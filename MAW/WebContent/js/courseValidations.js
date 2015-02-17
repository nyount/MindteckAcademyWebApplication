$(document).ready(function() {
		
	validateStartDate();
	validateEndDate();
	validateLocation();
	validateType();
	validateDescription();
	deleteConfirmation();
	

});

function validateStartDate() {
	
	$(".form").submit(
			function(event) {
				var f = $("#start_date").val();
				var regexone = /^[0-9]{4}\-(0[1-9]|1[012])\-(0[1-9]|[12][0-9]|3[01])/;
				var regextwo = /^(?:(0[1-9]|1[012])[\/.](0[1-9]|[12][0-9]|3[01])[\/.](19|20)[0-9]{2})$/;
				$("#sdError").remove();
				if(!regexone.test(f) && !regextwo.test(f)) {
					
					$("#start_date").after('<td id="sdError" style="color:red">*Date must be mm/dd/yyyy.</td>');
					event.preventDefault();	
				} else {
					return true;
				}
			});		
}

function validateEndDate() {
	
	$(".form").submit(
			function(event) {
				var f = $("#end_date").val();
				var regexone = /^[0-9]{4}\-(0[1-9]|1[012])\-(0[1-9]|[12][0-9]|3[01])/;
				var regextwo = /^(?:(0[1-9]|1[012])[\/.](0[1-9]|[12][0-9]|3[01])[\/.](19|20)[0-9]{2})$/;
				$("#edError").remove();
				if(!regexone.test(f) && !regextwo.test(f)) {
					
					$("#end_date").after('<td id="edError" style="color:red">*Date must be mm/dd/yyyy.</td>');
					event.preventDefault();	
				} else {
					return true;
				}
			});		
}

function validateLocation() {
	$(".form").submit(
			function(event) {
				var f = $("#location").val();
				var regex = /^([a-zA-Z0-9#+\-,.\/ ]{2,45})$/;
				$("#loError").remove();
				if(!regex.test(f)) {
					
					$("#location").after('<td id="loError" style="color:red">*Must be minimum 2 characters with no invalid special characters.</td>');
					event.preventDefault();	
				} else {
					return true;
				}
			});		
}

function validateType() {
	$(".form").submit(
			function(event) {
				var f = $("#type").val();
				var regex = /^([a-zA-Z0-9#+\-,.\/@!  ]{1,45})$/;
				$("#tyError").remove();
				if(!regex.test(f)) {
					
					$("#type").after('<td id="tyError" style="color:red">*Must be minimum 1 character with no invalid special characters.</td>');
					event.preventDefault();	
				} else {
					return true;
				}
			});		
}

function validateDescription() {
	$(".form").submit(
			function(event) {
				var f = $("#description").val();
				var regex = /^([a-zA-Z0-9#+\-,.\/ ]{2,1000})$/;
				$("#deError").remove();
				if(!regex.test(f)) {
					
					$("#description").after('<td id="deError" style="color:red">*Must be minimum 2 characters with no invalid special characters.</td>');
					event.preventDefault();	
				} else {
					return true;
				}
			});		
}

function deleteConfirmation() {
	
	$('.deleteForm').submit(function() {
	    var c = confirm("Delete this Course?");
	    return c; //you can just return c because it will be true or false
	});



}