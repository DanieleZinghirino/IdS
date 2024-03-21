package org.example;

import junit.framework.TestCase;
import org.junit.jupiter.api.DisplayName;

public class CampionatoTest extends TestCase {
    @DisplayName("Test di creazione di una nuova giornata nel campionato")
    public void testCreaGiornata() {
        Campionato c = new Campionato();
        c.creaGiornata();
        assertEquals(c.getGiornata(0).getId(),0);
        c.creaGiornata();
        assertEquals(c.getGiornata(0).getId(),0);
        c.creaGiornata();
        assertEquals(c.getGiornata(1).getId(),1);
    }
    @DisplayName("Test dell'inserimento del voto ad un calciatore in una determinata giornata")
    public void testAggiornaVoto() {
        Campionato c = new Campionato();
        c.creaGiornata();
        Calciatore c0 = new Calciatore(0,"Nome","Cognome",24,"Squadra");
        Bonus b = new Bonus(0,0,0,false,false);
        Voto v = new Voto(6.0F,b);
        Giornata g = c.getGiornata(0);
        g.aggiungiVoto(c0,v);
        c.aggiornaVoto(0,c0,6.0F,0,0,0,false,false);
        assertEquals(c0.getUltimoVoto().getTotale(),v.getTotale());
        c.aggiornaVoto(0,c0,7.0F,1,0,0,false,false);
        assertEquals(c0.getUltimoVoto().getTotale(),10.0F);}
    @DisplayName("Test dell'aggiornamento dei punteggi di tutte le squadre dopo una giornata")
    public void testAggiornaPunteggio() {
        Campionato c = new Campionato();
        Calciatore c1 = new Calciatore(1,"Nome","Cognome",24,"Squadra");
        Squadra s = new Squadra("SquadraTest");
        c.addSquadra(s);
        s.addCalciatore(c1);
        c.creaGiornata();
        c.aggiornaVoto(0,c1,6,0,0,0,false,false);
        c.aggiornaPunteggio();
        assertEquals(s.getPunteggio(),c1.getUltimoVoto().getTotale());

        float votoC1 = c1.getUltimoVoto().getTotale();

        Calciatore c2 = new Calciatore(2,"Nome","Cognome",24,"Squadra");
        s.addCalciatore(c2);
        c.creaGiornata();
        c.aggiornaVoto(1,c1,7,1,1,0,true,false);
        c.aggiornaVoto(1,c2,5,0,0,1,false,true);
        c.aggiornaPunteggio();
        assertEquals(s.getPunteggio(),votoC1 + c1.getUltimoVoto().getTotale() + c2.getUltimoVoto().getTotale());


    }
    @DisplayName("Test di controllo inserimento di una squadra già registrata")
    public void testCheckRidondanzaSquadra() {
        Campionato c = new Campionato();
        Squadra s = new Squadra("Squadra0");
        c.addSquadra(s);
        assertTrue(c.checkRidondanzaSquadra("Squadra1"));
        assertFalse(c.checkRidondanzaSquadra(s.getNome()));
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

        assertTrue(FantaApp.getInstance().getCampionato().checkCalciatoreInSquadra("SquadraTest",1));
        assertFalse(FantaApp.getInstance().getCampionato().checkCalciatoreInSquadra("SquadraTest",2));
        assertFalse(FantaApp.getInstance().getCampionato().checkCalciatoreInSquadra("Squadra",1));
    }

    @DisplayName("Test del controllo della presenza di almeno una giornata caricata nel sistema")
    public void testCheckPresenzaGiornata() {
        assertFalse(Validatore.checkPresenzaGiornata());

        Campionato c = new Campionato();
        c.creaGiornata();
        assertTrue(c.checkPresenzaGiornata());
    }
}