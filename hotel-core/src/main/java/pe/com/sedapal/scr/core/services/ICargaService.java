/**
 * 
 * Resumen.
 * Objeto : ICargaService
 * Descripción : Interface con definición de métodos de negocio para la gestión de cargas
 * Fecha de Creación : 27/06/2017
 * Autor : grondo
 * -----------------------------------------------------------------
 * Modificaciones
 * Fecha             Nombre                  Descripción
 * -----------------------------------------------------------------
 * 
 *
 */
package pe.com.sedapal.scr.core.services;

import pe.com.sedapal.common.core.beans.Paginacion;
import pe.com.sedapal.common.core.beans.Result;
import pe.com.sedapal.scr.core.beans.CargaBean;

public interface ICargaService {

	/**
	 * Método que permite obtener la última carga automática de caudales
	 * @Return Objeto de tipo CargaBean que contiene los datos de la carga
	 * @throws Exception Excepción que puede ser lanzada
	 */
	CargaBean obtenerUltimaCarga() throws Exception;
	
	/**
	 * Método que permite obtener el listado de cargas
	 * @param paginacion Representa la página solicitada
	 * @Return Objeto de tipo Result que contiene los resultados
	 * @throws Exception Excepción que puede ser lanzada
	 */
	Result buscarCargas(Paginacion paginacion) throws Exception;
}
