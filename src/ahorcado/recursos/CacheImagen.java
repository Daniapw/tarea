package ahorcado.recursos;

import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

public class CacheImagen {
	
	private static CacheImagen cache=null;
	
	private BufferedImage imagenFondo = null;
	private BufferedImage fondoNavidad = null;
	
	
	public CacheImagen () {
		super();
	}
	
	
	public static CacheImagen getCache() {
		if (cache==null) {
			cache = new CacheImagen();
		}
		return cache;
	}
	
	
	public BufferedImage getImagen(String nombre) {
		URL url=null;
		try {
			url = getClass().getResource("/ahorcado/recursos/" + nombre);
			return ImageIO.read(url);
		} catch (Exception e) {
			System.out.println("No se pudo cargar la imagen " + nombre +" de "+url);
			System.out.println("El error fue : "+e.getClass().getName()+" "+e.getMessage());
			System.exit(0);
			return null;
		}
	}
	
	//Fondo normal
	public BufferedImage getFondo() {
		if (imagenFondo == null) {
			imagenFondo = getCache().getImagen("western.jpg");
		}
		
		return imagenFondo;
	}
	
	//Fondo navideño
	public BufferedImage getFondoNavidad() {
		if (fondoNavidad == null) {
			fondoNavidad = getCache().getImagen("navidad.jpg");
		}
		
		return fondoNavidad;
	}
}
