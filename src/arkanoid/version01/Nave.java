package arkanoid.version01;


import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Nave extends Actor {
	
	private int vX = 6;
	private boolean derecha, izda;
	
	/**
	 * 
	 * @param posX
	 * @param posY
	 * @param vX
	 * @param vY
	 */
	//Constructor
	public Nave(int posX, int posY) {
		super(posX, posY);

	}
	
	/**
	 * 
	 */
	//Metodo que ejecutara el actor cuando se pulsa o suelta una tecla
	public void actua(int borde) {
		
		//Posicion en el eje X de la nave
		int posicion = this.getPosX();

		/*Si el jugador esta pulsando la flecha derecha y el borde derecho de la nave (posicion + 90) no esta en una posicion superior
		al ancho de ancho de la ventana, la velocidad de la nave (vX) se sumara a la posicion actual*/
		if (derecha && (posicion + 90) < borde) {
			
			posicion += vX;
			
			this.setPosX(posicion);
			
		}
		/*Si el jugador esta pulsando la flecha izda y el borde izquierdo de la nave no esta en una posicion
		 * inferior a 0, la velocidad de la nave (vX) se restara la posicion actual */
		if (izda && this.getPosX() > 0) {
			
			posicion -= vX;
			
			this.setPosX(posicion);
			
		}
		
	}

	/**
	 * 
	 * @param e
	 */
	//Metodo que verificara que tecla se esta pulsando
	public void teclaPulsada(KeyEvent e) {
		
		switch (e.getKeyCode()) {
			
			// Si la tecla pulsada es la flecha derecha, el boolean derecha se cambiara a true  
			 case KeyEvent.VK_RIGHT:{
				
				derecha = true;
				break;
			}
			
			 // Si la tecla pulsada es la flecha izquierda, el boolean izquierda se cambiara a true
			case KeyEvent.VK_LEFT:{
				
				izda = true;
				break;
			}
		
		}
		
		//Por ultimo, se ejecutara el metodo actua pasandole el ancho de la ventana del juego
		this.actua(Arkanoid.ANCHO);
	}
	
	/**
	 * 
	 * @param e
	 */
	//Metodo que comprobara si se ha soltado una tecla
	public void teclaSoltada(KeyEvent e) {
		
		switch (e.getKeyCode()) {
			//Si se ha soltado la flecha derecha, el boolean derecha se cambiara a false
			case KeyEvent.VK_RIGHT:{
				
				derecha = false;
				break;
			}
			
			//Si se ha soltado la flecha izquierda, el boolean izda se cambiara a false
			case KeyEvent.VK_LEFT:{
				
				izda = false;
				break;
			}
	
		}
		
		//Por ultimo, se ejecutara el metodo actua pasandole el ancho de la ventana del juego
		this.actua(Arkanoid.ANCHO);
		
	}
	/**
	 * 
	 * @param e
	 */
	//Metodo que controla el movimiento de la nave con el raton
	public void controlRaton(MouseEvent e) {
		
		int posicionRaton = e.getX();
		
		/*Si la posicion del raton es superior o igual al ANCHO (de la ventana) - 45 (la mitad del ancho de la nave),
		 * la nave se quedará en ANCHO - 90. */
		
		if (posicionRaton >= Arkanoid.ANCHO - 45) {
			
			this.setPosX(Arkanoid.ANCHO - 90);
			
		}

		/*Si la posicion del raton es inferior o igual a 45 (la mitad del ancho de la nave),
		 * la nave se quedara en la posicion 0*/
		if (posicionRaton <= 45) {
			
			this.setPosX(0);
			
		}

		//Si la nave esta entre 45 y ANCHO-45, el punto medio de la nave se pondra en la posicion del raton
		if (posicionRaton > 45 && posicionRaton < (Arkanoid.ANCHO - 45)) {
			
			this.setPosX(posicionRaton - 45);
			
		}

	}
	/**
	 * 
	 * @return
	 */
	//Getters y setters
	public int getvX() {
		return vX;
	}

	public void setvX(int vX) {
		this.vX = vX;
	}

	
	
	
}
