package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;
import java.math.BigDecimal;

public class DatosRepresasGerenciaBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String strFecha;
	private String strHoraCorte;
	private Integer intCodigoRepresa;
	private String strNombreRepresa;
	private BigDecimal bdTopeMaximoRepresa;
	private Integer intCodigoRepresas;
	private BigDecimal bdVolumen;
	private BigDecimal bdVolumenTotal;
	private BigDecimal bdDescarga;
	private String strNombreClima;
	
	public String getStrFecha() {
		return strFecha;
	}
	public void setStrFecha(String strFecha) {
		this.strFecha = strFecha;
	}
	public Integer getIntCodigoRepresa() {
		return intCodigoRepresa;
	}
	public void setIntCodigoRepresa(Integer intCodigoRepresa) {
		this.intCodigoRepresa = intCodigoRepresa;
	}
	public String getStrNombreRepresa() {
		return strNombreRepresa;
	}
	public void setStrNombreRepresa(String strNombreRepresa) {
		this.strNombreRepresa = strNombreRepresa;
	}
	public Integer getIntCodigoRepresas() {
		return intCodigoRepresas;
	}
	public void setIntCodigoRepresas(Integer intCodigoRepresas) {
		this.intCodigoRepresas = intCodigoRepresas;
	}
	public BigDecimal getBdVolumen() {
		return bdVolumen;
	}
	public void setBdVolumen(BigDecimal bdVolumen) {
		this.bdVolumen = bdVolumen;
	}
	public BigDecimal getBdVolumenTotal() {
		return bdVolumenTotal;
	}
	public void setBdVolumenTotal(BigDecimal bdVolumenTotal) {
		this.bdVolumenTotal = bdVolumenTotal;
	}
	public BigDecimal getBdDescarga() {
		return bdDescarga;
	}
	public void setBdDescarga(BigDecimal bdDescarga) {
		this.bdDescarga = bdDescarga;
	}
	public String getStrNombreClima() {
		return strNombreClima;
	}
	public void setStrNombreClima(String strNombreClima) {
		this.strNombreClima = strNombreClima;
	}
	public String getStrHoraCorte() {
		return strHoraCorte;
	}
	public void setStrHoraCorte(String strHoraCorte) {
		this.strHoraCorte = strHoraCorte;
	}
	public BigDecimal getBdTopeMaximoRepresa() {
		return bdTopeMaximoRepresa;
	}
	public void setBdTopeMaximoRepresa(BigDecimal bdTopeMaximoRepresa) {
		this.bdTopeMaximoRepresa = bdTopeMaximoRepresa;
	}
}
