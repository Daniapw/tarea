package ejerciciosListas.bloque5.ejercicio3;

public class Cromo {
	public String descripcion;
	public int id;
	
	/**
	 * 
	 * @param descripcion
	 * @param id
	 */
	public Cromo(int id, String descripcion) {
		
		this.descripcion = descripcion;
		this.id = id;
		
	}
	
	/**
	 * 
	 */
	public String toString() {
		
		String str = "Cromo " + this.id + this.descripcion;
		
		return str;
	}
}
