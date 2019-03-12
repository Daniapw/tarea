package ejerciciosTema6.bloque7Eventos.ejercicio1;

/**
 * Este es la interfaz DigitoEncontradoListener. Este listener tiene el metodo digitoEncontrado(), al que hay que pasarle un evento DigitoEncontradoEvent
 * Las clases que la implementen seran las encargadas de desarrollar ese metodo, podiendo hacer lo que quieran con el
 * @author diurno
 *
 */
public interface DigitoEncontradoListener {

	public void digitoEncontrado(DigitoEncontradoEvent evento);
	
}
