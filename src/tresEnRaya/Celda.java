package tresEnRaya;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

import javax.swing.JOptionPane;

public class Celda {
	public Jugador jugador = null;
	public int codigo = 0;
	public static final int ANCHO = 200;
	public static final int ALTO = 200;
	public VentanaJuego ventana = null;
	public int x;
	public int y;
	
	public Celda(int x, int y, VentanaJuego ventana) {
		
		this.x = x;
		this.y = y;
		this.ventana = ventana;
		
	}
	
	//Método que pinta la celda
	public void paintCelda(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setStroke(new BasicStroke(5.0f));
		
		g2d.setColor(Color.black);
		
		g2d.drawRect(this.x, this.y, ANCHO, ALTO);
		
		
		//Según el código del jugador que la ocupe se pintará una equis o un círculo
		if (this.codigo == 1) {

			g2d.setStroke(new BasicStroke(14.0f));
			
			g2d.setColor(new Color(40, 94, 183));
			
			g2d.drawLine(this.x+ 22, this.y+22, this.x +178, this.y + 178);
			
			g2d.drawLine(this.x + 22 , this.y + 178, this.x + 178, this.y + 22);
			
		}

		if (this.codigo == 2) {
			
			g2d.setStroke(new BasicStroke(14.0f));
			
			g2d.setColor(new Color(229, 18, 18));
			g2d.drawOval(this.x + 16 , this.y+ 16, 168, 168);
			
			
		}
			
			
		
	}
	
	
	//Método para comprobar si el ratón ha hecho clic en una celda
	public boolean comprobarCoordenadas(int puntoX, int puntoY) {
		
		boolean estaEnCoordenadas;
		
		if ( puntoX > this.x && puntoX < (this.x + ANCHO)
				&& puntoY > this.y && puntoY < (this.y + ALTO)) {
			
			estaEnCoordenadas = true;
			
		}
		else {
			
			estaEnCoordenadas = false;
			
		}
		
		return estaEnCoordenadas;
		
	}
	
	//Método que determina el comportamiento interno de la celda cuando se le hace clic
	public void clicCelda() {
		String jugarOtraVez;
		
		if (!PrincipalTresEnRaya.tablero.esEmpate() && !PrincipalTresEnRaya.tablero.haGanado()) {
			
			//Si la celda ya ha sido ocupada la celda no cambia y se emite un mensaje
			if (this.jugador != null) {
				
				JOptionPane.showMessageDialog(null, "Esta casilla ya está ocupada, elige otra");
				
			}
			//Si la celda no está ocupada:
			else {
				
				//Se establece el jugador de la celda al jugador que hecho clic
				this.jugador = PrincipalTresEnRaya.getJugadorActivo();
				this.codigo = this.jugador.codigo;
				
				//El valor de la matriz correspondiente a esta celda también cambiará al código del jugador activo
				PrincipalTresEnRaya.tablero.matriz[this.x/ANCHO][this.y/ALTO] = this.jugador.codigo;
				
				//Se repintará la ventana para ver el resultado
				this.ventana.repaint();
				
				//Si tras cambiar el valor de la celda el jugador gana, la partida acabará y se mostrará un mensaje felicitando al jugador
				if (PrincipalTresEnRaya.tablero.haGanado()) {
					
					JOptionPane.showMessageDialog(null, "Fin de la partida, el jugador " + this.jugador.codigo + " ("+ this.jugador.nombre + ") " + " ha ganado!");
					
					//Se le pregunta a los jugadores si quieren volver a jugar mediante un inputDialog (tienen que responder S ó N)
					do {
					
						jugarOtraVez = JOptionPane.showInputDialog("Jugar otra vez? (S/N)");
					
					}while(!jugarOtraVez.equalsIgnoreCase("S") && !jugarOtraVez.equalsIgnoreCase("N"));
					
					//En caso de que la respuesta sea afirmativa se reseteará el juego y se repintará la ventana
					if (jugarOtraVez.equalsIgnoreCase("S")) {
						
						PrincipalTresEnRaya.resetearJuego();
						
						this.ventana.repaint();
						
					}
					//En caso de que la respuesta sea negativa se cerrará el programa
					else {
						
						System.exit(0);
						
					}
					
					
				}
				//En caso de que el jugador no haya ganado con este movimiento la partida continúa
				else {
					
					PrincipalTresEnRaya.avanzarTurno();
					
				}
				
			}
	
		}
		
		//Si hay un empate terminará el juego
		if (PrincipalTresEnRaya.tablero.esEmpate() && !PrincipalTresEnRaya.tablero.haGanado()) {
		
			JOptionPane.showMessageDialog(null, "Fin de la partida, es un empate!");
			
			//Se le pregunta a los jugadores si quieren volver a jugar mediante un inputDialog (tienen que responder S ó N)
			do {
			
				jugarOtraVez = JOptionPane.showInputDialog("Jugar otra vez? (S/N)");
			
			}while(!jugarOtraVez.equalsIgnoreCase("S") && !jugarOtraVez.equalsIgnoreCase("N"));
			
			
			//En caso de que la respuesta sea afirmativa se reseteará el juego y se repintará la ventana
			if (jugarOtraVez.equalsIgnoreCase("S")) {
				
				PrincipalTresEnRaya.resetearJuego();
				
				this.ventana.repaint();
				
			}
			//En caso de que la respuesta sea negativa se cerrará el programa
			else {
				
				System.exit(0);
				
			}
			
		}
	
	}
	
	
	
}
