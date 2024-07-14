
$('document').ready(function() {

	$('table #editButton').on('click', function(event) {
		event.preventDefault();

		// /contacts/findById?id=1
		var href = $(this).attr('href');
		$.get(href, function(value, status) {
			$('#idEdit').val(value.id);
			$('#firstNameEdit').val(value.firstname);
			$('#lastNameEdit').val(value.lastname);
			$('#emailEdit').val(value.email);
			$('#mobileEdit').val(value.mobile);
			$('#phoneEdit').val(value.phone);
			$('#remarksEdit').val(value.remarks);
		});

		$('#editModal').modal('show');
	});

	$('table #deleteButton').on('click', function(event) {
		event.preventDefault();

		// /contacts/delete?id=1
		var href = $(this).attr('href');
		$('#confirmDeleteButton').attr('href', href);

		$('#deleteModal').modal('show');
	});

	$('table #detailsButton').on('click', function(event) {
		event.preventDefault();

		// /contacts/findById?id=1
		var href = $(this).attr('href');
		$.get(href, function(value, status) {
			$('#tableDetails').empty();
			$('#tableDetails').append('<tr><td>Id</td><td>'+value.id+'</td></tr>');
			$('#tableDetails').append('<tr><td>First Name</td><td>'+value.firstname+'</td></tr>');
			$('#tableDetails').append('<tr><td>Last Name</td><td>'+value.lastname+'</td></tr>');
			$('#tableDetails').append('<tr><td>Email</td><td>'+value.email+'</td></tr>');
			$('#tableDetails').append('<tr><td>Mobile</td><td>'+value.mobile+'</td></tr>');
			$('#tableDetails').append('<tr><td>Phone</td><td>'+value.phone+'</td></tr>');
			$('#tableDetails').append('<tr><td>Remarks</td><td>'+value.remarks+'</td></tr>');
		});

		$('#detailsModal').modal('show');
	});
});