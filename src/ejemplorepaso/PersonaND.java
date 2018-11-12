package ejemplorepaso;

public class PersonaND extends Persona {
	
	private String descripcion;
	
	public PersonaND(String nombre, String apellidos, String fechanac, String descripcion) {
		super(nombre, apellidos, fechanac);

	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
