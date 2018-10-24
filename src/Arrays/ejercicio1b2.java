package Arrays;

public class ejercicio1b2 {

	public static void main(String[] args) {
		int array[] = new int [10];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = ((int) Math.round(Math.random() * (-100 -100) + 100));
			
			System.out.print(array[i] + " ");
		}
		
		for (int i = 0; i < array.length; i++) {
			
			if (array[i] < 0) {
				array[i] = Math.abs(array[i]);
			}
			else {
				array[i] = array[i] - (array[i] * 2);
			}
		}
		
		System.out.println(" ");
		
		for (int i = 0; i < array.length; i++) {
			
			System.out.print(array[i] + " ");
		}

	}

}
