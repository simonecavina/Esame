package it.university;

import it.university.model.*;
import it.university.service.*;
import it.university.gestione_menu.*;


public class MainApp {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        ProfessorService professorService = new ProfessorService();
        CourseService courseService = new CourseService();
        ClassroomService classroomService = new ClassroomService();
        GradeService gradeService = new GradeService(studentService, courseService);
        
        // Inizializzazione dati di default
        studentService.registerStudent(new Student(1, "Alice", "alice@mail.com"));
        studentService.registerStudent(new Student(2, "Bob", "bob@mail.com"));
        
        professorService.add(new Professor(1, "Dr. Rossi", "Informatica"));
        
        courseService.createCourse(new Course(1, "Programmazione", 9));
        courseService.createCourse(new Course(2, "Basi di Dati", 6));
        courseService.assignProfessor(courseService.list().get(0), 1);
        
        classroomService.add(new Classroom("A101", 30));
        
        Menu menu = new Menu(studentService, courseService, professorService, gradeService, classroomService);
        

    System.out.println("MENU GESTIONE UNIVERSITÀ \n\n SCEGLIERE LA MACROCATEGORIA:\n");
        menu.eseguiMenuPrincipale();


        System.out.println("Studenti finali:");
        studentService.list().forEach(System.out::println);

        System.out.println("\nProfessori finali:");
        professorService.list().forEach(System.out::println);

        System.out.println("\nCorsi finali:");
        courseService.list().forEach(System.out::println);

        System.out.println("\nAule finali:");
        classroomService.list().forEach(System.out::println);
    }
}
