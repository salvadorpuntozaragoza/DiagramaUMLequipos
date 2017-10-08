import java.io.Serializable;

public class Jugadores extends Equipos implements Serializable {

	/**
	 * Habilidad especial de cada jugador
	 */
	private String HabSpecial;
	protected int Salud;
	protected int x,y,height,weight;
	protected int speed;
	
	public Jugadores(){
		x = 100;
		y = 100;
		height = 150;
		weight = 150;
	}
	
	public int getSalud() {
		return Salud;
	}

	public void setSalud(int salud) {
		Salud = salud;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}


	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public void correr() {
		// TODO - implement Jugadores.correr
		throw new UnsupportedOperationException();
	}

	public void disparar() {
		// TODO - implement Jugadores.disparar
		throw new UnsupportedOperationException();
	}

}