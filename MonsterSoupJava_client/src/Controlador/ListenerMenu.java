package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Vista.FinestraPpal;

public class ListenerMenu implements ActionListener {
	private FinestraPpal fin;
	
	public ListenerMenu(FinestraPpal f){
		fin = f;
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		JButton orig;
		orig = (JButton)evt.getSource();
		
		if (orig.getText().equals("Play")){
			// Play

			fin.setPanell(3);
			
		} else if (orig.getText().equals("How to Play")){
			// How to play
			fin.setPanell(2);
		}
	}
}
