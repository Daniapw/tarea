package tutorialjava.capitulo1;
import javax.swing.JOptionPane;
public class Ejerciciocuatro {

	public static void ejercicio4() {
		int numero1, numero2, numero3, promedio;
		
		String num = JOptionPane.showInputDialog("Introduce el primer n�mero:");
		numero1 = Integer.parseInt(num);
		
		num = JOptionPane.showInputDialog("Introduce el segundo n�mero:");
		numero2 = Integer.parseInt(num);
		
		num = JOptionPane.showInputDialog("Introduce el tercer n�mero:");
		numero3 = Integer.parseInt(num);
		
		promedio = (numero1 + numero2+ numero3) / 3;
		
		System.out.println("La media es " + promedio);
	}
		

}
