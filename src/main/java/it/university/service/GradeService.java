package it.university.service;

import it.university.Exceptions.RisorsaNonTrovata;
import it.university.model.Grade;
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

    public void controlloVoto(int grade){
        if (grade < 18 || grade > 30){
            throw new IllegalArgumentException("Il Valore inserito deve essere un valore da 18 a 30");
        }
    }

    public void insertGrade(int idStudente, int idCorso, int valoreVoto) {
        //AGGIUNTA A GESTIONE DELLE ECCEZZIONI PER L'INSERMENTO DI UN NUOVO VOO
        try {
            courseService.findById(idCorso);
        } catch (IllegalArgumentException e) {
            System.err.println("Errore di Input: "+ e.getMessage());
        } catch(RisorsaNonTrovata e){
            System.err.println("Errore Risorsa: " + e.getMessage());
        } catch (Exception e){
            System.err.println("Errore Generico: "+ e.getMessage());
        }   
        try {
            studentService.findById(idStudente);
        } catch (IllegalArgumentException e) {
            System.err.println("Errore di Input: "+ e.getMessage());
        } catch(RisorsaNonTrovata e){
            System.err.println("Errore Risorsa: " + e.getMessage());
        } catch (Exception e){
            System.err.println("Errore Generico: "+ e.getMessage());
        }   
        Grade grade = new Grade(idStudente, idCorso, valoreVoto);
        repo.save(grade);
        }
}
