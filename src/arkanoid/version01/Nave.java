package arkanoid.version01;


import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Nave extends Actor {
	
	//Velocidad de la nave
	private int vX = 5;
	//Booleans para saber en que direccion se esta desplazando
	private boolean derecha, izda;
	//Animacion de la nave
	private BufferedImage spritesNave[] = new BufferedImage[3];
	//Variables para saber cuando la nave tiene un efecto activo y la duracion del mismo
	protected boolean efectoActivo = false;
	protected boolean disparosActivos = false;
	protected int duracionEfecto = 0;
	protected long timerTiempoActivacion = 0;
	//Variables para la animacion de la nave
	protected int t = 0;
	protected int frameActual;
	//Vidas de la nave
	protected int intentos = 3;
	//Boolean para saber si la nave ha sido alcanzada por un disparo
	protected boolean naveAlcanzada = false;
	
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
		
		naveAlcanzada = false;
		
		if (efectoActivo) {
			
			timerEfecto();
			
		}
		
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
			
			//Si el jugador pulsa la barra espaciadora al comienzo del juegola bola saldra despedida y se reproducira un sonido  
			case KeyEvent.VK_SPACE:{
				
				if (!Arkanoid.getInstancia().bolaLanzada) {
					
					Arkanoid.getInstancia().bola.iniciarMovimiento(-1, -1);
					
				}
				break;
			}

			//Por si la bola se atasca
			case KeyEvent.VK_R:{
				
				if (e.isShiftDown() && Arkanoid.getInstancia().bolaLanzada) {
					
					Arkanoid.getInstancia().resetBolaYNave();
					
				}
				break;
			}
			//Si el jugador ha conseguido la capsula de los disparos
			case KeyEvent.VK_UP:{
				
				if (disparosActivos && !Arkanoid.getInstancia().juegoTerminado) {
					
					CacheSonido.getCacheSonido().reproducirSonido("SonidoDisparo.wav");
					Arkanoid.getInstancia().disparos.add(new Disparo(this.posX, (this.posY - 17) , "Disparo"));
					Arkanoid.getInstancia().disparos.add(new Disparo((this.posX + this.ancho - 5 ), this.posY - 17, "Disparo"));
					
				}
				break;
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
		if (posicionRaton >= (this.ancho / 2) && !e.isShiftDown()
				&&
			//...y la posicion del raton no es mayor que el ancho de la ventana - el ancho de la nave/2...
			posicionRaton <= (Arkanoid.ANCHO - this.ancho / 2)) {
			
			//...el centro de la nave se colocara en la posicion del raton. De este modo no se saldra por los lados.
			this.posX = posicionRaton - this.ancho / 2;
		}

	}
	
	/**
	 * Metodo que controla si el usuario ha hecho clic para lanzar la bola
	 * @param e
	 */
	
	public void empezarConRaton(MouseEvent e) {
		
		if (e.getID() == MouseEvent.MOUSE_CLICKED) {
			
			// En caso de que hagan clic manteniendo pulsado las may�sculas y el control iniciaremos un movimiento con
			// una trayectoria que pase desde el punto actual de la bola y por el punto se�alado con el rat�n
			if ((e.isShiftDown() || e.isControlDown()) && !Arkanoid.getInstancia().bolaLanzada) {
				Arkanoid.getInstancia().bola.iniciarMovimiento(e.getX(), e.getY());
			}
			
				
			if (!e.isShiftDown() && !e.isControlDown() && !Arkanoid.getInstancia().bolaLanzada) {
				// Indicamos que se inicie el movimiento con una trayectoria por defecto
				Arkanoid.getInstancia().bola.iniciarMovimiento(-1, -1);
			}
			
			
			
		}
		
	}
	
	/**
	 * Metodo para controlar el tiempo restante de un efecto
	 */
	
	public void timerEfecto() {
		
		long tiempoActual = System.currentTimeMillis();
		
		if ((tiempoActual - timerTiempoActivacion)/1000 > duracionEfecto){
			
			efectoActivo = false;
			disparosActivos = false;
			duracionEfecto = 0;
			
			//Cambiar el ancho y el alto a los valores por defecto de la nave
			this.ancho = this.spritesNave[0].getWidth();
			this.alto = this.spritesNave[0].getHeight();
		}
		
	}
	
	/**
	 * Metodo que llamaran las capsulas para activar un efecto en la nave
	 */
	
	public void activarEfecto(BufferedImage sprite, long tiempoActivacion, int duracion) {
		
		this.spriteActual = sprite;
		this.ancho = this.spriteActual.getWidth();
		this.alto = this.spriteActual.getHeight();
		this.timerTiempoActivacion = tiempoActivacion;
		this.duracionEfecto = duracion;
		this.efectoActivo = true;
		this.disparosActivos = false;
	}
	
	/**
	 * Metodo paint
	 */
	
	public void paint(Graphics g) {
		
		//Si no hay un efecto activo se pintara la nave normal
		if (!efectoActivo) {
			
			g.drawImage(this.spritesNave[frameActual], this.posX, this.posY, null);
			
		}	
		//Si lo hay se pintara el spriteActual, que cambia segun el efecto activo
		else {
		
			g.drawImage(this.spriteActual, this.posX, this.posY, null);
			
		}
	}
	
	/**
	 * Metodos que gestionan la colision
	 */
	
	public void colision() {
		
		CacheSonido.getCacheSonido().reproducirSonido("ChoqueBola.wav");
		
	}
	
	public void colision(Actor actor) {
		
		naveAlcanzada = true;
		
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
