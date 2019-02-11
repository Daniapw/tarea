package arkanoid.version01;

public class Fase02 extends Fase {
	

	private int margenIzquierdo = 1;
	
	private int ladrillos[][] = new int[][] {
		//"1-cian", "2-verde", "3-magenta", "4-verdeOscuro", "5-naranja", "6-rojo", "7-rompible", "8-irrompible"
		{7, 7, 7, 7, 8, 0, 8, 7, 7, 7, 7},
		{1, 1, 1, 1, 8, 0, 8, 1, 1, 1, 1},
		{2, 2 ,2, 2, 8, 0, 8, 1, 1, 1, 1},
		{3, 3, 3, 3, 8, 0, 8, 3, 3, 3, 3},
		{4, 4, 4, 4, 8, 0, 8, 4, 4, 4, 4},
		{5, 5, 5, 5, 8, 0, 8, 5, 5, 5, 5},
		{6, 6, 6, 6, 8, 0, 8, 6, 6, 6, 6},
		{7, 7, 7, 7, 8, 0, 8, 7, 7, 7, 7}
		
		
	}; 
	
	/**
	 * Constructor
	 */
	public Fase02() {
		super();
		
		this.fondo = "fondo2.jng";
		
		
	}
	
	/**
	 * Metodo que inicia la fase
	 */
	public void initFase() {

		 for (int i = 0; i < ladrillos.length; i++) {
		    	for (int j = 0; j < numLadrillosPosibles; j++) {
			    	this.actoresFase.add(new Ladrillo(margenIzquierdo + j * (50 + Ladrillo.ESPACIO_ENTRE_LADRILLOS), 
			    			MARGEN_SUPERIOR + i * (24 + Ladrillo.ESPACIO_ENTRE_LADRILLOS), colores[j]));
			    }
		    }
		
	}
	
	
}
