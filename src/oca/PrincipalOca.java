package oca;

public class PrincipalOca {

	public static void main (String args[]) {
		
		Tablero tablero = new Tablero();
		
		//Imprimir tablero
		
		tablero.imprimeTablero();
		
		//Prueba de uso del primer jugador
		Jugador jugador = new Jugador("Rojo");
		
		do {
			jugador.tirarDado();
			jugador.imprimir();
		}while(jugador.getPosicion() < 62);
	}
	

}
