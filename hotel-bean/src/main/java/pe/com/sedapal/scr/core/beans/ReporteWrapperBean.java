package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;
import java.util.List;

public class ReporteWrapperBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String strEjexTitulo;
	private String strEjeyTitulo;
	private Integer intDiasPeriodo;
	private List<ReporteBean> lstDataReporte;
	
	public String getStrEjexTitulo() {
		return strEjexTitulo;
	}
	public void setStrEjexTitulo(String strEjexTitulo) {
		this.strEjexTitulo = strEjexTitulo;
	}
	public String getStrEjeyTitulo() {
		return strEjeyTitulo;
	}
	public void setStrEjeyTitulo(String strEjeyTitulo) {
		this.strEjeyTitulo = strEjeyTitulo;
	}
	public Integer getIntDiasPeriodo() {
		return intDiasPeriodo;
	}
	public void setIntDiasPeriodo(Integer intDiasPeriodo) {
		this.intDiasPeriodo = intDiasPeriodo;
	}
	public List<ReporteBean> getLstDataReporte() {
		return lstDataReporte;
	}
	public void setLstDataReporte(List<ReporteBean> lstDataReporte) {
		this.lstDataReporte = lstDataReporte;
	}
}
