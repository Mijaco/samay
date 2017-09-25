package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;

public class ManiobraBean extends BaseBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer intCodigo;
	private Integer intTipoManiobra;	
	private String strHora;
	private Double dblAperturaInicial;
	private Double dblAperturaFinal;
	private RepresasBean represas;	
	private String strEstado;
	
	private String strCodigoRepresas;
	
	private String codigo;	

	public Integer getIntCodigo() {
		return intCodigo;
	}

	public void setIntCodigo(Integer intCodigo) {
		this.intCodigo = intCodigo;
	}

	public Integer getIntTipoManiobra() {
		return intTipoManiobra;
	}

	public void setIntTipoManiobra(Integer intTipoManiobra) {
		this.intTipoManiobra = intTipoManiobra;
	}

	public String getStrHora() {
		return strHora;
	}

	public void setStrHora(String strHora) {
		this.strHora = strHora;
	}

	public Double getDblAperturaInicial() {
		return dblAperturaInicial;
	}

	public void setDblAperturaInicial(Double dblAperturaInicial) {
		this.dblAperturaInicial = dblAperturaInicial;
	}

	public Double getDblAperturaFinal() {
		return dblAperturaFinal;
	}

	public void setDblAperturaFinal(Double dblAperturaFinal) {
		this.dblAperturaFinal = dblAperturaFinal;
	}

	public RepresasBean getRepresas() {
		return represas;
	}

	public void setRepresas(RepresasBean represas) {
		this.represas = represas;
	}

	public String getStrEstado() {
		return strEstado;
	}

	public void setStrEstado(String strEstado) {
		this.strEstado = strEstado;
	}

	public String getStrCodigoRepresas() {
		return strCodigoRepresas;
	}

	public void setStrCodigoRepresas(String strCodigoRepresas) {
		this.strCodigoRepresas = strCodigoRepresas;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}	

}
