package tema3.bloque3;
import javax.swing.JOptionPane;
public class Paresonones {

	public static void main(String[] args) {
		int manoizdjugador, manodrchajugador, totaljugador, num;
		double manoizdmaquina, manodrchamaquina, totalmaquina, resultado;
		
		do {
			num = Integer.parseInt(JOptionPane.showInputDialog("¿Pares o nones (2 para pares; 1 para nones)?"));
		} while (num !=1 && num != 2);
			
		if (num == 1) {
			JOptionPane.showMessageDialog(null, "Has elegido nones.");
		}
		else {
			JOptionPane.showMessageDialog(null, "Has elegido pares.");
		}
		
		
		
		manoizdjugador = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos dedos de la mano izquierda vas a levantar?"));
		manodrchajugador = Integer.parseInt(JOptionPane.showInputDialog("¿Y de la mano derecha?"));
										
		while (manoizdjugador > 5 || manoizdjugador < 0 || manodrchajugador > 5 || manodrchajugador < 0) {
			JOptionPane.showMessageDialog(null, "¡No puedes sacar más de 5 dedos en una mano, y tampoco menos de 0!");
			manoizdjugador = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos dedos de la mano izquierda vas a levantar?"));
			manodrchajugador = Integer.parseInt(JOptionPane.showInputDialog("¿Y de la mano derecha?"));
		}
		
		totaljugador = manoizdjugador + manodrchajugador;
		
		do {
			manoizdmaquina = (int) (Math.random() * 10);
			manodrchamaquina =  (int) (Math.random() * 10);
		
		} while ((manoizdmaquina + manodrchamaquina) > 10);
		
		
		totalmaquina = manoizdmaquina + manodrchamaquina;
		
		JOptionPane.showMessageDialog(null, "La máquina ha sacado " + totalmaquina + " dedos.");
		
		resultado = (totaljugador + totalmaquina) % 2;
		
		JOptionPane.showMessageDialog(null, "Total: " + (totaljugador + totalmaquina));
		
		if (num == 1 && resultado != 0) {
			JOptionPane.showMessageDialog(null, "¡Enhorabuena, has ganado!");
		}
		else {
			if (num == 1 && resultado == 0) {
				JOptionPane.showMessageDialog(null, "Lo siento, has perdido.");
			}
			else {
				if (num == 2 && resultado == 0) {
					JOptionPane.showMessageDialog(null, "¡Enhorabuena, has ganado!");
				}
				else {
					if (num == 2 && resultado != 0) {
						JOptionPane.showMessageDialog(null, "Lo siento, has perdido.");
					}
				}
			}
		}
	}

}
