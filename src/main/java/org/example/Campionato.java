package org.example;

import java.util.ArrayList;

public class Campionato {
    ////////////////////////    ATTRIBUTI   ////////////////////////
    private ArrayList<Giornata> elencoGiornate;
    private ArrayList<Squadra> elencoSquadre;
    private Classifica classifica;
    ////////////////////////    COSTRUTTORE   ////////////////////////

    public Campionato(){
        elencoGiornate = new ArrayList<>();
        elencoSquadre = new ArrayList<>();
        classifica = new Classifica();
    }

    ////////////////////////    METODI   ////////////////////////
    public int creaGiornata(){
        int id = elencoGiornate.size();
        Giornata g = new Giornata(id);
        elencoGiornate.add(g);
        return id;
    }
    public Giornata getGiornata(int id){
        for(Giornata g : elencoGiornate)
            if(g.getId() == id)
                return g;
        return null;
    }
    public void aggiornaVoto(int idGiornata, Calciatore c, float votoBase, int gol, int assist, int autogol,
                             boolean ammonizione, boolean espulsione){
        Bonus b = new Bonus(gol, assist, autogol, ammonizione, espulsione);
        Voto v = new Voto(votoBase, b);
        Giornata g = getGiornata(idGiornata);
        g.aggiungiVoto(c,v);
    }
    public void aggiornaPunteggio(){
        for(Squadra s : elencoSquadre)
            s.aggiornaPunteggio();
    }
    public Squadra getSquadra(String nome){
        for(Squadra s : elencoSquadre)
            if(s.getNome().equals(nome))
                return s;
        return null;
    }
    public void addSquadra(Squadra s){
        elencoSquadre.add(s);
        classifica.addSquadra(s);
    }
    public void aggiornaClassifica(){
        classifica.aggiornaClassifica();
    }
    public boolean checkRidondanzaSquadra(String nomeSquadra){
        if(getSquadra(nomeSquadra)!=null){
            System.out.println("\n***Il nome scelto è già presente nel campionato! Inserisci un nome valido.***\n");
            return false;
        }
        return true;
    } //METODO PER VERIFICARE RIDONDANZA NOMI SQUADRE
    public boolean checkPresenzaSquadra(String nomeSquadra){
        if(getSquadra(nomeSquadra) != null)
            return true;
        System.out.println("\n***La squadra " + nomeSquadra + " non esiste!***\n");
        return false;
    } //METODO PER VERIFICARE PRESENZA SQUADRA IN CAMPIONATO
    public boolean checkCalciatoreInSquadra(String nomeSquadra, int id){
        Squadra s = getSquadra(nomeSquadra);
        if(s.getNome().equals(nomeSquadra))
            for(Calciatore c : s.getFormazione())
                if(c.getId() == id)
                    return true;
        System.out.println("\n***Il calciatore non è presente nella squadra " + nomeSquadra + "! Inserisci un nuovo id.***\n");
        return false;
    } //METODO PER VERIFICARE CALCIATORE IN SQUADRA
    public boolean checkPresenzaGiornata(){
        if(elencoGiornate.size() > 0)
            return true;
        System.out.println("\n***Non è presente alcun voto nel sistema! Inserisci prima una nuova giornata.***\n");
        return false;
    } //METODO PER VERIFICARE CHE SIA STATA INSERITA ALMENO UNA GIORNATA NEL SISTEMA
}
