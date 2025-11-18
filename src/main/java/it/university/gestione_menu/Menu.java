package it.university.gestione_menu;

import java.util.Scanner;

import it.university.model.Professor;
import it.university.model.Student;
import it.university.model.Course;
import it.university.model.Classroom;
import it.university.service.*;
public class Menu {
    // Nella tua classe Menu (fuori da tutti i metodi):
    private final Scanner scanner = new Scanner(System.in);
    private int contatoreStudenti = 1500;
    private int contatoreProfessori =0;
    private StudentService studentService;
    private ProfessorService professorService;
    private CourseService courseService;
    private GradeService gradeService;
    private ClassroomService classroomService;

    public Menu(StudentService studentService) {
        this.studentService = studentService;
    }

    public Menu(ProfessorService professorService){
       this.professorService =professorService;
    }

    public Menu(StudentService studentService, CourseService courseService, ProfessorService professorService, GradeService gradeService, ClassroomService classroomService) {
        this.studentService = studentService;
        this.courseService = courseService;
        this.professorService = professorService;
        this.gradeService = gradeService;
        this.classroomService = classroomService;
    }

    private static void simulaCaricamento(String messaggio) {
        System.out.print("\n" + messaggio + " ");
        int durata = 20; 
        
        for (int i = 0; i < durata; i++) {
            System.out.print("#");
            try {
                Thread.sleep(20); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(" Completato.");

    }


    private static void mostraMenu() {
        System.out.println("\n--- MENU PRINCIPALE ---");
        System.out.println("1. STUDENTI");
        System.out.println("2. PROFESSORI");
        System.out.println("3. AULE");
        System.out.println("4. CORSI");
        System.out.println("0. Esci dal programma");
        System.out.println("----------------------");
    }

    private static void mostraMenuCorso() {
        System.out.println("\n--- MENU CORSO ---");
        System.out.println("1.   - CREA NUOVO CORSO");
        System.out.println("2.   - ASSEGNA CORSO");
        System.out.println("3.   - LISTA CORSI");
        System.out.println("0. Torna al menu principale");
        System.out.println("-------------------------");
    }
        private static void mostraMenuAule() {
        System.out.println("\n--- MENU AULE ---");
        System.out.println("1.   - CREA NUOVA AULA");
        System.out.println("2.   - VISUALIZZA AULE");
        System.out.println("0. Torna al menu principale");
        System.out.println("-------------------------");
    }

    private static void mostraMenuProfessori() {
        System.out.println("\n--- MENU PROFESSORI ---");
        System.out.println("1.  - AGGIUNGI PROFESSORE");
        System.out.println("2.  - CERCA PROFESSORE");
        System.out.println("3.  - INSERISCI VOTO");
        System.out.println("0. Torna al menu principale");
        System.out.println("-----------------------------");
    }

    private static void mostraMenuStudenti() {
        System.out.println("\n--- MENU STUDENTI ---");
        System.out.println("1.  - ISCRIZIONE");
        System.out.println("2.  - CERCA STUDENTE");
        System.out.println("3.  - STAMPA LISTA STUDENTI");
        System.out.println("4.  - ASSEGNA CORSO");
        System.out.println("5.  - VISUALIZZA VOTI");
        System.out.println("0.  - Torna al menu principale");
        System.out.println("--------------------------");
    }

    //Boolean per controllare se la mail dello studente contiene @

    private static boolean isValidEmail(String email) {
        return email.contains("@");
    }


    private void gestioneSottomenuStudenti() {
        mostraMenuStudenti();
        
        while (true) {
            System.out.print("\n[STUDENTI] Inserisci la tua scelta (0 per tornare): ");
            String inputMenu = scanner.nextLine();
            int sceltaSottomenuStudenti = -1;
            try{
                sceltaSottomenuStudenti = Integer.parseInt(inputMenu);
            } catch (NumberFormatException e) {
                System.out.println("ERRORE: L'input non è un numero intero. Per favore, riprova.");
                continue;
            }
                
                switch (sceltaSottomenuStudenti) {
                    case 1: 
                        simulaCaricamento("Esecuzione Logica: Iscrizione...");
                        System.out.println("--- Inserimento Dati Studente ---");
                        System.out.println("Inserisci Nome: ");
                        String nome = scanner.nextLine();
                        
                        String email = "";
                        boolean emailValida = false;
                        while (!emailValida) {
                            System.out.println("Inserisci Email: ");
                            email = scanner.nextLine();
                            if (isValidEmail(email)) {
                                emailValida = true;
                            } else {
                                System.out.println("Email non valida! \n\n\nRiprova.");
                            }
                        }

                        //generazione id automatico
                        this.contatoreStudenti++;
                        int idStudente = this.contatoreStudenti;
                        studentService.registerStudent(new Student(idStudente, nome, email));

                    
                        System.out.println("+-----------------------------+");
                        System.out.println("|   Studente aggiunto con successo!   |");
                        System.out.println("+-----------------------------+");
                        System.out.println("Studente Iscritto:" + idStudente +" " + nome + " " + email); 
                        break;
                    
                    case 2: 
                        simulaCaricamento("Esecuzione Logica: Ricerca studente...");
                        System.out.println("Inserire ID Studente:");
                        String idRicercaStr = scanner.nextLine();
                        int idRicercaStud = -1;
                        try{
                            idRicercaStud = Integer.parseInt(idRicercaStr);
                        } catch (NumberFormatException e){
                            System.out.println("ERRORE: L'input non è un numero intero. Per favore, riprova.");
                            break;
                        }
                        
                        Student studenteTrovato = studentService.findById(idRicercaStud);
                        if (studenteTrovato != null) {
                            System.out.println("\n\nStudente trovato: " + studenteTrovato);
                        } else {
                            System.out.println("\n\nStudente con ID " + idRicercaStud + " non trovato.");
                        }
                        
                        break;

                        case 3: 
                            simulaCaricamento("Esecuzione Logica: Stampa lista studenti...");
                            System.out.println("\n\n");
                            studentService.list().forEach(System.out::println);
                            break;
                        
                        // case 4: 
                        // simulaCaricamento("Esecuzione Logica: Assegna corso...");
                        // System.out.println("Inserire ID Studente per l'assegnazione del corso:");

                        // int idStudenteAssegna = scanner.nextInt();
                        // scanner.nextLine();

                        
                        // Student studToAssign = studentService.findById(idStudenteAssegna);
                        // if (studToAssign == null) {
                        //     System.out.println("ID non trovato, perfavore inserirne uno valido");
                        //     break;
                        // }
                        // System.out.println("Elenco dei corsi disponibili:");
                        // courseService.list().forEach(corso -> {
                        //     System.out.println("  - ID: " + corso.getId() + ", Nome: " + corso.getName());
                        // });

                        // System.out.println("Inserire ID Corso da assegnare:");
                        // int idCorsoAssegna = scanner.nextInt();
                        // scanner.nextLine();
                        
                        // Course corsoAssegnato = courseService.findById(idCorsoAssegna);
                        // if (corsoAssegnato != null) {
                        //     System.out.println("Corso assegnato a Studente " + idStudenteAssegna + ":");
                        //     System.out.println("  - ID: " + corsoAssegnato.getId());
                        //     System.out.println("  - Nome: " + corsoAssegnato.getName());
                        //     System.out.println("  - CFU: " + corsoAssegnato.getCredits());
                        //     System.out.println("  - Professore ID: " + (corsoAssegnato.getProfessorId() != null ? corsoAssegnato.getProfessorId() : "Non assegnato"));
                        // } else {
                        //     System.out.println("Corso con ID " + idCorsoAssegna + " non trovato.");
                        // }
                        // break; 
                        case 0:
                            System.out.println("Torno al menu principale.");
                            return;
                        default:
                            System.out.println("Opzione non riconosciuta (1-4, 0).");
                    }
                    if (sceltaSottomenuStudenti != 0) mostraMenuStudenti();    
        }
    }
    
    private void gestioneSottomenuProfessori() {
        mostraMenuProfessori();
        
        while (true) {
            System.out.print("\n[PROFESSORI] Inserisci la tua scelta (0 per tornare): ");
            String inputLine = scanner.nextLine();
            int sceltaSottomenuProf = -1;
            try{
                sceltaSottomenuProf = Integer.parseInt(inputLine);
            } catch (NumberFormatException e) {
                System.out.println("ERRORE: L'input non è un numero intero. Per favore, riprova.");
                continue;
            } 
            boolean inputValido = true;
                switch (sceltaSottomenuProf) {
                   case 1: 
                    simulaCaricamento("Esecuzione Logica: Aggiungi Professore...");
                    System.out.println("Inserisci Nome: ");
                    String nome = scanner.nextLine();
                    System.out.println("Inserisci Dipartimento: ");
                    String department = scanner.nextLine();

                    this.contatoreProfessori++;
                    int idProfessore = this.contatoreProfessori;
                    professorService.add(new Professor(idProfessore, nome, department));
                    
                    System.out.println("+-------------------------------+");
                    System.out.println("|  Professore aggiunto con successo!  |");
                    System.out.println("+-------------------------------+");
                    System.out.println("Professore Aggiunto: " + idProfessore + " " + nome + " " + department);
                    break;
                    case 2: 
                    simulaCaricamento("Esecuzione Logica: Cerca professore...");
                    System.out.println("Inserire ID Professore:");
                    String idProfString = scanner.nextLine();
                    int idProfInt = -1;
                    try{
                        idProfInt = Integer.parseInt(idProfString);
                    } catch (NumberFormatException e){
                        System.out.println("ERRORE: L'input non è un numero intero. Per favore, riprova.");
                        inputValido = false;
                        break;
                    }
                    if (inputValido){
                        Professor professoreTrovato = professorService.findById(idProfInt);
                        if (professoreTrovato != null) {
                            System.out.println("\n\nProfessore trovato: " + professoreTrovato);
                        } else {
                            System.out.println("\n\nProfessore con ID " + idProfInt + " non trovato.");
                        }   
                    }
                    break;

                    case 3: 
                    inputValido = true;
                    simulaCaricamento("Esecuzione Logica: Inserisci voto...");
                    System.out.println("ID studente: ");
                    String idStudenteString = scanner.nextLine();
                    int idStudenteInt = -1;
                    try{
                        idStudenteInt = Integer.parseInt(idStudenteString);
                        if (studentService.findById(idStudenteInt) == null) {
                            System.out.println("Studente non trovato. Ritorno al menu professori.");
                            inputValido = false;
                    }
                    } catch (NumberFormatException e){
                        System.out.println("ERRORE: L'input non è un numero intero. Per favore, riprova.");
                        inputValido = false;
                        break;
                    }
            
                    
                    System.out.println("ID corso: ");
                    String idCorsoString = scanner.nextLine();
                    int idCorso = -1;
                    try{
                        idCorso = Integer.parseInt(idCorsoString);
                        if (courseService.findById(idCorso) == null) {
                            System.out.println("Corso non trovato. Ritorno al menu professori.");
                            inputValido = false;
                    }
                    } catch (NumberFormatException e){
                        System.out.println("ERRORE: L'input non è un numero intero. Per favore, riprova.");
                        inputValido = false;
                        break;
                    }

                    System.out.println("Valore voto: ");
                    String valoreVotoString = scanner.nextLine();
                    int valoreVoto = -1;
                    try{
                        valoreVoto = Integer.parseInt(valoreVotoString);
                    } catch (NumberFormatException e){
                        System.out.println("ERRORE: L'input non è un numero intero. Per favore, riprova.");
                        inputValido = false;
                        break;
                    }

                    if(valoreVoto < 0 || valoreVoto > 30) {
                        System.out.println("Valore voto non valido. Ritorno al menu professori.");
                        break;
                    }
                    if (inputValido){
                        Student studente = studentService.findById(idStudenteInt);
                        System.out.print("\n\nVuoi inserire voto " + valoreVoto + " per Studente " + idStudenteInt + " " + studente.getName() + studente.getEmail() + ", Corso " + idCorso + "? (S/N): ");
                        String conferma = scanner.nextLine();
                        if (conferma.equalsIgnoreCase("S")) {
                            gradeService.insertGrade(idStudenteInt, idCorso, valoreVoto);
                            System.out.println("+-------------------------------+");
                            System.out.println("|       Voto inserito con successo!       |");
                            System.out.println("+-------------------------------+");
                            System.out.println("Voto " +valoreVoto+ " inserito con successo per lo studente " + idStudenteInt + " " + studente.getName() +  studente.getEmail() + " nel corso " + idCorso);
                        } else {
                            System.out.println("Inserimento voto annullato.");
                        }  

                    }
                    break;

                    case 0:
                    System.out.println("Torno al menu principale.");
                    return;
                    default:
                    System.out.println("Opzione non riconosciuta (1-3, 0).");
                }
                if (sceltaSottomenuProf != 0) mostraMenuProfessori();
            }
        }
    
    
    private void gestioneSottomenuAule() {
        
        mostraMenuAule();
        
        while (true) {
            System.out.print("\n[AULE] Inserisci la tua scelta (0 per tornare): ");
            String inputLine = scanner.nextLine();
            int sceltaSottomenuAule = -1;
            try{
                sceltaSottomenuAule = Integer.parseInt(inputLine);
            } catch (NumberFormatException e) {
                System.out.println("ERRORE: L'input non è un numero intero. Per favore, riprova.");
                continue;
            }  
            boolean inputValido = true;

            switch (sceltaSottomenuAule) {
                case 1:
                simulaCaricamento("Crea nuova Aula...");
                System.out.println("Inserire codice aula:");
                String codiceAula = scanner.nextLine();
                if (classroomService.findByCode(codiceAula) != null) {
                    System.out.println("Errore: Esiste già un'aula con questo codice.");
                    inputValido = false;
                    break;
                }
                System.out.println("Inserire capacità aula:");
                String capacitaAulaString = scanner.nextLine();
                int capacitaAulaInt = -1;
                try{
                    capacitaAulaInt = Integer.parseInt(capacitaAulaString);
                    if (capacitaAulaInt <= 0) {
                        inputValido = false;
                        System.out.println("Errore: La capacità deve essere un numero positivo.");
                        break;
                    }
                } catch (NumberFormatException e){
                    inputValido = false;
                    System.out.println("ERRORE: L'input non è un numero intero. Per favore, riprova.");
                }   
                
                if (inputValido){
                    classroomService.add(new Classroom(codiceAula, capacitaAulaInt));
                    System.out.println("+-------------------------------+");
                    System.out.println("|       Aula inserita con successo!       |");
                    System.out.println("+-------------------------------+");
                    System.out.println("\n\nAula creata: " + codiceAula + " con capacità di " + capacitaAulaInt + " posti.");
                }
                
                case 2:
                simulaCaricamento("Visualizza Aule...");
                System.out.println("\n\n");
                classroomService.list().forEach(System.out::println);
                break;
                case 0:
                System.out.println("Torno al menu principale.");
                return;
                default:
                System.out.println("Opzione non riconosciuta (1-4, 0).");
            }
            if (sceltaSottomenuAule != 0) mostraMenuAule(); 
        }
    }

    private void gestioneSottomenuCorsi() {
        mostraMenuCorso();
        while(true){
            System.out.print("\n[CORSI] Inserisci la tua scelta (0 per tornare): ");
            String inputLine = scanner.nextLine();
            int sceltaSottomenu = -1;
            try{
                sceltaSottomenu = Integer.parseInt(inputLine);
            } catch (NumberFormatException e) {
                System.out.println("ERRORE: L'input non è un numero intero. Per favore, riprova.");
                continue;
            }
                
            switch (sceltaSottomenu) {
                case 1:
                    simulaCaricamento("Esecuzione Logica: Crea nuovo corso...");
                    System.out.println("Inserisci Nome Corso: ");
                    String nomeCorso = scanner.nextLine();
                    System.out.println("Inserisci CFU Corso: ");
                    String cfuString = scanner.nextLine();
                    try{
                        int cfuCorso = Integer.parseInt(cfuString);
                        int idCorso = courseService.list().size() + 1;
                        courseService.createCourse(new Course(idCorso, nomeCorso, cfuCorso));

                        System.out.println("+-------------------------------+");
                        System.out.println("|       Corso creato con successo!       |");
                        System.out.println("+-------------------------------+");
                        System.out.println("Corso Creato: " + idCorso + " " + nomeCorso + " " + cfuCorso + " CFU");
                    break;

                    } catch(NumberFormatException e){
                        System.out.println("ERRORE: L'input non è un numero intero. Per favore, riprova.");
                        break;
                    }
                    
                case 2:
                    simulaCaricamento("Esecuzione Logica: Assegna professore al corso...");
                    Course corsoDaAssegnare = null;

                    System.out.println("Inserire ID Corso da assegnare:");
                    String idCorsoString = scanner.nextLine();
                    boolean inputValido = true;
                    try{
                        int idCorsoAssegnaInt = Integer.parseInt(idCorsoString);
                        corsoDaAssegnare = courseService.findById(idCorsoAssegnaInt);
                        if (corsoDaAssegnare == null) {
                            System.out.println("ID Corso non trovato, perfavore inserirne uno valido");
                            inputValido = false;
                        }
                    }catch(NumberFormatException e){
                        System.out.println("ERRORE: L'input non è un numero intero. Per favore, riprova.");
                        inputValido = false;
                    }

                    if (!inputValido){
                        break;
                    } 
                        
                    int idProfessoreAssegnaInt = -1;
                    System.out.println("Inserire ID Professore da assegnare al corso:");
                    String idProfessoreAssegnaString = scanner.nextLine();
                    try{
                        idProfessoreAssegnaInt = Integer.parseInt(idProfessoreAssegnaString);
                        Professor professoreDaAssegnare = professorService.findById(idProfessoreAssegnaInt);
                        if (professoreDaAssegnare == null) {
                            System.out.println("ID Professore non trovato, perfavore inserirne uno valido");
                            inputValido = false;
                        }
                        
                    }catch (NumberFormatException e){
                        System.out.println("ERRORE: L'input non è un numero intero. Per favore, riprova.");
                        inputValido = false;
                    }
                    if (inputValido){
                        courseService.assignProfessor(corsoDaAssegnare, idProfessoreAssegnaInt);
                        System.out.println("+-------------------------------+");
                        System.out.println("|       Professore assegnato con successo!       |");
                        System.out.println("+-------------------------------+");
                        System.out.println("Professore " + idProfessoreAssegnaInt + " assegnato al corso " + corsoDaAssegnare.getId());
                    }
                    break;
                
                case 3:
                    simulaCaricamento("Esecuzione Logica: Lista corsi...");
                    System.out.println("\n\n");
                    courseService.list().forEach(System.out::println);
                    break;
                case 0:
                    System.out.println("Torno al menu principale.");
                    return;
                default:
                    System.out.println("Opzione non riconosciuta (1-4, 0).");
            }
            if (sceltaSottomenu != 0) mostraMenuCorso();
        }
    }

    

public void eseguiMenuPrincipale() {
            //Scanner scanner = new Scanner(System.in);
            int scelta;
    
            // Il ciclo principale dell'applicazione
            while (true) {
                mostraMenu(); // Visualizza le opzioni
                
                System.out.print("\n[PRINCIPALE] Inserisci la tua scelta (0 per uscire): ");
                
                //scanner.nextLine(); 
                String inputLine = scanner.nextLine();
                System.out.print(inputLine);
                    try{
                        scelta = Integer.parseInt(inputLine);
                        switch (scelta) {   
                            case 1:
                                simulaCaricamento("Caricamento Sottomenu Studenti...");
                                gestioneSottomenuStudenti();
                                break;
                            case 2:
                                simulaCaricamento("Caricamento Sottomenu Professori...");
                                gestioneSottomenuProfessori();
                                break;
                            case 3:
                                // Hai AULE nel menu, ma CORSI nel main,
                                // ipotizzo tu voglia chiamare gestioneSottomenuAule
                                simulaCaricamento("Caricamento Sottomenu Aule..."); 
                                gestioneSottomenuAule();
                                break; 
                            case 4:
                                simulaCaricamento("Caricamento Sottomenu Corsi...");
                                gestioneSottomenuCorsi();
                                break;
                            case 0:
                                System.out.println("\nUscita dal programma. Arrivederci!");
                                //scanner.close(); // Chiudi lo Scanner qui e solo qui
                                return; 
                            default:
                                System.out.println("Opzione non riconosciuta. Per favore, inserisci un numero valido.");
                        }
                    }catch (NumberFormatException e) {
                        System.out.println("ERRORE: L'input non è un numero intero. Per favore, riprova.");
                        continue;
                    }
                
            }
        }
}