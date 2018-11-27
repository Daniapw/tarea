package tema4.bloque1;

import javax.swing.JOptionPane;

public class Utils {
		
	public static void main(String[] args) {
		
		Fibonacci(5,8);
		
	}	
	
	/*
	 * Ejercicio 1
	 */
	
	public static int media (int num1, int num2, int num3, float float1) {
		
		int resultado = (num1 + num2 + num3 + (int) float1)/4;
		
		return resultado;
	}
	
	/*
	 * Ejercicio 2
	 */
	
	public static void pedirvalores () {
		
		int numero;
		
		int limiteinf = Integer.parseInt(JOptionPane.showInputDialog("Introduce el límite inferior:"));
		int limitesup = Integer.parseInt(JOptionPane.showInputDialog("Introduce el límite superior:"));
		
		do {
			numero = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número entre " + limiteinf + " y " + limitesup ));
		
		}while(numero > limitesup || numero < limiteinf);
		
	}
	
	/*
	 * Ejercicio 3
	 */
	
	public static void metodo1 () {
		
		int numero1 = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número"));
		int numero2 = Integer.parseInt(JOptionPane.showInputDialog("Introduce otro número"));
		metodo2(numero1, numero2);
		
	}
	
	public static void metodo2 (int numero1, int numero2) {
		
		if (numero1 > numero2){
			System.out.println(numero1 + " es mayor que " + numero2);
		}
		else {
			if (numero1 == numero2 || numero2 == numero1) {
				System.out.println("Es el mismo número.");
			}
			else {
				System.out.println(numero2 + " es mayor que " + numero1);
			}
		}	
	
	}
	
	/*
	 * Ejercicio 4
	 */
	
	public static void Fibonacci (int numero1, int numero2) {
		int array[] = new int [7];
		
		array[0] = numero1;
		array[1] = numero2;
		
		for (int i = 2; i < array.length; i++) {
			
			array[i] = array[i-1] + array[i-2];
			
			System.out.print(array[i] + " ");
			
		}
		
	}
	
	
}
