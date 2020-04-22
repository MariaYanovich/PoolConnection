package by.epam.agency.validator;

import by.epam.agency.exception.ValidatorException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PasswordValidatorTest {
    private String password;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void validatorForEmptyString() throws ValidatorException {
        password = "";
        action();
    }

    @Test
    public void validatorForNull() throws ValidatorException {
        password = null;
        action();
    }

    @Test
    public void validatorForSymbols() throws ValidatorException {
        password = "...,!.";
        action();
    }

    @Test
    public void validatorForRussianSymbols() throws ValidatorException {
        password = "helloпривет23N";
        action();
    }

    @Test
    public void validatorForStringWithoutNumbers() throws ValidatorException {
        password = "helloeee";
        action();
    }

    @Test
    public void validatorForStringWithoutLetters() throws ValidatorException {
        password = "135156245";
        action();
    }

    @Test
    public void validatorForStringWithLessThanSixSymbols() throws ValidatorException {
        password = "hell1";
        action();
    }

    private void action() throws ValidatorException {
        exceptionRule.expect(ValidatorException.class);
        Validator validator = new PasswordValidator(password);
        validator.validate();
    }
}