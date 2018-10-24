package ExamenProgramacion1;

import javax.swing.JOptionPane;

public class ejercicio1 {

	public static void main(String[] args) {
		int opcion, num1, num2, resultado;
		
		do {
			opcion = Integer.parseInt(JOptionPane.showInputDialog("Elige una opción:" +
					 "\n1-. Calcular área de un triángulo rectángulo." +
					 "\n2-. Perímetro de una circunferencia." +
					 "\n3-. Generar números al azar entre 0 y 100 hasta que salga 47." +
					 "\n0-. Salir. "));
			
			if (opcion < 0 || opcion > 3) {
				JOptionPane.showMessageDialog(null, "Por favor, introduce una opción válida.");
			}
	
			switch (opcion) {
			
				case 0:{
					break;
				}
				
				case 1:{
					num1 = Integer.parseInt(JOptionPane.showInputDialog("Introduce la base del triángulo:"));
					num2 = Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura del triángulo:"));
					resultado = (num1 * num2)/2;
					
					JOptionPane.showMessageDialog(null, "El área del triángulo es " + resultado);
					break;
				}
				
				case 2:{
					num1 = Integer.parseInt(JOptionPane.showInputDialog("Introduce el radio de la circunferencia:"));
					resultado = (int) ( Math.PI * (Math.pow(num1, 2)));
					
					JOptionPane.showMessageDialog(null, "El perímetro de la circunferencia es " + resultado);
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
		} while (opcion > 0 || opcion < 3);
		
	}

}
