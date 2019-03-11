package ejerciciosTema6.bloque2Math;

import javax.swing.JOptionPane;

public class Ejercicio1 {
	protected static float soluciones[] = new float[2];
	protected static float array[] = new float[3];
	protected static float a,b,c;
	protected static String letras[] = new String[] {"a", "b", "c"};
	
	public static void main(String[] args) {
		
		for (int i = 0; i < array.length; i++ ) {
			
			array[i] = Float.parseFloat(JOptionPane.showInputDialog("Introduce el valor de " + letras[i]));
			
		}

		a = array[0];
		b = array[1];
		c = array[2];
		
		soluciones[0] = (float) ((-b + Math.sqrt(Math.pow(b, 2) - 4*a*c))/(2*a));
		soluciones[0] = (float) ((-b - Math.sqrt(Math.pow(b, 2) - 4*a*c))/(2*a));
		
		for (float num:soluciones) System.out.println(num);
	}

}
