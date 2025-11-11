package it.university.gestione_menu;

import java.util.Scanner;

public class Menu {

    private static void simulaCaricamento(String messaggio) {
        System.out.print("\n" + messaggio + " ");
        int durata = 20; 
        
        for (int i = 0; i < durata; i++) {
            System.out.print("#");
            try {
                Thread.sleep(50); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(" Completato.");
        System.out.println(" Completatoooooooooooooooooooooooooooooooooooooooooooooooooooooooooo.");
    }


    private static void mostraMenu() {
        System.out.println("\n--- MENU PRINCIPALE ---");
        System.out.println("1. STUDENTI");
        System.out.println("2. PROFESSORI");
        System.out.println("3. AULE");
        System.out.println("0. Esci dal programma");
        System.out.println("----------------------");
    }

    private static void mostraMenuAule() {
        System.out.println("\n--- MENU AULE ---");
        System.out.println("1. 01 - CATTEDRALE");
        System.out.println("2. 02 - CATTEDRALE");
        System.out.println("3. 03 - CATTEDRALE");
        System.out.println("4. 01 - CORPO F");
        System.out.println("0. Torna al menu principale");
        System.out.println("-------------------------");
    }

    private static void mostraMenuProfessori() {
        System.out.println("\n--- MENU PROFESSORI ---");
        System.out.println("1. 01 - PROSSIME LEZIONI");
        System.out.println("2. 02 - CERCA PROFESSORE");
        System.out.println("3. 03 - INSERISCI VOTI");
        System.out.println("0. Torna al menu principale");
        System.out.println("-----------------------------");
    }

    private static void mostraMenuStudenti() {
        System.out.println("\n--- MENU STUDENTI ---");
        System.out.println("1. 01 - ISCRIZIONE");
        System.out.println("2. 02 - CARRIERA");
        System.out.println("3. 03 - VOTI");
        System.out.println("4. 01 - RINUNCIA AGLI STUDI");
        System.out.println("0. Torna al menu principale");
        System.out.println("--------------------------");
    }

    // ---------------------------------------------
    // 3. METODI DI GESTIONE DEI SOTTOMENU (con Caricamento)
    // ---------------------------------------------

    private static void gestioneSottomenuStudenti(Scanner scanner) {
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
                        System.out.println("-> Logica: Iscrizione completata."); 
                        System.out.println("--- Inserimento Dati Studente ---");
                     System.out.println("Inserisci Nome: ");
                    String nome = scanner.nextLine();
        
                    System.out.println("Inserisci Cognome: ");
                    String cognome = scanner.nextLine();
        
                    System.out.println("Inserisci Codice Fiscale: ");
                    String cf = scanner.nextLine();
        
                    System.out.println("Inserisci Email: ");
                    String email = scanner.nextLine();
        
      
                    Iscrizione_studente studente = null;
                    String codiceTest = "";
        
                    while (studente == null) {
                    System.out.print("Inserisci Codice Test di Ammissione (7 numeri): ");
                    codiceTest = scanner.nextLine();
            
                    try {
                    studente = new Iscrizione_studente(nome, cognome, cf, email, codiceTest);
                    System.out.println("\n✅ Iscrizione avvenuta con successo!");
                    } catch (IllegalArgumentException e) {
                    System.err.println(e.getMessage());
                    System.out.println("Riprova ad inserire il codice del test.");
            }
        }
        
     
                    System.out.println("\n--- Riepilogo ---");
                    System.out.println(studente);

                    scanner.close();

                    case 2: 
                        simulaCaricamento("Esecuzione Logica: Carriera...");
                        System.out.println("-> Logica: Carriera visualizzata."); 
                        break;
                    case 3: 
                        simulaCaricamento("Esecuzione Logica: Voti...");
                        System.out.println("-> Logica: Voti inseriti."); 
                        break;
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


    private static void gestioneSottomenuProfessori(Scanner scanner) {
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

    private static void gestioneSottomenuAule(Scanner scanner) {
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


    public static void main(String[] args) {
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
    }
}