package practicaSegundoExamen.tienda;

public class Perecederos extends Articulo{
	
	public String fechaCaducidad;
	
	public Perecederos(int codigo, String nombre, int precio, String fecha) {
		super(codigo, nombre, precio);
		
		this.fechaCaducidad = fecha;
		
	}
	
	public String toString() {
		
		String str = "Código: " + this.codigo
				+ "\nNombre: " + this.nombre
				+ "\nPrecio: " + this.precio
				+ "\nFecha de cadudicad: " + this.fechaCaducidad;
		
		return str;
	}
	
}
