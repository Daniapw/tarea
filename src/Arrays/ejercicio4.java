package Arrays;

public class ejercicio4 {

	public static void main(String[] args) {
		int array[] = new int [150], sumapares=0, sumaimpares=0;
		
		for (int i = 0; i < array.length; i++) {
			array[i] = ((int) Math.round(Math.random() * 100));
			
			System.out.print(array[i] + " ");
			
			if (array[i] % 2 == 0) {
				sumapares += array[i];
			}
			else {
				sumaimpares += array[i];
			}
		}
		
		System.out.println("\nSuma pares: " + sumapares +
							"\nSuma impares: " + sumaimpares);
		

	}

}
