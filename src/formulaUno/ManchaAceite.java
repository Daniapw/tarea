package formulaUno;

public class ManchaAceite extends Obstaculo {
	
	public ManchaAceite() {
		
		this.setValor(inicializa());
		this.setTipo("Mancha");
	}
	
	public int inicializa() {
		
		int numero = ((int) Math.round(Math.random() * (-10 -(-50)))) - (-10);
		
		return numero;
	}
	
}
