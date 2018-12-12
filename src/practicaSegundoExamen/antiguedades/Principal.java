package practicaSegundoExamen.antiguedades;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		int peticion;
		
		Antiguedad antiguedad = null;
		peticion = Integer.parseInt(JOptionPane.showInputDialog("Qué antigüedad quieres crear?"
				+ "\n1.Joya"
				+ "\n2.Mueble"
				+ "\n3.Libro"
				+ "\n4.Arma"));
		
		switch (peticion) {
			case 1:{
				
				antiguedad = new Joya();
				Joya joya = (Joya) antiguedad;
				joya.material = JOptionPane.showInputDialog("Material: ");
				
				break;
			}
			case 2:{
				
				antiguedad = new Mueble();
				Mueble mueble = (Mueble) antiguedad;
				mueble.tipoMadera = JOptionPane.showInputDialog("Material: ");
				
				break;
			}
			case 3:{
				antiguedad = new Libro();
				Libro libro = (Libro) antiguedad;
				libro.autor = JOptionPane.showInputDialog("Autor ");
				break;
			}
			case 4:{
				
				antiguedad =new Arma();
				Arma arma = (Arma) antiguedad;
				arma.tipoArma = JOptionPane.showInputDialog("Tipo de arma: ");
				break;
				
			}
			
		}
		
		antiguedad.anyoFabricacion = Integer.parseInt(JOptionPane.showInputDialog("Año de fabricación:"));
		antiguedad.precio = Integer.parseInt(JOptionPane.showInputDialog("Precio: "));
		antiguedad.origen = JOptionPane.showInputDialog("Lugar de origen ");
		
		System.out.println(antiguedad.toString());
	}

}
