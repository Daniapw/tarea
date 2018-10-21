package Arrays;
import javax.swing.JOptionPane;
public class ejercicio6b2 {

	public static void main(String[] args) {
		int numeros[] = new int [5], i = 0, j = 0, direccion, desplazar, aux = 0;
		
		for (i = 0; i < numeros.length; i++) {
					
			numeros[i] = ((int) Math.round(Math.random() * 100));
					
			System.out.print(numeros[i] + " ");
		}
		
		System.out.println("\n");
		
		do {
			direccion = Integer.parseInt(JOptionPane.showInputDialog("¿Hacia qué dirección quiere que se muevan los números (0 para la derecha.; 1 para la izda.)?"));
		} while (direccion < 0 || direccion > 1);
		
		
		desplazar = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la cantidad de posiciones que desea desplazar los números:"));
		
		if (direccion == 0) {
						
			for (i = 0; i < desplazar; i++) {
				
				aux = numeros[numeros.length - 1];
				
				for (j = (numeros.length - 1); j > 0; j--) {
				
					numeros[j] = numeros[j - 1];
				}
				
				numeros[0] = aux;
			}
			
		}
		else {
			
			for (i = 0; i < desplazar; i++) {
				
				aux = numeros[0];
				
				for (j = 0; j < (numeros.length - 1); j++) {
					
					numeros[j] = numeros[j + 1];
					
				}
				
				numeros[4] = aux;
			}
			
			
		}
		
		for (i = 0; i < numeros.length; i++) {
			
			System.out.print(numeros[i] + " ");
		}
		
		
	}

}
