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
	
	//booleano que se le pasa al m√©todo "isTerminado", que determinar√° si el jugador ha completado la palabra o no
	private static boolean terminado = true;

	//Booleans para los cheats
	private static boolean trampaActivada = false;
	private static boolean godmode = false;
	private static boolean pista = false;
	private static boolean navidad = false; //Este boolean servir· para saber si el jugador ha activado el modo navidad desde la clase Ventana
	private static boolean navidadEscape = false; //Este boolean servir· para la secuencia de escape del bucle del juego cuando el jugador quiera usar el cheat christmas
	
	//progreso es el Array en el que se va guardando el progreso del jugador. Se inicializa con espacios en blanco que se ir√°n sustituyendo por letras
	private static String progreso[] = new String[Palabras.getPalabra().length()];
	
	
	//M√©todo del bucle principal del juego
	public static void bucleJuego (String letras[]) {
				
		for (int i = 0; i < progreso.length; i++) {
			
			progreso[i] = " ";
			
		}
		
		do {
			
			Ventana.getVentana().repaint();
			
			trampaActivada = false;
			
			intento = JOptionPane.showInputDialog("Introduce una letra o una palabra:");	
			
			arrayIntentos[contadorEjecucion] = intento;
			
			//Activar y desactivar modo sin fallos (godmode). Si el usuario introduce "godmode on" o "godmode off" ese intento se dejarÔøΩ en blanco
			//para que no salga en pantalla
			if (intento.equalsIgnoreCase("godmode on")) {
				
				godmode = true;
				arrayIntentos[contadorEjecucion] = " ";
				
			}
			else {
				
				if (intento.equalsIgnoreCase("godmode off")) {
					
					godmode = false;
					arrayIntentos[contadorEjecucion] = " ";
					
				}
			}
			
			//Si el jugador usa la pista (solo se puede usar una vez)
			if (intento.equalsIgnoreCase("hint") && pista == false) {
				
				pista = true;		
				fallos++;
				arrayIntentos[contadorEjecucion] = " ";
				int j = 0;
				
				for (int i = 0; i < 1; j++ ) {
					
					if (progreso[j].equals(" ")) {
						
						progreso[j] = letras[j];
						i++;
						
					}	
				}
			}

			//Si el jugador activa el modo navideÒo
			if (intento.equalsIgnoreCase("christmas")) {
				
				navidad = true;
				navidadEscape = true;
				
			}
			
			//Si el jugador introduce una sola letra:
			if (intento.length() == 1) {
				
				//Buscar letra e imprimir resultado
				for (int i = 0; i < letras.length; i++) {
					
					if (intento.equalsIgnoreCase(letras[i])) {
						
						progreso[i] = letras[i];
						contadorCoincidencias++;
						coincidencia = true;
					}
					
				}	
				
				//Si la letra no se ha encontrado y el godmode estÔøΩ desactivado se aÔøΩade un fallo
				if (contadorCoincidencias == 0) {
					
					coincidencia =false;
					
					if (godmode == false) {
						
						fallos++;
						
					}		
				}
			}
			else {
				
				//Si el jugador introduce una palabra

				if (intento.equalsIgnoreCase(Palabras.getPalabra())) {
					
					for (int i = 0; i < letras.length; i++) {
							
						progreso[i] = letras[i];
						coincidencia = true;
						
					}
					
				}
				else {
					
					if (!esTrampa()) {
						
						coincidencia = false;
						
						if (godmode == false) {
							
							fallos++;
						
						}
					}
				}	
			}
			
			//Resetear contador de coincidencias para el siguiente intento
			contadorCoincidencias = 0;
			
			//A√±adir 1 m√°s al contador de ejecuciones
			contadorEjecucion++;

		} while(fallos < 6 && !isTerminado() && navidadEscape == false);
	
		Ventana.getVentana().repaint();
		
		if (navidad == true) {
			
			modoNavidad();
			
		}
		
	}
	
	//Resetear el juego cuando el usuario use el cheat christmas
	public static void modoNavidad() {
		
		Palabras.elegirPalabraNavidad();
		
		String letras[] = Palabras.separarLetras();
		
		resetearJuego();
		
		bucleJuego(letras);
		
	}
	
	
	//M√©todo boolean para saber si el jugador ha adivinado la palabra y el juego tiene que terminar
	public static boolean isTerminado () {
		terminado = true;
		for (int i = 0; i < progreso.length; i++) {
			
			if (progreso[i] == " ") {
				
				terminado = false;
				
			}
		}
		
		return terminado;
	}
	
	
	//Boolean para saber si el jugador ha introducido un cheat en este turno
	public static boolean esTrampa() {
		
		if (intento.equalsIgnoreCase("godmode on") || intento.equalsIgnoreCase("godmode off") || intento.equalsIgnoreCase("hint") || intento.equalsIgnoreCase("christmas")) {
			
			trampaActivada = true;
		
		}
		else {
			
			trampaActivada = false;
			
		}
		
		return trampaActivada;
		
	}
	
	//MÈtodo para resetear juego cuando el usuario quiera jugar otra vez o use el cheat "christmas"
	
	public static void resetearJuego() {
		
		fallos = 0;
		contadorEjecucion = 0;
		godmode = false;
		pista = false;
		coincidencia = false;
		
		if (navidadEscape == true) {
			
			navidad = false;
			
		}
		
		navidadEscape = false;
		
		for (int i = 0; i < arrayIntentos.length; i++) {
			
			arrayIntentos[i] = null;
			
		}
		
		progreso = new String[Palabras.getPalabra().length()];
		
		Ventana.setLetraProgreso(progreso);
		
		Ventana.setLetrasPorSeparado(Palabras.separarLetras());
		
		Ventana.setVentanaIntentos(arrayIntentos);
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


	public static String getIntento() {
		return intento;
	}


	public static void setIntento(String intento) {
		Juego.intento = intento;
	}


	public static boolean isGodmode() {
		return godmode;
	}


	public static void setGodmode(boolean godmode) {
		Juego.godmode = godmode;
	}


	public static boolean isTrampaActivada() {
		return trampaActivada;
	}


	public static void setTrampaActivada(boolean trampaActivada) {
		Juego.trampaActivada = trampaActivada;
	}


	public static boolean isPista() {
		return pista;
	}


	public static void setPista(boolean pista) {
		Juego.pista = pista;
	}


	public static boolean isNavidad() {
		return navidad;
	}


	
	
}
