package tutorialjava.capitulo1;
import javax.swing.JOptionPane;
public class Ejerciciotres {
	
	public static void ejercicio3() {
		int numero1, numero2, numero3, suma;
		
		String num = JOptionPane.showInputDialog("Introduce el primer n�mero:");
		numero1 = Integer.parseInt(num);
		
		num = JOptionPane.showInputDialog("Introduce el segundo n�mero:");
		numero2 = Integer.parseInt(num);
		
		num = JOptionPane.showInputDialog("Introduce el tercer n�mero:");
		numero3 = Integer.parseInt(num);
		
		suma = numero1 + numero2+ numero3;
		
		System.out.println("La suma de los n�meros " + numero1 + ", " + numero2 + " y " + numero3 + " es: " + suma );
	}

}
