package ejerciciosListas.bloque5.ejercicio3;

import javax.swing.JOptionPane;

public class Ejercicio3 {

	public static void main(String[] args) {
		int opcion = -1;
		
		Coleccion miColeccion = new Coleccion();
		Coleccion todosLosCromos = new Coleccion();
		
		for (int i = 0; i < 15; i++) {
			
			Cromo cromo = new Cromo(i, "A");
			
			todosLosCromos.cromos.add(cromo);

		}
		
		
		
		do {
			
			try {
				opcion = Integer.parseInt(JOptionPane.showInputDialog("Elige una opción:"
					+ "\n1. Anadir cromo a la coleccion"
					+ "\n2. Imprimir coleccion"
					+ "\n3. Ver cromos repetidos"
					+ "\n4. Cromos que faltan en la coleccion"
					+ "\n0. Salir"));
				
				if (opcion < 0 || opcion > 4) {
					
					JOptionPane.showMessageDialog(null, "El valor introducido no es valido");
					
				}
			}catch (Exception ex) {
				
				JOptionPane.showMessageDialog(null,"El valor introducido no es valido");
				
			}
			
			
			switch (opcion) {
			
				case 0:{
					
					System.exit(0);
					break;
				}
			
				case 1:{
					
					miColeccion.anadirCromo();
					break;
				}
				case 2:{
					
					miColeccion.imprimirLista();
					break;
				}
				case 3:{
					
					miColeccion.imprimirRepes();
					break;
				}
				case 4:{
					
					miColeccion.compararColeccion(todosLosCromos);
					break;
				}
			}
			
			System.out.println();
			
		}while(opcion != 0);

	}

}
