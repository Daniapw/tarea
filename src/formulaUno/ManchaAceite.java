package formulaUno;

public class ManchaAceite extends Obstaculo {
	
	//Constructor
	public ManchaAceite() {
		
		this.setValor(inicializa());
		this.setTipo("Mancha");
	}
	
	//Método que inicializa el obstáculo
	public int inicializa() {
		
		int numero = ((int) Math.round(Math.random() * (-5 -(-20)))) + (-20);

		return numero;
	}
	
}
