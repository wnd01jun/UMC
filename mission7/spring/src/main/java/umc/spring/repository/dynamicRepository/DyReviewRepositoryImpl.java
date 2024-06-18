package umc.spring.repository.dynamicRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import umc.spring.domain.QReview;
import umc.spring.domain.Review;

import java.util.Optional;

import static umc.spring.domain.QReview.*;

public class DyReviewRepositoryImpl implements DyReviewRepository{
    private final JPAQueryFactory queryFactory;

    public DyReviewRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Optional<Review> findWithMemberStore(Long memberId, Long storeId) {
        return Optional.ofNullable(
                queryFactory.selectFrom(review)
                        .where(review.member.id.eq(memberId),
                                review.store.id.eq(storeId))
                        .fetchOne()
        );
    }
}
