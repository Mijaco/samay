package pe.com.sedapal.scr.core.dao;

import org.springframework.stereotype.Repository;

import pe.com.sedapal.common.core.beans.Paginacion;
import pe.com.sedapal.common.core.beans.Result;
import pe.com.sedapal.scr.core.beans.TablaPoissonBean;

@Repository
public interface ITablaPoissonDao {
	
	/*
	 * Método que permite obtener el listado de Tabla Poisson
	 * @param tablaPoissonBean Contiene el bean que representa la búsqueda
	 * @param paginacion Representa la página solicitada
	 * @Return Objeto de tipo Result que contiene los resultados
	 * @throws Exception Excepción que puede ser lanzada
	 * */
	Result obtenerDatosPoisson(TablaPoissonBean tablaPoissonBean, Paginacion paginacion) throws Exception;
	
	/* 
	 * Obtiene tabla poisson por identificador
	 * @param nid Identificador del registro
	 * @throws Exception Excepción que puede ser lanzada
	 * */	
	TablaPoissonBean obtenerTablaPoisson(Integer id) throws Exception;
	
	
	/* 
	 * Realiza el registro de un registro de la tabla poisson
	 * @param tablaPoissonBean objeto del tipo TablaPoissonBean que contiene el registro  
	 * @throws Exception Excepción que puede ser lanzada
	 * */	
	int grabarTablaPoisson(TablaPoissonBean tablaPoissonBean) throws Exception;
	
	
	/* 
	 * Realiza la modificación de un registro de la tabla poisson
	 * @param tablaPoissonBean objeto del tipo TablaPoissonBean que contiene el registro 
	 * @throws Exception Excepción que puede ser lanzada
	 * */
	void actualizarTablaPoisson(TablaPoissonBean tablaPoissonBean) throws Exception;
	
	/* 
	 * Realiza el cambío de estado de un registro de la tabla poisson
	 * @param tablaPoissonBean objeto del tipo TablaPoissonBean que contiene el registro 
	 * @throws Exception Excepción que puede ser lanzada
	 * */
	void inactivarTablaPoisson(TablaPoissonBean tablaPoissonBean) throws Exception;

}
