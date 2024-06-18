package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StoreAddDto {
    @NotNull
    private String name;
    @NotNull
    private String address;
    @NotNull
    private Long regionId;
}

