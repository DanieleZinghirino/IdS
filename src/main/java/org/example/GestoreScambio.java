package org.example;

public class GestoreScambio {
    ////////////////////////    METODI   ////////////////////////
    public static void gestioneScambio(Calciatore c1, Squadra s1, Calciatore c2, Squadra s2) {
        s1.removeCalciatore(c1);
        s1.addCalciatore(c2);
        if (s2 != null) {
            s2.removeCalciatore(c2);
            s2.addCalciatore(c1);
        } else {
            c1.setSvincolato(true);
            c2.setSvincolato(false);
        }
    }
}
