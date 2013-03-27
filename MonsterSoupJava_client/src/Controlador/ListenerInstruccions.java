package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Vista.FinestraPpal;

public class ListenerInstruccions implements ActionListener{
	private FinestraPpal fin;
	
	public ListenerInstruccions(FinestraPpal f){
		fin = f;
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		JButton orig;
		orig = (JButton)evt.getSource();
		
		if (orig.getText().equals("Tornar al menœ")){
			// Play

			fin.setPanell(1);
		}
	}
}
