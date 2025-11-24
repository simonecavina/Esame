package it.university.repository;

import it.university.Interfaces.IStudentRepository;
import it.university.model.Student;
import java.util.*;

public class StudentRepository implements IStudentRepository {
    private Map<Integer, Student> students = new HashMap<>();

    @Override
    public void save(Student s) { students.put(s.getId(), s); }
    @Override
    public Student findById(Integer id) { return students.get(id); }
    @Override
    public List<Student> findAll() { return new ArrayList<>(students.values()); }
}
