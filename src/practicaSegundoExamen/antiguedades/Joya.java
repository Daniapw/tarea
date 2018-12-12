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
		
		String str = "Año de fabricación: " + this.anyoFabricacion
						+ "\nOrigen: " + this.origen
						+ "\nPrecio: " + this.precio
						+ "\nMaterial: " + this.material;
		
		return str;
		
	}
	
	
}
