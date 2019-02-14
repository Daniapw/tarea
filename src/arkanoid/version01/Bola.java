package arkanoid.version01;

import java.awt.Graphics;
import java.awt.Rectangle;


public class Bola extends Actor {
	//Tiempo en ms en el que se ha creado la bola
	private long tiempoCreacion;
	//Diametro de la bola
	protected static final int DIAMETRO = 20;
	//Boolean para saber si la bola ha tocado abajo
	protected boolean toqueAbajo = false;
	// La bola se mover� en una determinada recta (trayectoria) con una determinada velocidad
	public TrayectoriaRecta trayectoria = null;
	// Para el control preciso del aumento de la velocidad de la bola constante utilizo unas coordenadas flotantes
	// aunque eso no quita que sigan existiendo las coordenades x e y del supertipo Actor. De hecho, cada vez que
	// actualizamos las coordenadas flotantes tambi�n actualizar� las coordenadas enteras.
	private PuntoAltaPrecision coordenadas = null;
	private float velocidadPorFrame = 3f; // Velocidad inicial de la bola, expresada en pixels por frame
	// La velocidad de la Bola aumentar� conforme vaya aumentando el n�mero de frames generados con el siguiente factor
	private float factorIncrementoVelocidadBola = 1.00035f;
	// M�xima velocidad posible a alcanzar
	private static final float MAXIMA_VELOCIDAD = 7;
	
	/**
	 * Constructor
	 * @param posX
	 * @param posY
	 * @param vX
	 * @param vY
	 */
	
	public Bola(int posX, int posY) {
		super(posX, posY);
		
		this.ancho = DIAMETRO;
		this.alto = DIAMETRO;
		this.tiempoCreacion = System.currentTimeMillis();
		this.spriteActual = SpriteCache.getSpriteCache().getSprite("bola.png");
		// Inicializamos las coordenadas de alta precisi�n
		this.coordenadas = new PuntoAltaPrecision(this.posX, this.posY);
		
	}
	
	/**
	 *  Metodo que hace que la bola se mueva
	 * @param ancho
	 * @param alto
	 * @param vX
	 * @param vY
	 */
	
	public void actua() {
		
		//Reiniciar boolean toqueAbajo
		toqueAbajo = false;
		
		if (this.trayectoria == null && (!Arkanoid.getInstancia().bolaLanzada || !Arkanoid.getInstancia().juegoEmpezado)) {
				this.iniciarMovimiento(-1, -1);
		
		}
		
		if (this.trayectoria != null) {
			// Si la bola toca el borde por arriba o por abajo, su trayectoria se reflejar� verticalmente
			if (this.posY < 0) {
				this.trayectoria.reflejarHaciaAbajo(this.coordenadas);
			}
			else if (this.posY > Arkanoid.ALTO - DIAMETRO) {
				this.trayectoria.reflejarHaciaArriba(this.coordenadas);
				toqueAbajo = true;
			}
			// Si la bola se toca el borde por la izquierda o por la derecha, su velocidad cambia de signo
			else if (this.posX < 0) {
				this.trayectoria.reflejarHaciaDerecha(this.coordenadas);
			}
			else if (this.posX > Arkanoid.ANCHO - DIAMETRO) {
				this.trayectoria.reflejarHaciaIzquierda(this.coordenadas);
			}

			// Calculo del nuevo punto de la trayectoria de la bola
			PuntoAltaPrecision nuevoPuntoEnLaTrayectoria = this.trayectoria.getPuntoADistanciaDePunto(this.coordenadas, this.velocidadPorFrame);
			this.coordenadas = nuevoPuntoEnLaTrayectoria;
			// Actualizo las coordenadas enteras del supertipo Actor, ya que es conforme a estas con las que se pinta en pantalla
			// y se detectan las colisiones.
			this.posX = Math.round(this.coordenadas.x);
			this.posY = Math.round(this.coordenadas.y);
			
			// Detecto si es necesario aumentar la velocidad de la bola y, si es as�, lo hago, hasta que llegue al l�mite
			if (this.velocidadPorFrame < MAXIMA_VELOCIDAD) {
				this.velocidadPorFrame *= this.factorIncrementoVelocidadBola;
			}

		}
		
	}
	
	/**
	 * Metodo que inicia el movimiento de la bola tras 5 segundos o cuando el usuario la lanza
	 */
	public void iniciarMovimiento(int xDestino, int yDestino) {
		
		this.posX = Arkanoid.getInstancia().nave.posX + (Arkanoid.getInstancia().nave.ancho/2);
		this.posY = Arkanoid.getInstancia().nave.posY - Bola.DIAMETRO - 1;
		
		long tiempoActual = System.currentTimeMillis();
		
		if ((tiempoActual - tiempoCreacion)/1000 >= 5 || Arkanoid.getInstancia().bolaLanzada) {
			
			CacheSonido.getCacheSonido().reproducirSonido("SonidoDespegueBola.wav");
			
			if (trayectoria == null) {
				// Si los valores del punto de destino son "-1" indica ue debemos hacer una trayectoria por defecto
				if (xDestino == -1 && yDestino == -1) {
					this.trayectoria = new TrayectoriaRecta(-3f, this.coordenadas, true);
				}
				// En caso contrario debemos trazar la trayectoria desde el punto actual de la bola hasta el punto
				// que nos indican
				else {
					// Establecemos una m�nima distancia en el eje X entre la situaci�n de la bola y el punto que nos
					// indican. De esa manera evitamos que la pelota se pueda poner completamente vertical
					int minimaDistanciamientoEntreX = 20;
					if (Math.abs(xDestino - this.posX) < minimaDistanciamientoEntreX) {
						// Trayectoria a derecha
						if (xDestino < this.posX) {
							xDestino = this.posX - minimaDistanciamientoEntreX;
						}
						else {
							// Trayectoria a izquierda
							xDestino = this.posX + minimaDistanciamientoEntreX;
						}
					}
					// Determinamos la direcci�n a seguir en la trayectoria en funci�n del signo de la pendiente que 
					// esperamos
					boolean direccionCreciente = (xDestino > this.posX)? true : false;
					// Creamos la trayectoria.
					this.trayectoria = new TrayectoriaRecta(new PuntoAltaPrecision(this.posX, this.posY), new PuntoAltaPrecision(xDestino, yDestino), direccionCreciente);
				}
			}
			
			Arkanoid.getInstancia().juegoEmpezado = true;
			Arkanoid.getInstancia().bolaLanzada = true;
		}
		
	}
	
	/**
	 * Metodo paint
	 */
	
	public void paint(Graphics g) {
		
		g.drawImage(this.getSprite(), this.posX, this.posY, null);
		
	}
	
	/**
	 * Metodo que gestiona las colisiones
	 */
	
	public void colision(Actor actor) {
		
		if (actor instanceof Ladrillo) {
			
			colisionConLadrillo(actor);
			
		}
		else {
			
			if (actor instanceof Nave) {
				
				colisionConNave(actor);
				
			}
			
		}
	}
	
	/**
	 * Colision con nave
	 * @param nave
	 */
	public void colisionConNave(Actor nave) {
		
		// Creo rect�ngulos para determinar la zona de la nave con la que choca la bola
		int anchoZonaEspecial = 7; // p�xeles que delimitan la zona de rebote especial de la nave
		Rectangle rectIzqNave = new Rectangle(nave.posX, nave.posY, anchoZonaEspecial, nave.alto);
		Rectangle rectDerNave = new Rectangle(nave.posX + nave.ancho - anchoZonaEspecial, nave.posY, anchoZonaEspecial, nave.alto);
		Rectangle rectBola = this.getMedidas();
		
		// Colisi�n con el lado derecho de la nave
		if (rectBola.intersects(rectDerNave)) {
			this.posY = nave.posY - nave.getAlto();
			this.coordenadas.y = this.posY;
			if (Math.abs(this.trayectoria.getPendiente()) > 1 ) { // La bola viene on una pendiente mayor a 1
				this.trayectoria.setPendiente(-(float) (Math.random() * (0.8 - 0.3) + 0.3), this.coordenadas, true);
			}
			else { // La bola viene con una pendiente suave ( > 0 y < 1 )
				this.trayectoria.setPendiente(-(float) (Math.random() * (10 - 2) + 2), this.coordenadas, true);
			}
			return;
		}
		// Colisi�n con el lado izquierdo de la nave
		if (rectBola.intersects(rectIzqNave)) {
			this.posY = nave.posY - nave.getAlto();
			this.coordenadas.y = this.posY;
			if (Math.abs(this.trayectoria.getPendiente()) > 1 ) { // La bola viene con una pendiente mayor a 1
				this.trayectoria.setPendiente((float) (Math.random() * (0.8 - 0.3) + 0.3), this.coordenadas, false);
			}
			else { // La bola viene con una pendiente suave ( > 0 y < 1 )
				this.trayectoria.setPendiente((float) (Math.random() * (10 - 2) + 2), this.coordenadas, false);
			}
			return;
		}
		else { // La bola intersecta la parte central de la nave
			this.trayectoria.reflejarHaciaArriba(this.coordenadas);
			return;
		}	

	}

	/**
	 * Colision con ladrillo
	 * @param actor
	 */
	public void colisionConLadrillo(Actor actorColisionado) {
		
		int margenLateral = 4; // Este mare
		// Creo peque�os rect�ngulos que coincidir�n con los bordes del ladrillo
		Rectangle rectArribaActor = new Rectangle(actorColisionado.posX, actorColisionado.posY, actorColisionado.getAncho(), 1);
		Rectangle rectAbajoActor = new Rectangle(actorColisionado.posX, actorColisionado.posY + actorColisionado.getAlto()-1, actorColisionado.getAncho(), 1);
		Rectangle rectIzquierdaActor = new Rectangle(actorColisionado.posX, actorColisionado.posY + margenLateral, 1, actorColisionado.getAlto() - 2 * margenLateral);
		Rectangle rectDerechaActor = new Rectangle(actorColisionado.posX + actorColisionado.getAncho()-1, actorColisionado.posY + margenLateral, 1, actorColisionado.getAlto() - 2 * margenLateral);

		// variables booleanas que me indicar�n una colsi�n por cada lado del ladrillo
		boolean arriba = false, abajo = false, derecha = false, izquierda = false;
		
		if (this.getMedidas().intersects(rectArribaActor))  arriba = true;
		if (this.getMedidas().intersects(rectAbajoActor))  abajo = true;
		if (this.getMedidas().intersects(rectIzquierdaActor))  izquierda = true;
		if (this.getMedidas().intersects(rectDerechaActor))  derecha = true;
		
		if (arriba && izquierda) { // Colisi�n con esquina superior izquierda
			// Coloco la bola en la esquina
			this.posX = actorColisionado.posX;
			this.posY = actorColisionado.posY;
			this.coordenadas.x = this.posX; this.coordenadas.y = this.posY;
			// Recalculo la pendiente
			this.trayectoria.setPendiente(Math.abs(this.trayectoria.getPendiente()), this.coordenadas, false);
			return;
		}
		if (arriba && derecha) {
			this.posX = actorColisionado.posX + actorColisionado.ancho;
			this.posY = actorColisionado.posY;
			this.coordenadas.x = this.posX; this.coordenadas.y = this.posY;
			this.trayectoria.setPendiente(0-Math.abs(this.trayectoria.getPendiente()), this.coordenadas, true);
			return;
		}
		if (abajo && izquierda) {
			this.posX = actorColisionado.posX;
			this.posY = actorColisionado.posY + actorColisionado.alto;
			this.coordenadas.x = this.posX; this.coordenadas.y = this.posY;
			this.trayectoria.setPendiente(0-Math.abs(this.trayectoria.getPendiente()), this.coordenadas, false);
			return;
		}
		if (abajo && derecha) {
			this.posX = actorColisionado.posX + actorColisionado.ancho;
			this.posY = actorColisionado.posY + actorColisionado.alto;
			this.coordenadas.x = this.posX; this.coordenadas.y = this.posY;
			this.trayectoria.setPendiente(Math.abs(this.trayectoria.getPendiente()), this.coordenadas, true);
			return;
		}
		if (abajo) {
			this.posY = actorColisionado.posY + actorColisionado.alto;
			this.coordenadas.y = this.posY;
			this.trayectoria.reflejarHaciaAbajo(this.coordenadas);
			return;
		}
		if (arriba) {
			this.posY = actorColisionado.posY;
			this.coordenadas.y = this.posY;
			this.trayectoria.reflejarHaciaArriba(this.coordenadas);
			return;
		}
		if (izquierda) {
			this.posX = actorColisionado.posX;
			this.coordenadas.x = this.posX;
			this.trayectoria.reflejarHaciaIzquierda(this.coordenadas);
			return;
		}
		if (derecha) {
			this.posX= actorColisionado.posX + actorColisionado.ancho;
			this.coordenadas.x = this.posX;
			this.trayectoria.reflejarHaciaDerecha(this.coordenadas);
			return;
		}
		
	}

	/**
	 * Getters y setters
	 * @return
	 */
	public long getTiempoCreacion() {
		return tiempoCreacion;
	}

	public void setTiempoCreacion(long tiempoCreacion) {
		this.tiempoCreacion = tiempoCreacion;
	}

}
