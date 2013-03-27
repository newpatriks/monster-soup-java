/**
 * 
 */
package Connexio;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JButton;

import Controlador.ConjuntMonstres;
import Controlador.Joc;

/**
 * @author jordillobet
 *
 */
public class ThreadEnviar implements Runnable{

	private ConjuntMonstres cm1;
	private ConjuntMonstres cm2;
	private Joc joc1;
	private Joc joc2;
	private ConnexioPantalla cp;
	private int numUsuari;
	ArrayList<ConjuntMonstres> alcm;
	
	//public ThreadEnviar(Joc joc1, Joc joc2, ConnexioPantalla cp) {
	public ThreadEnviar(ConjuntMonstres cm1, ConjuntMonstres cm2, ConnexioPantalla cp) {
		//this.joc1 = joc1;
		//this.joc2 = joc2;
		this.cp = cp;
		this.cm1 = cm1;
		this.cm2 = cm2;
		//this.joc1.start();
		//this.joc2.start();
	}
	
	@Override
	public void run() {
		while(true){
			try{
				ArrayList<ConjuntMonstres> alcm = new ArrayList<ConjuntMonstres>();
				alcm.add(this.cm1);
				alcm.add(this.cm2);
				
				//System.out.println("cm1: "+joc1.getConjuntMonstres().quantsMonstres());
				//System.out.println("cm2: "+joc2.getConjuntMonstres().quantsMonstres());
				
				cp.enviaMonstresAL(alcm);
				Thread.sleep(100);
				//System.out.println(alcm);
			}catch(Exception e){
				System.out.println("Error en l'enviament");
			}
			
		}
	}
	/*
	public void enviaMonstres() {
		try{
			ObjectOutputStream oos = new ObjectOutputStream(skt.getOutputStream());
			//System.out.println(cm.getMonstres().size());
			oos.writeObject(cm.getMonstres());
			oos.flush();
			oos.close();
		}catch(Exception e){
			//e.printStackTrace();
		}
		
	}
	*/
	public void start(){
    	new Thread(this).start();
    }
}
