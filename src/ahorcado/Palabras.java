package ahorcado;

public class Palabras {
	private static String palabra;
	public static String palabrasPosibles[] = new String[] {"aburrido", "acido", "alegre", "alto", "amargo", "ancho", "atrevido", "azul", "bajo", "blanco", "blando", "bonito", "buen", "caliente", "capaz", "central", "chungo", "comun", "conocido", "contento", "corto", "debil", "delgado", "derecho", "diferente", "dificil", "dulce", "duro", "enfermo", "estrecho", "exterior", "facil", "falso", "famoso", "feo", "final", "fresco", "frio", "fuerte", "gordo", "grande", "guay", "guapo", "humedo", "igual", "imposible", "interesante", "interior", "inutil", "izquierdo", "joven", "largo", "lento", "listo", "malo", "masivo", "mayor", "mejor", "menor", "mucho", "muerto", "musical", "nacional", "natural", "negro", "nuevo", "peor", "pequeño", "perfecto", "pobre", "poco", "popular", "posible", "primero", "principal", "proximo", "rapido", "raro", "real", "recto", "rico", "rojo", "salado", "sano", "seco", "segundo", "simple", "sinverguenza", "social", "solo", "soso", "timido", "tonto", "triste", "util", "verdadero", "verde", "viejo", "vivo", "crema", "explosion", "navaja", "universidad", "llaves", "papa", "catre", "escuela", "codo", "mapa", "lima", "edificio", "hojas", "granizo", "mano", "musica", "habitacion", "abuelo", "templo", "plato", "botella", "casa", "planeta", "metal", "mono", "petroleo", "debate", "ruedo", "herramienta", "anteojos", "zapato", "ojo", "ciente", "diente", "buzo", "puerta", "ensalada", "candidato", "diario", "hierro", "barco", "tecla", "departamento", "hipopotamo", "arbol", "discurso", "recula", "lentejas", "reloj", "desodorante", "montañas", "mono", "partido", "fiesta", "cafe", "guitarra", "martillo", "lapicera", "letra", "libreria", "rueda", "camisa", "sillon", "teclado", "pantalla", "tenedor", "pantalla", "tenedor", "agua", "cohete", "cesped", "parlante", "pestaña", "monitor", "hombre", "velero", "palo", "lentes", "nube", "castillo", "libro", "televisor", "telefono", "percha", "anillo", "pared", "cartas", "impresora", "luces", "bomba", "boligrafo", "gobierno", "enano", "persona", "guantes", "proyector", "muela", "remate", "cuaderno", "taladro", "chocolate", "caramelos", "angustia", "lluvia", "corbata", "periodico", "planta", "chupete", "oficina", "persiana", "silla", "pradera", "zoologico", "deporte", "recipiente", "fotografia", "ave", "refugio", "pantalon", "carne", "nieve", "humedad", "pistola", "tristeza", "sofa", "cama", "campera", "coche", "cinturon", "famoso", "madera", "piso", "maletin", "diputado", "cuchillo", "candado", "luz", "ordenador", "radio", "cuadro", "calor", "teatro", "bala", "auriculares", "plastico", "libro", "aluminio", "agujeta", "sonido", "perro", "pelo", "felicidad", "servilleta", "sol", "estadistica", "mensaje", "rey", "presidencia", "colegio", "lampara", "flor", "tornillo", "abuela", "satelite"}; 
	public static String palabrasNavidad[] = new String[] {"nochevieja", "nochebuena", "navidad", "celebracion", "turron", "polvorones", "abeto", "muerdago", "luces", "villancico", "belen", "regalo", "reyes", "estrella"};
	
	public Palabras() {
		super();
	}
	
	//Metodo para elegir palabra al azar
	public static String elegirPalabra() {	
		
		int azar = (int) Math.round(Math.random() * (palabrasPosibles.length - 1));
				
		palabra = palabrasPosibles[azar];
		
		System.out.println(palabra);
		
		return palabra;
	}
	
	//Metodo para elegir palabra al azar si el jugador activa 
	public static String elegirPalabraNavidad() {	
		
		int azar = (int) Math.round(Math.random() * (palabrasNavidad.length - 1));
				
		palabra = palabrasNavidad[azar];
		
		System.out.println(palabra);
		
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

	public static String[] getPalabrasPosibles() {
		return palabrasPosibles;
	}
	
	
}
