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
		
		this.setAlto(20);
		this.setAncho(20);
	}
	
	/**
	 *  Metodo que hace que la bola se mueva
	 * @param ancho
	 * @param alto
	 * @param vX
	 * @param vY
	 */
	
	public void actua(int ancho, int alto) {
		
		//Si la posicion X de la bola es superior al ancho de la pantalla cambiar� de direcci�n, es decir, se invertir� el signo de vX
		if (this.getPosX() + 20 > ancho) {
			
			this.vX =  -vX;
			
		}
		else {
			
			if (this.getPosX() < 0) {
				
				this.vX = Math.abs(vX);
				
			}
			
		}
		
		//Lo mismo con la posicion Y
		if (this.getPosY() +50 > alto) {
			
			this.vY = -vY;
			
		}
		else {
			
			if (this.getPosY() < 0) {
				
				this.vY = Math.abs(vY);
				
			}
			
		}
		
		
		this.setPosX(this.getPosX() + this.vX);
		
		this.setPosY(this.getPosY() + this.vY);		
	
	}
	
	/**
	 * Metodo que gestiona las colisiones
	 */
	public void colision() {
		
		this.vY = -vY;
		
	}


}
