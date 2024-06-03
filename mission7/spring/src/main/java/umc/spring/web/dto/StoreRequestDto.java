package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class StoreRequestDto {

    @Getter
    public static class ReviewDto {
        @NotBlank
        String title;
        @NotNull
        Double score;
        @NotBlank
        String body;
    }
}
