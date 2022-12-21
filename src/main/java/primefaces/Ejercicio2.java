package primefaces;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import primefaces.utilidades.StringUtils;

@ViewScoped
@ManagedBean
public class Ejercicio2 {

	private static final String DATATABLE = "Datatable";
	
	private static final String KNOB = "Knob";
	
	private static final String RADIO = "Radio";
	
	private static final String DATEPICKER = "Datepicker";
	
	private final List<String> componentes = Arrays.asList(DATATABLE, KNOB, RADIO, DATEPICKER);
	
	private String componenteSeleccionado;
	
	private Integer campoKnob;
	
	private String ciudad;
	
	private Date fecha;

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Integer getCampoKnob() {
		return campoKnob;
	}

	public void setCampoKnob(Integer campoKnob) {
		this.campoKnob = campoKnob;
	}

	public String getComponenteSeleccionado() {
		return componenteSeleccionado;
	}

	public void setComponenteSeleccionado(String componenteSeleccionado) {
		this.componenteSeleccionado = componenteSeleccionado;
	}

	public List<String> getComponentes() {
		return componentes;
	}
	
	public List<Product> getProducts() {
		Product p1 = new Product(1, "1", "P1", "DescP1", "", 100, "P1", 100);
		Product p2 = new Product(2, "2", "P2", "DescP2", "", 200, "P2", 200);
		Product p3 = new Product(3, "3", "P3", "DescP3", "", 300, "P2", 300);
		return Arrays.asList(p1, p2, p3);
	}
	
	public List<String> getCiudades() {
		return Arrays.asList("Sevilla", "Madrid", "Barcelona");
	}
	
	public Boolean mostrarComponente(String componente) {
		return !StringUtils.isEmpty(this.componenteSeleccionado) && this.componenteSeleccionado.contentEquals(componente);
	}
	
	public void incrementarKnob() {
		if (Objects.isNull(this.campoKnob)) {
			this.campoKnob=0;
		} else {
			this.campoKnob++;
		}
	}
}
