package tresEnRaya;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaJuego extends Canvas {

	private static final int ANCHO = 603;
	private static final int ALTO = 632;
	public Celda celdas[] = new Celda[9];
	
	public VentanaJuego() {
			
			//JFrame para mostrar la ventana en la que se ve el juego
			JFrame ventana = new JFrame("Tres en raya");
			
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
			
			this.setBackground(Color.WHITE);
			
			//A�adir MouseListener y su comportamiento
			this.addMouseListener(new MouseAdapter(){
				
				public void mouseClicked(MouseEvent e) {

					for (int i = 0; i < celdas.length; i++) {
						
						//Se comprueba si el jugador ha hecho clic en una celda y, si lo ha hecho, se ejecuta el m�todo clicCelda() de dicha celda
						if (celdas[i].comprobarCoordenadas(e.getX(), e.getY())) {
							
							celdas[i].clicCelda();
							
						}
						
					}
					
				}
				
				
			});
			
			inicializarCeldas();
	}
	
	//M�todo para inicializar las celdas
	private void inicializarCeldas() {
		celdas[0] = new Celda (0, 0, this);
		celdas[1] = new Celda (200, 0, this);
		celdas[2] = new Celda (400, 0, this);
		celdas[3] = new Celda (0, 200, this);
		celdas[4] = new Celda (200, 200, this);
		celdas[5] = new Celda (400, 200, this);
		celdas[6] = new Celda (0, 400, this);
		celdas[7] = new Celda (200, 400, this);
		celdas[8] = new Celda (400, 400, this);
	}
	
	//M�todo para resetear las celdas en caso de que los jugadores quieran volver a jugar
	
	public void resetearCeldas() {
		
		for (int i = 0; i < celdas.length; i++) {
			
			celdas[i].jugador = null;
			celdas[i].codigo = 0;
			
		}
		
	}
	
	//M�todo para pintar las celdas
	public void paint(Graphics g) {
		
		for (int i = 0; i < celdas.length; i++) {
			
			celdas[i].paintCelda(g);
			
		}
		
	}

	
}

