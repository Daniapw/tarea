package arkanoid.version01;

import java.awt.Graphics;

public class Ladrillo extends Actor {
	protected String color;
	protected int vidas = 1;
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
	
		if (color.equals("rompible")) this.vidas = 2;
		
		if (color.equals("irrompible")) this.vidas = -1;
		
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
		
		switch (this.vidas) {
		
			case 1:{
				
				CacheSonido.getCacheSonido().reproducirSonido("SonidoChoqueLadrillo.wav");
				vidas--;
				this.setBorrar(true);
				break;
				
			}
			
			case 2:{
				
				CacheSonido.getCacheSonido().reproducirSonido("SonidoRompible.wav");
				
				this.spriteActual = SpriteCache.getSpriteCache().getSprite("rompible2.png");
				
				vidas--;
				
				break;
				
			}
			
			case -1:{
				
				CacheSonido.getCacheSonido().reproducirSonido("SonidoIrrompible.wav");
				
				break;
			}
		
		}
		
	}
	
}
