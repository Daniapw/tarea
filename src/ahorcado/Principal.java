package ahorcado;

import javax.swing.JOptionPane;

public class Principal {
	
	public static String palabra;
	public static String palabrasPosibles[] = new String[]{"hola", "adios", "pantalla", "silla", "mesa", "daniel"};

	
	public static void main(String[] args) {
		
		int azar = (int) Math.round(Math.random() * (palabrasPosibles.length - 1));
		
		palabra = palabrasPosibles[azar];
		
		String coincidencias[] = new String[palabra.length()];
		
		System.out.println(palabra);
	
		for (int i = 0; i < palabra.length(); i++) {
			
			System.out.print("_ ");
			
		}
		
		
		//Arrays para las letras de la palabra por separado
		
		char letrasPalabra[] = new char[palabra.length()];
		String letras[] = new String[palabra.length()];
		
		for (int i = 0; i < palabra.length(); i++) {
					
			letrasPalabra[i] = palabra.charAt(i);
			letras[i] = String.valueOf(letrasPalabra[i]);
			
		}
		
	
		//Intentos del jugador
		
		int fallos = 0;
		int contadorCoincidencias = 0;
		
		
		for (int i = 0; i < coincidencias.length; i++) {
			
			coincidencias[i] = "_";
			
		}
		
		do {
			
			String intento = JOptionPane.showInputDialog("Introduce una letra o una palabra:");
			
			//Si el jugador introduce una sola letra:
			if (intento.length() == 1) {
				
				System.out.println(" ");
				
				//Buscar letra e imprimir resultado
				for (int i = 0; i < letras.length; i++) {
					
					if (intento.equals(letras[i])) {
						
						coincidencias[i] = letras[i];
						System.out.print(coincidencias[i] + " ");
						contadorCoincidencias++;
						
					}
					else {
						
						System.out.print(coincidencias[i] + " ");
						
					}
					
				}	
				
				//Si la letra no se ha encontrado se añade un fallo
				
				if (contadorCoincidencias == 0) {
					fallos++;
				}
				
			}
			else {
				
				System.out.println("");
				
				
				//Si el jugador introduce una palabra
				
				if (intento.equals(palabra)) {
					
					for (int i = 0; i < letras.length; i++) {
							
						System.out.print(letras[i] + " ");
							
					}
					
					System.out.println("¡Enhorabuena, has ganado!");
					
				}
				else {
					
					System.out.println("Incorrecto");
					
					fallos++;
					
					for (int i = 0; i < coincidencias.length; i++) {
						
						System.out.print(coincidencias[i] + " ");
						
					}
					
				}
					
			}

			contadorCoincidencias = 0;
			
		} while(fallos < 6);
		
	}
	


}
