package Vista;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

class PanellTitol extends JPanel
{
	public void paintComponent (Graphics painter){

		Image pic = Toolkit.getDefaultToolkit().getImage("img/titol.png");
		if(pic != null) painter.drawImage(pic, 15, 5, this);     //create image

	}
}