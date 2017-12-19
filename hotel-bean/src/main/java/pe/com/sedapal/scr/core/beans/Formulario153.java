package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;
import java.sql.Timestamp;

public class Formulario153 extends BaseBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String codigo;
	private Integer tipoCustodia;
	private String codigoFrasco;
    private String strFechaHora;
    private String hora;
    private Integer matriz;
    private Integer personaMuestrea;
    private Integer tipoAnalisis;
    private Integer recepcionAnalista;
    private Integer puntoMuestreo;
    private Integer tipoFrasco;
    private String aplicacionMedidas;
    private String temperatura;
 
    
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Integer getTipoCustodia() {
		return tipoCustodia;
	}
	public void setTipoCustodia(Integer tipoCustodia) {
		this.tipoCustodia = tipoCustodia;
	}
	public String getCodigoFrasco() {
		return codigoFrasco;
	}
	public void setCodigoFrasco(String codigoFrasco) {
		this.codigoFrasco = codigoFrasco;
	}
	public String getStrFechaHora() {
		return strFechaHora;
	}
	public void setStrFechaHora(String strFechaHora) {
		this.strFechaHora = strFechaHora;
	}
	public Integer getMatriz() {
		return matriz;
	}
	public void setMatriz(Integer matriz) {
		this.matriz = matriz;
	}
	public Integer getPersonaMuestrea() {
		return personaMuestrea;
	}
	public void setPersonaMuestrea(Integer personaMuestrea) {
		this.personaMuestrea = personaMuestrea;
	}
	public Integer getTipoAnalisis() {
		return tipoAnalisis;
	}
	public void setTipoAnalisis(Integer tipoAnalisis) {
		this.tipoAnalisis = tipoAnalisis;
	}
	public Integer getRecepcionAnalista() {
		return recepcionAnalista;
	}
	public void setRecepcionAnalista(Integer recepcionAnalista) {
		this.recepcionAnalista = recepcionAnalista;
	}
	public Integer getPuntoMuestreo() {
		return puntoMuestreo;
	}
	public void setPuntoMuestreo(Integer puntoMuestreo) {
		this.puntoMuestreo = puntoMuestreo;
	}
	public Integer getTipoFrasco() {
		return tipoFrasco;
	}
	public void setTipoFrasco(Integer tipoFrasco) {
		this.tipoFrasco = tipoFrasco;
	}
	public String getAplicacionMedidas() {
		return aplicacionMedidas;
	}
	public void setAplicacionMedidas(String aplicacionMedidas) {
		this.aplicacionMedidas = aplicacionMedidas;
	}
	public String getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}
	
	public String getHora() {
		return hora;
	}
	
	public void setHora(String hora) {
		this.hora = hora;
	}
	

}
