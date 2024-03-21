package org.example;

import junit.framework.TestCase;
import org.junit.jupiter.api.DisplayName;
import java.util.ArrayList;

public class SquadraTest extends TestCase {
    @DisplayName("Test del costruttore e dei metodi get")
    public void testCostruttoreEGet(){
        ArrayList<Calciatore> formazione = new ArrayList<>();
        Squadra s = new Squadra("SquadraTest");
        assertEquals(s.getNome(),"SquadraTest");
        assertEquals(s.getPunteggio(),0.0F);
        assertEquals(s.getFormazione(),formazione);
        assertEquals(s.getFormazione().size(),0);
    }
    @DisplayName("Test aggiornamento punteggio squadra")
    public void testAggiornaPunteggio() {
        Calciatore c1, c2, c3;
        c1 = new Calciatore(1, "Nome1","Cognome1", 24, "Squadra1");
        c2 = new Calciatore(2, "Nome2","Cognome3", 24, "Squadra2");
        c3 = new Calciatore(3, "Nome3","Cognome3", 24, "Squadra3");
        Squadra s = new Squadra("SquadraTest");
        s.addCalciatore(c1);
        s.addCalciatore(c2);
        s.addCalciatore(c3);
        Voto v1,v2,v3;
        Bonus b1,b2,b3;
        b1 = new Bonus(0,0,0,false,false);
        b2 = new Bonus(1,0,0,false,false);
        b3 = new Bonus(0, 1, 0, true, false);
        v1 = new Voto(6, b1);
        v2 = new Voto(7, b2);
        v3 = new Voto( 5, b3);
        c1.setUltimoVoto(v1);
        c2.setUltimoVoto(v2);
        c3.setUltimoVoto(v3);

        s.aggiornaPunteggio();
        assertEquals(s.getPunteggio(), 6+10+5.5F);
    }
    @DisplayName("Test aggiunta di un calciatore nella formazione")
    public void testAddUnCalciatore() {
        Calciatore c1 = new Calciatore(1, "Nome1","Cognome1", 24, "Squadra1");
        Squadra s = new Squadra("SquadraTest");
        ArrayList<Calciatore> formazioneTest = new ArrayList<>();

        formazioneTest.add(c1);
        s.addCalciatore(c1);

        assertEquals(s.getFormazione().size(),1);
        assertEquals(s.getFormazione(),formazioneTest);
        assertEquals(s.getFormazione().getFirst(),c1);
    }
    @DisplayName("Test aggiunta di 3 calciatori nella formazione")
    public void testAddTreCalciatori() {
        Calciatore c1, c2, c3;
        c1 = new Calciatore(1, "Nome1","Cognome1", 24, "Squadra1");
        c2 = new Calciatore(2, "Nome2","Cognome3", 24, "Squadra2");
        c3 = new Calciatore(3, "Nome3","Cognome3", 24, "Squadra3");
        Squadra s = new Squadra("SquadraTest");
        s.addCalciatore(c1);
        s.addCalciatore(c2);
        s.addCalciatore(c3);
        ArrayList<Calciatore> formazioneTest = new ArrayList<>();
        formazioneTest.add(c1);
        formazioneTest.add(c2);
        formazioneTest.add(c3);
        assertEquals(s.getFormazione().size(),3);
        assertEquals(s.getFormazione(), formazioneTest);
        assertEquals(s.getFormazione().getFirst(),c1);
        assertEquals(s.getFormazione().get(1),c2);
        assertEquals(s.getFormazione().getLast(),c3);
    }
    @DisplayName("Test rimozioine di un calciatore dalla formazione")
    public void testRemoveCalciatore() {
        Calciatore c1, c2, c3;
        c1 = new Calciatore(1, "Nome1","Cognome1", 24, "Squadra1");
        c2 = new Calciatore(2, "Nome2","Cognome3", 24, "Squadra2");
        c3 = new Calciatore(3, "Nome3","Cognome3", 24, "Squadra3");
        Squadra s = new Squadra("SquadraTest");
        s.addCalciatore(c1);
        s.addCalciatore(c2);
        s.addCalciatore(c3);
        ArrayList<Calciatore> formazioneTest = new ArrayList<>();
        formazioneTest.add(c1);
        formazioneTest.add(c3);

        s.removeCalciatore(c2);
        assertEquals(s.getFormazione().size(),2);
        assertEquals(s.getFormazione(),formazioneTest);

    }
}