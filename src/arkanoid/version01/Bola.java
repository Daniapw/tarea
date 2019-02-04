package arkanoid.version01;

import java.awt.Graphics;

public class Bola extends Actor {
	private int vX = 0, vY = 0;
	private long tiempoCreacion;

	protected static final int DIAMETRO = 20;
	
	/**
	 * Constructor
	 * @param posX
	 * @param posY
	 * @param vX
	 * @param vY
	 */
	
	public Bola(int posX, int posY) {
		super(posX, posY);
		
		this.ancho = DIAMETRO;
		this.alto = DIAMETRO;
		this.tiempoCreacion = System.currentTimeMillis();
		this.spriteActual = SpriteCache.getSpriteCache().getSprite("bola.png");

		
	}
	
	/**
	 *  Metodo que hace que la bola se mueva
	 * @param ancho
	 * @param alto
	 * @param vX
	 * @param vY
	 */
	
	public void actua() {
		
		//Al comienzo del juego se inicia el movimiento de la pelota
		if (!Arkanoid.juegoEmpezado) iniciarMovimiento();
		
		//Si la posicion X de la bola es superior al ancho de la pantalla cambiar� de direcci�n, es decir, se invertir� el signo de vX
		if (this.posX + DIAMETRO >= Arkanoid.ANCHO) {
			
			this.vX =  -vX;
			
		}
		else {
			
			if (this.posX < 0) {
				
				this.vX = Math.abs(vX);
				
			}
			
		}
		
		//Lo mismo con la posicion Y
		if (this.posY + DIAMETRO >= Arkanoid.ALTO) {
			
			this.vY = -vY;
			
		}
		else {
			
			if (this.posY < 0) {
				
				this.vY = Math.abs(vY);
				
			}
			
		}
		
		
		this.posX += vX;
		
		this.posY += vY;	
	

		
	}
	
	/**
	 * Metodo que inicia el movimiento de la bola tras 5 segundos
	 */
	public void iniciarMovimiento() {
		
		long tiempoActual = System.currentTimeMillis();
		
		if ((tiempoActual - tiempoCreacion)/1000 >= 5 || Arkanoid.lanzarBola) {
			
			this.vX = 4;
			this.vY = -4;
			Arkanoid.juegoEmpezado = true;
			
		}
		
	}
	
	/**
	 * Metodo paint
	 */
	
	public void paint(Graphics g) {
		
		g.drawImage(this.getSprite(), this.posX, this.posY, null);
		
	}
	
	/**
	 * Metodo que gestiona las colisiones
	 */
	
	public void colision() {
		
		this.vY = -vY;
		
	}


}
