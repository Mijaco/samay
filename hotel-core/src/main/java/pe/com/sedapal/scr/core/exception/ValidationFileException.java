/**
 * 
 * Resumen.
 * Objeto : ValidationFileException
 * Descripción : Clase customizada para la gestión de excepciones
 * Fecha de Creación : 27/06/2017
 * Autor : grondo
 * -----------------------------------------------------------------
 * Modificaciones
 * Fecha             Nombre                  Descripción
 * -----------------------------------------------------------------
 * 
 *
 */
package pe.com.sedapal.scr.core.exception;

public class ValidationFileException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor de la clase
	 * @param message Es el mensaje de error 
	 */
	public ValidationFileException(String message){
		super(message);
	}

}
