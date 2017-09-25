package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;
import java.util.List;

public class ReporteBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String label;
	private List data;
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}

}