package dataAccess;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

import connection.ConnectionFactory;
import model.Client;
import model.Product;

public class AccessClient {

	private final static String showStatementString = "SELECT * FROM client";
	private final static String insertStatementString = "INSERT INTO client(name,email,age,address)"
			+ "values(?,?,?,?)";
	private static String updateStatementString = "UPDATE client SET price = ? WHERE description= ?";
	private final static String deleteStatementString = "DELETE FROM client WHERE name=?";

	@SuppressWarnings("null")
	/**
	 * method which accesses the database and takes all the clients 
	 * creates the table with all the clients
	 * @param show table to show all clients
	 */
	public static void showClients(JTable show) {

		
        DefaultTableModel  tableModel = new DefaultTableModel();
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement showStatement = null;
		ResultSet rs = null;
//		String[] columnsNames= {"Name","Email","Age","Address"};
//		tableModel.setColumnIdentifiers(columnsNames);
//		tableModel.setRowCount(0);
		
		
		//String[] data=new String[5];
		
		try {
			showStatement = dbConnection.prepareStatement(showStatementString);
			rs = showStatement.executeQuery();
			rs.next();
			Client c=new Client(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5));
			 for(Field f:c.getClass().getDeclaredFields())
				tableModel.addColumn( f.getName());
			    tableModel.addRow(new Object[] {rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5)});
			while (rs.next()) {
				tableModel.addRow(new Object[] {rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5)});
//                data[1]=rs.getString(2);
//                data[2]=rs.getString(3);
//                data[3]=Integer.toString(rs.getInt(4));
//                data[4]=rs.getString(5);
//               tableModel.addRow(data);
				//System.out.println( data[0]+ " " + rs.getString(3) + " " + rs.getInt(4) + " " + rs.getInt(5));
			}
			show.setModel(tableModel);
			show.setVisible(true);
			
			// ConnectionFactory.close(dbConnection);
			ConnectionFactory.close(showStatement);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * method used to access the database and insert a client
	 * @param c client to be inserted
	 */
	public static void insertClient(Client c) {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement insertStatement = null;
		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString);
			insertStatement.setString(1, c.getName());
			insertStatement.setString(2, c.getEmail());
			insertStatement.setInt(3, c.getAge());
			insertStatement.setString(4, c.getAddress());

			insertStatement.execute();
			// ConnectionFactory.close(dbConnection);
			ConnectionFactory.close(insertStatement);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * method used to access the database and update a client
	 * @param c client to be updated
	 * @param field field of the client to be updated
	 */
	public static void updateClient(Client c, String field) {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement updateStatement = null;
		try {
			if (field.equals("age"))
				updateStatementString = "UPDATE client SET age = ? WHERE name= ?";
			if (field.equals("address"))
				updateStatementString = "UPDATE client SET address = ? WHERE name= ?";
			if (field.equals("email"))
				updateStatementString = "UPDATE client SET email = ? WHERE name= ?";

			updateStatement = dbConnection.prepareStatement(updateStatementString);
			if (field.equals("age"))
				updateStatement.setInt(1, c.getAge());
			if (field.equals("address"))
				updateStatement.setString(1, c.getAddress());
			if (field.equals("email"))
				updateStatement.setString(1, c.getEmail());
			// System.out.println(field + " " + p.getPrice());

			updateStatement.setString(2, c.getName());

			updateStatement.execute();

			// ConnectionFactory.close(dbConnection);
			ConnectionFactory.close(updateStatement);
		} catch (Exception e) {
			System.out.println("Unavailable client");
		}

	}
    /**
     * method used to access a database and delete a client
     * @param name name of the client to be deleted
     */
	public static void deleteClient(String name) {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement deleteStatement = null;
		try {
			deleteStatement = dbConnection.prepareStatement(deleteStatementString);
			deleteStatement.setString(1, name);
			deleteStatement.execute();

			// ConnectionFactory.close(dbConnection);
			ConnectionFactory.close(deleteStatement);
		} catch (Exception e) {
			System.out.println("Product not available");
		}
	}
}
