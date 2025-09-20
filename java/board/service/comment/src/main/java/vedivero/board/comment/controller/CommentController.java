package vedivero.board.comment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vedivero.board.comment.service.CommentService;
import vedivero.board.comment.service.request.CommentCreateRequest;
import vedivero.board.comment.service.request.CommentResponse;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private CommentService commentService;

    @GetMapping("/v1/comments/{commentId}")
    public CommentResponse read(
            @PathVariable("commentId") Long commentId
    ) {
        return commentService.read(commentId);
    }

    @PostMapping("/v1/comments")
    public CommentResponse create(@RequestBody CommentCreateRequest request) {
        return commentService.create(request);
    }

    @DeleteMapping("/v1/comments/{commentId}")
    public void delete(
            @PathVariable("commentId") Long commentId
    ) {
        commentService.delete(commentId);
    }
}
