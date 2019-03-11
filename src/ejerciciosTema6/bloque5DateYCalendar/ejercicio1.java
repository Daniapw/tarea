package ejerciciosTema6.bloque5DateYCalendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

public class ejercicio1 {
	protected static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	protected static Date fecha = null;
	
	public static void main(String[] args) {
		
		String pedirFecha = JOptionPane.showInputDialog("Por favor, introduzca una fecha:");
			
		formatearFecha(pedirFecha);
		imprimirCampos();
		
	}
	
	/**
	 * Formatear la fecha recibida
	 * @param pedirFecha
	 */
	public static void formatearFecha(String pedirFecha) {
		
		try {
			
			fecha = sdf.parse(pedirFecha);
			
			System.out.println(sdf.format(fecha));
			
		}
		catch(ParseException ex){
			
			System.out.println("Error: la fecha no se pudo parsear");
			
		}
		
	}
	
	/**
	 * Pasar fecha recibida a Calendar
	 * @param fecha
	 */
	public static void pasarACalendar() {
		
		Calendar calendario = Calendar.getInstance();
		
		calendario.setTime(fecha);
		
		Date fechaAPartirDeCalendar = calendario.getTime();
		
		System.out.println(sdf.format(fechaAPartirDeCalendar));
		
	}
	
	public static void imprimirCampos() {
		
		System.out.println("Anio: " + fecha.getYear());
		
	}

}
