package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;

public class TrabajadorBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String codigo;
	private String numFicha;
	private String nombreCompleto;
	private String numDocumento;
	private String nombreEmpresa;
	private String tipoTrabajador;
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNumFicha() {
		return numFicha;
	}

	public void setNumFicha(String numFicha) {
		this.numFicha = numFicha;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getTipoTrabajador() {
		return tipoTrabajador;
	}

	public void setTipoTrabajador(String tipoTrabajador) {
		this.tipoTrabajador = tipoTrabajador;
	}

}
