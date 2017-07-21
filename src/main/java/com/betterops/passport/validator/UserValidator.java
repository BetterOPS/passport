package com.betterops.passport.validator;

import com.betterops.passport.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by leoliu on 2017/7/21.
 */

@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors err) {
       ValidationUtils.rejectIfEmptyOrWhitespace(err, "firstName", "invalid firstName");
       ValidationUtils.rejectIfEmptyOrWhitespace(err, "lastName", "invalid lastName");
    }
}
