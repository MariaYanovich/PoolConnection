package by.epam.agency.validator;

import by.epam.agency.exception.ValidatorException;
import by.epam.agency.util.Messages;

public class MoneyValidator extends Validator {
    private double money;

    public MoneyValidator(double money) {
        this.money = money;
    }

    @Override
    public void validate() throws ValidatorException {
        if (money < 0) {
            throw new ValidatorException(Messages.NEGATIVE_MONEY_MESSAGE);
        }
        if (hasNext()) {
            next.validate();
        }
    }
}
