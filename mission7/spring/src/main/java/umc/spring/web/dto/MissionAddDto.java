package umc.spring.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import umc.spring.domain.Store;

import java.time.LocalDateTime;

@Data
public class MissionAddDto {
    private Long storeId;
    private Integer reward;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime deadline;
    private String missionSpec;
}
