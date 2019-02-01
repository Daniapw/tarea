package arkanoid.version01;

public class Bola extends Actor {
	private int vX, vY;
	
	/**
	 * Constructor
	 * @param posX
	 * @param posY
	 * @param vX
	 * @param vY
	 */
	
	public Bola(int posX, int posY, int vX, int vY) {
		super(posX, posY);
		this.vX = vX;
		this.vY = vY;
		
		this.spriteActual = SpriteCache.getSpriteCache().getSprite("bola.png");
		this.setAlto(this.spriteActual.getHeight());
		this.setAncho(this.spriteActual.getWidth());
	}
	
	/**
	 *  Metodo que hace que la bola se mueva
	 * @param ancho
	 * @param alto
	 * @param vX
	 * @param vY
	 */
	
	public void actua() {
		
		//Si la posicion X de la bola es superior al ancho de la pantalla cambiar� de direcci�n, es decir, se invertir� el signo de vX
		if (this.posX + this.getAncho() >= Arkanoid.ANCHO) {
			
			this.vX =  -vX;
			
		}
		else {
			
			if (this.posX < 0) {
				
				this.vX = Math.abs(vX);
				
			}
			
		}
		
		//Lo mismo con la posicion Y
		if (this.posY + this.getAncho() >= Arkanoid.ALTO) {
			
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
	 * Metodo que gestiona las colisiones
	 */
	
	public void colision() {
		
		this.vY = -vY;
		
	}


}
