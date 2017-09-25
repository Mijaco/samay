package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;

public class DetalleCatalogoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String strAbreviatura;
	private String strValor1;
	private String strValor2;
	
	public String getStrAbreviatura() {
		return strAbreviatura;
	}
	public void setStrAbreviatura(String strAbreviatura) {
		this.strAbreviatura = strAbreviatura;
	}
	public String getStrValor1() {
		return strValor1;
	}
	public void setStrValor1(String strValor1) {
		this.strValor1 = strValor1;
	}
	public String getStrValor2() {
		return strValor2;
	}
	public void setStrValor2(String strValor2) {
		this.strValor2 = strValor2;
	}
}
