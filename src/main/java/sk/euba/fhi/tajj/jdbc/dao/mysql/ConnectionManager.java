package sk.euba.fhi.tajj.jdbc.dao.mysql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Igor Banduric.
 */
public class ConnectionManager {

	private static final Logger logger = LoggerFactory.getLogger( ConnectionManager.class );

	public Connection createConnection() {
		try {
			Class.forName( "com.mysql.jdbc.Driver" );
		} catch (ClassNotFoundException e) {
			logger.error( "Where is your MySQL JDBC Driver?" );
		}
		logger.info( "MySQL JDBC Driver Registered!" );
		Connection connection = null;
		try {
			connection = DriverManager.getConnection( "jdbc:mysql://35.198.174.32:3306/JALC", "jalc", "jalc" );
		} catch (SQLException e) {
			logger.error( "Connection Failed! Check output console", e );
		}
		return connection;
	}
}