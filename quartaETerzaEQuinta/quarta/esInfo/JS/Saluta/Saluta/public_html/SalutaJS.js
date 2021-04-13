"use strict";

var saluto;
var bottoneDaCliccare;

window.onload=function(){
	
	saluto=document.getElementById("saluto");
	bottoneDaCliccare=document.getElementById("bottoneDaCliccare");
	bottone();
};

function saluta(){
	
	saluto.innerHTML="ciao a tutti da saluto";
	//alert("ciao a tutti da allert");
}

function bottone(){
	
	bottoneDaCliccare.onclick=saluta;
}