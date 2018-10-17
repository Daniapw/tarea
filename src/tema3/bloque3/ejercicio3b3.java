package tema3.bloque3;
import javax.swing.JOptionPane;
public class ejercicio3b3 {
	
	public static void main(String[] args) {	
		int num, mayor;
		
		num = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número"));
		mayor = num;
		
		while (num != 0) {
			num = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número"));
			
			if (num > mayor && num != 0) {
				mayor = num;
			}
		}
		
		System.out.println("El número más grande es " + mayor);
		
	}
}