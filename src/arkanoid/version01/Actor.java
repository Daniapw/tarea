package arkanoid.version01;

import java.awt.Rectangle;

public class Actor {

	private int posX, posY, ancho, alto;
	private boolean borrar = false;
	
	/**
	 *  
	 * @param posX
	 * @param pos
	 */
	
	//Constructor
	public Actor(int posX, int posY) {
		
		super();
		this.posX = posX;
		this.posY = posY;
		
	}
	
	/**
	 * 
	 */
	
	//Metodo que ejecutaran los actores
	public void actua() {}
	
	/**
	 * 
	 */
	
	//Metodo que cambiara el objeto si colisiona
	public void colision() {}
	
	/**
	 *
	 */
	//Getter para el color
	public String getColor() {return "";}
	
	/**
	 * 
	 * @return
	 */
	
	//Metodo que devuelve el rectangulo que encapsula al actor
	public Rectangle getMedidas() {
		
		return new Rectangle(posX, posY, ancho, alto);
	
	}
	
	/**
	 * 
	 */
	
	//Getters y Setters
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
	
	
}
