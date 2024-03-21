package org.example;
import java.util.*;
public class Squadra {
    ////////////////////////    ATTRIBUTI   ////////////////////////
    private String nome;
    private float punteggio;
    private ArrayList<Calciatore> formazione;

    ////////////////////////    COSTRUTTORE   ////////////////////////
    Squadra(String nome){
        this.nome = nome;
        this.punteggio = 0.0F;
        this.formazione = new ArrayList<>();
    }

    ////////////////////////    METODI   ////////////////////////

    public String getNome() {
        return this.nome;
    }
    public float getPunteggio(){
        return this.punteggio;
    }
    public void aggiornaPunteggio(){
        for(Calciatore c : formazione)
            this.punteggio += c.getUltimoVoto().getTotale();
    }
    void addCalciatore(Calciatore c){
        this.formazione.add(c);
    }
    ArrayList<Calciatore> getFormazione(){
        return this.formazione;
    }
    void removeCalciatore(Calciatore c){this.formazione.remove(c);}
    void stampa(){
        System.out.println(this.nome + " = " + this.punteggio);
    }

    Calciatore getCalciatore(int id){
        for(Calciatore c : formazione)
            if(c.getId() == id)
                return c;
        return null;
    } //METODO INSERITO SOLO PER TEST
}
