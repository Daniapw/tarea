package formulaUno;

import java.awt.Color;
import java.awt.Graphics;

public class Coche extends Vehiculo {
	
	//Constructor
	public Coche (String nombrePiloto, int posicionY, String color) {
		super();
		
		this.setPiloto(nombrePiloto);
		this.setPosicionY(posicionY);
		this.setColor(color);
	}
	
	//Método abstracto heredado de la superclase Vehículo: imprime el coche en pantalla
	public void paint(Graphics g){
		
		int x = this.getPosicion();
		int y = this.getPosicionY();
		
		//Coordenadas para dibujar los polígonos
		int posicionesX[] = new int[] {x, x, x+13, x + 23, x + 46, x + 63, x + 78, x +78, x} ;
		int posicionesY[] = new int[] {y, y - 15, y - 15, y - 23, y - 23, y - 15, y-11 ,y, y};
		
		int ventanaX[] = new int[] {x + 36, x + 46, x + 60, x+36};
		int ventanaY[] = new int[] {y- 19, y - 19, y - 11, y - 11};
		
		//Dibujar el polígono
		g.setColor(Color.decode(getColor()));
		g.fillPolygon(posicionesX, posicionesY, 9);
		
		//Ventana
		g.setColor(new Color(229, 229, 229));
		g.fillPolygon(ventanaX, ventanaY, 4);
		
		g.setColor(Color.black);
		g.drawPolygon(ventanaX, ventanaY, 4);
		
		//Ruedas y llantas
		g.setColor(Color.black);
		g.fillOval(x + 6, y - 5 , 15, 15);
		g.fillOval(x + 54, y - 5, 15, 15);
		
		g.setColor(Color.gray);
		g.fillOval(x+ 9, y - 3, 9, 9);
		g.fillOval(x+ 57, y - 3, 9, 9);
		
		
	}
	
	public String toString() {
		
		String str;
		str= "[Posición actual de " + this.getPiloto() + ": " + this.getPosicion() + "]";
		return str;
	}
}
