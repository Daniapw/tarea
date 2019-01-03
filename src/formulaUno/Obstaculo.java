package formulaUno;

public abstract class Obstaculo {
	private String tipo;
	private int valor = 0;
	private int lugarInicio;
	private int lugarFin;
	
	
	
	public abstract int inicializa();

	
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}


	public int getLugarInicio() {
		return lugarInicio;
	}


	public void setLugarInicio(int lugar) {
		this.lugarInicio = lugar;
	}


	public int getLugarFin() {
		return lugarFin;
	}


	public void setLugarFin(int lugarFin) {
		this.lugarFin = lugarFin;
	}
	
	
}
