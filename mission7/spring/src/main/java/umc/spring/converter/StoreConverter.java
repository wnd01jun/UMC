package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.domain.Region;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.MissionAddDto;
import umc.spring.web.dto.StoreAddDto;
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

    public static Mission toMission(MissionAddDto dto, Store store){
        return Mission.builder()
                .deadline(dto.getDeadline())
                .reward(dto.getReward())
                .missionSpec(dto.getMissionSpec())
                .store(store)
                .build();
    }

    public static Store toStore(StoreAddDto dto, Region region){
        return Store.builder()
                .address(dto.getAddress())
                .name(dto.getName())
                .region(region)
                .build();
    }
}
