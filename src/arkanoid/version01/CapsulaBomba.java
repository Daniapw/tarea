package arkanoid.version01;

public class CapsulaBomba extends Capsula {

	/**
	 * Constructor
	 * @param x
	 * @param y
	 */
	
	public CapsulaBomba(int x, int y) {
		
		super(x, y);
		
		this.spriteActual = SpriteCache.getSpriteCache().getSprite("bomba.png");
		this.ancho = this.spriteActual.getWidth();
		this.alto = this.spriteActual.getHeight();
		
	}
	
	/**
	 * Implementacion del metodo abstracto efecto()
	 */
	
	public void efecto() {
		
		this.setBorrar(true);
		Arkanoid.getInstancia().actoresEspeciales.add(new Explosion(this.posX, this.posY));
		CacheSonido.getCacheSonido().reproducirSonido("ExplosionBomba.wav");
		Arkanoid.getInstancia().nave.naveAlcanzada = true;
		Arkanoid.getInstancia().nave.intentos--;
		
	}	
	
}
