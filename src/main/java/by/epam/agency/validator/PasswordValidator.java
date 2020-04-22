package by.epam.agency.validator;

import by.epam.agency.exception.ValidatorException;
import by.epam.agency.util.Messages;
import by.epam.agency.validator.constants.ValidatorRegex;
import com.mysql.cj.util.StringUtils;

import java.util.regex.Pattern;

/**
 * Password must contain at least one letter,
 * at least one number, and be longer than six characters.
 */

public class PasswordValidator extends Validator {
    private String password;

    public PasswordValidator(String password) {
        this.password = password;
    }

    @Override
    public void validate() throws ValidatorException {
        try {
            pattern = Pattern.compile(ValidatorRegex.PASSWORD);
            matcher = pattern.matcher(password);
        } catch (NullPointerException e) {
            throw new ValidatorException(Messages.NULL_PASSWORD_MESSAGE, e);
        }
        if (StringUtils.isNullOrEmpty(password) || !matcher.find()) {
            throw new ValidatorException(Messages.INCORRECT_PASSWORD_MESSAGE);
        }
        if (hasNext()) {
            next.validate();
        }
    }
}
