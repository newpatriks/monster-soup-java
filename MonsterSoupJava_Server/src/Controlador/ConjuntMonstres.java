package Controlador;


import java.io.Serializable;
import java.util.Vector;

public class ConjuntMonstres implements Serializable {
	
	private Vector<Monstre> monstres;
	//private PanellMonstres pM;
	private static final long serialVersionUID = -6733656002916532753L;
	
	public ConjuntMonstres(){
		monstres = new Vector();
		//pM = panell;
	}
	
	public void afegeixMon(Monstre nouMon){
		monstres.addElement(nouMon);
		
	}
	public Vector<Monstre> getMonstres(){
		return monstres;
	}
	public void setMonstres(Vector<Monstre> m){
		for (int i = 0; i < m.size(); i++){
			monstres.add(m.elementAt(i));
		}
	}
	public int quantsMonstres() {
		return monstres.size();
	}
	
	
	
	
	/*
	public void run(){
		while(true){
			try{
				comprovaMonstres();
				Thread.sleep(100);
			}catch(Exception e){
				
			}
		}	
	}
	
	public void comprovaMonstres(){
		Gel gel;
		for(int i = 0; i < monstres.size(); i++){
			if(!(monstres.elementAt(i).viu())){
				monstres.elementAt(i).setVisible(false);
				gel = new Gel(monstres.elementAt(i).getX());
				monstres.removeElementAt(i);
				//pM.afegeixGel(gel);
			}
		}
		//System.out.println(monstres.size());
	}
	public void start(){
    	new Thread(this).start();
    }
	*/
	
}
