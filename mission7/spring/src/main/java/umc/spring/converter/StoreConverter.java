package umc.spring.converter;

import umc.spring.domain.Review;
import umc.spring.web.dto.StoreRequestDto;
import umc.spring.web.dto.StoreResponseDto;

import java.time.LocalDateTime;

public class StoreConverter {

    public static Review toReview(StoreRequestDto.ReviewDto request){
        return Review.builder()
                .title(request.getTitle())
                .score(request.getScore())
                .body(request.getBody())
                .build();
    }

    public static StoreResponseDto.CreateReviewResultDTO toCreateReviewResultDTO(Review review){
        return StoreResponseDto.CreateReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
