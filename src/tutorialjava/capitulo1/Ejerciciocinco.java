package tutorialjava.capitulo1;
import javax.swing.JOptionPane;
public class Ejerciciocinco {
	
	public static void ejercicio5() {

		String num = JOptionPane.showInputDialog("Introduce el primer n�mero:");
		int numero1 = Integer.parseInt(num);
		
		num = JOptionPane.showInputDialog("Introduce el segundo n�mero:");
		int numero2 = Integer.parseInt(num);
		
		System.out.println("Has introducido los n�meros: " + numero1 + numero2);
		
	}

}
