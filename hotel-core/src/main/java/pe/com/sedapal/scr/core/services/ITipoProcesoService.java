/**
 * 
 * Resumen.
 * Objeto : ITipoProcesoService
 * Descripción : Interface con definición de métodos de negocio para la gestión de tipos de proceso
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

import java.util.List;

import pe.com.sedapal.common.core.beans.SelectItemBean;

public interface ITipoProcesoService {

	/**
	 * Obtiene la lista de tipos de proceso para la carga de caudales
	 * @return Lista de objetos de tipo SelectItemBean que contiene los datos de los tipos de proceso
	 * @throws Exception Excepción que puede ser lanzada
	 */
	List<SelectItemBean> obtenerAllTipoProceso() throws Exception;
}
