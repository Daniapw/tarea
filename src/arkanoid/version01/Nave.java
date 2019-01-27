package arkanoid.version01;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;

public class Nave extends Actor {
	
	private int vX = 2;
	
	/**
	 * 
	 * @param posX
	 * @param posY
	 * @param vX
	 * @param vY
	 */
	public Nave(int posX, int posY) {
		super(posX, posY);

	}
	
	public void actua() {
		

		
		
	}

	//Getters y setters
	public int getvX() {
		return vX;
	}

	public void setvX(int vX) {
		this.vX = vX;
	}

	
	
	
}
