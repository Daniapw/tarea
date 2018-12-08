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

	
	public static Ventana ventana = null;
	
	public Ventana() {
		
		//JFrame para mostrar la ventana en la que se ve el juego
		JFrame ventana = new JFrame("El juego del ahorcado");
		
		//Establecemos las dimensiones de la ventana
		ventana.setBounds(0, 0, ANCHO, ALTO);
		
		//CreaciÃ³n del panel principal de la ventana y le aÃ±adimos el objeto Ventana (el canvas)
		JPanel panel = (JPanel)ventana.getContentPane();
		
		panel.add(this);
		
		//Establezco el tamaÃ±o del Canvas
		this.setBounds(0,0,ANCHO,ALTO);
		this.setFont(new Font("Verdana", Font.PLAIN, 16));
		
		//Establezco el comportamiento al darle a la X
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Hago visible la ventana y que no se pueda redimensionar
		ventana.setVisible(true);
		ventana.setResizable(false);
		
	}
	
	
	public void paint(Graphics g) {
		
		//Establecer la imagen de fondo. Si el juego está en modo navidad, cogerá el fondo navideño
		if (Juego.isNavidad() == false) {
			
			g.drawImage(CacheImagen.getCache().getFondo(), 0, 0, null);
			
		}
		else {
			
			g.drawImage(CacheImagen.getCache().getFondoNavidad(), 0, 0, null);
			
		}
		
		
		if (Juego.isNavidad() == true) {
			
			g.setColor(Color.white);
			
		}
		else {
			
			g.setColor(new Color(204, 137, 75));
			
		}
		
		//Base del patï¿½bulo
		g.fillRect(200, 340, 130, 13);
		
		//Viga principal del patï¿½bulo
		g.fillRect(260, 120, 13, 220);
		
		//Viga de la cuerda
		g.fillRect(260, 110, 170, 13);
		
		//Soporte
		int x[] = new int[] {310, 314, 276, 272};
		int y[] = new int[] {122, 126, 166, 162};
		g.fillPolygon(x, y, 4);
		
		//Soga
		g.setColor(Color.orange);
		g.fillRect(400, 110, 3, 70);
		
		//Cï¿½rculo para simular la soga alrededor del cuello
		g.fillOval(380, 165, 28, 29);
		
		//Cabeza
		g.setColor(new Color(17, 150, 15));
		g.fillOval(380, 163, 28, 28);
		
		int xGorro[] = new int[] { 380, 408, 395};
		int yGorro[] = new int[] { 170, 170, 139};
		
		
		//Si el juego está en modo navidad le dibujará un gorrito al personaje
		if (Juego.isNavidad() == true) {
			
			g.setColor(Color.red);
			

			g.fillPolygon(xGorro, yGorro, 3);
			
			g.setColor(Color.white);
			g.fillRect(380, 169, 30, 3);
			g.fillOval(391, 138, 7, 7);
		}
		
		//Ojos
		g.setColor(Color.white);
		g.fillOval(385, 173, 7, 7);
		g.fillOval(395, 173, 8, 8);
		g.setColor(Color.black);
		g.fillOval(387, 174, 4, 4);
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
		g.drawPolygon(x, y, 4);
		
		
		
		//Progreso del jugador (huecos y letras de la palabra)
		int x1 = 100, x2 = 115, x3=260;
		
		g.setColor(Color.black);
		
		for (int i = 0; i < Palabras.getPalabra().length();i++) {
			
			x1 += 30;
			x2 += 30;
			
			g.drawLine(x1, 400, x2, 400);
			g.drawString(letraProgreso[i], x1+4, 397);
			
		}
		
		//Dibujar palabras y letras intentadas por el jugador
		g.drawString("Letras/palabras intentadas:", 45, 430);
		
		for (int j = 0; j < Juego.getContadorEjecucion(); j++) {
			
			if (ventanaIntentos[j].length() == 1) {
				
				x3 += 20;
				g.drawString(ventanaIntentos[j], x3, 430);
				
			}
			else {
				
				if (!Juego.esTrampa()) {
					
					x3 += 50;
					g.drawString(ventanaIntentos[j], x3, 430);
					
				}
			}
		}

		
		//Intentos restantes:
		g.drawString("NÂº de errores: " + Juego.getFallos() + "/6", 45, 448);
		
		//Mensaje para saber si godmode estï¿½ activado
		if (Juego.isGodmode() == true) {
			
			g.setColor(new Color(255, 124, 25));
			g.drawString("Modo inmortal activado", 10, 30);
			
		}
		
		//Mensaje para saber si se ha usado la pista
		if (Juego.isPista() == true) {
			
			g.setColor(new Color(255, 124, 25));
			g.drawString("Has usado la pista", 10, 50);
			
		}
		
		//Mensaje del modo navideño
		
		if (Juego.isNavidad() == true) {
			
			g.setColor(Color.white);
			g.drawString("Modo navideño activado!", 10, 70);
			
		}
		
		//RepresentaciÃ³n de fallos y aciertos
		//Si el jugador acierta
		if (Juego.isCoincidencia() == true ) {
			
			//Poner un tono más brillante si el modo navideño está activado
			if (Juego.isNavidad() == true) {
			
				g.setColor(new Color(21, 252, 0));
				
			}
			
			else {
				
				g.setColor(new Color(0, 132, 11));
				
			}
			
			
			if (!Juego.isTerminado() && !Juego.esTrampa()) {
			
				g.drawString("Correcto!", 240, 60);
				
				
			}
			else {
				
				if (!Juego.esTrampa()) {
					
					g.drawString("Enhorabuena, has ganado!", 240, 60);
					
				}
			}
		}
		
		//Si el jugador falla
		else {
			
			//Poner un tono más brillante si el modo navideño está activado
			if (Juego.isNavidad() == true) {
			
				g.setColor(new Color(255, 35, 35));
				
			}
			
			else {
				
				g.setColor(new Color(247, 19, 46));
				
			}
			
			
			if (Juego.isCoincidencia() == false && Juego.getFallos() < 6 && Juego.getContadorEjecucion() > 0) {
				
				//Este if es para que no se imprima el mensaje cuando el jugador active o desactive un cheat
				if (!Juego.esTrampa()){
					
					g.drawString("Incorrecto!", 240, 60);
					
				}
				
				
			}
			else {
				
				if (Juego.getFallos() == 6) {

					g.drawString("Lo siento, has perdido", 240, 60);
					
					x1 = 100;
					
					//Este bucle imprime en rojo los caracteres que el jugador no habÃ­a adivinado 
					for (int i = 0; i < Palabras.getPalabra().length();i++) {
	
						x1+=30;
						
						if (letraProgreso[i].equals(" ")) {
							
							g.setColor(Color.red);
							g.drawString(letrasPorSeparado[i], x1+2, 397);

						}

					}
				}
			}
		}
		
		
		//Dibujar partes en rojo segÃºn el nÃºmero de fallos
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
				
				//Gorro (si el modo navideño está activado). Lo dibujo otra vez para que se superponga a la cabeza en rojo
				if (Juego.isNavidad() == true) {
					
					g.fillPolygon(xGorro, yGorro, 3);
					
					g.setColor(Color.white);
					g.fillRect(380, 169, 30, 3);
					g.fillOval(391, 138, 7, 7);
				}
				
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
	
	//Boolean para saber si el jugador ha activado un cheat en esta ejecuciï¿½n

	public static Ventana getVentana() {
		if (ventana == null) {
			ventana = new Ventana();
		}
		return ventana;
	}


	public static String[] getLetraProgreso() {
		return letraProgreso;
	}


	public static void setLetraProgreso(String[] letraProgreso) {
		Ventana.letraProgreso = letraProgreso;
	}


	public static String[] getVentanaIntentos() {
		return ventanaIntentos;
	}


	public static void setVentanaIntentos(String[] ventanaIntentos) {
		Ventana.ventanaIntentos = ventanaIntentos;
	}


	public static String[] getLetrasPorSeparado() {
		return letrasPorSeparado;
	}


	public static void setLetrasPorSeparado(String[] letrasPorSeparado) {
		Ventana.letrasPorSeparado = letrasPorSeparado;
	}
	
	
	//Getters y setters
	
	
}
