package it.university.gestione_menu;

import java.util.Scanner;

import it.university.model.Student;
import it.university.service.*;
public class Menu {
    private int contatoreStudenti = 0;
    private StudentService studentService;

    public Menu(StudentService studentService) {
        this.studentService = studentService;
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
        System.out.println("3. CORSI");
        System.out.println("4. AULE");
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

    // ---------------------------------------------
    // 3. METODI DI GESTIONE DEI SOTTOMENU (con Caricamento)
    // ---------------------------------------------

    private void gestioneSottomenuStudenti(Scanner scanner) {
        int sceltaSottomenu;
        mostraMenuStudenti();
        
        while (true) {
            System.out.print("\n[STUDENTI] Inserisci la tua scelta (0 per tornare): ");
            
            if (scanner.hasNextInt()) {
                sceltaSottomenu = scanner.nextInt();
                scanner.nextLine(); 
                
                switch (sceltaSottomenu) {
                    case 1: 
                        simulaCaricamento("Esecuzione Logica: Iscrizione...");
                        System.out.println("--- Inserimento Dati Studente ---");
                        System.out.println("Inserisci Nome: ");
                        String nome = scanner.nextLine();
                        
                        System.out.println("Inserisci Email: ");
                        String email = scanner.nextLine();
                        

                        //generazione id automatico
                        this.contatoreStudenti++;
                        int idStudente = this.contatoreStudenti;
                        studentService.registerStudent(new Student(idStudente, nome, email));

                    
                        System.out.println("-> Logica: Studente Iscritto:" + idStudente +" " + nome + " " + email); 
                    
                    case 2: 
                    simulaCaricamento("Esecuzione Logica: Carriera...");
                        System.out.println("-> Logica: Carriera visualizzata."); 
                        break;

                        case 3: 
                        simulaCaricamento("Esecuzione Logica: Voti...");
                        System.out.println("-> Logica: Stampa Studenti"); 
                        studentService.list().forEach(System.out::println);

                        case 4: 
                        simulaCaricamento("Esecuzione Logica: Rinuncia agli studi...");
                        System.out.println("-> Logica: Rinuncia processata."); 
                        break;
                        case 0:
                        System.out.println("Torno al menu principale.");
                        return;
                        default:
                        System.out.println("Opzione non riconosciuta (1-4, 0).");
                    }
                    if (sceltaSottomenu != 0) mostraMenuStudenti();
                } else {
                    System.out.println("ERRORE: Inserisci un numero intero.");
                    scanner.nextLine();
                }
        }
    }
    
    
    private void gestioneSottomenuProfessori(Scanner scanner) {
        int sceltaSottomenu;
        mostraMenuProfessori();
        
        while (true) {
            System.out.print("\n[PROFESSORI] Inserisci la tua scelta (0 per tornare): ");
            
            if (scanner.hasNextInt()) {
                sceltaSottomenu = scanner.nextInt();
                scanner.nextLine(); 
                
                switch (sceltaSottomenu) {
                    case 1: 
                    simulaCaricamento("Esecuzione Logica: Prossime lezioni...");
                    System.out.println("-> Logica: Lezioni visualizzate."); 
                    break;
                    case 2: 
                    simulaCaricamento("Esecuzione Logica: Cerca professore...");
                    System.out.println("-> Logica: Ricerca completata."); 
                    break;
                    case 3: 
                    simulaCaricamento("Esecuzione Logica: Inserisci voti...");
                    System.out.println("-> Logica: Voti inseriti."); 
                    break;
                    case 0:
                    System.out.println("Torno al menu principale.");
                    return;
                    default:
                    System.out.println("Opzione non riconosciuta (1-3, 0).");
                }
                if (sceltaSottomenu != 0) mostraMenuProfessori();
            } else {
                System.out.println("ERRORE: Inserisci un numero intero.");
                scanner.nextLine();
            }
        }
    }
    
    private void gestioneSottomenuAule(Scanner scanner) {
        int sceltaSottomenu;
        mostraMenuAule();
        
        while (true) {
            System.out.print("\n[AULE] Inserisci la tua scelta (0 per tornare): ");
            
            if (scanner.hasNextInt()) {
                sceltaSottomenu = scanner.nextInt();
                scanner.nextLine(); 
                
                switch (sceltaSottomenu) {
                    case 1:
                    case 2:
                    case 3:
                    case 4: 
                    simulaCaricamento("Esecuzione Logica: Dettagli Aula " + sceltaSottomenu + "...");
                    System.out.println("-> Logica: Dettagli Aula " + sceltaSottomenu + " visualizzati."); 
                    break;
                    case 0:
                    System.out.println("Torno al menu principale.");
                    return;
                    default:
                    System.out.println("Opzione non riconosciuta (1-4, 0).");
                }
                if (sceltaSottomenu != 0) mostraMenuAule();
            } else {
                System.out.println("ERRORE: Inserisci un numero intero.");
                scanner.nextLine();
            }
        }
    }
    
    
    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scelta;
        
        mostraMenu();
        
        while (true) { 
            System.out.print("\n[PRINCIPALE] Inserisci la tua scelta (0 per uscire): ");
            
            if (scanner.hasNextInt()) {
                scelta = scanner.nextInt();
                scanner.nextLine(); 
                
                switch (scelta) {
                    case 1:
                    simulaCaricamento("Caricamento Sottomenu Studenti...");
                    gestioneSottomenuStudenti(scanner);
                    mostraMenu(); 
                    break;
                    case 2:
                    simulaCaricamento("Caricamento Sottomenu Professori...");
                    gestioneSottomenuProfessori(scanner);
                    mostraMenu(); 
                        break;
                        case 3:
                        simulaCaricamento("Caricamento Sottomenu Aule...");
                        gestioneSottomenuAule(scanner);
                        mostraMenu(); 
                        break;
                        case 0:
                        System.out.println("\nUscita dal programma. Arrivederci!");
                        scanner.close();
                        return; 
                        default:
                        System.out.println("Opzione non riconosciuta. Per favore, inserisci un numero tra 0 e 3.");
                    }
                    
                } else {
                    System.out.println("ERRORE: L'input non è un numero intero. Per favore, riprova.");
                    scanner.nextLine(); 
                    mostraMenu();
                }
            } 
        }*/

        public void eseguiMenuPrincipale() {
            Scanner scanner = new Scanner(System.in);
            int scelta;
    
            // Il ciclo principale dell'applicazione
            while (true) {
                mostraMenu(); // Visualizza le opzioni
                
                System.out.print("\n[PRINCIPALE] Inserisci la tua scelta (0 per uscire): ");
                
                if (scanner.hasNextInt()) {
                    scelta = scanner.nextInt();
                    scanner.nextLine(); 
    
                    switch (scelta) {
                        case 1:
                            simulaCaricamento("Caricamento Sottomenu Studenti...");
                            gestioneSottomenuStudenti(scanner);
                            break;
                        case 2:
                            simulaCaricamento("Caricamento Sottomenu Professori...");
                            gestioneSottomenuProfessori(scanner);
                            break;
                        case 3:
                            // Hai AULE nel menu, ma CORSI nel main,
                            // ipotizzo tu voglia chiamare gestioneSottomenuAule
                            simulaCaricamento("Caricamento Sottomenu Aule..."); 
                            gestioneSottomenuAule(scanner);
                            break; 
                        case 0:
                            System.out.println("\nUscita dal programma. Arrivederci!");
                            scanner.close(); // Chiudi lo Scanner qui e solo qui
                            return; 
                        default:
                            System.out.println("Opzione non riconosciuta. Per favore, inserisci un numero valido.");
                    }
                    
                } else {
                    System.out.println("ERRORE: L'input non è un numero intero. Per favore, riprova.");
                    scanner.nextLine(); // Consuma l'input non valido per evitare loop infiniti
                }
            }
        }
}