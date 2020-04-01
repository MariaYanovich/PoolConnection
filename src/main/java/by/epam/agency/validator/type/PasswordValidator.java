package by.epam.agency.validator.type;

import by.epam.agency.constants.ValidatorRegex;
import by.epam.agency.exception.ValidatorException;
import by.epam.agency.validator.Validator;

import java.util.regex.Pattern;

public class PasswordValidator extends Validator {

    private String password;

    public PasswordValidator(String password) {
        this.password = password;
        pattern = Pattern.compile(ValidatorRegex.PASSWORD);
        matcher = pattern.matcher(password);
    }

    @Override
    public void validate() throws ValidatorException {
        if (password == null || password.isEmpty() || !matcher.find()) {
            throw new ValidatorException();
        }
        if (hasNext()) {
            next.validate();
        }
    }
}
