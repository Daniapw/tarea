package tema4;

import javax.swing.JOptionPane;

public class Ejercicio3 {
	
	public static void main(String[] args) {
		metodo1();

	}
	
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
			System.out.println(numero2 + " es mayor que " + numero1);
		}
		
	}
}
