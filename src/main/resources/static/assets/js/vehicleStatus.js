
$('document').ready(function() {

	$('table #editButton').on('click', function(event) {
		event.preventDefault();

		// /vehiclestatus/findById?id=1
		var href = $(this).attr('href');
		$.get(href, function(vehicleStatus, status) {
			$('#idEdit').val(vehicleStatus.id);
			$('#descriptionEdit').val(vehicleStatus.description);
			$('#detailsEdit').val(vehicleStatus.details);
		});

		$('#editModal').modal('show');
	});

	$('table #deleteButton').on('click', function(event) {
		event.preventDefault();

		// /vehiclestatus/delete?id=1
		var href = $(this).attr('href');
		$('#confirmDeleteButton').attr('href', href);

		$('#deleteModal').modal('show');
	});

	$('table #detailsButton').on('click', function(event) {
		event.preventDefault();

		// /vehiclestatus/findById?id=1
		var href = $(this).attr('href');
		$.get(href, function(vehicleStatus, status) {
			$('#tableDetails').empty();
			$('#tableDetails').append('<tr><td>Id</td><td>'+vehicleStatus.id+'</td></tr>');
			$('#tableDetails').append('<tr><td>Description</td><td>'+vehicleStatus.description+'</td></tr>');
			$('#tableDetails').append('<tr><td>Details</td><td>'+vehicleStatus.details+'</td></tr>');
		});

		$('#detailsModal').modal('show');
	});
});