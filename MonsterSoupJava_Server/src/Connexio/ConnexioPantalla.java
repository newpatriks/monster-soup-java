package Connexio;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Vector;

import Controlador.*;


public class ConnexioPantalla{
	private ServerSocket ss;
	private Socket s_1;
	private Socket s_2;
	private ObjectInputStream ois_1;
	private ObjectOutputStream oos_1;
	private ObjectInputStream ois_2;
	private ObjectOutputStream oos_2;
	private int numConexions = 0;
	
	public ConnexioPantalla(){
		try{
			ss = new ServerSocket(5000);
			System.out.println(" Esperant 2 conexio... ");
			s_1 = ss.accept();
			System.out.println(" 1 usuari connectat ");
			s_2 = ss.accept();
			System.out.println(" 2 usuaris connectats ");		
						
			ois_1 = new ObjectInputStream(s_1.getInputStream());
			oos_1 = new ObjectOutputStream(s_1.getOutputStream());
			
			ois_2 = new ObjectInputStream(s_2.getInputStream());
			oos_2 = new ObjectOutputStream(s_2.getOutputStream());			
			
		}catch(Exception e){
			System.out.println("caca");
		}
	}
	public void tanca(){
		try{
			ois_1.close();
			ois_2.close();
			
			s_1.close();
			s_2.close();
			
			ss.close();
		}catch(Exception e){}
	}
	
	public ConjuntMonstres llegeixMonstres(){
		ConjuntMonstres cm = null;
		try{
			//msg = dis.readUTF();
			cm = (ConjuntMonstres)ois_1.readObject();
		}catch(Exception e){
			System.out.println("Error al llegir des del Servidor Monstres1");
		}
		return cm;
	}
	
	public void enviaMonstres(ConjuntMonstres cm){
		try{
			//System.out.println("Num monstres servidor: "+cm.quantsMonstres());
			oos_1.writeObject(cm);
			oos_1.flush();
			oos_1.reset();
		}catch(Exception e){
			//System.out.println("Error d'enviament!");
		}
	}
	
	public ConjuntMonstres llegeixMonstres2(){
		ConjuntMonstres cm = null;
		try{
			//msg = dis.readUTF();
			cm = (ConjuntMonstres)ois_2.readObject();
		}catch(Exception e){
			System.out.println("Error al llegir des del Servidor Monstres2");
		}
		return cm;
	}
	
	public void enviaMonstres2(ConjuntMonstres cm){
		try{
			//System.out.println("Num monstres servidor: "+cm.quantsMonstres());
			oos_2.writeObject(cm);
			oos_2.flush();
			oos_2.reset();
		}catch(Exception e){
			//System.out.println("Error d'enviament!");
		}
	}
	
	public void enviaMonstresAL(ArrayList<ConjuntMonstres> alcm){
		try{
			//System.out.println("Num monstres servidor: "+alcm.size());
			oos_1.writeObject(alcm);
			oos_1.flush();
			oos_1.reset();
		}catch(Exception e){
			System.out.println("enviaMonstresAL > Error d'enviament!");
		}
	}
}