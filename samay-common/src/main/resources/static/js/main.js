//MANEJO DE NAMESPACE
var MYAPPL = MYAPPL || {};

MYAPPL.lastTime = Date.now();

//FUNCION PARA QUITAR EL ENTER
//MYAPPL.removeInputEnter = function () { 
//	jQuery(document).ready(function(){
//	    jQuery('input').keypress(function(event){
//	        if (event.which == 13) {
//	            event.preventDefault();
//	            return false;   
//	        }
//	    });
//	});
//}
//MYAPPL.removeInputEnter();

//FUNCION PARA QUE SOLO PERMITA INGRESAR LETRAS
MYAPPL.soloLetras = function (e){
    key = e.keyCode || e.which;
    tecla = String.fromCharCode(key).toLowerCase();
    letras = " áéíóúabcdefghijklmnñopqrstuvwxyz";
    especiales = "8-37-39-46";

    tecla_especial = false
    for(var i in especiales){
         if(key == especiales[i]){
             tecla_especial = true;
             break;
         }
     }

     if(letras.indexOf(tecla)==-1 && !tecla_especial){
         return false;
     }
};
 
//FUNCION PARA QUE SOLO PERMITA INGRESAR NUMEROS INCLUYE PUNTO 
 MYAPPL.soloNumeros = function (e) {
     var keynum = window.event ? window.event.keyCode : e.which;
     if ((keynum == 8) || (keynum == 46))
     return true;
      
     return /\d/.test(String.fromCharCode(keynum));
 };
 
//FUNCION PARA QUE SOLO PERMITA INGRESAR NUMEROS SIN PUNTO
 MYAPPL.soloNumerosSinPunto = function soloNumerosSinPunto(e) {
     var keynum = window.event ? window.event.keyCode : e.which;
     if ((keynum == 8))
     return true;
      
     return /\d/.test(String.fromCharCode(keynum));
 };
 
//FUNCION PARA QUE SOLO PERMITA INGRESAR NUMEROS INCLUYE PUNTO 
 MYAPPL.soloNumerosPunto = function (evt) {
     var theEvent = evt || window.event;
     var key = theEvent.keyCode || theEvent.which;
     key = String.fromCharCode(key);
     if (key.length == 0) return;
     var regex = /^[0-9.\b]+$/;
     if (!regex.test(key)) {
         theEvent.returnValue = false;
         if (theEvent.preventDefault) theEvent.preventDefault();
     }
 }
 
//FUNCION PARA QUE SOLO PERMITA INGRESAR NUMEROS, LETRAS, GUIONES
 MYAPPL.soloNumerosLetrasGuiones = function (evt) {
     var theEvent = evt || window.event;
     var key = theEvent.keyCode || theEvent.which;
     key = String.fromCharCode(key);
     if (key.length == 0) return;
     var regex = /^[a-z0-9-\b]+$/i;
     if (!regex.test(key)) {
         theEvent.returnValue = false;
         if (theEvent.preventDefault) theEvent.preventDefault();
     }
} 
 
//FUNCION PARA QUE SOLO PERMITA INGRESAR SOLO LETRAS Y ESPACIO
 MYAPPL.soloLetrasEspacio = function (evt) {
     var theEvent = evt || window.event;
     var key = theEvent.keyCode || theEvent.which;
     key = String.fromCharCode(key);
     if (key.length == 0) return;
     var regex = /^[ñÑáéíóúÁÉÍÓÚa-zA-Z \b]+$/i;
     if (!regex.test(key)) {
         theEvent.returnValue = false;
         if (theEvent.preventDefault) theEvent.preventDefault();
     }
} 
 
//FUNCION PARA QUE SOLO PERMITA INGRESAR SOLO LETRAS, NUMEROS Y ESPACIO 
 MYAPPL.soloLetrasNumerosEspacio = function (evt) {
     var theEvent = evt || window.event;
     var key = theEvent.keyCode || theEvent.which;
     key = String.fromCharCode(key);
     if (key.length == 0) return;
     var regex = /^[ñÑáéíóúÁÉÍÓÚa-zA-Z0-9 \b]+$/i;
     if (!regex.test(key)) {
         theEvent.returnValue = false;
         if (theEvent.preventDefault) theEvent.preventDefault();
     }
} 
 
//FUNCION PARA QUE SOLO PERMITA INGRESAR NUMEROS Y LETRAS (MAYUSCULAS Y MINUSCULAS, INCLUYE Ñ)
 MYAPPL.soloNumerosLetras = function (evt) {
     var theEvent = evt || window.event;
     var key = theEvent.keyCode || theEvent.which;
     key = String.fromCharCode(key);
     if (key.length == 0) return;
     var regex = /^[ñÑáéíóúÁÉÍÓÚa-zA-Z0-9\b]+$/i;
     if (!regex.test(key)) {
         theEvent.returnValue = false;
         if (theEvent.preventDefault) theEvent.preventDefault();
     }
} 
 
//FUNCION PARA QUE SOLO PERMITA INGRESAR NUMEROS, LETRAS (MAYUSCULAS Y MINUSCULAS, INCLUYE Ñ),
 // PARENTESIS, SLASH, ESPACIO
 MYAPPL.soloNumerosLetrasParentesisSlashSpace = function (evt) {
     var theEvent = evt || window.event;
     var key = theEvent.keyCode || theEvent.which;
     key = String.fromCharCode(key);
     if (key.length == 0) return;
     var regex = /^[ñÑáéíóúÁÉÍÓÚa-zA-Z0-9()/ \b]+$/i;
     if (!regex.test(key)) {
         theEvent.returnValue = false;
         if (theEvent.preventDefault) theEvent.preventDefault();
     }
} 
 
//FUNCION PARA QUE SOLO PERMITA INGRESAR FORMULAS MATEMATICAS (NO ADMITE COMAS)
 // (),/,*,+,-,^,.  Y NUMEROS
 MYAPPL.soloFormulaMatematicaBasica = function (evt) {
     var theEvent = evt || window.event;
     var key = theEvent.keyCode || theEvent.which;
     key = String.fromCharCode(key);
     if (key.length == 0) return;
     var regex = /^[0-9()/*+-.\b]+$/;
     if (!regex.test(key)) {
         theEvent.returnValue = false;
         if (theEvent.preventDefault) theEvent.preventDefault();
     }
} 

//FUNCION PARA QUE SOLO PERMITA INGRESAR NUMEROS, LETRAS, Y " ,.;:-_"
 MYAPPL.soloNumerosLetrasGuionesComas = function (e){
	    key = e.keyCode || e.which;
	    tecla = String.fromCharCode(key).toLowerCase();
	    letras = " áéíóúabcdefghijklmnñopqrstuvwxyz ,.;:-_0123456789";
	    especiales = "8-37-39-46";

	    tecla_especial = false
	    for(var i in especiales){
	         if(key == especiales[i]){
	             tecla_especial = true;
	             break;
	         }
	     }

	     if(letras.indexOf(tecla)==-1 && !tecla_especial){
	         return false;
	     }
	 }; 

//FUNCION PARA OBTENER LA FECHA HORA EN FORMATO YYYYMMDDHHmmSS	 
MYAPPL.getCurrentTimeStamp = function (){
	var d = new Date();
	return ""+	d.getFullYear() +
	("00" + (d.getMonth() + 1)).slice(-2) + 
	    ("00" + d.getDate()).slice(-2)  + 
	    ("00" + d.getHours()).slice(-2)+ 
	    ("00" + d.getMinutes()).slice(-2) + 
	    ("00" + d.getSeconds()).slice(-2);	
}

//FUNCION PARA CAMBIAR A MAYUSCULAS LOS INPUTS
MYAPPL.toUppercaseInputs = function () { 
	$('input[type=text]').val (function () {
	    return this.value.toUpperCase();
	});
	$('textarea').val (function () {
	    return this.value.toUpperCase();
	});
}


//CONFIGURACION DEL MENSAJE TEMPORAL
toastr.options = {
		  "closeButton": true,
		  "debug": false,
		  "newestOnTop": false,
		  "progressBar": false,
		  "positionClass": "toast-top-center",
		  "preventDuplicates": false,
		  "showDuration": "300",
		  "hideDuration": "1000",
		  "timeOut": "5000",
		  "extendedTimeOut": "1000",
		  "showEasing": "swing",
		  "hideEasing": "linear",
		  "showMethod": "fadeIn",
		  "hideMethod": "fadeOut"
}

//FUNCION PARA MOSTRAR EL MENSAJE TEMPORAL LUEGO DE EJECUTADA LA ACCION DE GRABAR, BORRAR, INACTIVAR
MYAPPL.showToast = function (mensajeTipo, mensajeError, btnRefreshId, modalId) {
	 if(mensajeTipo==='grabadoOk'){
		 toastr["success"](mensajeError, "Registro guardado correctamente");
		 $('#'+modalId).modal('hide');
		 $('#'+btnRefreshId).click();
	 }else if(mensajeTipo==='grabadoNoOk'){
		 toastr["error"](mensajeError, "Hubo un error en el servidor, el registro no fue guardado");
	 }else if(mensajeTipo==='actualizadoOk'){
		 toastr["success"](mensajeError, "Registro actualizado correctamente");
		 $('#'+modalId).modal('hide');
		 $('#'+btnRefreshId).click();
	 }else if(mensajeTipo==='actualizadoNoOk'){
		 toastr["error"](mensajeError, "Hubo un error en el servidor, el registro no fue actualizado");
	 }else if(mensajeTipo==='borradoOk'){
		 toastr["success"](mensajeError, "Registro borrado correctamente");
		 $('#'+modalId).modal('hide');
		 $('#'+btnRefreshId).click();
	 }else if(mensajeTipo==='borradoNoOk'){
		 toastr["error"](mensajeError, "Hubo un error en el servidor, el registro no fue borrado");
	 }else if(mensajeTipo==='inactivadoOk'){
		 toastr["success"](mensajeError, "Registro inactivado correctamente");
		 $('#'+modalId).modal('hide');
		 $('#'+btnRefreshId).click();
	 }else if(mensajeTipo==='inactivadoNoOk'){
		 toastr["error"](mensajeError, "Hubo un error en el servidor, el registro no fue inactivado");
	 }else if(mensajeTipo==='cargaNoOk'){
		 toastr["error"]('', "Hubo un error en el servidor, no se pudo mostrar el formulario");
	 } else if(mensajeTipo==='genericOk'){
		 toastr["success"]('', mensajeError);
	 }else if(mensajeTipo==='genericNoOk'){
		 toastr["error"]('',mensajeError );
	 }else if (mensajeTipo==='subidaArchivoTamanhoNoOk') {
		 toastr["error"](mensajeError, "Se excedió el tamaño limite permitido");
	 }else if (mensajeTipo==='subidaArchivoCantidadNoOk') {
		 toastr["error"](mensajeError, "Se excedió la cantidad máxima de archivos permitidos");
	 }else if (mensajeTipo==='subidaArchivoRepetido') {
		 toastr["error"](mensajeError, "No puede adjuntar el mismo archivo más de una vez");
	 }else if(mensajeTipo==='aperturadoPeriodoOk'){
		 toastr["success"](mensajeError, "El Periodo fue aperturado correctamente");
		 $('#'+modalId).modal('hide');
		 $('#'+btnRefreshId).click();
	 }else if(mensajeTipo==='aperturadoPeriodoNoOk'){
		 toastr["error"](mensajeError, "Hubo un error en el servidor, el Periodo no fue aperturado");
	 }else if(mensajeTipo==='cerradoPeriodoOk'){
		 toastr["success"](mensajeError, "Se cerro el Periodo correctamente");
		 $('#'+modalId).modal('hide');
		 $('#'+btnRefreshId).click();
	 }else if(mensajeTipo==='cerradoPeriodoNoOk'){
		 toastr["error"](mensajeError, "Hubo un error en el servidor, el Periodo no fue cerrado");
	 }else if (mensajeTipo==='subidaArchivoTipoNoOk') {
		 toastr["error"](mensajeError, "No es un tipo de archivo permitido");
	 }else if (mensajeTipo==='subidaArchivoTamanhoNoOk') {
		 toastr["error"](mensajeError, "Se excedió el peso máximo permitido");
	 }
	 
}

//INICIO MANEJO DE SESION
MYAPPL.validNavigation = false;

MYAPPL.endSession = function(){       
    // Browser or broswer tab is closed
    // Do sth here ...     
	location.href = "./logout";                                      
};

/*function endSession() {
    // Browser or broswer tab is closed
    // Do sth here ...                
    location.href = "./logout";   
}*/

MYAPPL.wireUpEvents =  function () {
    window.onbeforeunload = function () {
        if (!MYAPPL.validNavigation) {
        	MYAPPL.endSession();
	    }
	}

    // Attach the event keypress to exclude the F5 refresh
    $(document).bind('keypress', function (e) {
        if (e.keyCode == 116) {
        	MYAPPL.validNavigation = true;
        }
    });

    // Attach the event click for all links in the page
    $("a").bind("click", function () {
        MYAPPL.validNavigation = true;
    });

    // Attach the event submit for all forms in the page
    $("form").bind("submit", function () {
        MYAPPL.validNavigation = true;
    });

    // Attach the event click for all inputs in the page
    $("input[type=submit]").bind("click", function () {
        MYAPPL.validNavigation = true;
    });
}



MYAPPL.fkey = function (e){
   e = e || window.event;
   if( MYAPPL.wasPressed ) return; 

    if (e.keyCode == 116) {
    	MYAPPL.validNavigation = true;
    	MYAPPL.wasPressed = true;
    }
}

MYAPPL.wasPressed = false;

document.onkeydown = MYAPPL.fkey;
document.onkeypress = MYAPPL.fkey
document.onkeyup = MYAPPL.fkey;

//FIN MANEJO DE SESION



//CONFIGURACION DE LOS BLOQUEOS MIENTRAS SE EJECUTA ACCION QUE POR LO GENERAL ES AJAX
$(document).ajaxStop($.unblockUI); 
MYAPPL.blockPageLoad = function () { 
	 $.blockUI({ message: '<h1><img  src="./images/loading.gif" height="75" width="75"/></h1>' ,
		 css: {
		        border:     'none',
		        backgroundColor:'transparent'
		    }
	 }); 
} 

//MANEJO DEL LISTADO DE TIPO DROPDOWN EN EL MENU
$(document).ready(function() {
	$(".dropdown-toggle").dropdown();
});


//PARA HABILITAR TOOLTIP
$(function() {
	$("[data-toggle='tooltip']").tooltip({
	      position: {
	          my: "left top",
	          at: "right+5 top-5",
	          collision: "none"
	        }
	    });
});

jQuery(document).ready(function () {
	MYAPPL.wireUpEvents();
});

MYAPPL.createNS = function (namespace) {
    var nsparts = namespace.split(".");
    var parent = MYAPPL;
 
    // we want to be able to include or exclude the root namespace so we strip
    // it if it's in the namespace
    if (nsparts[0] === "MYAPPL") {
        nsparts = nsparts.slice(1);
    }
 
    // loop through the parts and create a nested namespace if necessary
    for (var i = 0; i < nsparts.length; i++) {
        var partname = nsparts[i];
        // check if the current parent already has the namespace declared
        // if it isn't, then create it
        if (typeof parent[partname] === "undefined") {
            parent[partname] = {};
        }
        // get a reference to the deepest element in the hierarchy so far
        parent = parent[partname];
    }
    // the parent is now constructed with empty namespaces and can be used.
    // we return the outermost namespace
    return parent;
};

//QUITAR EL CLICK DERECHO
$(document).contextmenu(function() {
    return false;
});


//$( document ).ajaxSend(function(e, xhri) {
//	
//	if(((Date.now()-MYAPPL.lastTime)/1000)>5){
//		var blnAbort = false 
//		var xhr = new XMLHttpRequest();
//		xhr.open('GET', MYAPPL.contextPath+'validaSesion', false);
//		xhr.ontimeout = function (e) {
//			xhri.abort();
//		};
//		
//		xhr.onerror = function (e) {			
//			if(xhr.status==0){//No hay internet
//				alert('Verifique su conexión de internet');	
//			}
//			xhri.abort();
//		};
//			
//		xhr.send(null);
//		if(xhr.status!=200){//La sesion expiró
//			alert('La sesión expiró');
//			location.href = MYAPPL.contextPath;   			
//		}		
//	}
//	MYAPPL.lastTime = Date.now();	
//});


