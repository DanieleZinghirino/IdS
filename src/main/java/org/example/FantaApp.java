package org.example;
import java.util.*;
public class FantaApp {

    ////////////////////////    ATTRIBUTI   ////////////////////////
    private static FantaApp instance;
    private ArrayList<Giocatore> listaGiocatori;
    private ElencoCalciatori elencoCalciatori;
    private Campionato campionato;

    ////////////////////////    COSTRUTTORE     ////////////////////////
    FantaApp(){
        listaGiocatori = new ArrayList<>();
        elencoCalciatori = ElencoCalciatori.getInstance();
        campionato = new Campionato();
    }

    ////////////////////////    METODO SINGLETON    ////////////////////////
    public static synchronized FantaApp getInstance() {
        if (instance == null) {
            instance = new FantaApp();
        }
        return instance;
    }

    ////////////////////////    METODI      ////////////////////////
    void aggiungiCalciatore(int id, String nome, String cognome, int eta, String squadra){
        Calciatore c = new Calciatore(id, nome, cognome, eta, squadra);
        elencoCalciatori.addCalciatore(c);
    }
    void addGiocatore(Giocatore g){
        listaGiocatori.add(g);
    }
    void aggiungiGiocatore(String cf, String nome, String cognome){
        Giocatore g = new Giocatore(cf, nome, cognome);
        addGiocatore(g);
    }
    boolean checkRidondanzaGiocatore(String cf){
        for(Giocatore g : listaGiocatori)
            if(g.getCf().equals(cf)){
                System.out.println("\n***Codice fiscale già registrato nel sistema! Inserisci un codice valido.***\n");
                return false;
            }
        return true;
    } //METODO DI CONTROLLO RIDONDANZA CF
    Giocatore getGiocatore(String cf){
        for(Giocatore g : listaGiocatori)
            if(g.getCf().equals(cf))
                return g;
        return null;
    }
    void creaSquadra(String nome, String cf){
        Giocatore g = getGiocatore(cf);
        System.out.println(g.toString());
        if(g!=null) campionato.addSquadra(g.creaSquadra(nome));
    }
    void aggiornaFormazione(int id, String cf){
        Calciatore c = elencoCalciatori.getCalciatore(id);
        Giocatore g = getGiocatore(cf);
        g.aggiornaFormazione(c);
        c.setSvincolato(false);
    }
    ElencoCalciatori getElencoCalciatori(){
        return this.elencoCalciatori;
    }
    Campionato getCampionato(){
        return campionato;
    }
    ArrayList<Giocatore> getListaGiocatori(){return listaGiocatori;} //MESSO SOLO PER TEST
    public int nuovaGiornata(){
        return campionato.creaGiornata();
    }
    public void aggiornaVoto(int idGiornata, Calciatore c, float votoBase, int gol, int assist, int autogol,
                             boolean ammonizione, boolean espulsione){
        campionato.aggiornaVoto(idGiornata, c, votoBase, gol, assist, autogol, ammonizione, espulsione);
    }
    public void gestioneScambio(int id1, String squadra1, int id2, String squadra2) {
        Calciatore c1 = elencoCalciatori.getCalciatore(id1);
        Calciatore c2 = elencoCalciatori.getCalciatore(id2);
        Squadra s1 = campionato.getSquadra(squadra1);
        Squadra s2 = campionato.getSquadra(squadra2);
        GestoreScambio.gestioneScambio(c1,s1,c2,s2);
    }
    public void aggiornaClassifica(){
        campionato.aggiornaClassifica();
    }
    public void aggiornaPunteggio(){
        campionato.aggiornaPunteggio();
    }
}
