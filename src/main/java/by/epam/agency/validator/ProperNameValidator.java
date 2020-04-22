package by.epam.agency.validator;

import by.epam.agency.exception.ValidatorException;
import by.epam.agency.util.Messages;
import by.epam.agency.validator.constants.ValidatorRegex;
import com.mysql.cj.util.StringUtils;

import java.util.regex.Pattern;

public class ProperNameValidator extends Validator {
    String properName;

    public ProperNameValidator(String properName) {
        this.properName = properName;
    }

    @Override
    public void validate() throws ValidatorException {
        try {
            pattern = Pattern.compile(ValidatorRegex.PROPER_NAME);
            matcher = pattern.matcher(properName);
        } catch (NullPointerException e) {
            throw new ValidatorException(Messages.NULL_PROPER_NAME_MESSAGE, e);
        }
        if (StringUtils.isNullOrEmpty(properName) || !matcher.find()) {
            throw new ValidatorException(Messages.INCORRECT_PROPER_NAME_MESSAGE);
        }
        if (hasNext()) {
            next.validate();
        }
    }
}
