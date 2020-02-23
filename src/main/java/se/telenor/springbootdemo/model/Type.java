package se.telenor.springbootdemo.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.telenor.springbootdemo.exception.WrongTypeException;

public enum Type {
    BIG,
    SMALL;

    static final Logger LOGGER = LoggerFactory.getLogger(Type.class);

    public static Type fromExternalValue(String value) {
        LOGGER.info("Type value from user '{}'", value);
        if (value != null) {
            switch (value.toUpperCase()) {
                case "BIG":
                    return BIG;
                case "SMALL":
                    return SMALL;
                default:
                    LOGGER.warn("'{}' is not identified ", value);
                    throw new WrongTypeException(value +" for Type is not defined");
            }
        }
        LOGGER.info("Noting from external value to map");
        return null;
    }
}
