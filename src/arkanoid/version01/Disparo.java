package arkanoid.version01;

import java.awt.Graphics;

public class Disparo extends Actor {

	protected int vY = 0;
	
	/**
	 * Constructor
	 * @param x
	 * @param y
	 */
	public Disparo(int x, int y, String sprite) {
		
		super(x, y);
		
		this.spriteActual = SpriteCache.getSpriteCache().getSprite(sprite + ".png");
		this.ancho = this.spriteActual.getWidth();
		this.alto = this.spriteActual.getHeight();
		
		if (sprite.equals("Disparo")) {
			
			this.vY = 5;
			
		}
		else {
			
			this.vY = -5;
			
		}
	}
	
	
	/**
	 * Metodo actua
	 */
	
	public void actua() {
		
		this.posY -= vY;
		
		if (this.posY < 0) this.setBorrar(true);
		
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

