package by.epam.agency.validator.type;

import by.epam.agency.exception.ValidatorException;
import by.epam.agency.validator.Validator;

public class CashValidator extends Validator {
    private float cash;

    public CashValidator(float cash) {
        this.cash = cash;
    }

    @Override
    public void validate() throws ValidatorException {
        if (cash == 0) {
            throw new ValidatorException();
        }
        if (hasNext()) {
            next.validate();
        }
    }
}
