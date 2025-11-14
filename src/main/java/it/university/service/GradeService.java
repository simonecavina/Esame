package it.university.service;

import it.university.model.Course;
import it.university.model.Grade;
import it.university.model.Student;
import it.university.repository.GradeRepository;
import java.util.List;

public class GradeService {
    private GradeRepository repo = new GradeRepository();
    private StudentService studentService;
    private CourseService courseService;

    public GradeService(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    public void add(Grade g) { repo.save(g); }
    public List<Grade> list() {
        if (repo.findAll().isEmpty()){
            System.out.println("Nessun voto registrato");
        } 
        return repo.findAll(); 
    }

    public void insertGrade(int idStudente, int idCorso, int valoreVoto) {
        Course corso = courseService.findById(idCorso);
        if (corso == null) {
            System.out.println("Errore: Corso non trovato.");
            return;
        }
        Student studente = studentService.findById(idStudente);
        if (studente == null) {
            System.out.println("Errore: Studente non trovato.");
            return;
        }
        Grade grade = new Grade(idStudente, idCorso, valoreVoto);
        repo.save(grade);
    }
}
