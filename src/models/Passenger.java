package models;

public abstract class User {
    protected final String userId;
    protected final String name;
    protected final String email;

    public User(String userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }
}
