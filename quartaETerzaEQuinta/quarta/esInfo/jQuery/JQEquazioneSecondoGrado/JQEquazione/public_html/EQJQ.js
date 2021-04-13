"use strict"

$(document).ready(function(){
	
	$("#btnSubmit").click(function(){

		var ris=( parseInt($("#primoNumero").val(), 10)** parseInt($("#secondoNumero").val(), 10));
		$("#ris").text(ris);
	});
	
});
