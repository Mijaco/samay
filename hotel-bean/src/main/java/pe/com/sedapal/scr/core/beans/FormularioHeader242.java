package pe.com.sedapal.scr.core.beans;

public class FormularioHeader242 extends BaseBean {

	private Integer  idHeader;
	private String  strFechaMuestreo;              
	private String  strFechaRecepcion;   
	private String  personaMuestrea;
	private String  personaRecepcion;                   
	private String  observacion;
	private String  tituloHeader;
	private Integer estado;
	

	public Integer getIdHeader() {
		return idHeader;
	}

	public void setIdHeader(Integer idHeader) {
		this.idHeader = idHeader;
	}

	public String getStrFechaMuestreo() {
		return strFechaMuestreo;
	}
	
	public void setStrFechaMuestreo(String strFechaMuestreo) {
		this.strFechaMuestreo = strFechaMuestreo;
	}
	
	public String getStrFechaRecepcion() {
		return strFechaRecepcion;
	}
	
	public void setStrFechaRecepcion(String strFechaRecepcion) {
		this.strFechaRecepcion = strFechaRecepcion;
	}
	
	public String getPersonaMuestrea() {
		return personaMuestrea;
	}

	public void setPersonaMuestrea(String personaMuestrea) {
		this.personaMuestrea = personaMuestrea;
	}

	public String getPersonaRecepcion() {
		return personaRecepcion;
	}
	
	public void setPersonaRecepcion(String personaRecepcion) {
		this.personaRecepcion = personaRecepcion;
	}
	
	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getTituloHeader() {
		return tituloHeader;
	}

	public void setTituloHeader(String tituloHeader) {
		this.tituloHeader = tituloHeader;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}  
	
	
	
}
