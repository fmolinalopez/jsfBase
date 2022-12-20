package primefaces;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class Formulario {

	private String campoTexto;

	private String selectedOption;

	private String countryGroup;

	private List<String> countriesGroup = Arrays.asList("España", "Marruecos", "Argentina");

	private Product selectedProduct;

	public void validarCampos() {

		if (this.isEmpty(this.campoTexto) || this.isEmpty(this.selectedOption) || this.isEmpty(this.countryGroup) ) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:", "Faltan datos obligatorios"));
		}
	}
	
	public List<Product> getProducts() {
		Product p1 = new Product(1, "1", "P1", "DescP1", "", 100, "P1", 100);
		Product p2 = new Product(2, "2", "P2", "DescP2", "", 200, "P2", 200);
		Product p3 = new Product(3, "3", "P3", "DescP3", "", 300, "P2", 300);
		return Arrays.asList(p1, p2, p3);
	}

	public Product getSelectedProduct() {
		return selectedProduct;
	}

	public void setSelectedProduct(Product selectedProduct) {
		this.selectedProduct = selectedProduct;
	}

	public String getCountryGroup() {
		return countryGroup;
	}

	public void setCountryGroup(String countryGroup) {
		this.countryGroup = countryGroup;
	}

	public List<String> getCountriesGroup() {
		return countriesGroup;
	}

	public void setCountriesGroup(List<String> countriesGroup) {
		this.countriesGroup = countriesGroup;
	}

	public String getCampoTexto() {
		return campoTexto;
	}

	public void setCampoTexto(String campoTexto) {
		this.campoTexto = campoTexto;
	}

	public String getSelectedOption() {
		return selectedOption;
	}

	public void setSelectedOption(String selectedOption) {
		this.selectedOption = selectedOption;
	}
	
	private boolean isEmpty(String cadena) {
		return Objects.isNull(cadena) || cadena.length() == 0;
	}
}
