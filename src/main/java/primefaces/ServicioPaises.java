package primefaces;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ServicioPaises {

	private static final List<Pais> paises 
		= Arrays.asList(new Pais(1, "Argentina"), new Pais(2, "Australia"), new Pais(3, "Brazil"), new Pais(4, "Canada"), new Pais(5, "Germany"), new Pais(6, "France"), new Pais(7, "India"), new Pais(8, "Italy"), new Pais(9, "Japan"), new Pais(10, "Russia"), new Pais(11, "Spain"), new Pais(12, "United Kingdom"));
	
	public static List<Pais> getPaises() {
		return paises;
	}
	
	public static List<Pais> getPaisPorNombre(String nombre) {
		return paises.stream()
				.filter(p -> p.getNombre().toLowerCase()
						.contains(nombre.toLowerCase()))
				.collect(Collectors.toList());
	}
}
