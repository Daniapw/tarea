package ejerciciosTema6.bloque7Eventos.ejercicio1;

public class BuscaDigitos implements DigitoEncontradoListener {

	@Override
	public void digitoEncontrado(DigitoEncontradoEvent evento) {
		System.out.println("\nSe han encontrado 3 o mas digitos:");
		
		for (Integer digito:evento.getDigitos()) {
			
			System.out.print(digito + " ");
			
		}
		
	}

	
}
