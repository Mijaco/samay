
$(document).ready(function() {
	
	//MANEJO DEL FORMULARIO DE BUSQUEDA
	$('#idBtnBuscarFormulario').click(function () {

		 $('#pFechaMuestreoHidden').val($('#inputFechaMuestreo').val());
		 $('#myTableFormulario242').DataTable().ajax.reload();  //PARA LLAMAR AL DATATABLE PRINCIPAL A TRAVES DEL ID
	});

	$('#inputFechaMuestreo').datetimepicker({
	        format: 'DD/MM/YYYY',
			//format: 'YYYY-MM-DD HH:mm:ss',
	        ignoreReadonly: false,
//	        date: new Date(),
	        locale: "es"
	    });
	
	
});

$('#modal-registra-formularioHeader').on('shown.bs.modal', function() {
	$($.fn.dataTable.tables(true)).DataTable().columns.adjust();
})

var idCabecera;
function modificarFormulario(id) {
//	id= -1 Boton Agregar
	idCabecera = id;
	$('#codigoCabecera').val(id); //input definido en la pagina principal
	$.ajax({
		type: 'GET',
		url: 'formulario242Get/'+id, //LLAMA AL CONTROLER Y DEVUELVE UNA PAGINA(PAGUNA HEADER)
		success: function(result) {
			$('#id-modal-content').replaceWith(result); //SE INYECTA EN LA PAGINA PRINCIPAL EL HEADER
			
			cargarCombo("listPersonaMuestrea","#cboPersonaMuestrea");
			cargarCombo("listPersonaRecepcion","#cboPersonaRecepcion");
			if(id != -1){ //EDITAR

				$("#idTableVerificacion").show();
//				$("#strFechaMuestreo").attr('disabled', 'disabled');
//				$("#strFechaRecepcion").attr('disabled', 'disabled');
//				$("#cboPersonaMuestrea").attr('disabled', 'disabled');
//				$("#cboPersonaRecepcion").attr('disabled', 'disabled');
//				$("#observacion").attr('disabled', 'disabled');
				$('#idModalTitle').html($('#idValEditModalTitle').html());
				
				$('#strFechaRecepcion').datetimepicker({
			        format: 'DD/MM/YYYY HH:mm:ss',
			        ignoreReadonly: false,
			        locale: "es"
			    });

			}else{
				
				$('#strFechaMuestreo').datetimepicker({
			        format: 'DD/MM/YYYY',
			        ignoreReadonly: false,
			        date: new Date(),
			        locale: "es"
			    });
				
				$('#strFechaRecepcion').datetimepicker({
			        format: 'DD/MM/YYYY HH:mm:ss',
			        ignoreReadonly: false,
			        date: new Date(),
			        locale: "es"
			    });

			    $("#idTableVerificacion").hide();
				$('#idModalTitle').html($('#idValCrearModalTitle').html());
			}
			enableValidationRules();	
			
		},complete: function() {
			
			$('#modal-registra-formularioHeader').modal('show'); //MUESTRA EN LA PANTALLA PRINCIPAL FORMULARIO HEADER
			if(id != -1){		
//			alert($('#cboMuestreaHidden').val());
			
				setTimeout(function(){
				
					$('#cboPersonaMuestrea').val($('#cboMuestreaHidden').val());
					$('#cboPersonaRecepcion').val($('#cboRecepcionHidden').val());
				}, 500);

				//$('#codMes').find("[value='" + $('#codMesHide').val() + "']").prop('selected', 'selected');
				//$('#codMes').find("[value='" + $('#codMesHide').val() + "']").attr('selected', 'selected');
				
			}
			$.unblockUI();
		}
	});
}


function modificarDetalle() {
var X = 0; 
	$.ajax({
		type: 'GET',
		url: 'formularioDetalleGet/'+X,
//		url: 'formularioDetalleGet/'+idCabecera, //LLAMA AL CONTROLER DEVUELVE UNA PAGINA(PAGINA DETALLE)
		success: function(result) {
			$('#id-modal-content-verif').replaceWith(result); //ESA PAGINA SE INYECTA EN LA PAGINA PRINCIPAL
			
			$('#idFormularioHeader').val(idCabecera);			
			
			cargarCombo("listSubactividades","#cboLocalMuestreo");
			cargarCombo("listPuntos","#cboEstacionMuestreo");
			
			$('#idModalEditTitle').html($('#idValCrearModalDetalleTitle').html());
			
//			if(idCabecera != 0){
//				$('#idModalEditTitle').html($('#idValEditModalDetalleTitle').html());
//
//			}else{
//				$('#idModalEditTitle').html($('#idValCrearModalDetalleTitle').html());
//			}
			enableValidationRulesVerificacion();								
		},complete: function() {
			 
			$('#modal-registra-detalle').modal('show'); //HACE VISIBLE EN LA PANTALLA PRINCIPAL EL FORMULARIO DETALLE
			$.unblockUI();
			
		}
	});
}

function modificarDetalle2(id) {

	$.ajax({
		type: 'GET',
		url: 'formularioDetalleGet/'+id, //LLAMA AL CONTROLER DEVUELVE UNA PAGINA(PAGINA DETALLE)
		success: function(result) {
			$('#id-modal-content-verif').replaceWith(result); //ESA PAGINA SE INYECTA EN LA PAGINA PRINCIPAL
			
			$('#idFormularioHeader').val(idCabecera);			
			
			cargarCombo("listSubactividades","#cboLocalMuestreo");
			cargarCombo("listPuntos","#cboEstacionMuestreo");
			
			$('#idModalEditTitle').html($('#idValEditModalDetalleTitle').html());
			
//			if(idCabecera != 0){
//				$('#idModalEditTitle').html($('#idValEditModalDetalleTitle').html());
//
//			}else{
//				$('#idModalEditTitle').html($('#idValCrearModalDetalleTitle').html());
//			}
			enableValidationRulesVerificacion();								
		},complete: function() {
			
			setTimeout(function(){
				
				$('#cboLocalMuestreo').val($('#cboLocalidadHidden').val());
				$('#cboEstacionMuestreo').val($('#cboEstacionHidden').val());
			}, 500);
			 
			$('#modal-registra-detalle').modal('show'); //HACE VISIBLE EN LA PANTALLA PRINCIPAL EL FORMULARIO DETALLE
			$.unblockUI();
			
		}
	});
}


function enableValidationRules() {

	var validator = $("#form-edit-turbidimetroDigital-id").bootstrapValidator({
		message: 'El valor no es v\u00e1lido',
		feedbackIcons : {
			valid : "glyphicon glyphicon-ok",
			invalid : "glyphicon glyphico-remove",
			validating : "glyphicon glyphicon-refresh"
		},
		fields : {
			strFechaMuestreo: {
					validators : {
						
						notEmpty: {
	                        message: 'Ingrese la Fecha'
	                    }
					}
			},
			strFechaRecepcion: {
					validators : {
						
						notEmpty: {
	                        message: 'Ingrese la Fecha'
	                    }		
						
					}
			},
            
		}
	})	
	.on('success.form.bv', function(e, data) {
		$("#guardarButton").html('Guardando...');
		$("#guardarButton").attr('disabled', 'disabled');
		e.preventDefault();
		var $nuevoTurbidimetroDigitalForm = $(e.target);
		$.ajax({
			type: 'POST',
			url: $('#form-edit-turbidimetroDigital-id').attr('action'),
			data: $('#form-edit-turbidimetroDigital-id').serialize(),
			success: function(result){
				$nuevoTurbidimetroDigitalForm.bootstrapValidator('resetForm', true);
				$nuevoTurbidimetroDigitalForm[0].reset();
				$('.container_save').html(result);
			},
			complete: function() {
				$("#guardarButton").html('Guardar');
				$('#guardarButton').removeAttr("disabled");
			}
		});
	});	
}



function enableValidationRulesVerificacion() {
	
var TIME_PATTERN = /^([01]?[0-9]|2[0-3]):([0-5][0-9])$/;
	
	$('#hora').datetimepicker({
		//defaultDate: new Date(),
        format: 'HH:mm',
        ignoreReadonly: true,
        locale: "es"
    }).on('dp.change dp.show', function (e) {
        $('#form-edit-Detalle-id').bootstrapValidator('revalidateField', 'hora');
    });
	

	$("#form-edit-Detalle-id").bootstrapValidator({
//	var validator = $("#form-edit-turbidimetroDigitalVerif-id").bootstrapValidator({
		message: 'El valor no es v\u00e1lido',
		feedbackIcons : {
			valid : "glyphicon glyphicon-ok",
			invalid : "glyphicon glyphico-remove",
			validating : "glyphicon glyphicon-refresh"
		},
		fields : {
			
			
			ph: {
				validators : {
							
					stringLength : {
						max : 8,
						message : "El valor ha de ser como m\u00e1ximo 8 caracteres"
					},			
					regexp: {
						 
						 regexp: /^[0-9]+([.][0-9]+)?$/, 
	 
						 message: 'Valor incorrecto'
	 
					}
				}
			},
			
			temperatura: {
				validators : {
							
					stringLength : {
						max : 8,
						message : "El valor ha de ser como m\u00e1ximo 8 caracteres"
					},			
					regexp: {
						 
						 regexp: /^[0-9]+([.][0-9]+)?$/, 
	 
						 message: 'Valor incorrecto'
	 
					}
				}
			},
			
			conductividad: {
				validators : {
							
					stringLength : {
						max : 8,
						message : "El valor ha de ser como m\u00e1ximo 8 caracteres"
					},			
					regexp: {
						 
						 regexp: /^[0-9]+([.][0-9]+)?$/, 
	 
						 message: 'Valor incorrecto'
	 
					}
				}
			},
			
			turbiedad: {
				validators : {
							
					stringLength : {
						max : 8,
						message : "El valor ha de ser como m\u00e1ximo 8 caracteres"
					},			
					regexp: {
						 
						 regexp: /^[0-9]+([.][0-9]+)?$/, 
	 
						 message: 'Valor incorrecto'
	 
					}
				}
			},
          
			oxigeno: {
				validators : {
							
					stringLength : {
						max : 8,
						message : "El valor ha de ser como m\u00e1ximo 8 caracteres"
					},			
					regexp: {
						 
						 regexp: /^[0-9]+([.][0-9]+)?$/, 
	 
						 message: 'Valor incorrecto'
	 
					}
				}
			},
			
			clorofila: {
				validators : {
							
					stringLength : {
						max : 8,
						message : "El valor ha de ser como m\u00e1ximo 8 caracteres"
					},			
					regexp: {
						 
						 regexp: /^[0-9]+([.][0-9]+)?$/, 
	 
						 message: 'Valor incorrecto'
	 
					}
				}
			},
			
			coordenadaW: {
				validators : {
							
					stringLength : {
						max : 8,
						message : "El valor ha de ser como m\u00e1ximo 8 caracteres"
					},			
					regexp: {
						 
						 regexp: /^[0-9]+([.][0-9]+)?$/, 
	 
						 message: 'Valor incorrecto'
	 
					}
				}
			},
           
			altura: {
				validators : {
							
					stringLength : {
						max : 8,
						message : "El valor ha de ser como m\u00e1ximo 8 caracteres"
					},			
					regexp: {
						 
						 regexp: /^[0-9]+([.][0-9]+)?$/, 
	 
						 message: 'Valor incorrecto'
	 
					}
				}
			},
			
			ficocianina: {
				validators : {
							
					stringLength : {
						max : 8,
						message : "El valor ha de ser como m\u00e1ximo 8 caracteres"
					},			
					regexp: {
						 
						 regexp: /^[0-9]+([.][0-9]+)?$/, 
	 
						 message: 'Valor incorrecto'
	 
					}
				}
			},
			
			coordenadaE: {
				validators : {
							
					stringLength : {
						max : 8,
						message : "El valor ha de ser como m\u00e1ximo 8 caracteres"
					},			
					regexp: {
						 
						 regexp: /^[0-9]+([.][0-9]+)?$/, 
	 
						 message: 'Valor incorrecto'
	 
					}
				}
			},
			
			observaciones: {
				validators : {
							
					stringLength : {
						max : 400,
						message : "El valor ha de ser como m\u00e1ximo 400 caracteres"
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

				}
			},
            
		}
	})	
	.on('success.form.bv', function(e, data) {
		$("#guardarButton").html('Guardando...');
		$("#guardarButton").attr('disabled', 'disabled');
		e.preventDefault();
		var $nuevoTurbidimetroDigitalVerificacionForm = $(e.target);
		$.ajax({
			type: 'POST',
			url: $('#form-edit-Detalle-id').attr('action'),
			data: $('#form-edit-Detalle-id').serialize(),
			success: function(result){
				$nuevoTurbidimetroDigitalVerificacionForm.bootstrapValidator('resetForm', true);
				$nuevoTurbidimetroDigitalVerificacionForm[0].reset();
				$('.container_save').html(result);
			},
			complete: function() {
				
				$("#guardarButton").html('Guardar');
				$('#guardarButton').removeAttr("disabled");
			}
		});
	});	
}



//FUNCION PARA INACTIVAR UN REGISTRO
function inactivarHeader(id) {
	$.confirm({
	    title: 'Confirmaci\u00f3n',
	    content: 'Confirma inactivar Registro ?',
	    buttons: {
	    	Aceptar: { 
	        	btnClass: 'btn-blue',
	        	action: function () {
		        	$('#inacIdHeader').val(id); 
				    $.ajax({
			    	   type: 'POST',
			    	   url: $('#form-inactiva-header242').attr('action'),
			    	   data: $('#form-inactiva-header242').serialize(),  
			    	   success: function(result){  		   
			    	       $('.container_save').html(result);		    	      
				    	   },
							complete: function() {
								$.unblockUI();
							}
				    	}); 
		        	}
		        },
		        Cancelar: {
		        }
		    }
		});	   
};

//FUNCION PARA INACTIVAR UN REGISTRO
function inactivarDetalle(id) {

	$.confirm({
	    title: 'Confirmaci\u00f3n',
	    content: 'Confirma inactivar Registro ?',
	    buttons: {
	    	Aceptar: { 
	        	btnClass: 'btn-blue',
	        	action: function () {
		        	$('#inactivarDetalleID').val(id); 
				    $.ajax({
			    	   type: 'POST',
			    	   url: $('#form-inactiva-detalle').attr('action'),
			    	   data: $('#form-inactiva-detalle').serialize(),  
			    	   success: function(result){  		
			    	       $('.container_save').html(result);		    	      
				    	   },
							complete: function(data) {
								$.unblockUI();
							}
				    	}); 
		        	}
		        },
		        Cancelar: {
		        }
		    }
		});	   
};

function showToastTurbidimetroDigital(mensajeTipo, mensajeError) {
	//Mensajes despues de grabar
	if(mensajeTipo==='grabadoOk'){
		 toastr["success"](mensajeError, "Registro correctamente guardado");
		 $('#modal-registra-formularioHeader').modal('hide');
		 $('#idBtnBuscarFormulario').click();
	 }
	 if(mensajeTipo==='grabadoNoOk'){
		 toastr["error"](mensajeError, "Hubo un error en el servidor, el registro no fue guardado");
	 }
	 //Mensajes despues de eliminar
	 if(mensajeTipo==='inactivadoOk'){
		 toastr["success"](mensajeError, "Registro correctamente inactivado");
//		 $('#modal-registra-formularioHeader').modal('hide');
		 $('#idBtnBuscarFormulario').click();
	 }
	 if(mensajeTipo==='inactivadoNoOk'){
		 toastr["error"](mensajeError, "Hubo un error en el servidor, el registro no fue inactivado");
	 }
	 if(mensajeTipo==='RegDuplicado'){
		 toastr["success"](mensajeError, "Registro ya existe en la Tabla");
		 $('#modal-registra-formularioHeader').modal('hide');
		 //$('#idBtnBuscarTurbidimetroDigital').click();
	 }
	 if(mensajeTipo==='grabadoOkSubForm'){
		 toastr["success"](mensajeError, "Registro agregado correctamente");
		 $('#modal-registra-detalle').modal('hide');
//		 $('#idCodigoVerifEquipo').val($('#intCodigo').val());
		 $('#myTableDetalle').DataTable().ajax.reload();   //LLAMA AL DATATABLE DETALLE A TRAVES DE SU ID
	 }
	 if(mensajeTipo==='inactivadoOkSubForm'){

		 toastr["success"](mensajeError, "Registro correctamente inactivado");
		 //$('#modal-registra-turbidimetroDigitalVerif').modal('hide');
		 $('#idCodigoVerifEquipo').val($('#intCodigo').val());
		 $('#myTableTurbidimetroDigitalVerif').DataTable().ajax.reload();
	 }
}

