package by.epam.agency.validator;

import by.epam.agency.exception.ValidatorException;
import by.epam.agency.util.Message;

public class PositiveIntValidator extends Validator {
    private int number;

    public PositiveIntValidator(int number) {
        this.number = number;
    }

    @Override
    public void validate() throws ValidatorException {
        if (number <= 0) {
            throw new ValidatorException(Message.NOT_POSITIVE_NUMBER);
        }
        if (hasNext()) {
            next.validate();
        }
    }
}
