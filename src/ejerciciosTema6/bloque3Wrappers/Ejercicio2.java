package ejerciciosTema6.bloque3Wrappers;

import javax.swing.JOptionPane;

public class Ejercicio2 {

	public static void main(String[] args) {
		
		String password;
		
		do {
			
			password = JOptionPane.showInputDialog("Introduzca una contrasenia");
		
		}while(!comprobarContr(password));
		
		JOptionPane.showMessageDialog(null, "La contrasenia es valida");
	}

	/**
	 * Metodo para comprobar si la contrasenia es valida
	 * @param cont
	 * @return
	 */
	public static boolean comprobarContr(String cont) {
		
		//Se separa la contrasenia en chars y se almacenan en un array
		char caracteres[] = cont.toCharArray();
		
		//Se crea un array con cuatro booleans (mayusculas, minusculas, digito, no alfanumerico)
		boolean bools[] = new boolean[4];
	
		/*Se comprueban uno por uno los caracteres de la contrasenia recorriendo el array.
		Si se encuentra una de las condiciones que se piden, se cambia el boolean correspondiente a true*/
		for (int i=0; i < caracteres.length; i++) {
			
			
			if (Character.isUpperCase(caracteres[i])) {
				
				bools[0] = true;
				
			}
			
			if (Character.isLowerCase(caracteres[i])) {
				
				bools[1] = true;
				
			}
			
			if (Character.isDigit(caracteres[i])) {
				
				bools[2] = true;
				
			}
			
			if (!Character.isAlphabetic(caracteres[i]) && !Character.isDigit(caracteres[i])) {
				
				bools[3] = true;
				
			}
			
		}
		
		//Por ultimo se recorre el array de booleans, y si hay alguno que no se cumple el metodo devuelve false
		for (boolean bool:bools) {
			
			if (!bool) {
				
				return false;
				
			}
			
		}
		
		//Si la ejecucion ha llegado a este punto es que la contrasenia es valida
		return true;
	}
	
	
}
