
$('document').ready(function() {

	$('table #editButton').on('click', function(event) {
		event.preventDefault();

		// /vehiclemovements/findById?id=1
		var href = $(this).attr('href');
		$.get(href, function(value, status) {
			$('#idEdit').val(value.id);
			$('#vehicleEdit').val(value.vehicleid);
			
			$('#departedAtEdit').val(value.locationid1);
			var departureDate = value.date1.substr(0,10);
			$('#departureDateEdit').val(departureDate);
			
			$('#arrivedAtEdit').val(value.locationid2);
			var arrivedDate = value.date2.substr(0,10);
			$('#arrivedDateEdit').val(arrivedDate);
			
			$('#remarksEdit').val(value.remarks);
		});

		$('#editModal').modal('show');
	});

	$('table #deleteButton').on('click', function(event) {
		event.preventDefault();

		// /vehiclemovements/delete?id=1
		var href = $(this).attr('href');
		$('#confirmDeleteButton').attr('href', href);

		$('#deleteModal').modal('show');
	});

	$('table #detailsButton').on('click', function(event) {
		event.preventDefault();

		// /vehiclemovements/findById?id=1
		var href = $(this).attr('href');
		$.get(href, function(value, status) {
			$('#tableDetails').empty();
			$('#tableDetails').append('<tr><td>Id</td><td>' + value.id + '</td></tr>');
			$('#tableDetails').append('<tr><td>Vehicle</td><td>' + value.vehicle.name + '</td></tr>');
			
			$('#tableDetails').append('<tr><td>Departed At</td><td>' + value.location1.description + '</td></tr>');
			var departureDate = value.date1.substr(0,10);
			$('#tableDetails').append('<tr><td>Daparture Date</td><td>' + departureDate + '</td></tr>');
			
			$('#tableDetails').append('<tr><td>Arrived At</td><td>' + value.location2.description + '</td></tr>');
			var arrivedDate = value.date2.substr(0,10);
			$('#tableDetails').append('<tr><td>Arrived Date</td><td>' + arrivedDate + '</td></tr>');
			
			$('#tableDetails').append('<tr><td>Remarks</td><td>' + value.remarks + '</td></tr>');
			
		});

		$('#detailsModal').modal('show');
	});
});