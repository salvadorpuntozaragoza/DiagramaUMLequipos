package Paneles;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MenuJuego extends JPanel {

	/**
	 * Create the panel.
	 */
	public MenuJuego() {

	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		ImageIcon image = new ImageIcon("images/main_menu.jpg");
		int x = getWidth()/2 - image.getIconWidth()/2;
		int y = getHeight()/2 - image.getIconHeight()/2;
		g.drawImage(image.getImage(),x,y,this);
		
	}

}
