
$(document).ready(function() {
	
	//MANEJO DEL FORMULARIO DE BUSQUEDA
	$('#idBtnBuscarPhmetroDigital').click(function () {		 
		 $('#myTablePhmetroDigital').DataTable().ajax.reload();
	});
	
});

function modificarPhmetroDigital(id) {
	
	MYAPPL.blockPageLoad();
	$.ajax({
		type: 'GET',
		url: 'phmetroDigitalGet/'+id, 
		success: function(result) {
			$('#id-modal-content').replaceWith(result);
			
			
			
			if(id != -1){
				$("#strCodEquipo").attr('disabled', 'disabled');
				$('#idModalTitle').html($('#idValEditModalTitle').html());
			}else{
				$('#idModalTitle').html($('#idValCrearModalTitle').html());
			}
			enableValidationRules();
		},complete: function() {
			$('#modal-registra-phmetroDigital').modal('show');
			$.unblockUI();
			
		}
	});
}

//FUNCION PARA HABILITAR LAS VALIDACIONES EN EL FORMULARIO DE CREACION O EDICION
function enableValidationRules() {
		
	var validator = $("#form-edit-phmetroDigital-id").bootstrapValidator({
		message: 'El valor no es v\u00e1lido',
		excluded: [':disabled', ':hidden', '#strParaAdd', '#strCcAdd'],
		feedbackIcons : {
			valid : "glyphicon glyphicon-ok",
			invalid : "glyphicon glyphico-remove",
			validating : "glyphicon glyphicon-refresh"
		},
		fields : {			
			strCodEquipo: {
				validators : {
							
					stringLength : {
						max : 20,
						message : "El valor ha de ser como m\u00e1ximo 20 caracteres"
					},
					notEmpty: {
                        message: 'Ingrese Código de equipo'
                    }
				}
			}			
		}
	})	
	.on('success.form.bv', function(e, data) {
		$("#guardarButton").html('Guardando...');
		$("#guardarButton").attr('disabled', 'disabled');
		e.preventDefault();
		var $nuevoPhmetroDigitalForm = $(e.target);
		$.ajax({
			type: 'POST',
			url: $('#form-edit-phmetroDigital-id').attr('action'),
			data: $('#form-edit-phmetroDigital-id').serialize(),
			success: function(result){
				$nuevoPhmetroDigitalForm.bootstrapValidator('resetForm', true);
				$nuevoPhmetroDigitalForm[0].reset();
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
function inactivarPhmetroDigital(id) {
	$.confirm({
	    title: 'Confirmaci\u00f3n',
	    content: 'Confirma inactivar Registro ?',
	    buttons: {
	    	Aceptar: { 
	        	btnClass: 'btn-blue',
	        	action: function () {
		        	$('#inacId').val(id); 
				    $.ajax({
			    	   type: 'POST',
			    	   url: $('#form-inactiva-phmetroDigital').attr('action'),
			    	   data: $('#form-inactiva-phmetroDigital').serialize(),  
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
}

var idPhMetro;
function modificarPhmetroDigitalDetalle(id) {
	idPhMetro=id;
	MYAPPL.blockPageLoad();
	$.ajax({
		type: 'GET',
		url: 'phmetroDigitalDetalleGet/'+id, 
		success: function(result) {
			$('#id-modal-content-detalle').replaceWith(result);
			
			$('#idCodigoPHmetro').val(id);
			
			if(id != -1){
				$("#strNomEquipo2").attr('disabled', 'disabled');
				$("#strCodEquipo2").attr('disabled', 'disabled');
				$("#strMarca2").attr('disabled', 'disabled');
				$("#strModelo2").attr('disabled', 'disabled');
				$("#strNroSerie2").attr('disabled', 'disabled');
				
				$('#idModalTitle').html($('#idValEditModalTitle').html());
			}else{
				$('#idModalTitle').html($('#idValCrearModalTitle').html());
			}
		},complete: function() {
			$('#modal-registra-phmetroDigital-detalle').modal('show');
			$.unblockUI();
			
		}
	});
}


function modificarPhmetroDigitalDetalleEdit() {
	//alert(idPhMetro);
	MYAPPL.blockPageLoad();
	$.ajax({
		type: 'GET',
		url: 'phmetroDigitalDetalleEditGet/'+idPhMetro, 
		success: function(result) {
			$('#id-modal-content-detalle-edit').replaceWith(result);
			
			$('#intIdPhmetroDigital').val(idPhMetro);
			
			$('#strFecha').datetimepicker({
			      //  format: 'DD/MM/YYYY HH:mm:SS',
					format: 'DD/MM/YYYY',
			        ignoreReadonly: false,
			        date: new Date(),
			        locale: "es"
			    });
						
			$('#idModalTitle').html($('#idValCrearModalTitle').html());
			enableValidationRulesDetalle();
		},complete: function() {
			$('#modal-registra-phmetroDigital-detalle-edit').modal('show');
			$.unblockUI();
			
		}
	});
}

function enableValidationRulesDetalle() {

	var validator = $("#form-edit-phmetroDigitalDetalleEdit-id").bootstrapValidator({
		message: 'El valor no es v\u00e1lido',
		feedbackIcons : {
			valid : "glyphicon glyphicon-ok",
			invalid : "glyphicon glyphico-remove",
			validating : "glyphicon glyphicon-refresh"
		},
		fields : {
			
			strFecha: {
				validators : {
							
					notEmpty: {
                        message: 'Ingrese Fecha'
                    }		
					
				}
			},
			strcalibracion1: {
				validators : {
							
					stringLength : {
						max : 20,
						message : "El valor ha de ser como m\u00e1ximo 20 caracteres"
					},			
					regexp: {
						 
						 regexp: /^[0-9]+([.][0-9]+)?$/, 
	 
						 message: 'Valor incorrecto'
	 
					}
				}
			},
			strcalibracion2: {
				validators : {
							
					stringLength : {
						max : 20,
						message : "El valor ha de ser como m\u00e1ximo 20 caracteres"
					},			
					regexp: {
						 
						 regexp: /^[0-9]+([.][0-9]+)?$/, 
	 
						 message: 'Valor incorrecto'
	 
					}
				}
			},
			strcalibracion3: {
				validators : {
							
					stringLength : {
						max : 20,
						message : "El valor ha de ser como m\u00e1ximo 20 caracteres"
					},			
					regexp: {
						 
						 regexp: /^[0-9]+([.][0-9]+)?$/, 
	 
						 message: 'Valor incorrecto'
	 
					}
				}
			},
			strVerificacion1: {
				validators : {
							
					stringLength : {
						max : 20,
						message : "El valor ha de ser como m\u00e1ximo 20 caracteres"
					},			
					regexp: {
						 
						 regexp: /^[0-9]+([.][0-9]+)?$/, 
	 
						 message: 'Valor incorrecto'
	 
					}
				}
			},
			strVerificacion2: {
				validators : {
							
					stringLength : {
						max : 20,
						message : "El valor ha de ser como m\u00e1ximo 20 caracteres"
					},			
					regexp: {
						 
						 regexp: /^[0-9]+([.][0-9]+)?$/, 
	 
						 message: 'Valor incorrecto'
	 
					}
				}
			},
			strVerificacion3: {
				validators : {
							
					stringLength : {
						max : 20,
						message : "El valor ha de ser como m\u00e1ximo 20 caracteres"
					},			
					regexp: {
						 
						 regexp: /^[0-9]+([.][0-9]+)?$/, 
	 
						 message: 'Valor incorrecto'
	 
					}
				}
			}
			
		}
	})	
	.on('success.form.bv', function(e, data) {
		$("#guardarButton").html('Guardando...');
		$("#guardarButton").attr('disabled', 'disabled');
		e.preventDefault();
		var $nuevoPhmetroDigitalDetalleEditForm = $(e.target);
		$.ajax({
			type: 'POST',
			url: $('#form-edit-phmetroDigitalDetalleEdit-id').attr('action'),
			data: $('#form-edit-phmetroDigitalDetalleEdit-id').serialize(),
			success: function(result){
				$nuevoPhmetroDigitalDetalleEditForm.bootstrapValidator('resetForm', true);
				$nuevoPhmetroDigitalDetalleEditForm[0].reset();
				$('.container_save').html(result);
			},
			complete: function() {
				
				$("#guardarButton").html('Guardar');
				$('#guardarButton').removeAttr("disabled");
			}
		});
	});	
}

function inactivarPhmetroDigitalDetalle(id) {
	$.confirm({
	    title: 'Confirmaci\u00f3n',
	    content: 'Confirma inactivar Registro ?',
	    buttons: {
	    	Aceptar: { 
	        	btnClass: 'btn-blue',
	        	action: function () {
		        	$('#inacIdDetalle').val(id); 
				    $.ajax({
			    	   type: 'POST',
			    	   url: $('#form-inactiva-phmetroDigitalDetalle').attr('action'),
			    	   data: $('#form-inactiva-phmetroDigitalDetalle').serialize(),  
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
}

function showToastPhmetroDigital(mensajeTipo, mensajeError) {
	//Mensajes despues de grabar
	if(mensajeTipo==='grabadoOk'){
		 toastr["success"](mensajeError, "Registro correctamente guardado");
		 $('#modal-registra-phmetroDigital').modal('hide');
		 $('#idBtnBuscarPhmetroDigital').click();
	 }
	 if(mensajeTipo==='grabadoNoOk'){
		 toastr["error"](mensajeError, "Hubo un error en el servidor, el registro no fue guardado");
	 }
	 //Mensajes despues de eliminar
	 if(mensajeTipo==='inactivadoOk'){
		 toastr["success"](mensajeError, "Registro correctamente inactivado");
		 $('#modal-registra-phmetroDigital').modal('hide');
		 $('#idBtnBuscarPhmetroDigital').click();
	 }
	 if(mensajeTipo==='inactivadoNoOk'){
		 toastr["error"](mensajeError, "Hubo un error en el servidor, el registro no fue inactivado");
	 }
	 if(mensajeTipo==='RegDuplicado'){
		 toastr["error"](mensajeError, "Registro ya existe en la Tabla");
		 //$('#modal-registra-phmetroDigital').modal('hide');
		 //$('#idBtnBuscarPhmetroDigital').click();
	 }
	 if(mensajeTipo==='grabadoOkSubForm'){
		 toastr["success"](mensajeError, "Registro agregado correctamente");
		 $('#modal-registra-phmetroDigital-detalle-edit').modal('hide');
		 $('#myTablePhmetroDigitalDetalle').DataTable().ajax.reload();
	 }
	 if(mensajeTipo==='inactivadoSubFormOk'){
		 toastr["success"](mensajeError, "Registro agregado correctamente");
		 $('#myTablePhmetroDigitalDetalle').DataTable().ajax.reload();
	 }
}
	 
