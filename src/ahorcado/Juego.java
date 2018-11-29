package ahorcado;

import javax.swing.JOptionPane;

public class Juego {
	
	private static int fallos = 0;
	private static String arrayIntentos[] = new String[100];
	
	//Contador de ejecuciones del juego para poder imprimir los errores del usuario
	private static int contadorEjecucion = 0;
	
	//Contador para saber si el jugador ha acertado al meter una letra o no
	private static int contadorCoincidencias = 0;
	
	//booleano que se le pasa al método "isTerminado", que determinará si el jugador ha completado la palabra o no
	private static boolean terminado = true;
	
	//Método para el bucle principal del juego
	public static void bucleJuego (String letras[]) {
		
		//progreso es el Array en el que se va guardando el progreso del jugador. Se inicializa con "_" que se irán sustituyendo por letras
		String progreso[] = new String[Palabras.getPalabra().length()];
		
		for (int i = 0; i < progreso.length; i++) {
			
			progreso[i] = "_";
			
		}
		
		do {
			
			Ventana.getVentana().repaint();
			
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

				if (intento.equals(Palabras.getPalabra())) {
					
					for (int i = 0; i < letras.length; i++) {
							
						System.out.print(letras[i] + " ");
						progreso[i] = letras[i];	
					}
					
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
		
		if (terminado ==true) {
			System.out.println("\n¡Enhorabuena, has ganado!");
		}
		
		return terminado;
	}
	
	//Getters y setters
	public int getFallos() {
		return fallos;
	}


	public void setFallos(int fallos) {
		this.fallos = fallos;
	}


	public String[] getArrayIntentos() {
		return arrayIntentos;
	}


	public void setArrayIntentos(String[] arrayIntentos) {
		this.arrayIntentos = arrayIntentos;
	}


	public int getContadorEjecucion() {
		return contadorEjecucion;
	}


	public void setContadorEjecucion(int contadorEjecucion) {
		this.contadorEjecucion = contadorEjecucion;
	}


	public int getContadorCoincidencias() {
		return contadorCoincidencias;
	}


	public void setContadorCoincidencias(int contadorCoincidencias) {
		this.contadorCoincidencias = contadorCoincidencias;
	}


	public boolean isTerminado() {
		return terminado;
	}


	public void setTerminado(boolean terminado) {
		this.terminado = terminado;
	}
	
	
	
}
