
$('document').ready(function() {

	$('table #editButton').on('click', function(event) {
		event.preventDefault();

		// /vehiclemakes/findById?id=1
		var href = $(this).attr('href');
		$.get(href, function(vehicleMake, status) {
			$('#idEdit').val(vehicleMake.id);
			$('#descriptionEdit').val(vehicleMake.description);
			$('#detailsEdit').val(vehicleMake.details);
		});

		$('#editModal').modal('show');
	});

	$('table #deleteButton').on('click', function(event) {
		event.preventDefault();

		// /vehiclemakes/delete?id=1
		var href = $(this).attr('href');
		$('#confirmDeleteButton').attr('href', href);

		$('#deleteModal').modal('show');
	});

	$('table #detailsButton').on('click', function(event) {
		event.preventDefault();

		// /vehiclemakes/findById?id=1
		var href = $(this).attr('href');
		$.get(href, function(vehicleMake, status) {
			$('#tableDetails').empty();
			$('#tableDetails').append('<tr><td>Id</td><td>'+vehicleMake.id+'</td></tr>');
			$('#tableDetails').append('<tr><td>Description</td><td>'+vehicleMake.description+'</td></tr>');
			$('#tableDetails').append('<tr><td>Details</td><td>'+vehicleMake.details+'</td></tr>');
		});

		$('#detailsModal').modal('show');
	});
});