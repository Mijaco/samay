/**
 * 
 * Resumen.
 * Objeto : IMantCorreoDao
 * Descripción : Interface con definición de métodos de persistencia para el mantenimiento de Configuración de correo
 * Fecha de Creación : 27/06/2017
 * Autor : atamayo
 * -----------------------------------------------------------------
 * Modificaciones
 * Fecha             Nombre                  Descripción
 * -----------------------------------------------------------------
 * 
 *
 */


package pe.com.sedapal.scr.core.dao;

import pe.com.sedapal.common.core.beans.Paginacion;
import pe.com.sedapal.common.core.beans.Result;
import pe.com.sedapal.scr.core.beans.MantCorreoBean;
import pe.com.sedapal.scr.core.beans.MantCorreoEditBean;
import pe.com.sedapal.scr.core.beans.ValidaUnicidadCorreoBean;
import pe.com.sedapal.scr.correo.core.beans.ConfiguracionCorreo;

public interface IMantCorreoDao {
	
	/**
	 * Método que permite obtener el listado de Correo
	 * @param mantCorreoBean Contiene el bean que representa la búsqueda
	 * @param paginacion Representa la página solicitada
	 * @throws Exception Excepción que puede ser lanzada
	 **/
	Result obtenerMantCorreo(MantCorreoBean mantCorreoBean, Paginacion paginacion) throws Exception;
	
	/**
	 * Realiza el cambio de estado de correo
	 * @param mantCorreoBean objeto del tipo MantCorreoBean que contiene el registro 
	 * @throws Exception Excepción que puede ser lanzada
	 **/
	void inactivarCorreo(MantCorreoBean mantCorreoBean) throws Exception;
	
	/**
	 * Realiza el registro de rios
	 * @param mantCorreoEditBean objeto del tipo MantCorreoEditBean que contiene el registro  
	 * @throws Exception Excepción que puede ser lanzada
	 **/
	void grabarMantCorreo(MantCorreoEditBean mantCorreoEditBean) throws Exception;

	/**
	 * Realiza la modificación de rios
	 * @param mantCorreoEditBean objeto del tipo MantCorreoEditBean que contiene el registro 
	 * @throws Exception Excepción que puede ser lanzada
	 **/
	void actualizarMantCorreo(MantCorreoEditBean mantCorreoEditBean) throws Exception;
	
	/** 
	 * Obtiene el correo por identificador
	 * @param idMantCorreo Identificador del registro
	 * @throws Exception Excepción que puede ser lanzada
	 **/
	MantCorreoEditBean obtenerMantenimientoCorreo(Integer idMantCorreo) throws Exception;
	
	/** 
	 * Valida si existen configuraciones de correo activas para cada tipo de configuración
	 * @Return Objeto de tipo ValidaUnicidadCorreoBean que contiene la información de validación
	 * @throws Exception Excepción que puede ser lanzada
	 */
	ValidaUnicidadCorreoBean obtenerInformacionValidacion() throws Exception;
	
	/**
	 * Método que permite obtener datos de configuración de correo para un periodo y un estado
	 * @Return Objeto de tipo ConfiguracionCorreo que contiene los datos de configuración de correo 
	 * @throws Exception Excepción que puede ser lanzada
	 */
	ConfiguracionCorreo obtenerConfigCorreo(String strTipoOperacion, String strEstado) throws Exception;
}
