package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Review;
import umc.spring.service.storeService.StoreCommandService;
import umc.spring.validation.annotation.ExistMember;
import umc.spring.validation.annotation.ExistReview;
import umc.spring.validation.annotation.ExistStore;
import umc.spring.web.dto.MissionAddDto;
import umc.spring.web.dto.StoreAddDto;
import umc.spring.web.dto.StoreRequestDto;
import umc.spring.web.dto.StoreResponseDto;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {
    private final StoreCommandService storeCommandService;

    @PostMapping("/{storeId}/reviews")
    public ApiResponse<StoreResponseDto.CreateReviewResultDTO> createReview(@RequestBody @Valid @ExistReview StoreRequestDto.ReviewDto request){
        Review review = storeCommandService.createReview(request);
        return ApiResponse.onSuccess(StoreConverter.toCreateReviewResultDTO(review));
    }

    @PostMapping("/add")
    public Long addStore(@RequestBody @Valid StoreAddDto dto){
        Long store = storeCommandService.createStore(dto);
        return store;

    }

    @PostMapping("/add/mission")
    public Long addMission(@RequestBody @Valid MissionAddDto dto){
        Long mission = storeCommandService.createMission(dto);
        return mission;
    }

}
