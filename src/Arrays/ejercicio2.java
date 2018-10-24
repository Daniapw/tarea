package Arrays;

public class ejercicio2 {

	public static void main(String[] args) {
		int array[] = new int [150];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = ((int) Math.round(Math.random() * 100));
			
			System.out.print(array[i] + " ");
		}
		
		System.out.println("\n");
		
		for (int i = (array.length - 1); i >= 0; i--) {
			
			System.out.print(array[i] + " ");
			
		}
		
	}

}
