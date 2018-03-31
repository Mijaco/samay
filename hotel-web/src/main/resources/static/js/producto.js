/**
 * Hoja de scripts manejados en el mantenimiento de clima
 */
$(document).ready(function() {
	
	toastr.options = {
		"closeButton" : true,
		"debug" : false,
		"newestOnTop" : false,
		"progressBar" : false,
		"positionClass" : "toast-top-center",
		"preventDuplicates" : false,
		"showDuration" : "300",
		"hideDuration" : "1000",
		"timeOut" : "5000",
		"extendedTimeOut" : "1000",
		"showEasing" : "swing",
		"hideEasing" : "linear",
		"showMethod" : "fadeIn",
		"hideMethod" : "fadeOut"
	}
	
	//CARGA DE LOS DISTRITOS EN LA BUSQUEDA
//	cargarCombo("listLambdas","#cboAreas");
//	enableClientSideValidationClima();

});

//EVENTO DE CERRADO DE MODAL
$("#modal-registra-clima").on("hidden.bs.modal", function () {
	$("#codigo").val("");
});




function enableClientSideValidationClima() {
	var validator = $("#form-search-product")
	.bootstrapValidator({
		message: 'El valor no es v\u00e1lido',
		feedbackIcons : {
			valid : "glyphicon glyphicon-ok",
			invalid : "glyphicon glyphico-remove",
			validating : "glyphicon glyphicon-refresh"
		},
		excluded: [':disabled'],
		fields : {
			nombre :{
				validators : {
					stringLength : {
						max : 20,
						message : "La Descripci\u00f3n ha de ser como m\u00e1ximo 20 caracteres"
					},
					notEmpty: {
			            message: 'Ingrese el nombre de Clima'
			        }
				}
			}
			
		}
	})
	.on('success.form.bv', function(e, data) {
		$("#guardarButton").html('Guardando...');
		$("#guardarButton").attr('disabled', 'disabled');

		var datos = {}
		datos.nombre = $("#name").val();
//		e.preventDefault();
		
		
		$.ajax({
		type: 'GET',
		data: datos,
		url: 'buscarProductos',
		success: function(result) {
			console.log("result: " + result)
			$('.result-body').replace(result);
		},complete: function() {
			$.unblockUI();
			
		}
	});
//		buscarProducto("SAN");
		
	});
}


function filtrarProductos() {
	MYAPPL.blockPageLoad();
	var data = {};
	data.nombre = $("#name").val();
	console.log("Buscando : " + data.nombre)
	
	$.ajax({
		type: 'GET',
		data: data,
		url: 'buscarProductos',
		success: function(result) {
			console.log("result: " + result)
			$('.result-body').html(result);
		},complete: function() {
			$.unblockUI();
			
		}
	});
}



function addNewProduct() {

	$.ajax({
		type: 'GET',
		url: 'productNew', 
		success: function(result) {
			
			console.log(">> " + result);
			$('#id-modal-content').replaceWith(result);
			
//			if(id != 0){
//				$('#idModalTitle').html($('#idValEditModalTitle').html());
//				$("#intCodLambda").attr('disabled', 'disabled');
//				$("#strCodIgx").attr('disabled', 'disabled');
//			}else{
//				$('#idModalTitle').html($('#idValCrearModalTitle').html());
//			}
//			enableValidationRules();
		},complete: function() {
			$('#modal-registra-producto').modal('show');
			$.unblockUI();
			
		}
	});
}





