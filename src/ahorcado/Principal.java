package ahorcado;

import javax.swing.JOptionPane;

public class Principal {
	
	public static String palabra;
	public static String palabrasPosibles[] = new String[]{"hola", "adios", "pantalla", "silla", "mesa", "daniel"};

	
	public static void main(String[] args) {
		
		//Generar número aleatorio para determinar con qué palabra jugaremos
		int azar = (int) Math.round(Math.random() * (palabrasPosibles.length - 1));
		
		palabra = palabrasPosibles[azar];
				
		System.out.println(palabra);
	
		//Bucle para mostrar la longitud de la palabra en "_"
		for (int i = 0; i < palabra.length(); i++) {
			
			System.out.print("_ ");
			
		}
		
		
		//Arrays para poner las letras de la palabra por separado
		
		char letrasPalabra[] = new char[palabra.length()];
		String letras[] = new String[palabra.length()];
		
		for (int i = 0; i < palabra.length(); i++) {
					
			letrasPalabra[i] = palabra.charAt(i);
			letras[i] = String.valueOf(letrasPalabra[i]);
			
		}
		
	
		//Intentos fallidos del jugador
		int fallos = 0;
		String arrayIntentos[] = new String[100];
		int contadorEjecucion = 0;
		
		//Contador para saber si el jugador ha acertado al meter una letra o no
		int contadorCoincidencias = 0;
		
		//booleano que se le pasa al método "isTerminado", que determinará si el jugador ha completado la palabra o no
		boolean terminado = true;
		
		//progreso es el Array en el que se va guardando el progreso del jugador. Se inicializa con "_" que se irán sustituyendo por letras
		String progreso[] = new String[palabra.length()];
		
		for (int i = 0; i < progreso.length; i++) {
			
			progreso[i] = "_";
			
		}
		
		do {
			
			String intento = JOptionPane.showInputDialog("Introduce una letra o una palabra:");
			
			System.out.println("\n");			
			
			arrayIntentos[contadorEjecucion] = intento;
			
			//Si el jugador introduce una sola letra:
			if (intento.length() == 1) {
				
				//Buscar letra e imprimir resultado
				for (int i = 0; i < letras.length; i++) {
					
					if (intento.equals(letras[i])) {
						
						progreso[i] = letras[i];
						System.out.print(progreso[i] + " ");
						contadorCoincidencias++;
						
					}
					else {
						
						System.out.print(progreso[i] + " ");
						
					}
					
				}	
				
				//Si la letra no se ha encontrado se a�ade un fallo
				if (contadorCoincidencias == 0) {
					System.out.println("\nIncorrecto: la palabra no contiene la letra " + intento );
					fallos++;
				}
				else {
					System.out.println("\nCorrecto");
				}
				
			}
			else {
				
				//Si el jugador introduce una palabra
				
				if (intento.equals(palabra)) {
					
					for (int i = 0; i < letras.length; i++) {
							
						System.out.print(letras[i] + " ");
						progreso[i] = letras[i];	
					}
					
					System.out.println("¡Enhorabuena, has ganado!");
					
				}
				else {
					
					System.out.println("\nIncorrecto");
					
					fallos++;
					
					for (int i = 0; i < progreso.length; i++) {
						
						System.out.print(progreso[i] + " ");
						
					}
					
				}
					
			}
			
			System.out.println("\nNúmero de errores: " + fallos + "/6");
			
			if (fallos == 6) {
				System.out.println("\nLo siento, has perdido el juego");
			}
			
			//Bucle para mostrar al usuario las letras y palabras que ha intentado hasta ahora
			
			System.out.println("Palabras y letras que has probado: ");
			
			for (int i = 0; i <= contadorEjecucion; i++) {
				
				System.out.print(arrayIntentos[i] + " ");
				
			}
			
			//Resetear contador de coincidencias para el siguiente intento
			contadorCoincidencias = 0;
			
			//Añadir 1 más al contador de ejecuciones
			contadorEjecucion++;
			
			
			
		} while(fallos < 6 && !isTerminado(terminado, progreso));
		
	}
	
	
	//Método boolean para saber si el jugador ha adivinado la palabra y el juego tiene que terminar
	private static boolean isTerminado (boolean terminado, String progreso[]) {
		
		for (int i = 0; i < progreso.length; i++) {
			
			if (progreso[i] == "_") {
				
				terminado = false;
				
			}
				
		}
		
		return terminado;
	}

}
