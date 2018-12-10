package formulaUno;

public class Pista {
	private int numeroPista;
	private int trayecto[] = new int[500];
	
	public Pista(int numero) {
		//Crear array de obstáculos para la pista
		Obstaculo obstaculos[] = new Obstaculo[4];
		
		for (int i = 0; i < trayecto.length; i++) {
			
			trayecto[i] = i;
			
		}
		
		double azar;
		
		//Determinar aleatoramiente si el obstáculo va a ser una rampa o una mancha de aceite y crearlo
		for (int i = 0; i < obstaculos.length; i++) {
			
			azar = Math.random();
			
			if (azar < 0.5) {
				
				obstaculos[i] = new Rampa();

			}
			else {
				
				obstaculos[i] = new ManchaAceite();
				
			}
			
		}
		
		int lugarInicio;
		int lugarFin;
		
		for (int i = 0; i < obstaculos.length; i++) {
			
			lugarInicio = (int)Math.round(Math.random() * (450 - 10) + 10);
			
			lugarFin = lugarInicio + 15;
			
			obstaculos[i].setLugarInicio(lugarInicio);
			obstaculos[i].setLugarFin(lugarFin);
			
			trayecto[lugarInicio] = obstaculos[i].getValor();
			
		}
		
		
		this.numeroPista = numero;
	}
	
	
}
