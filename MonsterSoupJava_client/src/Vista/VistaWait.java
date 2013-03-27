package Vista;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controlador.ListenerMenu;

public class VistaWait extends JPanel{
	
	private JLabel label1;
	private AnimatedIcon icon1;
	private JLabel textWait;
	
	public VistaWait(){
		this.setLayout(null);
		
		label1 = new JLabel();
		icon1 = new AnimatedIcon(label1, 80, 100);
		
		ImageIcon wait1 = new ImageIcon("img/wait1.png");
		icon1.addIcon(wait1);
		ImageIcon wait2 = new ImageIcon("img/wait2.png");
		icon1.addIcon(wait2);
		ImageIcon wait3 = new ImageIcon("img/wait3.png");
		icon1.addIcon(wait3);
		ImageIcon wait4 = new ImageIcon("img/wait4.png");
		icon1.addIcon(wait4);
		ImageIcon wait5 = new ImageIcon("img/wait5.png");
		icon1.addIcon(wait5);
		ImageIcon wait6 = new ImageIcon("img/wait6.png");
		icon1.addIcon(wait6);
		ImageIcon wait7 = new ImageIcon("img/wait7.png");
		icon1.addIcon(wait7);
		ImageIcon wait8 = new ImageIcon("img/wait8.png");
		icon1.addIcon(wait8);
		ImageIcon wait9 = new ImageIcon("img/wait9.png");
		icon1.addIcon(wait9);
		ImageIcon wait10 = new ImageIcon("img/wait10.png");
		icon1.addIcon(wait10);
		
		label1.setIcon(icon1);
		
		textWait = new JLabel("Esperant enemic...");
	
		label1.setLocation(110, 50);
		label1.setSize(100, 100);
		textWait.setLocation(90, 20);
		textWait.setSize(200, 50);
	
		this.add(label1);
		this.add(textWait);
		icon1.start();
	}

}
