package practicaSegundoExamen.tienda;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		
		Articulo articulos[] = new Articulo[4];
		int peticion;
		int codigo;
		String nombre;
		int precio;
		String fechaCad;
		
		for (int i = 0; i <= 1; i++) {
			
			peticion = Integer.parseInt(JOptionPane.showInputDialog("¿Qué tipo de artículo desea crear?:"
					+ "\n1. Perecedero"
					+ "\n2. No perecedero"));
			
			codigo = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el código del artículo:"));
			nombre = JOptionPane.showInputDialog("Introduzca el nombre del artículo:");
			precio = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el precio del artículo:"));
			
			if (peticion == 1) {

				fechaCad = JOptionPane.showInputDialog("Introduzca la fecha de caducidad del artículo:");

				articulos[i] = new Perecederos(codigo, nombre, precio, fechaCad);
				
			}
			else {
				
				articulos[i] = new NoPerecederos(codigo, nombre, precio);
				
			}
			
		}
		
		for (int i = 0; i <= 1; i++) {
			
			System.out.println(articulos[i].toString() + "\n");
			
		}

	}

}
