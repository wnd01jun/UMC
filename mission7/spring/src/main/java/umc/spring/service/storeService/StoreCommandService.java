package umc.spring.service.storeService;

import umc.spring.domain.Review;
import umc.spring.web.dto.StoreRequestDto;

public interface StoreCommandService {
    Review createReview(Long memberId, Long storeId, StoreRequestDto.ReviewDto request);
}
