package se.telenor.springbootdemo.testBuilder;

import se.telenor.springbootdemo.model.Account;
import se.telenor.springbootdemo.model.Path;
import se.telenor.springbootdemo.model.Type;

public class PathTestBuilder {

    Path.Builder builder;

    private PathTestBuilder(Path.Builder builder) {
        this.builder = builder;
        this.builder
                .withAccount(Account.PERSONAL)
                .withId(123)
                .withType(Type.SMALL);
    }

    public static PathTestBuilder builder() {
        return new PathTestBuilder(Path.builder());
    }

    public PathTestBuilder withAccountBuilder(Account account) {
        builder.withAccount(account);
        return this;
    }

    public PathTestBuilder withId(Integer id) {
        builder.withId(id);
        return this;
    }

    public PathTestBuilder withType(Type type) {
        builder.withType(type);
        return this;
    }

    public Path build() {
        return this.builder.build();
    }
}