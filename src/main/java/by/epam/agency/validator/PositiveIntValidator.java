package by.epam.agency.validator;

import by.epam.agency.exception.ValidatorException;

public class PositiveIntValidator extends Validator {
    private int number;

    public PositiveIntValidator(int number) {
        this.number = number;
    }

    @Override
    public void validate() throws ValidatorException {
        if (number <= 0) {
            throw new ValidatorException();
        }
        if (hasNext()) {
            next.validate();
        }
    }
}
