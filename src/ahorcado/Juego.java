package ahorcado;

import javax.swing.JOptionPane;

public class Juego {
	
	private static int fallos = 0;
	private static String arrayIntentos[] = new String[100];
	private static String intento;
	
	//Contador de ejecuciones del juego para poder imprimir los errores del usuario
	private static int contadorEjecucion = 0;
	
	//Contador para saber si el jugador ha acertado al meter una letra o no
	private static int contadorCoincidencias = 0;
	private static boolean coincidencia = false;
	
	//booleano que se le pasa al método "isTerminado", que determinará si el jugador ha completado la palabra o no
	private static boolean terminado=true;

	//progreso es el Array en el que se va guardando el progreso del jugador. Se inicializa con "_" que se irán sustituyendo por letras
	private static String progreso[] = new String[Palabras.getPalabra().length()];
	
	
	//Método para el bucle principal del juego
	public static void bucleJuego (String letras[]) {
				
		for (int i = 0; i < progreso.length; i++) {
			progreso[i] = " ";
		}
		do {
			
			Ventana.getVentana().repaint();
	
			
			intento = JOptionPane.showInputDialog("Introduce una letra o una palabra:");	
			
			arrayIntentos[contadorEjecucion] = intento;
			
			//Si el jugador introduce una sola letra:Correcto
			if (intento.length() == 1) {
				
				//Buscar letra e imprimir resultado
				for (int i = 0; i < letras.length; i++) {
					
					if (intento.equals(letras[i])) {
						
						progreso[i] = letras[i];
						contadorCoincidencias++;
						coincidencia = true;
					}
					
				}	
				
				//Si la letra no se ha encontrado se a�ade un fallo
				if (contadorCoincidencias == 0) {
					
					coincidencia =false;
					fallos++;

				}
				
			}
			else {
				
				//Si el jugador introduce una palabra

				if (intento.equals(Palabras.getPalabra())) {
					
					for (int i = 0; i < letras.length; i++) {
							
						progreso[i] = letras[i];
						coincidencia = true;
					}
					
				}
				else {
					
					fallos++;
					coincidencia = false;
				}
					
			}
			
			
			//Resetear contador de coincidencias para el siguiente intento
			contadorCoincidencias = 0;
			
			//Añadir 1 más al contador de ejecuciones
			contadorEjecucion++;

		} while(fallos < 6 && !isTerminado());
	
		Ventana.getVentana().repaint();

	}
	
	
	//Método boolean para saber si el jugador ha adivinado la palabra y el juego tiene que terminar
	public static boolean isTerminado () {
		terminado = true;
		for (int i = 0; i < progreso.length; i++) {
			
			if (progreso[i] == " ") {
				
				terminado = false;
				
			}
		}
		
		return terminado;
	}
	
	
	
	//Getters y setters
	public static int getFallos() {
		return fallos;
	}

	public static String[] getArrayIntentos() {
		return arrayIntentos;
	}
	
	public static int getContadorEjecucion() {
		return contadorEjecucion;
	}

	public static String[] getProgreso() {
		return progreso;
	}

	public static boolean getTerminado() {
		return terminado;
	}

	public static boolean isCoincidencia() {
		return coincidencia;
	}

	
	
}
