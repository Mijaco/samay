package pe.com.sedapal.scr.web.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.sedapal.common.core.beans.Paginacion;
import pe.com.sedapal.common.core.beans.Result;
import pe.com.sedapal.common.core.utils.ConstantsCommon;
import pe.com.sedapal.scr.core.beans.FormularioDetalle242;
import pe.com.sedapal.scr.core.beans.FormularioHeader242;
import pe.com.sedapal.scr.core.common.ConstantsLaboratorio;
import pe.com.sedapal.scr.core.services.IFormulario242Service;
import pe.com.sedapal.scr.web.common.Constants;
import pe.com.sedapal.scr.web.common.Util;


@Controller
@PropertySources(value = { @PropertySource(name = "props", value = {
		"classpath:application.properties" }, ignoreResourceNotFound = true) })
public class Formulario242Controller {

	private static final Logger LOG = LoggerFactory.getLogger(Constants.PACKAGE);
	private boolean flagInsert;
	private boolean flagInsert2;
	
	@Autowired
	IFormulario242Service iformulario242Service;
	
	@RequestMapping(value = "/formulario242", method = RequestMethod.GET)
	public String turbidimetroDigital(HttpServletRequest request, HttpSession session,
			@ModelAttribute("formularioHeader242EditBean") FormularioHeader242 formularioHeader242EditBean,
			ModelMap model){

		return "formulario242/formulario242";
	}
	

	@RequestMapping(value = "/formulario242/pagination", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Map<String,Object>> obtenerDatos(@RequestParam Map<String,String> allRequestParams)
			throws Exception {
		try {
			FormularioHeader242 formularioHeader242 = new FormularioHeader242();
			Paginacion paginacion = new Paginacion();
			paginacion.setCantidadpag(Integer.parseInt(allRequestParams.get("length")));
			paginacion.setPagdesde(Integer.parseInt(allRequestParams.get("start")));
			paginacion.setColorderby( Integer.parseInt(allRequestParams.get("order[0][column]"))==0?Integer.parseInt(allRequestParams.get("order[0][column]"))+1:Integer.parseInt(allRequestParams.get("order[0][column]")));
			paginacion.setColorderbydir(allRequestParams.get("order[0][dir]"));
			
			if(allRequestParams.get("pFecha")!=null && !"".equals(allRequestParams.get("pFecha"))){ 
				formularioHeader242.setStrFechaMuestreo(allRequestParams.get("pFecha"));
			}

			Result result = iformulario242Service.getListadoFormularioHeader(formularioHeader242, paginacion);
			
			Map<String,Object> dtResponse = new HashMap<String, Object>();
			dtResponse.put("draw", allRequestParams.get("draw"));
			dtResponse.put("recordsTotal", result.getRecords());
			dtResponse.put("recordsFiltered", result.getRecords());
			dtResponse.put("data", result.getData());
			
			return new ResponseEntity<Map<String,Object>>(dtResponse, HttpStatus.OK);
		} catch (Exception e) {			
			LOG.error(e.getMessage(), e);	
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
		
	@RequestMapping(value = "/formulario242Get/{id}", method = RequestMethod.GET)
	public String turbidimetroDigitalGetPage(
			@ModelAttribute("formularioHeader242SearchBean") FormularioHeader242 formularioHeader242SearchBean,
			@ModelAttribute("formularioHeader242EditBean") FormularioHeader242 formularioHeader242EditBean, Model model,
			@PathVariable int id) throws Exception {
		
			if(id>0){
				flagInsert=false;
				formularioHeader242EditBean = iformulario242Service.getFormularioHeader(id);
			}else{
				flagInsert=true;
				formularioHeader242EditBean = new FormularioHeader242();  
			}
			model.addAttribute("formularioHeader242EditBean", formularioHeader242EditBean);
			return "formulario242/formulario242Edit :: form-edit-form242";
	}
	
	
	@RequestMapping(value = "/formularioDetalleGet/{id}", method = RequestMethod.GET)
	public String turbidimetroDigitalVerificacionGetPage(
			@ModelAttribute("formularioDetalle242") FormularioDetalle242 formularioDetalle242, Model model,
			@PathVariable int id) throws Exception {
		
		if(id>0){
			formularioDetalle242 = iformulario242Service.getFormularioDetalle(id);
			flagInsert2=false;
		}
		else {
			//INSERT
			flagInsert2=true;
		    formularioDetalle242 = new FormularioDetalle242();  
		}
		model.addAttribute("formularioDetalle242", formularioDetalle242);
		return "formulario242/formularioDetalle242Edit :: form-edit-detalle";
	}
	
	
	@RequestMapping(value = "/formularioHeaderSave", method = RequestMethod.POST)
	public String insertTurbidimetroDigital(ModelMap model, HttpServletRequest request, HttpSession session,
			@ModelAttribute("formularioHeader242EditBean") FormularioHeader242 formularioHeader242EditBean){

		String strMensajeTipo = "";
		String strMensajeError = "";
		
		formularioHeader242EditBean.setPrograma(Util.getPageCall());
		formularioHeader242EditBean.setUsuarioCreacion(Util.getUserLoged());
		formularioHeader242EditBean.setUsuarioModificacion(Util.getUserLoged());
		try {
			if(flagInsert){				
				iformulario242Service.grabarFormularioHeader(formularioHeader242EditBean);							
			}else{
				iformulario242Service.updateFormularioHeader(formularioHeader242EditBean);
			}
			
			strMensajeTipo = ConstantsCommon.GRABADO_OK;
			
		} catch (Exception e) {
			strMensajeTipo = ConstantsCommon.GRABADO_NO_OK;
			strMensajeError = e.getMessage();
			e.printStackTrace();
		}
		
		model.addAttribute("mensajeTipo", strMensajeTipo);
		model.addAttribute("mensajeError", strMensajeError);
		return "formulario242/formulario242Save :: mensajesSave";
	}
	
	
	@RequestMapping(value = "/formularioDetalleSave", method = RequestMethod.POST)
	public String insertTurbidimetroDigitalVerificacion(ModelMap model, HttpServletRequest request, HttpSession session,
			@ModelAttribute("formularioDetalle242") FormularioDetalle242 formularioDetalle242){

		String strMensajeTipo = "";
		String strMensajeError = "";
		
		formularioDetalle242.setPrograma(Util.getPageCall());
		formularioDetalle242.setUsuarioCreacion(Util.getUserLoged());
		formularioDetalle242.setUsuarioModificacion(Util.getUserLoged());
		
		try {
			if(flagInsert2){	
				iformulario242Service.grabarFormularioDetalle(formularioDetalle242);
			}else{	
				iformulario242Service.updateFormularioDetalle(formularioDetalle242);		
			}
			
			strMensajeTipo = "grabadoOkSubForm";
			
		} catch (Exception e) {
			strMensajeTipo = ConstantsCommon.GRABADO_NO_OK;
			strMensajeError = e.getMessage();
			e.printStackTrace();
		}
		
		model.addAttribute("mensajeTipo", strMensajeTipo);
		model.addAttribute("mensajeError", strMensajeError);
		return "formulario242/formulario242Save :: mensajesSave";
	}
	

	@RequestMapping(value = "/formularioDetalle242/pagination", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Map<String,Object>> obtenerDatosVerificacion(@RequestParam Map<String,String> allRequestParams)
			throws Exception {
		try {

			FormularioDetalle242 formularioDetalle242 = new FormularioDetalle242();
			Paginacion paginacion = new Paginacion();
			paginacion.setCantidadpag(Integer.parseInt(allRequestParams.get("length")));
			paginacion.setPagdesde(Integer.parseInt(allRequestParams.get("start")));
			paginacion.setColorderby( Integer.parseInt(allRequestParams.get("order[0][column]"))==0?Integer.parseInt(allRequestParams.get("order[0][column]"))+1:Integer.parseInt(allRequestParams.get("order[0][column]")));
			paginacion.setColorderbydir(allRequestParams.get("order[0][dir]"));
			
			if(allRequestParams.get("codigo")!=null && !"0".equals(allRequestParams.get("codigo")) && !"".equals(allRequestParams.get("codigo"))){

				formularioDetalle242.setCodigoHeader(Integer.parseInt(allRequestParams.get("codigo")));
			}

			Result result = iformulario242Service.getListadoFormularioDetalle(formularioDetalle242, paginacion);
			
			Map<String,Object> dtResponse = new HashMap<String, Object>();
			if(result != null){				
			dtResponse.put("draw", allRequestParams.get("draw"));
			dtResponse.put("recordsTotal", result.getRecords());
			dtResponse.put("recordsFiltered", result.getRecords());
			dtResponse.put("data", result.getData());
			}
			
			return new ResponseEntity<Map<String,Object>>(dtResponse, HttpStatus.OK);
		} catch (Exception e) {			
			LOG.error(e.getMessage(), e);	
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	/* 
//	 * Este método elimina un registro de tabla Verificacion de equipos del formulario hijo
//	 * ModelMap es una interfaz de Map, que permite la abstracción completa de la tecnología de vista
//	 * @param HttpServletRequest solicita la solicitud de envío a la vista
//	 * @param HttpSession se utiliza para almacenar información entre diferentes peticiones HTTP. 
//	 * @RequestParam inacId es el parámetro que sirve para cambiar de estado 
//	 * */
	@RequestMapping(value = "/formularioDetalle/inactivar", method = RequestMethod.POST)
	public String inactivarFormularioDetalle(ModelMap model, HttpServletRequest request, HttpSession session, 
			@RequestParam int inactivarDetalleID) {

		String strMensajeTipo = "";
		String strMensajeError = "";		
		
		FormularioDetalle242 formularioDetalle242 = new FormularioDetalle242(); 
		formularioDetalle242.setEstado(0);
		formularioDetalle242.setIdDetalle(inactivarDetalleID);

		try {			
			iformulario242Service.inactivarFormularioDetalle(formularioDetalle242);
			strMensajeTipo = ConstantsCommon.INACTIVADO_OK;
			
		} catch (Exception e) {
			strMensajeTipo = ConstantsCommon.INACTIVADO_NO_OK;
			strMensajeError = e.getMessage();
			e.printStackTrace();
		}
		
		model.addAttribute("mensajeTipo", strMensajeTipo);
		model.addAttribute("mensajeError", strMensajeError);

		return "formulario242/formulario242Save :: mensajesSave";
	}
	
	@RequestMapping(value = "/formularioHeader/inactivar", method = RequestMethod.POST)
	public String inactivarFormularioHeader(ModelMap model, HttpServletRequest request, HttpSession session, 
			@RequestParam int inacIdHeader) {

		String strMensajeTipo = "";
		String strMensajeError = "";		
		
		FormularioHeader242 formularioHeader242 = new FormularioHeader242(); 
		formularioHeader242.setEstado(0);
		formularioHeader242.setIdHeader(inacIdHeader);

		try {			
			iformulario242Service.inactivarFormularioHeader(formularioHeader242);
			strMensajeTipo = ConstantsCommon.INACTIVADO_OK;
			model.addAttribute("mensajeTipo", "inactivadoOkSubForm");
		} catch (Exception e) {
			strMensajeTipo = ConstantsCommon.INACTIVADO_NO_OK;
			strMensajeError = e.getMessage();
			e.printStackTrace();
		}
		
		model.addAttribute("mensajeTipo", strMensajeTipo);
		model.addAttribute("mensajeError", strMensajeError);

		return "formulario242/formulario242Save :: mensajesSave";
	}
	
	
}
