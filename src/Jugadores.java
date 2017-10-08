public class Jugadores extends Equipos {

	/**
	 * Habilidad especial de cada jugador
	 */
	private String HabSpecial;
	private int Salud;
	private int x,y,height,weight;

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