package umc.spring.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.validation.validator.CategoriesExistValidator;
import umc.spring.validation.validator.ChallengeMissionValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ChallengeMissionValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ChallengeMission {
    String message() default "해당 미션이 수행중입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
