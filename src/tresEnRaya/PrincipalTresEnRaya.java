package tresEnRaya;

public class PrincipalTresEnRaya {
	
	private static int indiceJugadorActivo = 1;
	public static Jugador jugadores[] = new Jugador[2];
	public static Matriz tablero = new Matriz();
	public static VentanaJuego ventana = new VentanaJuego();
	
	public static void main(String[] args) {
		
		jugadores[0] = new Jugador("Equis", 1);
		jugadores[1] = new Jugador("Círculo", 2);
		
		ventana.repaint();

	}
	
	//Método para avanzar al siguiente turno
	public static int avanzarTurno() {
		
		if (indiceJugadorActivo== 1) {
			
			indiceJugadorActivo = 2;

		}
		else {
			
			indiceJugadorActivo = 1;
			
		}
		
		return indiceJugadorActivo;
		
	}

	//Método para resetear el juego en caso de que los jugadores quieran volver a jugar
	public static void resetearJuego() {
		
		ventana.resetearCeldas();
		tablero.inicializarMatriz();
		indiceJugadorActivo = 1;
		
	}

	//Getters y setters
	public static Jugador getJugadorActivo() {
		return jugadores[indiceJugadorActivo - 1];
	}

	public static void setIndiceJugadorActivo(int indiceJugadorActivo) {
		PrincipalTresEnRaya.indiceJugadorActivo = indiceJugadorActivo;
	}

	
	
	

}
