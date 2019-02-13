package arkanoid.version01;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Actor {

	protected int posX, posY, ancho, alto;
	protected BufferedImage spriteActual;
	private boolean borrar = false;
	private String tipo;
	
	/**
	 *  Constructor
	 * @param posX
	 * @param pos
	 */
	
	public Actor(int posX, int posY) {
		super();
		this.posX = posX;
		this.posY = posY;
		this.spriteActual = null;
		
		
	}
	
	/**
	 * Metodo que ejecutaran los actores
	 */
	
	public void actua() {}
	
	/**
	 * Metodo que cambiara el objeto si colisiona
	 */
	
	public void colision() {}
	

	
	/**
	 * Metodo que devuelve el rectangulo que encapsula al actor
	 * @return
	 */
	
	public Rectangle getMedidas() {
		
		return new Rectangle(posX, posY, ancho, alto);
	
	}

	/**
	 * Metodo paint que sobreescribiran los actores
	 * @param g
	 */
	
	public void paint(Graphics g) {	}
	
	/**
	 * Getters y Setters
	 */
	
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
	public int getAncho() {
		return ancho;
	}
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	public int getAlto() {
		return alto;
	}
	public void setAlto(int alto) {
		this.alto = alto;
	}

	public boolean isBorrar() {
		return borrar;
	}

	public void setBorrar(boolean borrar) {
		this.borrar = borrar;
	}

	public BufferedImage getSprite() {
		return spriteActual;
	}

	public void setSprite(BufferedImage sprite) {
		this.spriteActual = sprite;
	}
	
	
	
}
