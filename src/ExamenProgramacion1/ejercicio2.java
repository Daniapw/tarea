package ExamenProgramacion1;

import javax.swing.JOptionPane;

public class ejercicio2 {

	public static void main(String[] args) {
		int numusuario, limite;
		
		numusuario = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el n�mero cuyos m�ltiplos desea mostrar:"));
		limite = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el l�mite de los m�ltiplos:"));

		for (int i = 0; limite > (numusuario * i); i++) {
			
			System.out.println(numusuario + " * " + i + " = " + (numusuario*i));
			
		}
		
		
	}

}
