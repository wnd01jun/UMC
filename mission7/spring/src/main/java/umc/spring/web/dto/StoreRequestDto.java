package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class StoreRequestDto {

    @Getter
    @Setter
    public static class ReviewDto {
        @NotBlank
        String title;
        @NotNull
        Double score;
        @NotBlank
        String body;

        @NotNull
        Long storeId;

        @NotNull
        Long memberId;
    }
}
