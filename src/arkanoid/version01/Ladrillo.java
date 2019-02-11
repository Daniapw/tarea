package arkanoid.version01;

import java.awt.Graphics;

public class Ladrillo extends Actor {
	protected String color, tipo;
	protected static final int ESPACIO_ENTRE_LADRILLOS = 1;
	
	protected boolean golpeado = false;
	
	/**
	 * Constructor
	 * @param posX
	 * @param posY
	 * @param color
	 */
	
	public Ladrillo(int posX, int posY,String color) {
		super(posX, posY);
		
		this.color = color;
		
		if (!color.equals("rompible") && !color.equals("irrompible")) {
			
			this.tipo = "normal";
			
		}else {
			
			if (color.equals("rompible")) this.tipo = "rompible";
			
			if (color.equals("irrompible")) this.tipo = "irrompible";
			
		}
		
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
		
		switch (this.tipo) {
		
			case "normal":{
				
				CacheSonido.getCacheSonido().reproducirSonido("SonidoChoqueLadrillo.wav");
				this.setBorrar(true);
				break;
			}
			
			case "rompible":{
				
				if (!this.golpeado) {
					
					CacheSonido.getCacheSonido().reproducirSonido("SonidoRompible.wav");
					
					this.spriteActual = SpriteCache.getSpriteCache().getSprite("rompible2.png");
					
					this.golpeado = true;
					
				}
				else {
					
					CacheSonido.getCacheSonido().reproducirSonido("SonidoChoqueLadrillo.wav");
					this.setBorrar(true);
					
				}
				
				break;
				
			}
			
			case "irrompible":{
				
				CacheSonido.getCacheSonido().reproducirSonido("SonidoIrrompible.wav");
				
				break;
			}
		
		}
		
		
	}

	
	
}
