package de.imnoo.properties;

public class UserProperties extends AbstractProperties {

    public static final String USER_PROPERTIES = "user.properties";

    public UserProperties() {
        super(USER_PROPERTIES);
    }

    public String getUserLogin() {
        return getProperty("user.login");
    }

    public String getUserPassword() {
        return getProperty("user.password");
    }
}
