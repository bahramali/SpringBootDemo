package se.telenor.springbootdemo.service;

import org.springframework.stereotype.Service;
import se.telenor.springbootdemo.exception.IdNotNegativeException;
import se.telenor.springbootdemo.exception.PathIsNotYetImplementedException;
import se.telenor.springbootdemo.model.Path;
import se.telenor.springbootdemo.model.Type;

@Service
public class GreetingServiceImpl implements GreetingService {
    @Override
    public String getMessage(Path path) {
        if(path == null) return null;

        if (path.getId() != null && path.getId() <= 0)
            throw new IdNotNegativeException("Id can not be negative");

        //personal/business + small --> error
        if (path.getType() != null && path.getType().equals(Type.SMALL)) {
            throw new PathIsNotYetImplementedException("The path is not yet implemented...");
        }

        //personal/business + id(+) -->"Hi, userId 123".
        //personal/business + big --> "Welcome, personal/business user!".
        return (path.getId() != null) ?
                "Hi, userId " + path.getId()
                : "Welcome, " + path.getAccount().name().toLowerCase() + " user!";

    }
}
