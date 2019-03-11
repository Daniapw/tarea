package ejerciciosTema6.bloque3Wrappers;

public class Ejercicio3 {

	public static void main(String[] args) {
		int numeros[] = new int[100];
		
		for (int i = 0; i < numeros.length; i++) {
			
			numeros[i] = i + 1;
			
			System.out.println(Integer.toHexString(numeros[i]));
		}

	}

}
