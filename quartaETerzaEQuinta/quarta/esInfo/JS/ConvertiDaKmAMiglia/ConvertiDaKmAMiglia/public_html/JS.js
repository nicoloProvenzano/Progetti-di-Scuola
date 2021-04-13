"use strict"

var nKm;
var nMiglia;
var btnSubmit;
var ris;

window.onload=function(){
	
	nKm=document.getElementById("nKm");
	nMiglia=document.getElementById("nMiglia");
	ris=document.getElementById("ris");
	
	btnSubmit=document.getElementById("btnSubmit");
	btnSubmit.onclick=prendiDati;
}

function prendiDati(){
	
	var km=nKm.value;
	var miglia=nMiglia.value;
	ris.innerHTML=km*0.6;
	
}

