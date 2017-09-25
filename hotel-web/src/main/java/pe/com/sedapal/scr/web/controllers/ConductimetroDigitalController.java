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
import pe.com.sedapal.scr.core.beans.ConductimetroDigitalBean;
import pe.com.sedapal.scr.core.beans.ConductimetroDigitalDetalleBean;
import pe.com.sedapal.scr.core.beans.PhmetroDigitalBean;
import pe.com.sedapal.scr.core.beans.PhmetroDigitalDetalleBean;
import pe.com.sedapal.scr.core.services.IConductimetroDigitalService;
import pe.com.sedapal.scr.web.common.Constants;
import pe.com.sedapal.scr.web.common.Util;

@Controller
@PropertySources(value = { @PropertySource(name = "props", value = {
		"classpath:application.properties" }, ignoreResourceNotFound = true) })
public class ConductimetroDigitalController {
	
	private static final Logger LOG = LoggerFactory.getLogger(Constants.PACKAGE);
	private boolean flagInsert;
	
	@Autowired
	IConductimetroDigitalService conductimetroDigitalService;
	
	@RequestMapping(value = "/conductimetroDigital", method = RequestMethod.GET)
	public String conductimetroDigital(HttpServletRequest request, HttpSession session,
			@ModelAttribute("conductimetroDigitalSearchBean") ConductimetroDigitalBean conductimetroDigitalSearchBean,
			@ModelAttribute("conductimetroDigitalEditBean") ConductimetroDigitalBean conductimetroDigitalEditBean,
			ModelMap model){

		return "conductimetroDigital/conductimetroDigital";
	}
	
	/*
	 * Método que permite realizar los filtros de búsqueda y luego mostrar la grilla páginada
	 * @RequestParam Se encarga de enviar los parámetros para los filtro de búsqueda
	 * @throws Exception, Excepción que puede ser lanzada
	 * */
	@RequestMapping(value = "/conductimetroDigital/pagination", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Map<String,Object>> obtenerDatos(@RequestParam Map<String,String> allRequestParams)
			throws Exception {
		try {
			ConductimetroDigitalBean conductimetroDigitalBean = new ConductimetroDigitalBean();
			Paginacion paginacion = new Paginacion();
			paginacion.setCantidadpag(Integer.parseInt(allRequestParams.get("length")));
			paginacion.setPagdesde(Integer.parseInt(allRequestParams.get("start")));
			paginacion.setColorderby( Integer.parseInt(allRequestParams.get("order[0][column]"))==0?Integer.parseInt(allRequestParams.get("order[0][column]"))+1:Integer.parseInt(allRequestParams.get("order[0][column]")));
			paginacion.setColorderbydir(allRequestParams.get("order[0][dir]"));
			
			if(allRequestParams.get("codigo")!=null && !"".equals(allRequestParams.get("codigo"))){
				conductimetroDigitalBean.setStrCodEquipo((String)allRequestParams.get("codigo"));
			}else{
				conductimetroDigitalBean.setStrCodEquipo("0");
			}

			Result result = conductimetroDigitalService.obtenerDatosEquipos(conductimetroDigitalBean, paginacion);
			
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
	 * Método que permite obtener un registro de la tabla de PHmetro Digital
	 * @ModelAttribute("conductimetroDigitalSearchBean") Objeto de tipo ConductimetroDigitalBean que se utiliza como atributo para la búsqueda en la tabla de Conductimetro
	 * @ModelAttribute("conductimetroDigitalEditBean") Esta clase sirve como soporte genérico de modelo para Servlet 
	 * Model es una interfaz de Map , que permite la abstracción completa de la tecnología de vista
	 * @PathVariable  identifíca al id como variable
	 * @throws Exception Excepción que puede ser lanzada
	 * */
		
	@RequestMapping(value = "/conductimetroDigitalGet/{id}", method = RequestMethod.GET)
	public String conductimetroDigitalGetPage(
			@ModelAttribute("conductimetroDigitalSearchBean") ConductimetroDigitalBean conductimetroDigitalSearchBean,
			@ModelAttribute("conductimetroDigitalEditBean") ConductimetroDigitalBean conductimetroDigitalEditBean, Model model,
			@PathVariable int id) throws Exception {
		
			if(id != -1){
				flagInsert=false;
				conductimetroDigitalEditBean = conductimetroDigitalService.obtenerConductimetroDigital(id);
			}else{
				flagInsert=true;
				conductimetroDigitalEditBean = new ConductimetroDigitalBean();  
			}
			model.addAttribute("conductimetroDigitalEditBean", conductimetroDigitalEditBean);
			return "conductimetroDigital/conductimetroDigitalEdit :: form-edit-conductimetroDigital";
	}
	
	/*
	 * Método que permite registrar y/o actualizar un registro de Conductimetro
	 * ModelMap es una interfaz de Map que permite la abstracción completa de la tecnología de vista
	 * @Return Objeto de tipo Result que contiene los resultados
	 * */
	@RequestMapping(value = "/conductimetroDigitalSave", method = RequestMethod.POST)
	public String insertConductimetroDigital(ModelMap model, HttpServletRequest request, HttpSession session,
			@ModelAttribute("phmetroDigitalEditBean") ConductimetroDigitalBean conductimetroDigitalEditBean){

		String strMensajeTipo = "";
		String strMensajeError = "";
		
		conductimetroDigitalEditBean.setIntEstado(Constants.ACTIVO);		
		conductimetroDigitalEditBean.setUsuarioCreacion(Util.getUserLoged());
		conductimetroDigitalEditBean.setUsuarioModificacion(Util.getUserLoged());
		try {
			if(flagInsert){				
				conductimetroDigitalEditBean.setPrograma(Constants.PROGRAMA_INS_CONDUCTIMETRO);
				int retorno = conductimetroDigitalService.grabarConductimetroDigital(conductimetroDigitalEditBean);
				if(retorno>0){
					model.addAttribute("mensajeTipo", "RegDuplicado");
					model.addAttribute("mensajeError", "DUPLICADO");					
					return "conductimetroDigital/conductimetroDigitalSave :: mensajesSave";
				}
			}else{	
				conductimetroDigitalEditBean.setPrograma(Constants.PROGRAMA_UPD_CONDUCTIMETRO);
				conductimetroDigitalEditBean.setStrCodEquipo(conductimetroDigitalEditBean.getStrCodEquipoHide());
				conductimetroDigitalService.actualizarConductimetroDigital(conductimetroDigitalEditBean);		
			}
			strMensajeTipo = ConstantsCommon.GRABADO_OK;
		} catch (Exception e) {
			strMensajeTipo = ConstantsCommon.GRABADO_NO_OK;
			strMensajeError = e.getMessage();
			e.printStackTrace();
		}
		
		model.addAttribute("mensajeTipo", strMensajeTipo);
		model.addAttribute("mensajeError", strMensajeError);
		return "conductimetroDigital/conductimetroDigitalSave :: mensajesSave";
	}
	
	/* 
	 * Este método elimina un registro de tabla de Conductimetro
	 * ModelMap es una interfaz de Map, que permite la abstracción completa de la tecnología de vista
	 * @param HttpServletRequest solicita la solicitud de envío a la vista
	 * @param HttpSession se utiliza para almacenar información entre diferentes peticiones HTTP. 
	 * @RequestParam inacId es el parámetro que sirve para cambiar de estado 
	 * */
	@RequestMapping(value = "/conductimetroDigital/inactivar", method = RequestMethod.POST)
	public String inactivarConductimetroDigital(ModelMap model, HttpServletRequest request, HttpSession session,
			@RequestParam int inacId) {

		String strMensajeTipo = "";
		String strMensajeError = "";		
		
		ConductimetroDigitalBean conductimetroDigitalBean = new ConductimetroDigitalBean();
		
		conductimetroDigitalBean.setIntEstado(Constants.INACTIVO);
		conductimetroDigitalBean.setIntCodigo(inacId);

		try {			

			conductimetroDigitalService.inactivarConductimetroDigital(conductimetroDigitalBean);
			strMensajeTipo = ConstantsCommon.INACTIVADO_OK;
		} catch (Exception e) {
			strMensajeTipo = ConstantsCommon.INACTIVADO_NO_OK;
			strMensajeError = e.getMessage();
			e.printStackTrace();
		}
		
		model.addAttribute("mensajeTipo", strMensajeTipo);
		model.addAttribute("mensajeError", strMensajeError);

		return "conductimetroDigital/conductimetroDigitalSave :: mensajesSave";

	}	
	
	/*
	 * Método que permite obtener un registro de la tabla de Conductimetro
	 * @ModelAttribute("conductimetroDigitalSearchBean") Objeto de tipo ConductimetroDigitalBean que se utiliza como atributo para la búsqueda en la tabla de Conductimetro
	 * @ModelAttribute("conductimetroDigitalEditBean") Esta clase sirve como soporte genérico de modelo para Servlet 
	 * Model es una interfaz de Map , que permite la abstracción completa de la tecnología de vista
	 * @PathVariable  identifíca al id como variable
	 * @throws Exception Excepción que puede ser lanzada
	 * */
		
	@RequestMapping(value = "/conductimetroDigitalDetalleGet/{id}", method = RequestMethod.GET)
	public String conductimetroDigitalDetalleGetPage(
			@ModelAttribute("conductimetroDigitalDetalleSearchBean") ConductimetroDigitalBean conductimetroDigitalDetalleSearchBean,
			@ModelAttribute("conductimetroDigitalDetalleEditBean") ConductimetroDigitalBean conductimetroDigitalDetalleEditBean, Model model,
			@PathVariable int id) throws Exception {
		
			if(id != -1){
				flagInsert=false;
				conductimetroDigitalDetalleEditBean = conductimetroDigitalService.obtenerConductimetroDigital(id);
			}else{
				flagInsert=true;
				conductimetroDigitalDetalleEditBean = new ConductimetroDigitalBean();  
			}
			model.addAttribute("conductimetroDigitalDetalleEditBean", conductimetroDigitalDetalleEditBean);
			return "conductimetroDigital/conductimetroDigitalDetalle :: form-edit-conductimetroDigitalDetalle";
	}
	
	/*
	 * Método que permite realizar los filtros de búsqueda y luego mostrar la grilla páginada
	 * @RequestParam Se encarga de enviar los parámetros para los filtro de búsqueda
	 * @throws Exception, Excepción que puede ser lanzada
	 * */
	@RequestMapping(value = "/conductimetroDigitalDetalle/pagination", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Map<String,Object>> obtenerDatosDetalle(@RequestParam Map<String,String> allRequestParams)
			throws Exception {
		try {
			ConductimetroDigitalDetalleBean conductimetroDigitalDetalleBean = new ConductimetroDigitalDetalleBean();
			Paginacion paginacion = new Paginacion();
			paginacion.setCantidadpag(Integer.parseInt(allRequestParams.get("length")));
			paginacion.setPagdesde(Integer.parseInt(allRequestParams.get("start")));
			paginacion.setColorderby( Integer.parseInt(allRequestParams.get("order[0][column]"))==0?Integer.parseInt(allRequestParams.get("order[0][column]"))+1:Integer.parseInt(allRequestParams.get("order[0][column]")));
			paginacion.setColorderbydir(allRequestParams.get("order[0][dir]"));
			
			if(allRequestParams.get("codigo")!=null && !"".equals(allRequestParams.get("codigo"))){
				conductimetroDigitalDetalleBean.setIntIdConductimetro(Integer.parseInt(allRequestParams.get("codigo")));

			}else{
				conductimetroDigitalDetalleBean.setIntIdConductimetro(0);
			}

			Result result = conductimetroDigitalService.obtenerDatosEquiposDetalle(conductimetroDigitalDetalleBean, paginacion);
			
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
	 * Método que permite obtener un registro de la tabla de detalle de PHmetro Digital
	 * @ModelAttribute("phmetroDigitalDetalleSearchBean") Objeto de tipo PhmetroDigitalBean que se utiliza como atributo para la búsqueda en la tabla  de detalle de PHmetro Digital
	 * @ModelAttribute("phmetroDigitalDetalleEditBean") Esta clase sirve como soporte genérico de modelo para Servlet 
	 * Model es una interfaz de Map , que permite la abstracción completa de la tecnología de vista
	 * @PathVariable  identifíca al id como variable
	 * @throws Exception Excepción que puede ser lanzada
	 * */
		
	@RequestMapping(value = "/conductimetroDigitalDetalleEditGet/{id}", method = RequestMethod.GET)
	public String phmetroDigitalDetalleEditGetPage(
			@ModelAttribute("conductimetroDigitalDetalleSearchBean") ConductimetroDigitalDetalleBean conductimetroDigitalDetalleSearchBean,
			@ModelAttribute("conductimetroDigitalDetalleEditBean") ConductimetroDigitalDetalleBean conductimetroDigitalDetalleEditBean, Model model,
			@PathVariable int id) throws Exception {
		
			conductimetroDigitalDetalleEditBean = new ConductimetroDigitalDetalleBean();  
			
			model.addAttribute("conductimetroDigitalDetalleEditBean", conductimetroDigitalDetalleEditBean);
			return "conductimetroDigital/conductimetroDigitalDetalleEdit :: form-edit-conductimetroDigitalDetalleEdit";
	}
	
	/*
	 * Método que permite registrar y/o actualizar un registro de Conductimetro
	 * ModelMap es una interfaz de Map que permite la abstracción completa de la tecnología de vista
	 * @Return Objeto de tipo Result que contiene los resultados
	 * */
	@RequestMapping(value = "/conductimetroDigitalDetalleEditSave", method = RequestMethod.POST)
	public String insertConductimetroDigitalDetalle(ModelMap model, HttpServletRequest request, HttpSession session,
			@ModelAttribute("conductimetroDigitalDetalleEditBean") ConductimetroDigitalDetalleBean conductimetroDigitalDetalleEditBean){

		String strMensajeTipo = "";
		String strMensajeError = "";
		
		conductimetroDigitalDetalleEditBean.setIntEstado(Constants.ACTIVO);		
		conductimetroDigitalDetalleEditBean.setUsuarioCreacion(Util.getUserLoged());
		conductimetroDigitalDetalleEditBean.setUsuarioModificacion(Util.getUserLoged());
		try {
					
			conductimetroDigitalDetalleEditBean.setPrograma(Constants.PROGRAMA_INS_CONDUCTIMETRO_EDIT);
			conductimetroDigitalService.grabarConductimetroDigitalDetalle(conductimetroDigitalDetalleEditBean);
				
			
			//strMensajeTipo = ConstantsCommon.GRABADO_OK;
			strMensajeTipo = "grabadoOkSubForm";
		} catch (Exception e) {
			strMensajeTipo = ConstantsCommon.GRABADO_NO_OK;
			strMensajeError = e.getMessage();
			e.printStackTrace();
		}
		
		model.addAttribute("mensajeTipo", strMensajeTipo);
		model.addAttribute("mensajeError", strMensajeError);
		return "conductimetroDigital/conductimetroDigitalSave :: mensajesSave";
	}

	/* 
	 * Este método elimina un registro de tabla detalle de Conductimetro
	 * ModelMap es una interfaz de Map, que permite la abstracción completa de la tecnología de vista
	 * @param HttpServletRequest solicita la solicitud de envío a la vista
	 * @param HttpSession se utiliza para almacenar información entre diferentes peticiones HTTP. 
	 * @RequestParam inacId es el parámetro que sirve para cambiar de estado 
	 * */
	@RequestMapping(value = "/conductimetroDigitalDetalle/inactivar", method = RequestMethod.POST)
	public String inactivarConductimetroDigitalDetalle(ModelMap model, HttpServletRequest request, HttpSession session,
			@RequestParam int inacIdDetalle) {

		String strMensajeTipo = "";
		String strMensajeError = "";		
		
		ConductimetroDigitalDetalleBean conductimetroDigitalDetalleBean = new ConductimetroDigitalDetalleBean();
		
		conductimetroDigitalDetalleBean.setIntEstado(Constants.INACTIVO);
		conductimetroDigitalDetalleBean.setIntIdConductimetro(inacIdDetalle);

		try {			

			conductimetroDigitalService.inactivarConductimetroDigitalDetalle(conductimetroDigitalDetalleBean);
			//strMensajeTipo = ConstantsCommon.INACTIVADO_OK;
			strMensajeTipo = "inactivadoSubFormOk";
		} catch (Exception e) {
			strMensajeTipo = ConstantsCommon.INACTIVADO_NO_OK;
			strMensajeError = e.getMessage();
			e.printStackTrace();
		}
		
		model.addAttribute("mensajeTipo", strMensajeTipo);
		model.addAttribute("mensajeError", strMensajeError);

		return "conductimetroDigital/conductimetroDigitalSave :: mensajesSave";
	}
}
