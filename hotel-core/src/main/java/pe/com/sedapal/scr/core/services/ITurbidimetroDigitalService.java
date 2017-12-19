package pe.com.sedapal.scr.core.services;

import pe.com.sedapal.common.core.beans.Paginacion;
import pe.com.sedapal.common.core.beans.Result;
import pe.com.sedapal.scr.core.beans.TurbidimetroDigitalBean;
import pe.com.sedapal.scr.core.beans.TurbidimetroDigitalVerificacionBean;

public interface ITurbidimetroDigitalService {
	
	/*
	 * Método que permite obtener el listado de Equipo
	 * @param verificacionEquipoBean Contiene el bean que representa la búsqueda
	 * @param paginacion Representa la página solicitada
	 * @throws Exception Excepción que puede ser lanzada
	 * */
	Result obtenerDatosEquipos(TurbidimetroDigitalBean verificacionEquipoBean, Paginacion paginacion) throws Exception;
	
	/* 
	 * Obtiene Información de equipo por identificador
	 * @param nid Identificador del registro
	 * @throws Exception Excepción que puede ser lanzada
	 * */	
	TurbidimetroDigitalBean obtenerVerificacionEquipo(Integer id) throws Exception;
	
	
	/* 
	 * Realiza el registro de un registro de la tabla de Verificación de Equipos
	 * @param verificacionEquipoBean objeto del tipo VerificacionEquipoBean que contiene el registro  
	 * @throws Exception Excepción que puede ser lanzada
	 * */	
	int grabarVerificacionEquipo(TurbidimetroDigitalBean verificacionEquipoBean) throws Exception;
	
	
	/* 
	 * Realiza la modificación de un registro de la tabla de Verificación de Equipos
	 * @param verificacionEquipoBean objeto del tipo VerificacionEquipoBean que contiene el registro 
	 * @throws Exception Excepción que puede ser lanzada
	 * */
	void actualizarVerificacionEquipo(TurbidimetroDigitalBean verificacionEquipoBean) throws Exception;
	
	/* 
	 * Realiza el cambío de estado de un registro de la tabla de Verificación de Equipos
	 * @param verificacionEquipoBean objeto del tipo VerificacionEquipoBean que contiene el registro 
	 * @throws Exception Excepción que puede ser lanzada
	 * */
	void inactivarVerificacionEquipo(TurbidimetroDigitalBean verificacionEquipoBean) throws Exception;
	
	/*
	 * Método que permite obtener el listado de Equipo
	 * @param turbidimetroDigitalVerificacionBean Contiene el bean que representa la búsqueda
	 * @param paginacion Representa la página solicitada
	 * @throws Exception Excepción que puede ser lanzada
	 * */
	Result obtenerDatosEquiposVerificacion(TurbidimetroDigitalVerificacionBean turbidimetroDigitalVerificacionBean, Paginacion paginacion) throws Exception;
	
	/* 
	 * Realiza el registro de un registro de la tabla de Verificación de Equipos del formulario
	 * @param verificacionEquipoBean objeto del tipo turbidimetroDigitalVerificacionBean que contiene el registro  
	 * @throws Exception Excepción que puede ser lanzada
	 * */
	int grabarVerificacionEquipoForm(TurbidimetroDigitalVerificacionBean turbidimetroDigitalVerificacionBean)throws Exception;
	
	/* 
	 * Realiza el cambío de estado de un registro de la tabla de Verificación de Equipos dek formulario hijo
	 * @param turbidimetroDigitalVerificacionBean objeto del tipo TurbidimetroDigitalVerificacionBean que contiene el registro 
	 * @throws Exception Excepción que puede ser lanzada
	 * */
	public void inactivarVerificacionEquipoForm(TurbidimetroDigitalVerificacionBean turbidimetroDigitalVerificacionBean) throws Exception;

}
