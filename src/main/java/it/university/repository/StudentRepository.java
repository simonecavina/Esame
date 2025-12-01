package it.university.repository;

import it.university.Interfaces.IStudent;
import it.university.model.Student;
import it.university.Exceptions.RisorsaNonTrovata;
import java.util.*;

public class StudentRepository implements IStudent {
    private Map<Integer, Student> students = new HashMap<>();

    @Override
    public void save(Student s) {
        students.put(s.getId(), s);
    }
    @Override
    public Student findById(Integer id) {
        Student student = students.get(id);
        if(student == null){
            throw new RisorsaNonTrovata("Non è stato trovato nessuno studente con il seguente ID: " + id);
        }
        return student;
    }
    @Override
    public List<Student> findAll() { return new ArrayList<>(students.values()); }
}
