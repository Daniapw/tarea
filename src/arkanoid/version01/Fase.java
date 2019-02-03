package arkanoid.version01;

import java.util.ArrayList;
import java.util.List;

public abstract class Fase {

	protected List<Actor> actoresFase = new ArrayList<Actor>();
	protected String fondo;
	
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
