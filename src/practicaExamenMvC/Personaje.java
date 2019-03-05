package practicaExamenMvC;

import java.util.ArrayList;
import java.util.List;

public abstract class Personaje {

	//Nombre del personaje
	protected String nombre;
	//ID del personaje para uso interno
	protected int id;
	//Puntos de vida
	protected float vida;
	//Fuerza del personaje
	protected float fuerza;
	//Lista de movs que va usar en este turno
	protected List<Ataque> ataques = new ArrayList<Ataque>();
	
	/**
	 * Metodo abstracto para atacar
	 */
	public abstract void atacar(Personaje rival);
}
