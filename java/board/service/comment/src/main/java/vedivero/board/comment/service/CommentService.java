package vedivero.board.comment.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vedivero.board.comment.entity.Comment;
import vedivero.board.comment.repository.CommentRepository;
import vedivero.board.comment.service.request.CommentCreateRequest;
import vedivero.board.comment.service.request.CommentResponse;
import vedivero.board.common.snowflake.Snowflake;

import static java.util.function.Predicate.not;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final Snowflake snowflake = new Snowflake();


    @Transactional
    public CommentResponse create(CommentCreateRequest request) {
        Comment parent = findParent(request);
        Comment comment = commentRepository.save(
                Comment.create(
                        snowflake.nextId(),
                        request.getContent(),
                        parent == null ? null : parent.getCommentId(),
                        request.getArticleId(),
                        request.getWriterId()
                )
        );
        return CommentResponse.from(comment);
    }

    private Comment findParent(CommentCreateRequest request) {
        Long parentCommentId = request.getParentCommentId();
        if (parentCommentId == null) {
            return null;
        }
        return commentRepository.findById(parentCommentId)
                .filter(not(Comment::getDeleted))
                .filter(Comment::isRoot); //댓글 = 최대 2 depth이기 때문에 상위 댓글은 root여야 함.
                .orElseThrow();
    }

    public CommentResponse read(Long commentId) {
        return CommentResponse.from(
                commentRepository.findById(commentId).orElseThrow()
        );
    }

    @Transactional
    public void delete(Long commentId) {
        commentRepository.findById(commentId)
                .filter(not(Comment::getDeleted)) //삭제되지 않았음을 체크
                .ifPresent(comment -> {
                    if (hasChildren(comment)) {
                        comment.delete();
                    } else {
                        delete(comment);
                    }
                });
    }

    private boolean hasChildren(Comment comment) {
        // 하위 댓글이 존재하는지를 쿼리로 체크
        // root 댓글을 포함해서 하위 댓글이 존재하면 2개 (=많은 개수를 조회할 필요 없음)
        return commentRepository.countBy(comment.getArticleId(), comment.getCommentId(), 2L) == 2;
    }

    private void delete(Comment comment) {
        commentRepository.delete(comment);
        // root 댓글이 아닐 경우 (=상위 댓글 존재)
        if (!comment.isRoot()) {
            // 만약 상위 댓글이 삭제된 상태(deleted=true)면, 상위 댓글도 삭제처리
            commentRepository.findById(comment.getParentCommentId())
                    .filter(Comment::getDeleted) //삭제가 되어있는지 체크
                    .filter(not(this::hasChildren)) //하위 댓글을 가졌는지 체크, 그래야 재귀적으로 삭제
                    .ifPresent(this::delete); //상위 댓글 삭제
        }
    }
}
