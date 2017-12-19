package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;

public class RepresaBean extends BaseBean implements Serializable {

	/*
	 * La clase RepresaBean representa a un objeto que extiende de BaseBean.
	*/
	
	private static final long serialVersionUID = 1L;
	
	private Integer intCodigo;
    private String nombreRepresa;
    private String abreviatura;
    private String strTopeMaximo;
    private String estado;
    private String perteneceAlmacenamiento;
   
    private String codigo;
	
	public RepresaBean() {
		this.perteneceAlmacenamiento = "0";
	}

	public RepresaBean(String nombreRepresa,  String abreviatura, String estado) {
		super();
		this.nombreRepresa = nombreRepresa;
		this.abreviatura = abreviatura;
		this.estado = estado;
		
	}

	public Integer getIntCodigo() {
		return intCodigo;
	}

	public void setIntCodigo(Integer intCodigo) {
		this.intCodigo = intCodigo;
	}

	public String getNombreRepresa() {
		return nombreRepresa;
	}

	public void setNombreRepresa(String nombreRepresa) {
		this.nombreRepresa = nombreRepresa;
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

	public String getPerteneceAlmacenamiento() {
		return perteneceAlmacenamiento;
	}

	public void setPerteneceAlmacenamiento(String perteneceAlmacenamiento) {
		this.perteneceAlmacenamiento = perteneceAlmacenamiento;
	}

	public String getStrTopeMaximo() {
		return strTopeMaximo;
	}

	public void setStrTopeMaximo(String strTopeMaximo) {
		this.strTopeMaximo = strTopeMaximo;
	}
}
