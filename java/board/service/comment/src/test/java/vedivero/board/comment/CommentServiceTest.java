package vedivero.board.comment;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import vedivero.board.comment.entity.Comment;
import vedivero.board.comment.repository.CommentRepository;
import vedivero.board.comment.service.CommentService;

import java.util.Optional;

import static org.mockito.BDDMockito.given;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CommentServiceTest {

    @InjectMocks
    CommentService commentService;

    @Mock
    CommentRepository commentRepository; // Mocking Object <- CommentRepository

    @Test
    @DisplayName("삭제할 댓글의 하위 댓글이 존재하면, 해당 댓글은 삭제 표시만 한다.")
    void deleteShouldMarkDeletedIfHasChildren() {
        Long articleId = 1L;
        Long commentId = 2L;
        Comment comment = createComment(articleId, commentId);
        // commentId를 조회한 결과가, comment라는 Mocking 객체일 때,
        given(commentRepository.findById(commentId))
                .willReturn(Optional.of(comment));
        
        // 결과가 2면, 하위 댓글이 존재
        given(commentRepository.countBy(articleId, commentId, 2L)).willReturn(2L);

        commentService.delete(commentId);

        verify(comment).delete();
    }


    @Test
    @DisplayName("하위 댓글 삭제 후, 부모는 삭제되지 않은 댓글이라면, 하위 댓글만 삭제")
    void deleteShouldDeleteChildOnlyIfNotDeletedParent() {
        Long articleId = 1L;
        Long commentId = 2L;
        Long parentCommentId = 1L;

        Comment comment = createComment(articleId, commentId, parentCommentId);
        // 하위 댓글이기 때문에 isRoot == false
        given(comment.isRoot()).willReturn(false);

        // 아직 삭제되지 않은 상위 댓글
        Comment parentComment = mock(Comment.class);
        given(parentComment.getDeleted()).willReturn(false);

        given(commentRepository.findById(commentId))
                .willReturn(Optional.of(comment));
        
        // 하위 댓글이 없기 때문에 1을 반환 -> hadChilren에서 false를 반환
        given(commentRepository.countBy(articleId, commentId, 2L)).willReturn(1L);

        // parent가 검색될 때, parentCommentId가 반환
        // 삭제된 댓글이 root 댓글이 아니라면,
        // 상위 댓글을 삭제하기 위해서
        // 상위 댓글을 검사하는 로직을 수행 (commentRepository.findById(comment.getParentCommentId()))
        given(commentRepository.findById(parentCommentId))
                .willReturn(Optional.of(parentComment));

        // when
        commentService.delete(commentId);

        // then
        // 하위 댓글 삭제
        verify(commentRepository).delete(comment);

        // 상위 댓글은 삭제된 내역이 없기 때문에 delete가 호출되지 않음
        // never를 사용하면 호출되지 않았다는 것을 검증
        verify(commentRepository, never()).delete(parentComment);
    }

    @Test
    @DisplayName("하위 댓글 삭제 후, 부모 댓글도 삭제된 댓글이라면, 재귀적으로 모두 삭제")
    void deleteShouldDeleteAllRecursivelyIfDeleteParent() {
        Long articleId = 1L;
        Long commentId = 2L;
        Long parentCommentId = 1L;

        Comment comment = createComment(articleId, commentId, parentCommentId);
        given(comment.isRoot()).willReturn(false);

        Comment parentComment = createComment(articleId, parentCommentId);
        given(parentComment.isRoot()).willReturn(true);
        given(parentComment.getDeleted()).willReturn(true);

        given(commentRepository.findById(commentId))
                .willReturn(Optional.of(comment));

        given(commentRepository.countBy(articleId, commentId, 2L)).willReturn(1L);

        given(commentRepository.findById(parentCommentId))
                .willReturn(Optional.of(parentComment));

        given(commentRepository.countBy(articleId, parentCommentId, 2L)).willReturn(1L);

        // when
        commentService.delete(commentId);

        // then
        verify(commentRepository).delete(comment);
        verify(commentRepository).delete(parentComment);
    }

    private Comment createComment(Long articleId, Long commentId) {
        Comment comment = mock(Comment.class);
        // 전달받은 파라미터를 모킹 객체에 대입
        given(comment.getArticleId()).willReturn(articleId);
        given(comment.getCommentId()).willReturn(commentId);
        return comment;
    }

    private Comment createComment(Long articleId, Long commentId, Long parentCommentId) {

        Comment comment = createComment(articleId, commentId);
        given(comment.getParentCommentId()).willReturn(parentCommentId);
        return comment;
    }
}