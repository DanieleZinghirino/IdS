package org.example;

import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

public class CalciatoreTest extends TestCase {
    Calciatore c;
    Voto v;
    Bonus b;
    @DisplayName("Test costruttore e metodi get")
    public void testCostruttoreEGet(){
        c = new Calciatore(0, "Calciatore0", "Cognome0", 24, "Squadra0");
        b = new Bonus(0,0,0,false,false);
        v = new Voto(6, b);

        assertEquals(0, c.getId());
        assertEquals("Calciatore0", c.getNome());
        assertEquals("Cognome0", c.getCognome());
        assertNull(c.getUltimoVoto());
        assertTrue(c.getSvincolato());
    }

    @DisplayName("Test metodi set")
    public void testSet(){
        Calciatore c1 = new Calciatore(1, "Calciatore1", "Cognome1", 24, "Squadra1");
        c1.setSvincolato(true);
        c1.setUltimoVoto(v);

        assertTrue(c1.getSvincolato());
        assertSame(c1.getUltimoVoto(), v);
    }
}