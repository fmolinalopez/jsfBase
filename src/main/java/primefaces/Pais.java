package primefaces;

import java.io.Serializable;

public class Pais implements Serializable {

	private static final long serialVersionUID = 8015641505873919762L;

	private Integer id;
	
	private String nombre;

	public Pais() {
		super();
	}

	public Pais(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
