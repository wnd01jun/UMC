package umc.spring.service.memberService;

import umc.spring.domain.Member;
import umc.spring.web.dto.MemberAcceptMissionDto;
import umc.spring.web.dto.MemberRequestDto;

public interface MemberCommandService {
    Member joinMember(MemberRequestDto.JoinDto request);

    Long acceptMission(MemberAcceptMissionDto dto);
}
