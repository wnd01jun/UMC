package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.domain.Member;
import umc.spring.repository.MemberRepository;
import umc.spring.validation.annotation.ExistMember;
import umc.spring.web.dto.MemberResponseDto;

import java.util.Optional;

@RequiredArgsConstructor
public class MemberExistValidator implements ConstraintValidator<ExistMember, Long> {
    private final MemberRepository memberRepository;
    @Override
    public boolean isValid(Long value, ConstraintValidatorContext constraintValidatorContext) {
        Optional<Member> member = memberRepository.findById(value);

        if(member.isEmpty()){
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(ErrorStatus.MEMBER_NOT_FOUND.toString()).addConstraintViolation();
            return false;
        }
        return true;
    }

    @Override
    public void initialize(ExistMember constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}
