
$('document').ready(function() {

	$('table #editButton').on('click', function(event) {
		event.preventDefault();

		// /vehiclemaintenances/findById?id=1
		var href = $(this).attr('href');
		$.get(href, function(value, status) {
			$('#idEdit').val(value.id);
			$('#vehicleEdit').val(value.vehicleid);
			
			var startDate = value.startDate.substr(0,10);
			$('#startDateEdit').val(startDate);
			
			$('#remarksEdit').val(value.remarks);
			
			var endDate = value.endDate.substr(0,10);
			$('#endDateEdit').val(endDate);
			
			$('#supplierEdit').val(value.supplierid);
			$('#priceEdit').val(value.price);
		});

		$('#editModal').modal('show');
	});

	$('table #deleteButton').on('click', function(event) {
		event.preventDefault();

		// /vehiclemaintenances/delete?id=1
		var href = $(this).attr('href');
		$('#confirmDeleteButton').attr('href', href);

		$('#deleteModal').modal('show');
	});

	$('table #detailsButton').on('click', function(event) {
		event.preventDefault();

		// /vehiclemaintenances/findById?id=1
		var href = $(this).attr('href');
		$.get(href, function(value, status) {
			$('#tableDetails').empty();
			$('#tableDetails').append('<tr><td>Id</td><td>' + value.id + '</td></tr>');
			$('#tableDetails').append('<tr><td>Vehicle</td><td>' + value.vehicle.name + '</td></tr>');
			
			var startDate = value.startDate.substr(0,10);
			$('#tableDetails').append('<tr><td>Start Date</td><td>' + startDate + '</td></tr>');
			
			$('#tableDetails').append('<tr><td>Remarks</td><td>' + value.remarks + '</td></tr>');
			
			var endDate = value.endDate.substr(0,10);
			$('#tableDetails').append('<tr><td>End Date</td><td>' + endDate + '</td></tr>');
			
			$('#tableDetails').append('<tr><td>Supplier</td><td>' + value.supplier.name + '</td></tr>');
			$('#tableDetails').append('<tr><td>Price</td><td>' + value.price + '</td></tr>');
		});

		$('#detailsModal').modal('show');
	});
});