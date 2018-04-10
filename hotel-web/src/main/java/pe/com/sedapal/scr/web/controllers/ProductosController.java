package pe.com.sedapal.scr.web.controllers;

import java.util.ArrayList;
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
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pe.com.sedapal.common.core.utils.ConstantsCommon;
import pe.com.sedapal.scr.core.beans.Producto;
import pe.com.sedapal.scr.core.beans.ResultadoBusqueda;
import pe.com.sedapal.scr.core.beans.TablaPoissonBean;
import pe.com.sedapal.scr.core.common.ConstantsLaboratorio;
import pe.com.sedapal.scr.core.services.IProductoService;
import pe.com.sedapal.scr.web.common.Constants;


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
	
	@Autowired
	IProductoService productoService;
	
	
	@RequestMapping(value = "/listaProductos", method = RequestMethod.GET)
	public String listaProductos(HttpServletRequest request, HttpSession session,
			ModelMap model) {
		
		ResultadoBusqueda rs = new ResultadoBusqueda(); 
		List<Producto> lista = productoService.listarProductosFrecuentes();
		LOG.info("LISTA: " + lista);
		rs.setProductos(lista);
		model.addAttribute("resultado", rs);
			
		return "productos/listaProductos";
	}

	
	@RequestMapping(value = "/buscarProductos", method = RequestMethod.GET)
	public String buscarProductos(HttpServletRequest request, HttpSession session, ModelMap model,@RequestParam Map<String,String> allRequestParams) {
		
		try {
			LOG.info("filtrando productos: ");
			ResultadoBusqueda rs = new ResultadoBusqueda();
			String nombre = allRequestParams.get("nombre")==null? null : allRequestParams.get("nombre").toUpperCase();
			LOG.info("nombre: " + nombre);
			
			List<Producto> lista = productoService.fitrarProductos(nombre, null, null);
			
			rs.setProductos(lista==null? new ArrayList<Producto>(): lista);
			model.addAttribute("resultado", rs);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "productos/result-search :: result";
	
	}
	
	@RequestMapping(value = "/productNew", method = RequestMethod.GET)
	public String productNew(
			@ModelAttribute("tablaPoissonSearchBean") TablaPoissonBean tablaPoissonSearchBean,
			@ModelAttribute("productAddBean") TablaPoissonBean tablaPoissonEditBean, Model model) throws Exception {
			
		    Producto productAddBean = new Producto();
		    productAddBean.setCodigo("09");
			
			model.addAttribute("productBean", productAddBean);
			return "productos/product-add :: form-add-product";
	}
	
	@RequestMapping(value = "/productSave", method = RequestMethod.POST)
	public String insertTablaPoisson(ModelMap model, HttpServletRequest request, HttpSession session,
			@ModelAttribute("productBean") Producto producto) {

		String strMensajeTipo = "";
		String strMensajeError = "";
		try {

			LOG.info("codigo producto: " + producto.getCodigo());

			strMensajeTipo = ConstantsCommon.GRABADO_OK;
		} catch (Exception e) {
			strMensajeTipo = ConstantsCommon.GRABADO_NO_OK;
			strMensajeError = e.getMessage();
			e.printStackTrace();
		}
		
	model.addAttribute(Constants.MENSAJE_MOSTRAR,"");
	model.addAttribute(ConstantsLaboratorio.MENSAJE_TIPO, strMensajeTipo);
	model.addAttribute(ConstantsLaboratorio.MENSAJE_ERROR, strMensajeError);
	return ConstantsLaboratorio.PATH_RESULT_GENERICSAVE; 
	
	}
	
	public String obtenerMensaje(String messageProp){
		return messageSource.getMessage(messageProp, new Object[] {}, Locale.US);
	}

}
