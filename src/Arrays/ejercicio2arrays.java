package Arrays;

public class ejercicio2arrays {

	public static void main(String[] args) {
		
		int numeros[] = new int [150];
		int i;

		for ( i = 0; i < numeros.length; i++ ) {
			
			numeros[i] = ((int)Math.round(Math.random() * (-100 - 100))) + 100;
			
			System.out.println("Número " + i + ": " + numeros[i]);
			
			if (numeros[i] % 2 == 0 && numeros[i] < 0) {
				
				numeros[i] = Math.abs(numeros[i]);
				
				System.out.println("Número " + i + ": " + numeros[i]);
			}
			else {
				if (numeros[i] % 2 == 0 && numeros [i] > 0) {
					
					numeros[i] = numeros[i] - (numeros[i] * 2);
					
					System.out.println("Número " + i + ": " + numeros[i]);
				}
			}
			
			
			
		}
		
		
	}

}
