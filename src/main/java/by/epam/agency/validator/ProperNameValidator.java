package by.epam.agency.validator;

import by.epam.agency.exception.ValidatorException;
import by.epam.agency.validator.constants.ValidatorRegex;
import com.mysql.cj.util.StringUtils;

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
        if (StringUtils.isNullOrEmpty(properName) || !matcher.find()) {
            throw new ValidatorException();
        }
        if (hasNext()) {
            next.validate();
        }
    }
}
