package ejerciciosListas.ej2Primitiva;

import java.util.ArrayList;
import java.util.List;

public class Primitiva {

	public static void main(String[] args) {
		
		List<Integer> primitiva = new ArrayList<Integer>();
		
		for (int i = 0; i < 5; i++) {
			//Primero se vac�a la lista
			primitiva.removeAll(primitiva);
			
			//Luego se a�aden los n�meros generados por el m�todo generarNumeros() a la lista
			primitiva.addAll(generarNumeros());
			
			//Por �ltimo se imprime la lista
			System.out.println(primitiva.toString());
			
		}

	}

	/**
	 * 
	 * @return
	 */
	
	//Este m�todo es el que genera una lista de seis n�meros y la devuelve
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
