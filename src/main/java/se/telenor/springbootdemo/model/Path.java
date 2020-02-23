package se.telenor.springbootdemo.model;

import java.util.Objects;

public class Path{

    private Account account;
    private Integer id;
    private Type type;

    private Path() {
    }

    private Path(Builder builder) {
        account = Objects.requireNonNull(builder.account,"Account could not be null");
        id =  builder.id;
        type = builder.type;
    }

    public Account getAccount() {
        return account;
    }

    private void setAccount(Account account) {
        this.account = account;
    }

    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    private void setType(Type type) {
        this.type = type;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Account account;
        private Integer id;
        private Type type;

        private Builder() {
        }

        public Builder withAccount(Account account) {
            this.account = account;
            return this;
        }

        public Builder withId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder withType(Type type) {
            this.type = type;
            return this;
        }

        public Path build() {
            return new Path(this);
        }

    }
}
