package primefaces;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Ejercicio3 {

	private static final String DATATABLE = "datatable";
	
	private static final String KNOB = "knob";
	
	private static final String RADIO = "radio";

	private static final String DATEPICKER = "datepicker";
	
	private final List<String> opciones = new ArrayList<>();
	
	private List<String> componentesSeleccionados;
	
	private Integer knobValue;
	
	private String radioValue;

	private Date datepickerValue;

	private String opcionSeleccionada;
	
	public Boolean cargarDataTable() {
		return this.componentesSeleccionados != null && this.componentesSeleccionados.contains(DATATABLE);
	}
	
	public Boolean cargarKnob() {
		return this.componentesSeleccionados != null && this.componentesSeleccionados.contains(KNOB);
	}
	
	public Boolean cargarRadioButton() {
		return this.componentesSeleccionados != null && this.componentesSeleccionados.contains(RADIO);
	}
	
	public Boolean cargarDatePicker() {
		return this.componentesSeleccionados != null && this.componentesSeleccionados.contains(DATEPICKER);
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

	public List<String> getComponentesSeleccionados() {
		return componentesSeleccionados;
	}

	public void setComponentesSeleccionados(List<String> componentesSeleccionados) {
		this.componentesSeleccionados = componentesSeleccionados;
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
	
	public void limpiarPanel() {
		if (this.componentesSeleccionados != null) {
			this.componentesSeleccionados.clear();
		}
	}
}
