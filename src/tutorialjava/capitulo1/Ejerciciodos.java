package tutorialjava.capitulo1;

import javax.swing.JOptionPane;

public class Ejerciciodos {
	
	public static void ejercicio2() {
		
		String num = JOptionPane.showInputDialog("Introduce un n�mero entero:");
		int entero = Integer.parseInt(num);
		
		System.out.println("Has introducido el n�mero " + entero);
		
		num = JOptionPane.showInputDialog("Introduce un n�mero float:");
		float flotante = Float.parseFloat(num);
		
		System.out.println("Has introducido el n�mero " + flotante);
		
		num = JOptionPane.showInputDialog("Introduce un n�mero double");
		double doble = Double.parseDouble(num);
		
		System.out.println("Has introducido el n�mero " + doble);
							

	}

	
	
}
