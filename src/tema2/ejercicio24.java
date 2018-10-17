package tema2;

import javax.swing.JOptionPane;

public class ejercicio24 {

	public static void main(String[] args) {
		
		int num, menor;
		String texto="Introduce un número:";
		
		menor = Integer.parseInt(JOptionPane.showInputDialog(texto));
		
		num = Integer.parseInt(JOptionPane.showInputDialog(texto));
		menor = (num > menor)? menor : num;
		
		num = Integer.parseInt(JOptionPane.showInputDialog(texto));
		menor = (num > menor)? menor : num;
		
		num = Integer.parseInt(JOptionPane.showInputDialog(texto));
		menor = (num > menor)? menor : num;
		
		num = Integer.parseInt(JOptionPane.showInputDialog(texto));
		menor = (num > menor)? menor : num;
		
		JOptionPane.showMessageDialog(null, "El número más pequeño es: " + menor);
	}
}


