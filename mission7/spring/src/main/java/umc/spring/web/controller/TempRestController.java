package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.TempConverter;
import umc.spring.service.tempService.TempQueryService;
import umc.spring.web.dto.TempResponse;

@RestController
@RequestMapping("/temp")
@RequiredArgsConstructor
public class TempRestController {
    @Autowired
    private final TempQueryService tempQueryService;
    @GetMapping("/test")
    public ApiResponse<TempResponse.TempTestDto> testApi(){
        return ApiResponse.onSuccess(TempConverter.toTempTestDto());
    }

    @GetMapping("/exception")
    public ApiResponse<TempResponse.TempExceptionDto> exceptionAPI(@RequestParam("flag") Integer flag){
        tempQueryService.checkFlag(flag);
        return ApiResponse.onSuccess(TempConverter.toTempExceptionDto(flag));
    }
}
