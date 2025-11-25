package it.university.service;

import it.university.model.Student;
import it.university.Interfaces.IStudentRepository;
import it.university.repository.StudentRepository;
import java.util.List;

public class StudentService {
    private IStudentRepository repository = new StudentRepository();

    public void registerStudent(Student s) { repository.save(s); }
    public List<Student> list() { 
        if (repository.findAll().isEmpty()){
            System.out.println("Nessuno studente");
        }
        return repository.findAll(); 
    }
    public Student findById(int idRicerca) {
        if (idRicerca<=0){
            throw new IllegalArgumentException("L'Id inserito non è valido, DEVE ESSERE UN NUMERO POSITIVO");
        }
        return repository.findById(idRicerca);
    }
}
