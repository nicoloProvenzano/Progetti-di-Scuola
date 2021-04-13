/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
"use strict";

var apriLink1=true;
var apriLink2=true;
var apriLink3=true;
var apriLink4=true;


$(document).ready(function(){
	
$("#bottone1").click(function(){//prova rispota server
	  
	if (apriLink1){
		
	  $("#div1").load("http://localhost:8088/");
	  apriLink1=false;
  }

	else{
		
		$("#div1").text("scrivere qui i risultati");
		apriLink1=true;
	}
  });
  
$("#bottone2").click(function(){//dati costruttori grezzi
	  
	if (apriLink2){
		
	  $("#div2").load("http://localhost:8088/costruttori");
	  apriLink2=false;
  }

	else{
		
		$("#div2").text("scrivere qui i risultati");
		apriLink2=true;
	}
  });  
  
  $("#bottone3").click(function(){//dati costruttori non ordinati
	  
	if (apriLink3){
            
            $.get("http://localhost:8088/costruttori", costruttoriOrdinati);
            apriLink3=false;
  }

	else{
		
		$("#div3").text("scrivere qui i risultati");
		apriLink3=true;
	}
  });
  
  $("#bottone4").click(function(){//tabella piloti
	  
	if (apriLink4){
		
	  $("#div4").load("http://localhost:8088/piloti",tabellaPiloti);
	  apriLink4=false;
  }

	else{
		
		$("#div4").text("scrivere qui i risultati");
		apriLink4=true;
	}
  });
  
  $("#bottone5").click(ricercaPiloti);
  
  $.get("http://localhost:8088/costruttori",RicercaCostruttori);
		
  $("#costruttore").change(function(){//6

    var value=$(this).find(':selected').attr('value');
    $.get("http://localhost:8088/campionati/2018/pilotiDeiTeams/"+value, selezionaPiloti);
          
  });
  
  //funzioni per le operazione più lunghe
  
  function  costruttoriOrdinati(data){//costruttori el
      
      var lista =$('<ul>');//crea lista
      $.each(data, function(key,val){//per ogni dato (in questo caso per ogni costruttore)
          lista.append($('<li>').text(val.nomeCostruttore +" "+ val.nazioneCostruttore));//appendo alla lista il nome e la nazionalità
          
      });
      $("#bottone3").html(lista);
  }
  
  
  function tabellaPiloti(data){
      
      var table=$('<table>');//crea tabella
      $.each(data, function(key,val){//per ogni pilora
          
          var tr =$('<tr>');//crea la riga e aggiungi le colonne ad ogni riga
          tr.append($('<td>').text(val.idPilota));
          tr.append($('<td>').text(val.nomePilota));
          tr.append($('<td>').text(val.cognomePilota));
          tr.append($('<td>').text(val.nazionalita));
          table.append(tr);//aggiunge riga alla tabella
      });
      $("#div4").html(table);//metto la tabella sul div
  }
          
          
  function RicercaCostruttori(data){//costruttori sel
      //forse evo mettere costruttore
      var costruttore=$("#pilota");//valore della textbox
      $.each(data, function (ix,val)
      {
          
          costruttore.append(new Option(val.nomeCostruttore, val.idCostruttore));
      });
  }
          
      
  
    function tabellaRicercaPiloti(data){//tabpiloti
      
      var table=$('<table>');//crea tabella
      $.each(data, function(key,val){//per ogni pilora
          
          var tr =$('<tr>');//crea la riga e aggiungi le colonne ad ogni riga
          tr.append($('<td>').text(val.idPilota));
          tr.append($('<td>').text(val.nomePilota));
          tr.append($('<td>').text(val.cognomePilota));
          tr.append($('<td>').text(val.nazionalita));
          table.append(tr);//aggiunge riga alla tabella
      });
      $("#div5").html(table);//metto la tabella sul div
  }    

    function selezionaPiloti(data){//piloti sel
        
        var tabella=$("<table>");
        $.each(data,function (key,val){
            var tr=$("<tr>");
            tr.append($('<td>').text(val.idPilota));
            tr.append($('<td>').text(val.nomePilota));
            tr.append($('<td>').text(val.cognomePilota));
            tr.append($('<td>').text(val.nazionalita));
            tabella.append(tr);
        });
        $("#div6").html(tabella);
    }
  
    function ricercaPiloti(){
        
        var pilota=$("textArea").val();
        $.get("http://localhost:8088/campionati/2018/pilotiDeiTeams/"+pilota,tabellaRicercaPiloti);
    }

});