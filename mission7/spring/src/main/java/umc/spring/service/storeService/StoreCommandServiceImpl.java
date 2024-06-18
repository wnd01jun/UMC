package umc.spring.service.storeService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.*;
import umc.spring.repository.*;
import umc.spring.web.dto.MissionAddDto;
import umc.spring.web.dto.StoreAddDto;
import umc.spring.web.dto.StoreRequestDto;

import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements  StoreCommandService{

    private final ReviewRepository reviewRepository;

    private final MemberRepository memberRepository;

    private final StoreRepository storeRepository;

    private final RegionRepository regionRepository;
    private final MissionRepository missionRepository;
    @Override
    public Review createReview(StoreRequestDto.ReviewDto request) {

        Review review = StoreConverter.toReview(request);

        review.setMember(memberRepository.findById(request.getMemberId()).get());
        review.setStore(storeRepository.findById(request.getStoreId()).get());

        return reviewRepository.save(review);
    }

    @Override
    public Long createStore(StoreAddDto dto) {
        Region region = regionRepository.findById(dto.getRegionId()).orElseThrow(() -> new NoSuchElementException());
        Store store = StoreConverter.toStore(dto, region);
        storeRepository.save(store);
        return store.getId();
    }

    @Override
    public Long createMission(MissionAddDto dto) {
        Store store = storeRepository.findById(dto.getStoreId()).orElseThrow(() -> new NoSuchElementException());
        Mission mission = StoreConverter.toMission(dto, store);
        missionRepository.save(mission);
        return mission.getId();
    }
}
