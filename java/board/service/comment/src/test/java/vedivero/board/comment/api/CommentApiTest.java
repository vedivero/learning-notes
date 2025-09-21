package vedivero.board.comment.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestClient;
import vedivero.board.comment.service.request.CommentResponse;

public class CommentApiTest {

    RestClient restClient = RestClient.create("http://localhost:9001");


    @Test
    void create() {
        CommentResponse response1 = createComment(new CommentCreateRequest(1L, "my comment1", null, 1L));
        CommentResponse response2 = createComment(new CommentCreateRequest(1L, "my comment2", response1.getCommentId(), 1L));
        CommentResponse response3 = createComment(new CommentCreateRequest(1L, "my comment3", response1.getCommentId(), 1L));

        System.out.println("commentId=%s".formatted(response1.getCommentId()));
        System.out.println("\tcommentId=%s".formatted(response2.getCommentId()));
        System.out.println("\tcommentId=%s".formatted(response3.getCommentId()));

        /*commentId=227978170003632128
            commentId=227978170695692288
            commentId=227978170779578368*/
    }

    @Test
    void read() {
        CommentResponse response = restClient.get()
                .uri("/v1/comments/{commentId}", 227978170003632128L)
                .retrieve()
                .body(CommentResponse.class);

        System.out.println("response = " + response);

    }

    @Test
    void delete() {
        restClient.delete()
                .uri("/v1/comments/{commentId}", 227978060111839232L)
                .retrieve()
                .toBodilessEntity();
    }
            /*commentId=227978170003632128
                commentId=227978170695692288
                commentId=227978170779578368*/

    CommentResponse createComment(CommentCreateRequest request) {
        return restClient.post()
                .uri("/v1/comments")
                .body(request)
                .retrieve()
                .body(CommentResponse.class);
    }

    @Getter
    @AllArgsConstructor
    public static class CommentCreateRequest{
        private Long articleId;
        private String content;
        private Long parentCommentId;
        private Long writerId;
    }

}
