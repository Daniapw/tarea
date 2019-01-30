package arkanoid.version01;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class SpriteCache {
	public static HashMap<String, BufferedImage> sprites;
	public static SpriteCache cache = null;
	
	/**
	 * Constructor
	 */
	
	public SpriteCache() {
		
		super();
		
		//Aqu� se inicia el HashMap
		sprites = new HashMap<String, BufferedImage>();
	}
	
	/**
	 * Singleton
	 * @return
	 */
	public static SpriteCache getSpriteCache() {
		if (cache == null) {
			
			cache = new SpriteCache();
			
		}
		
		return cache;
		
	}
	
	/**
	 * Metodo que carga las imagenes
	 * @param nombre
	 * @return
	 */
	
	public BufferedImage loadImage(String nombre) {
		URL url=null;
		try {
			url = getClass().getResource(nombre);
			return ImageIO.read(url);
		} catch (Exception e) {
			System.out.println("No se pudo cargar la imagen " + nombre +" de "+url);
			System.out.println("El error fue : "+e.getClass().getName()+" "+e.getMessage());
			System.exit(0);
			return null;
		}
	}
	
	
	/**
	 * Metodo que coge los sprites del HashMap y, si no estan, los anade
	 * @param nombre
	 * @return
	 */
	
	public BufferedImage getSprite(String nombre) {
		
		BufferedImage img = (BufferedImage)sprites.get(nombre);
		if (img == null) {
			img = loadImage("recursos/"+nombre);
			sprites.put(nombre,img);
		}
		return img;
	}
}
