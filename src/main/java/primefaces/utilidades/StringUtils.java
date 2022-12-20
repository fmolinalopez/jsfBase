package primefaces.utilidades;

import java.util.Objects;

public class StringUtils {

	public static Boolean isEmpty(String cadena) {
		return Objects.isNull(cadena) || cadena.isEmpty(); 
	}
}
