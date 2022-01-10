package primefaces;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

@ManagedBean (name="ejercicio5Vista")
@ViewScoped
public class Ejercicio5 {
	
	private String nombre;
	
	private String apellido1;
	
	private String apellido2;
	
	private String dni;
	
	private String direccion;
	
	private Date fechaNotificacion;
	
	private final List<Persona> asistentes = new ArrayList<>();
	
	private List<String> asistentesSeleccionados = new ArrayList<>();
	
	private Persona asistenteSeleccionado;
	
	public List<Persona> getAsistentes() {
		return this.asistentes;
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFechaNotificacion() {
		return fechaNotificacion;
	}

	public void setFechaNotificacion(Date fechaNotificacion) {
		this.fechaNotificacion = fechaNotificacion;
	}

	public Persona getAsistenteSeleccionado() {
		return asistenteSeleccionado;
	}

	public void setAsistenteSeleccionado(Persona asistenteSeleccionado) {
		this.asistenteSeleccionado = asistenteSeleccionado;
	}
	
	public List<String> getAsistentesSeleccionados() {
		return asistentesSeleccionados;
	}

	public void setAsistentesSeleccionados(List<String> asistentesSeleccionados) {
		this.asistentesSeleccionados = asistentesSeleccionados;
	}

	public void addAsistente() {
		
		if (this.validarCamposAsistente()) {
			this.asistentes.add(new Persona(this.getSiguienteId(),
					this.nombre, this.apellido1, this.apellido2, this.dni));
			this.limpiarCamposAsistente();
			this.info("Asistente añadido correctamente");
		}
	}
	
	private Integer getSiguienteId() {
		return this.asistentes.isEmpty() ? 1 : this.asistentes.size()+1;
	}
	
	public void addAsistentes() {
		
		this.asistentes.add((new Persona(this.getSiguienteId(), "FRANCISCO", "MOLINA", "LOPEZ", "123456789Z")));
		this.asistentes.add((new Persona(this.getSiguienteId(), "FRANCISCO", "LOPEZ", "MOLINA", "987654321X")));
		this.asistentes.add((new Persona(this.getSiguienteId(), "ASD", "ASD", "ASD", "321654987C")));
		this.asistentes.add((new Persona(this.getSiguienteId(), "QWE", "QWE", "QWE", "789456123V")));
	}
	
	private Boolean validarCamposAsistente() {
		StringBuilder sb = new StringBuilder();
		
		if (this.isBlank(this.nombre)) {
			sb.append("Nombre, ");
		}
		
		if (this.isBlank(this.apellido1)) {
			sb.append("Apellido1, ");
		}
		
		if (this.isBlank(this.apellido2)) {
			sb.append("Apellido2, ");
		}
		
		if (this.isBlank(this.dni)) {
			sb.append("Dni, ");
		}
		
		if (this.isBlank(sb.toString())) {
			return true;
		}
		
		this.error("Faltan los campos: " + sb.toString().substring(0, sb.toString().lastIndexOf(", ")));
		return false;
	}
	
	private Boolean isBlank(String cadena) {
		return cadena == null || cadena.equals("");
	}
	
	private void limpiarCamposAsistente() {
		this.nombre = "";
		this.apellido1 = "";
		this.apellido2 = "";
		this.dni = "";
	}

	public Boolean mostrarTablaAsistentes() {
		return !this.asistentes.isEmpty();
	}
	
	public void subir() {
		final int indiceAsistente = this.asistentes.indexOf(this.asistenteSeleccionado);
		if (indiceAsistente > 0) {
			Persona temp = this.asistentes.get(indiceAsistente-1);
			this.asistentes.set(this.asistentes.indexOf(this.asistenteSeleccionado)-1, this.asistenteSeleccionado);
			this.asistentes.set(indiceAsistente, temp);
		}
	}
	
	public void bajar() {
		final int indiceAsistente = this.asistentes.indexOf(this.asistenteSeleccionado);
		if (indiceAsistente < this.asistentes.size()-1) {
			Persona temp = this.asistentes.get(indiceAsistente+1);
			this.asistentes.set(this.asistentes.indexOf(this.asistenteSeleccionado)+1, this.asistenteSeleccionado);
			this.asistentes.set(indiceAsistente, temp);
		}
	}
	
	public void primero() {
		final int indiceAsistente = this.asistentes.indexOf(this.asistenteSeleccionado);
		if (indiceAsistente > 0) {
			Persona temp = this.asistentes.get(0);
			this.asistentes.set(0, this.asistenteSeleccionado);
			this.asistentes.set(indiceAsistente, temp);
		}
	}
	
	public void ultimo() {
		final int indiceAsistente = this.asistentes.indexOf(this.asistenteSeleccionado);
		if (indiceAsistente < this.asistentes.size()-1) {
			Persona temp = this.asistentes.get(this.asistentes.size()-1);
			this.asistentes.set(this.asistentes.size()-1, this.asistenteSeleccionado);
			this.asistentes.set(indiceAsistente, temp);
		}
	}
	
	public void editarAsistente() {
		this.asistentes.set(this.asistentes.indexOf(asistenteSeleccionado), asistenteSeleccionado);
		this.asistenteSeleccionado = null;
		PrimeFaces.current().executeScript("PF('modalEditarAsistenteWV').hide();");
		this.info("Asistente modificado");
	}
	
	public List<Persona> autocompletarAsistentes(String query) {
		return this.asistentes.stream().filter(a -> a.getNombre().contains(query) 
				|| a.getApellido1().contains(query) 
				|| a.getApellido2().contains(query) 
				|| a.getDni().contains(query)).collect(Collectors.toList());
	}

	public String getPreguntaNotificar() {
		return "Se van a notificar los siguientes asistentes: " + this.stringAsistentesANotificar() + " ¿Quiere continuar?";
	}
	
	public String stringAsistentesANotificar() {
		if (this.asistentesSeleccionados == null || this.asistentesSeleccionados.isEmpty()) {
			return "";
		}
		
		StringBuilder sb = new StringBuilder();
		this.asistentesSeleccionados.stream().forEach(a -> {
			sb.append(a + ", ");
		});
		
		return sb.toString().substring(0, sb.toString().lastIndexOf(", "));
	}
	
	public void mostrarModalNotificar() {
		this.ocultarModal("modalPreguntaNotificarWV");
		this.mostrarModal("modalNotificarWV");
	}
	
	private void mostrarModal(String modal) {
		PrimeFaces.current().executeScript("PF('"+modal+"').show();");
	}
	
	private void ocultarModal(String modal) {
		PrimeFaces.current().executeScript("PF('"+modal+"').hide();");
	}
	
	public void notificar() {
		StringBuilder sb = new StringBuilder();
		
		if (this.isBlank(this.direccion)) {
			sb.append("Direccion, ");
		}
		
		if (this.fechaNotificacion == null) {
			sb.append("Fecha de notificacion, ");
		}
		
		if (!this.isBlank(sb.toString())) {
			this.error("No se ha podido notificar. Faltan los siguientes campos obligatorios: " + sb.toString().substring(0, sb.toString().lastIndexOf(", ")));
		} else {
			this.info("La notificacion se ha realizado correctamente. Llegara a " + this.direccion + " el " + this.formatearFechaNotificacion());
			this.ocultarModal("modalNotificarWV");
			this.limpiarCamposNotificacion();
		}
	}
	
	private void limpiarCamposNotificacion() {
		this.direccion = "";
		this.fechaNotificacion = null;
	}

	private String formatearFechaNotificacion() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		return format.format(this.fechaNotificacion);
	}
	
	public Boolean botonNotificarHabilitado() {
		return this.asistentesSeleccionados == null || this.asistentesSeleccionados.isEmpty();
	}
	
	private void info(String mensaje) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito!", mensaje));
	}
	
	private void error(String mensaje) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", mensaje));
	}
}
