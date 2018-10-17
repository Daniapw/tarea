package tema3.bloque3;
import javax.swing.JOptionPane;
public class juegomoneda {

	public static void main(String[] args) {
		int tirada, resultado, contadorjugador=0, contadormaquina=0;
		
		do {
		tirada = Integer.parseInt(JOptionPane.showInputDialog("¿0 ó 1?"));
			resultado = (int) Math.round(Math.random());
			
			if (tirada == resultado) {
				JOptionPane.showMessageDialog(null,"Ha salido " + resultado + ", punto para el jugador");
				contadorjugador++;
			}
			else {
				JOptionPane.showMessageDialog(null, "Ha salido " + resultado + ", punto para la máquina");
				contadormaquina++;
			}
			
		} while (contadorjugador < 3 && contadormaquina < 3);
		
		if (contadorjugador > contadormaquina) {
			JOptionPane.showMessageDialog(null, "¡Enhorabuena, has ganado!");
		}
		else {
			JOptionPane.showMessageDialog(null, "Lo siento, ha ganado la máquina");
	
		}
	}

}
