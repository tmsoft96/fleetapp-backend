
$('document').ready(function() {

	$('table #editButton').on('click', function(event) {
		event.preventDefault();

		// /jobtitles/findById?id=1
		var href = $(this).attr('href');
		$.get(href, function(jobTitle, status) {
			$('#idEdit').val(jobTitle.id);
			$('#descriptionEdit').val(jobTitle.description);
			$('#detailsEdit').val(jobTitle.details);
		});

		$('#editModal').modal('show');
	});

	$('table #deleteButton').on('click', function(event) {
		event.preventDefault();

		// /jobtitles/delete?id=1
		var href = $(this).attr('href');
		$('#confirmDeleteButton').attr('href', href);

		$('#deleteModal').modal('show');
	});

	$('table #detailsButton').on('click', function(event) {
		event.preventDefault();

		// /jobtitles/findById?id=1
		var href = $(this).attr('href');
		$.get(href, function(jobTitle, status) {
			$('#tableDetails').empty();
			$('#tableDetails').append('<tr><td>Id</td><td>'+jobTitle.id+'</td></tr>');
			$('#tableDetails').append('<tr><td>Description</td><td>'+jobTitle.description+'</td></tr>');
			$('#tableDetails').append('<tr><td>Details</td><td>'+jobTitle.details+'</td></tr>');
		});

		$('#detailsModal').modal('show');
	});
});