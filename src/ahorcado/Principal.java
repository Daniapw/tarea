package ahorcado;

import javax.swing.JOptionPane;

public class Principal {
	private static String jugarotravez;
	
	public static void main(String[] args) {
		
		do {
			Palabras.elegirPalabra();
			
			Juego.resetearJuego();
			
			String letras[] = Palabras.separarLetras();
			
			Juego.bucleJuego(letras);
			
			
			if (Juego.isNavidad() == true) {
				
				Juego.modoNavidad();
				
			}
			
			
			jugarotravez = JOptionPane.showInputDialog("Gracias por jugar a mi juego!"
					+ "\n Jugar otra vez (escribe S o N)?");
			
		}while (jugarotravez.equalsIgnoreCase("S"));

		System.exit(0);
	}
	

}
