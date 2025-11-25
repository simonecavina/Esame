package it.university.Interfaces;

import it.university.model.Course;

public interface ICourseRepository extends IProfStud<Course>{
    //Questi metodi sono stati commentanti perchè vengono definiti nell'interfaccia comune IProfStud,
    //Qui si possono aggiungere metodi che sono solo legati al professore.
}
