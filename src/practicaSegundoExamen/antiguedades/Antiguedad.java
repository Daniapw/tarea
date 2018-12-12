package practicaSegundoExamen.antiguedades;

public class Antiguedad {
	public int anyoFabricacion;
	public String origen;
	public int precio;
	
	public Antiguedad() {
		super();
	}
	
	public Antiguedad(int anyo, String origen, int precio) {
		
		this.anyoFabricacion = anyo;
		this.origen = origen;
		this.precio = precio;
		
	}
}
