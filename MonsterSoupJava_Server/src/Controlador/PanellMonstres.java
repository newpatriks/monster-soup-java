package Controlador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class PanellMonstres extends JPanel{
	
	private ConjuntMonstres monstres;
	private Vector<Monstre> vec_mon;
	public GridBagConstraints propsLay;
	public FinestraPpal finestra;
	public JLabel imgfons;
	
	public PanellMonstres(FinestraPpal fin){
		imgfons = new JLabel(new ImageIcon("fons_1.png"));
		
		imgfons.setLocation(0, 0);
		imgfons.setSize(390, 540);
		imgfons.setVisible(true);
		
		
		finestra = fin;
		setLayout(new GridBagLayout());
		propsLay = new GridBagConstraints();
		propsLay.gridx = 0;
		propsLay.gridy = 0;
		propsLay.fill = GridBagConstraints.BOTH;
		propsLay.weightx = 1.0;
		propsLay.weighty = 1.0;
		this.add(imgfons, propsLay);
		
		//this.add(imgfons, propsLay);
		// Fixem tamany finestra
		setSize(390, 540);
		//this.setBackground(Color.YELLOW);
		fin.setContentPane(this);
		this.setLocation(0, 0);
		// Fixem tamany finestra
		fin.setSize(390, 540);
		fin.setVisible(true);

	}
	
	public void afegeixMonstre(Monstre m){
		remove(imgfons);
		this.add(m, propsLay);
		this.add(imgfons, propsLay);
		finestra.setVisible(true);
	}
	public void afegeixGel(Gel g){
		//remove(imgfons);
		this.add(g, propsLay);
		//this.add(imgfons, propsLay);
		finestra.setVisible(true);
	}


}
