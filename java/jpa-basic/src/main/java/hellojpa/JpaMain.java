package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class JpaMain {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try {
            // 비영속 상태 (아직 JPA와 관련 없는 상태/DB에 입력되지 않음)
            Member member = new Member();
            member.setId(100L);
            member.setName("Hello-JPA");

            // 영속 상태(영속성 컨텍스트에 의해 관리)
            entityManager.persist(member);

            // 엔티티를 영속성 컨텍스트에서 분리, 준영속 상태
            // entityManager.detach(member);

            // 트랜잭션 커밋하는 시점에서 DB에 쿼리가 실행
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.clear();
        }
        entityManagerFactory.close();
    }
}
