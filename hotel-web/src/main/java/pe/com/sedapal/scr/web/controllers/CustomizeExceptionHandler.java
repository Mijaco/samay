/**
 * 
 * Resumen.
 * Objeto : CustomizeExceptionHandler
 * Descripción : Clase controladora para la gestión customizada de excepciones
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;

@ControllerAdvice
public class CustomizeExceptionHandler {
	
	@Autowired
	Environment env;

	public static final String DEFAULT_ERROR_VIEW = "exception";

	private static final Logger logger = LoggerFactory
			.getLogger(CustomizeExceptionHandler.class);

	/**
	 * Método que permite gestionar la excepción MultipartException
	 * @param exception Es la excepción lanzada
	 * @return Objeto de tipo ResponseEntity con un mensaje descriptivo
	 **/
	@ExceptionHandler(value = MultipartException.class)
	public ResponseEntity<String> IllegalStateHandler(Exception exception) {
		logger.error(exception.getMessage());
		return new ResponseEntity<>("El archivo ingresado supera el tama&ntilde;o permitido ("+
				env.getProperty("spring.http.multipart.maxFileSize")+")", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
