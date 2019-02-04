package arkanoid.version01;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Ladrillo extends Actor {
	protected String color;
	protected static final int ESPACIO_ENTRE_LADRILLOS = 12;
	
	
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
	 * Metodo paint
	 */
	
	public void paint(Graphics g) {
		
		//Rectangulo
		g.setColor(Color.decode(this.color));
		g.fillRect(this.posX, this.posY, this.ancho, this.alto);
		
		//Borde
		g.setColor(Color.black);
		g.drawRect(this.posX, this.posY, this.ancho, this.alto);
		
	}
	
	/**
	 * Metodo que gestiona la colision
	 */
	
	public void colision() {
		
		this.setBorrar(true);
		CacheSonido.getCacheSonido().reproducirSonido("SonidoChoqueLadrillo.wav");
	}

	
	
}
