package pe.com.sedapal.scr.web.controllers;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.sedapal.common.core.utils.ConstantsCommon;
import pe.com.sedapal.common.core.utils.DateUtils;
import pe.com.sedapal.scr.core.beans.ActividadArea;
import pe.com.sedapal.scr.core.beans.SelectItemBean;
import pe.com.sedapal.scr.core.common.ConstantsLaboratorio;
import pe.com.sedapal.scr.core.services.IActividadXAreaService;
import pe.com.sedapal.scr.web.common.Constants;
import pe.com.sedapal.scr.web.common.Util;


@Controller
@PropertySources(value = { @PropertySource(name = "props", value = {
		"classpath:application.properties" }, ignoreResourceNotFound = true) })
public class ProductosController {

	private static final Logger LOG = LoggerFactory.getLogger(Constants.PACKAGE);
	private static final String  OPCION_UPDATE_DESCRIPCION= "UD";
	

	@Autowired
	Environment env;
	
	@Autowired
	MessageSource messageSource;
	
	
	@RequestMapping(value = "/listaProductos", method = RequestMethod.GET)
	public String bandejaCaudalesGo(HttpServletRequest request, HttpSession session,
			ModelMap model) {
		
		model.addAttribute("today",DateUtils.dateToddMMyyyyhhmmss12(new Date()));
		
		return "productos/listaProductos";
	}

	
	
	public String obtenerMensaje(String messageProp){
		return messageSource.getMessage(messageProp, new Object[] {}, Locale.US);
	}

}
