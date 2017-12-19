/**
 * 
 * Resumen.
 * Objeto : IMantClimaDao
 * Descripción : Interface con definición de métodos de acceso a datos para el mantenimiento de Clima
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

import java.util.List;

import org.springframework.stereotype.Repository;

import pe.com.sedapal.common.core.beans.Paginacion;
import pe.com.sedapal.common.core.beans.Result;
import pe.com.sedapal.scr.core.beans.ClimaBean;
import pe.com.sedapal.scr.core.beans.ValidaAbreviaturaBean;

@Repository
public interface IMantClimaDao {
	
	/**
	 * Método que permite obtener el listado de Clima
	 * @param climaBean Contiene el bean que representa la búsqueda
	 * @param paginacion Representa la página solicitada
	 * @Return Objeto de tipo Result que contiene los resultados
	 * @throws Exception Excepción que puede ser lanzada
	 **/
	Result obtenerMantClima(ClimaBean climaBean, Paginacion paginacion) throws Exception;
	
	/**
	 * Obtiene el clima por identificador
	 * @param nid Identificador del registro
	 * @Return Objeto de tipo climaBean que contiene el registro 
	 * @throws Exception Excepción que puede ser lanzada
	 **/
	ClimaBean obtenerClima(Integer nid) throws Exception;

	/** 
	 * Realiza el registro de clima
	 * @param climaBean objeto del tipo ClimaBean que contiene el registro  
	 * @throws Exception Excepción que puede ser lanzada
	 **/
	void grabarClima(ClimaBean climaBean) throws Exception;
	
	/**
	 * Realiza la modificación de clima
	 * @param climaBean objeto del tipo ClimaBean que contiene el registro 
	 * @throws Exception Excepción que puede ser lanzada
	 **/
	void actualizarClima(ClimaBean climaBean) throws Exception;
	
	/** 
	 * Realiza el cambio de estado de clima
	 * @param climaBean objeto del tipo ClimaBean que contiene el registro 
	 * @throws Exception Excepción que puede ser lanzada
	 * */
	void inactivarClima(ClimaBean climaBean) throws Exception;
	
	/** 
	 * Obtiene los climas registrados en la plataforma según su estado
	 * @param estado de los climas que se desean listar
	 * @return lista de objetos de tipo ClimaBean
	 * @throws Exception Excepción que puede ser lanzada
	 * */
	List<ClimaBean> obtenerClimas(String estado) throws Exception;
	
	/** 
	 * Valida si existen climas con una determinada condición
	 * @param climaBean objeto del tipo ClimaBean que contiene el registro
	 * @return Objeto de tipo ValidaAbreviaturaBean que contiene la información de validación
	 * @throws Exception Excepción que puede ser lanzada
	 */
	public ValidaAbreviaturaBean validarAbrevMantClima(ClimaBean climaBean) throws Exception;
}
