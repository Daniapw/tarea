package ejerciciosTema6.bloque4Excepciones.ejercicio1;

import java.util.Scanner;

public class PedirNumeroPar {

	public static int pedirNumeroPar() throws NumeroImparException {
		
		Scanner sc = new Scanner(System.in);
		
		int numUsuario = sc.nextInt();
		
		if (numUsuario % 2 == 1) {
			
			throw new NumeroImparException();
			
		}
		
		return numUsuario;
	}
	
	public static void main(String[] args) {
		
		System.out.println("Introduzca numero: ");
	
		try{
			
			int num = pedirNumeroPar();
			System.out.println(num);
			
		}
		catch(NumeroImparException ex) {
			
			System.out.println("Numero impar introducido");
			
		}
		
		

	}

}
