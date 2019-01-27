package arkanoid.version01;

public class Ladrillo extends Actor {
	public String color;
	private int alto = 8, ancho = 10;
	
	//Constructor
	public Ladrillo(int posX, int posY, String color) {
		super(posX, posY);
		
		this.color = color;
	}

	
	
}
