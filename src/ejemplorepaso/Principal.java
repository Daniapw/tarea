package ejemplorepaso;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		String menuPersona=JOptionPane.showInputDialog("Selecciona una opción" +
									"\n 1. Registrar persona." + 
									"\n 2. Matricular persona.");
		
		int opcionPersona = Integer.parseInt(menuPersona);
	
	
	
		if (opcionPersona >= 1 && opcionPersona <= 2) {
			
			Persona persona = null;
			
		
		
			switch (opcionPersona) {
			case 1: //No documentada
				persona = new PersonaND();
				PersonaND perNoDoc = (PersonaND) persona;
				break;
			
			case 2: // Documentada
				persona = new PersonaD();
				PersonaD perSiDoc = (PersonaD) persona;
			}
		}
	}
}
