package tema2;
import javax.swing.JOptionPane;
public class ejercicio21 {
	
	public static void mostrarmayor () {
		

		int num1;
		int num2;
		
		String str = JOptionPane.showInputDialog("Introduce el primer número:");
		num1 = Integer.parseInt(str);
		
		str = JOptionPane.showInputDialog("Introduce el segundo número");
		num2 = Integer.parseInt(str);
		
		if (num1 > num2) {
			JOptionPane.showConfirmDialog(null, "El número más grande es: " + num1);
		}
		else {
			JOptionPane.showConfirmDialog(null, "El número más grande es: "+ num2);
			
		
	}

	
}
}
