
$('document').ready(function() {

	$('table #editButton').on('click', function(event) {
		event.preventDefault();

		// /countries/findById?id=1
		var href = $(this).attr('href');
		$.get(href, function(country, status) {
			$('#idEdit').val(country.id);
			$('#descriptionEdit').val(country.description);
			$('#capitalEdit').val(country.capital);
			$('#codeEdit').val(country.code);
			$('#continentEdit').val(country.continent);
			$('#nationalityEdit').val(country.nationality);
		});

		$('#editModal').modal('show');
	});

	$('table #deleteButton').on('click', function(event) {
		event.preventDefault();

		// /countries/delete?id=1
		var href = $(this).attr('href');
		$('#confirmDeleteButton').attr('href', href);

		$('#deleteModal').modal('show');
	});

	$('table #detailsButton').on('click', function(event) {
		event.preventDefault();

		// /countries/findById?id=1
		var href = $(this).attr('href');
		$.get(href, function(country, status) {
			$('#tableDetails').empty();
			$('#tableDetails').append('<tr><td>Id</td><td>'+country.id+'</td></tr>');
			$('#tableDetails').append('<tr><td>Description</td><td>'+country.description+'</td></tr>');
			$('#tableDetails').append('<tr><td>Capital</td><td>'+country.capital+'</td></tr>');
			$('#tableDetails').append('<tr><td>Code</td><td>'+country.code+'</td></tr>');
			$('#tableDetails').append('<tr><td>Continent</td><td>'+country.continent+'</td></tr>');
			$('#tableDetails').append('<tr><td>Nationality</td><td>'+country.nationality+'</td></tr>');
		});

		$('#detailsModal').modal('show');
	});
});