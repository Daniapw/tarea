package arkanoid.version01;

public class Fase01 extends Fase {
	
    private int margenIzquierdo = (600 % (50 + Ladrillo.ESPACIO_ENTRE_LADRILLOS)) / 2;
    private int MARGEN_SUPERIOR = 20;

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
		
	    /*for (int i = 0; i < (colores.length - 2); i++) {
	    	for (int j = 0; j < 11; j++) {
		    	this.actoresFase.add(new Ladrillo(margenIzquierdo + j * (50 + Ladrillo.ESPACIO_ENTRE_LADRILLOS), 
		    			MARGEN_SUPERIOR + i * (24 + Ladrillo.ESPACIO_ENTRE_LADRILLOS), colores[i]));
		    }
	    }*/
		
		this.actoresFase.add(new Ladrillo(500, 350, "rojo"));
		this.actoresFase.add(new Ladrillo(300, 350, "irrompible"));
		this.actoresFase.add(new Ladrillo(150, 350, "rompible"));
	}
		
}

