package it.university.service;

import it.university.model.Course;
//import it.university.repository.ProfessorRepository;
import it.university.Interfaces.ICourse;
import it.university.repository.CourseRepository;
import it.university.Interfaces.IProfessor;
import java.util.List;

public class CourseService extends ExceptionService{
    private ICourse repo = new CourseRepository();

    public void createCourse(Course c) { repo.save(c); }
    //PRIMA DI ASSEGNARE UN CORSO AD UN PROFESSORE CONTROLLO CHE ESISTANO GLI ID DELL'UNO E DELL'ALTRO
    public void assignProfessor(int courseId, int professorId, IProfessor professorRepo) {
        controlloId(professorId);
        controlloId(courseId);
        
        //IN CASO NON ESISTESSERO IL PROGRAMMA NON CONTINUEREBBE MA VERREBBERO LANCIATE DELLE ECCEZIONI
        professorRepo.findById(professorId);
        Course course = repo.findById(courseId);

        //IN CASO INVECE IL PROGRAMMA NON AVESSE LANCIATO DELLE ECCEZIONI PROSEGUE ASSEGNANDO IL CORSO AL PROFESSORE INDICATO
        course.setProfessorId(professorId);
        repo.save(course);
    }
    public Course findById(int id) { return repo.findById(id); }
    public List<Course> list() { 
        if (repo.findAll().isEmpty()){
            System.out.println("Nessun corso trovato");
        }
        return repo.findAll(); 
    }
}
