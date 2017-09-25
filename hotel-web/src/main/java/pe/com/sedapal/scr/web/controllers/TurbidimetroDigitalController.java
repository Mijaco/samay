package pe.com.sedapal.scr.web.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import pe.com.sedapal.scr.core.beans.TurbidimetroDigitalBean;
import pe.com.sedapal.scr.core.beans.TurbidimetroDigitalVerificacionBean;
import pe.com.sedapal.scr.core.services.ITurbidimetroDigitalService;
import pe.com.sedapal.scr.web.common.Constants;
import pe.com.sedapal.scr.web.common.Util;


@Controller
@PropertySources(value = { @PropertySource(name = "props", value = {
		"classpath:application.properties" }, ignoreResourceNotFound = true) })
public class TurbidimetroDigitalController {

	private static final Logger LOG = LoggerFactory.getLogger(Constants.PACKAGE);
	private boolean flagInsert;
	
	@Autowired
	ITurbidimetroDigitalService turbidimetroDigitalService;
	
	@RequestMapping(value = "/turbidimetroDigital", method = RequestMethod.GET)
	public String turbidimetroDigital(HttpServletRequest request, HttpSession session,
			@ModelAttribute("turbidimetroDigitalSearchBean") TurbidimetroDigitalBean turbidimetroDigitalSearchBean,
			@ModelAttribute("turbidimetroDigitalEditBean") TurbidimetroDigitalBean turbidimetroDigitalEditBean,
			ModelMap model){

		return "turbidimetroDigital/turbidimetroDigital";
	}
	
	/*
	 * Método que permite realizar los filtros de búsqueda y luego mostrar la grilla páginada
	 * @RequestParam Se encarga de enviar los parámetros para los filtro de búsqueda
	 * @throws Exception, Excepción que puede ser lanzada
	 * */
	@RequestMapping(value = "/turbidimetroDigital/pagination", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Map<String,Object>> obtenerDatos(@RequestParam Map<String,String> allRequestParams)
			throws Exception {
		try {
			TurbidimetroDigitalBean turbidimetroDigitalBean = new TurbidimetroDigitalBean();
			Paginacion paginacion = new Paginacion();
			paginacion.setCantidadpag(Integer.parseInt(allRequestParams.get("length")));
			paginacion.setPagdesde(Integer.parseInt(allRequestParams.get("start")));
			paginacion.setColorderby( Integer.parseInt(allRequestParams.get("order[0][column]"))==0?Integer.parseInt(allRequestParams.get("order[0][column]"))+1:Integer.parseInt(allRequestParams.get("order[0][column]")));
			paginacion.setColorderbydir(allRequestParams.get("order[0][dir]"));
			
			if(allRequestParams.get("codigo")!=null && !"".equals(allRequestParams.get("codigo"))){ //campo codigo viene desde turbidimetroDigitalTable
				turbidimetroDigitalBean.setStrCodEquipo((String)allRequestParams.get("codigo"));
			}else{
				turbidimetroDigitalBean.setStrCodEquipo("0");
			}

			Result result = turbidimetroDigitalService.obtenerDatosEquipos(turbidimetroDigitalBean, paginacion);
			
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
	
	/*
	 * Método que permite obtener un registro de la tabla Poisson por id
	 * @ModelAttribute("turbidimetroDigitalSearchBean") Objeto de tipo turbidimetroDigitalBean que se utiliza como atributo para la búsqueda de tablas Poisson
	 * @ModelAttribute("turbidimetroDigitalEditBean") Esta clase sirve como soporte genérico de modelo para Servlet 
	 * Model es una interfaz de Map , que permite la abstracción completa de la tecnología de vista
	 * @PathVariable  identifíca al id como variable
	 * @throws Exception Excepción que puede ser lanzada
	 * */
		
	@RequestMapping(value = "/turbidimetroDigitalGet/{id}", method = RequestMethod.GET)
	public String turbidimetroDigitalGetPage(
			@ModelAttribute("turbidimetroDigitalSearchBean") TurbidimetroDigitalBean turbidimetroDigitalSearchBean,
			@ModelAttribute("turbidimetroDigitalEditBean") TurbidimetroDigitalBean turbidimetroDigitalEditBean, Model model,
			@PathVariable int id) throws Exception {
		
			if(id>0){
				flagInsert=false;
				turbidimetroDigitalEditBean = turbidimetroDigitalService.obtenerVerificacionEquipo(id);
			}else{
				flagInsert=true;
				turbidimetroDigitalEditBean = new TurbidimetroDigitalBean();  
			}
			model.addAttribute("turbidimetroDigitalEditBean", turbidimetroDigitalEditBean);
			return "turbidimetroDigital/turbidimetroDigitalEdit :: form-edit-turbidimetroDigital";
	}
	
	/*
	 * Método que permite registrar y/o actualizar un registro de Verificacion de Equipos
	 * ModelMap es una interfaz de Map que permite la abstracción completa de la tecnología de vista
	 * @Return Objeto de tipo Result que contiene los resultados
	 * */
	@RequestMapping(value = "/turbidimetroDigitalSave", method = RequestMethod.POST)
	public String insertTurbidimetroDigital(ModelMap model, HttpServletRequest request, HttpSession session,
			@ModelAttribute("turbidimetroDigitalEditBean") TurbidimetroDigitalBean turbidimetroDigitalEditBean){

		String strMensajeTipo = "";
		String strMensajeError = "";
		
		turbidimetroDigitalEditBean.setIntEstado(Constants.ACTIVO);
		
		turbidimetroDigitalEditBean.setUsuarioCreacion(Util.getUserLoged());
		turbidimetroDigitalEditBean.setUsuarioModificacion(Util.getUserLoged());
		try {
			if(flagInsert){	
				turbidimetroDigitalEditBean.setPrograma(Constants.PROGRAMA_INS_TURBIDI);
				int retorno = turbidimetroDigitalService.grabarVerificacionEquipo(turbidimetroDigitalEditBean);		
				if(retorno>0){
					model.addAttribute("mensajeTipo", "RegDuplicado");
					model.addAttribute("mensajeError", "DUPLICADO");					
					return "turbidimetroDigital/turbidimetroDigitalSave :: mensajesSave";
				}
			}else{	
				turbidimetroDigitalEditBean.setPrograma(Constants.PROGRAMA_UPD_TURBIDI);
				turbidimetroDigitalEditBean.setStrCodEquipo(turbidimetroDigitalEditBean.getStrCodEquipoHide());
				turbidimetroDigitalService.actualizarVerificacionEquipo(turbidimetroDigitalEditBean);		
			}
			strMensajeTipo = ConstantsCommon.GRABADO_OK;
		} catch (Exception e) {
			strMensajeTipo = ConstantsCommon.GRABADO_NO_OK;
			strMensajeError = e.getMessage();
			e.printStackTrace();
		}
		
		model.addAttribute("mensajeTipo", strMensajeTipo);
		model.addAttribute("mensajeError", strMensajeError);
		return "turbidimetroDigital/turbidimetroDigitalSave :: mensajesSave";
	}
	
	/* 
	 * Este método elimina un registro de tabla Verificacion de equipos
	 * ModelMap es una interfaz de Map, que permite la abstracción completa de la tecnología de vista
	 * @param HttpServletRequest solicita la solicitud de envío a la vista
	 * @param HttpSession se utiliza para almacenar información entre diferentes peticiones HTTP. 
	 * @RequestParam inacId es el parámetro que sirve para cambiar de estado 
	 * */
	@RequestMapping(value = "/turbidimetroDigital/inactivar", method = RequestMethod.POST)
	public String inactivarTurbidimetroDigital(ModelMap model, HttpServletRequest request, HttpSession session,
			@RequestParam int inacId) {

		String strMensajeTipo = "";
		String strMensajeError = "";		
		
		TurbidimetroDigitalBean turbidimetroDigitalBean = new TurbidimetroDigitalBean();
		
		turbidimetroDigitalBean.setIntEstado(Constants.INACTIVO);
		turbidimetroDigitalBean.setIntCodigo(inacId);

		try {			

			turbidimetroDigitalService.inactivarVerificacionEquipo(turbidimetroDigitalBean);;
			strMensajeTipo = ConstantsCommon.INACTIVADO_OK;
		} catch (Exception e) {
			strMensajeTipo = ConstantsCommon.INACTIVADO_NO_OK;
			strMensajeError = e.getMessage();
			e.printStackTrace();
		}
		
		model.addAttribute("mensajeTipo", strMensajeTipo);
		model.addAttribute("mensajeError", strMensajeError);

		return "turbidimetroDigital/turbidimetroDigitalSave :: mensajesSave";

	}	
	
	/*
	 * Muestra grilla páginada
	 * @RequestParam Se encarga de enviar los parámetros para los filtro de búsqueda, en este caso es estático
	 * @throws Exception, Excepción que puede ser lanzada
	 * */
	@RequestMapping(value = "/turbidimetroDigitalVerif/pagination", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Map<String,Object>> obtenerDatosVerificacion(@RequestParam Map<String,String> allRequestParams)
			throws Exception {
		try {
			TurbidimetroDigitalVerificacionBean turbidimetroDigitalVerificacionBean = new TurbidimetroDigitalVerificacionBean();
			Paginacion paginacion = new Paginacion();
			paginacion.setCantidadpag(Integer.parseInt(allRequestParams.get("length")));
			paginacion.setPagdesde(Integer.parseInt(allRequestParams.get("start")));
			paginacion.setColorderby( Integer.parseInt(allRequestParams.get("order[0][column]"))==0?Integer.parseInt(allRequestParams.get("order[0][column]"))+1:Integer.parseInt(allRequestParams.get("order[0][column]")));
			paginacion.setColorderbydir(allRequestParams.get("order[0][dir]"));
			
			if(allRequestParams.get("codigo")!=null && !"0".equals(allRequestParams.get("codigo")) && !"".equals(allRequestParams.get("codigo"))){
				turbidimetroDigitalVerificacionBean.setIntCodigoTurbDigital(Integer.parseInt(allRequestParams.get("codigo")));
			}else{
				turbidimetroDigitalVerificacionBean.setIntCodigoTurbDigital(0);
			}

			Result result = turbidimetroDigitalService.obtenerDatosEquiposVerificacion(turbidimetroDigitalVerificacionBean, paginacion);
			
			Map<String,Object> dtResponse = new HashMap<String, Object>();
			if(result != null){				
			dtResponse.put("draw", allRequestParams.get("draw"));
			dtResponse.put("recordsTotal", result.getRecords()+1);
			dtResponse.put("recordsFiltered", result.getRecords()+1);
			dtResponse.put("data", result.getData());
			}
			
			return new ResponseEntity<Map<String,Object>>(dtResponse, HttpStatus.OK);
		} catch (Exception e) {			
			LOG.error(e.getMessage(), e);	
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/turbidimetroDigitalVerificacionGet/{id}", method = RequestMethod.GET)
	public String turbidimetroDigitalVerificacionGetPage(
			@ModelAttribute("turbidimetroDigitalVerifSearchBean") TurbidimetroDigitalVerificacionBean turbidimetroDigitalVerifSearchBean,
			@ModelAttribute("turbidimetroDigitalVerifEditBean") TurbidimetroDigitalVerificacionBean turbidimetroDigitalVerifEditBean, Model model,
			@PathVariable int id) throws Exception {
		
				turbidimetroDigitalVerifEditBean = new TurbidimetroDigitalVerificacionBean();  
			
				model.addAttribute("turbidimetroDigitalVerifEditBean", turbidimetroDigitalVerifEditBean);
				return "turbidimetroDigital/turbidimetroDigitalVerifiEdit :: form-edit-turbidimetroDigitalVerif";
	}
	
	/*
	 * Método que permite registrar y/o actualizar un registro de Verificacion de Equipos del formulario hijo
	 * ModelMap es una interfaz de Map que permite la abstracción completa de la tecnología de vista
	 * @Return Objeto de tipo Result que contiene los resultados
	 * */
	@RequestMapping(value = "/turbidimetroDigitalVerificacionSave", method = RequestMethod.POST)
	public String insertTurbidimetroDigitalVerificacion(ModelMap model, HttpServletRequest request, HttpSession session,
			@ModelAttribute("turbidimetroDigitalVerifEditBean") TurbidimetroDigitalVerificacionBean turbidimetroDigitalVerifEditBean){

		String strMensajeTipo = "";
		String strMensajeError = "";
		
		turbidimetroDigitalVerifEditBean.setIntEstado(Constants.ACTIVO);
		turbidimetroDigitalVerifEditBean.setPrograma(Constants.PROGRAMA_INS_TURBIDI_EDIT);
		turbidimetroDigitalVerifEditBean.setUsuarioCreacion(Util.getUserLoged());
		turbidimetroDigitalVerifEditBean.setUsuarioModificacion(Util.getUserLoged());
		try {
				
			turbidimetroDigitalService.grabarVerificacionEquipoForm(turbidimetroDigitalVerifEditBean);								
			
			//strMensajeTipo = ConstantsCommon.GRABADO_OK;
			model.addAttribute("mensajeTipo", "grabadoOkSubForm");
		} catch (Exception e) {
			strMensajeTipo = ConstantsCommon.GRABADO_NO_OK;
			strMensajeError = e.getMessage();
			e.printStackTrace();
		}
		
		return "turbidimetroDigital/turbidimetroDigitalSave :: mensajesSave";
	}
	
	/* 
	 * Este método elimina un registro de tabla Verificacion de equipos del formulario hijo
	 * ModelMap es una interfaz de Map, que permite la abstracción completa de la tecnología de vista
	 * @param HttpServletRequest solicita la solicitud de envío a la vista
	 * @param HttpSession se utiliza para almacenar información entre diferentes peticiones HTTP. 
	 * @RequestParam inacId es el parámetro que sirve para cambiar de estado 
	 * */
	@RequestMapping(value = "/turbidimetroDigitalVerificacion/inactivar", method = RequestMethod.POST)
	public String inactivarTurbidimetroDigitalVerificacion(ModelMap model, HttpServletRequest request, HttpSession session,
			@RequestParam int inacIdVerif) {

		String strMensajeTipo = "";
		String strMensajeError = "";		
		
		TurbidimetroDigitalVerificacionBean turbidimetroDigitalVerificacionBean = new TurbidimetroDigitalVerificacionBean();
		
		turbidimetroDigitalVerificacionBean.setIntEstado(Constants.INACTIVO);
		turbidimetroDigitalVerificacionBean.setIntIdVerificacion(inacIdVerif);

		try {			
			turbidimetroDigitalService.inactivarVerificacionEquipoForm(turbidimetroDigitalVerificacionBean);;
			//strMensajeTipo = ConstantsCommon.INACTIVADO_OK;
			model.addAttribute("mensajeTipo", "inactivadoOkSubForm");
		} catch (Exception e) {
			strMensajeTipo = ConstantsCommon.INACTIVADO_NO_OK;
			strMensajeError = e.getMessage();
			e.printStackTrace();
		}
		
		//model.addAttribute("mensajeTipo", strMensajeTipo);
		model.addAttribute("mensajeError", strMensajeError);

		return "turbidimetroDigital/turbidimetroDigitalSave :: mensajesSave";

	}	
}
