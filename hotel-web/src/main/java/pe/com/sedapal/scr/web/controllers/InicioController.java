/**
 * 
 * Resumen.
 * Objeto : InicioController
 * Descripción : Clase controladora para la gestión de ingreso del usuario al sistema
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

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class InicioController {

	/**
	 * Método que permite redirigir a la pantalla de inicio del sistema
	 * @param name Parametro nombre
	 * @param request se utiliza para almacenar información entre diferentes peticiones HTTP. 
	 * @param model permite la abstracción completa de la tecnología de vista
	 * @return Objeto tipo String con el nombre de la vista de inicio
	 **/
	@RequestMapping("/inicio")
	public String inicio(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name,  HttpServletRequest request, Principal principal) {	    
		if (principal!=null && ((Authentication)principal).isAuthenticated()) {
	        return "inicio";
	    }else{
	    	model.addAttribute("name", name);
        	return "login";
        }		
	}
	
	/**
	 * Método que permite redirigir a la pantalla de inicio del sistema
	 * @param name Parametro nombre
	 * @param request se utiliza para almacenar información entre diferentes peticiones HTTP. 
	 * @param model permite la abstracción completa de la tecnología de vista
	 * @return Objeto tipo String con el nombre de la vista de inicio
	 **/
	@RequestMapping("/")
	public String home1(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name,  HttpServletRequest request) {	   
		return "redirect:/inicio";
	}
	 
}
