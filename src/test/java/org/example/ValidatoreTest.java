package org.example;

import junit.framework.TestCase;
import org.junit.jupiter.api.DisplayName;

public class ValidatoreTest extends TestCase {
    @DisplayName("Test del controllo di inserimento di un giocatore già registrato")
    public void testCheckRidondanzaGiocatore() {
        Giocatore g = new Giocatore("cf", "Nome", "cognome");
        FantaApp.getInstance().addGiocatore(g);
        assertFalse(Validatore.checkRidondanzaGiocatore("cf"));
    }
    @DisplayName("Test della verifica che un calciatore possa essere scelto da un nuovo giocatore per la propria squadra")
    public void testCheckCalciatoreSvincolato() {
        FantaApp.getInstance().aggiungiCalciatore(1,"Nome","Cognome",24,"Squadra");

        assertFalse(Validatore.checkCalciatoreSvincolato(0));
        assertTrue(Validatore.checkCalciatoreSvincolato(1));

        FantaApp.getInstance().aggiungiCalciatore(2,"Nome","Cognome",24,"Squadra");
        ElencoCalciatori.getInstance().getCalciatore(2).setSvincolato(false);

        assertFalse(Validatore.checkCalciatoreSvincolato(2));
    }
    @DisplayName("Test del controllo di inserimento di una squadra già registrata")
    public void testCheckRidondanzaSquadra() {
        Campionato c = new Campionato();
        Squadra s = new Squadra("Squadra0");
        c.addSquadra(s);
        assertTrue(c.checkRidondanzaSquadra("Squadra1"));
        assertFalse(c.checkRidondanzaSquadra(s.getNome()));
    }
    @DisplayName("Test del numero di calciatori svincolati sufficiente per creare una nuova squadra")
    public void testCheckNumeroCalciatoriSvincolati() {
        FantaApp.getInstance().aggiungiCalciatore(1,"Nome1","Cognome1",24,"Squadra1");
        FantaApp.getInstance().aggiungiCalciatore(2,"Nome2","Cognome2",24,"Squadra2");
        FantaApp.getInstance().aggiungiCalciatore(3,"Nome3","Cognome3",24,"Squadra3");
        assertTrue(Validatore.checkNumeroCalciatoriSvincolati());

        ElencoCalciatori.getInstance().getCalciatore(1).setSvincolato(false);
        assertFalse(Validatore.checkNumeroCalciatoriSvincolati());
    }
    @DisplayName("Test del controllo della presenza di un calciatore all'interno di una squadra")
    public void testCheckCalciatoreInSquadra() {
        FantaApp.getInstance().aggiungiCalciatore(1,"Nome1","Cognome1",24,"Squadra1");
        FantaApp.getInstance().aggiungiCalciatore(2,"Nome1","Cognome1",24,"Squadra1");
        Squadra s1 = new Squadra("SquadraTest");
        Squadra s2 = new Squadra("Squadra");
        s1.addCalciatore(ElencoCalciatori.getInstance().getCalciatore(1));
        s2.addCalciatore(ElencoCalciatori.getInstance().getCalciatore(2));
        FantaApp.getInstance().getCampionato().addSquadra(s1);
        FantaApp.getInstance().getCampionato().addSquadra(s2);

        assertTrue(Validatore.checkCalciatoreInSquadra("SquadraTest",1));
        assertFalse(Validatore.checkCalciatoreInSquadra("SquadraTest",2));
        assertFalse(Validatore.checkCalciatoreInSquadra("Squadra",1));
    }
    @DisplayName("Test del controllo della presenza di almeno una giornata caricata nel sistema")
    public void testCheckPresenzaGiornata() {
        assertFalse(Validatore.checkPresenzaGiornata());

        FantaApp.getInstance().nuovaGiornata();
        assertTrue(Validatore.checkPresenzaGiornata());
    }
}