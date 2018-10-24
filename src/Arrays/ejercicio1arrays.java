package Arrays;
import javax.swing.JOptionPane;
public class ejercicio1arrays {

	public static void main(String[] args) {
		
		int numeros[] = new int [150];
		int limiteinf, limitesup;
		
		limiteinf = Integer.parseInt(JOptionPane.showInputDialog("Introduce el límite inferior"));
		limitesup = Integer.parseInt(JOptionPane.showInputDialog("Introduce el límite superior"));
		

		
		for (int i = 0; i < numeros.length; i++) {
			
			numeros[i] = ((int) Math.round(Math.random() * (limitesup - limiteinf))) + limiteinf;
		}	
			
		for (int i = 0; i < numeros.length; i++) {
			
			System.out.println("Número " + i + ": " + numeros[i]);
		}

		
	}

}
