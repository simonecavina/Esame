package it.university.Exceptions;

//QUESTA CLASSE VIENE CHIAMATA QUANDO DURANTE LA GESTIONE DELLE ECCEZIONI IL PROGRAMMA NON TROVI L'ID CORRISPONDENTE
public class RisorsaNonTrovata extends RuntimeException{
    public RisorsaNonTrovata(String messaggioErrore){
        super(messaggioErrore);
    }
}

