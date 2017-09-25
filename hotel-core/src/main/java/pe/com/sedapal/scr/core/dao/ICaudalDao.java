/**
 * 
 * Resumen.
 * Objeto : ICaudalDao
 * Descripción : Interface con definición de métodos de acceso a datos para caudales
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

import java.util.List;

import pe.com.sedapal.common.core.beans.Paginacion;
import pe.com.sedapal.common.core.beans.Result;
import pe.com.sedapal.scr.core.beans.CaudalSearchBean;
import pe.com.sedapal.scr.core.beans.CeldaMatrizBean;
import pe.com.sedapal.scr.core.beans.ReporteResumenBean;
import pe.com.sedapal.scr.correo.core.beans.Caudal;

public interface ICaudalDao {

	/**
	 * Método que permite obtener el listado de caudales de río
	 * @param caudalSearchBean Contiene los filtros de búsqueda de caudal
	 * @param paginacion Representa la página solicitada
	 * @Return Objeto de tipo Result que contiene los resultados
	 * @throws Exception Excepción que puede ser lanzada
	 */
	Result buscarCaudales(CaudalSearchBean caudalSearchBean, Paginacion paginacion) throws Exception;
	
	/**
	 * Método que permite obtener el detalle de un caudal de río
	 * @param caudalId es el identificador de caudal
	 * @Return Lista de objetos de tipo CeldaMatrizBEan que contiene los datos del detalle
	 * @throws Exception Excepción que puede ser lanzada
	 */
	List<CeldaMatrizBean> obtenerDetalleCaudal(Integer caudalid) throws Exception;
	
	/**
	 * Método que permite obtener la información para el reporte resumen pdf
	 * @param periodo Es el periodo del cual se requiere información
	 * @Return Lista de objetos ReporteResumenBean que contiene la información del reporte pdf
	 * @throws Exception Excepción que puede ser lanzada
	 */
	List<ReporteResumenBean> generarReporteResumenCaudal (String periodo) throws Exception;
	
	/**
	 * Método que actualiza la información de un caudal
	 * @param caudal Es el objeto con la información a actualizar
	 * @throws Exception Excepción que puede ser lanzada
	 */
	void actualizarCaudal(Caudal caudal) throws Exception;
}
