package formulaUno;

import javax.swing.JOptionPane;

public class Pista {
	private int numeroPista;
	public Obstaculo obstaculos[] = new Obstaculo[4];
	public static final int  META = 530;
	
	//Constructor de la pista
	public Pista(int numero) {
		
		double azar;
		
		obstaculos[0] = new Rampa();	
		
		//Determinar aleatoramiente si el obst√°culo va a ser una rampa o una mancha de aceite y crearlo
		for (int i = 1; i < obstaculos.length; i++) {
			
			azar = Math.random();
			
			if (azar < 0.5) {
				
				obstaculos[i] = new Rampa();

			}
			else {
				
				obstaculos[i] = new ManchaAceite();
				
			}
			
		}
		
		//Llamar al mÈtodo para posicionar los obst·culos
		posicionarObstaculos();
		
		
		this.numeroPista = numero;
	}
	
	//MÈtodo para posicionar obst·culos
	private void posicionarObstaculos() {
		
		int lugarInicio;
		int lugarFin;
		int azar;
		
		//Dado que el primer obst·culo siempre va a ser una rampa y siempre va a estar en el mismo lugar,
		//el lugar de inicio se establece manualmente
		obstaculos[0].setLugarInicio(100);
		obstaculos[0].setLugarFin(150);
		
		//Los obst·culos se van posicionando a partir del lugar donde acaba el obst·culo anterior (con un pequeÒo margen para que no aparezcan pegados)
		int j=160;
		
		for (int i=1;i<4;i++){
			
			obstaculos[i].setLugarInicio((int)Math.round(Math.random() * ((j+40) - j + 20)) + (j + 20));
			
		    j=obstaculos[i].getLugarInicio() + 50;
		    obstaculos[i].setLugarFin(j);
		    
		}
		
		

		
	}
		
	
	//MÈtodo para determinar quÈ ha ocurrido en el turno del piloto de esta pista
	public void determinacionObstaculos(Vehiculo participante, VentanaCarrera ventana) {
		
		//Bucle que recorre el array de obst·culos de la pista en cuestiÛn y aplica los cambios a la posiciÛn del participante
		for (int j = 0; j < obstaculos.length; j++) {
			
			//Si una de las ruedas del vehÌculo del  participante cae en el obst·culo se aplicar· su efecto y se imprimir· un mensaje
			if (participante.getPosicion() +5 >= this.obstaculos[j].getLugarInicio() && participante.getPosicion() +5 <= this.obstaculos[j].getLugarFin()|| 
					participante.getPosicion() + 50 >= this.obstaculos[j].getLugarInicio() && participante.getPosicion() +50 <= this.obstaculos[j].getLugarFin()) {
				
				//Si el vehÌculo ha caÌdo en una rampa, la rampa lo mover· hacia delante
				if (this.obstaculos[j] instanceof Rampa) {
					
					JOptionPane.showMessageDialog(null, participante.getPiloto() + " se impulsa con la rampa y avanza "
					+ this.obstaculos[j].getValor() + " metros!");
					
					participante.setPosicion(participante.getPosicion() + (this.obstaculos[j].getValor()));
					
					ventana.repaint();
				}
				
				//Si el vehÌculo ha caÌdo en una mancha se le restar· el valor de la mancha
				else {
					
					JOptionPane.showMessageDialog(null, "El vehÌculo de " + participante.getPiloto() + " resbala con la mancha de aceite, por lo que retrocede "
							+ this.obstaculos[j].getValor() + " metros!" );
					
					participante.setPosicion(participante.getPosicion() + this.obstaculos[j].getValor());
					ventana.repaint();
					
				}
				
				
			}
			
		}
		

	}
	
	
	
	
}
