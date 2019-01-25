package arkanoid.version01;

import java.awt.Canvas;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Arkanoid extends Canvas {
	public static final int ANCHO = 500; 
	public static final int ALTO = 700;

	public Arkanoid() {
		
		JFrame ventanaJuego = new JFrame("Arkanoid");
		JPanel panel = (JPanel) ventanaJuego.getContentPane();
		panel.add(this);
		ventanaJuego.setBounds(0,0, ANCHO + 5,ALTO+28);
		ventanaJuego.setVisible(true);
		ventanaJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaJuego.setResizable(false);
	}
	
	public void paint(Graphics2D g) {
		
		
	}
	
	
	public static void main(String[] args) {
		
		Arkanoid juego = new Arkanoid();
		
	}
	
}
