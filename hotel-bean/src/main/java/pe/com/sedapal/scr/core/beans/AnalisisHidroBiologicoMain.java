package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;
import java.util.ArrayList;

public class AnalisisHidroBiologicoMain  extends BaseBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer codsub;
	private Integer tipoOrganismo;
	private String localidad;
	private String fecha;
	
	private ArrayList<AnalisisHidroBiologico> listAnalisis;

	
	/**
	 * @return the tipoOrganismo
	 */
	public Integer getTipoOrganismo() {
		return tipoOrganismo;
	}

	/**
	 * @param tipoOrganismo the tipoOrganismo to set
	 */
	public void setTipoOrganismo(Integer tipoOrganismo) {
		this.tipoOrganismo = tipoOrganismo;
	}

	/**
	 * @return the codsub
	 */
	public Integer getCodsub() {
		return codsub;
	}

	/**
	 * @param codsub the codsub to set
	 */
	public void setCodsub(Integer codsub) {
		this.codsub = codsub;
	}

	/**
	 * @return the listAnalisis
	 */
	public ArrayList<AnalisisHidroBiologico> getListAnalisis() {
		return listAnalisis;
	}

	/**
	 * @param listAnalisis the listAnalisis to set
	 */
	public void setListAnalisis(ArrayList<AnalisisHidroBiologico> listAnalisis) {
		this.listAnalisis = listAnalisis;
	}

	/**
	 * @return the localidad
	 */
	public String getLocalidad() {
		return localidad;
	}

	/**
	 * @param localidad the localidad to set
	 */
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AnalisisHidroBiologicoMain [localidad=" + localidad + ", fecha=" + fecha + ", listAnalisis="
				+ listAnalisis + "]";
	}

}
