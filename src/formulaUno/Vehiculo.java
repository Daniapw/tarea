package formulaUno;

public abstract class Vehiculo {
	
	private String piloto;
	private int posicion;
	private int turno = -1;
	private int pista;
	private boolean terminado = false;
	
	//Metodo para que el vehículo avance
	public int avanza() {
		
		int numero = (int) Math.round(Math.random()* (50 - 3)) + 3;
		
		posicion+=numero;
		
		return numero;
		
	}
	
	//Método para saber si un vehículo ha terminado
	public boolean haTerminado(){
		
		if (this.posicion >= 500) {
			
			terminado = true;
			
		}
		
		return terminado;
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




