package dataAccess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import connection.ConnectionFactory;
import model.Client;
import model.Order;

public class AccessOrder {
	private final static String insertStatementString = "INSERT INTO comanda(idClient,idProduct,size,quantity,price,totalPrice) VALUES (?,?,?,?,?,?)";
	private final static String updateStatementString = "UPDATE product SET quantity = quantity - ? WHERE description= ? and size=?";
	private final static String showStatementStringClient = "SELECT * FROM client WHERE name=?";
	private final static String showStatementStringProduct = "SELECT * FROM product WHERE description=? and size=?";
	/**
	 * method used to access the database and insert an order
	 * @param o order to be inserted
	 * @param frame frame used to show error messages
	 * @return 1 if the order was  inserted
	 */
	
	public static int insertOrder(Order o,JFrame frame) {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement insertStatement = null;
		PreparedStatement pid = null;
		PreparedStatement cid = null;
		ResultSet rsp = null;
		ResultSet rsc = null;
		int price=0;
		int quantity=0;
		int x = 0, y = 0;
		int ok=1;
		try {
			// dbConnection.setAutoCommit(true);
			cid = dbConnection.prepareStatement(showStatementStringClient);
			cid.setString(1, o.getC_name());
			rsc = cid.executeQuery();
			rsc.next();
			x = rsc.getInt(1);
			ConnectionFactory.close(rsc);
			ConnectionFactory.close(cid);
			
			pid = dbConnection.prepareStatement(showStatementStringProduct);
			pid.setString(1, o.getP_name());
			pid.setString(2, o.getSize());
			rsp = pid.executeQuery();
			rsp.next();
			y = rsp.getInt(1);
			price=rsp.getInt(4);
			quantity=rsp.getInt(5);
			ConnectionFactory.close(rsc);
			ConnectionFactory.close(cid);
			System.out.println(x + " " + y);
			if(quantity<o.getQuantity()) {
				 ok=0;
                 JOptionPane.showMessageDialog(frame, "Not enough stock");
			}
			System.out.println(ok + " " + quantity+" "+o.getQuantity());
			o.setPrice(price);
			o.setTotal(price*o.getQuantity());
			if(ok==1) {
			 insertStatement = dbConnection.prepareStatement(insertStatementString);
			 insertStatement.setInt(1, x);
			 insertStatement.setInt(2, y);
			 insertStatement.setString(3, o.getSize());
			 insertStatement.setInt(4, o.getQuantity());
			 insertStatement.setInt(5, price);
			 insertStatement.setInt(6, o.getTotal());
			 
			 insertStatement.execute();
			 JOptionPane.showMessageDialog(frame, "Order was made");
			 
			// ConnectionFactory.close(dbConnection);
			 ConnectionFactory.close(insertStatement);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame, "Product not available");
		}
		return ok;
	}
    /**
     * method used to access the database and update the quantity based on the quantity ordered
     * @param o order used for updating conditions
     */
	public static void updateQuantity(Order o) {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement updateStatement = null;

		ResultSet rs = null;
		int quantity = 0;
		try {
			updateStatement = dbConnection.prepareStatement(updateStatementString);

			updateStatement.setInt(1, o.getQuantity());
			updateStatement.setString(2, o.getP_name());
			updateStatement.setString(3, o.getSize());
			updateStatement.execute();

			ConnectionFactory.close(updateStatement);
		} catch (Exception e) {
			System.out.println("Unavailable product");
		}

	}

}
