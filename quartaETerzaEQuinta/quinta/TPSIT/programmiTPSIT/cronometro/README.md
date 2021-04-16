# cronometro

Progetto:Cronometro

Descrizione:
Il progetto e' un cronometro che utilizza uno stream per aggiornare un widget che mostra il tempo passato creando e distruggendo il widget ogni volta che riceveva un evento, ovvero ogni secondo. Le ore e i minuti vengono aumentati rispettivamente quando i minuti o i secondi arrivano a 60.

## Getting Started

Layout:
Il layout e' una colonna divisa in tre widget.
Ogni widget e' distanziato l'uno dall'altro da una sized box.
Il primo widget e' il cronometro.
Il secondo e' una riga che contiene tre pulsanti.
Da sinistra a destra i pulsanti sono: parziali, avvia/ferma, resetta.
Il terzo e' la lista dei parziali che si espande verso il basso in caso non ci sia piu' spazio creando un scroll bar.

Funzionamento:
Quando clicco un pulsante richiamo la funzione onClick() del pulsante, ognuna collegata ad una funzione specifica che cambia lo stato del cronometro.

Idee mie:

Ho usato le sized box per distanziare i vari widget e disporli come volevo perche' facili da usare e statici, cioe' che non cambiano e non vengono "surclassati" da altri widget piu' invasivi.

Ho usato un Expanded widget per contenere la lista dei tempi. Serve a fare in modo che lo spazio occupato dalla lista si ESPANDA e OCCUPI lo spazio rimanenente(verso il basso in questo caso).
Non richiede l'aggiunta di una scrollbar perchè la fornisce in automatico.
link che spiega https://stackoverflow.com/questions/53577835/center-expanded-listview-inside-column-flutter e https://api.flutter.dev/flutter/widgets/Expanded-class.html

Ho usato un List view widget per la lista dei tempi.
Ho usato questo widget perchè permette di creare una lista dinamica che non viene distrutta e ricreata ma aggionata ogni volta che riceve un nuovo evento.
Il metodo builder crea la lista.
itemCount è il numero di oggetti della lista-
shrinkWrap dice alla lista di OCCUPARE SOLAMENTE LO SPAZIO RICHIESTO 
E NON LO SPAZIO DEL WIDGET PADRE
link utile https://stackoverflow.com/questions/54007073/what-does-the-shrink-wrap-property-do-in-flutter

link su come creare una list view https://www.youtube.com/watch?v=eIILhIYJ30Q





