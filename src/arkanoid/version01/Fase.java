package arkanoid.version01;

import java.util.ArrayList;
import java.util.List;

public abstract class Fase {

	public List<Actor> actores = new ArrayList<Actor>();
	
	
	public abstract void initLadrillos();
}
