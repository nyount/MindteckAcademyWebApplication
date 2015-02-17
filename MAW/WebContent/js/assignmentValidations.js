$(document).ready(function() {
		
	validateType();
	validateScore();
	validateGraduateId();
	deleteConfirmation();

});


function validateType() {
	$(".form").submit(
			function(event) {
				var f = $("#type").val();
				var regex = /^([a-zA-Z0-9#+\-,.\/ ]{2,45})$/;
				$("#tyError").remove();
				if(!regex.test(f)) {
					
					$("#type").after('<td id="tyError" style="color:red">*Must be minimum 2 characters with no invalid special characters.</td>');
					event.preventDefault();	
				} else {
					return true;
				}
			});		
}

function validateScore() {
	$(".form").submit(
			function(event) {
				var f = $("#score").val();
				var regex = /^([0-9]{1,3})$/;
				$("#scError").remove();
				if(!regex.test(f) || f > 100 || f < 0) {
					
					$("#score").after('<td id="scError" style="color:red">*Must be a number(0-100)</td>');
					event.preventDefault();	
				} else {
					return true;
				}
			});		
}

function validateGraduateId() {
	$(".form").submit(
			function(event) {
				var f = $("#graduate_id").val();
				var regex = /^([0-9]{1,5})$/;
				$("#grError").remove();
				if(!regex.test(f) || f > 100 || f < 1) {
					
					$("#graduate_id").after('<td id="grError" style="color:red">*Must be a number.</td>');
					event.preventDefault();	
				} else {
					return true;
				}
			});		
}

function deleteConfirmation() {
	
	$('.deleteForm').submit(function() {
	    var c = confirm("Delete this Assignment?");
	    return c; //you can just return c because it will be true or false
	});



}

