package Arrays;
import javax.swing.JOptionPane;
public class ejercicio5b2 {

	public static void main(String[] args) {
		int numeros[] = new int [5];
		
		for (int i = 0; i < numeros.length; i++) {
			
			numeros[i] = ((int) Math.round(Math.random() * 100));
			
			System.out.print(numeros[i] + " ");
		}
		
		
		
		System.out.println("\n");
		
		int desplazar = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la cantidad de posiciones que desea desplazar los números:"));
		
		for (int i = 0; i < desplazar; i++) {
			
			int aux = numeros[numeros.length-1];
			
			for (int j = (numeros.length - 1); j > 0; j--) {
				
				numeros[j] = numeros[j-1];
				
			}
			
			numeros[0] = aux;
			
		}	
		
		
		
		for (int i = 0; i < numeros.length; i++) {
			
			System.out.print(numeros[i] + " ");
		}
	}

}
