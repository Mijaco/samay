/**
 * 
 * Resumen.
 * Objeto : IMantClimaService
 * Descripción : Interface con definición de métodos de negocio para el mantenimiento de Clima
 * Fecha de Creación : 27/06/2017
 * Autor : atamayo
 * -----------------------------------------------------------------
 * Modificaciones
 * Fecha             Nombre                  Descripción
 * -----------------------------------------------------------------
 * 
 *
 */
package pe.com.sedapal.scr.core.services;



import java.util.List;

import pe.com.sedapal.common.core.beans.Paginacion;
import pe.com.sedapal.common.core.beans.Result;
import pe.com.sedapal.common.core.beans.SelectItemBean;
import pe.com.sedapal.scr.core.beans.ClimaBean;

public interface IMantClimaService {
	
	/**
	 * Método que permite obtener el listado de Clima
	 * @param climaBean Contiene el bean que representa la búsqueda
	 * @param paginacion Representa la página solicitada
	 * @throws Exception Excepción que puede ser lanzada
	 **/
	Result obtenerMantClima(ClimaBean climaBean, Paginacion paginacion) throws Exception;
	
	/**
	 * Obtiene el clima por identificador
	 * @param nid Identificador del registro
	 * @throws Exception Excepción que puede ser lanzada
	 * */
	ClimaBean obtenerClima(Integer nid) throws Exception;
	
	
	/**
	 * Realiza el registro de clima
	 * @param climaBean objeto del tipo ClimaBean que contiene el registro  
	 * @throws Exception Excepción que puede ser lanzada
	 **/
	boolean grabarClima(ClimaBean climaBean) throws Exception;
	
	
	/** 
	 * Realiza la modificación de clima
	 * @param climaBean objeto del tipo ClimaBean que contiene el registro 
	 * @throws Exception Excepción que puede ser lanzada
	 **/
	boolean actualizarClima(ClimaBean climaBean, boolean abreviaturaIsUpdate) throws Exception;
	
	/**
	 * Realiza el cambio de estado de clima
	 * @param climaBean objeto del tipo ClimaBean que contiene el registro 
	 * @throws Exception Excepción que puede ser lanzada
	 **/
	void inactivarClima(ClimaBean climaBean) throws Exception;
	
	/**
	 * Obtiene la lista de climas activos
	 * @return Lista de objetos de tipo SelectItemBean que contiene los datos de los climas
	 * @throws Exception Excepción que puede ser lanzada
	 */
	List<SelectItemBean> obtenerClimasActivos() throws Exception;
	
	/**
	 * Obtiene la lista de todos los climas
	 * @return Lista de objetos de tipo SelectItemBean que contiene los datos del clima
	 * @throws Exception Excepción que puede ser lanzada
	 */
	List<SelectItemBean> obtenerClimasTodos() throws Exception;
	
}
