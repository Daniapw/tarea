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
import java.util.HashMap;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Arkanoid extends Canvas {
	
	public static final int ANCHO = 500; 
	public static final int ALTO = 700;
	public Nave nave = new Nave(210, 640);
	public Bola bola = new Bola(250, 540, 3, 3);
	public List<Actor> actores = new ArrayList<Actor>();
	private BufferStrategy estrategia;
	private long tiempoUsado;
	
	
	/**
	 * Constructor
	 */
	
	public Arkanoid() {
		
		//JFrame para mostrar la ventana en la que se ve el juego
		JFrame ventana = new JFrame("Arkanoid");
		
		//Establezco las dimensiones de la ventana
		ventana.setBounds(0, 0, ANCHO, ALTO);
		
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
		
		//Inicializo los ladrillos
		initLadrillos();
		
		//Anado todos los actores a la lista
		actores.add(nave);
		actores.add(bola);

		
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
	 * Metodo que inicializa los ladrillos
	 */
	
	public void initLadrillos() {
		
		Ladrillo ladrillo = null;
		String color = "#";
		int x = 28;
		int y = 100;

		
		for (int i = 0; i < 60; i++) {
			
			switch (i) {
				case 0:{
					
					color = "#77abff";
					
					break;
				}
				case 10:{
					
					color = "#b8f759";
					break;
					
				}
				case 20:{
					
					color = "#fcfc2d";
					break;
					
				}
				case 30:{
					
					color = "#f49529";
					break;
				}
				case 40:{
					
					color = "#9128f4";
					break;
				}
				
				case 50:{
					
					color = "#ff052a";
					break;
				}
			}
			
			ladrillo = new Ladrillo(0, 0, color);
			
			actores.add(ladrillo);
			
			actores.get(i).setPosX(x);
			actores.get(i).setPosY(y);
			
			x += 44;
			
			if (i == 9 || i  == 19 || i  == 29 || i  == 39 || i  == 49) {
				
				y += 28;
				x = 28;
						
			}

		}
		
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
			
			if (bolaRec.intersects(r2) && !actores.get(i).isBorrar()) {
				
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
		bola.actua(ANCHO, ALTO);

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

		tiempoUsado = 1000;
		
		//Mientras la ventana del juego sea visible:
		while(this.isVisible()) {
			long tiempoComienzo = System.currentTimeMillis();

			
			//Se ejecutara el metodo buscarColisiones()
			buscarColisiones();
			
			//Se ejecutara el metodo actualizarMundo()
			actualizarMundo();			
			
			//Se repintara la escena
			paintMundo();
			
			//Se mide el tiempo que ha tardado en pintarse el frame
			tiempoUsado = System.currentTimeMillis() - tiempoComienzo;
			
			try { 
				 Thread.sleep(10);
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
		g.drawImage(SpriteCache.getSpriteCache().getSprite("vaus.png"), nave.getPosX(), nave.getPosY(), this);
		g.drawImage(SpriteCache.getSpriteCache().getSprite("bola.png"), bola.getPosX(), bola.getPosY(), this);
		paintLadrillos(g);
		
		//Pintar medidor de fps
		g.setColor(Color.white);
		if (tiempoUsado > 0) {
			
			g.drawString(String.valueOf(1000/tiempoUsado)+" fps",0,20);
			
		}
		else {
			
			g.drawString(" -- fps",0,20);
			
		}
		
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
