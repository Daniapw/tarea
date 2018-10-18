package Arrays;

public class ejercicio2b2 {

	public static void main(String[] args) {
		int array1[] = new int [150];
		int array2[] = new int [150];
		int array3[] = new int [150];
		
		System.out.println("Primer array:");
		
		for (int i = 0; i < array1.length; i++) {
			
			array1[i] =  (int)(Math.round(Math.random()*100));
			System.out.print(array1[i] + " ");
		}
		
		System.out.println("\n\nSegundo array:");
		
		for (int i = 0; i < array2.length; i++) {
			array2[i] =  (int)(Math.round(Math.random()*100));
			System.out.print(array2[i] + " ");
		}
		
		System.out.println("\n\nTercer array:");
		
		for (int i = 0; i < array3.length; i++) {
			
			if (i % 2 != 0) {
				array3[i] = array1[i];
			}
			else {
				array3[i] = array2[i];
			}
			
			System.out.print(array3[i] + " ");
		}
	}

}
