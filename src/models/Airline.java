package models;

public class Airline {
    private final String code;
    private final String name;

    public Airline(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
