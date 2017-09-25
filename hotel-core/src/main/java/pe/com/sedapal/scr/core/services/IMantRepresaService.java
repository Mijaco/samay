
/**
 * 
 * Resumen.
 * Objeto : IMantRepresaService
 * Descripción : Interface con definición de métodos de negocio para el mantenimiento de Represa
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
import pe.com.sedapal.scr.core.beans.RepresaBean;


public interface IMantRepresaService {
	
	/**
	 * Método que permite obtener el listado de Represa
	 * @param represaBean Contiene el bean que representa la búsqueda
	 * @param paginacion Representa la página solicitada
	 * @Return Objeto de tipo Result que contiene los resultados
	 * @throws Exception Excepción que puede ser lanzada
	 **/
	Result obtenerMantRepresa(RepresaBean represaBean, Paginacion paginacion) throws Exception;
	
	/** 
	 * Obtiene la represa por identificador
	 * @param nid Identificador del registro
	 * @Return Objeto de tipo represaBean que contiene el registro 
	 * @throws Exception Excepción que puede ser lanzada
	 **/
	RepresaBean obtenerRepresa(Integer nid) throws Exception;
	
	/** 
	 * Realiza el registro de represa
	 * @param represaBean objeto del tipo RepresaBean que contiene el registro  
	 * @throws Exception Excepción que puede ser lanzada
	 **/
	boolean grabarRepresa(RepresaBean represaBean) throws Exception;
	
	
	/**
	 * Realiza la modificación de represa
	 * @param represaBean objeto del tipo RepresaBean que contiene el registro 
	 * @throws Exception Excepción que puede ser lanzada
	 **/
	boolean actualizarRepresa(RepresaBean represaBean, boolean abreviaturaIsUpdate) throws Exception ;
	
	/** 
	 * Realiza el cambío de estado de represa
	 * @param represaBean objeto del tipo RepresaBean que contiene el registro 
	 * @throws Exception Excepción que puede ser lanzada
	 **/
	void inactivarRepresa(RepresaBean represaBean) throws Exception;
	
	/**
	 * Obtiene la lista de represas activas
	 * @return Lista de objetos de tipo SelectItemBean que contiene los datos de las represas
	 * @throws Exception Excepción que puede ser lanzada
	 */
	List<SelectItemBean> obtenerRepresasActivas() throws Exception;
	
	/**
	 * Obtiene la lista de todas las represas
	 * @return Lista de objetos de tipo SelectItemBean que contiene los datos de la represa
	 * @throws Exception Excepción que puede ser lanzada
	 */
	List<SelectItemBean> obtenerRepresasTodas() throws Exception;
}
