package dataAccess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

import connection.ConnectionFactory;
import model.Product;

public class AccessStudent {

	private final static String showStatementString = "SELECT * FROM product";
	private final static String insertStatementString = "INSERT INTO product(description,size,price,quantity)"
			+ "values(?,?,?,?)";
	private static String updateStatementString = "UPDATE product SET price = ? WHERE description= ?";
	private final static String deleteStatementString = "DELETE FROM product WHERE description=? and size=?";

	@SuppressWarnings("null")
	/**
	 * method  used to access the database and takes all data and shows it into a table
	 * @param show table where data is shown
	 * @return
	 */
	public static Product showProducts(JTable show) {

		Product toReturn = new Product();
        DefaultTableModel  tableModel = (DefaultTableModel) show.getModel();
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement showStatement = null;
		ResultSet rs = null;
		String[] columnsNames= {"Description","Size","Price","Quantity"};
		tableModel.setColumnIdentifiers(columnsNames);
		tableModel.setRowCount(0);
		String[] data=new String[4];
		
		try {
			showStatement = dbConnection.prepareStatement(showStatementString);
			rs = showStatement.executeQuery();
			while (rs.next()) {
                data[0]=rs.getString(2);
                data[1]=rs.getString(3);
                data[2]=Integer.toString(rs.getInt(4));
                data[3]=Integer.toString(rs.getInt(5));
               tableModel.addRow(data);
				System.out.println( data[0]+ " " + rs.getString(3) + " " + rs.getInt(4) + " " + rs.getInt(5));
			}
			show.setModel(tableModel);
			show.setVisible(true);
			
			// ConnectionFactory.close(dbConnection);
			ConnectionFactory.close(showStatement);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return toReturn;
	}
	/**
	 * method used to access a database and inserts a product
	 * @param p product to be inserted
	 */
	public static void insertProduct(Product p) {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement insertStatement = null;
		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString);
			insertStatement.setString(1, p.getDescription());
			insertStatement.setString(2, p.getSize());
			insertStatement.setInt(3, p.getPrice());
			insertStatement.setInt(4, p.getQuantity());

			insertStatement.execute();
			// ConnectionFactory.close(dbConnection);
			ConnectionFactory.close(insertStatement);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * method used to access the database and to update a product
	 * @param p product to be updated
	 * @param field from product to be updated
	 */
	public static void updateProduct(Product p, String field) {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement updateStatement = null;
		try {
			if (field.equals("price"))
				updateStatementString = "UPDATE product SET price = ? WHERE description= ?";
			if (field.equals("size"))
				updateStatementString = "UPDATE product SET size = ? WHERE description= ?";
			if (field.equals("quantity"))
				updateStatementString = "UPDATE product SET quantity = ? WHERE description= ?";

			updateStatement = dbConnection.prepareStatement(updateStatementString);
			if (field.equals("price"))
				updateStatement.setInt(1, p.getPrice());
			if (field.equals("size"))
				updateStatement.setString(1, p.getSize());
			if (field.equals("quantity"))
				updateStatement.setInt(1, p.getQuantity());
			// System.out.println(field + " " + p.getPrice());

			updateStatement.setString(2, p.getDescription());

			updateStatement.execute();

			// ConnectionFactory.close(dbConnection);
			ConnectionFactory.close(updateStatement);
		} catch (Exception e) {
			System.out.println("Unavailable product");
		}

	}

	/**
	 * method used to access the database and delete a product
	 * @param description which product
	 * @param size size of product to be deleted
	 */
	public static void deleteProduct(String description, String size) {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement deleteStatement = null;
		try {
			deleteStatement = dbConnection.prepareStatement(deleteStatementString);
			deleteStatement.setString(1, description);
			deleteStatement.setString(2, size);
			deleteStatement.execute();

			// ConnectionFactory.close(dbConnection);
			ConnectionFactory.close(deleteStatement);
		} catch (Exception e) {
			System.out.println("Product not available");
		}
	}
}
