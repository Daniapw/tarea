package tema4;

import javax.swing.JOptionPane;

public class Ejercicio2 {
	public int limiteinf, limitesup, numero;
	
	public void main(String[] args) {
		limiteinf = Integer.parseInt(JOptionPane.showInputDialog("Introduce el l�mite inferior:"));
		limitesup = Integer.parseInt(JOptionPane.showInputDialog("Introduce el l�mite superior:"));
		
		pedirvalores(limiteinf, limitesup);
	}

	public void pedirvalores (int limiteinf, int limitesup) {
		
		do {
			numero = Integer.parseInt(JOptionPane.showInputDialog("Introduce un n�mero entre " + limiteinf + " y " + limitesup ));
		}while(numero > limitesup || numero < limiteinf);
		
	}
}
