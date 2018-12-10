package formulaUno;

public abstract class Vehiculo {
	
	private String piloto;
	private int posicion;
	private int turno = -1;
	private int pista;
	
	public int avanza() {
		
		int numero = (int) Math.round(Math.random()* (50 - 3)) + 3;
		
		posicion+=numero;
		
		return numero;
		
	}
	
	
	public abstract void paint();

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
	
	
	
	
	
	
}




