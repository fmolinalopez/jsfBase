package primefaces;

import java.util.Objects;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "conversorPais")
public class ConversorPais implements Converter {

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if (Objects.nonNull(value) && value instanceof Pais) {
			return ((Pais)value).getNombre();
		}
		
		return null;
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return ServicioPaises.getPaisPorNombre(value).get(0);
	}
}
