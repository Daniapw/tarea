package ahorcado;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends Canvas {

	private static final int ANCHO = 640;
	private static final int ALTO = 480;
	
	public static Ventana ventana = null;
	
	public Ventana() {
		
		//JFrame para mostrar la ventana en la que se ve el juego
		JFrame ventana = new JFrame("El juego del ahorcado");
		
		//Establecemos las dimensiones de la ventana
		ventana.setBounds(0, 0, ANCHO, ALTO);
		
		//Creaci√≥n del panel principal de la ventana y le a√±adimos el objeto Ventana (el canvas)
		JPanel panel = (JPanel)ventana.getContentPane();
		
		panel.add(this);
		
		//Establezco el tama√±o del Canvas
		this.setBounds(0,0,ANCHO,ALTO);
		this.setBackground(Color.white);
		
		//Establezco el comportamiento al darle a la X
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Hago visible la ventana y que no se pueda redimensionar
		ventana.setVisible(true);
		ventana.setResizable(false);
		
	}
	
	public void paint(Graphics g) {
	
		g.setColor(new Color(170, 119, 80));
		
		//Base del patÌbulo
		g.fillRect(200, 305, 130, 10);

		//Palo del patÌbulo
		g.fillRect(260, 90, 10, 220);
		
		//Soporte
		g.drawLine(310, 80, 260, 140);
		
		//Viga de la cuerda
		
		g.fillRect(260, 80, 170, 10);
		
		//Soga
		g.setColor(Color.orange);
		g.fillRect(400, 80, 2, 70);
		g.fillOval(380, 145, 28, 28);
		
		//Cabeza
		g.setColor(new Color(71, 138, 255));
		g.fillOval(380, 142, 28, 28);
		
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
		
	}
		
	public static Ventana getVentana() {
		if (ventana == null) {
			ventana = new Ventana();
		}
		return ventana;
	}
	
}
