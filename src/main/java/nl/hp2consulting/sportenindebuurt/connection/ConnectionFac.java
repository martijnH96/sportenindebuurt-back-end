package nl.hp2consulting.sportenindebuurt.connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFac {
    private static final String PROPERTY_LOCATION = "/database.properties";

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        var properties = loadProperties();
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(properties.getProperty("db.url"),
                properties.getProperty("db.user"),
                properties.getProperty("db.password"));

    }
    private Properties loadProperties() {
        var properties = new Properties();
        try (
                var inputStream = this.getClass().getResourceAsStream(PROPERTY_LOCATION)
        ) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
