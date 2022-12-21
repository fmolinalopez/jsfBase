package primefaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import primefaces.utilidades.StringUtils;

@ViewScoped
@ManagedBean
public class Ejercicio4 {

	private static final String CAMPO_NOMBRE = "Nombre";
	
	private static final String CAMPO_AP1 = "Apellido1";
	
	private static final String CAMPO_AP2 = "Apellido2";
	
	private static final String CAMPO_EDAD = "Edad";
	
	private static final String CAMPO_FIRMA = "Firma";
	
	private final List<String> campos = Arrays.asList(CAMPO_NOMBRE, CAMPO_AP1, CAMPO_AP2, CAMPO_EDAD, CAMPO_FIRMA);
	
	private List<String> camposSeleccionados;
	
	private String nombre;
	
	private String apellido1;
	
	private String apellido2;
	
	private Integer edad;
	
	private String firma;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getFirma() {
		return firma;
	}

	public void setFirma(String firma) {
		this.firma = firma;
	}

	public List<String> getCampos() {
		return campos;
	}
	
	public List<String> getCamposSeleccionados() {
		return camposSeleccionados;
	}

	public void setCamposSeleccionados(List<String> camposSeleccionados) {
		this.camposSeleccionados = camposSeleccionados;
	}
	
	public void limpiarCampos() {
		this.nombre = null;
		this.apellido1 = null;
		this.apellido2 = null;
		this.edad = null;
		this.firma = null;
		if (Objects.nonNull(this.camposSeleccionados)) {
			this.camposSeleccionados.clear();
		}
	}
	
	public Boolean mostrarNombre() {
		return Objects.nonNull(this.camposSeleccionados) && camposSeleccionados.contains(CAMPO_NOMBRE);
	}
	
	public Boolean mostrarApellido1() {
		return Objects.nonNull(this.camposSeleccionados) && camposSeleccionados.contains(CAMPO_AP1);
	}
	
	public Boolean mostrarApellido2() {
		return Objects.nonNull(this.camposSeleccionados) && camposSeleccionados.contains(CAMPO_AP2);
	}
	
	public Boolean mostrarEdad() {
		return Objects.nonNull(this.camposSeleccionados) && camposSeleccionados.contains(CAMPO_EDAD);
	}
	
	public Boolean mostrarFirma() {
		return Objects.nonNull(this.camposSeleccionados) && camposSeleccionados.contains(CAMPO_FIRMA);
	}
	
	public void validarFormulario() {
		final List<String> camposConError = new ArrayList<>();
		
		if (this.mostrarNombre() && StringUtils.isEmpty(this.nombre)) {
			camposConError.add(CAMPO_NOMBRE);
		}
		
		if (this.mostrarApellido1() && StringUtils.isEmpty(this.apellido1)) {
			camposConError.add(CAMPO_AP1);
		}
		
		if (this.mostrarApellido2() && StringUtils.isEmpty(this.apellido2)) {
			camposConError.add(CAMPO_AP2);
		}
		
		if (this.mostrarEdad() && (Objects.isNull(this.edad) || this.edad < 1)) {
			camposConError.add(CAMPO_EDAD);
		}
		
		if (this.mostrarFirma() && StringUtils.isEmpty(this.firma)) {
			camposConError.add(CAMPO_FIRMA);
		}
		
		if (!camposConError.isEmpty()) {
			this.mostrarError("Faltan los campos: "
					.concat(String.join(", ", camposConError)));
		} else {
			this.mostrarInfo("Formulario validado con exito");
		}
	}
	
	public void mostrarError(String err) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", err));
	 }
	 
	 public void mostrarInfo(String msj) {
		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", msj));
	 }
	 
	 public void cargarTodosLosCampos() {
		 this.camposSeleccionados = this.campos;
	 }
}
