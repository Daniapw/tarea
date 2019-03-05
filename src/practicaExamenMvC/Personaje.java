package practicaExamenMvC;

public abstract class Personaje {

	protected String nombre;
	protected String movEspecial;
	protected int id;
	protected float vida;
	protected float fuerza;
	
	/**
	 * Metodo abstracto para atacar
	 */
	public abstract void atacar(Personaje rival);
}
