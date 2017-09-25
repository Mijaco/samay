/**
 * 
 * Resumen.
 * Objeto : IMantRioDao
 * Descripción : Interface con definición de métodos de persistencia para el mantenimiento de Río
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
import pe.com.sedapal.scr.core.beans.RioBean;
import pe.com.sedapal.scr.core.beans.ValidaAbreviaturaBean;

@Repository
public interface IMantRioDao {
	
	/**
	 * Método que permite obtener el listado de Rios
	 * @param rioBean Contiene el bean que representa la búsqueda
	 * @param paginacion Representa la página solicitada
	 * @throws Exception Excepción que puede ser lanzada
	 **/
	Result obtenerMantRio(RioBean rioBean, Paginacion paginacion) throws Exception;
	
	/** 
	 * Obtiene el río por identificador
	 * @param nid Identificador del registro
	 * @throws Exception Excepción que puede ser lanzada
	 **/
	RioBean obtenerRio(Integer nid) throws Exception;

	/**
	 * Realiza el registro de rios
	 * @param rioBean objeto del tipo RioBean que contiene el registro  
	 * @throws Exception Excepción que puede ser lanzada
	 **/
	void grabarRio(RioBean rioBean) throws Exception;
	
	/**
	 * Realiza la modificación de rios
	 * @param rioBean objeto del tipo RioBean que contiene el registro 
	 * @throws Exception Excepción que puede ser lanzada
	 **/
	void actualizarRio(RioBean rioBean) throws Exception;
	
	/**
	 * Realiza el cambio de estado de río
	 * @param rioBean objeto del tipo RioBean que contiene el registro 
	 * @throws Exception Excepción que puede ser lanzada
	 **/
	void inactivarRio(RioBean rioBean) throws Exception;
	
	/** 
	 * Obtiene los ríos registrados en la plataforma según su estado
	 * @param estado de los ríos que se desean listar
	 * @return lista de objetos de tipo RioBean que contiene el resultado
	 * @throws Exception Excepción que puede ser lanzada
	 * */
	List<RioBean> obtenerRios(String estado) throws Exception;
	
	/** 
	 * Valida si existen ríos con una determinada condición
	 * @param rioBean objeto del tipo RioBean que contiene el registro
	 * @return Objeto de tipo ValidaAbreviaturaBean que contiene la información de validación
	 * @throws Exception Excepción que puede ser lanzada
	 */
	public ValidaAbreviaturaBean validarAbrevMantRio(RioBean rioBean) throws Exception;
	
}
