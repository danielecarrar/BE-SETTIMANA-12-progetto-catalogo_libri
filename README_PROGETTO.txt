Per accedere all'interfaccia:

http://localhost:8080/swagger-ui.html

Bisogna prima effettuare il login (o signup); 

I metodi GETALL sono accessibili ANCHE a utenti "user"
tutti gli altri solo con utente "admin"

Una volta registrati o loggati (c'è già un admin nel database, username=admin, password=admin)
si può accedere ai vari metodi crud.

Se ci si registra con un ruolo non valido, viene segnalato e si ricevono in risposta i 2 ruoli disponibili

QUI DEGLI ESEMPI SULLA SINTASSI UTILIZZATE NELLA POST:

inserire un libro:

{
  "titolo": "esempio",
  "anno": 1933,
  "prezzo": 13.32
}

inserire una nuova categoria:

{
  "genere": "genere"
}

inserire un nuovo autore:

{
  "nome": "nome",
  "cognome": "cognome"
}

In allegato, la copia del database.
Presenti un paio di test base Junit.
