package oca;

public class Casilla {
	private int orden;
	private String nombre;
	private Casilla destino;
	private int turnos;
	private String mensajeEspecial;
	
	
	public Casilla() {
		super();
	}


	public Casilla(int orden, String nombre, Casilla destino, int turnos, String mensajeEspecial) {
		super();
		this.orden = orden;
		this.nombre = nombre;
		this.destino = destino;
		this.turnos = turnos;
		this.mensajeEspecial = mensajeEspecial;
	}
	
	

	public Casilla(int orden, String nombre) {
		super();
		this.orden = orden;
		this.nombre = nombre;
	}


	public int getOrden() {
		return orden;
	}


	public void setOrden(int orden) {
		this.orden = orden;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Casilla getDestino() {
		return destino;
	}


	public void setDestino(Casilla destino) {
		this.destino = destino;
	}


	public int getTurnos() {
		return turnos;
	}


	public void setTurnos(int turnos) {
		this.turnos = turnos;
	}


	public String getMensajeEspecial() {
		return mensajeEspecial;
	}


	public void setMensajeEspecial(String mensajeEspecial) {
		this.mensajeEspecial = mensajeEspecial;
	}
	
	
	
}
