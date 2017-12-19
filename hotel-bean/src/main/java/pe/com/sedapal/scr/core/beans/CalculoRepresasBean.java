package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;
import java.math.BigDecimal;

public class CalculoRepresasBean extends BaseBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer intIdRepresas;
	private String strFormulaVolumenTrasvasado;
	private BigDecimal bdValorVolumenTrasvasado;
	private String strFecha;
	
	public Integer getIntIdRepresas() {
		return intIdRepresas;
	}
	public void setIntIdRepresas(Integer intIdRepresas) {
		this.intIdRepresas = intIdRepresas;
	}
	public String getStrFormulaVolumenTrasvasado() {
		return strFormulaVolumenTrasvasado;
	}
	public void setStrFormulaVolumenTrasvasado(String strFormulaVolumenTrasvasado) {
		this.strFormulaVolumenTrasvasado = strFormulaVolumenTrasvasado;
	}
	public BigDecimal getBdValorVolumenTrasvasado() {
		return bdValorVolumenTrasvasado;
	}
	public void setBdValorVolumenTrasvasado(BigDecimal bdValorVolumenTrasvasado) {
		this.bdValorVolumenTrasvasado = bdValorVolumenTrasvasado;
	}
	public String getStrFecha() {
		return strFecha;
	}
	public void setStrFecha(String strFecha) {
		this.strFecha = strFecha;
	}
}
