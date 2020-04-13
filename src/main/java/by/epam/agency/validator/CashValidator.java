package by.epam.agency.validator;

import by.epam.agency.exception.ValidatorException;

public class CashValidator extends Validator {
    private float cash;

    public CashValidator(float cash) {
        this.cash = cash;
    }

    @Override
    public void validate() throws ValidatorException {
        if (cash < 0) {
            throw new ValidatorException();
        }
        if (hasNext()) {
            next.validate();
        }
    }
}
