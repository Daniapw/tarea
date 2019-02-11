package arkanoid.version01;

public class Fase01 extends Fase {
	
    protected int margenIzquierdo = (Arkanoid.ANCHO % (50 + Ladrillo.ESPACIO_ENTRE_LADRILLOS)) / 2;
	protected int MARGEN_SUPERIOR = 20;

	/**
	 * Constructor
	 */
	
	public Fase01() {	
		super();
		
		this.fondo = "fondo2.jpg";
		
		initFase();
	}
	
	/**
	 * Metodo que inicia la fase
	 */
	
	public void initFase() {
		
	    for (int i = 0; i < (colores.length - 2); i++) {
	    	for (int j = 0; j < numLadrillosPosibles; j++) {
		    	this.actoresFase.add(new Ladrillo(margenIzquierdo + j * (50 + Ladrillo.ESPACIO_ENTRE_LADRILLOS), 
		    			MARGEN_SUPERIOR + i * (24 + Ladrillo.ESPACIO_ENTRE_LADRILLOS), colores[i]));
		    }
	    }
	}
		
}

