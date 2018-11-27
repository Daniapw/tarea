package tema4.ejercicio1;

public class ejercicio1tema4 {
	public static int resultado;
	public int num1, num2, num3;
	public float float1;
	
	public static void main(String[] args) {
		
		System.out.println(media(8,6,4,8));
		
	}
	
	public static int media (int num1, int num2, int num3, float float1) {
		
		resultado = (num1 + num2 + num3 + (int) float1)/4;
		
		return resultado;
	}

}