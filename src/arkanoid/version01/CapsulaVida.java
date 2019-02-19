package arkanoid.version01;

public class CapsulaVida extends Capsula{

	/**
	 * Constructor
	 * @param x
	 * @param y
	 */
	
	public CapsulaVida (int x, int y) {
		
		super(x,y);
		
		this.spriteActual = SpriteCache.getSpriteCache().getSprite("BurbujaVida.png");
		this.ancho = this.spriteActual.getWidth();
		this.alto = this.spriteActual.getHeight();

	}
	
	/**
	 * Implementacion del metodo abstracto efecto()
	 */
	
	public void efecto() {
		
		CacheSonido.getCacheSonido().reproducirSonido("SonidoPowerUp.wav");
		
		if (Arkanoid.getInstancia().nave.intentos < 3) Arkanoid.getInstancia().nave.intentos++;
	}
}
