package it.university.service;

import it.university.model.Student;
import it.university.Interfaces.IStudent;
import it.university.repository.StudentRepository;
import java.util.List;

//QUESTA CLASSE E' FIGLIA DELLA CLASSE ExceptionService PER UNIFICARE IL CONTROLLO DELL'ID

public class StudentService extends ExceptionService{
    private IStudent repository = new StudentRepository();

    public void registerStudent(Student s) { repository.save(s); }
    public List<Student> list() { 
        if (repository.findAll().isEmpty()){
            System.out.println("Nessuno studente");
        }
        return repository.findAll(); 
    }
    public Student findById(int idRicerca) {
        controlloId(idRicerca);
        return repository.findById(idRicerca);
    }
}
