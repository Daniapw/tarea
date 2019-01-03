package formulaUno;

import java.awt.Color;
import java.awt.Graphics;

public class Moto extends Vehiculo {
	
	
	//Constructor
	public Moto (String nombrePiloto, int posicionY, String color) {
		super();
		
		this.setPiloto(nombrePiloto);
		this.setPosicionY(posicionY);
		this.setColor(color);
	}
	
	//Método abstracto heredado de la superclase Vehículo: pinta el coche en pantalla según su posición
	public void paint(Graphics g) {
		
		int x = this.getPosicion();
		int y = this.getPosicionY();
		
		int posicionesX[] = new int[] {x+12, x+27, x+33, x +18};
		int posicionesY[] = new int[] {y, y-22, y-22, y};
		
		int posicionesX2[] = new int[] {x+60, x+45, x+40, x +55};
		int posicionesY2[] = new int[] {y, y-22, y-22, y};
		
		int posicionesX3[] = new int[] {x+5,  x+25, x+65, x+ 62, x + 5};
		int posicionesY3[] = new int[] {y - 10, y-20, y-20, y-10, y-10};
		
		//Moto
		g.setColor(Color.decode(getColor()));
		g.fillPolygon(posicionesX, posicionesY, 4);
		
		g.fillPolygon(posicionesX2, posicionesY2, 4);
		
		g.fillPolygon(posicionesX3, posicionesY3, 5);
		
		//Manillar
		g.fillRect(x+58, y-30, 5, 20);
		
		//Chasis ruedas
		g.fillOval(x + 5, y - 8 , 19, 19);
		g.fillOval(x + 53, y - 7, 19, 19);
		
		//Asiento
		g.setColor(Color.black);
		g.fillRect(x + 27, y - 22, 18, 7);
		
		//Ruedas y llantas
		g.setColor(Color.black);
		g.fillOval(x + 6, y - 5 , 18, 18);
		g.fillOval(x + 54, y - 5, 18, 18);
		
		g.setColor(Color.gray);
		g.fillOval(x+ 9, y - 2, 10, 10);
		g.fillOval(x+ 57, y - 2, 10, 10);
		
	}

	public String toString() {
		
		String str;
		str= "[Posición actual de " + this.getPiloto() + ": " + this.getPosicion() + "]";
		return str;
	}
	
}
