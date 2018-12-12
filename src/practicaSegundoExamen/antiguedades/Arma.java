package practicaSegundoExamen.antiguedades;

public class Arma extends Antiguedad {

	public String tipoArma;
	
	public Arma() {
		super();
	}
	
	public Arma(int anyo, String origen, int precio, String tipoArma) {
		
		super(anyo, origen, precio);
		
		this.tipoArma = tipoArma;
		
	}
	
	
	public String toString() {
		
		String str = "Año de fabricación: " + this.anyoFabricacion
						+ "\nOrigen: " + this.origen
						+ "\nPrecio: " + this.precio
						+ "\nTipo de arma: " + this.tipoArma;
		
		return str;
		
	}
}
