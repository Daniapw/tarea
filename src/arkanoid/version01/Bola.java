package arkanoid.version01;

import java.awt.Graphics;

public class Bola extends Actor {
	private float vX = 0, vY = 0;
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
		if (!Arkanoid.getInstancia().juegoEmpezado) iniciarMovimiento();
		
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
		
		this.posX = Arkanoid.getInstancia().nave.posX + (Arkanoid.getInstancia().nave.ancho/2);
		this.posY = Arkanoid.getInstancia().nave.posY - Bola.DIAMETRO;
		
		long tiempoActual = System.currentTimeMillis();
		
		if ((tiempoActual - tiempoCreacion)/1000 >= 5 || Arkanoid.getInstancia().lanzarBola) {
			
			CacheSonido.getCacheSonido().reproducirSonido("SonidoDespegueBola.wav");
			
			this.vX = 3;
			this.vY = 3;
			Arkanoid.getInstancia().juegoEmpezado = true;
			
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
	
	public void colision(Actor actor) {
		
		if (actor instanceof Ladrillo) {
			
			this.vX *= 1.010;
			this.vY *= 1.010;
			
		}
		
		if (actor instanceof Nave) {
			
			this.vX *= 1.005;
			this.vY *= 1.005;
			
		}
		
		this.vY = -vY;
		

	}


}
