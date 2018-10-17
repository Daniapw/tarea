package tema3.bloque3;

import javax.swing.JOptionPane;

public class ejercicio4b3 {

	public static void main(String[] args) {	
		int num, menor;
		
		num = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número"));
		menor = num;
		
		while (num != 0) {
			num = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número"));
			
			if (num < menor && num != 0) {
				menor = num;
			}
		}
		
		System.out.println("El número más pequeño es " + menor);
		
	}	
	
}
