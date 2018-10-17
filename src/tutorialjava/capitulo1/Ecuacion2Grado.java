package tutorialjava.capitulo1;

public class Ecuacion2Grado {
	
	/* Esta es la función reoluciónEcuaciónSegundoGrado, que
	 * resuelve la ecuación de segundo grado
	 */
	public static void ecuacionsegundogrado() {
		
			int a = 1, b = 0, c = -1;
			float x1, x2;
			float determinante;
			
			determinante = (float) Math.sqrt(b*b - 4*a*c);
			x1 = ((0 - b) + determinante) / (2 * a);
			x2 = ((0 - b) - determinante) / (2 * a);
			
			System.out.println("La ecuación es " + a + "x(2) + " + b + "x +" + c + "=0");
			System.out.println("La solución x1 es " + x1 + " y la solución x2 es " + x2);
		

	}

}
