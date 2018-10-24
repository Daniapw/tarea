package Arrays;

import javax.swing.JOptionPane;

public class ejercicio3 {

	public static void main(String[] args) {
		int array[] = new int [150], numero, linea=0;
		
		numero = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el valor que desea buscar:"));
		
		
		for (int i = 0; i < array.length; i++) {
			array[i] = ((int) Math.round(Math.random() * 100));
			
			System.out.println("Número " + i + ": " +
			array[i] + " ");
		
		}
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] == numero) {
				linea = i;
			}			
		}
		
		System.out.println("\nValor encontrado en array[" + linea +"].");

	}

}
