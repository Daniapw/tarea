package arkanoid.version01;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Explosion extends Actor{

	protected BufferedImage spritesExpl[] = new BufferedImage[12];
	protected int t = 0;
	protected int frameActual;
	
	/**
	 * Constructor
	 * @param x
	 * @param y
	 */
	public Explosion(int x, int y) {
		super(x,y);
		
		for (int i = 0; i < spritesExpl.length; i++) {
			
			spritesExpl[i] = SpriteCache.getSpriteCache().getSprite("Ex" + (i + 1) + ".png");
			
		}
		
	}
	
	/**
	 * Metodo paint
	 */
	public void paint(Graphics g) {
		
		//Se dibuja el sprite actual
		g.drawImage(spritesExpl[frameActual], posX, posY, null);
		
		
	}
	
	/**
	 * Metodo actua
	 */
	public void actua() {
		
		t++;
		
		if (t % 4 == 0) {
			
			frameActual = (frameActual + 1) % spritesExpl.length; 
			
			//Cuando llega al ultimo frame se activara la flag borrar de este actor para que desaparezca al terminar su animacion
			if (frameActual == spritesExpl.length -1) {
				
				this.setBorrar(true);
				
			}
			
		}
		
	}
}
