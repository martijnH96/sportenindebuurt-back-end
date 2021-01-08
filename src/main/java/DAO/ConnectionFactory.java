package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	public Connection getConnection() throws sportenInDeBuurtPersistenceException {
		var properties = loadProperties();

		try {
			return DriverManager.getConnection(
					properties.getProperty("db.url"),
					properties.getProperty("db.user"),
					properties.getProperty("db.password")
			);
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			throw new sportenInDeBuurtPersistenceException(sqlException);
		}
	}

	private Properties loadProperties() throws sportenInDeBuurtPersistenceException {
		var properties = new Properties();
		var propertiesResource = this.getClass().getResourceAsStream("/Database.properties");

		try {
			properties.load(propertiesResource);
		} catch (IOException e) {
			e.printStackTrace();
			throw new sportenInDeBuurtPersistenceException("there was an error reading the databse properties");
		}
		return properties;
	}
}
