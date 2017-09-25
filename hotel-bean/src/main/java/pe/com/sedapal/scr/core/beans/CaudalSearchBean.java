package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;

public class CaudalSearchBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String strNombreLargo;
	private String strTipoProceso;
	private String strPeriodo;
	
	public String getStrNombreLargo() {
		return strNombreLargo;
	}
	public void setStrNombreLargo(String strNombreLargo) {
		this.strNombreLargo = strNombreLargo;
	}
	public String getStrTipoProceso() {
		return strTipoProceso;
	}
	public void setStrTipoProceso(String strTipoProceso) {
		this.strTipoProceso = strTipoProceso;
	}
	public String getStrPeriodo() {
		return strPeriodo;
	}
	public void setStrPeriodo(String strPeriodo) {
		this.strPeriodo = strPeriodo;
	}
}
