package arkanoid.version01;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Arkanoid extends Canvas {
	
	//Dimensiones del JFrame
	public static final int ANCHO = 620; 
	public static final int ALTO = 700;
	//Tasa de frames
	public static final int FPS = 100;	
	//Objetos nave y bola (se crean aqui para tener un puntero)
	public Nave nave = new Nave(210, 640);
	public Bola bola = new Bola(nave.posX + (nave.ancho/2), nave.posY - Bola.DIAMETRO);
	//Listas de actores (ladrillos, nave, bola...)
	public List<Actor> actores = new ArrayList<Actor>();
	public List<Actor> actoresEspeciales = new ArrayList<Actor>();
	//Fase activa
	public Fase faseActiva = null;
	//Estrategia de buffer
	private BufferStrategy estrategia;
	//Boolean para saber si el juego ha empezado
	protected boolean juegoEmpezado = false;	
	protected boolean lanzarBola = false;
	//Boolean para saber si el juego ha terminado
	protected boolean juegoTerminado = false;
	//Puntero Arkanoid para el singleton
	public static Arkanoid arkanoid=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Constructor
	 */
	
	public Arkanoid() {
		
		//JFrame para mostrar la ventana en la que se ve el juego
		JFrame ventana = new JFrame("Arkanoid");
		
		//Establezco las dimensiones de la ventana
		ventana.setBounds(0, 0, ANCHO, ALTO + 28);
		
		//Creacion del panel principal de la ventana y le añadimos el objeto Ventana (el canvas)
		JPanel panel = (JPanel)ventana.getContentPane();
		
		panel.add(this);
		
		panel.setPreferredSize(new Dimension(ANCHO, ALTO));

		//Establezco el tamaño del Canvas
		this.setBounds(0,0,ANCHO ,ALTO);
		this.setFont(new Font("Verdana", Font.PLAIN, 16));
		
		//Establezco el comportamiento al darle a la X
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Hago visible la ventana y que no se pueda redimensionar
		ventana.setVisible(true);
		ventana.setResizable(false);
		ventana.setIgnoreRepaint(true);

		
		//Cambiar fase activa
		faseActiva = new Fase01();
		
		//Anado todos los actores a la lista
		actores.add(nave);
		actores.add(bola);

		actores.addAll(faseActiva.actoresFase);
		
		//Estrategia de buffer
		createBufferStrategy(2);
		
		estrategia = getBufferStrategy();
		requestFocus();

		//Listener del teclado
		this.addKeyListener(new KeyAdapter() {
			
			//Cuando se pulse una tecla se ejecutara el metodo teclaPulsada() de la nave
			public void keyPressed(KeyEvent e) {
				
				nave.teclaPulsada(e);
				
				
			}
			
			//Cuando se suelte una tecla se ejecutara el metodo teclaSoltada() de la nave
			public void keyReleased(KeyEvent e) {
				
				nave.teclaSoltada(e);
				
			}
		});
		
		//MouseMotionListener para mover la nave con el raton
		this.addMouseMotionListener(new MouseAdapter() {
			
			//Cuando el raton se mueve dentro de la ventana se ejecutara el metodo controlRaton() de la nave
			public void mouseMoved(MouseEvent e) {
				
				nave.controlRaton(e);
				
			}	
			

		});
		
		//MouseListener para detectar si el usuario ha hecho clic
		this.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
			
				nave.empezarConRaton(e);
				
			}
			
		});
	}
	
	/**
	 * Metodo que busca colisiones
	 */
	
	public void buscarColisiones() {
		
		Rectangle bolaRec = bola.getMedidas();
		Rectangle r2 = null;
		
		/*Se compara el rectangulo de la bola con los rectangulos de los demas actores, y
		si colisionan se ejecuta el metodo colision de la bola y el del actor en cuestion*/
		for (int i = 0; i < actores.size(); i++) {
			
			r2 = actores.get(i).getMedidas();
			
			if (bolaRec.intersects(r2) && (actores.get(i) instanceof Ladrillo || actores.get(i) instanceof Nave)) {
				
				actores.get(i).colision();
				
				bola.colision(actores.get(i));
				
				break;
			}	
		}
	}

	/**
	 * Comprobar si ha terminado la fase
	 * @return
	 */
	public boolean faseTerminada() {
		
		List<Ladrillo> ladrillos = new ArrayList<Ladrillo>();
		
		//Creo una lista y le anado los ladrillos de la lista de actores
		for (int i = 0; i < actores.size(); i++) {
			
			if (actores.get(i) instanceof Ladrillo) {
				
				ladrillos.add((Ladrillo) actores.get(i));
				
			}
			
		}
		
		//Recorro la lista y compruebo si alguno de los ladrillos tienen mas de 0 vidas (los irrompibles tienen -1)
		for (Ladrillo ladrillo:ladrillos) {
			
			if (ladrillo.vidas > 0) {
				
				return false;
			
			}	
		}
		
		//Si no se encuentra ningun ladrillo "vivo" el metodo devuelve true
		return true;
	}
	
	/**
	 * Metodo que comprueba si hay que borrar ladrillos y crea las explosiones
	 */
	
	public void comprobacionLadrillosYExplosiones() {
		
		/*Los ladrillos cuyo boolean borrar este en true seran borrados. Ademas, se creara un actor Explosion en sus coordenadas y 
		se anadira a la lista actoresEspeciales*/
		for (int i = 0; i < actores.size(); i++) {
			
			if (actores.get(i).isBorrar()) {
				
				actoresEspeciales.add(new Explosion(actores.get(i).posX + 5, actores.get(i).posY -2));
				
				actores.remove(i);
				
			}
			
		}
		
		//Se recorre la lista de actores especiales; estos actuan y, si la flag borrar esta levantada, se borran
		for (int i = 0; i < actoresEspeciales.size(); i++) {
			
			actoresEspeciales.get(i).actua();
			
			if (actoresEspeciales.get(i).isBorrar()) {
				
				actoresEspeciales.remove(i);
				
			}
			
		}
	}
	
	/**
	 * Metodo que cambia el mundo en cada fotograma
	 */
	
	public void actualizarMundo() {
		
		//Si el juego no ha terminado, se actualiza el mundo
		
		if (!juegoTerminado) {
			
			bola.actua();
			
			comprobarVida();
			
			nave.actua();
			
			comprobacionLadrillosYExplosiones();
			
			if (faseTerminada()) {
				
				System.out.println("Fase terminada");
				
			}
		}
	}
	
	/**
	 * Metodo que resta vidas a la nave y termina el juego si no le quedan
	 */
	
	public void comprobarVida() {
		
		//Si la bola ha tocado la parte inferior de la pantalla se le resta un intento a la nave
		if (bola.toqueAbajo) {
			
			nave.intentos--;
			
			//Si todavia le quedan intentos a la nave se reproduce el sonido que indica que le han hecho dano
			if (nave.intentos > 0) {
				
				CacheSonido.getCacheSonido().reproducirSonido("SonidoDanio.wav");
				
			}
			/*Si no le quedan vidas el juego se detendra durante 3 segundos, se reproducira un sonido para indicar que has perdido
			y juegoTerminado pasara a ser true*/
			else {
				
				//La cancion de fondo se detiene
				CacheSonido.getCacheSonido().pararSonido("Cancion1.wav");
				
				long tiempoInicial = System.currentTimeMillis();
				long tiempo = System.currentTimeMillis();
				
				while ((tiempo - tiempoInicial)/1000 < 2 ) {
					
					tiempo = System.currentTimeMillis();
					
				}
				
				juegoTerminado = true;
				
			}
		
		}

	}
	
	/**
	 * Bucle principal del juego (el que pinta los fotogramas)
	 */
	
	public void bucleJuego() {
			
		CacheSonido.getCacheSonido().reproducirSonidoBucle("Cancion1.wav");
		
		//Mientras la ventana del juego sea visible:
		while(this.isVisible()) {
			
			//Se mide el tiempo que ha tardado en pintarse el frame
			long millisAntesDeConstruirEscena = System.currentTimeMillis();
			
			//Se ejecutara el metodo buscarColisiones()
			buscarColisiones();
			
			//Se ejecutara el metodo actualizarMundo()
			actualizarMundo();			
			
			//Se repintara la escena
			paintMundo();
			
			int millisUsados = (int) (System.currentTimeMillis() - millisAntesDeConstruirEscena);
			
			try { 
				
				 int millisADetenerElJuego = 1000 / FPS - millisUsados;
				 
				 if (millisADetenerElJuego >= 0) {
					 Thread.sleep(millisADetenerElJuego);
				 }
				 
			} catch (InterruptedException e) {}
			
		}
		
	}
	
	/**
	 * Metodo que pinta los actores
	 */

	public void paintMundo() {
		
		//Esta linea evita que el juego se lagee en Linux
		Toolkit.getDefaultToolkit().sync();
		
		Graphics g = estrategia.getDrawGraphics();
		
		//Si el juego no ha terminado (el jugador no ha perdido)
		if (!juegoTerminado) {
			//Pintar fondo
			g.drawImage(SpriteCache.getSpriteCache().getSprite(faseActiva.fondo), 0, 0, this);
			
			//Pintar actores normales (ladrillos, nave, bola)
			for (int i = 0; i < actores.size(); i++) {
				
				actores.get(i).paint(g);
				
			}
	
			//Pintar actores especiales (disparos, power-ups, etc.)
			for (int i = 0; i < actoresEspeciales.size(); i++) {
				
				actoresEspeciales.get(i).paint(g);
				
			}
		}
		//Si el juego ha terminado (el jugador ha perdido)
		else {
		
			//Se dibuja la imagen GameOver en pantalla
			g.drawImage(SpriteCache.getSpriteCache().getSprite("GameOver.png"), 0, 0, this);
			
		}
			
		estrategia.show();
		
	}
	
 /**
  * Singleton
  * @return
  */
	public static Arkanoid getInstancia() {
		
		if (arkanoid == null) {
			
			arkanoid = new Arkanoid();
			
		}
		
		return arkanoid;
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Main
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		Arkanoid.getInstancia().bucleJuego();
		
	}
	
}
