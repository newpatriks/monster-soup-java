package Connexio;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Vector;

import Controlador.ConjuntMonstres;
import Controlador.Monstre;

public class ConnexioComandament{
	private Socket s;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private ArrayList<ConjuntMonstres> alcm;
	
	public ConnexioComandament(String IP, int Port){
		try{
			s 	= new Socket(IP,Port);
			oos = new ObjectOutputStream(s.getOutputStream());
			ois = new ObjectInputStream(s.getInputStream());
		}catch(Exception e){
			System.out.println("Error al crear el socket");
		}
	}
	
	public void tanca(){
		try{
			oos.close();
			s.close();
		}catch(Exception e){}
	}
	
	
	public ArrayList<ConjuntMonstres> llegeixMonstresArray(){
		try{
			alcm = (ArrayList<ConjuntMonstres>)ois.readObject();
			//System.out.println("ConnexioComandament > llegeixMonstresArray (OK)");
		}catch(Exception e){
			System.out.println("ConnexioComandament > llegeixMonstresArray (FAIL)");
		}
		return alcm;
	}
	
	/*public void enviaMonstres(Monstre mon){
		try{
			//oos = new ObjectInputStream();
			//dos.writeObject(mon);
			oos.flush();
		}catch(Exception e){}
	}*/

}