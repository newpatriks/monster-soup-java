package Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Vector;

import javax.swing.JPanel;

// Aquest import no ha de ser-hi!!!!!
// Després quan li passem des de les connexions el treurem juju :)
import Controlador.Monstre;

public class Escenari extends JPanel{

	public Escenari(){
		this.setPreferredSize(new Dimension(390, 540));
		
	}
	public void pintaMonstres(Vector<Monstre> monstres){
		for(int i = 0; i < monstres.size(); i++){
			this.add(monstres.elementAt(i));
		}
	}
	
}
