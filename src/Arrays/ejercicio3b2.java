package Arrays;
import javax.swing.JOptionPane;
public class ejercicio3b2 {

	public static void main(String[] args) {
		int numeros[] = new int [150], numusuario, resultado;
		
		numusuario = Integer.parseInt(JOptionPane.showInputDialog("Introduce el n�mero por el cual quieres multiplicar el array"));
		
		for (int i = 0; i < numeros.length; i++) {
			
			numeros[i] = ((int) Math.round(Math.random() * 100));
			resultado = (numeros[i] * numusuario);
			
			System.out.println("N�mero " + i + ": " + numeros[i] +
					"\n Multiplicaci�n: " + numeros[i] + " * " + numusuario + " = " + resultado);
			
		}

	}

}
