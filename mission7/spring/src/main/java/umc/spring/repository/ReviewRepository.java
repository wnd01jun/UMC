package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Review;
import umc.spring.repository.dynamicRepository.DyReviewRepository;

public interface ReviewRepository extends JpaRepository<Review, Long>, DyReviewRepository {
}
