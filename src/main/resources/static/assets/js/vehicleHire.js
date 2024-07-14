
$('document').ready(function() {

	$('table #editButton').on('click', function(event) {
		event.preventDefault();

		// /clients/findById?id=1
		var href = $(this).attr('href');
		$.get(href, function(value, status) {
			$('#idEdit').val(value.id);
			$('#vehicleEdit').val(value.vehicleid);
			$('#clientEdit').val(value.clientid);
			
			var dateOut = value.dateOut.substr(0, 10);
			$('#dateOutEdit').val(dateOut);
			
			$('#timeOutEdit').val(value.timeout);
			$('#destinationEdit').val(value.locationid);
			
			var dateIn = value.dateIn.substr(0, 10);
			$('#dateInEdit').val(dateIn);
			
			$('#timeInEdit').val(value.timeIn);
			$('#priceEdit').val(value.price);
			$('#remarksEdit').val(value.remarks);
		});

		$('#editModal').modal('show');
	});

	$('table #deleteButton').on('click', function(event) {
		event.preventDefault();

		// /clients/delete?id=1
		var href = $(this).attr('href');
		$('#confirmDeleteButton').attr('href', href);

		$('#deleteModal').modal('show');
	});

	$('table #detailsButton').on('click', function(event) {
		event.preventDefault();

		// /clients/findById?id=1
		var href = $(this).attr('href');
		$.get(href, function(value, status) {
			$('#idDetails').val(value.id);
			$('#vehicleDetails').val(value.vehicle.name);
			$('#clientDetails').val(value.client.name);
			
			var dateOut = value.dateOut.substr(0, 10);
			$('#dateOutDetails').val(dateOut);
			
			$('#timeOutDetails').val(value.timeout);
			$('#destinationDetails').val(value.location.description);
			
			var dateIn = value.dateIn.substr(0, 10);
			$('#dateInDetails').val(dateIn);
			
			$('#timeInDetails').val(value.timeIn);
			$('#priceDetails').val(value.price);
			$('#remarksDetails').val(value.remarks);
		});

		$('#detailsModal').modal('show');
	});
});