package tema3;
import javax.swing.JOptionPane;
public class ejercicio31 {

	public static void main(String[] args) {
		int num, str = 0, acumulador = 0;
		
		for (str = 0; str < 4; str++) {
			num = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número entero:"));
			if (num > 10) {
				acumulador = num + acumulador;
			}
					
		

		}
		JOptionPane.showMessageDialog(null, "El resultado es " + acumulador);
	}
}
