package Controlador;

import java.util.Vector;

import javax.swing.JPanel;

import Connexio.ThreadRebre;
import Vista.DibuixaMonstre;
import Vista.DibuixaMonstre2;
import Vista.EscenariEnemic;
import Vista.EscenariJugador;
import Vista.FinestraPpal;
import Vista.PanellMonstres;
import Vista.VistaJoc;

public class ControlEscenari implements Runnable{
	private EscenariJugador escJ;
	private EscenariEnemic escE;
	private PanellMonstres p1;
	private PanellMonstres p2;
	private ThreadRebre tr;
	private FinestraPpal fin;
	private VistaJoc vj;
	private Vector<Monstre> monstres;
	private Vector<Monstre> vec_mon; 
	private DibuixaMonstre2 dm;
	private Vector<DibuixaMonstre2> dMonstres;
	private ConjuntMonstres cm;
	private DibuixaMonstre prova;
	
	public ControlEscenari(ThreadRebre tr, FinestraPpal fin){
		this.start();
		
		monstres = new Vector();
		dMonstres = new Vector();
		this.tr = tr;
		this.fin = fin;
		vj = new VistaJoc();
		vj.setLocation(150,100);

		// Creem dos panells de monstres un per cada jugador
		p1 = new PanellMonstres(this.fin);
		p2 = new PanellMonstres(this.fin);
		
		escJ = new EscenariJugador();
		escE = new EscenariEnemic();
		
		escJ.add(p1);
		escE.add(p2);
		
		escJ.setLocation(100, 0);
		escE.setLocation(400, 0);
		
		vj.add(escJ);
		vj.add(escE);
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try{
				actualitzaMonstres();
				actualitzaMonstres2();
				Thread.sleep(100);
			}catch(Exception e){
				
			}
		}	
	}
	
	public void actualitzaMonstres(){
		cm = tr.getConjuntMonstres();
		vec_mon = cm.getMonstres();
		//System.out.println("Num Monstres vista: "+ monstres.size());
		// Bucle per comparar els monstres antics amb els nous
		// Si no troba el monstre antic al vector nou, Žs que ja no existeix
		
		//System.out.println("Num Monstres nou: "+monstres.size() );
		//System.out.println("Num Monstres antic: "+vec_mon.size() );
		
		for (int i = monstres.size()-1; i>= 0; i--){
			//System.out.println(" 1 (bucle per borrar els que ja no hi son) ");
			boolean monstreExisteix = false;
			for (int j = 0; j< vec_mon.size(); j++){
				if(monstres.elementAt(i).getID() == vec_mon.elementAt(j).getID()){
					monstreExisteix = true;
				}
			}
			if (!monstreExisteix){
				monstres.remove(i);
				dMonstres.remove(i);
				// caldria borrar-lo de l'escenari
			} else{
				// Si el monstre hi Žs, el movem cap a dalt
				monstres.elementAt(i).setY(vec_mon.elementAt(getPosicioMonstreVector(i)).getY());
				dMonstres.elementAt(i).setY(vec_mon.elementAt(getPosicioMonstreVector(i)).getY());
				//dMonstres.elementAt(i).repaint();
				//p1.repaint();
			}
		}
		
		
		// Bucle per afegir els nous monstres
		// Si no troba el monstre nou al antic es que el monstre ha aparegut
		for (int i = 0; i< vec_mon.size(); i++){
			//System.out.println(" 2 (bucle per afegir els nous monstres) ");
			boolean monstreExisteix = false;
			for (int j = 0; j< monstres.size(); j++){
				if(monstres.elementAt(j).getID() == vec_mon.elementAt(i).getID()){
					monstreExisteix = true;
				}
			}
			if (!monstreExisteix){
				monstres.add(vec_mon.elementAt(i));
				// Aqu’ tambŽ l'haur’em d'afegir al panell
				dm = new DibuixaMonstre2(monstres.elementAt(monstres.size()-1));
				
				System.out.println(p1.getComponentCount());
				p1.afegeixMonstre(dm);
				
				dMonstres.add(dm);
			}
		}
		/*
		for (int z = 0; z<p1.getComponentCount(); z++){
			//System.out.println(" 3 (pintem de nou) ");
			p1.getComponent(z).repaint();
			p1.getComponent(z).setVisible(true);
			p1.repaint();
		}*/
		
	}
	
	public void actualitzaMonstres2(){
		cm = tr.getConjuntMonstres2();
		vec_mon = cm.getMonstres();
		//System.out.println("Num Monstres vista: "+ monstres.size());
		// Bucle per comparar els monstres antics amb els nous
		// Si no troba el monstre antic al vector nou, Žs que ja no existeix
		
		//System.out.println("Num Monstres nou: "+monstres.size() );
		//System.out.println("Num Monstres antic: "+vec_mon.size() );
		
		for (int i = monstres.size()-1; i>= 0; i--){
			//System.out.println(" 1 (bucle per borrar els que ja no hi son) ");
			boolean monstreExisteix = false;
			for (int j = 0; j< vec_mon.size(); j++){
				if(monstres.elementAt(i).getID() == vec_mon.elementAt(j).getID()){
					monstreExisteix = true;
				}
			}
			if (!monstreExisteix){
				monstres.remove(i);
				dMonstres.remove(i);
				// caldria borrar-lo de l'escenari
			} else{
				// Si el monstre hi Žs, el movem cap a dalt
				monstres.elementAt(i).setY(vec_mon.elementAt(getPosicioMonstreVector(i)).getY());
				dMonstres.elementAt(i).setY(vec_mon.elementAt(getPosicioMonstreVector(i)).getY());
				//dMonstres.elementAt(i).repaint();
				//p1.repaint();
			}
		}
		
		
		// Bucle per afegir els nous monstres
		// Si no troba el monstre nou al antic es que el monstre ha aparegut
		for (int i = 0; i< vec_mon.size(); i++){
			//System.out.println(" 2 (bucle per afegir els nous monstres) ");
			boolean monstreExisteix = false;
			for (int j = 0; j< monstres.size(); j++){
				if(monstres.elementAt(j).getID() == vec_mon.elementAt(i).getID()){
					monstreExisteix = true;
				}
			}
			if (!monstreExisteix){
				monstres.add(vec_mon.elementAt(i));
				// Aqu’ tambŽ l'haur’em d'afegir al panell
				dm = new DibuixaMonstre2(monstres.elementAt(monstres.size()-1));
				
				System.out.println(p1.getComponentCount());
				p1.afegeixMonstre(dm);
				
				dMonstres.add(dm);
			}
		}
		/*
		for (int z = 0; z<p1.getComponentCount(); z++){
			//System.out.println(" 3 (pintem de nou) ");
			p1.getComponent(z).repaint();
			p1.getComponent(z).setVisible(true);
			p1.repaint();
		}*/
		
	}
	
	public int getPosicioMonstreVector(int i) {
		int aux = 0;
		for (int j=0;j<vec_mon.size();j++){
			if (monstres.elementAt(i).getID() == vec_mon.elementAt(j).getID()) {
				//trobat
				aux = j;
			}else{
				//no trobat
			}
		}
		return aux;
	}
	
	public VistaJoc getVistaJoc(){
		return vj;
	}
	
	public void start(){
    	new Thread(this).start();
    }
	
}
