package practicaSegundoExamen.tienda;

public class NoPerecederos extends Articulo{

	public NoPerecederos(int codigo, String nombre, int precio) {
		
		super(codigo, nombre, precio);
		
	}
	
	
	public String toString() {
		
		String str = "C�digo: " + this.codigo
				+ "\nNombre: " + this.nombre
				+ "\nPrecio: " + this.precio;
		
		return str;
	}
	
}
