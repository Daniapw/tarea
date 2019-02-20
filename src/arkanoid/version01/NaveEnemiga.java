package arkanoid.version01;

import java.awt.Graphics;

public class NaveEnemiga extends Actor{
	
	protected int vX = 4;
	protected int vidas = 5;
	protected long timerAlcance = 0;
	protected boolean naveAlcanzada = false;
	
	public NaveEnemiga(int x, int y) {
		
		super(x,y);
		
		this.spriteActual = SpriteCache.getSpriteCache().getSprite("SpriteNaveEnemiga.png");
		this.ancho = this.spriteActual.getWidth();
		this.alto = this.spriteActual.getHeight();
		
	}
	
	/**
	 * Metodo actua
	 */
	public void actua() {
		
		//Se genera un numero aleatorio entre 0 y 1
		double numAleatorio = Math.random();
		
		//Si la nave se sale por la derecha de la ventana cambiara de sentido
		//tambien cambiara de sentido si el numero aleatoio generado esta entre 0 y 0.007
		if ((this.posX + this.vX + this.ancho) > Arkanoid.ANCHO || numAleatorio < 0.007) {
			
			this.vX = -vX;
			
		}
		
		//Si la nave se sale por la izda cambiara de sentido
		if (this.posX < 0) {
			
			this.vX = Math.abs(vX);
			
		}
		
		//Si el numero es menor que 0.002 la nave disparara
		if (numAleatorio < 0.002) {
			
			CacheSonido.getCacheSonido().reproducirSonido("SonidoDisparo.wav");
			Arkanoid.getInstancia().disparos.add(new Disparo(this.posX, (this.posY + this.alto), "DisparoEnemigo"));
			Arkanoid.getInstancia().disparos.add(new Disparo((this.posX + this.ancho - 13 ), (this.posY + this.alto), "DisparoEnemigo"));
			
		}
		
		this.posX += this.vX; 

		//Si la nave ha sido alcanzada se llamara al metodo timerDanio(), que controla el tiempo que el sprite permanecera cambiado
		if (this.naveAlcanzada) {
		
			timerDanio();
			
		}
	}
	
	/**
	 * Metodo paint
	 */
	public void paint(Graphics g) {
		
		if (this.naveAlcanzada) {
			
			this.spriteActual = SpriteCache.getSpriteCache().getSprite("SpriteNaveEnemigaDanio.png");
			
		}
		else {
			
			this.spriteActual = SpriteCache.getSpriteCache().getSprite("SpriteNaveEnemiga.png");
			
		}
		
		g.drawImage(spriteActual, this.posX, this.posY, null);	

	}
	
	/**
	 * Metodo colision
	 */
	public void colision(Actor actor) {
		
		//Si la nave es alcanzada por un disparo:
		if (actor instanceof Disparo) {
			//Se reproducira un sonido:
			CacheSonido.getCacheSonido().reproducirSonido("DanioNaveEnemiga.wav");
			//Se le restara una vida:
			this.vidas--;
			//El boolean naveAlcanzada pasara a true
			this.naveAlcanzada = true;
			//Y se guardara el tiempo en el que ha sido alcanzada
			this.timerAlcance = System.currentTimeMillis();
			
			//Si se ha quedado sin vidas la nave se marcara para borrar y se creara una explosion en su lugar
			if (this.vidas == 0) {
				this.setBorrar(true);
				CacheSonido.getCacheSonido().reproducirSonido("SonidoExplosionNaveEnemiga.wav");
				Arkanoid.getInstancia().actoresEspeciales.add(new Explosion(this.posX + 5, this.posY -2));
			}
		}
		
	}
	
	/**
	 * Metodo para controlar el tiempo que la nave va a tener el sprite cambiado cuando le hacen danio
	 */
	public void timerDanio() {
		
		long tiempoActual = System.currentTimeMillis();
		
		if ((tiempoActual- this.timerAlcance )/1000 > 0) {
			
			this.naveAlcanzada = false;
			
		}

	}
}
