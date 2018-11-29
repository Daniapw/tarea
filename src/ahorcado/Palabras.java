package ahorcado;

public class Palabras {
	private static String palabra;
	private static String palabrasPosibles[] = new String[]{"hola", "adios", "pantalla", "silla", "mesa", "daniel"};

	public Palabras() {
		super();
	}
	
	public static String elegirPalabra() {
		
		//Generar número aleatorio para determinar con qué palabra jugaremos
		int azar = (int) Math.round(Math.random() * (palabrasPosibles.length - 1));
		
		palabra = palabrasPosibles[azar];
				
		System.out.println(palabra);
	
		//Bucle para mostrar la longitud de la palabra con "_"
		for (int i = 0; i < palabra.length(); i++) {
			
			System.out.print("_ ");
			
		}
			
		return palabra;
	}
	
	
	//Método para poner las letras de la palabra por separado
	
	public static String[] separarLetras() {
		
		char charsPalabra[] = new char[palabra.length()];
		String letras[] = new String[palabra.length()];
		
		for (int i = 0; i < palabra.length(); i++) {
					
			charsPalabra[i] = palabra.charAt(i);
			letras[i] = String.valueOf(charsPalabra[i]);
			
		}
		
		return letras;
	}
	
	
	//Getters y setters
	public static String getPalabra() {
		return palabra;
	}

	public static void setPalabra(String palabra) {
		Palabras.palabra = palabra;
	}

	public static String[] getPalabrasPosibles() {
		return palabrasPosibles;
	}

	public static void setPalabrasPosibles(String[] palabrasPosibles) {
		Palabras.palabrasPosibles = palabrasPosibles;
	}
	
}
