package practicaSegundoExamen.antiguedades;

public class Mueble extends Antiguedad{
	
	public String tipoMadera;

	public Mueble() {
		super();
	}
	public Mueble(int anyo, String origen, int precio, String madera) {
		
		super(anyo, origen, precio);
		
		this.tipoMadera = madera;
	}
	
	
	public String toString() {
		
		String str = "A�o de fabricaci�n: " + this.anyoFabricacion
						+ "\nOrigen: " + this.origen
						+ "\nPrecio: " + this.precio
						+ "\nTipo de madera: " + this.tipoMadera;
		
		return str;
		
	}
}
