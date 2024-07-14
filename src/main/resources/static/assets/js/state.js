
$('document').ready(function() {

	$('table #editButton').on('click', function(event) {
		event.preventDefault();

		// /states/findById?id=1
		var href = $(this).attr('href');
		$.get(href, function(state, status) {
			console.log(state);
			$('#idEdit').val(state.id);
			$('#nameEdit').val(state.name);
			$('#capitalEdit').val(state.capital);
			$('#codeEdit').val(state.code);
			$('#countryEdit').val(state.countryid);
			$('#detailsEdit').val(state.details);
		});

		$('#editModal').modal('show');
	});

	$('table #deleteButton').on('click', function(event) {
		event.preventDefault();

		// /states/delete?id=1
		var href = $(this).attr('href');
		$('#confirmDeleteButton').attr('href', href);

		$('#deleteModal').modal('show');
	});

	$('table #detailsButton').on('click', function(event) {
		event.preventDefault();

		// /states/findById?id=1
		var href = $(this).attr('href');
		$.get(href, function(state, status) {
			$('#tableDetails').empty();
			$('#tableDetails').append('<tr><td>Id</td><td>'+state.id+'</td></tr>');
			$('#tableDetails').append('<tr><td>Name</td><td>'+state.name+'</td></tr>');
			$('#tableDetails').append('<tr><td>Capital</td><td>'+state.capital+'</td></tr>');
			$('#tableDetails').append('<tr><td>Code</td><td>'+state.code+'</td></tr>');
			$('#tableDetails').append('<tr><td>Country</td><td>'+state.country.description+'</td></tr>');
			$('#tableDetails').append('<tr><td>Details</td><td>'+state.details+'</td></tr>');
		});

		$('#detailsModal').modal('show');
	});
});