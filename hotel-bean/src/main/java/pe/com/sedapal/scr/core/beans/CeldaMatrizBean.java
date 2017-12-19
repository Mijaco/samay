package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;
import java.math.BigDecimal;

public class CeldaMatrizBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String SIN_DATO = "-1.0";
	private static final String CLASS_CSS_DEFAULT = "celda-default";
	private static final String CLASS_CSS_SIN_DATO = "celda-sin-dato";
	
	private String strData;
	private String strClass;
	
	public CeldaMatrizBean(String strData, String strClass){
		this.strData = strData;
		this.strClass = strClass;
	}
	
	public CeldaMatrizBean(double dblData){
		// para evitar la notacion exponencial PE: 12.3434E4
		if(dblData == Double.parseDouble(SIN_DATO)){ // Que no le quite el .0 
			this.strData = new BigDecimal(dblData + "").toPlainString();
		}
		else{
			this.strData = new BigDecimal(dblData + "").stripTrailingZeros().toPlainString();
		}
		
		if(strData.equals(String.valueOf(SIN_DATO))){
			this.strClass = CLASS_CSS_SIN_DATO;
		}
		else{
			this.strClass = CLASS_CSS_DEFAULT;
		}
	}
	
	public CeldaMatrizBean(String strData){
		this.strData = strData;
		if(strData.equals(String.valueOf(SIN_DATO))){
			this.strClass = CLASS_CSS_SIN_DATO;
		}
		else{
			this.strClass = CLASS_CSS_DEFAULT;
		}
		
	}
	
	public String getStrData() {
		return strData;
	}
	public void setStrData(String strData) {
		this.strData = strData;
	}
	public String getStrClass() {
		return strClass;
	}
	public void setStrClass(String strClass) {
		this.strClass = strClass;
	}

	@Override
	public String toString() {
		return "CeldaMatrizBean [strData=" + strData + ", strClass=" + strClass + "]";
	}
}
