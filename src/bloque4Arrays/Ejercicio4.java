package bloque4Arrays;

public class Ejercicio4 {
	public static int matriz[][] = new int[5][5];
	
	public static void main(String[] args) {
		
		rellenarAlAzar();

		imprimeMatriz();

		comprobarDispersa();
	}
	/**
	 * 
	 */
	//Método que rellena la matriz con números al azar entre -10 y 100
	public static void rellenarAlAzar() {
		int diagonal = 0;
		
		for (int i = 0; i < matriz.length; i++) {
			
			for (int j = 0; j < matriz[0].length; j++) {
				
					matriz[i][j] = 1;
					
				
			}
			
			diagonal++;
			
		}
		
	}
	
	/**
	 * 
	 */
	//Método que recorre la matriz y la imprime
	public static void imprimeMatriz() {
		
		for (int i = 0; i < matriz.length; i++) {
			
			for (int j = 0; j < matriz[0].length; j++) {
				
				System.out.print(matriz[i][j] + "\t");
				
			
			}
			
			System.out.println();
		}
		
	}
	
	/**
	 * 
	 */
	//Método que comprueba si la matriz es positiva
	public static void comprobarPositiva() {
		
		boolean positiva = true;
		
		//Recorre la matriz y, si encuentra un número negativo, cambia el boolean positiva a false
		for (int i = 0; i < matriz.length; i++) {
			
			for (int j = 0; j < matriz[0].length; j++) {
				
				if (matriz[i][j] < 0) {
					
					positiva = false;
					
				}
				
			}
			
		}
		
		//Dependiendo del estado de positiva saldrá un resultado u otro
		if (positiva == false) {
			
			System.out.println("La matriz no es positiva.");
		
		}
		else {
		
			System.out.println("La matriz es positiva");
		
		}
	}
	
	/**
	 * 
	 */
	//Método que comprueba si la matriz es diagonal
	public static void comprobarDiagonal() {
		int diagonal=0;
		boolean esDiagonal = true;
		
		for (int i = 0; i < matriz.length; i++) {
			
			for (int j = 0; j < matriz[0].length; j++) {
				
				if (matriz[i][j] != 0 && j != diagonal || matriz[i][diagonal] == 0) {
					
					esDiagonal = false;
					
				}
				
			}
			
			diagonal++;
			
		}
		
		if (esDiagonal == false) {
			
			System.out.println("La matriz no es diagonal");
			
		}
		else {
			
			System.out.println("La matriz es diagonal");
			
		}
	}
	
	/**
	 * 
	 */
	//Método que comprueba si la matriz es triangular superior
	public static void comprobarTriangularSuperior() {
		
		int diagonal=0;
		boolean triangularSuperior = true;
		
		
		for (int i = 0; i < matriz.length; i++) {
			
			//j solo llegará hasta el valor anterior a [i][diagonal], es decir, los números que quedan debajo de la diagonal principal
			for (int j = 0; j < diagonal; j++) {
				
				//Si alguno de los valores anteriores a diagonal no es nulo el boolean se establecerá a falso
				if (matriz[i][j] != 0 && i >= 1) {
					
					triangularSuperior = false;
					
				}
				
			}
			//Al final de cada iteración se le sumará 1 a diagonal
			diagonal++;
			
		}
		
		//Dependiendo del estado de triangularSuperior se imprimirá un mensaje u otro
		if (triangularSuperior == true) {
			
			System.out.println("La matriz es triangular superior");
			
		}
		else {
			
			System.out.println("La matriz no es triangular superior");
			
		}
	}
	/**
	 * 
	 */
	public static void comprobarDispersa() {
		
		//Boolean que indicará si la fila es dispersa
		boolean filaDispersa = false;
		
		//Bucle para comprobar las filas
		for (int i = 0; i < matriz.length; i++) {
			
			//El boolean se reinicia en cada fila
			filaDispersa = false;
			
			for (int j = 0; j < matriz[0].length; j++) {
				
				//Si un valor de la columna es nulo, el boolean se cambiará a true
				if (matriz[i][j] == 0) {
					
					filaDispersa = true;
					
				}
				
			}
			
			/*Si ningún elemento de la fila es nulo la matriz no es dispersa, por lo que
			se imprimirá un mensaje y terminará la ejecución del método*/
			if (filaDispersa == false) {
				
				System.out.println("La matriz no es dispersa");

				
			}
			
		}
		
		//Boolean que indicará si la fila es dispersa
		boolean columnaDispersa = false;
		
		
		int i = 0, j = 0;
		
		//Bucle para comprobar las filas
		for (i = 0; i < matriz.length; i++) {
			
			//El boolean se reinicia en cada columna
			columnaDispersa = false;
			
			for (j = 0; j < matriz[0].length; j++) {
				
				//Si un valor de la columna es nulo, el boolean se cambiará a true
				if (matriz[j][i] == 0) {
					
					columnaDispersa = true;
					
				}
				
			}
			
			/*Si ningún elemento de la columna es nulo la matriz no es dispersa, por lo que
			se imprimirá un mensaje y terminará la ejecución del método*/
			if (columnaDispersa == false) {
				
				System.out.println("La matriz no es dispersa");

				
			}
			
		}
		
	}
}
