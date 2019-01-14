package bloque4Arrays;

public class Ejercicio3 {

	public static void main(String[] args) {
		
		int arrayEnteros[] = new int[20];
		float arrayDecimales[] = new float[20];
		float arrayFinal[] = new float[20];
		int contador = 0;
		
		
		for (int i = 0; i < arrayEnteros.length; i++) {
			//Se generan los números enteros y los decimales
			arrayEnteros[i] = (int) (Math.random() * 100);
			arrayDecimales[i] = (float) Math.random();
			
			//El valor de la suma arrayEnteros[i] + arrayDecimales[i] es el valor de arrayFinal[i]
			arrayFinal[i] = arrayEnteros[i] + arrayDecimales[i];
			
			
			//Se imprime cada valor
			System.out.println("Entero: " + arrayEnteros[i]+
								"\nDecimal: " + arrayDecimales[i] +
								"\nNúmero final: " + arrayFinal[i]);
			
			/*Ahora, a arrayFinal[i] se le resta su parte entera (es decir, arrayEnteros[i]), dejando así su parte decimal.
			Si la parte decimal resultante está entre .00 y .49 se imprimirá un mensaje y se le sumará 1 al contador*/
			if (arrayFinal[i] - arrayEnteros[i] <= 0.49 ) {
				
				System.out.println("La parte decimal de " + arrayFinal[i] + " está comprendida entre .00 y .49");
				contador++;
			}
			//Si la parte decimal no está entre .00 y .49 se imprime otro mensaje
			else {
				
				System.out.println("La parte decimal de " + arrayFinal[i] + " no está comprendida entre .00 y .49");
				
			}
			
			System.out.println();
				
		}
		
		//Por último se imprime un mensaje para informar de la cantidad total de números cuya parte decimal está comprendida entre .00 y .49
		System.out.println("El total de números cuya parte decimal está entre .00 y .49 es de " + contador);

	}

}
