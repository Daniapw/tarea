package ExamenProgramacion1;

import javax.swing.JOptionPane;

public class ejercicio1 {

	public static void main(String[] args) {
		int opcion, num1, num2, resultado;
		
		do {
			opcion = Integer.parseInt(JOptionPane.showInputDialog("Elige una opci�n:" +
					 "\n1-. Calcular �rea de un tri�ngulo rect�ngulo." +
					 "\n2-. Per�metro de una circunferencia." +
					 "\n3-. Generar n�meros al azar entre 0 y 100 hasta que salga 47." +
					 "\n0-. Salir. "));
			
			if (opcion < 0 || opcion > 3) {
				JOptionPane.showMessageDialog(null, "Por favor, introduce una opci�n v�lida.");
			}
			else {
	
				switch (opcion) {
				
					case 0:{
						break;
					}
					
					case 1:{
						num1 = Integer.parseInt(JOptionPane.showInputDialog("Introduce la base del tri�ngulo:"));
						num2 = Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura del tri�ngulo:"));
						resultado = (num1 * num2)/2;
						
						JOptionPane.showMessageDialog(null, "El �rea del tri�ngulo es " + resultado);
						break;
					}
					
					case 2:{
						num1 = Integer.parseInt(JOptionPane.showInputDialog("Introduce el radio de la circunferencia:"));
						resultado = (int) ( Math.PI * (Math.pow(num1, 2)));
						
						JOptionPane.showMessageDialog(null, "El per�metro de la circunferencia es " + resultado);
						break;
					}
					
					case 3:{
						do {
							num1 = ((int) Math.round(Math.random() * 100));
							JOptionPane.showMessageDialog(null, num1);
						} while (num1 != 47);
						break;
					}
				} 
			}
			
		} while (opcion != 0 );
		
	}

}
