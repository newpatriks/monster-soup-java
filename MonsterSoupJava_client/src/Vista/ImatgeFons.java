package Vista;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class ImatgeFons extends JLabel implements Runnable{

    private Image image;

    private int posY;
    public ImatgeFons(int posicioY) {
    	super(new ImageIcon("img/fons.jpg"));
    	posY=posicioY;
    	setSize(1100, 750);
    }
    @Override
    public void run(){
		while(true){
			try{
				mou();
				Thread.sleep(100);
			}catch(Exception e){
				
			}
		}
		
	}
    public void mou(){
    	if(posY<-700){
    		posY = 670;
    	} else {
    		posY--;
    	}
		setLocation(0,posY);
	}
    public void start(){
    	new Thread(this).start();
    }
    public void stop(){
    	new Thread(this).stop();
    }
}

