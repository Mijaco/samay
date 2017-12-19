package pe.com.sedapal.scr.core.beans;

public class Formulario314 extends BaseBean {
	
	private Integer idformulario314;
	private Integer tipoEnsayo;
	private Integer tipoAnalista;
	private String codMuestra;
	private Double resultado1;
	private Double resultado2;
	private String strFecha;
	private Double rsd;
	private Integer obs;
	private String opcion;    //Grabar = S, Update = U
	private Integer status;
	
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIdformulario314() {
		return idformulario314;
	}

	public void setIdformulario314(Integer idformulario314) {
		this.idformulario314 = idformulario314;
	}

	public Integer getTipoEnsayo() {
		return tipoEnsayo;
	}

	public void setTipoEnsayo(Integer tipoEnsayo) {
		this.tipoEnsayo = tipoEnsayo;
	}

	public Integer getTipoAnalista() {
		return tipoAnalista;
	}

	public void setTipoAnalista(Integer tipoAnalista) {
		this.tipoAnalista = tipoAnalista;
	}

	public String getCodMuestra() {
		return codMuestra;
	}

	public void setCodMuestra(String codMuestra) {
		this.codMuestra = codMuestra;
	}

	public Double getResultado1() {
		return resultado1;
	}

	public void setResultado1(Double resultado1) {
		this.resultado1 = resultado1;
	}

	public Double getResultado2() {
		return resultado2;
	}

	public void setResultado2(Double resultado2) {
		this.resultado2 = resultado2;
	}

	public String getStrFecha() {
		return strFecha;
	}

	public void setStrFecha(String strFecha) {
		this.strFecha = strFecha;
	}

	public Double getRsd() {
		return rsd;
	}

	public void setRsd(Double rsd) {
		this.rsd = rsd;
	}

	public Integer getObs() {
		return obs;
	}

	public void setObs(Integer obs) {
		this.obs = obs;
	}

	public String getOpcion() {
		return opcion;
	}

	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}


	
	

}
