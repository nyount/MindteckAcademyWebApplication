$(document).ready(function() {
	
	
	validateFirstName();
	validateLastName();
	validateAddress();
	validateDob();
	deleteConfirmation();

});

function validateFirstName() {
	$(".form").submit(
			function(event) {
				var f = $("#first_name").val();
				var regex = /^([a-zA-Z#+\-,.\/ ]{2,45})$/;
				$("#fnError").remove();
				if(!regex.test(f)) {
					
					$("#first_name").after('<td id="fnError" style="color:red">*Must be minimum 2 letters with no special characters.</td>');
					event.preventDefault();	
				} else {
					return true;
				}
			});		
}

function validateLastName() {
	$(".form").submit(
			function(event) {
				var f = $("#last_name").val();
				var regex = /^([a-zA-Z#+\-,.\/ ]{2,45})$/;
				$("#lnError").remove();
				var tr = $("#last_name").closest("tr");
				if(!regex.test(f)) {
					
					$("#last_name").after('<td id="lnError" style="color:red">*Must be minimum 2 letters with no invalid special characters.</td>');
					event.preventDefault();	
				} else {
					return true;
				}
			});		
}

function validateAddress() {
	
	$(".form").submit(
			function(event) {
				var f = $("#address1").val();
				var regex = /^([a-zA-Z0-9#+\-,.\/ ]{2,45})$/;
				$("#adError").remove();
				var tr = $("#address1").closest("tr");
				if(!regex.test(f)) {
					
					$("#address1").after('<td id="adError" style="color:red">*Must be minimum 2 characters with no invalid special characters.</td>');
					event.preventDefault();	
				} else {
					return true;
				}
			});		
}

function validateDob() {
	
	$(".form").submit(
			function(event) {
				var f = $("#dob").val();
				var regexone = /^[0-9]{4}\-(0[1-9]|1[012])\-(0[1-9]|[12][0-9]|3[01])/;
				var regextwo = /^(?:(0[1-9]|1[012])[\/.](0[1-9]|[12][0-9]|3[01])[\/.](19|20)[0-9]{2})$/;
				$("#doError").remove();
				if(!regexone.test(f) && !regextwo.test(f)) {
					
					$("#dob").after('<td id="doError" style="color:red">*Date must be mm/dd/yyyy.</td>');
					event.preventDefault();	
				} else {
					return true;
				}
			});		
}

function deleteConfirmation() {
	
	$('.deleteForm').submit(function() {
	    var c = confirm("Delete this Graduate?");
	    return c; //you can just return c because it will be true or false
	});



}
