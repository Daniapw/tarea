package tutorialjava.capitulo1;
import javax.swing.JOptionPane;
public class Ejerciciotres {
	
	public static void ejercicio3() {
		int numero1, numero2, numero3, suma;
		
		String num = JOptionPane.showInputDialog("Introduce el primer número:");
		numero1 = Integer.parseInt(num);
		
		num = JOptionPane.showInputDialog("Introduce el segundo número:");
		numero2 = Integer.parseInt(num);
		
		num = JOptionPane.showInputDialog("Introduce el tercer número:");
		numero3 = Integer.parseInt(num);
		
		suma = numero1 + numero2+ numero3;
		
		System.out.println("La suma de los números " + numero1 + ", " + numero2 + " y " + numero3 + " es: " + suma );
	}

}
