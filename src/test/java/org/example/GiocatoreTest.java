package org.example;

import junit.framework.TestCase;
import org.junit.jupiter.api.DisplayName;

public class GiocatoreTest extends TestCase {
    @DisplayName("Test costruttore e metodi get")
        public void testCostruttoreEGet(){
        Giocatore g = new Giocatore("cf", "nome", "cognome");
        assertEquals(g.getCf(), "cf");
        assertNull(g.getSquadra());
    }
    @DisplayName("Test metodi set")
    public void testSet(){
        Giocatore g = new Giocatore("cf", "nome", "cognome");
        Squadra s = new Squadra("Squadra");
        g.setSquadra(s);
        assertEquals(g.getSquadra(),s);
    }
    @DisplayName("Testo metodo 'CreaSquadra'")
    public void testCreaSquadra() {
        Giocatore g = new Giocatore("cf", "nome", "cognome");
        Squadra s = g.creaSquadra("Squadra");

        assertEquals(g.getSquadra(),s);
    }
    @DisplayName("Test inserimento calciatore in formazione")
    public void testAggiornaFormazione() {
        Giocatore g = new Giocatore("cf", "nome", "cognome");
        Squadra s = g.creaSquadra("Squadra");
        assertEquals(g.getSquadra().getFormazione().size(),0);
        Calciatore c = new Calciatore(0,"Nome", "Cognome", 24, "Squadra");
        g.aggiornaFormazione(c);
        c.setSvincolato(false);
        assertEquals(g.getSquadra().getFormazione().size(),1);
        assertEquals(g.getSquadra().getFormazione().getFirst().getId(),0);
        assertEquals(g.getSquadra().getFormazione().getFirst().getNome(),"Nome");
        assertEquals(g.getSquadra().getFormazione().getFirst().getCognome(),"Cognome");
        assertNull(g.getSquadra().getFormazione().getFirst().getUltimoVoto());
        assertFalse(g.getSquadra().getFormazione().getFirst().getSvincolato());
    }
}