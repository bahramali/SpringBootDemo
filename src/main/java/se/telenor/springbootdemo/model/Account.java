package se.telenor.springbootdemo.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.telenor.springbootdemo.exception.WrongTypeException;

public enum Account {
    PERSONAL,
    BUSINESS;

    static final Logger LOGGER = LoggerFactory.getLogger(Account.class);

    public static Account fromExternalValue(String value) {
        LOGGER.info("Account type value from user is '{}'", value);
        if (value != null) {
            switch (value.toUpperCase()) {
                case "PERSONAL":
                    return PERSONAL;
                case "BUSINESS":
                    return BUSINESS;
                default:
                    LOGGER.warn("Account type is not identified '{}'", value);
                    throw new WrongTypeException(value +" for Account is not defined");
            }
        }
        LOGGER.info("No Account type from external value to map");
        return null;
    }
}
