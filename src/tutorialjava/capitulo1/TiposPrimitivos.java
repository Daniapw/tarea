package tutorialjava.capitulo1;

public class TiposPrimitivos {

	public static void primerEjemplo () {
		int numEntero; // Declaración de una variable entera
		float numFlotante; // Declaración de una variable real o flotante
		double numDouble; // Declaracion de una variable doble o flotante larga
		
		numEntero = (int) 4.6; // Asignación de un valor a una variable
		numFlotante = (float) 4.5; // Casting de valor double a float
		numDouble = 4.8; // Asignación de valor double a variable double
		
		// Impresión en la consola de salidad e las variables
		System.out.println("El valor de la variable numEntero es: " + numEntero + 
				"\nEl valor de la variable numEntero es: "  + numFlotante);
		System.out.println("El valor de la variable numEntero es: " + numDouble);
	}
	
	
	
}
