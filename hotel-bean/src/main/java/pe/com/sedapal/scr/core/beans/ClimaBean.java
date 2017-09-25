package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;

public class ClimaBean extends BaseBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	/*
	 * La clase ClimaBean representa a un objeto que extiende de BaseBean.
	*/
	private Long lonCodigo;
    private String nombreClima;
    private String abreviatura;
    private String estado;
	
    private String codigo;
	
	public ClimaBean() {
	}


	public ClimaBean(String nombreClima,  String abreviatura, String estado) {
		super();
		this.nombreClima = nombreClima;
		this.abreviatura = abreviatura;
		this.estado = estado;
		
	}

	public Long getLonCodigo() {
		return lonCodigo;
	}


	public void setLonCodigo(Long lonCodigo) {
		this.lonCodigo = lonCodigo;
	}


	public String getNombreClima() {
		return nombreClima;
	}

	public void setNombreClima(String nombreClima) {
		this.nombreClima = nombreClima;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
