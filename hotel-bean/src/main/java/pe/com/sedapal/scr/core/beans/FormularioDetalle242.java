package pe.com.sedapal.scr.core.beans;

public class FormularioDetalle242 extends BaseBean {
	
	private Integer  localMuestreo;              
	private Integer  estacionMuestreo;              
	private Double altura;                      
	private String  hora;                        
	private Double  coordenadaW;                    
	private Double  coordenadaE;		                     
	private Double  ph;                        
	private Double  temperatura;                     
	private Double  conductividad;               
	private Double  turbiedad;                       
	private Double  oxigeno;                        
	private Double  clorofila ;                  
	private Double  ficocianina;                     
	private String  observaciones;                        
	private Integer codigoHeader;
	private String  tituloHeader;
	private Integer estado;
	private Integer idDetalle;
	
	
	public Integer getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(Integer idDetalle) {
		this.idDetalle = idDetalle;
	}

	public String getTituloHeader() {
		return tituloHeader;
	}

	public void setTituloHeader(String tituloHeader) {
		this.tituloHeader = tituloHeader;
	}
	
	public Integer getLocalMuestreo() {
		return localMuestreo;
	}

	public void setLocalMuestreo(Integer localMuestreo) {
		this.localMuestreo = localMuestreo;
	}

	public Integer getEstacionMuestreo() {
		return estacionMuestreo;
	}

	public void setEstacionMuestreo(Integer estacionMuestreo) {
		this.estacionMuestreo = estacionMuestreo;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public String getHora() {
		return hora;
	}
	
	public void setHora(String hora) {
		this.hora = hora;
	}
	
	public Double getCoordenadaW() {
		return coordenadaW;
	}

	public void setCoordenadaW(Double coordenadaW) {
		this.coordenadaW = coordenadaW;
	}

	public Double getCoordenadaE() {
		return coordenadaE;
	}

	public void setCoordenadaE(Double coordenadaE) {
		this.coordenadaE = coordenadaE;
	}

	public Double getPh() {
		return ph;
	}
	public void setPh(Double ph) {
		this.ph = ph;
	}
	public Double getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(Double temperatura) {
		this.temperatura = temperatura;
	}
	public Double getConductividad() {
		return conductividad;
	}
	public void setConductividad(Double conductividad) {
		this.conductividad = conductividad;
	}
	public Double getTurbiedad() {
		return turbiedad;
	}
	public void setTurbiedad(Double turbiedad) {
		this.turbiedad = turbiedad;
	}
	public Double getOxigeno() {
		return oxigeno;
	}
	public void setOxigeno(Double oxigeno) {
		this.oxigeno = oxigeno;
	}
	public Double getClorofila() {
		return clorofila;
	}
	public void setClorofila(Double clorofila) {
		this.clorofila = clorofila;
	}
	public Double getFicocianina() {
		return ficocianina;
	}
	public void setFicocianina(Double ficocianina) {
		this.ficocianina = ficocianina;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Integer getCodigoHeader() {
		return codigoHeader;
	}

	public void setCodigoHeader(Integer codigoHeader) {
		this.codigoHeader = codigoHeader;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	

}
