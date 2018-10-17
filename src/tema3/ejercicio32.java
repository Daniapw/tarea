package tema3;
import javax.swing.JOptionPane;
public class ejercicio32 {

	public static void main(String[] args) {
		int num, acumulador = 0, i, num2;
		
		num = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos números desea introducir?"));
		
		for ( i=0; i<num ;i++  ) {
			num2 = Integer.parseInt(JOptionPane.showInputDialog("Introduzca un número: "));
			if (num2 > 10) {
				acumulador = num + acumulador;
			}
		}
		
		JOptionPane.showMessageDialog(null, "El resultado es: " + acumulador);
		
	}

}
