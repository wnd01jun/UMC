package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import umc.spring.domain.Region;
import umc.spring.repository.RegionRepository;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/regions")
public class RegionController {
    private final RegionRepository regionRepository;

    @PostMapping("/add")
    public Long addRegion(@RequestBody String name){
        return regionRepository.save(Region.builder()
                .name(name)
                .build()).getId();
    }
}
