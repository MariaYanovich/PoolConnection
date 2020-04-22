package by.epam.agency.validator;

import by.epam.agency.exception.ValidatorException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MoneyValidatorTest {
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    private double money;

    @Test
    public void validatorForNegative() throws ValidatorException {
        money = -1;
        action();
    }

    private void action() throws ValidatorException {
        exceptionRule.expect(ValidatorException.class);
        Validator validator = new MoneyValidator(money);
        validator.validate();
    }
}