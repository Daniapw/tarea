package tutorialjava.capitulo1;
import javax.swing.JOptionPane;
public class Ejerciciouno {
	
	public static void ejercicio1() {
		String num = JOptionPane.showInputDialog("Introduce un n�mero entero:");
		int entero = Integer.parseInt(num);
		
		num = JOptionPane.showInputDialog("Introduce un n�mero float:");
		float flotante = Float.parseFloat(num);
		
		num = JOptionPane.showInputDialog("Introduce un n�mero double");
		double doble = Double.parseDouble(num);
							
		System.out.println("El valor de la variable entero es " + entero + 
				", el de la variable flotante es " + flotante + 
				", y el de la variable doble es " + doble);
	}

}
