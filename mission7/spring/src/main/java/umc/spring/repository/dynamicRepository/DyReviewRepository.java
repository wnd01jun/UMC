package umc.spring.repository.dynamicRepository;

import umc.spring.domain.Review;

import java.util.Optional;

public interface DyReviewRepository {
    Optional<Review> findWithMemberStore(Long memberId, Long storeId);
}
