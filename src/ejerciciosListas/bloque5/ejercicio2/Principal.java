package ejerciciosListas.bloque5.ejercicio2;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Principal {
	
	public static void main(String[] args) {

		Cliente clientes[] = new Cliente[10];
		String nombres[] = new String[] {"Dani", "Rafa", "Joaquín", "Eva", "Miguel", "Jorge" ,"Juan","Antonio","Carmen","Juan Carlos"}; 
		
		for (int i = 0; i < clientes.length; i++) {
			
			clientes[i] = new Cliente(nombres[i]);
			
		}
		
		Cola cola1 = new Cola();
		Cola cola2 = new Cola();
		double numero;
		int clienteAleatorio;
		
		do {
			
			numero =  Math.random();
			
			clienteAleatorio = (int) Math.round(Math.random() * 9);
			
			if (numero < 0.5) {
				
				cola1.anadirCliente(clientes[clienteAleatorio]);
				
			}
			else {
				
				if (cola1.clientes.size() > 4) {
					
					cola1.despacharCliente();
					
				}
				
			}
			
			if (cola1.clientes.size() >= 8) {
				
				cola2.clientes = cola1.dividirCola();
				
			}
			
			cola1.imprimirCola();
			
			System.out.println();
			
			if (cola2.clientes.size() > 0) {
				
				System.out.println("Cola 2: ");
				cola2.imprimirCola();
				
			}
			
			JOptionPane.showMessageDialog(null,"Pausa");
			
			System.out.println();
		}while(true);
		
		
	}
	
	
	
}
