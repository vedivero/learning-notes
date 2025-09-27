package vedivero.board.comment.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;
import vedivero.board.comment.service.response.CommentResponse;
import vedivero.board.comment.service.response.CommentPageResponse;

import java.util.List;

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

    // 페이지 호출
    @Test
    void readAll() {
        CommentPageResponse response = restClient.get()
                .uri("/v1/comments?articleId=1&page=1&pageSize=10")
                .retrieve()
                .body(CommentPageResponse.class);

        System.out.println("response.getCommentCount() = " + response.getCommentCount());
        for (CommentResponse comment : response.getComments()) {
            // 2 depth comment
            if (!comment.getCommentId().equals(comment.getParentCommentId())) {
                System.out.print("\t");
            }

            System.out.println("comment.getCommentId() = " + comment.getCommentId());

        }
        /**
         * comment - 1번 페이지
         * response.getCommentCount() = 101
         * comment.getCommentId() = 228034514191482880
         * 	comment.getCommentId() = 228034514258591747
         * comment.getCommentId() = 228034514191482881
         * 	comment.getCommentId() = 228034514258591744
         * comment.getCommentId() = 228034514191482882
         * 	comment.getCommentId() = 228034514258591750
         * comment.getCommentId() = 228034514191482883
         * 	comment.getCommentId() = 228034514258591745
         * comment.getCommentId() = 228034514191482884
         * 	comment.getCommentId() = 228034514258591751
         * */
    }

    @Test
    void readAllInfiniteScroll() {
        List<CommentResponse> responses1 = restClient.get()
                .uri("/v1/comments/infinite-scroll?articleId=1&pageSize=5")
                .retrieve()
                .body(new ParameterizedTypeReference<List<CommentResponse>>() {
                });

        System.out.println("firstPage");
        for (CommentResponse comment : responses1) {
            if (!comment.getCommentId().equals(comment.getParentCommentId())) {
                System.out.print("\t");
            }
            System.out.println("comment.getCommentId() = " + comment.getCommentId());
        }

        Long lastParentCommentId = responses1.getLast().getParentCommentId();
        Long lastCommentId = responses1.getLast().getCommentId();

        List<CommentResponse> responses2 = restClient.get()
                .uri("/v1/comments/infinite-scroll?articleId=1&pageSize=5&lastParentCommentId=%s&lastCommentId=%s"
                        .formatted(lastParentCommentId, lastCommentId))
                .retrieve()
                .body(new ParameterizedTypeReference<List<CommentResponse>>() {
                });

        System.out.println("secondPage");
        for (CommentResponse comment : responses2) {
            if (!comment.getCommentId().equals(comment.getParentCommentId())) {
                System.out.print("\t");
            }
            System.out.println("comment.getCommentId() = " + comment.getCommentId());
        }
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
