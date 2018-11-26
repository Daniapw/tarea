package ahorcado;

public class Palabras {
	public static String palabraelegida;
	public static String palabras[] = new String[]{"hola","adios","silla","mesa","pantalla"};

	public Palabras() {
		super();
	}
	
	public static void elegirPalabra() {
		
		palabraelegida = palabras[(int) Math.round(Math.random() * (palabras.length - 1))];
		
		System.out.println(palabraelegida);
		
		for (int i = 0; i < palabraelegida.length(); i++) {
			
			System.out.print("_ ");
			
		}
	}	
}
