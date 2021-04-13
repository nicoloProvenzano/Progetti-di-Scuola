"use strict"

$(document).ready(function(){
	
	$("#btnSubmit").click(function(){
		
		$("#ris").text("");
		$("#ris").append("il nome utente é: "+$("#username").val()+" "+"la password é: "+$("#password").val());
	});
	
});


