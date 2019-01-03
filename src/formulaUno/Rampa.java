package formulaUno;

public class Rampa extends Obstaculo {
	
	//Constructor
	public Rampa() {
		
		this.setValor(inicializa());
		this.setTipo("Rampa");

	}
	
	//Método que inicializa el obstáculo
	public int inicializa() {
		
		int numero = ((int) Math.round(Math.random() * (100 - 50))) + 50;
	
		return numero;
	}
	
	
}
