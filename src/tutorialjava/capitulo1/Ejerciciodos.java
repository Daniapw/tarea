package tutorialjava.capitulo1;

import javax.swing.JOptionPane;

public class Ejerciciodos {
	
	public static void ejercicio2() {
		
		String num = JOptionPane.showInputDialog("Introduce un número entero:");
		int entero = Integer.parseInt(num);
		
		System.out.println("Has introducido el número " + entero);
		
		num = JOptionPane.showInputDialog("Introduce un número float:");
		float flotante = Float.parseFloat(num);
		
		System.out.println("Has introducido el número " + flotante);
		
		num = JOptionPane.showInputDialog("Introduce un número double");
		double doble = Double.parseDouble(num);
		
		System.out.println("Has introducido el número " + doble);
							

	}

	
	
}
