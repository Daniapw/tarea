package tutorialjava.capitulo1;
import javax.swing.JOptionPane;
public class Ejerciciocinco {
	
	public static void ejercicio5() {

		String num = JOptionPane.showInputDialog("Introduce el primer número:");
		int numero1 = Integer.parseInt(num);
		
		num = JOptionPane.showInputDialog("Introduce el segundo número:");
		int numero2 = Integer.parseInt(num);
		
		System.out.println("Has introducido los números: " + numero1 + numero2);
		
	}

}
