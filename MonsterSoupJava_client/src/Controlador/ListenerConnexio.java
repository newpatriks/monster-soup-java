package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import Connexio.ConnexioComandament;
import Connexio.ThreadRebre;
import Vista.FinestraPpal;
import Vista.VistaPortIP;

public class ListenerConnexio implements ActionListener{
	private FinestraPpal fin;
	private VistaPortIP vPI;
	private ConnexioComandament cc;
	
	public ListenerConnexio(FinestraPpal f, VistaPortIP vistaCon){
		fin = f;
		vPI = vistaCon;
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		JButton orig;
		orig = (JButton)evt.getSource();
		
		if (orig.getText().equals("Busca enemic!")){
			// Esperar enemic

			//conServ = new ConnexioComandament(vPI.getIP(), Integer.parseInt(vPI.getPort()));
			cc = new ConnexioComandament("127.0.0.1", 5000);
			ThreadRebre tr = new ThreadRebre(cc);
			tr.start();
			
			ControlEscenari ce= new ControlEscenari(tr, fin);
			fin.setControlador(ce);
			fin.setPanell(5);

		}
	}
}
