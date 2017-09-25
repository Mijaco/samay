package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;
import java.math.BigDecimal;

public class AlmacenamientoBean implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	private String strDia;
	private BigDecimal bdValorVolumen;
	private BigDecimal bdPorcentajeVolumen;
	private BigDecimal bdValorDescarga;
	private BigDecimal bdPorcentajeDescarga;
	private BigDecimal bdVolumenTotal;
	private BigDecimal bdQRegulado;
	private BigDecimal bdQDescarga;
	private BigDecimal bdQNatural;
	private BigDecimal dbColumnaUno;
	private BigDecimal dbColumnaDos;
	private String strFechaRegistro;
	private String strFormulaAlmacenamiento;
	private String strTextoFormulaAlmacenamiento;
	private String strFormulaManiobraDescarga;
	private String strTextoFormulaManiobraDescarga;
	private String strTextoFormulaColumnaUno;
	private String strTextoFormulaColumnaDos;
	
	public String getStrDia() {
		return strDia;
	}
	public void setStrDia(String strDia) {
		this.strDia = strDia;
	}
	public BigDecimal getBdValorVolumen() {
		return bdValorVolumen;
	}
	public void setBdValorVolumen(BigDecimal bdValorVolumen) {
		this.bdValorVolumen = bdValorVolumen;
	}
	public BigDecimal getBdPorcentajeVolumen() {
		return bdPorcentajeVolumen;
	}
	public void setBdPorcentajeVolumen(BigDecimal bdPorcentajeVolumen) {
		this.bdPorcentajeVolumen = bdPorcentajeVolumen;
	}
	public BigDecimal getBdValorDescarga() {
		return bdValorDescarga;
	}
	public void setBdValorDescarga(BigDecimal bdValorDescarga) {
		this.bdValorDescarga = bdValorDescarga;
	}
	public BigDecimal getBdPorcentajeDescarga() {
		return bdPorcentajeDescarga;
	}
	public void setBdPorcentajeDescarga(BigDecimal bdPorcentajeDescarga) {
		this.bdPorcentajeDescarga = bdPorcentajeDescarga;
	}
	public String getStrFechaRegistro() {
		return strFechaRegistro;
	}
	public void setStrFechaRegistro(String strFechaRegistro) {
		this.strFechaRegistro = strFechaRegistro;
	}
	public String getStrFormulaAlmacenamiento() {
		return strFormulaAlmacenamiento;
	}
	public void setStrFormulaAlmacenamiento(String strFormulaAlmacenamiento) {
		this.strFormulaAlmacenamiento = strFormulaAlmacenamiento;
	}
	public BigDecimal getBdVolumenTotal() {
		return bdVolumenTotal;
	}
	public void setBdVolumenTotal(BigDecimal bdVolumenTotal) {
		this.bdVolumenTotal = bdVolumenTotal;
	}
	public BigDecimal getBdQRegulado() {
		return bdQRegulado;
	}
	public void setBdQRegulado(BigDecimal bdQRegulado) {
		this.bdQRegulado = bdQRegulado;
	}
	public BigDecimal getBdQDescarga() {
		return bdQDescarga;
	}
	public void setBdQDescarga(BigDecimal bdQDescarga) {
		this.bdQDescarga = bdQDescarga;
	}
	public BigDecimal getBdQNatural() {
		return bdQNatural;
	}
	public void setBdQNatural(BigDecimal bdQNatural) {
		this.bdQNatural = bdQNatural;
	}
	public String getStrTextoFormulaAlmacenamiento() {
		return strTextoFormulaAlmacenamiento;
	}
	public void setStrTextoFormulaAlmacenamiento(String strTextoFormulaAlmacenamiento) {
		this.strTextoFormulaAlmacenamiento = strTextoFormulaAlmacenamiento;
	}
	public String getStrFormulaManiobraDescarga() {
		return strFormulaManiobraDescarga;
	}
	public void setStrFormulaManiobraDescarga(String strFormulaManiobraDescarga) {
		this.strFormulaManiobraDescarga = strFormulaManiobraDescarga;
	}
	public String getStrTextoFormulaManiobraDescarga() {
		return strTextoFormulaManiobraDescarga;
	}
	public void setStrTextoFormulaManiobraDescarga(String strTextoFormulaManiobraDescarga) {
		this.strTextoFormulaManiobraDescarga = strTextoFormulaManiobraDescarga;
	}
	public BigDecimal getDbColumnaUno() {
		return dbColumnaUno;
	}
	public void setDbColumnaUno(BigDecimal dbColumnaUno) {
		this.dbColumnaUno = dbColumnaUno;
	}
	public BigDecimal getDbColumnaDos() {
		return dbColumnaDos;
	}
	public void setDbColumnaDos(BigDecimal dbColumnaDos) {
		this.dbColumnaDos = dbColumnaDos;
	}
	public String getStrTextoFormulaColumnaUno() {
		return strTextoFormulaColumnaUno;
	}
	public void setStrTextoFormulaColumnaUno(String strTextoFormulaColumnaUno) {
		this.strTextoFormulaColumnaUno = strTextoFormulaColumnaUno;
	}
	public String getStrTextoFormulaColumnaDos() {
		return strTextoFormulaColumnaDos;
	}
	public void setStrTextoFormulaColumnaDos(String strTextoFormulaColumnaDos) {
		this.strTextoFormulaColumnaDos = strTextoFormulaColumnaDos;
	}
}
