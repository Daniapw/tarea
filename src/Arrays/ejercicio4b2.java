package Arrays;

import java.lang.reflect.Array;

public class ejercicio4b2 {

	public static void main(String[] args) {
		int numeros[] = new int [5];
		
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = ((int) Math.round(Math.random() * 100));
			System.out.print(numeros[i] + " ");
		}

		System.out.println(" ");
		
		int aux = numeros[numeros.length - 1];
		
		for (int i = (numeros.length - 1); i > 0; i--) {
			numeros[i] = numeros[i-1];
			
		}
		
		numeros[0] = aux;
		
		for (int i = 0; i < numeros.length; i++) {
			System.out.print(numeros[i] + " ");
		}
		
	}

}
