package by.epam.agency.validator;

import by.epam.agency.exception.ValidatorException;
import by.epam.agency.util.Messages;

public class PositiveIntValidator extends Validator {
    private int number;

    public PositiveIntValidator(int number) {
        this.number = number;
    }

    @Override
    public void validate() throws ValidatorException {
        if (number <= 0) {
            throw new ValidatorException(Messages.NOT_POSITIVE_NUMBER_MESSAGE);
        }
        if (hasNext()) {
            next.validate();
        }
    }
}
