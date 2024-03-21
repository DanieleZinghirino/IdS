package org.example;

import junit.framework.TestCase;
import org.junit.jupiter.api.DisplayName;

public class FantaAppTest extends TestCase {

    @DisplayName("Test dell'inserimento di un nuovo calciatore nel sistema")
    public void testAggiungiCalciatore() {
        FantaApp.getInstance().aggiungiCalciatore(0,"Nome","Cognome",24,"Squadra");
        assertEquals(ElencoCalciatori.getInstance().getCalciatore(0).getId(),0);
        assertEquals(ElencoCalciatori.getInstance().getCalciatore(0).getNome(),"Nome");
        assertEquals(ElencoCalciatori.getInstance().getCalciatore(0).getCognome(),"Cognome");
        assertTrue(ElencoCalciatori.getInstance().getCalciatore(0).getSvincolato());
        assertNull(ElencoCalciatori.getInstance().getCalciatore(0).getUltimoVoto());
        assertEquals(ElencoCalciatori.getInstance().dimensioneElenco(),1);
        assertTrue(ElencoCalciatori.getInstance().checkCalciatoreSvincolato(0));
    }
    @DisplayName("Test dell'inserimento di un nuovo giocatore nel sistema")
    public void testAggiungiGiocatore() {
        FantaApp.getInstance().aggiungiGiocatore("cf","Nome","Cognome");

        assertEquals(FantaApp.getInstance().getGiocatore("cf").getCf(),"cf");
        assertNull(FantaApp.getInstance().getGiocatore("cf").getSquadra());
        assertEquals(FantaApp.getInstance().getListaGiocatori().size(),1);
    }
    @DisplayName("Test del controllo dell'inserimento di un giocatore già registrato nel sistema")
    public void testCheckRidondanzaGiocatore() {
        FantaApp.getInstance().aggiungiGiocatore("cf","Nome","Cognome");
        assertFalse(FantaApp.getInstance().checkRidondanzaGiocatore("cf"));
        assertTrue(FantaApp.getInstance().checkRidondanzaGiocatore("cf2"));
    }
    @DisplayName("Test del controllo della creazione di una squadra per un nuovo giocatore")
    public void testCreaSquadra() {
        FantaApp.getInstance().aggiungiGiocatore("cf","Nome","Cognome");
        FantaApp.getInstance().creaSquadra("SquadraTest","cf");

        assertEquals(FantaApp.getInstance().getGiocatore("cf").getSquadra().getNome(),"SquadraTest");
        assertEquals(FantaApp.getInstance().getGiocatore("cf").getSquadra().getFormazione().size(),0);
    }
    @DisplayName("Test dell'inserimento di calciatori nella formazione di una nuova squadra")
    public void testAggiornaFormazione() {
        FantaApp.getInstance().aggiungiCalciatore(1,"Nome","Cognome",24,"Squadra");
        FantaApp.getInstance().aggiungiGiocatore("cf","Nome","Cognome");
        FantaApp.getInstance().creaSquadra("SquadraTest","cf");
        FantaApp.getInstance().aggiornaFormazione(1,"cf");

        assertEquals(FantaApp.getInstance().getGiocatore("cf").getSquadra().getFormazione().size(),1);
        assertEquals(FantaApp.getInstance().getGiocatore("cf").getSquadra().getFormazione().getFirst().getId(),1);

        FantaApp.getInstance().aggiungiCalciatore(2,"Nome","Cognome",24,"Squadra");
        FantaApp.getInstance().aggiornaFormazione(2,"cf");
        assertEquals(FantaApp.getInstance().getGiocatore("cf").getSquadra().getFormazione().size(),2);
        assertEquals(FantaApp.getInstance().getGiocatore("cf").getSquadra().getFormazione().getFirst().getId(),1);
        assertEquals(FantaApp.getInstance().getGiocatore("cf").getSquadra().getFormazione().get(1).getId(),2);


    }
    @DisplayName("Test dell'inserimento dei voti per un calciatore in una giornata")
    public void testAggiornaVoto() {
        FantaApp.getInstance().aggiungiCalciatore(0,"Nome","Cognome",24,"Squadra");
        FantaApp.getInstance().getCampionato().creaGiornata();
        FantaApp.getInstance().aggiornaVoto(0,FantaApp.getInstance().getElencoCalciatori().getCalciatore(0),
                6.0F,0,0,0,false,false);

        assertEquals(ElencoCalciatori.getInstance().getCalciatore(0).getUltimoVoto().getTotale(),6,0F);
    }
    @DisplayName("Test della gestione degli scambi di due calciatori tra due squadre o di un calciatore con uno svincolato")
    public void testGestioneScambio() {
        FantaApp.getInstance().aggiungiCalciatore(1,"Nome","Cognome",24,"Squadra");
        FantaApp.getInstance().aggiungiCalciatore(2,"Nome","Cognome",24,"Squadra");
        FantaApp.getInstance().aggiungiCalciatore(3,"Nome","Cognome",24,"Squadra");
        FantaApp.getInstance().aggiungiCalciatore(4,"Nome","Cognome",24,"Squadra");
        FantaApp.getInstance().aggiungiCalciatore(5,"Nome","Cognome",24,"Squadra");
        FantaApp.getInstance().aggiungiCalciatore(6,"Nome","Cognome",24,"Squadra");
        FantaApp.getInstance().aggiungiCalciatore(7,"Nome","Cognome",24,"Squadra");
        FantaApp.getInstance().aggiungiGiocatore("cf1","Nome","Cognome");
        FantaApp.getInstance().aggiungiGiocatore("cf2","Nome","Cognome");
        FantaApp.getInstance().creaSquadra("Squadra1","cf1");
        FantaApp.getInstance().creaSquadra("Squadra2","cf2");
        FantaApp.getInstance().aggiornaFormazione(1,"cf1");
        FantaApp.getInstance().aggiornaFormazione(2,"cf1");
        FantaApp.getInstance().aggiornaFormazione(3,"cf1");
        FantaApp.getInstance().aggiornaFormazione(4,"cf2");
        FantaApp.getInstance().aggiornaFormazione(5,"cf2");
        FantaApp.getInstance().aggiornaFormazione(6,"cf2");
        FantaApp.getInstance().gestioneScambio(1,"Squadra1",6,"Squadra2");

        assertEquals(FantaApp.getInstance().getGiocatore("cf1").getSquadra().getFormazione().size(),3);
        assertEquals(FantaApp.getInstance().getGiocatore("cf2").getSquadra().getFormazione().size(),3);
        assertEquals(FantaApp.getInstance().getGiocatore("cf1").getSquadra().getCalciatore(6).getId(),6);
        assertEquals(FantaApp.getInstance().getGiocatore("cf2").getSquadra().getCalciatore(1).getId(),1);
        assertNull(FantaApp.getInstance().getGiocatore("cf1").getSquadra().getCalciatore(1));
        assertNull(FantaApp.getInstance().getGiocatore("cf2").getSquadra().getCalciatore(6));

        FantaApp.getInstance().gestioneScambio(2,"Squadra1",7,null);
        assertEquals(FantaApp.getInstance().getGiocatore("cf1").getSquadra().getFormazione().size(),3);
        assertEquals(FantaApp.getInstance().getGiocatore("cf1").getSquadra().getCalciatore(7).getId(),7);
        assertNull(FantaApp.getInstance().getGiocatore("cf1").getSquadra().getCalciatore(2));
        assertTrue(ElencoCalciatori.getInstance().getCalciatore(2).getSvincolato());
        assertFalse(ElencoCalciatori.getInstance().getCalciatore(7).getSvincolato());


    }
}