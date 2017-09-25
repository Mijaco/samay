package pe.com.sedapal.scr.web.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.sedapal.scr.core.beans.SelectItemBean;
import pe.com.sedapal.scr.core.services.ICatalogoService;

/**
 * @author Mijail Aymara
 *
 */
@Controller
@PropertySources(value = { @PropertySource(name = "props", value = {
		"classpath:application.properties" }, ignoreResourceNotFound = true) })
public class ItemsController {

	private static final Logger logger = LoggerFactory.getLogger(ItemsController.class);

	@Autowired
	Environment env;

	@Autowired
	MessageSource messageSource;

	@Autowired
	ICatalogoService catalogoService;
	
	@RequestMapping(value = "/listAreas", method = RequestMethod.GET)
	public @ResponseBody
	List<SelectItemBean> findAreas() throws Exception {
		
		logger.debug("finding all distritos");
		return this.catalogoService.obtenerCatalogo(1);
	}
	
	@RequestMapping(value = "/listLambdas", method = RequestMethod.GET)
	public @ResponseBody
	List<SelectItemBean> findlLambdas() throws Exception {
		
		logger.debug("finding all distritos");
		return this.catalogoService.obtenerCatalogo(2);
	}
	
	@RequestMapping(value = "/listActividades", method = RequestMethod.GET)
	public @ResponseBody
	List<SelectItemBean> findActividad() throws Exception {
		logger.debug("finding all actividades");
		return this.catalogoService.obtenerCatalogo(2);
	}
	
	@RequestMapping(value = "/listSubactividades", method = RequestMethod.GET)
	public @ResponseBody
	List<SelectItemBean> findSubActividades() throws Exception {
		logger.debug("finding all actividades");
		return this.catalogoService.obtenerCatalogo(3);
	}
	
	@RequestMapping(value = "/listPuntos", method = RequestMethod.GET)
	public @ResponseBody
	List<SelectItemBean> findPuntos() throws Exception {
		logger.debug("finding all actividades");
		return this.catalogoService.obtenerCatalogo(6);
	}
	
	@RequestMapping(value = "/listGrupo", method = RequestMethod.GET)
	public @ResponseBody
	List<SelectItemBean> findGrupo() throws Exception {
		
		logger.debug("finding all Grupos");
		return this.catalogoService.obtenerCatalogo(1);
	}
	
	@RequestMapping(value = "/listComboUbicacion", method = RequestMethod.GET)
	public @ResponseBody
	List<SelectItemBean> findUbicacion() throws Exception {
		
		logger.debug("finding all Ubicacion");
		System.out.println("consultando Ubicacion");
		return this.catalogoService.obtenerCatalogo(13);
	}
	
	@RequestMapping(value = "/listComboMeses", method = RequestMethod.GET)
	public @ResponseBody
	List<SelectItemBean> findMeses() throws Exception {
		
		logger.debug("finding all Meses");
		System.out.println("consultando Meses");
		return this.catalogoService.obtenerCatalogo(12);
	}
	
	@RequestMapping(value = "/listUnidadMedida", method = RequestMethod.GET)
	public @ResponseBody
	List<SelectItemBean> findUnidadMedida() throws Exception {
		
		logger.debug("finding all Meses");
		System.out.println("consultando Meses");
		return this.catalogoService.obtenerCatalogo(20);
	}
	
	@RequestMapping(value = "/listParametros", method = RequestMethod.GET)
	public @ResponseBody
	List<SelectItemBean> findParametros() throws Exception {
		
		logger.debug("finding all Parametros");
		
		return this.catalogoService.obtenerCatalogo(4);
	}
	
	@RequestMapping(value = "/listPersonaMuestrea", method = RequestMethod.GET)
	public @ResponseBody
	List<SelectItemBean> findPersonaMuestrea() throws Exception {
		
		logger.debug("finding all PersonaMuestrea");
		System.out.println("consultando Personas q muestrean");
		return this.catalogoService.obtenerCatalogoSeleccionar(10,2);
	}
	
	@RequestMapping(value = "/listPersonaRecepcion", method = RequestMethod.GET)
	public @ResponseBody
	List<SelectItemBean> findPersonaRecepcion() throws Exception {
		
		logger.debug("finding all PersonaRecepcion");
		System.out.println("consultando Persona q recepciona");
		return this.catalogoService.obtenerCatalogoSeleccionar(11,2);
	}
	@RequestMapping(value = "/listEspecialistas", method = RequestMethod.GET)
	public @ResponseBody
	List<SelectItemBean> findEspecialistas() throws Exception {
		
		logger.debug("finding all Especialistas");
		
		return this.catalogoService.obtenerCatalogoSeleccionar(14,2);
	}
	
	@RequestMapping(value = "/listTipoFrasco", method = RequestMethod.GET)
	public @ResponseBody
	List<SelectItemBean> findTipoFrasco() throws Exception {
		
		logger.debug("finding all listTipoFrasco");
		
		return this.catalogoService.obtenerCatalogo(9);
	}
	
	@RequestMapping(value = "/listTipoMuestra", method = RequestMethod.GET)
	public @ResponseBody
	List<SelectItemBean> findTipoMuestra() throws Exception {
		
		logger.debug("finding all listTipoMuestra");
		
		return this.catalogoService.obtenerCatalogo(7);
	}
	
	@RequestMapping(value = "/listTipoPreservacion", method = RequestMethod.GET)
	public @ResponseBody
	List<SelectItemBean> findTipoPreservacion() throws Exception {
		
		logger.debug("finding all listTipoPreservacion");
		
		return this.catalogoService.obtenerCatalogo(15);
	}
	
	@RequestMapping(value = "/listPuntos2", method = RequestMethod.GET)
	public @ResponseBody
	List<SelectItemBean> findPuntos2() throws Exception {
		logger.debug("finding all actividades");
		return this.catalogoService.obtenerCatalogoSeleccionar(6,2);
	}
	
	@RequestMapping(value = "/listTipoEnsayo", method = RequestMethod.GET)
	public @ResponseBody
	List<SelectItemBean> listTipoEnsayo() throws Exception {
		logger.debug("finding all Metodo de Ensayo");
		return this.catalogoService.obtenerCatalogoSeleccionar(16,2);
	}
	
	@RequestMapping(value = "/listTipoEnsayo2", method = RequestMethod.GET)
	public @ResponseBody
	List<SelectItemBean> listTipoEnsayo2() throws Exception {
		logger.debug("finding all Metodo de Ensayo");
		return this.catalogoService.obtenerCatalogo(16);
	}
	
	@RequestMapping(value = "/listAnalistas", method = RequestMethod.GET)
	public @ResponseBody
	List<SelectItemBean> listAnalistas() throws Exception {
		
		logger.debug("finding all listAnalistas");
		return this.catalogoService.obtenerCatalogo(11);
	}
	
	@RequestMapping(value = "/listMuestreadores", method = RequestMethod.GET)
	public @ResponseBody
	List<SelectItemBean> listMuestreadores() throws Exception {
		
		logger.debug("finding all PersonaMuestrea");
		System.out.println("consultando listMuestreadores");
		return this.catalogoService.obtenerCatalogo(10);
	}
	
}
