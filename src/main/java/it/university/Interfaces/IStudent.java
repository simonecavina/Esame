package it.university.Interfaces;

import it.university.model.Student;

//Questa è l'implementazione dell'interfccia IStudentRepository, che permette di
// dividere la logia del Service da quella di persistenza cioè repository
// Service contiene la logica di business come ad esempio la registrazione
// L'interfaccia definisce i metodi che il service userà


public interface IStudent extends IGeneric<Student, Integer>{
    //QUESTA E' L'INTERFACCIA PER LA CLASSE STUDENTE, I METODI DELLO STUDENTE (quelli commentati) SONO COMUNI A TUTTI GLI ALTRI
    // E QUINDI SONO STATI INSERITI ALL'INTERNO DELL'INTEFACCIA GENERICA.

    //QUESTA INTERFACCIA RISULTEREBBE UTILE NEL CASO ESISTSSERO DEI METODI CHE SOLO SOLAMENTE DELLO STUDENTE E QUINDI NON COMUNI

    //Student findById(int id);
    //List<Student> findAll();
    //void save(Student student);
}