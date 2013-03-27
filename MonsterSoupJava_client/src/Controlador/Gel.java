package Controlador;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class Gel extends JComponent{
	private int posX;
	private int posY;
	private BufferedImage im;
	private boolean alive;

	public Gel(int posicioX){
		posX = posicioX;
		posY = 0;
		alive = true;		
		im = CarregaImatge("img/gel.png");
	}
	
	@Override
	public void paintComponent(Graphics g){
		g.drawImage(im, posX, posY, this);
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

	public boolean viu(){
		return alive;
	}
}
