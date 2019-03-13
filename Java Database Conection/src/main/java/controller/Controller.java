package controller;

import businessAccess.ClientBusiness;
import businessAccess.OrderBusiness;
import businessAccess.ProductBusiness;
import connection.ConnectionFactory;
import dataAccess.*;
import model.Client;
import model.Order;
import model.Product;
import view.ClientView;
import view.ProductView;
import view.Selection;

public class Controller {
	private String name = null;
    private int ok=0;
	public Controller() {
		final Selection s = new Selection();
		final ProductView pv = new ProductView();
		final ClientView cv = new ClientView();
		ConnectionFactory cf = new ConnectionFactory();
		cf.createConnection();

		s.productButton(e -> {
			s.visibleS(false);
			pv.visibleP(true);
		});
		s.clientButton(e -> {
			s.visibleS(false);
			cv.visibleC(true);
		});
		pv.back(e -> {
			pv.visibleP(false);
			s.visibleS(true);
		});
		cv.back(e -> {
			cv.visibleC(false);
			s.visibleS(true);
		});

		pv.addProduct(e -> {
			Product p = new Product(pv.getDescription(), pv.getSize(), pv.getQuantity(), pv.getPrice());
			ProductBusiness.insertProduct(p);
		});

		pv.deleteProduct(e -> {
			ProductBusiness.deleteProduct(pv.getDescription(), pv.getSize());
		});
		pv.editProduct(e -> {
			Product p = new Product(pv.getDescription(), pv.getSize(), pv.getQuantity(), pv.getPrice());
			ProductBusiness.editProduct(p, pv.getEdit());
		});
		pv.showProduct(e -> {
			ProductBusiness.showAll(pv.show);
		});
		cv.addClient(e -> {
			Client c = new Client(0,cv.getName(), cv.getEmail(), cv.getAge(), cv.getAddress());
			ClientBusiness.insertClient(c);
		});

		cv.delete(e -> {
			ClientBusiness.deleteClient(cv.getName());
		});

		cv.editClient(e -> {
			Client c = new Client(0,cv.getName(), cv.getEmail(), cv.getAge(), cv.getAddress());
			ClientBusiness.editClient(c, cv.getEdit());
		});
		cv.showClient(e -> {
			ClientBusiness.showAll(cv.show);
		});

		cv.orderButton(e -> {
			cv.visibleC(false);
			name = cv.getName();
			pv.visibleP(true);
		});

		pv.chooseButton(e -> {
			 
			Order o = new Order(name, pv.getDescription(), pv.getSize(), pv.getQuantity(),0);
			ok=OrderBusiness.insertOrder(o,pv.frame);
			if (ok == 1) {
				OrderBusiness.updateQuantity(o);
				CreateBill.makeBill(o);
			}
		});

	}

}
