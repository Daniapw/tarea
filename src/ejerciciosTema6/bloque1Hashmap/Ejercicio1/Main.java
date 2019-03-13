package ejerciciosTema6.bloque1Hashmap.Ejercicio1;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class Main {
	protected static HashMap<String, Articulo> hm = new HashMap<String, Articulo>();
	protected static boolean almacenVacio = true;
	
	public static void main(String[] args) {
	
		int opcion=-1;
		
		//El bucle principal del programa se repetira hasta que el usuario introduzca un 0
		do {
			//El boolean almacenVacio controla si hay algun objeto en el Hashmap
			if (hm.isEmpty()) {
				almacenVacio = true;
			}
			else {
				almacenVacio = false;
			}
			
			//Menu de opciones
			opcion = Integer.parseInt(JOptionPane.showInputDialog("Selecciona una opcion:"
					+ "\n\t1-.Anadir articulo"
					+ "\n\t2-.Borrar articulo"
					+ "\n\t3-.Actualizar estante de un articulo"
					+ "\n\t4-.Imprimir lista de articulos"
					+ "\n\t5-.Consultar localizacion de un articulo"
					+ "\n\t0-.Salir"));
			
			
			//Switch para la opcion introducida
			switch(opcion) {
			
			//Anadir un nuevo articulo
			case 1:{
				
				String codBarras = JOptionPane.showInputDialog("Introduce el codigo de barras del articulo:");
				
				if (!hm.containsKey(codBarras)) {
					String numeroEstante = JOptionPane.showInputDialog("Introduce el estante al que pertenece el articulo:");
					String desc = JOptionPane.showInputDialog("Introduce la descripcion del articulo:");
					
					anadirArt(codBarras,numeroEstante, desc);
				}
				else {
					
					JOptionPane.showMessageDialog(null, "El articulo ya esta en el inventario");
					
				}
				
				break;
			}
			
			//Borrar un articulo existente
			case 2:{
				
				if (!almacenVacio) {
					String key = JOptionPane.showInputDialog(imprimirArts()+"\nIntroduce el codigo de barras del articulo a borrar");
					
					//Si el articulo no esta en el inventario se mostrara un mensaje 
					if (!hm.containsKey(key)) {
						JOptionPane.showMessageDialog(null, "El articulo no esta en el inventario");
					}
					else {
						borrarArt(key);	
					}
					
				}
				else {
					
					JOptionPane.showMessageDialog(null, imprimirArts());
					
				}
				
				break;
			}
			
			//Modificar el estante de un articulo
			case 3:{
				
				if (!almacenVacio) {
					
					String key = JOptionPane.showInputDialog(imprimirArts()+"\nIntroduce el codigo de barras del articulo que quieres modificar:");
					
					//Si el articulo no esta en el inventario se mostrara un mensaje 
					if (!hm.containsKey(key)) {
						JOptionPane.showMessageDialog(null, "El articulo no esta en el inventario");
					}
					else {
						
						String estante= JOptionPane.showInputDialog("Introduce el numero del nuevo estante:");
	
						modificarEstante(key, estante);
					}
					
				}
				else {
					
					JOptionPane.showMessageDialog(null, imprimirArts());
					
				}
				
				break;
			}
			//Imprimir la lista de articulos
			case 4:{
				
				JOptionPane.showMessageDialog(null, imprimirArts());
				
				break;
			}
			//Consultar localizacion de un articulo
			case 5:{
				
				if (!almacenVacio) {
					String key = JOptionPane.showInputDialog(imprimirArts()+"\nIntroduce el codigo de barras del articulo:");
					
					JOptionPane.showMessageDialog(null, "El articulo esta en el estante " + consultarLocalizacion(key));
					
				}
				else {
					
					JOptionPane.showMessageDialog(null, imprimirArts());
					
				}
				
				break;
			}
			}
			
			
		}while(opcion!=0);

	}
	
	/**
	 * Metodo para anadir un articulo
	 * @param codBarras
	 * @param numeroEstante
	 * @param desc
	 */
	public static void anadirArt(String codBarras, String numeroEstante, String desc) {
	
		hm.put(codBarras, new Articulo(codBarras, numeroEstante, desc));
		JOptionPane.showMessageDialog(null, "Articulo introducido con exito");
	}

	/**
	 * Metodo para borrar un articulo
	 * @param key
	 */
	public static void borrarArt(String key) {
		
		hm.remove(key);
		JOptionPane.showMessageDialog(null, "Objeto borrado con exito");
		
	}
	
	/**
	 * Metodo para modificar estante de un objeto
	 * @param key
	 * @param estante
	 */
	public static void modificarEstante(String key, String estante) {
		
		Articulo articulo = hm.get(key);
		
		articulo.numeroEstante = estante;
		
		JOptionPane.showMessageDialog(null, "Estante modificado con exito");
		
	}
	
	public static String consultarLocalizacion(String key) {
		
		Articulo articulo = hm.get(key);
		
		return articulo.numeroEstante;
		
	}
	
	/**
	 * Metodo para imprimir los articulos
	 * @return
	 */
	public static StringBuffer imprimirArts() {
		StringBuffer str = new StringBuffer();
		
		if (!hm.isEmpty()) {
			Collection<Articulo> objetos= hm.values(); 

			for (Articulo articulo: objetos) {
				
				str.append(articulo.toString());
				
			}
			
			
		}
		else {
			
			str.append("No hay ningun objeto en el almacen");
			
		}
		
		return str;
	}
	
	
	
}
