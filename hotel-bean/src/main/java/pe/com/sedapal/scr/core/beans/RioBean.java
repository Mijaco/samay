package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;

public class RioBean extends BaseBean implements Serializable {
	/*
	 * La clase RioBean representa a un objeto que extiende de BaseBean.
	*/

	private static final long serialVersionUID = 1L;
	
	private Integer intCodigo;
    private String nombrerio;
    private String nombreLargo;
    private String abreviatura;
    private String estado;
    private String perteneceAforo;
   
    private String codigo;
	
	public RioBean() {
		this.perteneceAforo = "0";
	}

	public RioBean(String nombrerio, String nombreLargo, String abreviatura, String estado) {
		super();
		this.nombrerio = nombrerio;
		this.nombreLargo=nombreLargo;
		this.abreviatura = abreviatura;
		this.estado = estado;
		
	}

	public String getNombrerio() {
		return nombrerio;
	}

	public void setNombrerio(String nombrerio) {
		this.nombrerio = nombrerio;
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

	public String getNombreLargo() {
		return nombreLargo;
	}

	public void setNombreLargo(String nombreLargo) {
		this.nombreLargo = nombreLargo;
	}

	public Integer getIntCodigo() {
		return intCodigo;
	}

	public void setIntCodigo(Integer intCodigo) {
		this.intCodigo = intCodigo;
	}

	public String getPerteneceAforo() {
		return perteneceAforo;
	}

	public void setPerteneceAforo(String perteneceAforo) {
		this.perteneceAforo = perteneceAforo;
	}
}