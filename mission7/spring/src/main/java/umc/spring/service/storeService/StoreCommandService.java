package umc.spring.service.storeService;

import umc.spring.domain.Review;
import umc.spring.web.dto.MissionAddDto;
import umc.spring.web.dto.StoreAddDto;
import umc.spring.web.dto.StoreRequestDto;

public interface StoreCommandService {
    Review createReview(StoreRequestDto.ReviewDto request);
    Long createStore(StoreAddDto dto);

    Long createMission(MissionAddDto dto);
}
