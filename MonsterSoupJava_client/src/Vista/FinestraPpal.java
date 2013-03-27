package Vista;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Controlador.ControlEscenari;
import Controlador.ListenerConnexio;
import Controlador.ListenerInstruccions;
import Controlador.ListenerMenu;

public class FinestraPpal extends JFrame{
	
	private VistaPortIP vistaConnexio;
	private VistaMenu vistaMenu;
	private VistaInstruccions vistaInstruc;
	private VistaWait vistaWait;
	private VistaJoc vistaJoc;
	private PanellTitol titol;
	private ImatgeFons imgfons;
	private ImatgeFons imgfons2;
	private JPanel panellfons;
	private ControlEscenari ce;
	
	public FinestraPpal(){

		// Fixem tamany finestra
		setSize(1100,750);
		// Layout manager a null
		setLayout(null);
		setLocation(100, 0);
		
		// Afegim panell t’tol
		titol = new PanellTitol();
		titol.setLocation(330,10);
		titol.setSize(435, 80);
		//getContentPane().add(titol);
		
		imgfons = new ImatgeFons(0);
		imgfons2 = new ImatgeFons(685);
		panellfons = new JPanel();
		panellfons.setSize(1000,800);
		panellfons.setLayout(null);

		setTitle("Monster Soup");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setPanell(int iPanell){
		
		
		getContentPane().removeAll();
		panellfons.add(titol);
		
		
		switch(iPanell){
			case 1:
				// MENU
				// Afegim panell menu
				vistaMenu = new VistaMenu();
				vistaMenu.setLocation(400,250);
				vistaMenu.setSize(300, 110);
				
				vistaMenu.setControlador(new ListenerMenu(this));
				panellfons.add(vistaMenu);
				imgfons.start();
				imgfons2.start();
				//System.out.println(getContentPane().getComponentCount());
				break;
			case 2:
				// Instruccions
				vistaInstruc = new VistaInstruccions();
				vistaInstruc.setLocation(300,220);
				vistaInstruc.setSize(530, 250);
				vistaInstruc.setOpaque(false);
				vistaInstruc.setControlador(new ListenerInstruccions(this));
				panellfons.add(vistaInstruc);
				imgfons.start();
				imgfons2.start();
				break;
			case 3:
				
				// IP/PORT
				// Afegim panell contingut
				vistaConnexio = new VistaPortIP();
				vistaConnexio.setLocation(390,250);
				vistaConnexio.setSize(300, 110);
				vistaConnexio.setControlador(new ListenerConnexio(this, vistaConnexio));
				vistaConnexio.setOpaque(false);
				panellfons.add(vistaConnexio);
				imgfons.start();
				imgfons2.start();
				break;
			case 4:
				// Wait
				// Afegim panell contingut
				vistaWait = new VistaWait();
				vistaWait.setLocation(300,250);
				vistaWait.setSize(300, 200);
				
				panellfons.add(vistaWait);
				imgfons.start();
				imgfons2.start();
				break;
			case 5:
				// Joc
				imgfons.stop();
				imgfons2.stop();
				panellfons.add(ce.getVistaJoc());
				break;
			case 6:
				// Final
				break;
			default:
				
				break;
		}
		panellfons.add(imgfons);
		panellfons.add(imgfons2);
		setContentPane(panellfons);
		
	}
	
	public void setControlador(ControlEscenari ce){	
		this.ce = ce;
	}
	
}
