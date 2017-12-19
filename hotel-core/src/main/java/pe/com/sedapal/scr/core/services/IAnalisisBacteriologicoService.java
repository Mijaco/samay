package pe.com.sedapal.scr.core.services;

import pe.com.sedapal.common.core.beans.Paginacion;
import pe.com.sedapal.common.core.beans.Result;
import pe.com.sedapal.scr.core.beans.AnalisisBacteriologicoBean;
import pe.com.sedapal.scr.core.beans.MuestraFirstBean;
import pe.com.sedapal.scr.core.beans.MuestraSecondBean;
import pe.com.sedapal.scr.core.beans.ResultMuestraBean;

public interface IAnalisisBacteriologicoService {

	/*
	 * Método que permite obtener el listado de equipos
	 * @param analisisBacteriologicoBean Contiene el bean que representa la búsqueda
	 * @param paginacion Representa la página solicitada
	 * @Return Objeto de tipo Result que contiene los resultados
	 * @throws Exception Excepción que puede ser lanzada
	 * */
	Result obtenerDatosEquipos(AnalisisBacteriologicoBean analisisBacteriologicoBean, Paginacion paginacion) throws Exception;
	
	/* 
	 * Obtiene Información de equipo por identificador
	 * @param nid Identificador del registro
	 * @throws Exception Excepción que puede ser lanzada
	 * */	
	AnalisisBacteriologicoBean obtenerAnalisisBacteriologico(Integer id) throws Exception;
	
	
	/* 
	 * Realiza el registro de un registro de la tabla de Conductimetro
	 * @param analisisBacteriologicoBean objeto del tipo AnalisisBacteriologicoBean que contiene el registro  
	 * @throws Exception Excepción que puede ser lanzada
	 * */	
	int grabarAnalisisBacteriologico(AnalisisBacteriologicoBean analisisBacteriologicoBean) throws Exception;
	
	
	/* 
	 * Realiza la modificación de un registro de la tabla de Conductimetro
	 * @param analisisBacteriologicoBean objeto del tipo AnalisisBacteriologicoBean que contiene el registro 
	 * @throws Exception Excepción que puede ser lanzada
	 * */
	void actualizarAnalisisBacteriologico(AnalisisBacteriologicoBean analisisBacteriologicoBean) throws Exception;
	
	/* 
	 * Realiza el cambío de estado de un registro de la tabla de Conductimetro
	 * @param analisisBacteriologicoBean objeto del tipo AnalisisBacteriologicoBean que contiene el registro 
	 * @throws Exception Excepción que puede ser lanzada
	 * */
	void inactivarAnalisisBacteriologico(AnalisisBacteriologicoBean analisisBacteriologicoBean) throws Exception;
	
	/*
	 * Método que permite obtener el listado de la Primera muestra del Analisis Bacteriologico
	 * @param analisisBacteriologicoBean Contiene el bean que representa la búsqueda
	 * @param paginacion Representa la página solicitada
	 * @Return Objeto de tipo Result que contiene los resultados
	 * @throws Exception Excepción que puede ser lanzada
	 * */
	Result obtenerDatosMuestraFirst(MuestraFirstBean muestraFirstBean, Paginacion paginacion) throws Exception;
	
	/* 
	 * Obtiene registro de Primera muestra del Analisis Bacteriologico por identificador
	 * @param nid Identificador del registro
	 * @throws Exception Excepción que puede ser lanzada
	 * */	
	MuestraFirstBean obtenerMuestraFirst(MuestraFirstBean muestraFirstBean) throws Exception;
	
	/* 
	 * Realiza la modificación de un registro de la primera muestra del Analisis Bacteriologico
	 * @param muestraFirstBean objeto del tipo MuestraFirstBean que contiene el registro 
	 * @throws Exception Excepción que puede ser lanzada
	 * */
	void actualizarMuestraFirst(MuestraFirstBean muestraFirstBean) throws Exception;
	
	/*
	 * Método que permite obtener el listado de la Segunda muestra del Analisis Bacteriologico
	 * @param muestraSecondBean Contiene el bean que representa la búsqueda
	 * @param paginacion Representa la página solicitada
	 * @Return Objeto de tipo Result que contiene los resultados
	 * @throws Exception Excepción que puede ser lanzada
	 * */
	Result obtenerDatosMuestraSecond(MuestraSecondBean muestraSecondBean, Paginacion paginacion) throws Exception;
	
	/* 
	 * Obtiene registro de Segunda muestra del Analisis Bacteriologico por identificador
	 * @param muestraSecondBean bean que contiene los identificadores del registro
	 * @throws Exception Excepción que puede ser lanzada
	 * */
	public MuestraSecondBean obtenerMuestraSecond(MuestraSecondBean muestraSecondBean) throws Exception;
	
	/* 
	 * Realiza la modificación de un registro de la segunda muestra del Analisis Bacteriologico
	 * @param muestraSecondBean objeto del tipo MuestraSecondBean que contiene el registro 
	 * @throws Exception Excepción que puede ser lanzada
	 * */
	void actualizarMuestraSecond(MuestraSecondBean muestraSecondBean) throws Exception;
	
	/*
	 * Método que permite obtener el listado del resultado de la primera y segunda muestra del Analisis Bacteriologico
	 * @param resultMuestraBean Contiene el bean que representa la búsqueda
	 * @param paginacion Representa la página solicitada
	 * @Return Objeto de tipo Result que contiene los resultados
	 * @throws Exception Excepción que puede ser lanzada
	 * */
	public Result obtenerDatosResultMuestra(ResultMuestraBean resultMuestraBean, Paginacion paginacion)	throws Exception;
	
	/* 
	 * Realiza el calculo del resultado de la primera muestra del Analisis Bacteriologico
	 * @param muestraFirstBean objeto del tipo MuestraFirstBean que contiene el registro 
	 * @throws Exception Excepción que puede ser lanzada
	 * */
	public int calculaResultadoMuestraFirst(MuestraFirstBean muestraFirstBean) throws Exception;
	
	/* 
	 * Realiza el calculo del resultado de la segunda muestra del Analisis Bacteriologico
	 * @param muestraSecondBean objeto del tipo MuestraSecondBean que contiene el registro 
	 * @throws Exception Excepción que puede ser lanzada
	 * */
	public int calculaResultadoMuestraSecond(MuestraSecondBean muestraSecondBean) throws Exception;
	
	/* 
	 * Realiza el duplicado del registro selecionado
	 * @param muestraFirstBean objeto del tipo MuestraFirstBean que contiene el registro 
	 * @throws Exception Excepción que puede ser lanzada
	 * */
	public int addDuplicadoMuestraFirst(MuestraFirstBean muestraFirstBean) throws Exception;
	
	/* 
	 * Realiza la eliminacion del duplicado del registro selecionado
	 * @param muestraFirstBean objeto del tipo MuestraFirstBean que contiene el registro 
	 * @throws Exception Excepción que puede ser lanzada
	 * */
	public int deleteDuplicadoMuestraFirst(MuestraFirstBean muestraFirstBean) throws Exception;
	
	/* 
	 * Realiza el duplicado del registro selecionado
	 * @param muestraSecondBean objeto del tipo MuestraSecondBean que contiene el registro 
	 * @throws Exception Excepción que puede ser lanzada
	 * */
	public int addDuplicadoMuestraSecond(MuestraSecondBean muestraSecondBean) throws Exception;
	
	/* 
	 * Realiza la eliminacion del duplicado del registro selecionado
	 * @param muestraSecondBean objeto del tipo MuestraSecondBean que contiene el registro 
	 * @throws Exception Excepción que puede ser lanzada
	 * */
	public int deleteDuplicadoMuestraSecond(MuestraSecondBean muestraSecondBean) throws Exception;
}
