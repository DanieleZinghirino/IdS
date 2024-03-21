package org.example;

import junit.framework.TestCase;
import org.junit.jupiter.api.DisplayName;

public class GiornataTest extends TestCase {

    @DisplayName("Test del costruttore e dei metodi get")
    public void testCostruttoreEGet(){
        Giornata g = new Giornata(1);
        assertEquals(g.getId(),1);
    }
    @DisplayName("Test dell'inserimento di un voto per un calciatore")
    public void testAggiungiVoto() {
        Giornata g = new Giornata(1);
        Calciatore c = new Calciatore(1,"Nome1", "Cognome1", 24, "Squadra1");
        Bonus b1 = new Bonus(0,0,0,false,false);
        Voto v1 = new Voto(6,b1);
        g.aggiungiVoto(c,v1);
        assertEquals(c.getUltimoVoto().getTotale(),6.0F);

        Bonus b2 = new Bonus(1,0,0,false,false);
        Voto v2 = new Voto(7,b2);
        g.aggiungiVoto(c,v2);
        assertEquals(c.getUltimoVoto().getTotale(),10.0F);
    }
}