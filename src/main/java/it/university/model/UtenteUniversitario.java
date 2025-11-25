package it.university.model;

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
