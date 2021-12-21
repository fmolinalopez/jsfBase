package primefaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Formulario {

	private String campoTexto;
	
	private String campoTextoAjax;

	private String selectOne;
	
	private final List<String> datos = Arrays.asList("Dato 1", "Dato 2", "Dato 3");
	
	private final List<String> opciones = new ArrayList<>();
	
	public void anadirOpcionALista() {
		if (this.selectOne != null && this.selectOne != "") {
			this.opciones.add(this.selectOne);
		}
	}
	
	public List<String> getOpciones() {
		return opciones;
	}

	public String getCampoTextoAjax() {
		return campoTextoAjax;
	}
	
	public void setCampoTextoAjax(String campoTextoAjax) {
		this.campoTextoAjax = campoTextoAjax;
	}
	
	public List<String> getDatos() {
		return datos;
	}

	public String getSelectOne() {
		return selectOne;
	}

	public void setSelectOne(String selectOne) {
		this.selectOne = selectOne;
	}

	public String getCampoTexto() {
		return campoTexto;
	}

	public void setCampoTexto(String campoTexto) {
		this.campoTexto = campoTexto;
	}
	
	public void validar() {
		if (this.campoTexto == null || this.campoTexto == ""
				|| this.selectOne == null || this.selectOne == "") {
			System.out.println("Formulario no valido");
		} else {
			System.out.println("Formulario valido");
		}
	}
}
