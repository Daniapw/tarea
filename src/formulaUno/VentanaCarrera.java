package formulaUno;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaCarrera extends Canvas{

	public static final int ANCHO = 650;
	public static final int ALTO = 600;
	public Carrera carrera = new Carrera();
	
	//Constructor
	public VentanaCarrera( Carrera carrera) {
		
		//JFrame para mostrar la ventana en la que se ve el juego
		JFrame ventanaJuego = new JFrame("FÛrmula 1");
		
		//Establezco las dimensiones de la ventana
		ventanaJuego.setBounds(0,0,ANCHO,ALTO);
		
		//CreaciÛn del panel principal de la ventana y le a√±adimos el objeto Ventana (el canvas)
		JPanel panel = (JPanel)ventanaJuego.getContentPane();

		panel.add(this);
		
		//Establezco el tama√±o del Canvas
		this.setBounds(0, 0, ANCHO, ALTO);
		this.setBackground(Color.WHITE);

		
		//Establezco el comportamiento al darle a la X
		ventanaJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Hago que la ventana sea visible y no se pueda redimensionar
		ventanaJuego.setVisible(true);
		ventanaJuego.setResizable(false);
		
		this.carrera = carrera;
	}
	
	public void paint(Graphics g) {
		
		g.setFont(new Font("Verdana", Font.BOLD, 16)); 
		paintPistas(g);
		
		for (int i = 0; i < 5; i++) {
			
			carrera.participantes[i].paint(g);
			
		}
		
		
	}
	
	//Pintar pistas
	public void paintPistas(Graphics g) {
		
		//Coordenada Y de las pistas
		int yPistas = 85;
		
		//Coordenadas para los polÌgonos que hacen de asfalto
		int xAsfalto[] = new int [] {0, 45, 620, 590};
		int yAsfaltoYMeta[] = new int [4];
		
		//Coordenadas X para dibujar las lÌneas de meta (lÌnea roja)
		int xMeta[] = new int[] {520, 550, 560, 530};

		for (int i = 0; i < 5; i++) {
			
			yAsfaltoYMeta[0] = yPistas;
			yAsfaltoYMeta[1] = yPistas - 40;
			yAsfaltoYMeta[2] = yPistas - 40;
			yAsfaltoYMeta[3] = yPistas;
			
			//Dibujar asfalto
			g.setColor(Color.DARK_GRAY);
	
			g.fillPolygon(xAsfalto, yAsfaltoYMeta, 4);
			
			//Nombres de los participantes
			g.setColor(Color.decode(carrera.participantes[i].getColor()));
			g.drawString(carrera.participantes[i].getPiloto(), 240, yPistas-65);
			
			//Pintar lÌnea de inicio
			g.setColor(Color.blue);
			
			//Pintar lÌnea de meta
			g.setColor(Color.orange);
			
			g.fillPolygon(xMeta, yAsfaltoYMeta, 4);
			
			//Pintar obst·culos
			int x;
			for (int j = 0; j < 4; j++) {
				
				x = carrera.pistas[i].obstaculos[j].getLugarInicio();
				int posicionesRampaX[] = new int[] {x, x+50, x+50,x};
				int posicionesRampaY[] = new int[] {yPistas-20, yPistas -55, yPistas -20, yPistas - 20};
				
				//Este if pintar· una rampa o una mancha de aceite seg˙n el obst·culo
				if (carrera.pistas[i].obstaculos[j] instanceof Rampa) {
					
					g.setColor(new Color(255, 197, 94));
					g.fillPolygon(posicionesRampaX, posicionesRampaY,4);
					
				}
				else {
					g.setColor(new Color(155, 41, 0));
					g.fillOval(x, yPistas - 35, 50, 25);
				
				}
			}
			
			
			yPistas += 120;
			
			
		}	
	}
	
}
