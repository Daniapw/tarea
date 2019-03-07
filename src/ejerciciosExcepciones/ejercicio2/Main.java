package ejerciciosExcepciones.ejercicio2;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		
		
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

	public static String pedirFrase() throws EspacioEnBlancoException, InsultoDetectadoException, MenosQue3PalabrasException, NoSeHaEncontradoBombillaException {
		
		String frase = JOptionPane.showInputDialog("Introduce una frase que contenga la palabra 'bombilla'");
		String palabras[] = frase.split(" ");
		
		if (frase.matches("[ ]+")) {
			
			throw new EspacioEnBlancoException();
			
		}
		
		if (frase.contains("[/tonto/|/tonta/|/idiota/]")) {
			
			throw new InsultoDetectadoException();
			
		}
		
		if (palabras.length < 3) {
			
			throw new MenosQue3PalabrasException();
			
		}
		
		if (!frase.contains("bombilla")) {
			
			throw new NoSeHaEncontradoBombillaException();
			
		}
		
		return frase;
	}
}
