package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;

public class SelectItemBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 137498342657462193L;
	
	private String id;
	private String value;
	private String label;
	private String custom;
	private String defecto;
	
	public SelectItemBean(String value, String label) {
		
		this.value = value;
		this.label = label;
	}

	@Override
	public String toString() {
		return "SelectItemBean [value=" + value + ", label=" + label + "]";
	}

	public SelectItemBean() {
		super();
	}
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getCustom() {
		return custom;
	}

	public void setCustom(String custom) {
		this.custom = custom;
	}

	public String getDefecto() {
		return defecto;
	}

	public void setDefecto(String defecto) {
		this.defecto = defecto;
	}
	
}
