
$('document').ready(function() {

	$('table #editButton').on('click', function(event) {
		event.preventDefault();

		// /vehicletypes/findById?id=1
		var href = $(this).attr('href');
		$.get(href, function(vehicleType, status) {
			$('#idEdit').val(vehicleType.id);
			$('#descriptionEdit').val(vehicleType.description);
			$('#detailsEdit').val(vehicleType.details);
		});

		$('#editModal').modal('show');
	});

	$('table #deleteButton').on('click', function(event) {
		event.preventDefault();

		// /vehicletypes/delete?id=1
		var href = $(this).attr('href');
		$('#confirmDeleteButton').attr('href', href);

		$('#deleteModal').modal('show');
	});

	$('table #detailsButton').on('click', function(event) {
		event.preventDefault();

		// /vehicletypes/findById?id=1
		var href = $(this).attr('href');
		$.get(href, function(vehicleType, status) {
			$('#tableDetails').empty();
			$('#tableDetails').append('<tr><td>Id</td><td>'+vehicleType.id+'</td></tr>');
			$('#tableDetails').append('<tr><td>Description</td><td>'+vehicleType.description+'</td></tr>');
			$('#tableDetails').append('<tr><td>Details</td><td>'+vehicleType.details+'</td></tr>');
		});

		$('#detailsModal').modal('show');
	});
});