$(document).ready(function() {

	validateFirstName();
	validateLastName();
	validateSkill();
	deleteConfirmation();

});

function validateFirstName() {
	$(".form")
			.submit(
					function(event) {
						var f = $("#firstName").val();
						var regex = /^([a-zA-Z#+\-,.\/ ]{2,45})$/;
						$("#fnError").remove();
						if (!regex.test(f)) {

							$("#firstName")
									.after(
											'<td id="fnError" style="color:red">*Must be minimum 2 letters with no invalid special characters.</td>');
							event.preventDefault();
						} else {
							return true;
						}
					});
}

function validateLastName() {
	$(".form")
			.submit(
					function(event) {
						var f = $("#lastName").val();
						var regex = /^([a-zA-Z#+\-,.\/ ]{2,45})$/;
						$("#lnError").remove();
						var tr = $("#lastName").closest("tr");
						if (!regex.test(f)) {

							$("#lastName")
									.after(
											'<td id="lnError" style="color:red">*Must be minimum 2 letters with no invalid special characters.</td>');
							event.preventDefault();
						} else {
							return true;
						}
					});
}

function validateSkill() {

	$(".form")
			.submit(
					function(event) {
						var f = $("#skill").val();
						var regex = /^([a-zA-Z0-9#+\-,.\/ ]{2,45})$/;
						$("#skError").remove();
						if (!regex.test(f) && f.length > 0) {

							$("#skill")
									.after(
											'<td id="skError" style="color:red">*Must be minimum 2 characters with no invalid special characters, or blank.</td>');
							event.preventDefault();
						} else {
							return true;
						}
					});
}

function deleteConfirmation() {
	
	$('.deleteForm').submit(function() {
	    var c = confirm("Delete this Instructor?");
	    return c; //you can just return c because it will be true or false
	});



}
