package arkanoid.version01;

import java.awt.Graphics;

/**
 * Clase que representa las capsulas que caeran a veces de los ladrillos al explotar
 * @author Equipo
 *
 */

public abstract class Capsula extends Actor {

	protected int vY = 3;
	protected int duracion;
	
	/**
	 * Constructor
	 * @param x
	 * @param y
	 */
	
	public Capsula(int x, int y) {
		
		super(x,y);

	}
	
	/**
	 * Metodo actua (override de actor)
	 */
	
	public void actua() {
		
		this.posY += vY;
		
	}
	
	/**
	 * Metodo colision
	 */
	
	public void colision() {
		
		this.setBorrar(true);
		this.efecto();
	}
	
	/**
	 * Metodo paint
	 */
	
	public void paint(Graphics g) {
		
		g.drawImage(this.spriteActual, this.posX, this.posY, null);
		
	}
	
	/**
	 * Metodo abstracto que ejecutara el efecto
	 */
	
	public abstract void efecto();
}
