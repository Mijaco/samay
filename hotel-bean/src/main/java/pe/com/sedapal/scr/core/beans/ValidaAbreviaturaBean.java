package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;

public class ValidaAbreviaturaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private boolean bolAbreviatura;
	private boolean bolNombreLargo;
	
	public boolean isBolAbreviatura() {
		return bolAbreviatura;
	}
	public void setBolAbreviatura(boolean bolAbreviatura) {
		this.bolAbreviatura = bolAbreviatura;
	}
	public boolean isBolNombreLargo() {
		return bolNombreLargo;
	}
	public void setBolNombreLargo(boolean bolNombreLargo) {
		this.bolNombreLargo = bolNombreLargo;
	}
}
