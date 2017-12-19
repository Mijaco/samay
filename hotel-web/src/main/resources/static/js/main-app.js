/* Colocar javascript compartida específico de la aplicacion web */
const OPERATION_TYPE_REPORTE_RESUMEN = '1';
const OPERATION_TYPE_PROCESO_AUTOMATICO = '2';
const OPERATION_TYPE_UNSELECTED = '';

const OPERATION_TYPE_CORREO_FUENTE_ENVIO = '3';
const OPERATION_TYPE_REPORTE_GERENCIA = '4';


//PARA REPORTE RESUMEN DE REPRESAS
const REPORTE_REPRESAS_TYPE_REPRESA = 1;
const REPORTE_REPRESAS_TYPE_ALMACENAMIENTO = 2;
const REPORTE_REPRESAS_TYPE_VOLUMENTOTAL = 3;
const REPORTE_REPRESAS_TYPE_AFORORIO = 4;
const REPORTE_REPRESAS_TYPE_MANIOBRAS = 5;
const REPORTE_REPRESAS_TYPE_AGREGADOS = 6;
//CONSTANTES PARA RUTA COMPARTIDA DEFAULT
const CONF_CORREO_EXTRACCION_RUTA = 'repofile';
const CONF_CORREO_EXTRACCION_USER = 'user';
const CONF_CORREO_EXTRACCION_PASSWORD = 'password';


const HTTP_STATUS_OK = 200;
const HTTP_BAD_REQUEST = 400;
const HTTP_STATUS_INTERNAL_SERVER_ERROR = 500;


//const REGEX_MAIL_VALIDATION = /\S+@\S+\.\S+/;
//const REGEX_MAIL_VALIDATION = /^(([^<>()\[\]\\.,;:ñÑ\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{1,}))$/;
const REGEX_MAIL_VALIDATION = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i;
const REGEX_ALL_WITHOUT_DESC = /[^A-Za-z0-9áéíóúÁÉÍÓÚñÑ .,#&/()<>;-\s]/gi;
const REGEX_ALL_WITHOUT_DESC_LIST = /[^A-Za-z0-9áéíóúÁÉÍÓÚñÑ\✓ .,#&/()<>;-\s]/gi;

//FUNCIONES GENERICAS

//LIMPIAR FILES PARA QUE FUNCIONE EN DIVERSOS BROWSERS
//IMPOTANTE: PARA USARLO IMPORTAR EN EL HTML EL PLUGIN jquery.browser.min.js
function clearInputTypeFile(idInputFile) {
	$fileInput = $('#' + idInputFile);
	if($.browser.msie){
		$fileInput.replaceWith( $fileInput = $fileInput.clone( true ) );
 } else {
 	$fileInput.val('');
 }
}

function ValidationCorreo(value, show) {
	this.value = value;
    this.show = show;
}

function pad(str, max) {
	str = str.toString();
	return str.length < max ? pad("0" + str, max) : str;
}

// MENSAJES VALIDACION
const MSG_VALID_ABREV = "La abreviatura ya se encuentra registrada";


function cargarCombo(urlJson,idSelect){
	console.log("cargando combo");
	MYAPPL.blockPageLoad();
	$.getJSON(urlJson, {
		ajax : 'true'
	}, function(data) {
		var html = '';
		var len = data.length;
		for ( var i = 0; i < len; i++) {
			html += '<option data-defecto="'+ data[i].defecto +'" data-custom="'+ data[i].custom + '"  data-id="'+ data[i].id +'" value="' + data[i].value + '">'
					+ data[i].label + '</option>';
		}
		html += '</option>';
                    //now that we have our options, give them to our select
		$(idSelect).html(html);
		$.unblockUI();
	});
}

function cargarComboSelectable(urlJson,idSelect){
	MYAPPL.blockPageLoad();
	$.ajax({
		url : urlJson,
		type : 'GET',
		dataType : "json",
		error : function(xhr, status) {
			
		},
		complete : function(xhr, status) {
			if(status == 'success' || status=='notmodified')
			{
				console.log(xhr.responseText)
				var data =  $.parseJSON(xhr.responseText);
				var html = '';
				var len = data.length;
				html += '<option data-id="" value="">-Seleccione-</option>';
				for ( var i = 0; i < len; i++) {
					html += '<option data-defecto="'+ data[i].defecto +'" data-custom="'+ data[i].custom + '"  data-id="'+ data[i].id +'" value="' + data[i].value + '">'
							+ data[i].label + '</option>';
				}
				html += '</option>';
				$(idSelect).html(html);
			}
			$.unblockUI();
		}
	});
}

function cargarComboTodos(urlJson,idSelect){
	MYAPPL.blockPageLoad();
	$.ajax({
		url : urlJson,
		type : 'GET',
		dataType : "json",
		error : function(xhr, status) {
			
		},
		complete : function(xhr, status) {
			if(status == 'success' || status=='notmodified')
			{
				console.log(xhr.responseText)
				var data =  $.parseJSON(xhr.responseText);
				var html = '';
				var len = data.length;
				html += '<option value="-1">-Todos-</option>';
				for ( var i = 0; i < len; i++) {
					html += '<option data-defecto="'+ data[i].defecto +'" data-custom="'+ data[i].custom + '"  data-id="'+ data[i].id +'" value="' + data[i].value + '">'
							+ data[i].label + '</option>';
				}
				html += '</option>';
				$(idSelect).html(html);
			}
			$.unblockUI();
		}
	});
}

function cargarComboRelacional(urlJson,idSelect){
	MYAPPL.blockPageLoad();
	$.ajax({
		url : urlJson,
		type : 'GET',
		dataType : "json",
		error : function(xhr, status) {
			
		},
		complete : function(xhr, status) {
			if(status == 'success' || status=='notmodified')
			{
				console.log("lenght: "+ xhr)
				var data =  $.parseJSON(xhr.responseText);
				var html = '';
				var len = data.length;
				if(len<1){
					return;
				}
				html += '<option>-Seleccione-</option>';
				for ( var i = 0; i < len; i++) {
					html += '<option data-idMaster="'+ data[i].idMaster + '"  data-idDetalle="'+ data[i].idDetalle +'" value="' + data[i].value + '">'
					+ data[i].label + '</option>';
				}
				html += '</option>';
				$(idSelect).html(html);
			}else{
				$(idSelect).html("");
			}
			
			$.unblockUI();
		}
	});
	
}

function armarCbo(data,idSelect){
	var html = '';
	var len = data.length;
	for ( var i = 0; i < len; i++) {
		html += '<option data-defecto="'+ data[i].defecto +'" data-custom="'+ data[i].custom + '"  data-id="'+ data[i].id +'" value="' + data[i].value + '">'
		+ data[i].label + '</option>';
	}
	html += '</option>';
                //now that we have our options, give them to our select
	$(idSelect).html(html);
}



//<span class="glyphicon glyphicon-plus"></span>

function armarCboRelacional(data,idSelect){
	var html = '';
	var len = data.length;
	for ( var i = 0; i < len; i++) {
		html += '<option data-idMaster="'+ data[i].idMaster + '"  data-idDetalle="'+ data[i].idDetalle +'" value="' + data[i].value + '">'
		+ data[i].label + '</option>';
	}
	html += '</option>';
                //now that we have our options, give them to our select
	$(idSelect).html(html);
}


function getJSON(urlJson){
var datos;
$.ajax({
	url : urlJson,
	type : 'GET',
	dataType : "json",
	success : function(dataServer) {
		datos = dataServer;
	},
	complete : function(xhr, status) {
		return datos;
	}
});

return datos;
}


function showToastGeneric(mensajeTipo, mensaje, mensajeError) {
	//Mensajes despues de grabar
	if(mensajeTipo==='grabadoOk'){
		 toastr["success"](mensajeError, mensaje);
//		 $('#idBtnFormBuscarClima').click();
	 }
	 if(mensajeTipo==='grabadoNoOk'){
		 toastr["error"](mensajeError, mensaje);
	 }
	 //Mensajes despues de eliminar
	 if(mensajeTipo==='inactivadoOk'){
		 toastr["success"](mensajeError, mensaje);
//		 $('#modal-registra-clima').modal('hide');
//		 $('#idBtnFormBuscarClima').click();
	 }
	 if(mensajeTipo==='inactivadoNoOk'){
		 toastr["error"](mensajeError, mensaje);
	 }
}

//SOLO PERMITE INGRESAR NUMEROS Y GUIONES
function soloNumerosGuiones(e){
	  tecla = (document.all) ? e.keyCode : e.which;
	  tecla = String.fromCharCode(tecla)
	  return /^[0-9\-]+$/.test(tecla);
	}

function printGridsInquiriesCustomized(div, title) {

	var isOSSystem = false;
	var isSafariBrowser = false;
	var isAndroid = false;

	var htmlContent = div.html();
	var stylesCssForPrint = $('#stylesTemplate').html();

	var cssDependencies = [ "/scr/css/myTheme.css",
			"/scr/css/defaultTheme.css",
			"/main/resources/css/bootstrap-select.min.css",
			"/scr/webjars/bootstrap/3.3.7/css/bootstrap.min.css",
			"/scr/webjars/bootstrap/3.3.7/css/bootstrap-theme.min.css",
   	        "/scr/webjars/jquery-ui/1.12.1/jquery-ui.min.css",
   	        "/scr/webjars/bootstrapvalidator/0.5.3/css/bootstrapValidator.min.css",
			"/scr/css/bootstrap-datetimepicker.min.css",
			"/scr/webjars/bootstrap-select/1.12.2/dist/css/bootstrap-select.min.css",
			"/scr/css/jquery.dataTables.min.css",
			"/scr/css/jquery-confirm.min.css",
			"/scr/css/main-app.css"
   	                    ];

	var scriptsDependencies = [ "/scr/webjars/jquery/3.2.1/jquery.min.js",
			"/scr/webjars/bootstrap/3.3.7/js/bootstrap.min.js",
			"/scr/webjars/toastr/2.1.3/toastr.min.css",
			"/scr/webjars/toastr/2.1.3/toastr.min.js",
			"/scr/webjars/jquery-ui/1.12.1/jquery-ui.min.js",
			"/scr/js/main-constants.js",
			"/scr/js/main-app-constants.js",
			"/scr/js/main.js",
			"/scr/webjars/bootstrapvalidator/0.5.3/js/bootstrapValidator.min.js",
			"/scr/webjars/bootstrap-select/1.12.2/dist/js/bootstrap-select.js",
			"/scr/js/jquery.dataTables.min.js",
			"/scr/js/jquery.blockUI.js",
			"/scr/webjars/bootstrapvalidator/0.5.3/js/bootstrapValidator.min.js",
			"/scr/webjars/bootstrapvalidator/0.5.3/js/bootstrapValidator.min.js",
			"/scr/js/jquery.dataTables.min.js",
			"/scr/js/jquery-confirm.min.js",
			"/scr/js/main-app.js"
			];

	var mywindow = window.open('', 'Home', 'height=700,width=1000');

	mywindow.document.head.innerHTML = '';
	mywindow.document.body.innerHTML = '';

	mywindow.document.write('<!doctype html><html><head><title>'+title+'</title>');
	    
	    // Seteo de dependencias js
	    for (var i in scriptsDependencies) {
	    
	    var scriptDep = scriptsDependencies[i];
	        
	    mywindow.document.write('<script ');
	    mywindow.document.write('src="' + scriptDep + '"/>');
	    mywindow.document.write('</'+'script'+'>');
	  }
	    
	     // Seteo de dependencias css
	    for (var i in cssDependencies) {
	    var cssDep = cssDependencies[i];  
	    mywindow.document.write('<link rel="stylesheet" href="'+ cssDep+'" type="text/css" />');
	  }

	mywindow.document.write('<style type="text/css" media="screen,print">');
	mywindow.document.write(stylesCssForPrint);
	mywindow.document.write('</style>');

	// metodo interval
	mywindow.document.writeln('    <script>');
	mywindow.document.writeln('       var interval = setInterval(function(){');
	mywindow.document.writeln('          if(document.getElementById("grid-body-print")){');
	mywindow.document.writeln('          if('+isOSSystem+'){');
	mywindow.document.writeln('          		var d = document.getElementById(\'headerColDynamic\'); if(d.className != null && d.className!=undefined){d.className = \'head-tabl\'}; setTimeout(function(){window.focus();window.print() ,1000});');
	mywindow.document.writeln('          } else if('+isSafariBrowser+' || '+isAndroid+'){');
	mywindow.document.writeln('					var d = document.getElementById(\'headerColDynamic\'); if(d.className != null && d.className!=undefined){d.className = \'head-tabl\'}; window.focus(); setTimeout(function(){window.print(), window.close(),1000});');
	mywindow.document.writeln('			 } else { ');
	mywindow.document.writeln('			 	var d = document.getElementById(\'headerColDynamic\'); if(d.className != null && d.className!=undefined){d.className = \'head-tabl\'}; setTimeout(function(){window.focus();window.print(); window.close(),1000});');
	mywindow.document.writeln(' 		 } ');
	mywindow.document.writeln('             clearInterval(interval)');
	mywindow.document.writeln('          }');
	mywindow.document.writeln('       },750)');
	mywindow.document.writeln('    </script>');
	// fin metodo interval

	mywindow.document.write('</head><body style="padding:20px">');
	mywindow.document.write(htmlContent);
	mywindow.document.write('</body></html>');
	mywindow.document.close();
}

function cargarComboSameValue(urlJson,idSelect){
	MYAPPL.blockPageLoad();
	$.getJSON(urlJson, {
		ajax : 'true'
	}, function(data) {
		var html = '';
		var len = data.length;
		for ( var i = 0; i < len; i++) {
			html += '<option data-defecto="'+ data[i].defecto + '" value="' + data[i].label + '">'
					+ data[i].label + '</option>';
		}
		html += '</option>';
                    //now that we have our options, give them to our select
		$(idSelect).html(html);
		$.unblockUI();
	});
}

function soloNumeros(e){

    // capturamos la tecla pulsada
    var teclaPulsada=window.event ? window.event.keyCode:e.which;

    // capturamos el contenido del input
    var valor=document.getElementById("num").value;

    // 45 = tecla simbolo menos (-)
    // Si el usuario pulsa la tecla menos, y no se ha pulsado anteriormente
    // Modificamos el contenido del mismo aÃ±adiendo el simbolo menos al
    // inicio
    if(teclaPulsada==45 && valor.indexOf("-")==-1)
    {
        document.getElementById("num").value="-"+valor;
    }

    // 13 = tecla enter
    // 46 = tecla punto (.)
    // Si el usuario pulsa la tecla enter o el punto y no hay ningun otro
    // punto
    if(teclaPulsada==13 || (teclaPulsada==46 && valor.indexOf(".")==-1))
    {
        return true;
    }

    // devolvemos true o false dependiendo de si es numerico o no
    return /\d/.test(String.fromCharCode(teclaPulsada));
}

//FUNCION PARA QUE SOLO PERMITA INGRESAR NUMEROS INCLUYE PUNTO 
soloNumerosTmp = function (e) {
    var keynum = window.event ? window.event.keyCode : e.which;
    if ((keynum == 8) || (keynum == 45)){
    	return true;
    }
     
    return /\d/.test(String.fromCharCode(keynum));
};


function getDDMMYYYY(){
	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth()+1; //January is 0!

	var yyyy = today.getFullYear();
	if(dd<10){
	    dd='0'+dd;
	} 
	if(mm<10){
	    mm='0'+mm;
	} 
	today = dd+'/'+mm+'/'+yyyy;
	console.log("today " + today)
	return today;
}


function cargarComboForField(urlJson,idSelect){
	console.log("cargando combo");
	MYAPPL.blockPageLoad();
	$.getJSON(urlJson, {
		ajax : 'true'
	}, function(data) {
		var html = '';
		var len = data.length;
		for ( var i = 0; i < len; i++) {
			html += '<option value="' + data[i].id + '">'
					+ data[i].label + '</option>';
		}
		html += '</option>';
                    //now that we have our options, give them to our select
		$(idSelect).html(html);
		$.unblockUI();
	});
}


