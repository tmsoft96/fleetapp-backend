
$('document').ready(function () {

	$('table #editButton').on('click', function (event) {
		event.preventDefault();

		// /employees/findById?id=1
		var href = $(this).attr('href');
		$.get(href, function (value, status) {
			$('#idEdit').val(value.id);
			$('#titleEdit').val(value.title);
			$('#initialsEdit').val(value.initials);
			$('#socialSecurityNumberEdit').val(value.socialSecurityNumber);
			$('#firstNameEdit').val(value.firstname);
			$('#lastNameEdit').val(value.lastname);
			$('#otherNameEdit').val(value.othername);
			$('#genderEdit').val(value.gender);
			$('#nationalityEdit').val(value.countryid);
			$('#addressEdit').val(value.address);

			var dateOfBirth = value.dateOfBirth.substr(0, 10);
			$('#dateOfBirthEdit').val(dateOfBirth);

			var hireDate = value.hireDate.substr(0, 10);
			$('#hireDateEdit').val(hireDate);

			$('#stateEdit').val(value.stateid);
			$('#cityEdit').val(value.city);
			$('#phoneEdit').val(value.phone);
			$('#mobileEdit').val(value.mobile);
			$('#maritalStatusEdit').val(value.maritalStatus);
			$('#emailEdit').val(value.email);
			$('#jobTitleEdit').val(value.jobtitleid);
			$('#employeeTypeEdit').val(value.employeetypeid);
		});

		$('#editModal').modal('show');
	});

	$('table #deleteButton').on('click', function (event) {
		event.preventDefault();

		// /employees/delete?id=1
		var href = $(this).attr('href');
		$('#confirmDeleteButton').attr('href', href);

		$('#deleteModal').modal('show');
	});

	$('table #detailsButton').on('click', function (event) {
		event.preventDefault();

		// /employees/findById?id=1
		var href = $(this).attr('href');
		$.get(href, function (value, status) {
			$('#idDetail').val(value.id);
			$('#titleDetail').val(value.title);
			$('#initialsDetail').val(value.initials);
			$('#socialSecurityNumberDetail').val(value.socialSecurityNumber);
			$('#firstNameDetail').val(value.firstname);
			$('#lastNameDetail').val(value.lastname);
			$('#otherNameDetail').val(value.othername);
			$('#genderDetail').val(value.gender);
			$('#nationalityDetail').val(value.country.description);
			$('#addressDetail').val(value.address);

			var dateOfBirth = value.dateOfBirth.substr(0, 10);
			$('#dateOfBirthDetail').val(dateOfBirth);

			var hireDate = value.hireDate.substr(0, 10);
			$('#hireDateDetail').val(hireDate);

			$('#stateDetail').val(value.state.name);
			$('#cityDetail').val(value.city);
			$('#phoneDetail').val(value.phone);
			$('#mobileDetail').val(value.mobile);
			$('#maritalStatusDetail').val(value.maritalStatus);
			$('#emailDetail').val(value.email);
			$('#jobTitleDetail').val(value.jobTitle.description);
			$('#employeeTypeDetail').val(value.employeeType.description);
		});

		$('#detailsModal').modal('show');
	});

	$('table #photoButton').on('click', function (event) {
		event.preventDefault();

		// /img/photos/user.png
		var href = $(this).attr('href');
		$('#employeePhoto').attr('src', href);

		$('#photoModal').modal('show');
	});
});