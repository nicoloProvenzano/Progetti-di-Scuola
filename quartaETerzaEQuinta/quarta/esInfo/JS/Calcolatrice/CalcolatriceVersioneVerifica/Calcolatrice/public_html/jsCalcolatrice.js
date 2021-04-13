"use strict";

var tab;
var ris;
var risultato="";
var uguale;

window.onload=function(){
    
    tab=document.getElementById("tab");
    ris=document.getElementById("ris");
    uguale=document.getElementById("uguale");
    
    tab.onclick=mostraInformazioni;
};

function mostraInformazioni(e){
    
    var cella;
    var contCella;
    
    e=(window.event)?window.event:e;    
    cella=(e.srcElement)?e.srcElement:e.target; 
    (e.stopPropagation)?e.stopPropagation():e.cancelBubble=true;
    if(cella.tagName!=="TD"){   
        return;
    }
    
    contCella=cella.innerHTML;
	
    if(contCella == uguale.innerHTML){
        
		risultato=eval(risultato);
        ris.innerHTML=eval(risultato);
    } else {
    
    risultato=risultato + contCella;
	ris.innerHTML=risultato;
	}
}
