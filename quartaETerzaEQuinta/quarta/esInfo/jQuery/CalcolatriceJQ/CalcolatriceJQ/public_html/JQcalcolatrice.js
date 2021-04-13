"use strict";

var tab;
var ris;
var risultato="";
var uguale;

$(document).ready(function(){
	
	$("#tab").click(function(){

		mostraInformazioni();
	});
	
});

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
	
    if(contCella == $("#uguale").text()){
        
        $("#ris").text(eval(risultato));
		risultato=eval(risultato);

    } else {
		
    risultato=risultato + contCella;
	$("#ris").text(risultato);
	}
}


