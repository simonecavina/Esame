package it.university.Interfaces;

import java.util.List;

public interface IProfStud<T>{
    T findById(Integer id);
    List<T> findAll();
    void save(T utente);
}
