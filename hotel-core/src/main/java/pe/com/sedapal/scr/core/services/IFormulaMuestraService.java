package pe.com.sedapal.scr.core.services;

import pe.com.sedapal.common.core.beans.Paginacion;
import pe.com.sedapal.common.core.beans.Result;
import pe.com.sedapal.scr.core.beans.FormulaMuestraBean;

public interface IFormulaMuestraService {

	/*
	 * Método que permite obtener el listado de la tabla de Fórmlas de muestra
	 * @param formulaMuestraBean Contiene el bean que representa la búsqueda
	 * @param paginacion Representa la página solicitada
	 * @Return Objeto de tipo Result que contiene los resultados
	 * @throws Exception Excepción que puede ser lanzada
	 * */
	Result obtenerDatosFormulasMuestra(FormulaMuestraBean formulaMuestraBean, Paginacion paginacion) throws Exception;

	/* 
	 * Obtiene Fórmlas de muestra por identificador
	 * @param nid Identificador del registro
	 * @throws Exception Excepción que puede ser lanzada
	 * */	
	FormulaMuestraBean obtenerFormulaMuestra(Integer id) throws Exception;
	
	
	/* 
	 * Realiza el registro de un registro de la tabla Fórmlas de muestra
	 * @param formulaMuestraBean objeto del tipo formulaMuestraBean que contiene el registro  
	 * @throws Exception Excepción que puede ser lanzada
	 * */	
	int grabarFormulaMuestra(FormulaMuestraBean formulaMuestraBean) throws Exception;
	
	
	/* 
	 * Realiza la modificación de un registro de la tabla Fórmlas de muestra
	 * @param formulaMuestraBean objeto del tipo formulaMuestraBean que contiene el registro 
	 * @throws Exception Excepción que puede ser lanzada
	 * */
	void actualizarFormulaMuestra(FormulaMuestraBean formulaMuestraBean) throws Exception;
	
	/* 
	 * Realiza el cambío de estado de un registro de la tabla Formula de Muestra
	 * @param formulaMuestraBean objeto del tipo formulaMuestraBean que contiene el registro 
	 * @throws Exception Excepción que puede ser lanzada
	 * */
	void inactivarFormulaMuestra(FormulaMuestraBean formulaMuestraBean) throws Exception;
	
}
