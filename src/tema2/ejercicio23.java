package tema2;
import javax.swing.JOptionPane;
public class ejercicio23 {
	
	public static void main(String[] args) {
		
		int num, mayor;
		String texto="Introduce un n�mero:";
		
		mayor = Integer.parseInt(JOptionPane.showInputDialog(texto));
		
		num = Integer.parseInt(JOptionPane.showInputDialog(texto));
		mayor = (num > mayor)? num : mayor;
		
		num = Integer.parseInt(JOptionPane.showInputDialog(texto));
		mayor = (num > mayor)? num : mayor;
		
		num = Integer.parseInt(JOptionPane.showInputDialog(texto));
		mayor = (num > mayor)? num : mayor;
		
		num = Integer.parseInt(JOptionPane.showInputDialog(texto));
		mayor = (num > mayor)? num : mayor;
		
		JOptionPane.showMessageDialog(null, "El n�mero m�s grande es: " + mayor);
	}
}
