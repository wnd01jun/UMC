package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MemberAcceptMissionDto {
    @NotNull
    private Long memberId;
    @NotNull
    private Long missionId;
}
