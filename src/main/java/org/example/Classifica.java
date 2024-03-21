package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Classifica {
    ////////////////////////    ATTRIBUTI   ////////////////////////
    private ArrayList<Squadra> elencoSquadre;

    ////////////////////////    COSTRUTTORE   ////////////////////////
    Classifica(){
        elencoSquadre = new ArrayList<>();
    }

    ////////////////////////    METODI   ////////////////////////
    void aggiornaClassifica(){
        Collections.sort(elencoSquadre, Comparator.comparing(Squadra::getPunteggio).reversed());
        for(int i = 1; i<elencoSquadre.size() + 1; i++){
            System.out.print(i + ") ");
            elencoSquadre.get(i-1).stampa();
        }
    }
    void addSquadra(Squadra s){
        elencoSquadre.add(s);
    }
}
