package by.epam.agency.validator;

import by.epam.agency.exception.ValidatorException;

import java.sql.Date;
import java.util.Calendar;

public class TourDateValidator extends Validator {
    private Date date;

    public TourDateValidator(Date date) {
        this.date = date;
    }

    @Override
    public void validate() throws ValidatorException {
        if (date.before(Calendar.getInstance().getTime())) {
            throw new ValidatorException();
        }
        if (hasNext()) {
            next.validate();
        }
    }
}
