package arkanoid.version01;


import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Nave extends Actor {
	
	private int vX = 5;
	private boolean derecha, izda;
	private BufferedImage spritesNave[] = new BufferedImage[3];
	protected int t = 0;
	protected int frameActual;
	
	/**
	 * Constructor
	 * @param posX
	 * @param posY
	 * @param vX
	 * @param vY
	 */
	
	public Nave(int posX, int posY) {
		super(posX, posY);
		
		for (int i = 0; i < 3; i++) {
			
			this.spritesNave[i] = SpriteCache.getSpriteCache().getSprite("vaus" + (i + 1) + ".png");
			
		}
		this.spriteActual = this.spritesNave[0];
		this.setAlto(this.spriteActual.getHeight());
		this.setAncho(this.spriteActual.getWidth());
	}
	
	/**
	 * Metodo que ejecutara el actor cuando se pulsa o suelta una tecla
	 * @param borde
	 */
	
	public void actua() {
		
		//Posicion en el eje X de la nave
		int posicion = this.getPosX();

		/*Si el jugador esta pulsando la flecha derecha y el borde derecho de la nave (posicion + 90) no esta en una posicion superior
		al ancho de ancho de la ventana, la velocidad de la nave (vX) se sumara a la posicion actual*/
		if (derecha && (posicion + this.vX +  this.ancho) <= Arkanoid.ANCHO) {
			
			this.posX += vX;		
			
		}
		/*Si el jugador esta pulsando la flecha izda y el borde izquierdo de la nave no esta en una posicion
		 * inferior a 0, la velocidad de la nave (vX) se restara la posicion actual */
		if (izda && (posicion - this.vX >= 0)) {
			
			this.posX -= vX;
			
			
		}
		
		//Animacion
		t++;
		
		if (t % 4 == 0) {
			
			t = 0;
			frameActual = (frameActual + 1) % spritesNave.length; 
		}
	}

	/**
	 * Metodo que verificara que tecla se esta pulsando
	 * @param e
	 */
	
	public void teclaPulsada(KeyEvent e) {
		
		switch (e.getKeyCode()) {
			
			// Si la tecla pulsada es la flecha derecha, el boolean derecha se cambiara a true  
			 case KeyEvent.VK_RIGHT:{
				
				derecha = true;
				break;
			}
			
			 // Si la tecla pulsada es la flecha izquierda, el boolean izquierda se cambiara a true
			case KeyEvent.VK_LEFT:{
				
				izda = true;
				break;
			}
			
			//Si el jugador pulsa la barra espaciadora la bola saldra despedida
			case KeyEvent.VK_SPACE:{
				
				Arkanoid.lanzarBola = true;
				
			}
		}
		
	}
	
	/**
	 * Metodo que comprobara si se ha soltado una tecla
	 * @param e
	 */
	
	public void teclaSoltada(KeyEvent e) {
		
		switch (e.getKeyCode()) {
			//Si se ha soltado la flecha derecha, el boolean derecha se cambiara a false
			case KeyEvent.VK_RIGHT:{
				
				derecha = false;
				break;
			}
			
			//Si se ha soltado la flecha izquierda, el boolean izda se cambiara a false
			case KeyEvent.VK_LEFT:{
				
				izda = false;
				break;
			}
	
		}
		
	}
	
	/**
	 * Metodo que controla el movimiento de la nave con el raton
	 * @param e
	 */
	
	public void controlRaton(MouseEvent e) {
		
		int posicionRaton = e.getX();
		
		//Si la posicion del raton es mayor o igual al ancho del sprite de la nave/2...
		if (posicionRaton >= (this.ancho / 2)
				&&
			//...y la posicion del raton no es mayor que el ancho de la ventana - el ancho de la nave/2...
			posicionRaton <= (Arkanoid.ANCHO - this.ancho / 2)) {
			
			//...el centro de la nave se colocara en la posicion del raton. De este modo no se saldra por los lados.
			this.posX = posicionRaton - this.ancho / 2;
		}

	}
	
	public void empezarConRaton(MouseEvent e) {
		
		if (e.getID() == MouseEvent.MOUSE_CLICKED) {
			
			Arkanoid.lanzarBola = true;
			
		}
		
	}
	/**
	 * Metodo paint
	 */
	
	public void paint(Graphics g) {
		
		g.drawImage(this.spritesNave[frameActual], this.posX, this.posY, null);
		
	}
	
	/**
	 * Metodo que gestiona la colision
	 */
	
	public void colision() {
		
		CacheSonido.getCacheSonido().reproducirSonido("ChoqueBola.wav");
		
	}
	/**
	 * Getters y setters
	 * @return
	 */
	
	public int getvX() {
		return vX;
	}

	public void setvX(int vX) {
		this.vX = vX;
	}

	
	
	
}
