package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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

import Controlador.ConjuntMonstres;
import Controlador.Gel;
import Controlador.Monstre;


public class PanellMonstres extends JPanel{
	
	private ConjuntMonstres monstres;
	private Vector<Monstre> vec_mon;
	public GridBagConstraints propsLay;
	public FinestraPpal finestra;
	public JLabel imgfons;
	
	public PanellMonstres(FinestraPpal fin){
		imgfons = new JLabel(new ImageIcon("img/fons_1.png"));
		
		imgfons.setLocation(0, 0);
		imgfons.setSize(390, 540);
		imgfons.setVisible(true);
		
		//DibuixaMonstre prova = new DibuixaMonstre(new Monstre(100, 0, 0));
		
		
		finestra = fin;
		setLayout(new GridBagLayout());
		propsLay = new GridBagConstraints();
		propsLay.gridx = 0;
		propsLay.gridy = 0;
		propsLay.fill = GridBagConstraints.BOTH;
		propsLay.weightx = 1.0;
		propsLay.weighty = 1.0;
		
		//this.add(imgfons, propsLay);
		
		//this.add(prova, propsLay);
		
		// Fixem tamany finestra
		this.setPreferredSize(new Dimension(390, 540));
		this.setBackground(Color.YELLOW);
		//fin.setContentPane(this);
		this.setLocation(0, 0);
	
		fin.setVisible(true);

	}
	
	public void afegeixMonstre(DibuixaMonstre2 m){
		
		System.out.println("DibuixaMonstre!");
		//this.removeAll();
		propsLay = new GridBagConstraints();
		propsLay.gridx = 0;
		propsLay.gridy = 0;
		propsLay.fill = GridBagConstraints.BOTH;
		propsLay.weightx = 1.0;
		propsLay.weighty = 1.0;
		this.add(m, propsLay);
		
		finestra.setVisible(true);
		
	}
	/*public void afegeixGel(Gel g){
		//remove(imgfons);
		this.add(g, propsLay);
		//this.add(imgfons, propsLay);
		finestra.setVisible(true);
	}*/


}
