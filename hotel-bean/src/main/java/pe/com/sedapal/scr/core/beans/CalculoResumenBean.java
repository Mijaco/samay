package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;

public class CalculoResumenBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String strFecha;
	private String strFormulaEmbalse;
	private String strFormulaDescarga;
	private String strFormulaUno;
	private String strFormulaDos;
	
	public String getStrFecha() {
		return strFecha;
	}
	public void setStrFecha(String strFecha) {
		this.strFecha = strFecha;
	}
	public String getStrFormulaEmbalse() {
		return strFormulaEmbalse;
	}
	public void setStrFormulaEmbalse(String strFormulaEmbalse) {
		this.strFormulaEmbalse = strFormulaEmbalse;
	}
	public String getStrFormulaDescarga() {
		return strFormulaDescarga;
	}
	public void setStrFormulaDescarga(String strFormulaDescarga) {
		this.strFormulaDescarga = strFormulaDescarga;
	}
	public String getStrFormulaUno() {
		return strFormulaUno;
	}
	public void setStrFormulaUno(String strFormulaUno) {
		this.strFormulaUno = strFormulaUno;
	}
	public String getStrFormulaDos() {
		return strFormulaDos;
	}
	public void setStrFormulaDos(String strFormulaDos) {
		this.strFormulaDos = strFormulaDos;
	}
}
