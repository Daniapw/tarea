package practicaSegundoExamen.antiguedades;

public class Joya extends Antiguedad {

	public String material;
	
	public Joya() {
		super();
	}
	
	public Joya(int anyo, String origen, int precio, String material) {
		
		super(anyo, origen, precio);
		
		this.material = material;
		
	}
	
	public String toString() {
		
		String str = "A�o de fabricaci�n: " + this.anyoFabricacion
						+ "\nOrigen: " + this.origen
						+ "\nPrecio: " + this.precio
						+ "\nMaterial: " + this.material;
		
		return str;
		
	}
	
	
}
