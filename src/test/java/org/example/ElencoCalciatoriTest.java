package org.example;

import junit.framework.TestCase;
import org.junit.jupiter.api.DisplayName;

public class ElencoCalciatoriTest extends TestCase {
    @DisplayName("Test controllo status di 'svincolato' di un calciatore")
    public void testCheckCalciatoreSvincolato() {
        Calciatore c0 = new Calciatore(0, "Nome0", "Cognome0", 24, "Squadra0");
        Calciatore c1 = new Calciatore(1, "Nome1", "Cognome1", 24, "Squadra1");
        c1.setSvincolato(false);
        ElencoCalciatori.getInstance().addCalciatore(c0);
        ElencoCalciatori.getInstance().addCalciatore(c1);

        assertTrue(ElencoCalciatori.getInstance().checkCalciatoreSvincolato(0));
        assertFalse(ElencoCalciatori.getInstance().checkCalciatoreSvincolato(1));
    }
    @DisplayName("Test controllo numero minimo di calciatori svincolati per formare una nuova squadra")
    public void testCheckNumeroCalciatoriSvincolati() {
        Calciatore c0 = new Calciatore(0, "Nome0", "Cognome0", 24, "Squadra0");
        Calciatore c1 = new Calciatore(1, "Nome1", "Cognome1", 24, "Squadra1");
        Calciatore c2 = new Calciatore(2, "Nome2", "Cognome2", 24, "Squadra2");
        ElencoCalciatori.getInstance().addCalciatore(c0);
        ElencoCalciatori.getInstance().addCalciatore(c1);
        ElencoCalciatori.getInstance().addCalciatore(c2);
        assertTrue(ElencoCalciatori.getInstance().checkNumeroCalciatoriSvincolati());
        c1.setSvincolato(false);
        assertFalse(ElencoCalciatori.getInstance().checkNumeroCalciatoriSvincolati());
    }
    @DisplayName("Test numero di calciatori nell'elenco")
    public void testDimensioneElenco() {
        assertEquals(ElencoCalciatori.getInstance().dimensioneElenco(),0);
        Calciatore c0 = new Calciatore(0, "Nome0", "Cognome0", 24, "Squadra0");
        ElencoCalciatori.getInstance().addCalciatore(c0);
        assertEquals(ElencoCalciatori.getInstance().dimensioneElenco(),1);
    }
}