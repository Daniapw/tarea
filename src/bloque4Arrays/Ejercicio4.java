package bloque4Arrays;

public class Ejercicio4 {
	//Matriz principal
	public static int matriz[][] = new int[5][5];
	
	//Matriz traspuesta:
	public static int matrizTraspuesta[][] = new int[5][5];	
	
	public static void main(String[] args) {
		
		rellenarAlAzar();
		
		construirArray();
		
	}
	/**
	 * 
	 */
	//Método que rellena la matriz con números al azar entre -10 y 100
	public static void rellenarAlAzar() {
		int diagonal = 0;
		int contador= 0;
		for (int i = 0; i < matriz.length; i++) {
			
			for (int j = 0; j < matriz[0].length; j++) {
				
					matriz[i][j] = contador;
					
					contador++;
				
			}
			
			diagonal++;
			
		}

	}
	
	/**
	 * 
	 */
	//Método que recorre la matriz y la imprime
	public static void imprimeMatriz(int[][] matriz) {
		
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
		boolean columnaDispersa = false;
		
		//Bucle para comprobar las filas
		for (int i = 0; i < matriz.length; i++) {
			
			//El boolean filaDispersa se reinicia en cada fila
			filaDispersa = false;
			
			for (int j = 0; j < matriz[0].length; j++) {
				
				//El boolean columnaDispersa se reinicia en cada columna
				columnaDispersa = false;
				
				//Si un valor de la fila es nulo, el boolean se cambiará a true
				if (matriz[i][j] == 0) {
					
					filaDispersa = true;
					
				}
				
				//Si un valor de la columna es nulo, el boolean se cambiará a true
				if (matriz[j][i] == 0) {
					
					columnaDispersa = true;
					
				}
			}
			
			/*Si ningún elemento de la fila/columna es nulo la matriz no es dispersa, por lo que
			se imprimirá un mensaje y terminará la ejecución del método*/
			if (filaDispersa == false || columnaDispersa == false) {
				
				System.out.println("La matriz no es dispersa");
				
				return;
				
			}
			
		}
		
		//Si el m�todo sale del bucle significa que la matriz es dispersa, por lo que se imprimir� este mensaje
		System.out.println("La matriz es dispersa");
		
	}
	
	/**
	 * 
	 */
	//M�todo que convierte la matriz en un array unidimensional
	public static void construirArray() {
		
		int array[] = new int[25];
		int contadorIteracion = 0;
		
		for (int i = 0; i < matriz.length; i++) {
			/*La variable contadorIteracion aumentará en 1 cada iteración,
			por lo que se usará como índice del array*/
			for (int j = 0; j < matriz[0].length; j++) {
				
				array[contadorIteracion] = matriz[i][j];
				
				System.out.print(array[contadorIteracion] + " ");
				
				contadorIteracion++;
				
				
			}
			
		}
		
	}
	/**
	 * 
	 */
	//M�todo que comprueba si la matriz es sim�trica
	public static void comprobarSimetrica() {

		for (int i = 0; i < matriz.length; i++) {
			
			for (int j = 0; j < matriz[0].length; j++) {
				
				/*Si el valor de las coordenadas [i][j] no es el mismo que el de [j][i] la matriz no es sim�trica, por lo que se
				imprimir� un mensaje y se detendr� la ejecuci�n del m�todo*/
				if (matriz[i][j] != matriz[j][i]) {
					
					System.out.println("La matriz no es sim�trica");
					return;
				
				}
				
			}
			
		}

		//Si la ejecuci�n del m�todo llega a este punto significa que la matriz es sim�trica, por lo que se mostrar� un mensaje dici�ndolo
		System.out.println("La matriz es sim�trica");
		
	}
	
	/**
	 * 
	 */
	//Método para sacar la matriz traspuesta
	public static void matrizTraspuesta() {
		
		for (int i = 0; i < matriz.length; i++) {
			
			/*Se recorre la matrizTraspuesta y se establece que el valor de la columna[j][i] es igual al
			valor de la fila [i][j]*/
			for (int j = 0; j < matriz[0].length; j++) {
				
				matrizTraspuesta[j][i] = matriz[i][j];
				
			}
			
		}
			
	}
	
	public static void matrizOpuesta() {
		
		for (int i = 0; i < matriz.length; i++) {
			
			for (int j = 0; j < matriz[0].length; j++) {
				
				if (matriz[i][j] < 0) {
					
					
					
				}
				
			}
			
		}
		
		
	}
}
