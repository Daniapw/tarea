package tresEnRaya;

public class Matriz {
	int matriz[][] = new int[3][3];
	
	public Matriz() {
		
		inicializarMatriz();
		
	}
	
	//Método que inicializa la matriz
	public void inicializarMatriz() {
		
		for (int i = 0; i < matriz.length; i++) {
			
			for (int j = 0; j < matriz.length; j++) {
				
				matriz[i][j] = 0;
				
			}
			
		}
		
	}
	
	//Método que comprueba si la partida ha terminado en empate
	public boolean esEmpate() {
		
		for (int i = 0; i < matriz.length; i++) {
			
			for (int j = 0; j < matriz.length; j++) {
				
				if (matriz [i][j] == 0 && !haGanado()) {
					
					return false;
					
				}
				
			}
			
		}
		
		return true;
	}
	
	//Boolean que comprueba si uno de los jugadores ha ganado
	public boolean haGanado() {
	
		if (matriz[0][0] == matriz [0][1] && matriz[0][1] == matriz[0][2] && matriz[0][2] != 0) {
			return true;
		}
		
		if (matriz[1][0] == matriz [1][1] && matriz[1][1] == matriz[1][2] && matriz[1][2] != 0) {
			return true;
		}
		
		if (matriz[2][0] == matriz [2][1] && matriz[2][1] == matriz[2][2] && matriz[2][2] != 0) {
			return true;
		}
		if (matriz[0][0] == matriz [1][0] && matriz[1][0] == matriz[2][0] && matriz[2][0] != 0) {
			return true;
		}
		
		if (matriz[0][1] == matriz [1][1] && matriz[1][1] == matriz[2][1] && matriz[2][1] != 0) {
			return true;
		}
		
		if (matriz[0][2] == matriz [1][2] && matriz[1][2] == matriz[2][2] && matriz[2][2] != 0) {
			return true;
		}
		
		if (matriz[0][0] == matriz [1][1] && matriz[1][1] == matriz[2][2] && matriz[2][2] != 0) {
			return true;
		}
		
		if (matriz[0][2] == matriz [1][1] && matriz[1][1] == matriz[2][0] && matriz[2][0] != 0) {
			return true;
		}
		
		return false;

	}
	
}
