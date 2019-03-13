package connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import com.mysql.jdbc.Connection;

public class ConnectionFactory {
	private static final Logger LOGGER = Logger.getLogger(ConnectionFactory.class.getName());
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/assignment3";
	private static final String USER = "root";
	private static final String PASS = "root";
	private static Connection connection = null;

	public ConnectionFactory() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// public ConnectionFactory() {
	//
	// }
	/**
	 * method which creates the connection with the database
	 */
	public static void createConnection() {
		try {
			connection = (Connection) DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/assignment3?autoReconnect=true&useSSL=false", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
		if (connection != null)
			System.out.println("Good");
		else
			System.out.println("Bad");
	}
    /**
     * method which returns the connection created before
     * @return Connection
     */
	public static Connection getConnection() {
		return connection;
	}
	/**
	 * method used to close a connection
	 * @param connection connection to be closed
	 */
	public static void close(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    /**
     * method used to close a statement
     * @param statement statement to be closed
     */
	public static void close(Statement statement) {
		try {
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * method used to close a result set
	 * @param rs result set to be closed
	 */
	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
