package practicaExamenMvC;

public class Spiderman extends Personaje{

	/**
	 * Constructor Spiderman
	 */
	public Spiderman() {
		
		super();
		this.nombre = "Spiderman";
		this.id = 02;
		this.fuerza = 8;
		this.vida = 100;

	}
	
	/**
	 * Metodo atacar
	 */
	public void atacar(Personaje rival) {
		
		
		//Numero aleatorio que se generara aleatoriamente
		double numAleatorio = 0;
		
		//Bucle que se repite 3 veces
		for (int i = 0; i < 3; i++) {
			
			//El ataque comienza como null
			Ataque ataque = null;
			
			//El numero aleatorio se genera
			numAleatorio = Math.random();
			
			//Dependiendo del numero que salga se hara un ataque u otro
			if (numAleatorio < 0.25) {
				
				ataque = new Punetazo(this.fuerza, "directo de derecha!");
				
				this.ataques.add(ataque);
				
			}
			
			if (numAleatorio > 0.25 && numAleatorio < 0.5) {
				
				ataque = new Patada(this.fuerza, "patada acrobatica!");
				
				this.ataques.add(ataque);
				
			}
			
			if (numAleatorio > 0.5 && numAleatorio < 0.75) {
				
				ataque = new MovEspecial(this.fuerza, "Web Swing!");
				
				this.ataques.add(ataque);
				
			}
			
			//Sin el numero es mayor que 0.8 el oponente esquiva el ataque
			if (numAleatorio > 0.75) {
				
				System.out.println(rival.nombre + " esquiva el ataque de " + this.nombre);
				
			}
			//Si no es mayor que 0.8 el ataque ha tenido exito
			else {
				
				System.out.println(this.nombre + " ataca a " + rival.nombre + " con " + ataque.nombre + "! " + rival.nombre + " pierde " + ataque.potencia + " de vida");
				rival.vida-=ataque.potencia;
				
			}
			
			
		}
		
		//Limpiar lista
		this.ataques.clear();
		
	}
	
}
