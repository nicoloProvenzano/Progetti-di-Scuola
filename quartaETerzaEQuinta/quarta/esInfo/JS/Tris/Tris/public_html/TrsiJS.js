"use strict";

var tab;
var ris;
var risultato;
var uguale;
var turno;

window.onload=function(){
    
    tab=document.getElementById("tab");
    ris=document.getElementById("ris");
    uguale=document.getElementById("uguale");
    
    tab.onclick=mostraInformazioni;
};

function mostraInformazioni(e){
    
    var cella;
   // var contCella;
    
    e=(window.event)?window.event:e;
    
    cella=(e.srcElement)?e.srcElement:e.target;
    
    (e.stopPropagation)?e.stopPropagation():e.cancelBubble=true;

    if(cella.tagName!=="TD"){
        
        return;
    }
	
	if (cella.innerHTML!=="X" || cella.innerHTML!=="O") {
		
		if (turno===0) {
			cella.innerHTML="X";
			turno=1;
		} else {

			cella.innerHTML="O";
			turno=0;
		}
		//contCella=cella.innerHTML.toString();
		ris.innerHTML=turno;
	}
}
