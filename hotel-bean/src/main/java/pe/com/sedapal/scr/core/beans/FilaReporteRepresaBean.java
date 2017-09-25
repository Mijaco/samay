package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;
import java.util.List;

public class FilaReporteRepresaBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String strDia;
	private String strFecha; // LA FECHA SE SETEA SOLO SI EL SIGUIENTE BOOLEAN ES TRUE
	private boolean bolExistData; // SI ES QUE HAY AL MENOS ALGUN DATO PARA EL DIA
	private String strFormulaAlmacenamiento;
	private String strFormulaManDescarga;
	private String strFormulaColumnaUno;
	private String strFormulaColumnaDos;
	private List<InfoReporteRepresasBean> lstData;
	
	public String getStrDia() {
		return strDia;
	}
	public void setStrDia(String strDia) {
		this.strDia = strDia;
	}
	public List<InfoReporteRepresasBean> getLstData() {
		return lstData;
	}
	public void setLstData(List<InfoReporteRepresasBean> lstData) {
		this.lstData = lstData;
	}
	public String getStrFecha() {
		return strFecha;
	}
	public void setStrFecha(String strFecha) {
		this.strFecha = strFecha;
	}
	public boolean isBolExistData() {
		return bolExistData;
	}
	public void setBolExistData(boolean bolExistData) {
		this.bolExistData = bolExistData;
	}
	public String getStrFormulaAlmacenamiento() {
		return strFormulaAlmacenamiento;
	}
	public void setStrFormulaAlmacenamiento(String strFormulaAlmacenamiento) {
		this.strFormulaAlmacenamiento = strFormulaAlmacenamiento;
	}
	public String getStrFormulaManDescarga() {
		return strFormulaManDescarga;
	}
	public void setStrFormulaManDescarga(String strFormulaManDescarga) {
		this.strFormulaManDescarga = strFormulaManDescarga;
	}
	public String getStrFormulaColumnaUno() {
		return strFormulaColumnaUno;
	}
	public void setStrFormulaColumnaUno(String strFormulaColumnaUno) {
		this.strFormulaColumnaUno = strFormulaColumnaUno;
	}
	public String getStrFormulaColumnaDos() {
		return strFormulaColumnaDos;
	}
	public void setStrFormulaColumnaDos(String strFormulaColumnaDos) {
		this.strFormulaColumnaDos = strFormulaColumnaDos;
	}
}
