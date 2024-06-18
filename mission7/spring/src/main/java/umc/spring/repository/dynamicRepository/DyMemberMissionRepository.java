package umc.spring.repository.dynamicRepository;

import umc.spring.domain.mapping.MemberMission;

import java.util.Optional;

public interface DyMemberMissionRepository {
    Optional<MemberMission> findWithMemberMissionId(Long memberId, Long missionId);
}
