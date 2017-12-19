package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;

public class ReportePivotBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String strAttributeVertical;
	private String strAttributeHorizontal;
	
	public String getStrAttributeVertical() {
		return strAttributeVertical;
	}
	public void setStrAttributeVertical(String strAttributeVertical) {
		this.strAttributeVertical = strAttributeVertical;
	}
	public String getStrAttributeHorizontal() {
		return strAttributeHorizontal;
	}
	public void setStrAttributeHorizontal(String strAttributeHorizontal) {
		this.strAttributeHorizontal = strAttributeHorizontal;
	}
}
