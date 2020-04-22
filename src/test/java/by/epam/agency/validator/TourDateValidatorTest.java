package by.epam.agency.validator;

import by.epam.agency.exception.ValidatorException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.sql.Date;

public class TourDateValidatorTest {
    private Date date;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void validatorForDateBefore() throws ValidatorException {
        date = Date.valueOf("2020-01-20");
        action();
    }

    private void action() throws ValidatorException {
        exceptionRule.expect(ValidatorException.class);
        Validator validator = new TourDateValidator(date);
        validator.validate();
    }
}