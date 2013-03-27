package Vista;

import javax.swing.JButton;
import javax.swing.JPanel;

import Controlador.ListenerMenu;

public class VistaMenu extends JPanel{
	
	private JButton btn_play;
	private JButton btn_tuto;
	
	public VistaMenu(){
		this.setLayout(null);
		setOpaque(false);
		btn_play = new JButton("Play");
		btn_tuto = new JButton("How to Play");
	
		btn_play.setLocation(50, 0);
		btn_play.setSize(200, 50);
		btn_tuto.setLocation(50, 60);
		btn_tuto.setSize(200, 50);
	
		this.add(btn_play);
		this.add(btn_tuto);
	}
	public void setControlador(ListenerMenu li){
		btn_play.addActionListener(li);
		btn_tuto.addActionListener(li);
	}
}
