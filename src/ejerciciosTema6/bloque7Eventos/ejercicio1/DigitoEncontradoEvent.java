package ejerciciosTema6.bloque7Eventos.ejercicio1;

import java.util.ArrayList;
import java.util.List;
/**
 * Esta clase es el evento que se creara cuando se encuentra un digito en la frase del usuario
 * Dentro contiene una lista con los numeros introducidos por el usuario
 * @author diurno
 *
 */
public class DigitoEncontradoEvent {
	List<Integer> digitos = new ArrayList<Integer>();
	
	public DigitoEncontradoEvent(List<Integer> lista) {
		
		super();
		this.digitos=lista;
		
	}
	
	
}
