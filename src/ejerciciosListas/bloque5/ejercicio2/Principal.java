package ejerciciosListas.bloque5.ejercicio2;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Principal {
	
	public static void main(String[] args) {
		
		//Creaci�n de los objetos tipo Cliente
		Cliente clientes[] = new Cliente[10];
		String nombres[] = new String[] {"Dani", "Rafa", "Joaquín", "Eva", "Miguel", "Jorge" ,"Juan","Antonio","Carmen","Juan Carlos"}; 
		
		for (int i = 0; i < clientes.length; i++) {
			
			clientes[i] = new Cliente(nombres[i]);
			
		}
		
		//Creaci�n de las colas del supermercado
		Cola cola1 = new Cola();
		Cola cola2 = new Cola();
		
		//Variable cuyo valor determinar� si se a�ade un cliente o se despacha a otro
		double numero;
		
		//Variable que sacar� un valor aleatorio
		int clienteAleatorio;
		
		//Bucle principal del programa
		do {
			
			//Se genera un n�mero del 0 al 1
			numero =  Math.random();
			
			//Se genera un n�mero del 0 al 9
			clienteAleatorio = (int) Math.round(Math.random() * 9);
			
			//Si numero es menor que 0.5 
			if (numero < 0.5) {
				
				//Se a�ade un cliente a la cola
				cola1.anadirCliente(clientes[clienteAleatorio]);
				
				//Si la segunda cola est� activa (tiene clientes) y la primera est� ocupada se a�adir� un cliente a la segunda cola
				if (!cola2.clientes.isEmpty() && !cola1.clientes.isEmpty()) {
					
					cola2.anadirCliente(clientes[clienteAleatorio]);
					
				}
			}
			//Si el n�mero es mayor que 0.5
			else {
				
				//Si la cola 1 no est� vac�a se despachar� al primer cliente
				if (!cola1.clientes.isEmpty()) {
					
					cola1.despacharCliente();
					
				}
				
				//Si la cola 2 no est� vac�a se despachar� al primer cliente
				if (!cola2.clientes.isEmpty()) {
					
					cola2.despacharCliente();
					
				}
				
			}
			
			//Si la cola1 llega a 8 clientes, la cola dos se pondr� en uso llev�ndose a 4 clientes de la cola 1
			if (cola1.clientes.size() >= 8) {
				
				cola2.clientes = cola1.dividirCola();
				
			}
			
			//Se imprime la cola 1
			System.out.println("Cola 1: ");
			cola1.imprimirCola();
			
			System.out.println();
			
			//Se imprime la cola 2 si est� en uso
			if (cola2.clientes.size() > 0) {
				
				System.out.println("Cola 2: ");
				cola2.imprimirCola();
				
			}
			
			//Ventana para pausar el programa en cada iteraci�n del bucle
			JOptionPane.showMessageDialog(null,"Pausa");
			
			System.out.println();
		}while(true);
		
		
	}
	
	
	
}
