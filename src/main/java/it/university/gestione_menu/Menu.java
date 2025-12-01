package it.university.gestione_menu;

import java.util.Scanner;


import it.university.model.Professor;
import it.university.model.Student;
import it.university.model.Course;
import it.university.model.Enrollment;
import it.university.Exceptions.ErroreGenerico;
import it.university.Exceptions.RisorsaNonTrovata;
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
    private EnrollmentService enrollmentService;

    public Menu(StudentService studentService) {
        this.studentService = studentService;
    }

    public Menu(ProfessorService professorService){
       this.professorService =professorService;
    }

    public Menu(StudentService studentService, CourseService courseService, ProfessorService professorService, GradeService gradeService, ClassroomService classroomService, EnrollmentService enrollmentService) {
        this.studentService = studentService;
        this.courseService = courseService;
        this.professorService = professorService;
        this.gradeService = gradeService;
        this.classroomService = classroomService;
        this.enrollmentService = enrollmentService;
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
        System.out.println("5.  - STAMPA CORSI ASSEGNATI AGLI STUDENTI");
        System.out.println("0.  - Torna al menu principale");
        System.out.println("--------------------------");
    }

    //Boolean per controllare se la mail dello studente contiene @

    private static boolean isValidEmail(String email) {
        return email.contains("@");
    }
    //TUTTO IL METODO DI GESTIONE SOTTOMUNU STUDENTI VIENE GESTITO ATTRAVERSO ECCEZIONI
    private void gestioneSottomenuStudenti() {
        mostraMenuStudenti();
        
        while (true) {
            try{
                System.out.print("\n[STUDENTI] Inserisci la tua scelta (0 per tornare): ");
                int sceltaSottomenuStudenti = scanner.nextInt();
                scanner.nextLine();
                switch (sceltaSottomenuStudenti) {
                    //CASO CREAZIONE DI UN NUOVO OGGETTO STUDENTE
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
                    
                    //CASO RICERCA STUDENTE PER ID, VIENE GESTITO CON LE ECCEZIONI IN CASO VENGA INSERITO UN ID NON VALIDO O UN ID NON ESISTENTE (RisorsaNonTrovata.Java)
                    case 2: 
                        simulaCaricamento("Esecuzione Logica: Ricerca studente...");
                        try{
                            System.out.println("Inserire ID Studente:");
                            int idRicercaStr = scanner.nextInt();
                            scanner.nextLine();
                            Student studenteTrovato = studentService.findById(idRicercaStr);
                            System.out.println("Studente trovato: "+ studenteTrovato.getName()+ " Mail studente: "+ studenteTrovato.getEmail());
                        } catch(IllegalArgumentException e){
                            System.err.println("Errore di Input: "+ e.getMessage());
                        } catch(RisorsaNonTrovata e){
                            System.err.println("Errore Risorsa: " + e.getMessage());
                        } catch (Exception e){
                            System.err.println("Errore Generico: "+ e.getMessage());
                        }
                        break;
                    //CASO STAMPA TUTTA LA LISTA DEGLI STUDENTI 
                    case 3: 
                        simulaCaricamento("Esecuzione Logica: Stampa lista studenti...");
                        System.out.println("\n\n");
                        studentService.list().forEach(System.out::println);
                        break;

                    //CASO ASSEGNAMENTO DI UNO STUDENTE AD UN CORSO GESTITO CON LE DOVUTE ECCEZIONI
                    case 4: 
                        simulaCaricamento("Esecuzione Logica: Assegna corso...");
                        int idAssegnato = 0;
                        try{
                            System.out.println("Inserire ID Studente per l'assegnazione del corso:");
                            int idStudenteAssegna = scanner.nextInt();
                            scanner.nextLine();
                            studentService.findById(idStudenteAssegna);
                            idAssegnato = idStudenteAssegna;
                        }catch(IllegalArgumentException e){
                            System.err.println("Errore di Input: "+ e.getMessage());
                            break;
                        } catch(RisorsaNonTrovata e){
                            System.err.println("Errore Risorsa: " + e.getMessage());
                            break;
                        } catch (Exception e){
                            System.err.println("Errore Generico: "+ e.getMessage());
                            break;
                        }
                        
                        try {
                            System.out.println("Elenco dei corsi disponibili:");
                            courseService.list().forEach(corso -> {
                            System.out.println("  - ID: " + corso.getId() + ", Nome: " + corso.getName());
                            });
    
                            System.out.println("Inserire ID Corso da assegnare:");
                            int idCorsoAssegna = scanner.nextInt();
                            scanner.nextLine();
                            Course corsoAssegnato = courseService.findById(idCorsoAssegna);
                            enrollmentService.enrollStudent(new Enrollment(idAssegnato, idCorsoAssegna));
                            System.out.println("Corso assegnato a Studente " + idAssegnato + ":");
                            System.out.println("  - ID: " + corsoAssegnato.getId());
                            System.out.println("  - Nome: " + corsoAssegnato.getName());
                            System.out.println("  - CFU: " + corsoAssegnato.getCredits());
                            System.out.println("  - Professore ID: " + (corsoAssegnato.getProfessorId() != null ? corsoAssegnato.getProfessorId() : "Non assegnato"));
                        } catch (IllegalArgumentException e) {
                            System.err.println("Errore di Input: "+ e.getMessage());
                        } catch(RisorsaNonTrovata e){
                            System.err.println("Errore Risorsa: " + e.getMessage());
                        } catch (Exception e){
                            System.err.println("Errore Generico: "+ e.getMessage());
                        }
                        break;
                        
                    //CASO IN CUI IL PROGRAMMA STAMPA TUTTA LA LISTA DEGLI STUDENTI ISCRITTI NEI VARI CORSI
                    case 5:
                        simulaCaricamento("Esecuzione Logica: Stampa lista corsi assegnati...");
                        System.out.println("\n\n");
                        enrollmentService.list().forEach(System.out::println);
                        break;
                    case 0:
                        System.out.println("Torno al menu principale.");
                        return;
                    default:
                        System.out.println("Opzione non riconosciuta (1-5, 0).");
                    }
                    if (sceltaSottomenuStudenti != 0) mostraMenuStudenti();
            } catch (NumberFormatException e) {
                System.out.println("ERRORE: L'input non è un numero intero. Per favore, riprova.");
                continue;
            }catch (Exception e) {
                System.out.println("ERRORE: L'input non è un numero intero. Per favore, riprova.");
                break;
            }          
        }
    }
    //TUTTO IL METODO DI GESTIONE SOTTOMENU PROFESSORI VIENE GESTITO ATTRAVERSO ECCEZIONI
    private void gestioneSottomenuProfessori() {
        mostraMenuProfessori();   
        while (true) {
            try{
                System.out.print("\n[PROFESSORI] Inserisci la tua scelta (0 per tornare): ");
                int sceltaSottomenuProf = scanner.nextInt();
                scanner.nextLine();
                switch (sceltaSottomenuProf) {

                //CASO CREAZIONE DI UN NUOVO PROFESSORE
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

                    //CASO RICERCA PROFESSORE PER ID, VIENE GESTITO CON LE ECCEZIONI IN CASO VENGA INSERITO UN ID NON VALIDO O UN ID NON ESISTENTE (RisorsaNonTrovata.Java)
                    case 2: 
                        simulaCaricamento("Esecuzione Logica: Cerca professore...");
                        try{
                            System.out.println("Inserire ID Professore:");
                            int idProf = scanner.nextInt();
                            scanner.nextLine();
                            Professor professoreTrovato = professorService.findById(idProf);
                            System.out.println("Professore trovato: "+ professoreTrovato.getName());
                        }catch (RisorsaNonTrovata e){
                            System.out.println("Errore Risorsa: "+ e.getMessage());
                            break;
                        }catch(IllegalArgumentException e){
                            System.err.println("Errore di Input: "+ e.getMessage());
                        }catch (Exception e){
                            System.err.println("Errore Generico: "+ e.getMessage());
                            }
                        break;

                    //CARICAMENTO VOTO IN CARRIERA, GESTITO CON LE DOVUTE ECCEZIONI PER STUDENTE CORSO E VOTO
                    case 3: 
                        simulaCaricamento("Esecuzione Logica: Inserisci voto...");
                        
                        int idStudente = 0;
                        int idCorso = 0;
                        try{
                            System.out.println("ID studente: ");
                            idStudente = scanner.nextInt();
                            scanner.nextLine();
                            studentService.findById(idStudente);
                        } catch(IllegalArgumentException e){
                            System.err.println("Errore di Input: "+ e.getMessage());
                            break;
                        } catch (RisorsaNonTrovata e){
                            System.out.println("Errore Risorsa: "+ e.getMessage());
                            break;
                        }catch (Exception e){
                            System.err.println("Errore Generico: "+ e.getMessage());
                            break;
                        }
                        
                        try{
                            System.out.println("ID corso: ");
                            idCorso = scanner.nextInt();
                            scanner.nextLine();
                            courseService.findById(idCorso);
                        } catch(IllegalArgumentException e){
                            System.err.println("Errore di Input: "+ e.getMessage());
                            break;
                        } catch (RisorsaNonTrovata e){
                            System.out.println("Errore Risorsa: "+ e.getMessage());
                            break;
                        }catch (Exception e){
                            System.err.println("Errore Generico: "+ e.getMessage());
                            break;
                        }

                        try {
                            System.out.println("Valore voto: ");
                            int valoreVoto = scanner.nextInt();
                            scanner.nextLine();
                            gradeService.controlloVoto(valoreVoto);
                            Student studente = studentService.findById(idStudente);
                            System.out.print("\n\nVuoi inserire voto " + valoreVoto + " per Studente " + idStudente + " " + studente.getName() + studente.getEmail() + ", Corso " + idCorso + "? (S/N): ");
                            String conferma = scanner.nextLine();
                            if (conferma.equalsIgnoreCase("S")) {
                                gradeService.insertGrade(idStudente, idCorso, valoreVoto);
                                System.out.println("+-------------------------------+");
                                System.out.println("|       Voto inserito con successo!       |");
                                System.out.println("+-------------------------------+");
                                System.out.println("Voto " +valoreVoto+ " inserito con successo per lo studente " + idStudente + " " + studente.getName() +  studente.getEmail() + " nel corso " + idCorso);
                            } else {
                                System.out.println("Inserimento voto annullato.");
                            }
                        } catch (IllegalArgumentException e) {
                            System.err.println("Errore di Input: "+ e.getMessage());
                        }catch (Exception e) {
                            System.err.println("Errore Generico: "+ e.getMessage());
                        }
                        break;

                    case 0:
                        System.out.println("Torno al menu principale.");
                        return;
                    default:
                        System.out.println("Opzione non riconosciuta (1-3, 0).");
                    }
                    if (sceltaSottomenuProf != 0) mostraMenuProfessori();
                } catch (NumberFormatException e) {
                    System.out.println("ERRORE: L'input non è un numero intero. Per favore, riprova.");
                    continue;
                }catch (Exception e) {
                    System.out.println("ERRORE: L'input non è un numero intero. Per favore, riprova.");
                    break;
                } 
                    
                }
            }

        //TUTTO IL METODO DI GESTIONE SOTTOMENU AULE VIENE GESTITO ATTRAVERSO ECCEZIONI
        private void gestioneSottomenuAule() {
            mostraMenuAule();
            while (true) {
                try{
                    System.out.print("\n[AULE] Inserisci la tua scelta (0 per tornare): ");
                    int sceltaSottomenuAule = scanner.nextInt();
                    scanner.nextLine();
                    switch (sceltaSottomenuAule) {

                    //CASO PER LA CREAZIONE DI UNA NUOVA AULA GESTITO CON ECCEZIONI PER IL CONTROLLO SUL CODICE E SULLA CAPIENZA
                    case 1:
                        simulaCaricamento("Crea nuova Aula...");
                        System.out.println("Inserire codice aula:");
                        String codiceAula = scanner.nextLine();
                        if (classroomService.findByCode(codiceAula) != null) {
                            System.out.println("Errore: Esiste già un'aula con questo codice.");
                            break;
                        }
                    try{
                        System.out.println("Inserire capacità aula:");
                        int capacitaAulaInt = scanner.nextInt();
                        scanner.nextLine();
                        if (capacitaAulaInt<=0){
                            throw new ErroreGenerico("Il numero inserito deve essere positivo");
                        }
                        classroomService.add(new Classroom(codiceAula, capacitaAulaInt));
                        System.out.println("+-------------------------------+");
                        System.out.println("|       Aula creata con successo!       |");
                        System.out.println("+-------------------------------+");
                        System.out.println("\n\nAula creata: " + codiceAula + " con capacità di " + capacitaAulaInt + " posti.");
                    }catch (NumberFormatException e){
                        System.out.println("ERRORE: L'input non è un numero intero. Per favore, riprova.");
                        break;
                    }
                    catch (ErroreGenerico e){
                        System.out.println("ERRORE: "+ e.getMessage());
                        break;
                    } 
                    
                    //CASO STAMPA TUTTE LE AULE
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
            } catch (NumberFormatException e) {
                System.out.println("ERRORE: L'input non è un numero intero. Per favore, riprova.");
                continue;
            }
             catch (Exception e) {
                System.out.println("ERRORE: L'input non è un numero intero. Per favore, riprova.");
                break;
            }
        }
    }
    //SOTTOMENU PER LA GESTIONE DEI CORSI INTERAMENTE GESTITO CON LE ECCEZIONI
    private void gestioneSottomenuCorsi() {
        mostraMenuCorso();
        while(true){
            try{
                System.out.print("\n[CORSI] Inserisci la tua scelta (0 per tornare): ");
                int sceltaSottomenu = scanner.nextInt();
                scanner.nextLine();
                switch (sceltaSottomenu) {
                //CASO CREAZIONE DI UN NUOVO CORSO
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

                    //CASO DI ASSEGNA CORSO A PROFESSORE CON GESTIONE DELLE ECCEZIONI   
                    case 2:
                        simulaCaricamento("Esecuzione Logica: Assegna professore al corso...");
                        try{
                            System.out.println("Inserisci ID Corso:");
                            int courseId = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Inserisci ID Professore da assegnare:");
                            int professorId = scanner.nextInt();
                            scanner.nextLine();

                            courseService.assignProfessor(courseId, professorId, professorService.getRepository());
                            System.out.println("Professore con ID: "+ professorId +" assegnato al corso "+courseId+" con successo.");
                        } catch (IllegalArgumentException e){
                            System.err.println("Errore: "+ e.getMessage());
                        }catch (RisorsaNonTrovata e){
                            System.err.println("Errore: Risorsa non trovata "+ e.getMessage());
                        }
                        break;

                    //CASO PER LA STAMPA COMPLETA DI TUTTI I CORSI
                    case 3:
                        simulaCaricamento("Esecuzione Logica: Lista corsi...");
                        System.out.println("\n\n");
                        courseService.list().forEach(System.out::println);
                        break;
                    case 0:
                        System.out.println("Torno al menu principale.");
                        return;
                    default:
                        System.out.println("Opzione non riconosciuta (1-3, 0).");
                }
            if (sceltaSottomenu != 0) mostraMenuCorso();
            } catch (NumberFormatException e) {
                System.out.println("ERRORE: L'input non è un numero intero. Per favore, riprova.");
                continue;
            } catch (Exception e){
                System.out.println("ERRORE: L'input non è un numero intero. Per favore, riprova.");
                break;
            }
        }
    }

public void eseguiMenuPrincipale() {
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