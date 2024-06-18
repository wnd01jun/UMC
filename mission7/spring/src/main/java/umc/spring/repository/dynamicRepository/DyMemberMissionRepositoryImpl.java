package umc.spring.repository.dynamicRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.domain.mapping.QMemberMission;

import java.util.Optional;

import static umc.spring.domain.mapping.QMemberMission.*;

public class DyMemberMissionRepositoryImpl implements DyMemberMissionRepository{
    private final JPAQueryFactory queryFactory;

    public DyMemberMissionRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Optional<MemberMission> findWithMemberMissionId(Long memberId, Long missionId) {
        return Optional.ofNullable(queryFactory.selectFrom(memberMission)
                .where(memberMission.member.id.eq(memberId),
                        memberMission.mission.id.eq(missionId))
                .fetchOne());
    }
}
