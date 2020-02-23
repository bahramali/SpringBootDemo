package se.telenor.springbootdemo.unit;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import se.telenor.springbootdemo.exception.WrongTypeException;
import se.telenor.springbootdemo.model.Account;
import se.telenor.springbootdemo.model.Path;
import se.telenor.springbootdemo.model.Type;
import se.telenor.springbootdemo.testBuilder.PathTestBuilder;

@SpringBootTest
public class ModelTests {

    @Test
    void shouldReturnExceptionIfNullOrNegative() {
        Assertions.assertThrows(NullPointerException.class, () -> Path.builder().withId(123).build());
        Assertions.assertThrows(NullPointerException.class, () -> Path.builder().withType(Type.SMALL).build());
        Assertions.assertThrows(NullPointerException.class, () -> Path.builder().withId(123).withType(Type.SMALL).build());
        Assertions.assertThrows(NullPointerException.class, () -> Path.builder().build());
    }

    @Test
    void testBuilderIsNotNull() {
        Assert.assertNotNull(PathTestBuilder.builder().build());
    }

    @Test
    void shouldGetNewValueForAccountTestBuilder() {
        Path path = PathTestBuilder.builder().build();
        Assert.assertEquals(Account.PERSONAL, path.getAccount());
        Assert.assertEquals(123, path.getId().intValue());

        Path path2 = PathTestBuilder.builder()
                .withAccountBuilder(Account.BUSINESS)
                .withId(4321)
                .withType(Type.BIG)
                .build();
        Assert.assertEquals(Account.BUSINESS, path2.getAccount());
        Assert.assertEquals(4321, path2.getId().intValue());
        Assert.assertEquals(Type.BIG, path2.getType());
    }

    @Test
    void shouldReturnExceptionForUndefinedEnumForAccount() {
        Assertions.assertThrows(WrongTypeException.class, () -> Account.fromExternalValue("Animal"));
    }

}
