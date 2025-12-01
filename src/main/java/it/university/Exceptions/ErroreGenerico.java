package it.university.Exceptions;

//QUESTA CLASSE VIENE CHIAMATA QUANDO DURANTE LA GESTIONE DELLE ECCEZIONI SI GENERA UN ERRORE 
public class ErroreGenerico extends RuntimeException{
    public ErroreGenerico(String messaggioErrore){
        super(messaggioErrore);
    }
    
}