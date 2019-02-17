package arkanoid.version01;

public class CapsulaShrink extends Capsula {

	/**
	 * Constructor
	 * @param x
	 * @param y
	 */
	
	public CapsulaShrink (int x, int y) {
		
		super(x,y);
		
		this.spriteActual = SpriteCache.getSpriteCache().getSprite("BurbujaShrink.png");
		this.ancho = this.spriteActual.getWidth();
		this.alto = this.spriteActual.getHeight();
		this.duracion = 10;
	}
	
	/**
	 * Implementacion del metodo abstracto efecto()
	 */
	
	public void efecto() {
		
		CacheSonido.getCacheSonido().reproducirSonido("SonidoPowerDown.wav");
		Arkanoid.getInstancia().nave.activarEfecto(SpriteCache.getSpriteCache().getSprite("miniVaus.png"), System.currentTimeMillis(), duracion);
		
	}
	
}
