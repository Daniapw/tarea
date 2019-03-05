package practicaExamenMvC;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class MainMvC {
	protected static List<Personaje> personajes = new ArrayList<Personaje>();
	protected static int indiceRival;
	protected static int contador = 0;
	
	public static void main(String[] args) {
		
		Personaje spiderman = new Spiderman();
		Personaje ryu = new Ryu();

		personajes.add(spiderman);
		personajes.add(ryu);
		
		do {
			
			JOptionPane.showMessageDialog(null, "\tEstado actual de la pelea"
					+ "\nSpiderman: " + spiderman.vida + " puntos de vida"
					+ "\nRyu: " + ryu.vida + " puntos de vida");
			
			System.out.println("\t\t\tRonda "+ (contador + 1));
			
			for (Personaje pers:personajes) {
				
				System.out.println("Turno de " + pers.nombre);
				
				cambiarRival();
				pers.atacar(personajes.get(indiceRival));
				
				System.out.println();
			}
			
			System.out.println();
			
			contador++;
			
		}while(!combateTerminado());
		
	}

	/**
	 * Metodo para cambiar indice del rival
	 */
	private static void cambiarRival() {
		
		if (indiceRival == 0) {
			
			indiceRival = 1;
			
		}
		else {
			
			indiceRival = 0;
			
		}
		
	}
	
	/**
	 * Metodo para comprobar si el combate ha terminado
	 * @return
	 */
	private static boolean combateTerminado() {
		
		for (Personaje personaje:personajes) {
			
			if (personaje.vida <= 0) {
				
				JOptionPane.showMessageDialog(null, personaje.nombre + " ha caido!");
				
				return true;
				
			}
			
		}
		
		return false;
	}
}
