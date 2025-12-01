package it.university.repository;

import it.university.Exceptions.RisorsaNonTrovata;
import it.university.Interfaces.IProfessor;
import it.university.model.Professor;
import java.util.*;

public class ProfessorRepository implements IProfessor {
    private Map<Integer, Professor> data = new HashMap<>();

    @Override
    public void save(Professor p) {
         data.put(p.getId(), p); 
    }
    @Override
    public Professor findById(Integer id) {
        Professor professore = data.get(id);
        if (professore == null){
            throw new RisorsaNonTrovata("Non è stato trovato nessun professore con il seguente ID: " + id);
        }
        return professore;
    }
    @Override
    public List<Professor> findAll() {
        return new ArrayList<>(data.values());
    }
}
