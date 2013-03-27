package Vista;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import Controlador.Monstre;

public class DibuixaMonstre extends JComponent{
	
	private Monstre m;
	private int posX;
	private int posY;
	private BufferedImage im;
	
	public DibuixaMonstre(Monstre m){
		this.m = m;
		posX = this.m.getX();
		posY = this.m.getY();
		switch(m.getTipus()){
		case 0:
			im = CarregaImatge("img/b1.png");
			//System.out.println("Monstre 1");
			break;
		case 1:
			im = CarregaImatge("img/b2.png");
			//System.out.println("Monstre 2");
			break;
		case 2:
			im = CarregaImatge("img/b3.png");
			//System.out.println("Monstre 3");
			break;
		case 3:
			im = CarregaImatge("img/b4.png");
			//System.out.println("Monstre 4");
			break;
		case 4:
			im = CarregaImatge("img/b5.png");
			//System.out.println("Monstre 5");
			break;
		}
	}

	@Override
	public void paintComponent(Graphics g){
		//super.paintComponent(g);
		g.drawImage(im, posX, posY, this);
		g.fillOval(posX, posY, 50, 50);
	}
	
	public BufferedImage CarregaImatge (String nom){
		BufferedImage imatge=null;
		try{
			imatge = ImageIO.read(new File(nom));
		}catch(Exception e){
			System.out.println("Error al carregar la imatge: " + e.getMessage());
		}
		return imatge;
	}
}
