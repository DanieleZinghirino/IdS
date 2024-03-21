package org.example;

public class Giocatore {

    ////////////////////////    ATTRIBUTI   ////////////////////////
    private String nome;
    private String cognome;
    private String cf;
    private Squadra squadra;

    ////////////////////////    COSTRUTTORE     ////////////////////////
    Giocatore(String cf, String nome, String cognome){
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
    }

    ////////////////////////    METODI      ////////////////////////
    String getCf(){
        return this.cf;
    }
    void setSquadra(Squadra s){
        this.squadra = s;
    }
    Squadra creaSquadra(String nome){
        Squadra s = new Squadra(nome);
        this.setSquadra(s);
        return s;
    }
    void aggiornaFormazione(Calciatore c){
        this.squadra.addCalciatore(c);
    }
    Squadra getSquadra(){
        return this.squadra;
    }
}
