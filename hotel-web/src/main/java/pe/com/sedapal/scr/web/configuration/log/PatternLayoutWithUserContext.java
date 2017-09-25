/**
 * 
 * Resumen.
 * Objeto : PatternLayoutWithUserContext
 * Descripción : Clase de Utilitarios
 * Fecha de Creación : 27/06/2017
 * Autor : grondo
 * -----------------------------------------------------------------
 * Modificaciones
 * Fecha             Nombre                  Descripción
 * -----------------------------------------------------------------
 * 
 *
 */
package pe.com.sedapal.scr.web.configuration.log;

import ch.qos.logback.classic.PatternLayout;

public class PatternLayoutWithUserContext extends PatternLayout{
	static {
        PatternLayout.defaultConverterMap.put("user", UserConverter.class.getName());
    }
}
