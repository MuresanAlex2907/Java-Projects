package businessAccess;

import javax.swing.JFrame;

import dataAccess.AccessOrder;
import model.Order;

public class OrderBusiness {
/**
 * method for inserting an order into the database
 * @param o new order
 * @param frame
 * @return 1 if the order can be done
 */
	public static int insertOrder(Order o,JFrame frame) {
		AccessOrder ao=null;
		return ao.insertOrder(o, frame);
	}
	/**
	 * method used for updating the quantity in product table after an order is done
	 * @param o
	 */
	public static void updateQuantity(Order o) {
		AccessOrder ao=null;
		ao.updateQuantity(o);
	}
	
}
