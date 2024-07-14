
$('document').ready(function() {

	$('table #editButton').on('click', function(event) {
		event.preventDefault();

		// /clients/findById?id=1
		var href = $(this).attr('href');
		$.get(href, function(value, status) {
			$('#idEdit').val(value.id);
			$('#vehicleTypeEdit').val(value.vehicletypeid);
			$('#nameEdit').val(value.name);
			$('#vehicleNumberEdit').val(value.vehicleNumber);
			
			var registrationDate = value.registrationDate.substr(0, 10);
			$('#registrationDateEdit').val(registrationDate);
			
			$('#descriptionEdit').val(value.description);
			
			var acquisitionDate = value.acquisitionDate.substr(0, 10);
			$('#acquisitionDateEdit').val(acquisitionDate)

			$('#vehicleMakeEdit').val(value.vehiclemakeid);
			$('#vehicleModelEdit').val(value.vehiclemodelid);
			$('#currentLocationEdit').val(value.locationid);
			$('#powerEdit').val(value.power);
			$('#fuelCapacityEdit').val(value.fuelCapacity);
			$('#netWeightEdit').val(value.netWeight);
			$('#remarksEdit').val(value.remarks);
			$('#inChargeEdit').val(value.employeeid);
			$('#currentStatusEdit').val(value.vehiclestatusid);
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
			$('#idDetail').val(value.id);
			$('#vehicleTypeDetail').val(value.vehicleType.description);
			$('#nameDetail').val(value.name);
			$('#vehicleNumberDetail').val(value.vehicleNumber);
			
			var registrationDate = value.registrationDate.substr(0, 10);
			$('#registrationDateDetail').val(registrationDate);
			
			$('#descriptionDetail').val(value.description);
			
			var acquisitionDate = value.acquisitionDate.substr(0, 10);
			$('#acquisitionDateDetail').val(acquisitionDate);
			
			$('#vehicleMakeDetail').val(value.vehicleMake.description);
			$('#vehicleModelDetail').val(value.vehicleModel.description);
			$('#currentLocationDetail').val(value.currentLocation.description);
			$('#powerDetail').val(value.power);
			$('#fuelCapacityDetail').val(value.fuelCapacity);
			$('#netWeightDetail').val(value.netWeight);
			$('#remarksDetail').val(value.remarks);
			
			var fullname = value.inCharge.person.firstname + ' ' + value.inCharge.person.lastname;
			$('#inChargeDetail').val(fullname);
			
			$('#currentStatusDetail').val(value.vehicleStatus.description);
		});

		$('#detailsModal').modal('show');
	});
});