package bloque4Arrays;

public class Ejercicio2 {

	public static void main(String[] args) {
		
		int array[] = new int[200];
		
		for (int i = 0; i < array.length; i++) {
			
			array[i] = (int) (Math.random() * 10);
			System.out.print(array[i] + " ");
		}
		
		notas(array);
	}
	
	/**
	 * 
	 * @param array
	 */
	//Método que calcula el porcentaje de aprobados y suspensos
	public static void notas(int array[]) {
		
		int contadorAprobados = 0;
		int contadorSuspensos = 0;
		double porcentaje;
		
		
		for (int i = 0; i < array.length; i++) {
			//Si la nota está por encima de cuatro se suma uno al contador
			if (array[i] >= 5) {
				
				contadorAprobados++;
				
			}
			//Si no está por encima de 4 se suma uno al contador de suspensos
			else {
				
				contadorSuspensos++;
				
			}
			
		}
		
		//Ahora se calcula el porcentaje de aprobados y se imprime
		porcentaje = (double) contadorAprobados/array.length;
		porcentaje *= 100;
		
		System.out.println("\nNúmero de aprobados: " + porcentaje + "%");
		
		//Y, por último, se calcula el porcentaje de suspensos
		porcentaje = (double) contadorSuspensos/array.length;
		porcentaje *= 100;
		
		System.out.println("\nNúmero de suspensos: " + porcentaje + "%");

		
	}

}
