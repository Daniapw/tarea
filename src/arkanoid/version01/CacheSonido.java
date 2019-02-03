package arkanoid.version01;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import java.util.HashMap;

public class CacheSonido {

	public static HashMap<String, AudioClip> sonidos;
	public static CacheSonido cacheSonido = null;
	
	/**
	 * Constructor
	 */
	
	public CacheSonido() {
		super();
		sonidos = new HashMap<String, AudioClip>();
		
	}
	
	/**
	 * Singleton
	 * @return
	 */
	
	public static CacheSonido getCacheSonido() {
		
		if (cacheSonido == null) {
			
			cacheSonido = new CacheSonido();
			
		}
		
		return cacheSonido;
		
	}
	
	/**
	 * Metodo que carga los sonidos
	 * @param nombre
	 * @return
	 */
	
	public AudioClip loadClip(String nombre) {
		URL url=null;
		try {
			url = getClass().getResource(nombre);
			return Applet.newAudioClip(url);
		} catch (Exception e) {
			System.out.println("No se pudo cargar el sonido " + nombre +" de "+url);
			System.out.println("El error fue : "+e.getClass().getName()+" "+e.getMessage());
			System.exit(0);
			return null;
		}
	}
	
	/**
	 * Metodo que coge los sonidos del HashMap y, si no estan, los anade
	 * @param nombre
	 * @return
	 */
	
	public AudioClip getSonido(String nombre) {
		
		AudioClip sonido = (AudioClip) sonidos.get(nombre);
		if (sonido == null) {
			sonido = loadClip("recursos/"+nombre);
			sonidos.put(nombre, sonido);
		}
		return sonido;
	}
	
	/**
	 * Metodo para reproducir un sonido
	 * @param nombre
	 */
	
	public void reproducirSonido(String nombre) {
		
		getSonido(nombre).play();
		
	}
	
	/**
	 * Metodo para reproducir un sonido en bucle
	 * @param nombre
	 */
	
	public void reproducirSonidoBucle(String nombre) {
		
		getSonido(nombre).loop();
		
	}
}
