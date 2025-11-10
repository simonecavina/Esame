package it.university.gestione_menu;

public class Iscrizione_studente {
    private String Nome;
    private String Cognome;
    private String CodiceFiscale;
    private String Email;
    private String CodiceTestDiAmmissione;

    public Iscrizione_studente(String nome, String cognome, String codiceFiscale, String email, String codiceTestDiAmmissione) {
        this.Nome = nome;
        this.Cognome = cognome;
        this.CodiceFiscale = codiceFiscale;
        this.Email = email;
        this.CodiceTestDiAmmissione = codiceTestDiAmmissione;
    }

    private boolean validaCodiceTest(String codice) {
        if (codice == null || codice.length() != 7) {
            return false;
        }
        try{
            Long.parseLong(codice);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    public String getNome(){
        return Nome;
    }

    public String getCognome(){
        return Cognome;
    }

    public String getCodiceFiscale(){
        return CodiceFiscale;
    }

    public String getEmail(){
        return Email;
    }

    public String getCodiceTestDiAmmissione(){
        return CodiceTestDiAmmissione;
    }

    @Override
    public String toString() {
        return "Dati Iscrizione:\n" +
               "  Nome: " + Nome + " " + Cognome + "\n" +
               "  C.F.: " + CodiceFiscale + "\n" +
               "  Email: " + Email + "\n" +
               "  Codice Test Amm.: " + CodiceTestDiAmmissione;
    }
}

