package arkanoid.version01;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Arkanoid extends Canvas {
	
	public static final int ANCHO = 500; 
	public static final int ALTO = 800;
	public Nave nave = new Nave(210, 740);
	public Bola bola = new Bola(250, 640, 2, 2);
	public List<Ladrillo> ladrillos = new ArrayList<Ladrillo>();
	private BufferStrategy estrategia;
	

	/**
	 * 
	 */
	//Constructor
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
		
		initLadrillos();
		
		//Estrategia de buffer
		createBufferStrategy(2);
		
		
		estrategia = getBufferStrategy();
		requestFocus();
		

	
	}

	//Bucle que inicializa los ladrillos
	public void initLadrillos() {
		
		Ladrillo ladrillo = null;
		
		int x = 47;
		int y = 100;
		
		Integer numero;
		int  numeroAF;
		double numeroAleat;
		
		String af[] = new String[] { "A", "B", "C", "D", "E", "F"};
		String color = "#";
		
		for (int i = 0; i < 60; i++) {
			
			//Bucle para generar el numero hexadecimal para el color del ladrillo
			for (int j = 0; j < 6; j++) {
				
				numero = (int) (Math.random() * 9);

				numeroAF = (int) (Math.random() * 5);
				
				numeroAleat = Math.random();

				if (numeroAleat < 0.5) {
					
					color = color.concat(numero.toString());
					
				}
				else {
					
					color = color.concat(af[numeroAF]);
					
				}
				
			}

			ladrillo = new Ladrillo(0, 0, color);
			
			ladrillos.add(ladrillo);
			
			ladrillos.get(i).setPosX(x);
			ladrillos.get(i).setPosY(y);
			
			x += 38;
			
			if (i == 9 || i  == 19 || i  == 29 || i  == 39 || i  == 49) {
				
				y += 23;
				x = 47;
				
				
			}
			
			color = "#";
		}
		
		
	}
	//Metodo para inicializar la lista de ladrillos
	public void paintLadrillos(Graphics g) {
	
		for (int i = 0; i < ladrillos.size(); i++) {
			
			g.setColor(Color.decode(ladrillos.get(i).color));
			g.fillRoundRect(ladrillos.get(i).getPosX(), ladrillos.get(i).getPosY(), 35, 20, 5, 10);
			g.setColor(Color.black);
			g.drawRoundRect(ladrillos.get(i).getPosX(),ladrillos.get(i).getPosY() , 35, 20, 1, 10);
		

		}
		
	}
	
	//Metodo que cambia el mundo en cada fotograma
	public void actualizarMundo() {
		
		bola.actua(ANCHO, ALTO);
	
	}
	
	/**
	 * 
	 */
	
	//Bucle principal del juego (el que pinta los fotogramas)
	public void bucleJuego() {
		
		//Mientras la ventana del juego sea visible:
		while(this.isVisible()) {
			
			//Se ejecutara el metodo actualizarMundo()
			actualizarMundo();
			
			//Se repintara la escena
			paintMundo();
			
			try { 
				 Thread.sleep(10);
			} catch (InterruptedException e) {}
		}
		
	}
	
	/**
	 * 
	 */
	
	//Metodo que pinta los actores
	public void paintMundo() {
		Graphics g = estrategia.getDrawGraphics();
		g.drawImage(SpriteCache.getSpriteCache().getSprite("fondoArkanoid1.jpg"), 0, 0, this);
		g.drawImage(SpriteCache.getSpriteCache().getSprite("vaus.png"), nave.getPosX(), nave.getPosY(), this);
		g.drawImage(SpriteCache.getSpriteCache().getSprite("bola.png"), bola.getPosX(), bola.getPosY(), this);
		paintLadrillos(g);
		estrategia.show();
		
	}
	
	//Main
	public static void main(String[] args) {
		
		Arkanoid juego = new Arkanoid();
		
		juego.bucleJuego();
	}
	
}
