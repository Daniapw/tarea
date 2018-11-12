package oca;

public class Jugador {
	private String nombre;
	private int posicion = 0;
	
	
	public Jugador(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Jugador(String nombre, int posicion) {
		super();
		this.nombre = nombre;
		this.posicion = posicion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	
	/**
	 * 
	 */
	
	public void tirarDado() {
		int dado = (int) Math.round(Math.random()*(6-1)+1);
		this.posicion += dado;
		
		if (this.posicion > 62) {
			this.posicion = 62 - (this.posicion - 62);
		}
	}
	
	/**
	 * 
	 */
	
	public void imprimir() {
		System.out.println(this.nombre + "- Posición: " + this.posicion);
	}
}
