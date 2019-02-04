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
		
		String colores[] = new String[] { "#77abff", "#b8f759", "#fcfc2d", "#f49529", "#bc0197", "#ff052a"};
					
		// Inicializamos los ladrillos
	    int numLadrillosPosibles = Arkanoid.ANCHO / (32 + Ladrillo.ESPACIO_ENTRE_LADRILLOS);
	    int margenIzquierdo = (Arkanoid.ANCHO % (32 + Ladrillo.ESPACIO_ENTRE_LADRILLOS)) / 2;
	    
	    // Creamos las filas
	    for (int i = 0; i < colores.length; i++) {
	    	for (int j = 0; j < numLadrillosPosibles; j++) {
		    	this.actoresFase.add(new Ladrillo(margenIzquierdo + j * (32 + Ladrillo.ESPACIO_ENTRE_LADRILLOS), 
		    			MARGEN_SUPERIOR + i * (22 + Ladrillo.ESPACIO_ENTRE_LADRILLOS), colores[i]));
		    }
	    }
	}
		
}

