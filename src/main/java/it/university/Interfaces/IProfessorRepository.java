package it.university.Interfaces;



import it.university.model.Professor;

public interface IProfessorRepository extends IProfStud <Professor>{
    
    //Questi metodi sono stati commentanti perchè vengono definiti nell'interfaccia comune IProfStud,
    //Qui si possono aggiungere metodi che sono solo legati al professore.
    
    //void save(Professor p);
    //Professor findById(int id);
    //List<Professor> findAll();
}
