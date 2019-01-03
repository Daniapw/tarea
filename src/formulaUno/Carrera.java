package formulaUno;

import javax.swing.JOptionPane;

public class Carrera {
	public Vehiculo participantes[] = new Vehiculo[5];
	public Pista pistas[] = new Pista[5];
	public Vehiculo clasificacion[] = new Vehiculo[] {null,null,null};
	public String nombres[] = new String[] {"Fernando Alonso", "Dani Pedrosa", "Lewis Hamilton", "Marc M·rquez", "Kimi Raikkonen"};
	public String colores[] = new String[] {"#2073f9" , "#f92044", "#0ed15f", "#d1830e", "#9900e5"};
	
	//Constructor
	public Carrera () {
		int posicionY = 55;
		//Crear participantes y pistas, asign√°ndole cada pista a un participante
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
			
			System.out.println("\n" + participantes[i].getPiloto() + " - Pista: " + participantes[i].getPista());
			
		}
		
	}
	
	//Bucle principal del juego. Se repetir· hasta que el mÈtodo carreraTerminada devuelva true
	public void bucleJuego() {
		
		//Primero se asignan los turnos a los jugadores
		asignarTurnos();
		
		//Se crea la ventana donde se va a ver el juego y se le aÒade el objeto carrera
		VentanaCarrera ventana = new VentanaCarrera(this);
		
		//Se pinta la ventana con las posiciones de inicio
		ventana.repaint();
		
		JOptionPane.showMessageDialog(null, "Comienza la carrera!");
		//Este es el bucle que llevar· a cabo la carrera
		do {
			
			//Bucle para los turnos
			for (int i = 0; i < participantes.length; i++) {
				
				ventana.repaint();
				//Si el participante no ha terminado llevar· a cabo su turno
				if (!participantes[i].haTerminado()) {
					
					//El participante ejecuta su turno
					//Primero se muestra un mensaje que muestra la distancia que avanza el vehÌculo
					JOptionPane.showMessageDialog(null, participantes[i].getPiloto() + " avanza "+ participantes[i].avanza() + " metros");
					
					pistas[participantes[i].getPista() - 1].determinacionObstaculos(participantes[i], ventana);

					//Si el participante termina se le clasifica en el pÛdium
					if (participantes[i].haTerminado()) {
						
						clasificarEnPodium(participantes[i]);
						
					}
					
					//Mensaje para mostrar la posiciÛn en la que se ha quedado el participante
					JOptionPane.showMessageDialog(null, participantes[i].toString());
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
		Vehiculo aux = null;
		String colorI, colorAzar;
		
		for (int i = 0; i < 5; ) {
			//El auxiliar guarda el participante
			aux = participantes[i];
			azar = ((int) Math.round(Math.random() * 4));
			
			if (participantes[azar].getTurno() == -1) {
			
				colorI = participantes[i].getColor();
				colorAzar = participantes[azar].getColor();
				
				participantes[azar].setTurno(i);

				participantes[i] = participantes[azar];
			
				participantes[azar] = aux;
				
				i++;
				
			}
		}
		
	}
	
	
	//MÈtodo que determina si la carrera ha terminado o no
	private boolean carreraTerminada(Vehiculo participantes[]){
		boolean carreraTerminada = true;
		
		for (int i = 0; i < 5; i++) {
			
			if (!participantes[i].haTerminado()) {
				
				carreraTerminada = false;
				
			}
			
		}
		
		return carreraTerminada;
	}
	
	
	//MÈtodo para ir clasificando a los jugadores seg˙n acaban
	private void clasificarEnPodium(Vehiculo participante) {
		
		for (int j = 0; j < clasificacion.length; j++) {
			
			//Si el puesto no est· ocupado se le asignar· al participante
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
