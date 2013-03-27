package Connexio;

import java.util.ArrayList;

import Controlador.ConjuntMonstres;

public class ThreadRebre implements Runnable {

	private ConjuntMonstres cm;
	private ConjuntMonstres cm2;
	private ConnexioComandament cc;
	ArrayList<ConjuntMonstres> alcm;
	
	public ThreadRebre(ConnexioComandament cc){
		this.cm = null;
		this.cm2 = null;
		this.cc = cc;
		this.alcm = null;
	}
	
	public void run(){
		while(true){
			try{
				//agafem els dos conjunts de monstres mitanant un arrayList
				alcm = cc.llegeixMonstresArray();
				System.out.println("1=>"+alcm.get(0).quantsMonstres());
				System.out.println("2=>"+alcm.get(1).quantsMonstres());
				this.cm = alcm.get(0);
				this.cm2 = alcm.get(1);
				//System.out.println("ThreadRebre > Llegin... (OK)");
				Thread.sleep(100);
			}catch(Exception e){
				System.out.println("ThreadRebre > Llegin... (FAIL)");
			}
		}	
	}
	/*
	public Vector<Monstre> repMonstres(){
		Vector<Monstre> cm = null;
		try{
			//ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			cm = (Vector<Monstre>)ois.readObject();
			System.out.println("Rebut!");
			//System.out.println(cm.size());
			//System.out.println(cm.elementAt(0).getX());
			ois.close();
		}catch(Exception e){
			//e.printStackTrace();
			System.out.println("No rebut");
		}
		
		//System.out.println(cm.size());
		return cm;
	}*/
	public void start(){
    	new Thread(this).start();
    }
	
	public ConjuntMonstres getConjuntMonstres(){
		return cm;
	}
	
	public ConjuntMonstres getConjuntMonstres2(){
		return cm2;
	}
}
