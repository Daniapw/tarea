package formulaUno;

public class ManchaAceite extends Obstaculo {
	
	//Constructor
	public ManchaAceite() {
		
		this.setValor(inicializa());
		this.setTipo("Mancha");
	}
	
	//M�todo que inicializa el obst�culo
	public int inicializa() {
		
		int numero = ((int) Math.round(Math.random() * (-5 -(-20)))) + (-20);

		return numero;
	}
	
}
