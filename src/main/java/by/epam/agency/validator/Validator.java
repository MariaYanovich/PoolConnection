package by.epam.agency.validator;

import by.epam.agency.exception.ValidatorException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Validator {
    protected Validator next;
    protected Pattern pattern;
    protected Matcher matcher;

    public void setNext(Validator validator) {
        this.next = validator;
    }

    public boolean hasNext() {
        return next != null;
    }

    public abstract void validate() throws ValidatorException;
}
