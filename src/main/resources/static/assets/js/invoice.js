
$('document').ready(function() {

	let dateDisplay = document.getElementsByClassName("displayInvoiceDate");
	for (var x = 0; x < dateDisplay.length; ++x) {
		let formatedDate = dateDisplay[x].innerHTML.substring(0, 10);
		dateDisplay[x].innerHTML = formatedDate;
	}

	$('table #editButton').on('click', function(event) {
		event.preventDefault();

		// /invoices/findById?id=1
		var href = $(this).attr('href');
		$.get(href, function(value, status) {
			$('#idEdit').val(value.id);
			$('#clientEdit').val(value.clientid);

			var invoiceDate = value.invoiceDate.substr(0, 10);
			$('#invoiceDateEdit').val(invoiceDate);

			$('#invoiceStatusEdit').val(value.invoicestatusid);
			$('#remarksEdit').val(value.remarks);
		});

		$('#editModal').modal('show');
	});

	$('table #deleteButton').on('click', function(event) {
		event.preventDefault();

		// /invoices/delete?id=1
		var href = $(this).attr('href');
		$('#confirmDeleteButton').attr('href', href);

		$('#deleteModal').modal('show');
	});

	$('table #detailsButton').on('click', function(event) {
		event.preventDefault();

		// /invoices/findById?id=1
		var href = $(this).attr('href');
		$.get(href, function(value, status) {
			$('#idDetails').val(value.id);
			$('#clientDetails').val(value.client.name);

			var invoiceDate = value.invoiceDate.substr(0, 10);
			$('#invoiceDateDetails').val(invoiceDate);

			$('#invoiceStatusDetails').val(value.invoiceStatus.description);
			$('#remarksDetails').val(value.remarks);
		});

		$('#detailsModal').modal('show');
	});
});