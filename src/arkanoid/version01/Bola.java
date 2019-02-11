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
	
		if (this.vX < 6) this.vX *= 1.00010f;

		if (this.vY < 6) this.vY *= 1.00010f;
		
	}
	
	/**
	 * Metodo que inicia el movimiento de la bola tras 5 segundos
	 */
	public void iniciarMovimiento() {
		
		this.posX = Arkanoid.getInstancia().nave.posX + (Arkanoid.getInstancia().nave.ancho/2);
		this.posY = Arkanoid.getInstancia().nave.posY - Bola.DIAMETRO - 1;
		
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
			
			colisionConLadrillo(actor);
			
		}
		else {
			
			if (actor instanceof Nave) {
				
				colisionConNave(actor);
				
			}
			
		}
	}
	
	/**
	 * Colision con nave
	 * @param nave
	 */
	public void colisionConNave(Actor nave) {
		
		if (this.posX > nave.posX && this.posX < (nave.posX +5)) {
			
			this.posX = nave.posX - Bola.DIAMETRO - 1;
			
			this.vX = -vX;
		}
		
		if (this.posX < (nave.posX + nave.ancho) && this.posX > (nave.posX + nave.ancho - 5)) {
			
			this.posX = (nave.posX + nave.ancho) + 1;
			
			this.vX = -vX;
		}
		
		this.vY = -vY;
		


	}

	/**
	 * Colision con ladrillo
	 * @param actor
	 */
	public void colisionConLadrillo(Actor actor) {
		
		if (this.posX + DIAMETRO/2 > actor.posX && this.posX + DIAMETRO/2 < actor.posX + 5) {
			
			this.posX = actor.posX - DIAMETRO - 1;
			vX = -vX;

		}
		else {
			
			if (this.posX + DIAMETRO/2 < (actor.posX + actor.ancho) && this.posX + DIAMETRO/2 > (actor.posX + actor.ancho) - 5 ) {
				
				this.posX = actor.posX + actor.ancho + 1;
				vX = -vX;

			}
		}
		
		this.vY = -vY;
		
	}
	
	
}
