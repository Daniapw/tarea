package ejerciciosTema6.bloque1Hashmap.Ejercicio1;

public class Articulo {

	protected String codBarras;
	protected String numeroEstante;
	protected String desc;
	
	/**
	 * Constructor
	 * @param codBarras
	 * @param numeroEstante
	 * @param desc
	 */
	public Articulo(String codBarras, String numeroEstante, String desc) {
		
		super();
		this.codBarras = codBarras;
		this.numeroEstante = numeroEstante;
		this.desc = desc;
		
	}
	
	/**
	 * Metodo toString()
	 */
	public String toString() {
		
		String str= "Articulo " + this.desc
		+ "\n-Codigo de barras: " + this.codBarras
		+ "\n-Estante: " + this.numeroEstante + "\n\n";
		
		return str;
	}
}
