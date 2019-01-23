package ejerciciosListas.bloque5.ejercicio3;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


public class Coleccion {
	public List<Cromo> cromos = new ArrayList<Cromo>();
	
	/**
	 * 
	 */
	public Coleccion() {
		super();
		
	}
	/**
	 * 
	 * @param id
	 * @param descripcion
	 */
	public void anadirCromo() {
		
		int id = Integer.parseInt(JOptionPane.showInputDialog("Introduce la ID del cromo"));		
	
		String descripcion = JOptionPane.showInputDialog("Introduce la descripcion del cromo");	
	
		Cromo cromo = new Cromo(id, descripcion);
		
		this.cromos.add(cromo);
		
		JOptionPane.showMessageDialog(null, "Cromo anadido con exito");
		
	}
	/**
	 * 
	 */
	public void imprimirLista() {
		
		System.out.println("Tu coleccion:");
		
		for (int i = 0; i < cromos.size(); i++) {
			
			System.out.println(cromos.get(i).toString());
			
		}
		
	}
	
	/**
	 * 
	 */
	public void imprimirRepes() {
		
		int contador = 0;
		boolean repe = false;
		
		for (int i = 0; i < cromos.size(); i++) {
			
			contador = 0;
			
			for (int j = 0; j < cromos.size(); j++) {
				
				if (cromos.get(j).equals(cromos.get(i))) {
					
					contador++;
					repe = true;
					
				}
				
				if (j == cromos.size() && contador > 0) {
					
					System.out.println("Tienes " + contador + " " + cromos.get(j).toString());
					
				}
				
			}
			
		}
		
		if (!repe) {
			
			JOptionPane.showMessageDialog(null, "No hay ningún cromo repetido en tu coleccion");
			
		}
		
	}
	/**
	 * 
	 * @param lista
	 */
	public void compararColeccion(Coleccion coleccion) {
		
		List<Cromo> listaFaltan = new ArrayList<Cromo>();
		
		int contador=0;
		
		boolean faltan = false;
		
		for (int i = 0; i < coleccion.cromos.size(); i++) {
			
			if (!this.cromos.contains(coleccion.cromos.get(i))) {
				
				listaFaltan.add(coleccion.cromos.get(i));
				contador++;
				faltan = true;
				
			}
			
		}
		
		if (faltan = true) {
			System.out.println("Te faltan " + contador + " cromos:");
			
			for (int i = 0; i < listaFaltan.size(); i++) {
				
				System.out.println(listaFaltan.get(i).toString());
				
			}	
		}
		else {
			
			JOptionPane.showMessageDialog(null, "Tienes todos los cromos!");
			
		}
		
	}
}
