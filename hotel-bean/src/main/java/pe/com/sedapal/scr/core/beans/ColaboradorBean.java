package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;

public class ColaboradorBean extends BaseBean implements Serializable {
	
	
	/*
	 * La clase ColaboradorBean representa a un objeto que extiende de BaseBean.
	*/

	private static final long serialVersionUID = 1L;
	
	private Long lonCodigo;
    private String nombreColaborador;
    private String dni;
    private String nombreEmpresa;
    private String tipoTrabajador;
    private String abreviatura;
    private String estado;
   
	
    private String codigo;
	
	public ColaboradorBean() {
	}



	public ColaboradorBean(String nombreColaborador, String dni, String nombreEmpresa, String nombreRepresa,
			String tipoTrabajador, String usuario, String abreviatura, String estado, String codigo) {
		super();
		this.nombreColaborador = nombreColaborador;
		this.dni = dni;
		this.nombreEmpresa = nombreEmpresa;
		this.tipoTrabajador = tipoTrabajador;
		this.abreviatura = abreviatura;
		this.estado = estado;
		this.codigo = codigo;
	}


	public Long getLonCodigo() {
		return lonCodigo;
	}

	public void setLonCodigo(Long lonCodigo) {
		this.lonCodigo = lonCodigo;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombreColaborador() {
		return nombreColaborador;
	}

	public void setNombreColaborador(String nombreColaborador) {
		this.nombreColaborador = nombreColaborador;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getTipoTrabajador() {
		return tipoTrabajador;
	}

	public void setTipoTrabajador(String tipoTrabajador) {
		this.tipoTrabajador = tipoTrabajador;
	}
}
