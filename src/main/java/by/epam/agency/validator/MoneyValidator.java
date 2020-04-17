package by.epam.agency.validator;

import by.epam.agency.exception.ValidatorException;

public class MoneyValidator extends Validator {
    private float money;

    public MoneyValidator(float money) {
        this.money = money;
    }

    @Override
    public void validate() throws ValidatorException {
        if (money < 0) {
            throw new ValidatorException();
        }
        if (hasNext()) {
            next.validate();
        }
    }
}
