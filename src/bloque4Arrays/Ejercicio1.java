package bloque4Arrays;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		int array[] = new int[10];

		for (int i = 0; i < array.length; i++) {
			
			array[i] = (int) (Math.random() * 100);
			
			System.out.print(array[i] + " ");
		}
		
		System.out.println("\nValor central: " +devolverMedio(array));
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
		 * (la longitud del array dividido entre 2*/
		else {
			
			medio = ((int) array.length/2);
			
			return array[medio];
		}
		
		
	}
	
}
