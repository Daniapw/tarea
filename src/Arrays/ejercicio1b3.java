package Arrays;

public class ejercicio1b3 {

	public static void main(String[] args) {
		int array[] = new int [150], numero=0;
		
		for (int i = 0; i < array.length; i++) {
			array[i] = ((int) Math.round(Math.random() * 1000));
			System.out.print(array[i] + " ");
		}

		for (int i = 0; i < array.length; i++) {
			
			
			for (int j = 0; j < array.length; j++) {
				
				if (j < (array.length-1)) {	
					if (array[j+1] < array[j]) {
						numero = array[j];
						array[j] = array[j+1];
						array[j+1] = numero;
					}
					
				}
			}
			
		}
		
		System.out.println(" ");
		
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		

	}
}


