var nsPd = MYAPPL.createNS("MYAPPL.LOGIC.PUNTODIST");

$(document).ready(function() {
	
	//MANEJO DEL FORMULARIO DE BUSQUEDA
	$('#idBtnFormBuscarClima').click(function () {

		$("#txtPeriodoHidden").val($("#txtPeriodo").val());
		$('#myClima').DataTable().ajax.reload();  //PARA LLAMAR AL DATATABLE PRINCIPAL A TRAVES DEL ID
	});

	$('#txtPeriodo').datetimepicker({
	        format: 'DD/MM/YYYY',
	        ignoreReadonly: true,
//	        date: null,
	        locale: "es"
	    });
	
	
});

function modificarFormulario(id) {
//	id= -1 Boton Agregar
	$.ajax({
		type: 'GET',
		url: 'muestraGet/'+id, //LLAMA AL CONTROLER Y DEVUELVE UNA PAGINA(PAGUNA HEADER)
		success: function(result) {
			$('#id-modal-content').replaceWith(result); //SE INYECTA EN LA PAGINA PRINCIPAL EL HEADER

				if(id != -1){ //EDITAR
					$('#strFechaHora').datetimepicker({
				        format: 'DD/MM/YYYY',
				        ignoreReadonly: false,
				        locale: "es"
					})
				}else{
					
					$('#strFechaHora').datetimepicker({
				        format: 'DD/MM/YYYY',
				        ignoreReadonly: false,
				        date: new Date(),
				        locale: "es"
					})
				}

			enableValidationRules();
				
		},complete: function() {
			
			$('#modal-registra-clima').modal('show'); //MUESTRA EN LA PANTALLA PRINCIPAL FORMULARIO HEADER
			$.unblockUI();
		}
	});
}


//FUNCION PARA INACTIVAR UN REGISTRO
function inactivarFormulario(id) {
	$.confirm({
		title : 'Confirmaci\u00f3n',
		content : 'Confirma Eliminar Registro ?',
		buttons : {
			Aceptar : {
				btnClass : 'btn-blue',
				action : function() {
					$('#inacIdmuestra').val(id);
					$.ajax({
						type : 'POST',
						url : $('#form-inactiva-muestra').attr('action'),
						data : $('#form-inactiva-muestra').serialize(),
						success : function(result) {
							$('.container_save').html(result);
						},
						complete : function() {
							$.unblockUI();
						}
					});
				}
			},
			Cancelar : {}
		}
	});
};


//FUNCION PARA MOSTRAR EL DIALOG CON REPORTE PDF
nsPd.cargandoReportePDF = function() {
	var periodo = $('#txtPeriodo').val();
	// var varConsDistrito = $('#consDistrito').val();
	// var varConsTipoFuente = $('#consTipoFuente').val();
	$("#pdf").text("Cargando Reporte...");
	var options = {
		fallbackLink : '<p>Este navegador no soporta la previsualización de archivos PDF. <a href="[url]">Clic aquí para descargar el PDF</a>.</p>',
		forcePDFJS : true,
		PDFJS_URL : "js/pdfjs/web/viewer.html"
	};
	
	PDFObject.embed(MYAPPL.LOGIC.PUNTODIST.getContextPath()+ "/registroMuestraReportePDF/registroMuestraReportePDF"+ MYAPPL.getCurrentTimeStamp() + ".pdf?periodo=" + periodo, "#pdf", options);

}

nsPd.getContextPath = function () {
	   return window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	}


function enableValidationRules() {

var TIME_PATTERN = /^([01]?[0-9]|2[0-3]):([0-5][0-9])$/;
	
	$('#hora').datetimepicker({
		//defaultDate: new Date(),
        format: 'HH:mm',
        ignoreReadonly: true,
        locale: "es"
    }).on('dp.change dp.show', function (e) {
        $('#form-edit-Detalle-id').bootstrapValidator('revalidateField', 'hora');
    });
	
	var validator = $("#form-edit-clima").bootstrapValidator({
		message: 'El valor no es v\u00e1lido',
		feedbackIcons : {
			valid : "glyphicon glyphicon-ok",
			invalid : "glyphicon glyphico-remove",
			validating : "glyphicon glyphicon-refresh"
		},
		fields : {
			strFechaHora: {
					validators : {
								
						notEmpty: {
	                        message: 'Ingrese la Fecha'
	                    }
					}
			},
			
			hora : {
				verbose: false,
				message : "Ingrese la hora",
				validators : {
					
					regexp: {
						regexp: /^([01]?[0-9]|2[0-3]):([0-5][0-9])$/,
                        message: "Debe tener el formato HH:MM (24 horas)"
                    },
                    
                    stringLength : {
						max : 5,
						message : "El campo ha de ser como m\u00e1ximo 5 caracteres"
					},

					notEmpty: {
                        message: 'Ingrese la Hora'
                    },
				}
			},
			
			codigoFrasco: {
				validators : {
							
					stringLength : {
						max : 8,
						message : "El valor ha de ser como m\u00e1ximo 8 caracteres"
					},
					notEmpty: {
                        message: 'Ingrese Código'
                    }
				}
		   },
			temp: {
					validators : {
								
						stringLength : {
							max : 5,
							message : "El valor ha de ser como m\u00e1ximo 5 caracteres"
						},			
						regexp: {
							 
							 regexp: /^[0-9]+([.][0-9]+)?$/, 
		 
							 message: 'Valor incorrecto'
		 
						}
					}
			},
			

            
		}
	})	
	.on('success.form.bv', function(e, data) {
		$("#guardarButton").html('Guardando...');
		$("#guardarButton").attr('disabled', 'disabled');
		e.preventDefault();
		var $nuevoClimaForm = $(e.target);
		$.ajax({
			type: 'POST',
			url: $('#form-edit-clima').attr('action'),
			data: $('#form-edit-clima').serialize(),
			success: function(result){
				$nuevoClimaForm.bootstrapValidator('resetForm', true);
				$nuevoClimaForm[0].reset();
				$('.container_save').html(result);
			},
			complete: function() {
				$("#guardarButton").html('Guardar');
				$('#guardarButton').removeAttr("disabled");
			}
		});
	});	
}


function showToastClima(mensajeTipo, mensajeError) {
// Mensajes despues de grabar
if (mensajeTipo === 'grabadoOk') {
	toastr["success"](mensajeError, "Registro correctamente guardado");
	$('#modal-registra-clima').modal('hide');
	$('#idBtnFormBuscarClima').click();
}
if (mensajeTipo === 'grabadoNoOk') {
	toastr["error"](mensajeError,
			"Hubo un error en el servidor, el registro no fue guardado");
}
// Mensajes despues de eliminar
if (mensajeTipo === 'borradoOk') {
	toastr["success"](mensajeError, "Registro correctamente inactivado");
	$('#modal-registra-clima').modal('hide');
	$('#idBtnFormBuscarClima').click();
  }
if (mensajeTipo === 'borradoNoOk') {
	toastr["error"](mensajeError,
			"Hubo un error en el servidor, el registro no fue inactivado");
  }
}





