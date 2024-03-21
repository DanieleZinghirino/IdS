package org.example;

import junit.framework.TestCase;
import org.junit.jupiter.api.DisplayName;

public class GestoreScambioTest extends TestCase {
    @DisplayName("Test scambio tra due squadre con calciatori nelle proprie squadre")
    public void testGestioneScambioSquadre() {
        Squadra s1 = new Squadra("Squadra1");
        Squadra s2 = new Squadra("Squadra2");
        Calciatore c1 = new Calciatore(1,"Nome1","Cognome1",24,"Squadra1");
        Calciatore c2 = new Calciatore(2,"Nome2","Cognome2",24,"Squadra2");
        Calciatore c3 = new Calciatore(3,"Nome3","Cognome3",24,"Squadra3");
        Calciatore c4 = new Calciatore(4,"Nome4","Cognome4",24,"Squadra4");
        Calciatore c5 = new Calciatore(5,"Nome5","Cognome5",24,"Squadra5");
        Calciatore c6 = new Calciatore(6,"Nome6","Cognome6",24,"Squadra6");
        ElencoCalciatori.getInstance().addCalciatore(c1);
        ElencoCalciatori.getInstance().addCalciatore(c2);
        ElencoCalciatori.getInstance().addCalciatore(c3);
        ElencoCalciatori.getInstance().addCalciatore(c4);
        ElencoCalciatori.getInstance().addCalciatore(c5);
        ElencoCalciatori.getInstance().addCalciatore(c6);
        s1.addCalciatore(c1);
        s1.addCalciatore(c2);
        s1.addCalciatore(c3);
        s2.addCalciatore(c4);
        s2.addCalciatore(c5);
        s2.addCalciatore(c6);

        GestoreScambio.gestioneScambio(c1,s1,c6,s2);

        assertEquals(s1.getFormazione().size(),3);
        assertEquals(s2.getFormazione().size(),3);
        assertNull(s1.getCalciatore(c1.getId()));
        assertNull(s2.getCalciatore(c6.getId()));
        assertEquals(s1.getCalciatore(c6.getId()),c6);
        assertEquals(s2.getCalciatore(c1.getId()),c1);
    }
    @DisplayName("Test sostituzione calciatore con uno svincolato")
    public void testGestioneScambioSvincolati(){
        Squadra s1 = new Squadra("Squadra1");
        Calciatore c1 = new Calciatore(1,"Nome1","Cognome1",24,"Squadra1");
        Calciatore c2 = new Calciatore(2,"Nome2","Cognome2",24,"Squadra2");
        Calciatore c3 = new Calciatore(3,"Nome3","Cognome3",24,"Squadra3");
        Calciatore c4 = new Calciatore(4,"Nome4","Cognome4",24,"Squadra4");
        ElencoCalciatori.getInstance().addCalciatore(c1);
        ElencoCalciatori.getInstance().addCalciatore(c2);
        ElencoCalciatori.getInstance().addCalciatore(c3);
        ElencoCalciatori.getInstance().addCalciatore(c4);
        s1.addCalciatore(c1);
        s1.addCalciatore(c2);
        s1.addCalciatore(c3);

        GestoreScambio.gestioneScambio(c1,s1,c4,null);

        assertEquals(s1.getFormazione().size(),3);
        assertEquals(s1.getCalciatore(c4.getId()),c4);
        assertFalse(c4.getSvincolato());
        assertTrue(c1.getSvincolato());
    }
}