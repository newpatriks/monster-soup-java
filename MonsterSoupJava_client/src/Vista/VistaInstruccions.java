package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Controlador.ListenerInstruccions;

public class VistaInstruccions extends JPanel{

	private JButton botoRetorn;
	private JTextArea textInstruc;
	private JPanel jpContent;
	
	public VistaInstruccions(){
		botoRetorn = new JButton("Tornar al menœ");
		botoRetorn.setSize(300, 100);
		
		textInstruc = new JTextArea("A menacing maniac from Pluto threatens the burgeoning \nmonster-civilization of Soup System. It's your job to unite \nthese innocent critters and rescue them from Plubert and his \napproaching Ice Age. \nDrag your finger over the screen to connect same-colored monsters. \nCreate longer chains for more points and special power-ups. But act \nfast before they get caught in the icy snares of the fiendish \nplanet-freezer, Plubert!");
		textInstruc.setFont(new Font("Calibri", Font.PLAIN, 18));
		textInstruc.setSize(500, 200);
		textInstruc.setAlignmentX(CENTER_ALIGNMENT);
		
		jpContent = new JPanel();
		jpContent.setOpaque(false);
		
		jpContent.setPreferredSize(new Dimension(500, 200));
		jpContent.setLayout(new BorderLayout());

		jpContent.add(textInstruc);

		this.add(jpContent, BorderLayout.CENTER);
		this.add(botoRetorn, BorderLayout.SOUTH);
		
		
		
	}
	public void setControlador(ListenerInstruccions li){
		botoRetorn.addActionListener(li);
	}
}
