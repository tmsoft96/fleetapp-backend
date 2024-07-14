
$('document').ready(function() {

	$('table #editButton').on('click', function(event) {
		event.preventDefault();

		// /suppliers/findById?id=1
		var href = $(this).attr('href');
		$.get(href, function(value, status) {
			$('#idEdit').val(value.id);
			$('#nameEdit').val(value.name);
			$('#detialsEdit').val(value.details);
			$('#websiteEdit').val(value.website);
			$('#addressEdit').val(value.address);
			$('#stateEdit').val(value.stateid);
			$('#countryEdit').val(value.countryid);
			$('#cityEdit').val(value.city);
			$('#phoneEdit').val(value.phone);
			$('#mobileEdit').val(value.mobile);
			$('#emailEdit').val(value.email);
		});

		$('#editModal').modal('show');
	});

	$('table #deleteButton').on('click', function(event) {
		event.preventDefault();

		// /suppliers/delete?id=1
		var href = $(this).attr('href');
		$('#confirmDeleteButton').attr('href', href);

		$('#deleteModal').modal('show');
	});

	$('table #detailsButton').on('click', function(event) {
		event.preventDefault();

		// /suppliers/findById?id=1
		var href = $(this).attr('href');
		$.get(href, function(value, status) {
			$('#idDetail').val(value.id);
			$('#nameDetail').val(value.name);
			$('#detialsDetail').val(value.details);
			$('#websiteDetail').val(value.website);
			$('#addressDetail').val(value.address);
			$('#stateDetail').val(value.state.name);
			$('#countryDetail').val(value.country.description);
			$('#cityDetail').val(value.city);
			$('#phoneDetail').val(value.phone);
			$('#mobileDetail').val(value.mobile);
			$('#emailDetail').val(value.email);
		});

		$('#detailsModal').modal('show');
	});
});