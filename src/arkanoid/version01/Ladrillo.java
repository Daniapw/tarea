package arkanoid.version01;

public class Ladrillo extends Actor {
	public String color;
	
	/**
	 * Constructor
	 * @param posX
	 * @param posY
	 * @param color
	 */
	
	public Ladrillo(int posX, int posY,String color) {
		super(posX, posY);
		
		this.color = color;
		
		this.setAncho(42);
		this.setAlto(22);
	}

	/**
	 * Metodo que gestiona la colision
	 */
	
	public void colision() {
		
		this.setBorrar(true);
		
	}
	
	/**
	 * Getters y setters
	 */
	
	public String getColor() {
		
		return color;
		
		
	}

	
	
}
