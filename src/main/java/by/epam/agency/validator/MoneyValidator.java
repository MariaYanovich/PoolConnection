package by.epam.agency.validator;

import by.epam.agency.exception.ValidatorException;
import by.epam.agency.util.Message;

public class MoneyValidator extends Validator {
    private double money;

    public MoneyValidator(double money) {
        this.money = money;
    }

    @Override
    public void validate() throws ValidatorException {
        if (money < 0) {
            throw new ValidatorException(Message.NEGATIVE_MONEY);
        }
        if (hasNext()) {
            next.validate();
        }
    }
}
