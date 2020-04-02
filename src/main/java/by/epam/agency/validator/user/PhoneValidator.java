package by.epam.agency.validator.user;

import by.epam.agency.exception.ValidatorException;
import by.epam.agency.validator.Validator;
import by.epam.agency.validator.constants.ValidatorRegex;

import java.util.regex.Pattern;

public class PhoneValidator extends Validator {

    public PhoneValidator(String phone) {
        pattern = Pattern.compile(ValidatorRegex.PHONE);
        matcher = pattern.matcher(phone);
    }

    @Override
    public void validate() throws ValidatorException {
        if (!matcher.find()) {
            throw new ValidatorException();
        }

        if (hasNext()) {
            next.validate();
        }
    }
}
