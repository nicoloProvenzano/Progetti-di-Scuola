"use strict"

var username;
var password;
var btnSubmit;
var ris;

window.onload=function(){
	
	username=document.getElementById("username");
	password=document.getElementById("password");
	ris=document.getElementById("ris");
	
	btnSubmit=document.getElementById("btnSubmit");
	btnSubmit.onclick=prendiDati;
}

function prendiDati(){
	
	var mioNome=username.value;
	var miaPassword=password.value;
	ris.innerHTML="il nome utente e':"+mioNome+" e la password e':"+miaPassword;
	
}

