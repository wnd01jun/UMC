package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.dynamicRepository.DyMemberMissionRepository;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long>, DyMemberMissionRepository {
}
