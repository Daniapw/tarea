package arkanoid.version01;

import java.awt.Graphics;

public class Ladrillo extends Actor {
	protected String color;
	protected static final int ESPACIO_ENTRE_LADRILLOS = 1;
	
	
	/**
	 * Constructor
	 * @param posX
	 * @param posY
	 * @param color
	 */
	
	public Ladrillo(int posX, int posY,String color) {
		super(posX, posY);
		
		this.color = color;
		
		this.spriteActual = SpriteCache.getSpriteCache().getSprite(color + ".png");
		
		this.alto = spriteActual.getHeight();
		this.ancho = spriteActual.getWidth();
	}

	/**
	 * Metodo paint
	 */
	
	public void paint(Graphics g) {
		
		g.drawImage(this.spriteActual, this.posX, this.posY, null);
		
	}
	
	/**
	 * Metodo que gestiona la colision
	 */
	
	public void colision() {
		
		this.setBorrar(true);
		CacheSonido.getCacheSonido().reproducirSonido("SonidoChoqueLadrillo.wav");
	}

	
	
}
