package tema2;

import javax.swing.JOptionPane;

public class ejercicio22 {

public static void mostrarmenor () {
		
		int num1, num2;
				
		String str = JOptionPane.showInputDialog("Introduce el primer n�mero:");
		num1 = Integer.parseInt(str);
		
		str = JOptionPane.showInputDialog("Introduce el segundo n�mero");
		num2 = Integer.parseInt(str);
		
		if (num1 < num2) {
			JOptionPane.showMessageDialog(null, "El n�mero m�s peque�o es: " + num1);
		}
		else {
			JOptionPane.showMessageDialog(null, "El n�mero m�s peque�o es: "+ num2);
		}
			
		
	}
}
