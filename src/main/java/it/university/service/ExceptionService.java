package it.university.service;

//QUESTA CLASSE ASTRATTA E' STATA CREATA PER POTER UNIFICARE IL CONTROLLO DELL'ID (e quindi il lancio dell'eccezione) DELLA CLASSE PROFESSORE, STUDENTE, E CORSO
public abstract class ExceptionService {
    protected void controlloId(int id){
        if (id<=0){
            throw new IllegalArgumentException("L'ID di ricerca/operazione non è valido: deve essere un numero positivo.");
        }
    }
} 