
$('document').ready(function() {

	$('table #editButton').on('click', function(event) {
		event.preventDefault();

		// /vehiclemodels/findById?id=1
		var href = $(this).attr('href');
		$.get(href, function(vehicleModel, status) {
			$('#idEdit').val(vehicleModel.id);
			$('#descriptionEdit').val(vehicleModel.description);
			$('#detailsEdit').val(vehicleModel.details);
		});

		$('#editModal').modal('show');
	});

	$('table #deleteButton').on('click', function(event) {
		event.preventDefault();

		// /vehiclemodels/delete?id=1
		var href = $(this).attr('href');
		$('#confirmDeleteButton').attr('href', href);

		$('#deleteModal').modal('show');
	});

	$('table #detailsButton').on('click', function(event) {
		event.preventDefault();

		// /vehiclemodels/findById?id=1
		var href = $(this).attr('href');
		$.get(href, function(vehicleModel, status) {
			$('#tableDetails').empty();
			$('#tableDetails').append('<tr><td>Id</td><td>'+vehicleModel.id+'</td></tr>');
			$('#tableDetails').append('<tr><td>Description</td><td>'+vehicleModel.description+'</td></tr>');
			$('#tableDetails').append('<tr><td>Details</td><td>'+vehicleModel.details+'</td></tr>');
		});

		$('#detailsModal').modal('show');
	});
});