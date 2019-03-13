package businessAccess;

import javax.swing.JTable;

import dataAccess.AccessStudent;
import model.Product;

public class ProductBusiness {
  /**
   * method used to insert a product
   * @param p new product
   */
	public static void insertProduct(Product p) {
		AccessStudent as=null;
		as.insertProduct(p);
	}
	/**
	 * method used to delete a product
	 * @param name product description
	 * @param size size
	 */
	public static void deleteProduct(String name,String size) {
		AccessStudent as=null;
		as.deleteProduct(name, size);
	}
	/**
	 * method used to edit a product's field
	 * @param p which product
	 * @param field which field
	 */
	public static void editProduct(Product p,String field) {
		AccessStudent as=null;
		as.updateProduct(p, field);
	}
	/**
	 * method used to show the table with all products available
	 * @param show
	 */
	public static void showAll(JTable show) {
		AccessStudent as=null;
		as.showProducts(show);
	}
}
