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
import pe.com.sedapal.scr.core.beans.Formulario314;
import pe.com.sedapal.scr.core.common.ConstantsLaboratorio;
import pe.com.sedapal.scr.core.services.IFormulario314Service;
import pe.com.sedapal.scr.web.common.Constants;
import pe.com.sedapal.scr.web.common.Util;



@Controller
@PropertySources(value = { @PropertySource(name = "props", value = {
		"classpath:application.properties" }, ignoreResourceNotFound = true) })
public class Formulario314Controller {

	private static final Logger LOG = LoggerFactory.getLogger(Constants.PACKAGE);
	private boolean flagInsert;
	
	@Autowired
	IFormulario314Service iformulario314Service;
	
	@RequestMapping(value = "/formulario314", method = RequestMethod.GET)
	public String formulario058(HttpServletRequest request, HttpSession session,
			@ModelAttribute("formulario314") Formulario314 formulario314,
			ModelMap model){

		return "formulario314/formulario314";
	}
	

	@RequestMapping(value = "/formulario314/pagination", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Map<String,Object>> obtenerDatos(@RequestParam Map<String,String> allRequestParams)
			throws Exception {
		try {
			Formulario314 formulario314 = new Formulario314();
			Paginacion paginacion = new Paginacion();
			paginacion.setCantidadpag(Integer.parseInt(allRequestParams.get("length")));
			paginacion.setPagdesde(Integer.parseInt(allRequestParams.get("start")));
			paginacion.setColorderby( Integer.parseInt(allRequestParams.get("order[0][column]"))==0?Integer.parseInt(allRequestParams.get("order[0][column]"))+1:Integer.parseInt(allRequestParams.get("order[0][column]")));
			paginacion.setColorderbydir(allRequestParams.get("order[0][dir]"));
			

			formulario314.setStrFecha(allRequestParams.get("pFecha"));
			
			if(allRequestParams.get("pTipo")!=null && !"".equals(allRequestParams.get("pTipo"))){ //campo codigo viene desde turbidimetroDigitalTable
				formulario314.setTipoEnsayo(Integer.parseInt(allRequestParams.get("pTipo")));
				
			}else{
				formulario314.setTipoEnsayo(0);
			}
			
			Result result =   iformulario314Service.getListadoFormulario314(formulario314, paginacion);
			
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
	
		
	@RequestMapping(value = "/formulario314Get/{id}", method = RequestMethod.GET)
	public String formulario314Get(
			@ModelAttribute("formulario314") Formulario314 formulario314, Model model,
			@PathVariable int id) throws Exception {
		
		    int cantidad = 0;
		    
			if(id != -1){
				formulario314 = iformulario314Service.getFormulario314(id);
				
			}else{
				formulario314 = new Formulario314();  
			}
			
			model.addAttribute("formulario314", formulario314);
			return "formulario314/formulario314Edit :: form-edit-form314";
	}

	
	@RequestMapping(value = "/formularioSave314", method = RequestMethod.POST)
	public String formularioSave314(ModelMap model, HttpServletRequest request, HttpSession session,
			@ModelAttribute("formulario314") Formulario314 formulario314){

		String strMensajeTipo = "";
		String strMensajeError = "";
		Double a, b, c;
		Double rsd;
		
        try{
        	if(formulario314.getOpcion().equals("S")  ){
        		
        		formulario314.setPrograma(Util.getPageCall());
        		formulario314.setUsuarioCreacion(Util.getUserLoged());
        		formulario314.setUsuarioModificacion(Util.getUserLoged());
        		a = formulario314.getResultado1();
        		b = formulario314.getResultado2();
        		c = Math.abs(a - b);
        		rsd = (c * 100 * Math.sqrt(2)) / (a + b);
        		formulario314.setRsd(rsd);
//        		formulario314.setObs(obs);
        		iformulario314Service.grabarFormulario314(formulario314);							
       
        	}else {
        		
        		iformulario314Service.updateFormulario314(formulario314);		
        	}
        	
        	strMensajeTipo = ConstantsCommon.GRABADO_OK;
        	
		} catch (Exception e) {
			strMensajeTipo = ConstantsCommon.GRABADO_NO_OK;
			strMensajeError = e.getMessage();
			e.printStackTrace();
		}
		
		model.addAttribute("mensajeTipo", strMensajeTipo);
		model.addAttribute("mensajeError", strMensajeError);
		return "formulario314/formulario314Save :: mensajesSave";
	}


	
	@RequestMapping(value = "/formulario314/inactivar", method = RequestMethod.POST)
	public String inactivarFormularioDetalle(ModelMap model, HttpServletRequest request, HttpSession session, 
			@RequestParam int inacId) {

		String strMensajeTipo = "";
		String strMensajeError = "";		
		
		Formulario314 formulario314 = new Formulario314(); 
		formulario314.setStatus(0);
		formulario314.setIdformulario314(inacId);

		try {			
			iformulario314Service.inactivarForm314(formulario314);
			strMensajeTipo = "inactivadoOk";
			
//			model.addAttribute("mensajeTipo", "inactivadoOkSubForm");
		} catch (Exception e) {
			strMensajeTipo = ConstantsCommon.INACTIVADO_NO_OK;
			strMensajeError = e.getMessage();
			e.printStackTrace();
		}
		
		model.addAttribute("mensajeTipo", strMensajeTipo);
		model.addAttribute("mensajeError", strMensajeError);

		return "formulario314/formulario314Save :: mensajesSave";
		
	}
	
}
