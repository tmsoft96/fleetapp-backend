
$('document').ready(function() {

	$('table #editButton').on('click', function(event) {
		event.preventDefault();

		// /locations/findById?id=1
		var href = $(this).attr('href');
		$.get(href, function(location, status) {
			$('#idEdit').val(location.id);
			$('#addressEdit').val(location.address);
			$('#cityEdit').val(location.city);
			$('#countryEdit').val(location.countryid);
			$('#stateEdit').val(location.stateid);
			$('#descriptionEdit').val(location.description);
			$('#detailsEdit').val(location.details);
		});

		$('#editModal').modal('show');
	});

	$('table #deleteButton').on('click', function(event) {
		event.preventDefault();

		// /locations/delete?id=1
		var href = $(this).attr('href');
		$('#confirmDeleteButton').attr('href', href);

		$('#deleteModal').modal('show');
	});

	$('table #detailsButton').on('click', function(event) {
		event.preventDefault();

		// /locations/findById?id=1
		var href = $(this).attr('href');
		$.get(href, function(location, status) {
			$('#tableDetails').empty();
			$('#tableDetails').append('<tr><td>Id</td><td>'+location.id+'</td></tr>');
			$('#tableDetails').append('<tr><td>Address</td><td>'+location.address+'</td></tr>');
			$('#tableDetails').append('<tr><td>City</td><td>'+location.city+'</td></tr>');
			$('#tableDetails').append('<tr><td>Country</td><td>'+location.country.description+'</td></tr>');
			$('#tableDetails').append('<tr><td>State</td><td>'+location.state.name+'</td></tr>');
			$('#tableDetails').append('<tr><td>Description</td><td>'+location.description+'</td></tr>');
			$('#tableDetails').append('<tr><td>Details</td><td>'+location.details+'</td></tr>');
		});

		$('#detailsModal').modal('show');
	});
});