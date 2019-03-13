import javax.swing.JOptionPane;

public class Controller {

	private View view = new View();
	private Coin coin = new Coin();
	private History history = new History();
	private static int bc = 0;
	private static int ec = 0;
	private static int rc = 0;
	private float i;

	public Controller() {
		history.setVisible(false);

		view.addPriceBtn(e -> {
			int ok = 1;
			try {
				String s = view.textField.getText();
				i = Float.parseFloat(s);
			} catch (NumberFormatException al) {
				ok = 0;
				JOptionPane.showMessageDialog(view, "Invalid amount");
			}
			if (ok == 1) {
				if (view.comboBox.getSelectedItem().equals("BITCOIN")) {
					view.bitcoin.setText(view.textField.getText());
					if (bc < 5) {
						coin.bitcoin[bc] = i;
						bc++;
					} else {
						coin.bitcoin[0] = coin.bitcoin[1];
						coin.bitcoin[1] = coin.bitcoin[2];
						coin.bitcoin[2] = coin.bitcoin[3];
						coin.bitcoin[3] = coin.bitcoin[4];
						coin.bitcoin[4] = i;
						bc++;
					}
				}
				if (view.comboBox.getSelectedItem().equals("RIPPLE")) {
					view.ripple.setText(view.textField.getText());
					if (rc < 5) {
						coin.ripple[rc] = i;
						rc++;
					} else {
						coin.ripple[0] = coin.ripple[1];
						coin.ripple[1] = coin.ripple[2];
						coin.ripple[2] = coin.ripple[3];
						coin.ripple[3] = coin.ripple[4];
						coin.ripple[4] = i;
						rc++;
					}
				}
				if (view.comboBox.getSelectedItem().equals("ETHEREUM")) {
					view.ethereum.setText(view.textField.getText());
					if (ec < 5) {
						coin.ethereum[ec] = i;
						ec++;
					} else {
						coin.ethereum[0] = coin.ethereum[1];
						coin.ethereum[1] = coin.ethereum[2];
						coin.ethereum[2] = coin.ethereum[3];
						coin.ethereum[3] = coin.ethereum[4];
						coin.ethereum[4] = i;
						ec++;
					}
				}
			}
		});
		view.bitcoinShow(e -> {
			if (bc == 0)
				history.mesaj.setText("No price hystory available for BITCOIN!");
			else if (bc == 1) {
				history.mesaj.setText("Showing last price for BITCOIN");
				history.price1.setText("1: " + coin.bitcoin[0] + "$");
			} else if (bc == 2) {
				history.mesaj.setText("Showing last 2 for BITCOIN");
				history.price1.setText("1: " + coin.bitcoin[0] + "$");
				history.price2.setText("2: " + coin.bitcoin[1] + "$");
			} else if (bc == 3) {
				history.mesaj.setText("Showing last 3 for BITCOIN");
				history.price1.setText("1: " + coin.bitcoin[0] + "$");
				history.price2.setText("2: " + coin.bitcoin[1] + "$");
				history.price3.setText("3: " + coin.bitcoin[2] + "$");
			} else if (bc == 4) {
				history.mesaj.setText("Showing last 4 for BITCOIN");
				history.price1.setText("1: " + coin.bitcoin[0] + "$");
				history.price2.setText("2: " + coin.bitcoin[1] + "$");
				history.price3.setText("3: " + coin.bitcoin[2] + "$");
				history.price4.setText("4: " + coin.bitcoin[3] + "$");
			} else if (bc >= 5) {
				history.mesaj.setText("Showing last 5 for BITCOIN");
				history.price1.setText("1: " + coin.bitcoin[0] + "$");
				history.price2.setText("2: " + coin.bitcoin[1] + "$");
				history.price3.setText("3: " + coin.bitcoin[2] + "$");
				history.price4.setText("4: " + coin.bitcoin[3] + "$");
				history.price5.setText("5: " + coin.bitcoin[4] + "$");
			}

			view.setVisible(false);
			history.setVisible(true);
		});
		view.rippleShow(e -> {
			if (rc == 0)
				history.mesaj.setText("No price hystory available for RIPPLE!");
			else if (rc == 1) {
				history.mesaj.setText("Showing last price for RIPPLE");
				history.price1.setText("1: " + coin.bitcoin[0] + "$");
			} else if (rc == 2) {
				history.mesaj.setText("Showing last 2 for RIPPLE");
				history.price1.setText("1: " + coin.ripple[0] + "$");
				history.price2.setText("2: " + coin.ripple[1] + "$");
			} else if (rc == 3) {
				history.mesaj.setText("Showing last 3 for RIPPLE");
				history.price1.setText("1: " + coin.ripple[0] + "$");
				history.price2.setText("2: " + coin.ripple[1] + "$");
				history.price3.setText("3: " + coin.ripple[2] + "$");
			} else if (rc == 4) {
				history.mesaj.setText("Showing last 4 for RIPPLE");
				history.price1.setText("1: " + coin.ripple[0] + "$");
				history.price2.setText("2: " + coin.ripple[1] + "$");
				history.price3.setText("3: " + coin.ripple[2] + "$");
				history.price4.setText("4: " + coin.ripple[3] + "$");
			} else if (rc >= 5) {
				history.mesaj.setText("Showing last 5 for RIPPLE");
				history.price1.setText("1: " + coin.ripple[0] + "$");
				history.price2.setText("2: " + coin.ripple[1] + "$");
				history.price3.setText("3: " + coin.ripple[2] + "$");
				history.price4.setText("4: " + coin.ripple[3] + "$");
				history.price5.setText("5: " + coin.ripple[4] + "$");
			}

			view.setVisible(false);
			history.setVisible(true);
		});
		view.ethereumShow(e -> {
			if (ec == 0)
				history.mesaj.setText("No price hystory available for ETHEREUM!");
			else if (ec == 1) {
				history.mesaj.setText("Showing last price for ETHEREUM");
				history.price1.setText("1: " + coin.ethereum[0] + "$");
			} else if (ec == 2) {
				history.mesaj.setText("Showing last 2 for ETHEREUM");
				history.price1.setText("1: " + coin.ethereum[0] + "$");
				history.price2.setText("2: " + coin.ethereum[1] + "$");
			} else if (ec == 3) {
				history.mesaj.setText("Showing last 3 for ETHEREUM");
				history.price1.setText("1: " + coin.ethereum[0] + "$");
				history.price2.setText("2: " + coin.ethereum[1] + "$");
				history.price3.setText("3: " + coin.ethereum[2] + "$");
			} else if (ec == 4) {
				history.mesaj.setText("Showing last 4 for ETHEREUM");
				history.price1.setText("1: " + coin.ethereum[0] + "$");
				history.price2.setText("2: " + coin.ethereum[1] + "$");
				history.price3.setText("3: " + coin.ethereum[2] + "$");
				history.price4.setText("4: " + coin.ethereum[3] + "$");
			} else if (ec >= 5) {
				history.mesaj.setText("Showing last 5 for ETHEREUM");
				history.price1.setText("1: " + coin.ethereum[0] + "$");
				history.price2.setText("2: " + coin.ethereum[1] + "$");
				history.price3.setText("3: " + coin.ethereum[2] + "$");
				history.price4.setText("4: " + coin.ethereum[3] + "$");
				history.price5.setText("5: " + coin.ethereum[4] + "$");
			}

			view.setVisible(false);
			history.setVisible(true);
		});
		history.closeBtn(e -> {
			history.mesaj.setText("");
			history.price1.setText("");
			history.price2.setText("");
			history.price3.setText("");
			history.price4.setText("");
			history.price5.setText("");
			view.setVisible(true);
			history.setVisible(false);
		});
	}

}
