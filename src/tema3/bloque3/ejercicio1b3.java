package tema3.bloque3;
import javax.swing.JOptionPane;
public class ejercicio1b3 {

	public static void main(String[] args) {
		int num, suma = 0;
		
		do {		
			num = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número (0 para salir del programa)"));
			suma += num;
		
		} while (num != 0);
		
		System.out.println("El resultado es: " + suma);
		
	}

}
