/**
 * 
 * Resumen.
 * Objeto : ICargaDao
 * Descripción : Interface con definición de métodos de acceso a datos para cargas
 * Fecha de Creación : 27/06/2017
 * Autor : grondo
 * -----------------------------------------------------------------
 * Modificaciones
 * Fecha             Nombre                  Descripción
 * -----------------------------------------------------------------
 * 
 *
 */
package pe.com.sedapal.scr.core.dao;

import pe.com.sedapal.scr.correo.core.beans.CaudalDetalle;

public interface ICaudalDetalleDao {
	
	/**
	 * Método que permite registrar el detalle de un caudal
	 * @param caudalDetalle representa la información de detalle de caudal 
	 * @return Objeto de tipo Integer con el identificador generado en la inserción
	 * @throws Exception Excepción que puede ser lanzada
	 */
	public Integer registrarCaudalDetalle(CaudalDetalle caudalDetalle) throws Exception;
	
	/**
	 * Método que permite eliminar un detalle de un caudal
	 * @param caudalDetalle representa la información de detalle de caudal 
	 * @throws Exception Excepción que puede ser lanzada
	 */
	void eliminarCaudalDetalle(CaudalDetalle caudalDetalle) throws Exception;
}
