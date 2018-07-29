package de.imnoo.properties;

public class EnvProperties extends AbstractProperties{

    public static final String ENV_PROPERTIES = "src/main/resources/env.properties";

    public EnvProperties() {
        super(ENV_PROPERTIES);
    }

    public String getBaseUrl () {
        return getProperty("base.url");
    }

    public String getAdminCustomersPageUrl() {
        return getBaseUrl() + getProperty("path.page.admin.customer");
    }
}
