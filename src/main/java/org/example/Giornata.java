package org.example;

import java.util.HashMap;
import java.util.Map;

public class Giornata {
    ////////////////////////    ATTRIBUTI   ////////////////////////
    private int id;
    private Map<Calciatore, Voto> listaVoti;

    ////////////////////////    COSTRUTTORE   ////////////////////////
    public Giornata(int id){
        this.id = id;
        this.listaVoti = new HashMap<>();
    }

    ////////////////////////    METODI   ////////////////////////
    public int getId() {
        return id;
    }
    public void aggiungiVoto(Calciatore c, Voto v){
        this.listaVoti.put(c, v);
        c.setUltimoVoto(v);
    }
}
