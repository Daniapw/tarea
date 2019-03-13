package ejerciciosTema6.bloque7Eventos.ejercicio1;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Main {
	
	/**
	 * Esta es la lista de listeners, se ha de poner en la clase que va a "escuchar" para ver si se
	 * produce un evento
	 * Se suele poner en privado
	 */
	private static List<DigitoEncontradoListener> digitoEncontradoListeners = new ArrayList<DigitoEncontradoListener>();
	
	/**
	 * Estos son los metodos para anadir un listener y para quitarlo
	 * @param listener
	 */
	public static void addDigitoEncontradoListener(DigitoEncontradoListener listener) {
		
		digitoEncontradoListeners.add(listener);
		
	}
	
	public static void removeDigitoEncontradoListener(DigitoEncontradoListener listener) {
		
		digitoEncontradoListeners.remove(listener);
		
	}
	
	/**
	 * Este es el metodo fire. Es el encargado de pasarle el evento a los listeners
	 * Se pone siempre en privado
	 * @param listaNumeros
	 */
	private static void fireDigitoEncontradoListener(List<Integer> listaNumeros) {
		
		for (int i = 0; i < digitoEncontradoListeners.size(); i++) {
			
			digitoEncontradoListeners.get(i).digitoEncontrado(new DigitoEncontradoEvent(listaNumeros));
			
		}
		
	}
	
	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*
		 * Primero se anade la clase BuscaDigitos, que implementa la interfaz DigitoEncontradoListener.
		 * Esta clase sera la notificada de que se ha introducido un digito, es decir, la que recibira el evento DigitoEncontradoEvent, que contiene
		 * la lista de digitos introducidos por el usuario
		 */
		BuscaDigitos buscador = new BuscaDigitos();
		
		addDigitoEncontradoListener(buscador);
		
		String frase;
		
		List<Integer> listaNumeros = new ArrayList<Integer>();
		
		//Se le piden palabras al usuario continuamente
		do {
			
			frase = JOptionPane.showInputDialog("Introduce una palabra");
			
			//Se separa la frases en caracteres, que se guardan en el array caracteres[]
			char caracteres[] = frase.toCharArray();
			
			//Se recorre el array de caracteres de la palabra
			for (char caracter:caracteres) {
				
				//Si el caracter es un digito se anade a la listaNumeros
				if (Character.isDigit(caracter)) {
					
					listaNumeros.add(Character.getNumericValue(caracter));
					
				}
				
			}
			
			//Si la lista tiene un tamanio de 3 o mas digitos se llama 
			//al metodo fireDigitoEncontradoListener(), pasandole la lista
			if (listaNumeros.size() >= 3) fireDigitoEncontradoListener(listaNumeros);
			
			//Por ultimo se limpia la lista para la siguiente iteracion
			listaNumeros.clear();
			
		}while(true);

	}

}
