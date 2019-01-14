package bloque4Arrays;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		int array[] = new int[29];
		
		System.out.println(devolverMedio(array));

	}
	
	/**
	 * 
	 * @param array
	 * @return
	 */
	//Método que devuelve el número central del array
	public static int devolverMedio(int array[]) {
		int medio;
		
		//Si la longitud es par el método devuelve -1
		if (array.length % 2 == 0) {
			
			return -1;
			
		}
		/*Si no es par el método devuelve el número medio 
		 * (la longitud del array - la mitad de la longitud del array redondeado*/
		else {
			
			medio = ((int) array.length - (array.length/2));
			
			return medio;
		}
		
		
	}
	
}
