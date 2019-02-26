package ejerciciosTema6.bloque2;

import javax.swing.JOptionPane;

public class Ejercicio2 {

	public static void main(String[] args) {
		
		String password;
		
		do {
			
			password = JOptionPane.showInputDialog("Introduzca una contrasenia");
		
		}while(!password.matches("([A-Z]+[a-z]+)"));

	}

}
