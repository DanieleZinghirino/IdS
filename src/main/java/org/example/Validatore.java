package org.example;

public class Validatore {
    public static boolean checkRidondanzaGiocatore(String cf){
        return FantaApp.getInstance().checkRidondanzaGiocatore(cf);
    }
    public static boolean checkCalciatoreSvincolato(int id){
        return ElencoCalciatori.getInstance().checkCalciatoreSvincolato(id);
    }
    public static boolean checkRidondanzaSquadra(String nomeSquadra){
        return FantaApp.getInstance().getCampionato().checkRidondanzaSquadra(nomeSquadra);
    }
    public static boolean checkNumeroCalciatoriSvincolati(){
        return ElencoCalciatori.getInstance().checkNumeroCalciatoriSvincolati();
    }
    public static boolean checkPresenzaSquadra(String nomeSquadra){
        return FantaApp.getInstance().getCampionato().checkPresenzaSquadra(nomeSquadra);
    }
    public static boolean checkCalciatoreInSquadra(String nomeSquadra, int id){
        return FantaApp.getInstance().getCampionato().checkCalciatoreInSquadra(nomeSquadra, id);
    }
    public static boolean checkPresenzaGiornata(){
        return FantaApp.getInstance().getCampionato().checkPresenzaGiornata();
    }
}
