package org.example;
import java.util.*;

public class ElencoCalciatori {

    ////////////////////////    ATTRIBUTI   ////////////////////////
    private static ElencoCalciatori instance;
    private ArrayList<Calciatore> listaCalciatori;

    ////////////////////////    COSTRUTTORE     ////////////////////////
    ElencoCalciatori(){
        listaCalciatori = new ArrayList<>();
    }

    ////////////////////////    METODO SINGLETON    ////////////////////////
    public static synchronized ElencoCalciatori getInstance() {
        if (instance == null) {
            instance = new ElencoCalciatori();
        }
        return instance;
    }
    ////////////////////////    METODI     ////////////////////////
    void addCalciatore(Calciatore c){
        listaCalciatori.add(c);
    }
    Calciatore getCalciatore(int id){
        for(Calciatore c : listaCalciatori)
            if(c.getId() == id) return c;
        return null;
    }
    void mostraSvincolati(){
        System.out.println("\nLista dei calciatori svincolati:\n");
        for(Calciatore c : listaCalciatori)
            if(c.getSvincolato()) c.stampa();
        System.out.println();
    }
    boolean checkCalciatoreSvincolato(int id){
        for(Calciatore c : listaCalciatori)
            if(c.getId() == id && c.getSvincolato())
                return true;
        System.out.println("\n***ID non valido, inserisci un altro codice!***\n");
        return false;
    } //METODO DI CONTROLLO RIDONDANZA ID
    boolean checkNumeroCalciatoriSvincolati(){
        int contatore = 0;
        for(Calciatore c : listaCalciatori)
            if(c.getSvincolato()) contatore ++;
        if(contatore < 3){
            System.out.println("\n***Numero insufficiente di calciatori svincolati! Inserisci nuovi calciatori nel sistema.***\n");
            return false;
        }
        return true;
    } //METODO DI CONTROLLO NUMERO SVINCOLATI SUFFICIENTE PER NUOVO PARTECIPANTE
    int dimensioneElenco(){
        return listaCalciatori.size();
    }
    ArrayList<Calciatore> getListaCalciatori(){
        return listaCalciatori;
    }
}
