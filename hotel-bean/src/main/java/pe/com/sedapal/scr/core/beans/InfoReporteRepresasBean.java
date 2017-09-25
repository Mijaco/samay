package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;

public class InfoReporteRepresasBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// IDENTIFICADOR POR TIPO DE COLUMNA
	private Integer intTipoColumna;
	
	// EN GENERAL
	private String strNombrePrincipalColumna;
	
	// PARA CADA REPRESA
	private Integer intCodRepresa;
	private Integer intIdRepresas;
	private String strCota;
	private String strVolumen;
	private String strVolumenTotalRep;
	private String strDescarga;
	private String strCaudalTrasvasado;
	private String strVolumenTrasvasado;
	private String strPrecipitacion;
	private String strTiempoAtmosferico;
	
	private String strFormulaVolumenTrasvasado;
	
	// PARA ALMACENAMIENTO
	private String strRepresasAlmacenamiento;
	private String strAlmacenamientoCantidad;
	private String strAlmacenamientoPorcentaje;
	private String strTotalEmbalseCantidad;
	private String strTotalEmbalsePorcentaje;
	
	// PARA VOLUMEN TOTAL
	private String strVolumenTotal;
	
	// PARA AFORO RIO RIMAC
	private String strAforoRioRimac;
	
	// PARA SHEQUE TAMBORAQUE
	private String strCaudalRegulado;
	private String strCaudalDescarga;
	private String strCaudalNatural;
	
	// PARA COLUMNA DE AGREGADOS
	private String strRepresasExcluidas;
	private String strColumnaUno;
	private String strColumnaDos;
	
	// SI EXISTE DATO PARA LA REPRESA
	private boolean bolExistDataRepresa; // SI ES QUE HAY AL MENOS ALGUN DATO PARA EL DIA;
	
	public Integer getIntCodRepresa() {
		return intCodRepresa;
	}
	public void setIntCodRepresa(Integer intCodRepresa) {
		this.intCodRepresa = intCodRepresa;
	}
	public String getStrNombrePrincipalColumna() {
		return strNombrePrincipalColumna;
	}
	public void setStrNombrePrincipalColumna(String strNombrePrincipalColumna) {
		this.strNombrePrincipalColumna = strNombrePrincipalColumna;
	}
	public String getStrCota() {
		return strCota;
	}
	public void setStrCota(String strCota) {
		this.strCota = strCota;
	}
	public String getStrVolumen() {
		return strVolumen;
	}
	public void setStrVolumen(String strVolumen) {
		this.strVolumen = strVolumen;
	}
	public String getStrDescarga() {
		return strDescarga;
	}
	public void setStrDescarga(String strDescarga) {
		this.strDescarga = strDescarga;
	}
	public String getStrAlmacenamientoCantidad() {
		return strAlmacenamientoCantidad;
	}
	public void setStrAlmacenamientoCantidad(String strAlmacenamientoCantidad) {
		this.strAlmacenamientoCantidad = strAlmacenamientoCantidad;
	}
	public String getStrAlmacenamientoPorcentaje() {
		return strAlmacenamientoPorcentaje;
	}
	public void setStrAlmacenamientoPorcentaje(String strAlmacenamientoPorcentaje) {
		this.strAlmacenamientoPorcentaje = strAlmacenamientoPorcentaje;
	}
	public String getStrRepresasAlmacenamiento() {
		return strRepresasAlmacenamiento;
	}
	public void setStrRepresasAlmacenamiento(String strRepresasAlmacenamiento) {
		this.strRepresasAlmacenamiento = strRepresasAlmacenamiento;
	}
	public String getStrPrecipitacion() {
		return strPrecipitacion;
	}
	public void setStrPrecipitacion(String strPrecipitacion) {
		this.strPrecipitacion = strPrecipitacion;
	}
	public String getStrTiempoAtmosferico() {
		return strTiempoAtmosferico;
	}
	public void setStrTiempoAtmosferico(String strTiempoAtmosferico) {
		this.strTiempoAtmosferico = strTiempoAtmosferico;
	}
	public String getStrTotalEmbalseCantidad() {
		return strTotalEmbalseCantidad;
	}
	public void setStrTotalEmbalseCantidad(String strTotalEmbalseCantidad) {
		this.strTotalEmbalseCantidad = strTotalEmbalseCantidad;
	}
	public String getStrTotalEmbalsePorcentaje() {
		return strTotalEmbalsePorcentaje;
	}
	public void setStrTotalEmbalsePorcentaje(String strTotalEmbalsePorcentaje) {
		this.strTotalEmbalsePorcentaje = strTotalEmbalsePorcentaje;
	}
	public Integer getIntTipoColumna() {
		return intTipoColumna;
	}
	public void setIntTipoColumna(Integer intTipoColumna) {
		this.intTipoColumna = intTipoColumna;
	}
	public String getStrVolumenTotal() {
		return strVolumenTotal;
	}
	public void setStrVolumenTotal(String strVolumenTotal) {
		this.strVolumenTotal = strVolumenTotal;
	}
	public String getStrAforoRioRimac() {
		return strAforoRioRimac;
	}
	public void setStrAforoRioRimac(String strAforoRioRimac) {
		this.strAforoRioRimac = strAforoRioRimac;
	}
	public String getStrCaudalRegulado() {
		return strCaudalRegulado;
	}
	public void setStrCaudalRegulado(String strCaudalRegulado) {
		this.strCaudalRegulado = strCaudalRegulado;
	}
	public String getStrCaudalDescarga() {
		return strCaudalDescarga;
	}
	public void setStrCaudalDescarga(String strCaudalDescarga) {
		this.strCaudalDescarga = strCaudalDescarga;
	}
	public String getStrCaudalNatural() {
		return strCaudalNatural;
	}
	public void setStrCaudalNatural(String strCaudalNatural) {
		this.strCaudalNatural = strCaudalNatural;
	}
	public String getStrCaudalTrasvasado() {
		return strCaudalTrasvasado;
	}
	public void setStrCaudalTrasvasado(String strCaudalTrasvasado) {
		this.strCaudalTrasvasado = strCaudalTrasvasado;
	}
	public String getStrVolumenTrasvasado() {
		return strVolumenTrasvasado;
	}
	public void setStrVolumenTrasvasado(String strVolumenTrasvasado) {
		this.strVolumenTrasvasado = strVolumenTrasvasado;
	}
	public String getStrFormulaVolumenTrasvasado() {
		return strFormulaVolumenTrasvasado;
	}
	public void setStrFormulaVolumenTrasvasado(String strFormulaVolumenTrasvasado) {
		this.strFormulaVolumenTrasvasado = strFormulaVolumenTrasvasado;
	}
	public Integer getIntIdRepresas() {
		return intIdRepresas;
	}
	public void setIntIdRepresas(Integer intIdRepresas) {
		this.intIdRepresas = intIdRepresas;
	}
	public boolean isBolExistDataRepresa() {
		return bolExistDataRepresa;
	}
	public void setBolExistDataRepresa(boolean bolExistDataRepresa) {
		this.bolExistDataRepresa = bolExistDataRepresa;
	}
	public String getStrColumnaUno() {
		return strColumnaUno;
	}
	public void setStrColumnaUno(String strColumnaUno) {
		this.strColumnaUno = strColumnaUno;
	}
	public String getStrColumnaDos() {
		return strColumnaDos;
	}
	public void setStrColumnaDos(String strColumnaDos) {
		this.strColumnaDos = strColumnaDos;
	}
	public String getStrRepresasExcluidas() {
		return strRepresasExcluidas;
	}
	public void setStrRepresasExcluidas(String strRepresasExcluidas) {
		this.strRepresasExcluidas = strRepresasExcluidas;
	}
	public String getStrVolumenTotalRep() {
		return strVolumenTotalRep;
	}
	public void setStrVolumenTotalRep(String strVolumenTotalRep) {
		this.strVolumenTotalRep = strVolumenTotalRep;
	}
}
