package Controlador;

import javax.swing.SwingUtilities;

import Vista.FinestraPpal;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Aquesta és la forma recomanable de crear i fer visible un JFrame.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	ListenerConnexio lcon;
                FinestraPpal finPrincipal = new FinestraPpal();
                finPrincipal.setPanell(1);
                finPrincipal.setVisible(true);
            }
        });
	}
}
