package pe.com.sedapal.scr.core.dao;

import org.springframework.stereotype.Repository;

import pe.com.sedapal.common.core.beans.Paginacion;
import pe.com.sedapal.common.core.beans.Result;
import pe.com.sedapal.scr.core.beans.Parametro;

@Repository
public interface ITipoServicioDao {

	/**
	 * Método que permite obtener los tipos de servicio para la paginacion
	 * @param parametro Contiene el bean que representa la búsqueda
	 * @param paginacion Representa la página solicitada
	 * @return Objeto de tipo Result que contiene los resultados
	 * @throws Exception Manejador de excepción que pueda ocurrir
	 */
	Result obtenerTipoDeServicio(Parametro parametro, Paginacion paginacion) throws Exception;
	
	/**
	 * 
	 * @param nid
	 * @return
	 * @throws Exception
	 */
	Parametro obtenerTipoDeServicio(Integer nid) throws Exception;
	
	/**
	 * 
	 * @param parametro
	 * @throws Exception
	 */
	void grabarTipoDeServicio(Parametro parametro) throws Exception;
	
	/**
	 * 
	 * @param parametroEditBean
	 * @throws Exception
	 */
	void actualizarPuntoDistribucion(Parametro parametroEditBean) throws Exception;
	
	/**
	 * 
	 * @param parametro
	 * @throws Exception
	 */
	void inactivarTipoDeServicio(Parametro parametro) throws Exception;
	
}
