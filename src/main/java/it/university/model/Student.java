package it.university.model;

public class Student extends UtenteUniversitario {
    private int id;
    private String email;

    public Student(int id, String name, String email) {
        super(name);
        this.id = id;
        this.email = email;
    }

    @Override
    public int getId() {
        return id;
    }
    public String getEmail() { return email; }

    @Override
    public String toString() {
        return "" + id + " - " + getName() + " - " + email + "";
    }
}
