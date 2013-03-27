package Vista;

import Controlador.ListenerConnexio;

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
import javax.swing.JTextField;

public class VistaPortIP extends JPanel{

	private JButton botoConnexio;
	private JTextField textPort;
	private JTextField textIP;
	private JLabel labelPort;
	private JLabel labelIP;
	private JPanel jpContent;

	public VistaPortIP(){
		botoConnexio = new JButton("Busca enemic!");
		textPort = new JTextField();
		textIP = new JTextField();
		labelPort = new JLabel("   PORT:");
		labelPort.setFont(new Font("Calibri", Font.BOLD, 30));
		labelPort.setForeground(Color.white);
		labelIP = new JLabel("         IP:");
		labelIP.setFont(new Font("Calibri", Font.BOLD, 30));
		labelIP.setForeground(Color.white);
		jpContent = new JPanel();
		jpContent.setOpaque(false);
		labelPort.setPreferredSize(new Dimension(150, 50));
		textPort.setPreferredSize(new Dimension(300, 50));
		labelIP.setPreferredSize(new Dimension(150, 50));
		textIP.setSize(200, 50);
		
		jpContent.setPreferredSize(new Dimension(270, 60));
		jpContent.setLayout(new GridLayout(2, 2));

		jpContent.add(labelPort);
		jpContent.add(textPort);
		jpContent.add(labelIP);
		jpContent.add(textIP);
		
		botoConnexio.setSize(300, 100);
		this.add(jpContent, BorderLayout.CENTER);
		this.add(botoConnexio, BorderLayout.SOUTH);
		
		
		
	}
	public void setControlador(ListenerConnexio li){
		botoConnexio.addActionListener(li);
	}
	public String getIP(){
		return textIP.getText();
	}
	public String getPort(){
		return textPort.getText();
	}
}
