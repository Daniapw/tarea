package ejemploPropiedades;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class EjemploPropiedades {

	private static Properties propiedades = null;
	
	public EjemploPropiedades() {
		
		super();
		
	}
	
	/**
	 * Singleton
	 * @return
	 */
	private static Properties getPropiedades() {
		
		if (propiedades == null) {
			
			propiedades = new Properties();
			
			try {
				propiedades.load(propiedades.getClass().getResourceAsStream("src/ejemploPropiedades/propiedades.properties"));
			} catch (FileNotFoundException e) {

				System.out.println("No se ha encontrado el archivo");	
				e.printStackTrace();
			}catch (IOException e) {
				
				System.out.println("Excepcion I/O");
				e.printStackTrace();
			}
			
		}
		
		return propiedades;
		
	}
	
	/**
	 * Coger propiedad String
	 * @param nombre
	 * @return
	 */
	public static String getProperty(String nombre) {
		
		return getPropiedades().getProperty(nombre);
		
	}
	
	/**
	 * Coger propiedad int
	 * @param nombre
	 * @return
	 */
	public static int getIntProperty(String nombre) {
		
		return Integer.parseInt(getPropiedades().getProperty(nombre));
		
	}
	
	/**
	 * Coger propiedad float
	 * @param nombre
	 * @return
	 */
	public static Float getFloatProperty(String nombre) {
		
		return Float.parseFloat(getPropiedades().getProperty(nombre));
		
	}
	
	public static void main(String[] args) {

		String nombre = EjemploPropiedades.getProperty("NOMBRE");
		int edad = EjemploPropiedades.getIntProperty("EDAD");
		float hora = EjemploPropiedades.getFloatProperty("HORA");
		
		System.out.println("Nombre: " + nombre
				+"\nEdad: " + edad
				+"\nHora: " + hora);

	}

}
