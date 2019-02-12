package arkanoid.version01;

import java.util.ArrayList;
import java.util.List;

public abstract class Fase {

	protected List<Actor> actoresFase = new ArrayList<Actor>();
	protected String fondo;
	protected static String colores[] = new String[] { "cian", "verde", "magenta", "verdeOscuro", "naranja", "rojo", "rompible", "irrompible"};
    protected static int numLadrillosPosibles = Arkanoid.ANCHO / (50 + Ladrillo.ESPACIO_ENTRE_LADRILLOS);

	/**
	 * Metodo abstracto que iniciara la fase en cuestion
	 */
	
	public abstract void initFase();

	/**
	 * Getters
	 * @return
	 */
	
	public List<Actor> getActoresFase() {
		return actoresFase;
	}
	
	public String getFondo() {
		
		return "fondo";
		
	}
	
}
