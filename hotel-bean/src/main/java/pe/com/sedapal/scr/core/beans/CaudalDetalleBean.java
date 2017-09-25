package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;
import java.util.List;

public class CaudalDetalleBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer intCodigoCaudal;
	private String strNombreLargoRio;
	private String strToday;
	private String strPeriodo;
	private List lstDetalles;
	
	public String getStrNombreLargoRio() {
		return strNombreLargoRio;
	}
	public void setStrNombreLargoRio(String strNombreLargoRio) {
		this.strNombreLargoRio = strNombreLargoRio;
	}
	public String getStrToday() {
		return strToday;
	}
	public void setStrToday(String strToday) {
		this.strToday = strToday;
	}
	public List getLstDetalles() {
		return lstDetalles;
	}
	public void setLstDetalles(List lstDetalles) {
		this.lstDetalles = lstDetalles;
	}
	public String getStrPeriodo() {
		return strPeriodo;
	}
	public void setStrPeriodo(String strPeriodo) {
		this.strPeriodo = strPeriodo;
	}
	public Integer getIntCodigoCaudal() {
		return intCodigoCaudal;
	}
	public void setIntCodigoCaudal(Integer intCodigoCaudal) {
		this.intCodigoCaudal = intCodigoCaudal;
	}
}
