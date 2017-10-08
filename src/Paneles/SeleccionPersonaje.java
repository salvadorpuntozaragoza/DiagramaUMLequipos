package Paneles;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class SeleccionPersonaje extends JPanel {

	/**
	 * Create the panel.
	 */
	private ImageIcon image = new ImageIcon("images/Select_char_soldier.jpg");
	private String opcion = "Soldier";
	private ImageIcon spray = new ImageIcon("images/spray_soldier76.png");
	

	public SeleccionPersonaje() {

	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		int x = getWidth()/2 - image.getIconHeight()/2;
		int y = getHeight()/2 - image.getIconHeight()/2;
		
		g.drawImage(image.getImage(), x, y, this);
	}

	public String getOpcion() {
		return opcion;
	}

	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}

	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}
	
	public ImageIcon getSpray() {
		return spray;
	}

	public void setSpray(ImageIcon spray) {
		this.spray = spray;
	}
	
	

}
