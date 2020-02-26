package se.telenor.springbootdemo.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.bind.annotation.ExceptionHandler;
import se.telenor.springbootdemo.exception.IdNotNegativeException;
import se.telenor.springbootdemo.exception.PathIsNotYetImplementedException;
import se.telenor.springbootdemo.model.Account;
import se.telenor.springbootdemo.model.Path;
import se.telenor.springbootdemo.model.Type;
import se.telenor.springbootdemo.testBuilder.PathTestBuilder;

public class GreetingServiceTest {

    GreetingService greetingService = new GreetingServiceImpl();

    @Test
    public void shouldHandelNull() {
        String message = greetingService.getMessage(null);
        Assert.assertNull(message);
    }

    @Test(expected = IdNotNegativeException.class)
    public void shouldHandelNegativeId() {
        Path path = PathTestBuilder.builder().withId(-100).withAccountBuilder(Account.BUSINESS).build();
        greetingService.getMessage(path);
    }

 @Test(expected = PathIsNotYetImplementedException.class)
    public void shouldHandelPathIsNotYetImplemented() {
        Path path = PathTestBuilder.builder().withType(Type.SMALL).withAccountBuilder(Account.BUSINESS).build();
        greetingService.getMessage(path);
    }


}
