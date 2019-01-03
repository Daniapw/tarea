package formulaUno;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ahorcado.recursos.CacheImagen;
import formulaUno.recursos.CacheF1;

public class VentanaPodium extends Canvas {
	public static final int ANCHO = 600;
	public static final int ALTO = 400;
	public Vehiculo clasificacion[] = new Vehiculo[3];
	
	//Constructor
	public VentanaPodium(Vehiculo clasificacion[] ) {
		
		//JFrame para mostrar la ventana en la que se ve el juego
		JFrame ventanaPodium = new JFrame("Pódium");
		
		//Establezco las dimensiones de la ventana
		ventanaPodium.setBounds(600,300,ANCHO,ALTO);
		
		//Creación del panel principal de la ventana y le aÃ±adimos el objeto Ventana (el canvas)
		JPanel panel = (JPanel)ventanaPodium.getContentPane();

		panel.add(this);
		
		//Establezco el tamaÃ±o del Canvas
		this.setBounds(600, 600, ANCHO, ALTO);
		this.setBackground(Color.WHITE);

		
		//Establezco el comportamiento al darle a la X
		ventanaPodium.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Hago que la ventana sea visible y no se pueda redimensionar
		ventanaPodium.setVisible(true);
		ventanaPodium.setResizable(false);
		
		this.clasificacion = clasificacion;

	}
	
	public void paint(Graphics g) {
		
		//Coger imagen del podium
		g.drawImage(CacheF1.getCache().getPodium(), 100, 150, null);
		
		//Establecer tipo de letra
		g.setFont(new Font("Verdana", Font.BOLD, 16)); 
		
		g.setColor(new Color(46, 198, 0));
		g.drawString("¡Enhorabuena, habéis ganado!", 170, 45);
		//Establecer las posiciones del primero, segundo y tercero respectivamente
		
		clasificacion[0].setPosicion(262);
		clasificacion[0].setPosicionY(155);
		
		clasificacion[1].setPosicion(133);
		clasificacion[1].setPosicionY(181);
		
		clasificacion[2].setPosicion(398);
		clasificacion[2].setPosicionY(213);
		
		//Dibujar los vehículos con los nombres por encima (el nombre del tercero se escribe más a la derecha que el de los demás para que no se superponga con la imagen
		for (int i = 0; i < clasificacion.length; i++) {
			
			clasificacion[i].paint(g);
			
			g.setColor(Color.decode( clasificacion[i].getColor()));
			
			if (i != 2) {
				
				g.drawString(clasificacion[i].getPiloto(), clasificacion[i].getPosicion()-20,  clasificacion[i].getPosicionY() - 42);
			
			}else {
				
				g.drawString(clasificacion[i].getPiloto(), clasificacion[i].getPosicion()-8,  clasificacion[i].getPosicionY() - 42);
				
			}
		}
		
		
		
	}
}
