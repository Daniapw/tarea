package ahorcado;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ahorcado.recursos.CacheImagen;

public class Ventana extends Canvas {

	private static final int ANCHO = 640;
	private static final int ALTO = 480;
	private static String letraProgreso[] = Juego.getProgreso();
	private static String ventanaIntentos[] = Juego.getArrayIntentos();
	private static String letrasPorSeparado[] = Palabras.separarLetras();
	private static boolean trampaActivada = false;
	
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
		this.setFont(new Font("Verdana", Font.PLAIN, 16));
		
		//Establezco el comportamiento al darle a la X
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Hago visible la ventana y que no se pueda redimensionar
		ventana.setVisible(true);
		ventana.setResizable(false);
		
	}
	
	
	public void paint(Graphics g) {
		
		g.drawImage(CacheImagen.getCache().getFondo(), 0, 0, null);
		
		g.setColor(new Color(204, 137, 75));
		
		//Base del pat�bulo
		g.fillRect(200, 340, 130, 13);
		
		//Viga principal del pat�bulo
		g.fillRect(260, 120, 13, 220);
		
		//Soporte
		int x[] = new int[] {310, 314, 264, 260};
		int y[] = new int[] {118, 122, 166, 162};
		g.fillPolygon(x, y, 4);
		
		//Viga de la cuerda
		g.fillRect(260, 110, 170, 13);
		
		//Soga
		g.setColor(Color.orange);
		g.fillRect(400, 112, 3, 70);
		
		//C�rculo para simular la soga alrededor del cuello
		g.fillOval(380, 165, 28, 29);
		
		//Cabeza
		g.setColor(new Color(17, 150, 15));
		g.fillOval(380, 163, 28, 28);
		
		//Ojos
		g.setColor(Color.white);
		g.fillOval(385, 173, 7, 7);
		g.fillOval(395, 173, 7, 7);
		g.setColor(Color.black);
		g.fillOval(387, 175, 4, 4);
		g.fillOval(397, 175, 4, 4);
		
		//Torso
		g.setColor(new Color(17, 150, 15));
		g.fillRoundRect(385, 191, 25, 55, 70, 10);
		
		//Brazos
		g.fillRoundRect(377, 196, 7, 57, 40, 5);
		g.fillRoundRect(411, 196, 7, 57, 40, 5);
		
		//Piernas
		g.fillRoundRect(387, 240, 9, 65, 40, 5);
		g.fillRoundRect(398, 240, 9, 65, 40, 5);
		
		
		//Bordes
		g.setColor(Color.black);
		g.drawRect(200, 340, 130, 13);
		g.drawRect(260, 123, 13, 217);
		g.drawRect(260, 110, 170, 13);


		
		//Progreso del jugador (huecos y letras de la palabra)
		int x1 = 170, x2 = 185, x3=260;
		
		g.setColor(Color.black);
		
		for (int i = 0; i < Palabras.getPalabra().length();i++) {
			
			x1 += 30;
			x2 += 30;
			
			g.drawLine(x1, 384, x2, 384);
			g.drawString(letraProgreso[i], x1+4, 380);
			
		}
		
		//Dibujar palabras y letras intentadas por el jugador
		g.drawString("Letras/palabras intentadas:", 45, 420);
		
		for (int j = 0; j < Juego.getContadorEjecucion(); j++) {
			
			if (ventanaIntentos[j].length() == 1) {
				
				x3 += 20;
				g.drawString(ventanaIntentos[j], x3, 420);
				
			}
			else {
				
				if (!esTrampa()) {
					
					x3 += 50;
					g.drawString(ventanaIntentos[j], x3, 420);
					
				}
			}
		}

		
		//Intentos restantes:
		g.drawString("Nº de errores: " + Juego.getFallos() + "/6", 45, 440);
		
		//Mensaje para saber si godmode est� activado
		if (Juego.isGodmode() == true) {
			
			g.setColor(new Color(255, 124, 25));
			g.drawString("Modo inmortal activado", 10, 30);
			
		}
		
		//Representación de fallos y aciertos
		//Si el jugador acierta
		if (Juego.isCoincidencia() == true ) {
			
			g.setColor(new Color(0, 132, 11));
			
			if (!Juego.isTerminado() && !esTrampa()) {
			
				g.drawString("Correcto!", 240, 60);
			
			}
			else {
				
				if (!esTrampa()) {
					
					g.drawString("Enhorabuena, has ganado!", 240, 60);
					
				}
			}
		}
		//Si el jugador falla
		else {
			
			g.setColor(new Color(247, 19, 46));
			
			if (Juego.isCoincidencia() == false && Juego.getFallos() < 6 && Juego.getContadorEjecucion() > 0) {
				
				//Este if es para que no se imprima el mensaje cuando el jugador active o desactive un cheat
				if (!esTrampa()){
					
					g.drawString("Incorrecto!", 240, 60);
					
				}
				
				
			}
			else {
				
				if (Juego.getFallos() == 6) {

					g.drawString("Lo siento, has perdido", 240, 60);
					
					x1 = 170;
					
					//Este bucle imprime en rojo los caracteres que el jugador no había adivinado 
					for (int i = 0; i < Palabras.getPalabra().length();i++) {
	
						x1+=30;
						
						if (letraProgreso[i] == " ") {
							
							g.setColor(Color.red);
							g.drawString(letrasPorSeparado[i], x1+2, 380);

						}

					}
				}
			}
		}
		
		
		//Dibujar partes en rojo según el número de fallos
		g.setColor(new Color(247, 19, 46));
		
		switch (Juego.getFallos()) {
			case 1:{
				x1=+30;
				//Torso
				g.fillRoundRect(385, 191, 25, 55, 70, 10);
				
				break;
			}
			case 2:{
				
				//Torso
				g.fillRoundRect(385, 191, 25, 55, 70, 10);
				
				//Brazo
				g.fillRoundRect(377, 196, 7, 57, 40, 5);
				
				break;
			}
			case 3:{
				
				//Torso
				g.fillRoundRect(385, 191, 25, 55, 70, 10);
				
				//Brazos
				g.fillRoundRect(377, 196, 7, 57, 40, 5);
				g.fillRoundRect(411, 196, 7, 57, 40, 5);
				
				
				break;
			}
			case 4:{

				//Torso
				g.fillRoundRect(385, 191, 25, 55, 70, 10);
				
				//Brazos
				g.fillRoundRect(377, 196, 7, 57, 40, 5);
				g.fillRoundRect(411, 196, 7, 57, 40, 5);
				
				//Pierna
				g.fillRoundRect(387, 240, 9, 65, 40, 5);
				
				break;
			}
			case 5:{
				
				//Torso
				g.fillRoundRect(385, 191, 25, 55, 70, 10);
				
				//Brazos
				g.fillRoundRect(377, 196, 7, 57, 40, 5);
				g.fillRoundRect(411, 196, 7, 57, 40, 5);
				
				//Piernas
				g.fillRoundRect(387, 240, 9, 65, 40, 5);
				g.fillRoundRect(398, 240, 9, 65, 40, 5);
				
				break;
			}
			
			case 6:{
				
				//Torso
				g.fillRoundRect(385, 191, 25, 55, 70, 10);
				
				//Brazos
				g.fillRoundRect(377, 196, 7, 57, 40, 5);
				g.fillRoundRect(411, 196, 7, 57, 40, 5);
				
				//Piernas
				g.fillRoundRect(387, 240, 9, 65, 40, 5);
				g.fillRoundRect(398, 240, 9, 65, 40, 5);
				
				//Cabeza
				g.fillOval(380, 163, 28, 28);
				
				//Ojos
				g.setColor(Color.black);
				g.drawLine(385,182,389,176);
				g.drawLine(385,176,389,182);
				g.drawLine(395,182,399,176);
				g.drawLine(395,176,399,182);
				
				break;
			}
			
		}
	
	

	}
	
	//Boolean para saber si el jugador ha activado un cheat en esta ejecuci�n
	private boolean esTrampa() {
		trampaActivada = false;
		if (Juego.getIntento().equals("godmode on") || Juego.getIntento().equals("godmode off")) {
			
			trampaActivada = true;
		
		}
		else {
			
			trampaActivada = false;
			
		}
		
		return trampaActivada;
	}
	
	
	public static Ventana getVentana() {
		if (ventana == null) {
			ventana = new Ventana();
		}
		return ventana;
	}
	
}
