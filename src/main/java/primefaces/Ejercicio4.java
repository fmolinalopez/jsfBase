package primefaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class Ejercicio4 {

	private static final String NOMBRE = "nombre";
	
	private static final String APELLIDO_1 = "apellido1";
	
	private static final String APELLIDO_2 = "apellido2";
	
	private static final String EDAD = "edad";
	
	private static final String FIRMA = "firma";
	
	private final List<String> campos = Arrays.asList(NOMBRE, APELLIDO_1, APELLIDO_2, EDAD, FIRMA);

	private List<String> camposSeleccionados = new ArrayList<>();

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

	public List<String> getCamposSeleccionados() {
		return camposSeleccionados;
	}

	public void setCamposSeleccionados(List<String> camposSeleccionados) {
		this.camposSeleccionados = camposSeleccionados;
	}

	public List<String> getCampos() {
		return campos;
	}
	
	public Boolean mostrarCampo(String campo) {
		return this.camposSeleccionados.contains(campo);
	}
	
	public void limpiarPanel() {
		this.camposSeleccionados.clear();
		this.limpiarCampos();
	}
	
	private void limpiarCampos() {
		this.nombre = null;
		this.apellido1 = null;
		this.apellido2 = null;
		this.edad = null;
		this.firma = null;
	}
	
	public Boolean algunCampoSeleccionado() {
		return this.camposSeleccionados != null && this.camposSeleccionados.size() > 0;
	}
	
	public void validar() {

		StringBuilder sb = new StringBuilder();
		
		if (this.mostrarCampo(NOMBRE) && (nombre == null || nombre.equals(""))) {
				sb.append("Nombre, ");
		}
		
		if (this.mostrarCampo(APELLIDO_1) && (apellido1 == null || apellido1.equals(""))) {
			sb.append("Apellido 1, ");
		}
		
		if (this.mostrarCampo(APELLIDO_2) && (apellido2== null || apellido2.equals(""))) {
			sb.append("Apellido 2, ");
		}
		
		if (this.mostrarCampo(EDAD) && (edad == null || edad <= 0)) {
			sb.append("Edad, ");
		}
		
		if (this.mostrarCampo(FIRMA) && (firma == null || firma.equals(""))) {
			sb.append("Firma, ");
		}
		
		if (sb.toString().equals("")) {
			this.info("Formulario válido!!!");
		} else {
			this.error("Faltan los campos: " + sb.toString().substring(0, sb.toString().lastIndexOf(", ")));
		}
	}
	
	private void info(String mensaje) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito!", mensaje));
	}
	
	private void error(String mensaje) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", mensaje));
	}
}
