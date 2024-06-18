package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.ReviewRepository;
import umc.spring.repository.StoreRepository;
import umc.spring.validation.annotation.ExistReview;
import umc.spring.web.dto.StoreRequestDto;

import java.util.Optional;

/*
    member, store, review 존재여부 다 검사
 */
@RequiredArgsConstructor
public class ReviewExistValidator implements ConstraintValidator<ExistReview, StoreRequestDto.ReviewDto> {
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;
    @Override
    public boolean isValid(StoreRequestDto.ReviewDto reviewDto, ConstraintValidatorContext constraintValidatorContext) {
        Optional<Member> member = memberRepository.findById(reviewDto.getMemberId());
        Optional<Store> store = storeRepository.findById(reviewDto.getStoreId());
        if(member.isEmpty()){
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(ErrorStatus.MEMBER_NOT_FOUND.toString()).addConstraintViolation();
            return false;
        }
        if(store.isEmpty()){
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(ErrorStatus.STORE_NOT_FOUND.toString()).addConstraintViolation();
            return false;
        }
        Optional<Review> review = reviewRepository.findWithMemberStore(reviewDto.getMemberId(), reviewDto.getStoreId());
        if(review.isPresent()){
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(ErrorStatus.REVIEW_ALREADY_EXIST.toString()).addConstraintViolation();
            return false;
        }
        return true;
    }

    @Override
    public void initialize(ExistReview constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}
