package ejerciciosListas.bloque5.ejercicio2;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Principal {
	public static List<Cliente> caja1 = new ArrayList<Cliente>();
	
	public static void main(String[] args) {

		int opcion = -1;

		
		do {
			
			while (opcion < 0 || opcion > 4) {
			
				opcion = Integer.parseInt(JOptionPane.showInputDialog("Selecciona lo que quieres hacer:"
						+ "\n1. Anadir cliente"
						+ "\n2. Despachar cliente"
						+ "\n3. Dividir cola"
						+ "\n4. Comportamiento aleatorio"
						+ "\n0. Salir"));
			
				if (opcion < 0 || opcion > 4) {
					
					JOptionPane.showMessageDialog(null, "Opción inválida, introduce otra");
					
				}
				
			}
			
			
			
		}while (opcion!= 0);
	}

	
	public static void anadirClientes() {
		
		
	}
	
}
