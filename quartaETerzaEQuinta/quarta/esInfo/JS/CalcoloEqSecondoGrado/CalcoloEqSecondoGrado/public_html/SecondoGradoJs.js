"use strict"

var primoNumero;
var secondoNmuero;
var terzoNumero;
var btnSubmit;
var ris;

window.onload=function(){
	
	primoNumero=document.getElementById("primoNumero");
	secondoNmuero=document.getElementById("secondoNmuero");
	ris=document.getElementById("ris");
	
	btnSubmit=document.getElementById("btnSubmit");
	btnSubmit.onclick=prendiDati;
}

function prendiDati(){
	
	var primoVal=primoNumero.value;
	var secondoVal=secondoNmuero.value;
	ris.innerHTML=primoVal+secondoVal;
	
}
