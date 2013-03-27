package Controlador;

import java.util.Vector;

public class ConjuntGels {
	
	private Vector<Gel> gels;
	
	public ConjuntGels(){
		gels = new Vector();
	}
	
	public void afegeixGel(Gel nouGel){
		gels.addElement(nouGel);
		
	}
	public Vector<Gel> getMonstres(){
		return gels;
	}
	
	/*public void run(){
		while(true){
			try{
				comprovaMonstres();
				Thread.sleep(100);
			}catch(Exception e){
				
			}
		}	
	}

	public void start(){
    	new Thread(this).start();
    }*/
}
