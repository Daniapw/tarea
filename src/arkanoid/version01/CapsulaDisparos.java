package arkanoid.version01;

public class CapsulaDisparos extends Capsula{
	/**
	 * Constructor
	 * @param x
	 * @param y
	 */
	
	public CapsulaDisparos (int x, int y) {
		
		super(x,y);
		
		this.spriteActual = SpriteCache.getSpriteCache().getSprite("BurbujaDisparos.png");
		this.ancho = this.spriteActual.getWidth();
		this.alto = this.spriteActual.getHeight();
		this.duracion = 10;
	}
	
	/**
	 * Implementacion del metodo abstracto efecto()
	 */
	
	public void efecto() {
		
		CacheSonido.getCacheSonido().reproducirSonido("SonidoPowerUp.wav");
		Arkanoid.getInstancia().nave.activarEfecto(SpriteCache.getSpriteCache().getSprite("VausDisparos.png"), System.currentTimeMillis(), duracion);
		Arkanoid.getInstancia().nave.disparosActivos = true;
	}
}
