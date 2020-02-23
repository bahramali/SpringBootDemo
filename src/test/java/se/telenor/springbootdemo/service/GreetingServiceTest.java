package se.telenor.springbootdemo.service;

import org.junit.Assert;
import org.junit.Test;

public class GreetingServiceTest {

    GreetingService greetingService = new GreetingServiceImpl();

    @Test
    public void shouldHandelNull(){
        String message = greetingService.getMessage(null);
        Assert.assertNull(message);
    }

}
