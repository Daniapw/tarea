package ejerciciosListas.bloque5.ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Cola {
	
	public List<Cliente> clientes= new ArrayList<Cliente>();
	
	public Cola() {
		
		super();
		
	}
	/**
	 * 
	 * @param cliente
	 */
	public void anadirCliente(Cliente cliente) {
		
		clientes.add(cliente);
		
	}
	/**
	 * 
	 */
	public void despacharCliente() {
		
		clientes.remove(0);
		
	}
	/**
	 * 
	 * @return
	 */
	public List<Cliente> dividirCola() {
		
		List<Cliente> nuevaCola = new ArrayList<Cliente>();
		
		for (int i = 0; i < clientes.size(); i++) {
			 
			if (i % 2 != 0) {
				
				nuevaCola.add(clientes.get(i));
				
			}

		}
		
		clientes.removeAll(nuevaCola);
		
		return nuevaCola;
	}
	
	/**
	 * 
	 * @param lista
	 */
	public void imprimirCola() {
		
		for (int i = 0; i < this.clientes.size(); i++) {
			
			System.out.println("Cliente " + i + " " + this.clientes.get(i).nombre);
			
		}
		
	}
	
}
