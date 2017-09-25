package pe.com.sedapal.scr.core.beans.pivote;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class Column {
	private String name;
    private String value;

    @XmlAttribute
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @XmlValue
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
}
