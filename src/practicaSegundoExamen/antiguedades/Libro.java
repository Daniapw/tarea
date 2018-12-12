package practicaSegundoExamen.antiguedades;

public class Libro extends Antiguedad{
	
	String autor;
	public Libro() {
		super();
		
	}
	public Libro (int anyo, String origen, int precio, String autor) {
		
		super(anyo, origen, precio);
		
		this.autor = autor;
		
	}
	
	
	public String toString() {
		
		String str = "Año de fabricación: " + this.anyoFabricacion
						+ "\nOrigen: " + this.origen
						+ "\nPrecio: " + this.precio
						+ "\nAutor: " + this.autor;
		
		return str;
		
	}
}
