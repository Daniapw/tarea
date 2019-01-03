package formulaUno;

import java.awt.Graphics;

public abstract class Vehiculo {
	
	private String piloto;
	private String color;
	private int posicion = 0;
	private int posicionY;
	private int turno = -1;
	private int pista;

	private boolean terminado = false;

	private int podium = -1;


	//M�todo que hace que los jugadores avancen generando un n�mero aleatorio entre 15 y 50 y sum�ndoselo a la posici�n

	public int avanza() {
		
		int numero = (int) Math.round(Math.random()* (50 - 15)) + 15;
		
		posicion+=numero;
		
		//El jugador no puede sobrepasar la meta
		if (posicion > Pista.META) {
			
			posicion = 530;
			
		}
		
		return numero;
		
	}
	

	//Método para saber si un vehículo ha terminado
	public boolean haTerminado(){
		
		if (this.posicion >= 530) {
			
			terminado = true;
			
		}
		
		return terminado;
	}

	
	//M�todo abstracto que se desarrolla en las subclases de veh�culo
	public abstract void paint(Graphics g);

	//Getters y setters
	
	public String getPiloto() {
		return piloto;
	}

	public void setPiloto(String piloto) {
		this.piloto = piloto;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}


	public int getPista() {
		return pista;
	}


	public void setPista(int pista) {
		this.pista = pista;
	}

	public int getPodium() {
		return podium;
	}

	public void setPodium(int podium) {
		this.podium = podium;
	}

	public int getPosicionY() {
		return posicionY;
	}

	public void setPosicionY(int posicionY) {
		this.posicionY = posicionY;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
	
	
	
	
}




