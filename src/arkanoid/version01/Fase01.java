package arkanoid.version01;

public class Fase01 extends Fase {
	
	protected static final int MARGEN_SUPERIOR = 20;

	/**
	 * Constructor
	 */
	
	public Fase01() {	
		super();
		
		this.fondo = "fondoArkanoid1.jpg";
		
		initFase();
	}
	
	/**
	 * Metodo que inicia la fase
	 */
	
	public void initFase() {
		
		String colores[] = new String[] { "cian", "verde", "magenta", "verdeOscuro", "naranja", "rojo"};
					
		// Inicializamos los ladrillos
	    int numLadrillosPosibles = Arkanoid.ANCHO / (48 + Ladrillo.ESPACIO_ENTRE_LADRILLOS);
	    int margenIzquierdo = (Arkanoid.ANCHO % (48 + Ladrillo.ESPACIO_ENTRE_LADRILLOS)) / 2;
	    
	    // Creamos las filas
	    for (int i = 0; i < colores.length; i++) {
	    	for (int j = 0; j < numLadrillosPosibles; j++) {
		    	this.actoresFase.add(new Ladrillo(margenIzquierdo + j * (48 + Ladrillo.ESPACIO_ENTRE_LADRILLOS), 
		    			MARGEN_SUPERIOR + i * (24 + Ladrillo.ESPACIO_ENTRE_LADRILLOS), colores[i]));
		    }
	    }
	}
		
}

