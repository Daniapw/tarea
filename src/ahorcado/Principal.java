package ahorcado;

public class Principal {
	
	public static void main(String[] args) {
		
		Palabras.elegirPalabra();
	
		String letras[] = Palabras.separarLetras();
		
		Juego.bucleJuego(letras);
		
	}
	

}
