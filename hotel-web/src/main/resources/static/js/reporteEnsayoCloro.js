
$(document).ready(function() {
	
	//MANEJO DEL FORMULARIO DE BUSQUEDA
	$('#idBtnBuscarTablaPoisson').click(function () {		 
		 $('#cboLambdasHidden').val($('#cboLambdas').val());
		 $('#myTableTablaPoisson').DataTable().ajax.reload();
	});
	
	//CARGA EL COMBO DE LAMBDAS
//	cargarCombo("listAreas","#cboAreas");
//	cargarComboTodos("listAreas","#cboAreasPlan");
	
	
});

function buscarReporteEnsayoXFecha(){
	
	console.log("buscando valores ensayo");
	$.ajax({
		type: 'POST',
		url: 'reporteEnsayoCloroSearch',
		data: dataSearchXFecha(),
		success: function(result){
			$('#tableResult').html(result);
//			$('#modal-registra-parametroplan').modal('show');
			
//				cargarCombo("listComboMeses","#cboMeses");
//				calcularTotales();
//				dataRefrescarDatos();
		},
		complete: function() {
			$("#guardarButton").html('Guardar');
			$('#guardarButton').removeAttr("disabled");
//			enableValidationRulesBandeja1();
		}
	});
}

function dataSearchXFecha(){
	var data = {};
	data.fechaMuestreo = $("#idFechaMuestreo").val();
	data.horaMuestreo = $("#idHoraMuestreo").val();
	return data;
}


