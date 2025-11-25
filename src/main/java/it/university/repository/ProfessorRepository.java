package it.university.repository;

import it.university.Interfaces.IProfessorRepository;
import it.university.model.Professor;
import java.util.*;

public class ProfessorRepository implements IProfessorRepository {
    private Map<Integer, Professor> data = new HashMap<>();

    @Override
    public void save(Professor p) {
         data.put(p.getId(), p); 
    }
    @Override
    public Professor findById(Integer id) {
        return data.get(id);
    }
    @Override
    public List<Professor> findAll() {
        return new ArrayList<>(data.values());
    }
}
