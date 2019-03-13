package businessAccess;

import javax.swing.JTable;

import dataAccess.AccessClient;
import model.Client;

public class ClientBusiness {
	/**
	 * method is used to insert a client into the database
	 * 
	 * @param c
	 *            client to be inserted
	 */
	public static void insertClient(Client c) {
		//AccessClient ac = null;
		AccessClient.insertClient(c);
	}

	/**
	 * method used to delete a client from database
	 * 
	 * @param name
	 *            name of the client to be deleted
	 */
	public static void deleteClient(String name) {
		//AccessClient ac = null;
		AccessClient.deleteClient(name);
	}

	/**
	 * this method updates the information from the database
	 * 
	 * @param c
	 *            client to be updated
	 * @param field
	 *            which parameter of client to be updated
	 */
	public static void editClient(Client c, String field) {
		//AccessClient ac = null;
		AccessClient.updateClient(c, field);
	}

	/**
	 * method for showing the table with all clients
	 * 
	 * @param show
	 */
	public static void showAll(JTable show) {
		AccessClient.showClients(show);
	}
}
