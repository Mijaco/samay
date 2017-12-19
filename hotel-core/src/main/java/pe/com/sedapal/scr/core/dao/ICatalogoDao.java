package pe.com.sedapal.scr.core.dao;

import java.util.List;

import pe.com.sedapal.scr.core.beans.DetalleCatalogoBean;
import pe.com.sedapal.scr.core.beans.SelectItemBean;

public interface ICatalogoDao {

	/**
	 * Método que permite obtener el detalle de un catalogo por su abreviatura
	 * @Return Objeto de tipo CargaBean que contiene los datos de la carga
	 * @throws Exception Excepción que puede ser lanzada
	 */
	List<DetalleCatalogoBean> obtenerDetalleCatalogo(String strAbreviatura) throws Exception;
	
	public List<SelectItemBean> obtenerCatalogo(Integer idTabla) throws Exception;
	List<SelectItemBean> obtenerCatalogoTodosNinguno(Integer idTabla, Integer flag)  throws Exception;
	
	public List<SelectItemBean> obtenerCatalogoSeleccionar(Integer idTabla, Integer flag) throws Exception;
}
