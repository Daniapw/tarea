package ejerciciosTema6.bloque5DateYCalendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import javax.swing.JOptionPane;

public class ejercicio1 {
	protected static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	protected static Date fecha = null;
	
	public static void main(String[] args) {
			
		calcularDiferencia();
		
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
	public static Calendar pasarACalendar() {
		
		Calendar calendario = Calendar.getInstance();
		
		calendario.setTime(fecha);
		
		return calendario;
	}
	
	/**
	 * Imprimir campos con Date y Calendar
	 */
	public static void imprimirCampos() {
		Locale locale = Locale.getDefault();
		Calendar calendario = pasarACalendar();

		System.out.println("Fecha con Date: " + new SimpleDateFormat("EEEE dd 'de' MMMM 'de' yyyy").format(fecha) 
				+ "\nFecha con Calendar: " 
				+ "\nDia " + calendario.getDisplayName(calendario.DAY_OF_WEEK, Calendar.LONG, locale) + " " + calendario.get(Calendar.DAY_OF_MONTH)
				+ "\nMes " +  calendario.getDisplayName(calendario.MONTH, Calendar.LONG, locale)
				+ "\nAnio " + calendario.get(Calendar.YEAR));
	}

	/**
	 * Operaciones con Calendar
	 */
	public static void operacionesCalendar() {
		
		Calendar calendario = pasarACalendar();
		SimpleDateFormat sdf2 = new SimpleDateFormat("EEEE dd 'de' MMMM 'de' yyyy");
		
		//Sumar 3 días
		calendario.add(Calendar.DAY_OF_MONTH, 3);
		System.out.println("Sumar 3 días: " + sdf2.format(calendario.getTime()));
		
		//Restar dos semanas
		calendario.add(Calendar.WEEK_OF_YEAR, -2);
		System.out.println("Restar 2 semanas: " + sdf2.format(calendario.getTime()));
		
		//Sumar 300 dias
		calendario.add(Calendar.DAY_OF_MONTH, 300);
		System.out.println("Sumar 300 dias: " + sdf2.format(calendario.getTime()));
		
		//Sumar 4 anios
		calendario.add(Calendar.YEAR, 4);
		System.out.println("Sumar 4 anios: " + sdf2.format(calendario.getTime()));
		
	}
	
	/**
	 * Calcular diferencia entre zonas horarias
	 */
	public static void calcularDiferencia() {
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("EEEE dd 'de' MMMM 'de' yyyy");
		Calendar ahoraEnRoma = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"));
		Calendar ahoraEnNY = Calendar.getInstance(TimeZone.getTimeZone("America/New_York"));
		
		System.out.println("Hora actual en Roma: " + sdf2.format(ahoraEnRoma.getTime()) + " a las " + ahoraEnRoma.get(Calendar.HOUR_OF_DAY));
		System.out.println("Hora actual en Nueva York: " + sdf2.format(ahoraEnNY.getTime()) + " a las " +  ahoraEnNY.get(Calendar.HOUR_OF_DAY));
		
		long milis = ahoraEnNY.getTimeInMillis() - ahoraEnRoma.getTimeInMillis();
		long diferencia = milis/1000/60/60/24;
		
		System.out.println("Diferencia horaria entre ambos: " + diferencia + " dias");
	}
	
}
