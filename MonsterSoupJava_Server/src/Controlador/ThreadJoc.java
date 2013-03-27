package Controlador;

import java.util.Vector;


public class ThreadJoc implements Runnable {
	
	private ConjuntMonstres cm;
	private Vector<Monstre> monstres;
	
	public ThreadJoc(ConjuntMonstres cm){
		this.cm = cm;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try{
				actualitzaJoc();
				Thread.sleep(100);
			}catch(Exception e){
				
			}
		}	
	}
	
	public void actualitzaJoc(){
		// Recuperem els monstres que hi ha actualment
		monstres = cm.getMonstres();
		
		for(int i = 0; i < monstres.size(); i++){
			// Comprovem si han arribat a dalt de tot
			if(!(monstres.elementAt(i).viu())){
				monstres.elementAt(i).setVisible(false);
				//gel = new Gel(monstres.elementAt(i).getX());
				
				// Eliminem si ha arribat a dalt de tot
				monstres.removeElementAt(i);
				
				System.out.println("Un monstre ha arribat a dalt");
			}else{
				// Si no, movem el monstre cap a dalt
				monstres.elementAt(i).mou();
			}
		}
	}
	public void start(){
    	new Thread(this).start();
    }
	
}
