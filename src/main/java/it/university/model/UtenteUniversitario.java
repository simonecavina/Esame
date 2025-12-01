package it.university.model;

//ABBIAMO UTILIZZATO QUESTA CLASSE ASTRATTA PER POTER DEFINIE UN ATTRIBUTO COMUNE A DUE CLASSI DIVERSE QUALI STUDENTE E PROFESSORE

public abstract class UtenteUniversitario {
    private String name;

    public UtenteUniversitario(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public abstract int getId();

    @Override
    public abstract String toString();
}
