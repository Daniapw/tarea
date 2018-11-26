package ahorcado;

import javax.swing.JOptionPane;

public class Intentos {
	public String intentos[] = new String[10];
	public int contadorFallos = 0;
	
	public Intentos() {
		super();
	}
	
	public void tiradasUsuario(String palabraelegida, String palabras[]) {
		
		char respuesta[] = new char[palabraelegida.length()];
		
		for (int i = 0; i < palabraelegida.length(); i++) {
			
			respuesta[i] = palabraelegida.charAt(i);
			
			System.out.print(respuesta[i] + " ");
			
		}
		
		for (int i = 0; i < intentos.length; i++) {
			
			intentos[i] = JOptionPane.showInputDialog("Introduce una letra o una palabra:");
			
			if (intentos[i].length() > 1) {
				
				for ( int j = 0; j < palabras.length; j++) {
					
					intentos[i].equals(respuesta[i]);
					
				}
								
			}
			
		}
		
	}
}
