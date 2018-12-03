package ahorcado;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ahorcado.recursos.CacheImagen;

public class Ventana extends Canvas {

	private static final int ANCHO = 640;
	private static final int ALTO = 480;
	private static String letraProgreso[] = Juego.getProgreso();
	private static String ventanaIntentos[] = Juego.getArrayIntentos();
	private static String letrasPorSeparado[] = Palabras.separarLetras();
	
	public static Ventana ventana = null;
	
	public Ventana() {
		
		//JFrame para mostrar la ventana en la que se ve el juego
		JFrame ventana = new JFrame("El juego del ahorcado");
		
		//Establecemos las dimensiones de la ventana
		ventana.setBounds(0, 0, ANCHO, ALTO);
		
		//Creación del panel principal de la ventana y le añadimos el objeto Ventana (el canvas)
		JPanel panel = (JPanel)ventana.getContentPane();
		
		panel.add(this);
		
		//Establezco el tamaño del Canvas
		this.setBounds(0,0,ANCHO,ALTO);
		this.setBackground(Color.white);
		this.setFont(new Font("Verdana", Font.PLAIN, 16));

		
		//Establezco el comportamiento al darle a la X
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Hago visible la ventana y que no se pueda redimensionar
		ventana.setVisible(true);
		ventana.setResizable(false);
		
	}
	
	
	public void paint(Graphics g) {
		
		g.drawImage(CacheImagen.getCache().getFondo(), 0, 0, null);
		
		g.setColor(new Color(170, 119, 80));
		
		//Base del pat�bulo
		g.fillRect(200, 305, 130, 10);

		//Viga principal del pat�bulo
		g.fillRect(260, 90, 10, 220);
		
		//Soporte
		int x[] = new int[] {310, 312, 262, 260};
		int y[] = new int[] {80, 82, 142, 140};
		g.fillPolygon(x, y, 4);
		
		//Viga de la cuerda
		g.fillRect(260, 80, 170, 10);
		
		//Soga
		g.setColor(Color.orange);
		g.fillRect(400, 80, 2, 70);
		
		//C�rculo para simular la soga alrededor del cuello
		g.fillOval(380, 145, 28, 29);
		
		//Cabeza
		g.setColor(new Color(71, 138, 255));
		g.fillOval(380, 143, 28, 28);
		
		//Ojos
		g.setColor(Color.black);
		g.drawLine(385,162,389,156);
		g.drawLine(385,156,389,162);
		g.drawLine(395,162,399,156);
		g.drawLine(395,156,399,162);
		
		//Torso
		g.setColor(new Color(71, 138, 255));
		g.fillRoundRect(385, 171, 25, 55, 70, 10);
		
		//Brazos
		g.fillRoundRect(377, 176, 7, 57, 40, 5);
		g.fillRoundRect(411, 176, 7, 57, 40, 5);
		
		//Piernas
		g.fillRoundRect(387, 210, 9, 65, 40, 5);
		g.fillRoundRect(398, 210, 9, 65, 40, 5);
		
		//Uni�n de los palos
		g.setColor(Color.black);
		g.drawLine(270, 90, 260, 80);
		
		//Progreso del jugador (huecos y letras de la palabra)
		int x1 = 150, x2 = 165, x3=235;
		
		for (int i = 0; i < Palabras.getPalabra().length();i++) {
			
			x1 += 30;
			x2 += 30;
			
			g.drawLine(x1, 370, x2, 370);
			g.drawString(letraProgreso[i], x1+4, 366);
			
		}
		
		//Palabras y letras intentadas por el jugador
		g.drawString("Letras/palabras intentadas:", 20, 420);
		
		for (int j = 0; j < Juego.getContadorEjecucion(); j++) {
			
			if (ventanaIntentos[j].length() == 1) {
				
				x3 += 20;
				g.drawString(ventanaIntentos[j], x3, 420);
				
			}
			else {
				
				x3 += 50;
				g.drawString(ventanaIntentos[j], x3, 420);
				
			}
		}

		
		//Intentos restantes:
		g.drawString("Nº de errores: " + Juego.getFallos() + "/6", 20, 440);
		
		//Sistema de fallos y aciertos
		if (Juego.isCoincidencia() == true ) {
			
			g.setColor(Color.green);
			g.drawString("¡Correcto!", 270, 40);
			
		}
		else {
			
			g.setColor(Color.red);
			
			if (Juego.getFallos() >= 1 && Juego.getFallos() < 6) {
				g.drawString("¡Incorrecto!", 270, 40);
			}
			else {
				if (Juego.getFallos() == 6) {
					
					g.drawString("Lo siento, has perdido", 220, 40);
					
					for (int i = 0; i < Palabras.getPalabra().length();i++) {
						
						x1=+30;
						g.drawString(letrasPorSeparado[i], x1, 366);
						
					}
					
				}
			}
		}
		
		
		g.setColor(Color.red);
		
		switch (Juego.getFallos()) {
			case 1:{
				
				//Torso
				g.fillRoundRect(385, 171, 25, 55, 70, 10);
				
				break;
			}
			case 2:{
				
				//Torso
				g.fillRoundRect(385, 171, 25, 55, 70, 10);
				
				//Brazo
				g.fillRoundRect(377, 176, 7, 57, 40, 5);
				
				break;
			}
			case 3:{
				
				//Torso
				g.fillRoundRect(385, 171, 25, 55, 70, 10);
				
				//Brazos
				g.fillRoundRect(377, 176, 7, 57, 40, 5);
				g.fillRoundRect(411, 176, 7, 57, 40, 5);
				
				
				break;
			}
			case 4:{

				//Torso
				g.fillRoundRect(385, 171, 25, 55, 70, 10);
				
				//Brazos
				g.fillRoundRect(377, 176, 7, 57, 40, 5);
				g.fillRoundRect(411, 176, 7, 57, 40, 5);
				
				//Pierna
				g.fillRoundRect(387, 210, 9, 65, 40, 5);
				
				break;
			}
			case 5:{
				
				//Torso
				g.fillRoundRect(385, 171, 25, 55, 70, 10);
				
				//Brazos
				g.fillRoundRect(377, 176, 7, 57, 40, 5);
				g.fillRoundRect(411, 176, 7, 57, 40, 5);
				
				//Piernas
				g.fillRoundRect(387, 210, 9, 65, 40, 5);
				g.fillRoundRect(398, 210, 9, 65, 40, 5);
				
				break;
			}
			
			case 6:{
				
				//Mensaje derrota
				g.setColor(Color.red);
				
				//Torso
				g.fillRoundRect(385, 171, 25, 55, 70, 10);
				
				//Brazos
				g.fillRoundRect(377, 176, 7, 57, 40, 5);
				g.fillRoundRect(411, 176, 7, 57, 40, 5);
				
				//Piernas
				g.fillRoundRect(387, 210, 9, 65, 40, 5);
				g.fillRoundRect(398, 210, 9, 65, 40, 5);
				
				//Cabeza
				g.fillOval(380, 143, 28, 28);
				
				//Ojos
				g.setColor(Color.black);
				g.drawLine(385,162,389,156);
				g.drawLine(385,156,389,162);
				g.drawLine(395,162,399,156);
				g.drawLine(395,156,399,162);
				
				break;
			}
			
		}
	
	

	}
	
	
	public static Ventana getVentana() {
		if (ventana == null) {
			ventana = new Ventana();
		}
		return ventana;
	}
	
}
