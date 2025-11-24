package it.university.Interfaces;

import it.university.model.Student;

//Questa è l'implementazione dell'interfccia IStudentRepository, che permette di
// dividere la logia del Service da quella di persistenza cioè repository
// Service contiene la logica di business come ad esempio la registrazione...
// L'interfaccia definisce i metodi che il service userà


public interface IStudentRepository extends IProfStud<Student>{

     //Questi metodi sono stati commentanti perchè vengono definiti nell'interfaccia comune IProfStud,
    //Qui si possono aggiungere metodi che sono solo legati allo studente.

    //Student findById(int id);
    //List<Student> findAll();
    //void save(Student student);
}