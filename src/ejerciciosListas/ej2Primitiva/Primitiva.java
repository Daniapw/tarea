package ejerciciosListas.ej2Primitiva;

import java.util.ArrayList;
import java.util.List;

public class Primitiva {

	public static void main(String[] args) {
		
		List<Integer> primitiva = new ArrayList<Integer>();
		
		for (int i = 0; i < 5; i++) {
			//Primero se vacía la lista
			primitiva.removeAll(primitiva);
			
			//Luego se añaden los números generados por el método generarNumeros() a la lista
			primitiva.addAll(generarNumeros());
			
			//Por último se imprime la lista
			System.out.println(primitiva.toString());
			
		}

	}

	/**
	 * 
	 * @return
	 */
	
	//Este método es el que genera una lista de seis números y la devuelve
	public static List<Integer> generarNumeros(){
		
		int numeroAzar;

		List<Integer> primitiva = new ArrayList<Integer>();
		
		for (int i = 0; i < 6; i++) {
			
			numeroAzar = (int) Math.round(Math.random() * (49 - 1) + 1);
			
			primitiva.add(numeroAzar);
			
		}
		
		
		return primitiva;
		
		
	}
}
