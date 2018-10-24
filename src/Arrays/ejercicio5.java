package Arrays;

public class ejercicio5 {

	public static void main(String[] args) {
		int array[] = new int [10], sumapares=0;
		
		for (int i = 0; i < array.length; i++) {
			array[i] = ((int) Math.round(Math.random() * 100));
			
			System.out.print("Número " + (i + 1) + ": " + array[i] + " ");
			
			if ((i + 1) % 2 == 0) {
				sumapares += array[i];
					
			}
		}
		
		System.out.println("\nSuma de los números con índice par: " + sumapares);

	}

}
