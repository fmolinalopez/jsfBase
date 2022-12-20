package primefaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import primefaces.utilidades.StringUtils;

@ViewScoped
@ManagedBean
public class Ejercicio1 {

	private String nombre;
	
	private String apellido1;
	
	private String apellido2;
	
	private Integer edad;
	
	private String firma;

	public void validarFormulario() {
		final List<String> camposErroneos = new ArrayList<>();
		
		if (StringUtils.isEmpty(this.nombre)) {
			camposErroneos.add("Nombre");
		}
		
		if (StringUtils.isEmpty(this.apellido1)) {
			camposErroneos.add("Apellido1");
		}
		
		if (StringUtils.isEmpty(this.apellido2)) {
			camposErroneos.add("Apellido2");
		}
		
		if (Objects.isNull(this.edad) || this.edad < 0) {
			camposErroneos.add("Edad");
		}
		
		if (StringUtils.isEmpty(this.firma)) {
			camposErroneos.add("Firma");
		}
		
		if (!camposErroneos.isEmpty()) {
			this.mostrarError("Faltan los campos: "
					.concat(String.join(", ", camposErroneos)));
		} else {
			this.mostrarInfo("Formulario validado con exito");
		}
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
	
	 public void mostrarError(String err) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", err));
	 }
	 
	 public void mostrarInfo(String msj) {
		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", msj));
	 }
}
