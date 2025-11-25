package it.university.model;

public class Professor extends UtenteUniversitario{
    private int id;
    private String department;

    public Professor(int id, String name, String department) {
        super(name);
        this.id = id;
        this.department = department;
    }

    public int getId() {
        return id;
    }
    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Professor{" + id + ", " + getName() + ", dept=" + department + "}";
    }
}
