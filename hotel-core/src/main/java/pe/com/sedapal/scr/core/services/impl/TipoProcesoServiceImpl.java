/**
 * 
 * Resumen.
 * Objeto : TipoProcesoServiceImpl
 * Descripción : Clase de implementación de la capa de negocio para la gestión de tipos de proceso
 * Fecha de Creación : 27/06/2017
 * Autor : grondo
 * -----------------------------------------------------------------
 * Modificaciones
 * Fecha             Nombre                  Descripción
 * -----------------------------------------------------------------
 * 
 *
 */
package pe.com.sedapal.scr.core.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import pe.com.sedapal.common.core.beans.SelectItemBean;
import pe.com.sedapal.scr.core.common.Constants;
import pe.com.sedapal.scr.core.services.ITipoProcesoService;

@Service
public class TipoProcesoServiceImpl implements ITipoProcesoService {

	/**
	 * Obtiene la lista de tipos de proceso para la carga de caudales
	 * @return Lista de objetos de tipo SelectItemBean que contiene los datos de los tipos de proceso
	 * @throws Exception Excepción que puede ser lanzada
	 */
	@Override
	public List<SelectItemBean> obtenerAllTipoProceso() throws Exception {
		List<SelectItemBean> result = new ArrayList<>();
		for(int i = 0; i < Constants.CAUDAL_TIPOPROCESO.length; i++){
			SelectItemBean sib = new SelectItemBean();
			sib.setValue("" + (i+1));
			sib.setLabel(Constants.CAUDAL_TIPOPROCESO[i]);
			result.add(sib);
		}
		return result;
	}

}
