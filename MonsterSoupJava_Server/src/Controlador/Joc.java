package Controlador;

import java.net.Socket;
import java.util.Random;

import Connexio.ConnexioPantalla;
import Connexio.ThreadEnviar;

public class Joc implements Runnable{

	private ConjuntMonstres monstres;
	private Monstre monstre;
	private ThreadJoc tj;
	private int idMonstre;
	
	public Joc(){
		monstres = new ConjuntMonstres();
		tj = new ThreadJoc(monstres);
		tj.start();
		idMonstre = 0;

	}
    public void run(){
		while(true){
			try{
				creaMonstre();
				Random generator = new Random();
				int interval = generator.nextInt(500) + 1500;
				Thread.sleep(interval);
			}catch(Exception e){
				
			}
		}	
	}
    
	public void creaMonstre(){
		
		Random generator = new Random();
		int tipus = generator.nextInt(6);
		Random generator2 = new Random();
		int posX = generator2.nextInt(200) + 50;
		
		monstre = new Monstre(posX, tipus, idMonstre);
		
		idMonstre+=1;
		monstres.afegeixMon(monstre);
		//panell.afegeixMonstre(monstre);
		//monstre.start();
	
	}
	
	public void start(){
    	new Thread(this).start();
    }
	public ConjuntMonstres getConjuntMonstres(){
		return monstres;
	}
}
