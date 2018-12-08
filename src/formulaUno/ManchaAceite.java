package formulaUno;

public class ManchaAceite extends Obstaculo {
	
	public int inicializa() {
		int numero = ((int) Math.round(Math.random() * (50 -100))) + 50;
		
		return numero;
	}
	
}
