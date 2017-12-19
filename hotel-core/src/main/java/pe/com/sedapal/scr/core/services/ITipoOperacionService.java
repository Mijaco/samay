/**
 * 
 * Resumen.
 * Objeto : ITipoOperacionService
 * Descripción : Interface con definición de métodos de negocio para la gestión de tipos de operación
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

public interface ITipoOperacionService {

	/**
	 * Obtiene la lista de tipos de operación para la configuración de correos
	 * @return Lista de objetos de tipo SelectItemBean que contiene los datos de los tipos de operación
	 * @throws Exception Excepción que puede ser lanzada
	 */
	List<SelectItemBean> obtenerAllTipoOperacion() throws Exception;
}
