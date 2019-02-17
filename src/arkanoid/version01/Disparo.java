package arkanoid.version01;

import java.awt.Graphics;

public class Disparo extends Actor {

	protected int vY = 5;
	
	/**
	 * Constructor
	 * @param x
	 * @param y
	 */
	public Disparo(int x, int y) {
		
		super(x, y);
		
		this.spriteActual = SpriteCache.getSpriteCache().getSprite("Disparo.png");
		this.ancho = this.spriteActual.getWidth();
		this.alto = this.spriteActual.getHeight();
		
	}
	
	/**
	 * Metodo actua
	 */
	
	public void actua() {
		
		this.posY -= vY;
		
	}
	
	/**
	 * Metodo paint
	 */
	
	public void paint(Graphics g) {
		
		g.drawImage(this.spriteActual, posX, posY, null);
		
	}
	
	/**
	 * Metodo colision
	 */
	
	public void colision() {
		
		this.setBorrar(true);
		
	}
	
}

