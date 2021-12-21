package primefaces;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class Ejercicio1 {

	private String nombre;
	
	private String apellido1;
	
	private String apellido2;
	
	private Integer edad;

	private String firma;
	
	public String getFirma() {
		return firma;
	}

	public void setFirma(String firma) {
		this.firma = firma;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}



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
	
	public void validar() {
		StringBuilder sb = new StringBuilder();
		
		if (this.nombre == null || this.nombre == "") {
			sb.append("nombre, ");
		}
		
		if (this.apellido1 == null || this.apellido1 == "") {
			sb.append("apellido1, ");
		}
		
		if (this.apellido2 == null || this.apellido2 == "") {
			sb.append("apellido2, ");
		}
		
		if (this.edad == null || this.edad <= 0) {
			sb.append("edad, ");
		}
		
		if (this.firma == null || this.firma == "") {
			sb.append("firma, ");
		}
		
		if (sb.toString().equals("")) {
			this.info("Formulario valido");
		} else {
			this.error("Faltan los campos " + sb.toString().substring(0, sb.lastIndexOf(", ")));
		}
	}
	
	public void info(String msgInfo) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msgInfo));
    }
	
	public void error(String msgError) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", msgError));
	}
}
