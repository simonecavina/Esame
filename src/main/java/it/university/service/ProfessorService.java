package it.university.service;

import it.university.model.Professor;
import it.university.repository.ProfessorRepository;
import it.university.Interfaces.IProfessorRepository;
import java.util.List;

public class ProfessorService {
    private IProfessorRepository repository = new ProfessorRepository();

    public void add(Professor p) { repository.save(p); }
    public List<Professor> list() { 
        if (repository.findAll().isEmpty()){
            System.out.println("Nessun professore trovato");
        }
        return repository.findAll(); 
    }
    public IProfessorRepository getRepository(){
        return repository;
    }
    public Professor findById(int idRicerca) {
        if (idRicerca <= 0){
            throw new IllegalArgumentException("L'Id inserito non è valido, DEVE ESSERE UN NUMERO POSITIVO");
        }
        return repository.findById(idRicerca);
    }
}
