package arkanoid.version01;

public class Actor {

	private int posX, posY;
	
	/**
	 *  
	 * @param posX
	 * @param pos
	 */
	//Constructor
	public Actor(int posX, int posY) {
		
		super();
		this.posX = posX;
		this.posY = posY;
		
	}

	//Metodo que ejecutaran los actores
	public void actua() {};
	/**
	 * 
	 */
	//Getters y Setters
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	
}
