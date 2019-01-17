package ejerciciosListas.bloque5;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Ejercicio1 {
	public static List<String> editor = new ArrayList<String>();
	public static List<String> textoCortado = new ArrayList<String>();
	
	
	public static void main(String[] args) {

		int opcion;
		
		do {
			
			opcion = Integer.parseInt(JOptionPane.showInputDialog("Elige una de las siguientes opciones:"
					+ "\n1. Aï¿½adir una lï¿½nea al texto"
					+ "\n2. Insertar una lï¿½nea en cualquier posiciï¿½n del texto"
					+ "\n3. Editar una lï¿½nea (reescribir su contenido)"
					+ "\n4. Borrar una lï¿½nea"
					+ "\n5. Cortar un conjunto de lï¿½neas"
					+ "\n6. Pegar un conjunto de lï¿½neas cortadas"
					+ "\n7. Imprimir texto"
					+ "\n0. Salir."));
			
			while (opcion < 0 || opcion > 7) {

				JOptionPane.showMessageDialog(null, "Opciï¿½n invï¿½lida, elige otra");

				opcion = Integer.parseInt(JOptionPane.showInputDialog("Elige una de las siguientes opciones:"
						+ "\n1. Aï¿½adir una lï¿½nea al texto"
						+ "\n2. Insertar una lï¿½nea en cualquier posiciï¿½n del texto"
						+ "\n3. Editar una lï¿½nea (reescribir su contenido)"
						+ "\n4. Borrar una lï¿½nea"
						+ "\n5. Cortar un conjunto de lï¿½neas"
						+ "\n6. Pegar un conjunto de lï¿½neas cortadas"
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
				
				case 3:{
					
					editarTexto();
					
					break;
										
				}
				
				case 4:{
					
					borrarLinea();
					
					break;
				}
				
				case 5:{
					
					cortar();
					
					break;
				}
				
				case 6:{
					
					if (textoCortado.isEmpty()) {
						
						JOptionPane.showMessageDialog(null, "No hay ningún texto cortado");
						
					}
					else {
						
						pegar();
						
					}
					
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
		
		String nuevoTexto = JOptionPane.showInputDialog("Introduce el texto que quieres aï¿½adir");

		editor.add(nuevoTexto);
		
		
	}
	/**
	 * 
	 */
	public static void insertarLinea() {
		
		String nuevoTexto = JOptionPane.showInputDialog("Introduce el texto que quieres aï¿½adir");

		int posicion = Integer.parseInt(JOptionPane.showInputDialog("Introduce la posiciï¿½n en la que quieres insertar el texto"));
		
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
			
			System.out.println( "-"+ (i) + ": " +  editor.get(i));
			
		}
		
		System.out.println();
	}
	/**
	 * 
	 * 
	 */
	public static void editarTexto() {
		
		int posicion = Integer.parseInt(JOptionPane.showInputDialog("Introduce la posiciï¿½n de la frase que quieres reemplazar"));
		
		String nuevoTexto = JOptionPane.showInputDialog("Introduce el nuevo texto");
		
		editor.set(posicion, nuevoTexto);
		
	}
	/**
	 * 
	 */
	public static void borrarLinea() {
		
		int posicion = Integer.parseInt(JOptionPane.showInputDialog("Introduce la posición de la frase que quieres borrar"));

		if (posicion > editor.size()) {
			
			editor.remove(editor.size() - 1);
			
		}else {

			editor.remove(posicion);
			
		}
		
	}
	/**
	 * 
	 */
	public static void cortar() {
		
		int posicion1 = Integer.parseInt(JOptionPane.showInputDialog("Línea desde la cual se empezará a cortar"));
		int posicion2 = Integer.parseInt(JOptionPane.showInputDialog("Línea hasta la que se cortará"));
		
		textoCortado = editor.subList(posicion1, posicion2);
		editor.removeAll(textoCortado);
		
	}
	
	/**
	 * 
	 */
	public static void pegar() {
		
		int posicion = Integer.parseInt(JOptionPane.showInputDialog("¿En qué posición quieres pegar el texto?"));
		
		editor.addAll(posicion, textoCortado);
		
	}
}
