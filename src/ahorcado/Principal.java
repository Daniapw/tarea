package ahorcado;

import javax.swing.JOptionPane;

public class Principal {
	private static String jugarotravez;
	
	public static void main(String[] args) {
		
		Palabras.elegirPalabra();
	
		String letras[] = Palabras.separarLetras();
		
		Juego.bucleJuego(letras);
		
		jugarotravez = JOptionPane.showInputDialog("Gracias por jugar a mi juego!"
				+ "\n Jugar otra vez (escribe S o N)?");
		
		while (jugarotravez.equalsIgnoreCase("S")) {
			
			Palabras.elegirPalabra();
			
			Juego.resetearJuego();;
			
			letras = Palabras.separarLetras();
			
			Juego.bucleJuego(letras);

			jugarotravez = JOptionPane.showInputDialog("Gracias por jugar a mi juego!"
					+ "\n Jugar otra vez (escribe S o N)?");
		}
		
		System.exit(0);
	}
	

}
