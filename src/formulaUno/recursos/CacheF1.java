package formulaUno.recursos;

import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

public class CacheF1 {
	
	private static CacheF1 cache=null;
	
	private BufferedImage imagenPodium = null;
	
	
	public CacheF1 () {
		super();
	}
	
	
	public static CacheF1 getCache() {
		if (cache==null) {
			cache = new CacheF1();
		}
		return cache;
	}
	
	
	public BufferedImage getImagen(String nombre) {
		URL url=null;
		try {
			url = getClass().getResource("/formulaUno/recursos/" + nombre);
			return ImageIO.read(url);
		} catch (Exception e) {
			System.out.println("No se pudo cargar la imagen " + nombre +" de "+url);
			System.out.println("El error fue : "+e.getClass().getName()+" "+e.getMessage());
			System.exit(0);
			return null;
		}
	}
	
	//Imagen Podium
	public BufferedImage getPodium() {
		if (imagenPodium == null) {
			imagenPodium = getCache().getImagen("podium.jpg");
		}
		
		return imagenPodium;
	}
	
}
