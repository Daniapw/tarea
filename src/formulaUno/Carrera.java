package formulaUno;

import javax.swing.JOptionPane;

public class Carrera {
	public Vehiculo participantes[] = new Vehiculo[5];
	public Pista pistas[] = new Pista[5];
	public Vehiculo clasificacion[] = new Vehiculo[] {null,null,null};
	public String nombres[] = new String[] {"Fernando Alonso", "Dani Pedrosa", "Lewis Hamilton", "Marc Márquez", "Kimi Raikkonen"};
	public String colores[] = new String[] {"#2073f9" , "#f92044", "#0ed15f", "#d1830e", "#9900e5"};
	
	//Constructor
	public Carrera () {
		int posicionY = 55;
		//Crear participantes y pistas, asignándole cada pista a un participante
		for (int i = 0; i < 5; i++) {
			
			if (i % 2 == 0) {
				
				participantes[i] = new Coche(nombres[i], posicionY, colores[i]);
				
			}
			else {
				
				participantes[i] = new Moto(nombres[i], posicionY, colores[i]);
				
			}
			
			pistas[i] = new Pista(i + 1);
			
			participantes[i].setPista(i + 1);
			
			posicionY += 120;
			
			
		}
		
	}
	
	//Bucle principal del juego. Se repetir� hasta que el m�todo carreraTerminada devuelva true
	public void bucleJuego() {
		
		//Primero se asignan los turnos a los jugadores
		asignarTurnos();
		
		//Se crea la ventana donde se va a ver el juego y se le a�ade el objeto carrera
		VentanaCarrera ventana = new VentanaCarrera(this);
		
		//Se pinta la ventana con las posiciones de inicio
		ventana.repaint();
		
		JOptionPane.showMessageDialog(null, "Comienza la carrera!");
		//Este es el bucle que llevar� a cabo la carrera
		do {
			
			//Bucle para los turnos
			for (int i = 0; i < participantes.length; i++) {
				
				//Se recorre el array de participantes y, cuando el turno de un participante coincide con i, �ste ejecutar� su turno
				for (int j = 0; j < participantes.length; j++) {
					
					ventana.repaint();
					
					//Si el participante no ha terminado llevar� a cabo su turno
					if (!participantes[j].haTerminado() && participantes[j].getTurno() == i) {
						
						//El participante ejecuta su turno
						//Primero se muestra un mensaje que muestra la distancia que avanza el veh�culo
						JOptionPane.showMessageDialog(null, participantes[j].getPiloto() + " avanza "+ participantes[j].avanza() + " metros");
						
						pistas[participantes[j].getPista() - 1].determinacionObstaculos(participantes[j], ventana);
	
						//Mensaje para mostrar la posici�n en la que se ha quedado el participante
						JOptionPane.showMessageDialog(null, participantes[j].toString());
						
						//Si el participante termina se le clasifica en el p�dium
						if (participantes[j].haTerminado()) {
							
							clasificarEnPodium(participantes[j]);
							
							JOptionPane.showMessageDialog(null, participantes[j].getPiloto() + " ha llegado a la meta!");
							
						}
						

					}
				}
			}
			

			
		}while(!carreraTerminada(participantes));
		
		//Cuando la carrera termina se crea una ventana que muestra a los ganadores de la carrera
		VentanaPodium podium = new VentanaPodium(this.clasificacion);
		podium.repaint();
		
	}
	
	//Asignar turnos al azar a cada participante
	private void asignarTurnos(){
		int azar = 0;
		
		for (int i = 0; i < 5; ) {
			//El auxiliar guarda el participante
			azar = ((int) Math.round(Math.random() * 4));
			
			if (participantes[azar].getTurno() == -1) {
			
				participantes[azar].setTurno(i);
				
				i++;
				
			}
		}
		
	}
	
	
	//M�todo que determina si la carrera ha terminado o no
	private boolean carreraTerminada(Vehiculo participantes[]){
		boolean carreraTerminada = true;
		
		for (int i = 0; i < 5; i++) {
			
			if (!participantes[i].haTerminado()) {
				
				carreraTerminada = false;
				
			}
			
		}
		
		return carreraTerminada;
	}
	
	
	//M�todo para ir clasificando a los jugadores seg�n acaban
	private void clasificarEnPodium(Vehiculo participante) {
		
		for (int j = 0; j < clasificacion.length; j++) {
			
			//Si el puesto no est� ocupado se le asignar� al participante
			if (clasificacion[j] == null && participante.getPodium() == -1){
				
				participante.setPodium(j + 1);
				
				clasificacion[j] = participante;
			}
			
			
		}
	
		
	}

	
	//Getters y setters
	
	public Pista[] getPistas() {
		return pistas;
	}

	public void setPistas(Pista[] pistas) {
		this.pistas = pistas;
	}
	

	
	
}
