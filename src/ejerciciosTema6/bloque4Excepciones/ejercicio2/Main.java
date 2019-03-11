package ejerciciosTema6.bloque4Excepciones.ejercicio2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

public class Main {

	protected static List<String> listaInsultos = new ArrayList<String>();
	
	public static void main(String[] args) {
		
		listaInsultos.add("tonto");
		listaInsultos.add("tonta");
		listaInsultos.add("idiota");

		
		try {
			
			if (pedirFrase().contains("bombilla")) {
				
				System.out.println("La frase contiene la palabra bombilla!");
				
			}
			
		}
		catch(EspacioEnBlancoException e){
			
			System.out.println("Error: Solo has escrito espacios en blanco");
			
		}
		catch(InsultoDetectadoException e) {
			
			System.out.println("Error: Has escrito un insulto.");
			
		}
		catch(MenosQue3PalabrasException e) {
			
			System.out.println("Error: La frase contiene menos de 3 palabras");
			
		}
		catch(NoSeHaEncontradoBombillaException e) {
			
			System.out.println("Error: La frase no contiene la palabra 'bombilla'");
			
		}
		
		System.out.println("Fin del programa");
	}

	/**
	 * Metodo que pide la frase y comprueba su contenido
	 * @return
	 * @throws EspacioEnBlancoException
	 * @throws InsultoDetectadoException
	 * @throws MenosQue3PalabrasException
	 * @throws NoSeHaEncontradoBombillaException
	 */
	
	public static String pedirFrase() throws EspacioEnBlancoException, InsultoDetectadoException, MenosQue3PalabrasException, NoSeHaEncontradoBombillaException {
		
		//Se pide la frase
		String frase = JOptionPane.showInputDialog("Introduce una frase que contenga la palabra 'bombilla'");
		
		//Se divide la frase en caracteres separados por espacios
		String palabras[] = frase.split(" ");
		
		//Si la frase solo tiene espacios lanza una excepcion EspacioEnBlancoException()
		if (frase.matches("[ ]+")) {
			
			throw new EspacioEnBlancoException();
			
		}
	
		/*Se recorre la lista de insultos y si la frase contiene alguno
		 * lanza una excepcion InsultoDetectadoException()
		 */
		for (String insulto:listaInsultos) {
			
			if (frase.contains(insulto)) throw new InsultoDetectadoException();

		}
		
		//Si la frase tiene menos de 3 palabras se lanza una excepcion MenosQue3PalabrasException()
		if (palabras.length < 3) {
			
			throw new MenosQue3PalabrasException();
			
		}
		
		//Si la frase no contiene la palabra 'bombilla' se lanza una excepcion NoSeHaEncontradoBombillaException()
		if (!frase.contains("bombilla")) {
			
			throw new NoSeHaEncontradoBombillaException();
			
		}
		
		//Por ultimo se devuelve la frase
		return frase;
	}
}
