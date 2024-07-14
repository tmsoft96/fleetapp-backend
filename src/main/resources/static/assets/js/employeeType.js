
$('document').ready(function() {

	$('table #editButton').on('click', function(event) {
		event.preventDefault();

		// /employeetypes/findById?id=1
		var href = $(this).attr('href');
		$.get(href, function(employeeType, status) {
			$('#idEdit').val(employeeType.id);
			$('#descriptionEdit').val(employeeType.description);
			$('#detailsEdit').val(employeeType.details);
		});

		$('#editModal').modal('show');
	});

	$('table #deleteButton').on('click', function(event) {
		event.preventDefault();

		// /employeetypes/delete?id=1
		var href = $(this).attr('href');
		$('#confirmDeleteButton').attr('href', href);

		$('#deleteModal').modal('show');
	});

	$('table #detailsButton').on('click', function(event) {
		event.preventDefault();

		// /employeetypes/findById?id=1
		var href = $(this).attr('href');
		$.get(href, function(employeeType, status) {
			$('#tableDetails').empty();
			$('#tableDetails').append('<tr><td>Id</td><td>'+employeeType.id+'</td></tr>');
			$('#tableDetails').append('<tr><td>Description</td><td>'+employeeType.description+'</td></tr>');
			$('#tableDetails').append('<tr><td>Details</td><td>'+employeeType.details+'</td></tr>');
		});

		$('#detailsModal').modal('show');
	});
});