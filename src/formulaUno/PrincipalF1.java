package formulaUno;

public class PrincipalF1 {

	public static void main(String[] args) {
		
		Vehiculo participantes[] = new Vehiculo[5];
		
		for (int i = 0; i < 5; i++) {
			
			if (i % 2 == 0) {
				
				participantes[i] = new Coche("Piloto " + (i + 1) + ": Coche");
				
			}
			else {
				
				participantes[i] = new Moto("Piloto " + (i + 1)+ ": Moto");
				
			}
			
			System.out.println(participantes[i].getPiloto()
					+ " avanza: " + participantes[i].avanza());

		}
		int azar = 0;
		
		for (int i = 1; i <= 5; ) {
			
			azar = ((int) Math.round(Math.random() * 4));
			
			if (participantes[azar].getTurno() == -1) {
				
				participantes[azar].setTurno(i);
				System.out.println("\nTurno " + participantes[azar].getPiloto() + ": " + participantes[azar].getTurno());
				i++;
			}

			
		}
	}

}
