
$('document').ready(function() {

	$('table #editButton').on('click', function(event) {
		event.preventDefault();

		// /invoicestatus/findById?id=1
		var href = $(this).attr('href');
		$.get(href, function(invoiceStatus, status) {
			$('#idEdit').val(invoiceStatus.id);
			$('#descriptionEdit').val(invoiceStatus.description);
			$('#detailsEdit').val(invoiceStatus.details);
		});

		$('#editModal').modal('show');
	});

	$('table #deleteButton').on('click', function(event) {
		event.preventDefault();

		// /invoicestatus/delete?id=1
		var href = $(this).attr('href');
		$('#confirmDeleteButton').attr('href', href);

		$('#deleteModal').modal('show');
	});

	$('table #detailsButton').on('click', function(event) {
		event.preventDefault();

		// /invoicestatus/findById?id=1
		var href = $(this).attr('href');
		$.get(href, function(invoiceStatus, status) {
			$('#tableDetails').empty();
			$('#tableDetails').append('<tr><td>Id</td><td>'+invoiceStatus.id+'</td></tr>');
			$('#tableDetails').append('<tr><td>Description</td><td>'+invoiceStatus.description+'</td></tr>');
			$('#tableDetails').append('<tr><td>Details</td><td>'+invoiceStatus.details+'</td></tr>');
		});

		$('#detailsModal').modal('show');
	});
});