package arkanoid.version01;

import java.awt.Canvas;
import java.awt.Color;
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
	
	public static final int ANCHO = 500; 
	public static final int ALTO = 700;
	public static final int FPS = 100;
	public Nave nave = new Nave(210, 640);
	public Bola bola = new Bola(250, 540, 3, 3);
	public List<Actor> actores = new ArrayList<Actor>();
	public Fase faseActiva = null;
	private BufferStrategy estrategia;
	int millisADetenerElJuego;
	
	
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
		
		//Listener del raton
		this.addMouseMotionListener(new MouseAdapter() {
			
		
			//Cuando el raton se mueve dentro de la ventana se ejecutara el metodo controlRaton() de la nave
			public void mouseMoved(MouseEvent e) {
				
				nave.controlRaton(e);
				
			}	
			
		});
	
	}
	
	/**
	 * Metodo para pintar la lista de ladrillos
	 * @param g
	 */

	public void paintLadrillos(Graphics g) {
		
		
		for (int i = 0; i < actores.size(); i++) {
			
			if (actores.get(i) instanceof Ladrillo) {
				
				g.setColor(Color.decode(actores.get(i).getColor()));
				g.fillRoundRect(actores.get(i).getPosX(), actores.get(i).getPosY(), 42, 22, 5, 10);
				g.setColor(Color.black);
				g.drawRoundRect(actores.get(i).getPosX(),actores.get(i).getPosY() , 42, 22, 1, 10);
			
			}
		}
		
	}
	
	/**
	 * Metodo que busca colisiones
	 */
	
	public void buscarColisiones() {
		
		Rectangle bolaRec = bola.getMedidas();
		Rectangle r2 = null;
		
		for (int i = 0; i < actores.size(); i++) {
			
			r2 = actores.get(i).getMedidas();
			
			if (bolaRec.intersects(r2) && (actores.get(i) instanceof Ladrillo || actores.get(i) instanceof Nave)) {
				
				actores.get(i).colision();
				
				bola.colision();
				
			}	
		}
	}
	
	/**
	 * Metodo que cambia el mundo en cada fotograma
	 */
	
	public void actualizarMundo() {
		
		//La bola ejecuta su metodo actua
		bola.actua();

		//Los ladrillos cuyo boolean borrar este en true seran borrados
		for (int i = 0; i < actores.size(); i++) {
			
			if (actores.get(i).isBorrar()) {
				
				actores.remove(i);
				
			}
			
		}
		
	}
	
	/**
	 * Bucle principal del juego (el que pinta los fotogramas)
	 */
	
	public void bucleJuego() {
		
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
				
				  millisADetenerElJuego = 1000 / FPS - millisUsados;
				 
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
		g.drawImage(SpriteCache.getSpriteCache().getSprite("fondoArkanoid1.jpg"), 0, 0, this);
		g.drawImage(nave.getSprite(), nave.getPosX(), nave.getPosY(), this);
		g.drawImage(bola.getSprite(), bola.getPosX(), bola.getPosY(), this);
		paintLadrillos(g);
		
		estrategia.show();
		
	}
	
	/**
	 * Main
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		Arkanoid juego = new Arkanoid();
		
		juego.bucleJuego();
	}
	
}
