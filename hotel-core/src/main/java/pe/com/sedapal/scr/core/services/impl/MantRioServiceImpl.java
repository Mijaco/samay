/**
 * 
 * Resumen.
 * Objeto : MantRioServiceImpl
 * Descripción : Clase de implementación de métodos de negocio para el mantenimiento de Río
 * Fecha de Creación : 27/06/2017
 * Autor : jtamayo
 * -----------------------------------------------------------------
 * Modificaciones
 * Fecha             Nombre                  Descripción
 * -----------------------------------------------------------------
 * 
 *
 */

package pe.com.sedapal.scr.core.services.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.sedapal.common.core.beans.Paginacion;
import pe.com.sedapal.common.core.beans.Result;
import pe.com.sedapal.common.core.beans.SelectItemBean;
import pe.com.sedapal.scr.core.beans.RioBean;
import pe.com.sedapal.scr.core.beans.ValidaAbreviaturaBean;
import pe.com.sedapal.scr.core.common.Constants;
import pe.com.sedapal.scr.core.dao.IMantRioDao;
import pe.com.sedapal.scr.core.services.IMantRioService;


@Service
public class MantRioServiceImpl implements IMantRioService {

	@Autowired
	private IMantRioDao iMantRioDao;
	
	
	/**
	 * Método que permite obtener el listado de Rio
	 * @param rioBean Contiene el bean que representa la búsqueda
	 * @param paginacion Representa la página solicitada
	 * @throws Exception Excepción que puede ser lanzada	
	 **/
	@Override
	public Result obtenerMantRio(RioBean rioBean, Paginacion paginacion) throws Exception {
		return iMantRioDao.obtenerMantRio(rioBean, paginacion);
	}

	/**
	 * Obtiene el río por identificador
	 * @param nid Identificador del registro
	 * @Return Objeto de tipo rioBean que contiene el registro 
	 * @throws Exception Excepción que puede ser lanzada
	 **/
	@Override
	public RioBean obtenerRio(Integer nid) throws Exception {
		return iMantRioDao.obtenerRio(nid);
	}
	
	/** 
	 * Realiza el registro de rios
	 * @param rioBean objeto del tipo RioBean que contiene el registro  
	 * @return Mapa de resultados
	 * @throws Exception Excepción que puede ser lanzada
	 **/
	@Override
	public Map<String, Object> grabarRio(RioBean rioBean) throws Exception {
		Map<String, Object> mapResultados = new HashMap<String, Object>();
		ValidaAbreviaturaBean validacionBean = iMantRioDao.validarAbrevMantRio(rioBean);
        if(!validacionBean.isBolAbreviatura() && !validacionBean.isBolNombreLargo()){
        	rioBean.setAbreviatura(rioBean.getAbreviatura().trim());
        	rioBean.setNombreLargo(rioBean.getNombreLargo().trim());
			iMantRioDao.grabarRio(rioBean);
			mapResultados.put("resultado", true);
		}
		else{
			String mensaje = "";
			if(validacionBean.isBolAbreviatura()){
				mensaje = Constants.VALIDACION_ABREVIATURA;
			}
			else if(validacionBean.isBolNombreLargo()){
				mensaje = mensaje + Constants.VALIDACION_NOMBRE_LARGO;
			}
			mapResultados.put("mensaje", mensaje);
			mapResultados.put("resultado", false);
		}
        return mapResultados;
	}

	/** 
	 * Realiza la modificación de rios
	 * @param rioBean objeto del tipo RioBean que contiene el registro 
	 * @param abreviaturaIsUpdate flag que nos indica si la abreviatura ha sido modificada
	 * @param nomlarIsUpdate flag que nos indica si el nombre largo ha sido modificado
	 * @return Mapa de resultados
	 * @throws Exception Excepción que puede ser lanzada
	 **/
	@Override
	public Map<String, Object> actualizarRio(RioBean rioBean, boolean abreviaturaIsUpdate, boolean nomlarIsUpdate) throws Exception {
		Map<String, Object> mapResultados = new HashMap<String, Object>();
		ValidaAbreviaturaBean validaBean = iMantRioDao.validarAbrevMantRio(rioBean);
		if(abreviaturaIsUpdate){
			if(!validaBean.isBolAbreviatura()){
				if(nomlarIsUpdate){
					if(!validaBean.isBolNombreLargo()){
						rioBean.setNombreLargo(rioBean.getNombreLargo().trim());
						iMantRioDao.actualizarRio(rioBean);
						mapResultados.put("resultado", true);
					}
					else{
						mapResultados.put("mensaje", Constants.VALIDACION_NOMBRE_LARGO);
						mapResultados.put("resultado", false);
					}
				}
				else{
					rioBean.setAbreviatura(rioBean.getAbreviatura().trim());
					iMantRioDao.actualizarRio(rioBean);
					mapResultados.put("resultado", true);
				}
			}
			else{
				mapResultados.put("mensaje", Constants.VALIDACION_ABREVIATURA);
				mapResultados.put("resultado", false);
			}
		}
		else if(nomlarIsUpdate){
			if(!validaBean.isBolNombreLargo()){
				rioBean.setNombreLargo(rioBean.getNombreLargo().trim());
				iMantRioDao.actualizarRio(rioBean);
				mapResultados.put("resultado", true);
			}
			else{
				mapResultados.put("mensaje", Constants.VALIDACION_NOMBRE_LARGO);
				mapResultados.put("resultado", false);
			}
		}
		else{
			iMantRioDao.actualizarRio(rioBean);
			mapResultados.put("resultado", true);
		}
		
		return mapResultados;
	}
	
	/**
	 * Realiza el cambío de estado de río
	 * @param rioBean objeto del tipo RioBean que contiene el registro 
	 * @throws Exception Excepción que puede ser lanzada
	 **/
	@Override
	public void inactivarRio(RioBean rioBean) throws Exception {
		iMantRioDao.inactivarRio(rioBean);
	}

	/**
	 * Obtiene la lista de todos los ríos activos registrados en la plataforma
	 * @return Lista de objetos de tipo SelectItemBean que contiene los datos del r+io
	 * @throws Exception Excepción que puede ser lanzada
	 */
	@Override
	public List<SelectItemBean> obtenerRiosActivos() throws Exception {
		List<RioBean> rios = iMantRioDao.obtenerRios(Constants.ACTIVE_STATE);
		List<SelectItemBean> result = new ArrayList<>();
		for(int i = 0; i < rios.size(); i++){
			SelectItemBean sib = new SelectItemBean();
			sib.setValue("" + rios.get(i).getIntCodigo());
			sib.setLabel(rios.get(i).getAbreviatura() + " - " + rios.get(i).getNombreLargo());
			result.add(sib);
		}
		return result;
	}

	/**
	 * Obtiene la lista de todos los ríos registrados en la plataforma
	 * @return Lista de objetos de tipo SelectItemBean que contiene los datos del r+io
	 * @throws Exception Excepción que puede ser lanzada
	 */
	@Override
	public List<SelectItemBean> obtenerRiosTodos() throws Exception {
		List<RioBean> rios = iMantRioDao.obtenerRios(null);
		List<SelectItemBean> result = new ArrayList<>();
		for(int i = 0; i < rios.size(); i++){
			SelectItemBean sib = new SelectItemBean();
			sib.setValue("" + rios.get(i).getIntCodigo());
			sib.setLabel(rios.get(i).getNombreLargo());
			result.add(sib);
		}
		return result;
	}
}
