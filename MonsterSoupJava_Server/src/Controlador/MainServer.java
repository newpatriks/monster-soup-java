package Controlador;

import java.util.ArrayList;

import javax.swing.SwingUtilities;

import Connexio.ConnexioPantalla;
import Connexio.ThreadEnviar;

public class MainServer {

	/**
	 * @param args
	 */
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Aquesta és la forma recomanable de crear i fer visible un JFrame.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	//FinestraPpal finPrincipal = new FinestraPpal();
            	//PanellMonstres panellM = new PanellMonstres(finPrincipal);

            	ConnexioPantalla cp = new ConnexioPantalla();
                
                Joc joc1 = new Joc();
                Joc joc2 = new Joc();
                
                joc1.start();
                joc2.start();
                                
                //ThreadEnviar te = new ThreadEnviar(joc1, joc2, cp);
                ThreadEnviar te = new ThreadEnviar(joc1.getConjuntMonstres(), joc2.getConjuntMonstres(), cp);
                
                te.start();
                
                //finPrincipal.setVisible(true);
            }
        });
		
	}

}
