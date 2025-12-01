package it.university.Interfaces;



import it.university.model.Professor;

public interface IProfessor extends IGeneric <Professor, Integer>{
    //QUESTA E' L'INTERFACCIA PER LA CLASSE PROFESSORE, I METODI DEL PROFESSORE (quelli commentati) SONO COMUNI A TUTTI GLI ALTRI
    // E QUINDI SONO STATI INSERITI ALL'INTERNO DELL'INTEFACCIA GENERICA.

    //QUESTA INTERFACCIA RISULTEREBBE UTILE NEL CASO ESISTSSERO DEI METODI CHE SOLO SOLAMENTE DEL PROFESSORE E QUINDI NON COMUNI

    //void save(Professor p);
    //Professor findById(int id);
    //List<Professor> findAll();
}
