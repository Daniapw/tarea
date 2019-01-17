package ejerciciosListas.bloque5;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Ejercicio1 {
	public static List<String> editor = new ArrayList<String>(80);
	
	public static void main(String[] args) {

		int opcion;
		
		for (int i = 0; i < editor.size(); i++) {
			
			editor.add("");
			
		}
		
		do {
			
			opcion = Integer.parseInt(JOptionPane.showInputDialog("Elige una de las siguientes opciones:"
					+ "\n1. A�adir una l�nea al texto"
					+ "\n2. Insertar una l�nea en cualquier posici�n del texto"
					+ "\n3. Editar una l�nea (reescribir su contenido)"
					+ "\n4. Borrar una l�nea"
					+ "\n5. Cortar un conjunto de l�neas"
					+ "\n6. Pegar un conjunto de l�neas cortadas"
					+ "\n7. Imprimir texto"
					+ "\n0. Salir."));
			
			while (opcion < 0 || opcion > 7) {

				JOptionPane.showMessageDialog(null, "Opci�n inv�lida, elige otra");

				opcion = Integer.parseInt(JOptionPane.showInputDialog("Elige una de las siguientes opciones:"
						+ "\n1. A�adir una l�nea al texto"
						+ "\n2. Insertar una l�nea en cualquier posici�n del texto"
						+ "\n3. Editar una l�nea (reescribir su contenido)"
						+ "\n4. Borrar una l�nea"
						+ "\n5. Cortar un conjunto de l�neas"
						+ "\n6. Pegar un conjunto de l�neas cortadas"
						+ "\n7. Imprimir texto"
						+ "\n0. Salir."));
				
				
			}
			
			
			switch(opcion) {
				
				case 1:{
									
					anadirLinea();
					
					break;
				}
				
				case 2:{
					
					insertarLinea();
					
					break;
				}
				case 7:{
					
					imprimirTexto();
					
					break;
				}
				
			}
			
			
		}while(opcion != 0);

	}

	/**
	 * 
	 * 
	 */
	public static void anadirLinea() {
		
		String nuevoTexto = JOptionPane.showInputDialog("Introduce el texto que quieres a�adir");

		editor.add(nuevoTexto);
		
		
	}
	/**
	 * 
	 */
	public static void insertarLinea() {
		
		String nuevoTexto = JOptionPane.showInputDialog("Introduce el texto que quieres a�adir");

		int posicion = Integer.parseInt(JOptionPane.showInputDialog("Introduce la posici�n en la que quieres insertar el texto"));
		
		if (posicion > editor.size()) {
			
			editor.add(nuevoTexto);
		
		}
		else {
			
			editor.add(posicion, nuevoTexto);
			
		}
		
	}
	
	/**
	 * 
	 */
	public static void imprimirTexto() {
		
		for (int i = 0; i < editor.size(); i++) {
			
			System.out.println( "-"+ (i + 1) + ": " +  editor.get(i));
			
		}
		
		
	}
}
