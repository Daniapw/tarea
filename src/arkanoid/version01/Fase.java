package arkanoid.version01;

import java.util.ArrayList;
import java.util.List;

public abstract class Fase {

	protected List<Actor> actores = new ArrayList<Actor>();
	
	/**
	 * Metodo abstracto que iniciara la fase en cuestion
	 */
	public abstract void initFase();

	
	/**
	 * Getter
	 * @return
	 */
	public List<Actor> getActores() {
		return actores;
	}
	
	
}
