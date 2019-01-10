package ejerciciosListas.ej3ArrayCreciente;

import java.util.ArrayList;
import java.util.List;

public class ArrayCreciente {
	Object[] lista = null;
	
	
	public ArrayCreciente(int tamano) {
		super();

		Object[] array = new Object[tamano];
		
		this.lista = array;
	}
	
	public Object[] anadeArray(Object[] objeto) {
		
		List lista = new ArrayList();
		
		lista.add(lista);
		
		lista.add(objeto);

		Object[] nuevoArray = lista.toArray();
		
		return nuevoArray;
	}
}
