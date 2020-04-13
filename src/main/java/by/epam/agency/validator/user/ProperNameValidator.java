package by.epam.agency.validator.user;

import by.epam.agency.exception.ValidatorException;
import by.epam.agency.validator.Validator;
import by.epam.agency.validator.constants.ValidatorRegex;

import java.util.regex.Pattern;

public class ProperNameValidator extends Validator {
    String properName;

    public ProperNameValidator(String properName) {
        this.properName = properName;
        pattern = Pattern.compile(ValidatorRegex.PROPER_NAME);
        matcher = pattern.matcher(properName);
    }

    @Override
    public void validate() throws ValidatorException {
        if (properName == null || properName.isEmpty() || !matcher.find()) {
            throw new ValidatorException();
        }
        if (hasNext()) {
            next.validate();
        }
    }
}