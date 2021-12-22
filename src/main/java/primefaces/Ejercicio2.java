package primefaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Ejercicio2 {

	private static final String DATATABLE = "datatable";
	
	private static final String KNOB = "knob";
	
	private static final String RADIO = "radio";

	private static final String DATEPICKER = "datepicker";
	
	private final List<String> componentes = Arrays.asList(DATATABLE, KNOB, RADIO, DATEPICKER);

	private final List<String> opciones = new ArrayList<>();
	
	private String componenteSeleccionado;
	
	private Integer knobValue;
	
	private String radioValue;

	private Date datepickerValue;

	private String opcionSeleccionada;
	
	public Boolean cargarDataTable() {
		return this.componenteSeleccionado != null
				&& this.componenteSeleccionado.equals(DATATABLE);
	}
	
	public Boolean cargarKnob() {
		return this.componenteSeleccionado != null
				&& this.componenteSeleccionado.equals(KNOB);
	}
	
	public Boolean cargarRadioButton() {
		return this.componenteSeleccionado != null
				&& this.componenteSeleccionado.equals(RADIO);
	}
	
	public Boolean cargarDatePicker() {
		return this.componenteSeleccionado != null
				&& this.componenteSeleccionado.equals(DATEPICKER);
	}
	
	public Integer getKnobValue() {
		return knobValue;
	}

	public void setKnobValue(Integer knobValue) {
		this.knobValue = knobValue;
	}

	public String getRadioValue() {
		return radioValue;
	}

	public void setRadioValue(String radioValue) {
		this.radioValue = radioValue;
	}

	public Date getDatepickerValue() {
		return datepickerValue;
	}

	public void setDatepickerValue(Date datepickerValue) {
		this.datepickerValue = datepickerValue;
	}

	public List<String> getOpciones() {
		return opciones;
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

	public String getOpcionSeleccionada() {
		return opcionSeleccionada;
	}

	public void setOpcionSeleccionada(String opcionSeleccionada) {
		this.opcionSeleccionada = opcionSeleccionada;
	}

	public void anadirOpcionALista() {
		if (this.opcionSeleccionada != null
				&& this.opcionSeleccionada != "") {
			this.opciones.add(this.opcionSeleccionada);
		}
	}
}
