package arkanoid.version01;

public class ListenerLadrillos implements LadrilloDestruidoListener {

	@Override
	public void ladrilloDestruido(LadrilloDestruidoEvent evento) {
		System.out.println("Se ha destruido un ladrillo en " + evento.ladrillo.posX + "-" + evento.ladrillo.posY);
		evento.ladrillo.setBorrar(true);;
	}

}
