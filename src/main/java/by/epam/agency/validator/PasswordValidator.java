package by.epam.agency.validator;

import by.epam.agency.exception.ValidatorException;
import by.epam.agency.util.Message;
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
            throw new ValidatorException(Message.NULL_PASSWORD, e);
        }
        if (StringUtils.isNullOrEmpty(password) || !matcher.find()) {
            throw new ValidatorException(Message.INCORRECT_PASSWORD);
        }
        if (hasNext()) {
            next.validate();
        }
    }
}
