package vedivero.board.comment.data;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.support.TransactionTemplate;
import vedivero.board.comment.entity.Comment;
import vedivero.board.common.snowflake.Snowflake;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest
public class DataInitializer {
    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    TransactionTemplate transactionTemplate;

    //게시글 삽입 목적
    Snowflake snowflake = new Snowflake();
    CountDownLatch latch = new CountDownLatch(EXCUTE_COUNT);

    static final int BULK_INSERT_SIZE = 2_000;
    static final int EXCUTE_COUNT = 6_000;

    //멀티쓰레드로 수행
    @Test
    void initialize() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < EXCUTE_COUNT; i++) {
            executorService.submit(() -> {
                insert();
                latch.countDown();
                System.out.println("latch.getCount() = " + latch.getCount());
            });
        }
        latch.await();
        executorService.shutdown();
    }

    //트랜잭션 템플릿으로 데이터 삽입
    void insert() {
        transactionTemplate.executeWithoutResult(status -> {

            Comment prev = null;

            for (int i = 0; i < BULK_INSERT_SIZE; i++) {

                Comment comment = Comment.create(
                        snowflake.nextId(),
                        "content",
                        i % 2 == 0 ? null : prev.getCommentId(),    // 홀수 = 이전 댓글을 상위 댓글로 지정(절반은 2 depth로 데이터 입력)
                        1L,
                        1L
                );
                prev = comment;
                entityManager.persist(comment);
            }
        });
    }
}
