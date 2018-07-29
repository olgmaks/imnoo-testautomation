package de.imnoo.properties;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;


public class AbstractProperties {

    private PropertiesConfiguration config;

    public AbstractProperties(final String fileName) {
        try {
            config = new FileBasedConfigurationBuilder<>(PropertiesConfiguration.class)
                    .configure(new Parameters().properties()
                            .setFileName(fileName)
                            .setIncludesAllowed(false)).getConfiguration();
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    protected <T> T getProperty(final String propertyName) {
        return (T)config.getProperty(propertyName);
    }
}
