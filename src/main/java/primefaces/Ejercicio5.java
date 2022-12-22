package primefaces;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;

@ViewScoped
@ManagedBean
public class Ejercicio5 implements Serializable{
	
	private static final long serialVersionUID = 1456097556779975818L;

	private Pais pais;
	
	private List<Pais> paises = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		this.paises = ServicioPaises.getPaises();
	}
	
	public List<Pais> buscarPais(String busqueda) {
		return ServicioPaises.getPaises().stream().filter(p -> p.getNombre().toLowerCase().contains(busqueda.toLowerCase())).collect(Collectors.toList());
	}
	
	public void paisSeleccionado(SelectEvent event) {
		this.pais = ((Pais)event.getObject());
	}

	public List<Pais> getPaises() {
		return this.paises;
	}
	
	public void setPaises(List<Pais> paises) {
		this.paises = paises;
	}
	
	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
}
