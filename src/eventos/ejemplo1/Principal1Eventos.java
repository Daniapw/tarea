package eventos.ejemplo1;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Principal1Eventos {

	static List<PalabraSecretaListener> listeners = new ArrayList<PalabraSecretaListener>();
	
	
	
	public static void main(String[] args) {
		
		String palabra = JOptionPane.showInputDialog("Introduce una palabra");
		
		while (true) {
			
			palabra = JOptionPane.showInputDialog("Introduce una palabra");
			
		}
		

	}

}
