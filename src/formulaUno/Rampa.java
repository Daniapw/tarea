package formulaUno;

public class Rampa extends Obstaculo {
	
	public Rampa() {
		
		this.setValor(inicializa());
		this.setTipo("Rampa");

	}
	
	public int inicializa() {
		
		int numero = ((int) Math.round(Math.random() * (50 -100))) + 50;
		
		return numero;
	}
	
	
}
