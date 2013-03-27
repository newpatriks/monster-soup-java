package Controlador;


import java.io.Serializable;
import java.util.Random;

import javax.swing.JComponent;

public class Monstre extends JComponent implements Serializable{
	
	private int posX;
	private int posY;
	private int tipus;
	private int vel;
	private boolean alive;
	private static final long serialVersionUID = -6733656002916532753L;
	private int idMonstre;

	public Monstre(int posicioX, int tipusM, int idMonstre){
		posX = posicioX;
		posY = 500;
		alive = true;
		tipus = tipusM;
		Random generator = new Random();
		vel = generator.nextInt(3) + 1;
		this.idMonstre = idMonstre;
	}
	public void mou(){
		if(posY < 0){
			// El monstre s'ha d'eliminar del conjunt de monstres
			// Ha d'aparixer el gel
			alive = false;
		}else{
			posY-=vel;
		}
	}
	public boolean viu(){
		return alive;
	}
	public int getX(){
		return posX;
	}
	public int getY(){
		return posY;
	}
	public int getTipus(){
		return tipus;
	}
	public int getID(){
		return idMonstre;
	}
	public void setY(int posY){
		this.posY = posY;
	}

}
