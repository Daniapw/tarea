package bloque4Arrays;

import javax.swing.JOptionPane;

public class Ejercicio4 {
	//Matriz principal
	public static int matriz[][] = new int[5][5];
	
	public static void main(String[] args) {
		
		rellenarAlAzar();
		
		imprimeMatriz(matriz);
		
		System.out.println();
		
		comprobarTriangularSuperior();
		
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
				
				if (i==j) {
					matriz[i][j] = 1;
					
					contador++;
				}
			}
			
			diagonal++;
			
		}

		matriz[2][1] = 1;
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
				
				/*Si un n�mero que NO sea parte de la diagonal no es 0 o si un n�mero de la diagonal es 0 la matriz no es diagonal,
				por lo que el boolean se cambia a false*/
				if (matriz[i][j] != 0 && j != diagonal || matriz[i][diagonal] == 0) {
					
					esDiagonal = false;
					
				}
				
			}
			//La diagonal estar� un espacio m�s a la derecha en cada fila
			diagonal++;
			
		}
		
		//Dependiendo del estado del boolean se imprime un mensaje u otro
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
		
		int array[] = new int[matriz.length * matriz[0].length];
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
		int matrizTraspuesta[][] = new int[5][5];
		
		for (int i = 0; i < matriz.length; i++) {
			
			/*Se recorre la matrizTraspuesta y se establece que el valor de la columna[j][i] es igual al
			valor de la fila [i][j] de la matriz original*/
			for (int j = 0; j < matriz[0].length; j++) {
				
				matrizTraspuesta[j][i] = matriz[i][j];
				
			}
			
		}
			
	}
	/**
	 * 
	 */
	//M�todo para obtener la matriz opuesta
	public static void matrizOpuesta() {
		
		for (int i = 0; i < matriz.length; i++) {
			
			for (int j = 0; j < matriz[0].length; j++) {
				
				//Si matriz[i][j] es menor que 0 se le sumar� su valor absoluto del n�mero * 2 (el doble del n�mero)
				if (matriz[i][j] < 0) {
					
					matriz[i][j] += (Math.abs(matriz[i][j])*2);
					
				}
				//Si, por el contrario, matriz[i][j] es mayor que 0 se har� lo contrario: se le restar� su valor absoluto * 2
				else {
				
					matriz[i][j] -= (Math.abs(matriz[i][j]*2));
					
				}
				
			}
			
		}
		
	}
	/**
	 * 
	 */
	//M�todo que permite al usuario borrar una matriz
	public static void borrarFila() {
		
		int numeroFila;
		
		//Primero se le pide al usuario el n�mero de fila que quiere borrar 
		do {
		
			numeroFila = Integer.parseInt(JOptionPane.showInputDialog("Escribe el n�mero de la fila que quieres borrar (entre 0 y 4)"));
			
		}while (numeroFila < 0 || numeroFila > 4);
		
		//Esta es la matriz que se rellenar� sin la fila que ha especificado el usuario
		int matrizSinFila[][] = new int[4][5];
		
		//El bucle se repetir� 4 veces, la longitud de matrizSinFila
		for (int i = 0; i < matrizSinFila.length; i++) {
			
			for (int j = 0; j < matriz[0].length; j++) {
				
				//Las filas anteriores a la que se va a borrar se rellenan normalmente...
				if (i < numeroFila) {
					
					matrizSinFila[i][j] = matriz[i][j];
					
				}
				//...pero a partir de esa fila inclusive se copiar� la fila i+1 de la matriz original, es decir, nos saltamos una
				else {
					
					matrizSinFila[i][j] = matriz[i+1][j];
					
				}
					
			}
			
		}
		
		//Por �ltimo se imprime la matriz resultante
		imprimeMatriz(matrizSinFila);
		
		
	}
}
