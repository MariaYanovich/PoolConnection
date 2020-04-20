package by.epam.agency.validator;


import by.epam.agency.exception.ValidatorException;
import by.epam.agency.validator.constants.ValidatorRegex;
import com.mysql.cj.util.StringUtils;

import java.util.regex.Pattern;

public class LoginValidator extends Validator {
    private String login;

    public LoginValidator(String login) {
        this.login = login;
        pattern = Pattern.compile(ValidatorRegex.LOGIN);
        matcher = pattern.matcher(login);
    }

    @Override
    public void validate() throws ValidatorException {
        if (login == null || login.isEmpty() || !matcher.find()) {
            throw new ValidatorException();
        }

        if (hasNext()) {
            next.validate();
        }
    }
}
