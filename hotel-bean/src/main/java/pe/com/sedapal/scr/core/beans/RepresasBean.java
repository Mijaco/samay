package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;

public class RepresasBean extends BaseBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer intCodigo;
	private String strNumeroPrecipitacion;
	private String strFechaRegistro;
	private RepresaBean represa;	
	private ColaboradorBean colaborador;
	private ClimaBean clima;
	private String strTemperaturaMaxima;
	private String strTemperaturaMinima;
	private Integer intHumedadRelativa;
	private String strEstado;
	
	private String codigo;
	
	private String strCodigoRepresa;
	private String strCodigoColaborador;
	private String strCodigoClima;
	
	// Refactorizando a Strings
	private String strCota;
	private String strVolumen;
	private String strVolumenTrasvasado;
	private String strVolumenTotal;
	private String strCaudalTrasvasado;
	private String strDescarga;
	private String strLluvia;
	private String strDiferenciaNivel;
	private String strDiferenciaVolumen;
	private String strEvaporacion;
	private String strAforoRio;
	private String strHy;
	private String strCaudal;
	
	private Integer intUsaFactorDescarga;
	private String strFactorDescarga;
	private String strFactorValor;
	
	private String strFormulaVolumenTrasvasado;
	
	public RepresasBean(){
	}
	
	public Integer getIntCodigo() {
		return intCodigo;
	}
	public void setIntCodigo(Integer intCodigo) {
		this.intCodigo = intCodigo;
	}
	public String getStrNumeroPrecipitacion() {
		return strNumeroPrecipitacion;
	}
	public void setStrNumeroPrecipitacion(String strNumeroPrecipitacion) {
		this.strNumeroPrecipitacion = strNumeroPrecipitacion;
	}
	public String getStrFechaRegistro() {
		return strFechaRegistro;
	}
	public void setStrFechaRegistro(String strFechaRegistro) {
		this.strFechaRegistro = strFechaRegistro;
	}
	public RepresaBean getRepresa() {
		return represa;
	}
	public void setRepresa(RepresaBean represa) {
		this.represa = represa;
	}
	public ColaboradorBean getColaborador() {
		return colaborador;
	}
	public void setColaborador(ColaboradorBean colaborador) {
		this.colaborador = colaborador;
	}
	public ClimaBean getClima() {
		return clima;
	}
	public void setClima(ClimaBean clima) {
		this.clima = clima;
	}
	public String getStrTemperaturaMaxima() {
		return strTemperaturaMaxima;
	}

	public void setStrTemperaturaMaxima(String strTemperaturaMaxima) {
		this.strTemperaturaMaxima = strTemperaturaMaxima;
	}

	public String getStrTemperaturaMinima() {
		return strTemperaturaMinima;
	}

	public void setStrTemperaturaMinima(String strTemperaturaMinima) {
		this.strTemperaturaMinima = strTemperaturaMinima;
	}

	public Integer getIntHumedadRelativa() {
		return intHumedadRelativa;
	}
	public void setIntHumedadRelativa(Integer intHumedadRelativa) {
		this.intHumedadRelativa = intHumedadRelativa;
	}
	public String getStrEstado() {
		return strEstado;
	}
	public void setStrEstado(String strEstado) {
		this.strEstado = strEstado;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getStrCodigoRepresa() {
		return strCodigoRepresa;
	}
	public void setStrCodigoRepresa(String strCodigoRepresa) {
		this.strCodigoRepresa = strCodigoRepresa;
	}
	public String getStrCodigoColaborador() {
		return strCodigoColaborador;
	}
	public void setStrCodigoColaborador(String strCodigoColaborador) {
		this.strCodigoColaborador = strCodigoColaborador;
	}
	public String getStrCodigoClima() {
		return strCodigoClima;
	}
	public void setStrCodigoClima(String strCodigoClima) {
		this.strCodigoClima = strCodigoClima;
	}
	public String getStrDiferenciaNivel() {
		return strDiferenciaNivel;
	}
	public void setStrDiferenciaNivel(String strDiferenciaNivel) {
		this.strDiferenciaNivel = strDiferenciaNivel;
	}
	public String getStrDiferenciaVolumen() {
		return strDiferenciaVolumen;
	}
	public void setStrDiferenciaVolumen(String strDiferenciaVolumen) {
		this.strDiferenciaVolumen = strDiferenciaVolumen;
	}
	public String getStrCota() {
		return strCota;
	}
	public void setStrCota(String strCota) {
		this.strCota = strCota;
	}
	public String getStrVolumen() {
		return strVolumen;
	}
	public void setStrVolumen(String strVolumen) {
		this.strVolumen = strVolumen;
	}
	public String getStrVolumenTrasvasado() {
		return strVolumenTrasvasado;
	}
	public void setStrVolumenTrasvasado(String strVolumenTrasvasado) {
		this.strVolumenTrasvasado = strVolumenTrasvasado;
	}
	public String getStrCaudalTrasvasado() {
		return strCaudalTrasvasado;
	}
	public void setStrCaudalTrasvasado(String strCaudalTrasvasado) {
		this.strCaudalTrasvasado = strCaudalTrasvasado;
	}
	public String getStrDescarga() {
		return strDescarga;
	}
	public void setStrDescarga(String strDescarga) {
		this.strDescarga = strDescarga;
	}
	public String getStrLluvia() {
		return strLluvia;
	}
	public void setStrLluvia(String strLluvia) {
		this.strLluvia = strLluvia;
	}
	public String getStrEvaporacion() {
		return strEvaporacion;
	}
	public void setStrEvaporacion(String strEvaporacion) {
		this.strEvaporacion = strEvaporacion;
	}
	public String getStrAforoRio() {
		return strAforoRio;
	}
	public void setStrAforoRio(String strAforoRio) {
		this.strAforoRio = strAforoRio;
	}
	public String getStrHy() {
		return strHy;
	}
	public void setStrHy(String strHy) {
		this.strHy = strHy;
	}
	public String getStrCaudal() {
		return strCaudal;
	}
	public void setStrCaudal(String strCaudal) {
		this.strCaudal = strCaudal;
	}

	public Integer getIntUsaFactorDescarga() {
		return intUsaFactorDescarga;
	}

	public void setIntUsaFactorDescarga(Integer intUsaFactorDescarga) {
		this.intUsaFactorDescarga = intUsaFactorDescarga;
	}

	public String getStrFactorDescarga() {
		return strFactorDescarga;
	}

	public void setStrFactorDescarga(String strFactorDescarga) {
		this.strFactorDescarga = strFactorDescarga;
	}

	public String getStrFactorValor() {
		return strFactorValor;
	}

	public void setStrFactorValor(String strFactorValor) {
		this.strFactorValor = strFactorValor;
	}

	public String getStrFormulaVolumenTrasvasado() {
		return strFormulaVolumenTrasvasado;
	}

	public void setStrFormulaVolumenTrasvasado(String strFormulaVolumenTrasvasado) {
		this.strFormulaVolumenTrasvasado = strFormulaVolumenTrasvasado;
	}

	public String getStrVolumenTotal() {
		return strVolumenTotal;
	}

	public void setStrVolumenTotal(String strVolumenTotal) {
		this.strVolumenTotal = strVolumenTotal;
	}	
}
