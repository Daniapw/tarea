package ExamenProgramacion1;

import javax.swing.JOptionPane;

public class ejercicio2 {

	public static void main(String[] args) {
		int numusuario, limite;
		
		numusuario = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el número cuyos múltiplos desea mostrar:"));
		limite = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el límite de los múltiplos:"));

		for (int i = 0; limite > (numusuario * i); i++) {
			
			System.out.println(numusuario + " * " + i + " = " + (numusuario*i));
			
		}
		
		
	}

}
