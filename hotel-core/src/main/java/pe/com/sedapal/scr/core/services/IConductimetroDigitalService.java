package pe.com.sedapal.scr.core.services;

import pe.com.sedapal.common.core.beans.Paginacion;
import pe.com.sedapal.common.core.beans.Result;
import pe.com.sedapal.scr.core.beans.ConductimetroDigitalBean;
import pe.com.sedapal.scr.core.beans.ConductimetroDigitalDetalleBean;
import pe.com.sedapal.scr.core.beans.PhmetroDigitalBean;
import pe.com.sedapal.scr.core.beans.PhmetroDigitalDetalleBean;

public interface IConductimetroDigitalService {

	/*
	 * Método que permite obtener el listado de equipos
	 * @param conductimetroDigitalBean Contiene el bean que representa la búsqueda
	 * @param paginacion Representa la página solicitada
	 * @Return Objeto de tipo Result que contiene los resultados
	 * @throws Exception Excepción que puede ser lanzada
	 * */
	Result obtenerDatosEquipos(ConductimetroDigitalBean conductimetroDigitalBean, Paginacion paginacion) throws Exception;
	
	/* 
	 * Obtiene Información de equipo por identificador
	 * @param nid Identificador del registro
	 * @throws Exception Excepción que puede ser lanzada
	 * */	
	ConductimetroDigitalBean obtenerConductimetroDigital(Integer id) throws Exception;
	
	
	/* 
	 * Realiza el registro de un registro de la tabla de Conductimetro
	 * @param conductimetroDigitalBean objeto del tipo ConductimetroDigitalBean que contiene el registro  
	 * @throws Exception Excepción que puede ser lanzada
	 * */	
	int grabarConductimetroDigital(ConductimetroDigitalBean conductimetroDigitalBean) throws Exception;
	
	
	/* 
	 * Realiza la modificación de un registro de la tabla de Conductimetro
	 * @param conductimetroDigitalBean objeto del tipo ConductimetroDigitalBean que contiene el registro 
	 * @throws Exception Excepción que puede ser lanzada
	 * */
	void actualizarConductimetroDigital(ConductimetroDigitalBean conductimetroDigitalBean) throws Exception;
	
	/* 
	 * Realiza el cambío de estado de un registro de la tabla de Conductimetro
	 * @param conductimetroDigitalBean objeto del tipo ConductimetroDigitalBean que contiene el registro 
	 * @throws Exception Excepción que puede ser lanzada
	 * */
	void inactivarConductimetroDigital(ConductimetroDigitalBean conductimetroDigitalBean) throws Exception;
	
	/*
	 * Método que permite obtener el detalle de la tabla  Conductimetro
	 * @param conductimetroDigitalDetalleBean Contiene el bean que representa la búsqueda
	 * @param paginacion Representa la página solicitada
	 * @Return Objeto de tipo Result que contiene los resultados
	 * @throws Exception Excepción que puede ser lanzada
	 * */
	public Result obtenerDatosEquiposDetalle(ConductimetroDigitalDetalleBean conductimetroDigitalDetalleBean, Paginacion paginacion) throws Exception;
	
	/* 
	 * Realiza el registro de un registro de la tabla de detalle de Conductimetro
	 * @param conductimetroDigitalDetalleBean objeto del tipo ConductimetroDigitalDetalleBean que contiene el registro  
	 * @throws Exception Excepción que puede ser lanzada
	 * */
	public int grabarConductimetroDigitalDetalle(ConductimetroDigitalDetalleBean conductimetroDigitalDetalleBean) throws Exception;
	
	/* 
	 * Realiza el cambío de estado de un registro de la tabla detalle de Conductimetro
	 * @param conductimetroDigitalDetalleBean objeto del tipo ConductimetroDigitalDetalleBean que contiene el registro 
	 * @throws Exception Excepción que puede ser lanzada
	 * */
	public void inactivarConductimetroDigitalDetalle(ConductimetroDigitalDetalleBean conductimetroDigitalDetalleBean) throws Exception;	
	
}
