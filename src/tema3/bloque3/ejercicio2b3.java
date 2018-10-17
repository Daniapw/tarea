package tema3.bloque3;

import javax.swing.JOptionPane;

public class ejercicio2b3 {

	public static void main(String[] args) {
		int num, suma = 0, contador = -1;
		
		
		do {		
			num = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número (0 para salir del programa)"));
			suma += num;
			contador++;
			
		} while (num != 0);
		
		System.out.println("El resultado es: " + suma/contador);
		
	}
	
	
}
