/**
 * 
 * Resumen.
 * Objeto : TipoOperacionController
 * Descripción : Clase controladora para tipo de operación
 * Fecha de Creación : 27/06/2017
 * Autor : grondo
 * -----------------------------------------------------------------
 * Modificaciones
 * Fecha             Nombre                  Descripción
 * -----------------------------------------------------------------
 * 
 *
 */
package pe.com.sedapal.scr.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.sedapal.common.core.beans.SelectItemBean;
import pe.com.sedapal.scr.core.services.ITipoOperacionService;

@Controller
@PropertySources(value = { @PropertySource(name = "props", value = {
		"classpath:application.properties" }, ignoreResourceNotFound = true) })
public class TipoOperacionController {


	@Autowired
	ITipoOperacionService tipoOperacionService;
	
	/**
	 * Método que permite enviar a al frontend el listado de tipos de operación
	 * @return lista de objetos de tipo SelectItemBean con la información de tipos de operación
	 * @throws Exception Excepción que puede ser lanzada
	 */
	@RequestMapping(value = "/listTiposOperacion", method = RequestMethod.GET)
	public @ResponseBody List<SelectItemBean> findAll() throws Exception {
		return this.tipoOperacionService.obtenerAllTipoOperacion();
	}
	
}
