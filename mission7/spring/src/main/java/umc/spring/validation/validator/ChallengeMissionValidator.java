package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.validation.annotation.ChallengeMission;
import umc.spring.web.dto.MemberAcceptMissionDto;

import java.util.Optional;


@RequiredArgsConstructor
public class ChallengeMissionValidator implements ConstraintValidator<ChallengeMission, MemberAcceptMissionDto> {
    private final MemberMissionRepository memberMissionRepository;
    public boolean isValid(Long value, ConstraintValidatorContext constraintValidatorContext) {
        Optional<MemberMission> memberMission = memberMissionRepository.findById(value);
        if(memberMission.isEmpty()){
            return true;
        }
        constraintValidatorContext.disableDefaultConstraintViolation();
        constraintValidatorContext.buildConstraintViolationWithTemplate(ErrorStatus.MEMBER_NOT_FOUND.toString()).addConstraintViolation();
        return false;


    }

    @Override
    public boolean isValid(MemberAcceptMissionDto memberAcceptMissionDto, ConstraintValidatorContext constraintValidatorContext) {
        Optional<MemberMission> memberMission = memberMissionRepository.findWithMemberMissionId(
                memberAcceptMissionDto.getMemberId(), memberAcceptMissionDto.getMissionId());
        if(memberMission.isEmpty()){
            return true;
        }
        constraintValidatorContext.disableDefaultConstraintViolation();
        constraintValidatorContext.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_ALREADY_ACCEPT.toString()).addConstraintViolation();
        return false;
    }

    @Override
    public void initialize(ChallengeMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}
