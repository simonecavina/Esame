package it.university.service;

import it.university.model.Professor;
import it.university.repository.ProfessorRepository;
import it.university.Interfaces.IProfessor;
import java.util.List;

public class ProfessorService extends ExceptionService{
    private IProfessor repository = new ProfessorRepository();

    public void add(Professor p) { repository.save(p); }
    public List<Professor> list() { 
        if (repository.findAll().isEmpty()){
            System.out.println("Nessun professore trovato");
        }
        return repository.findAll(); 
    }
    public IProfessor getRepository(){
        return repository;
    }
    public Professor findById(int idRicerca) {
        controlloId(idRicerca);
        return repository.findById(idRicerca);
    }
}
