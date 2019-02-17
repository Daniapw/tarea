package arkanoid.version01;

public class CapsulaAgrandar extends Capsula{
	
	/**
	 * Constructor
	 * @param x
	 * @param y
	 */
	
	public CapsulaAgrandar(int x, int y) {
		
		super(x, y);
		
		this.spriteActual = SpriteCache.getSpriteCache().getSprite("BurbujaGrande.png");
		this.ancho = this.spriteActual.getWidth();
		this.alto = this.spriteActual.getHeight();
		this.duracion = 10;
	}
	
	/**
	 * Implementacion del metodo abstracto efecto()
	 */
	
	public void efecto() {
		
		CacheSonido.getCacheSonido().reproducirSonido("SonidoPowerUp.wav");
		
		Arkanoid.getInstancia().nave.activarEfecto(SpriteCache.getSpriteCache().getSprite("vausGrande.png"), System.currentTimeMillis(), duracion);
		
	}
}
