package org.example;
public class Avvio {
    ////////////////////////    METODI DI INIT   ////////////////////////
    public static void inizializzaCalciatori(FantaApp fantaApp){
        fantaApp.aggiungiCalciatore(1, "Lautaro", "Martinez", 26, "Inter");
        fantaApp.aggiungiCalciatore(2, "Olivier", "Giroud", 38, "Milan");
        fantaApp.aggiungiCalciatore(3, "Paulo", "Dybala", 30, "Roma");
        fantaApp.aggiungiCalciatore(4, "Romelu", "Lukaku", 30, "Roma");
        fantaApp.aggiungiCalciatore(5, "Ciro", "Immobile", 34, "Lazio");
        fantaApp.aggiungiCalciatore(6, "Dusan", "Vlahovic", 24, "Juventus");
        fantaApp.aggiungiCalciatore(7, "Rafael", "Leao", 24, "Milan");
        fantaApp.aggiungiCalciatore(8, "Victor", "Osimhen", 25, "Napoli");
        fantaApp.aggiungiCalciatore(9, "Gianluca", "Scamacca", 25, "Atalanta");
    }
    public static void inizializzaGiocatori(FantaApp fantaApp){
        //GIOCATORE 1
        fantaApp.aggiungiGiocatore("ZNGDNL", "Daniele", "Zinghirino");
        fantaApp.creaSquadra("SquadraD","ZNGDNL");
        fantaApp.aggiornaFormazione(1,"ZNGDNL");
        fantaApp.aggiornaFormazione(2,"ZNGDNL");
        fantaApp.aggiornaFormazione(4,"ZNGDNL");
        //GIOCATORE 2
        fantaApp.aggiungiGiocatore("RSSMRI", "Mario", "Rossi");
        fantaApp.creaSquadra("SquadraM","RSSMRI");
        fantaApp.aggiornaFormazione(6,"RSSMRI");
        fantaApp.aggiornaFormazione(7,"RSSMRI");
        fantaApp.aggiornaFormazione(9,"RSSMRI");
    }

    ////////////////////////    METODI CASI D'USO   ////////////////////////

    //UC1
    public static void inserimentoNuovoCalciatore(FantaApp fantaApp){
        int id = ElencoCalciatori.getInstance().dimensioneElenco() + 1; //ID AUTOINCR
        String nome = UI.leggiStringa("Inserisci il nome del calciatore ---> ");
        String cognome = UI.leggiStringa("Inserisci il cognome del calciatore ---> ");
        int eta = (int) UI.leggiNumero("Inserisci l'età del calciatore ---> ");
        String squadra = UI.leggiStringa("Inserisci la squadra di appartenenza del calciatore ---> ");
        fantaApp.aggiungiCalciatore(id, nome, cognome, eta, squadra);
    }
    //UC2
    public static void creazioneSquadra(FantaApp fantaApp){
        boolean isValid = false;
        String cf = "";
        String squadra = "";
        while(!isValid){
            cf = UI.leggiStringa("Inserisci il codice fiscale del nuovo partecipante ---> ");
            isValid = Validatore.checkRidondanzaGiocatore(cf);
        }
        String nome = UI.leggiStringa("Inserisci il nome del nuovo partecipante ---> ");
        String cognome = UI.leggiStringa("Inserisci il cognome del nuovo partecipante ---> ");
        fantaApp.aggiungiGiocatore(cf, nome, cognome);
        isValid = false;
        while (!isValid){
        squadra = UI.leggiStringa("Inserisci il nome della nuova squadra da creare ---> ");
        isValid = Validatore.checkRidondanzaSquadra(squadra);
        }
        fantaApp.creaSquadra(squadra, cf);
        int id;
        for(int i = 0; i < 3; i++){
            fantaApp.getElencoCalciatori().mostraSvincolati();
            id = (int) UI.leggiNumero("Inserisci l'id del calciatore da inserire nella squadra ---> ");
            isValid = Validatore.checkCalciatoreSvincolato(id);
            if(!isValid) i--;
            else fantaApp.aggiornaFormazione(id, cf);
        }
    }
    //UC3
    public static void gestioneGiornata(FantaApp fantaApp){
        int id = fantaApp.nuovaGiornata();
        for(Calciatore c : ElencoCalciatori.getInstance().getListaCalciatori()){
            float votoBase = UI.leggiNumero("Inserisci il voto del calciatore "
                    + c.getNome() + " " + c.getCognome() + " ---> ", 0);
            int gol = (int) UI.leggiNumero("Inserire numero di gol segnati dal calciatore ---> ", 0);
            int assist = (int) UI.leggiNumero("Inserire numero di assist effettuati dal calciatore ---> ", 0);
            int autogol = (int) UI.leggiNumero("Inserire numero di autogol commessi dal calciatore ---> ",0);
            int ammonizione = (int) UI.leggiNumero("Inserire il valore 1 se il giocatore è stato ammonito ---> ");
            int espulsione = (int) UI.leggiNumero("Inserire il valore 1 se il giocatore è stato espulso ---> ");
            boolean amm = false;
            boolean esp = false;
            if(ammonizione == 1) amm = true;
            if(espulsione == 1) esp = true;
            fantaApp.aggiornaVoto(id, c, votoBase, gol, assist, autogol, amm, esp);
        }
        fantaApp.aggiornaPunteggio();
    }
    //UC4
    public static void sostituzioneCalciatori(FantaApp fantaApp){
        int scelta = (int)UI.leggiNumero("Digita '0' se vuoi scambiare due calciatori tra due squadre, digita '1' " +
                "se vuoi sostituire il calciatore di una squadra con un calciatore svincolato ---> ", 0, 1);
        String nome2 = null;
        int id1 = 0;
        int id2 = 0;
        String nome1 = "";
        boolean isValid = false;
        while(!isValid){
            nome1 = UI.leggiStringa("Inserisci il nome della squadra che vuole scambiare un calciatore ---> ");
            isValid = Validatore.checkPresenzaSquadra(nome1);
        }
        isValid = false;
        while(!isValid){
            id1 = (int)UI.leggiNumero("Inserisci l'id del calciatore da sostituire ---> ");
            isValid = Validatore.checkCalciatoreInSquadra(nome1, id1);
        }
        isValid = false;
        if(scelta == 0){
            while(!isValid){
                nome2 = UI.leggiStringa("Inserisci il nome dell'altra squadra che vuole scambiare un calciatore ---> ");
                isValid = Validatore.checkPresenzaSquadra(nome2);
            }
            isValid = false;
            while(!isValid){
            id2 = (int)UI.leggiNumero("Inserisci l'id dell'altro calciatore da sostituire ---> ");
            isValid = Validatore.checkCalciatoreInSquadra(nome2, id2);
            }
        }
        else{
            fantaApp.getElencoCalciatori().mostraSvincolati();
            while(!isValid){
                id2 = (int)UI.leggiNumero("Inserisci l'id del calciatore svincolato desiderato ---> ");
                isValid = Validatore.checkCalciatoreSvincolato(id2);
            }
        }
        fantaApp.gestioneScambio(id1, nome1, id2, nome2);
    }
    //UC5
    public static void visualizzazioneClassifica(FantaApp fantaApp){
        fantaApp.aggiornaClassifica();
    }

    ////////////////////////    STAMPA MENU    ////////////////////////
    public static void menu(FantaApp fantaApp) {
        System.out.println("\n--------    MENU    -------");
        System.out.println("1)Inserimento calciatore");
        System.out.println("2)Inserimento nuovo partecipante");
        System.out.println("3)Visualizzazione lista svincolati");
        System.out.println("4)Visualizzazione lista squadre");
        System.out.println("5)Inserimento nuova giornata");
        System.out.println("6)Visualizzazione statistiche calciatori");
        System.out.println("7)Sostituzione calciatori");
        System.out.println("8)Visualizzazione classifica");
        System.out.println("0)Esci");
        int n = (int) UI.leggiNumero("Inserisci la tua opzione ----> ", 0, 8);
        System.out.println();
        switch (n){
            case 1:
                inserimentoNuovoCalciatore(fantaApp);
                break;
            case 2:
                if(Validatore.checkNumeroCalciatoriSvincolati())
                    creazioneSquadra(fantaApp);
                break;
            case 3:
                fantaApp.getElencoCalciatori().mostraSvincolati();
                break;
            case 4:
                for(Giocatore g : fantaApp.getListaGiocatori()){
                    System.out.println("Codice fiscale: " + g.getCf());
                    System.out.println("Nome squadra: " +g.getSquadra().getNome());
                    System.out.println("Formazione:");
                    for(Calciatore c : g.getSquadra().getFormazione())
                        c.stampa();
                    System.out.println("---------------");
                }
                break;
            case 5:
                gestioneGiornata(fantaApp);
                break;
            case 6:
                for(Calciatore c : ElencoCalciatori.getInstance().getListaCalciatori())
                    c.stampa();
                break;
            case 7:
                sostituzioneCalciatori(fantaApp);
                break;
            case 8:
                if(Validatore.checkPresenzaGiornata())
                    visualizzazioneClassifica(fantaApp);
                break;
            case 0:
                System.exit(0);
        }
    }

    ////////////////////////    MAIN    ////////////////////////
    public static void main(String[] args) {
        FantaApp fantaApp = FantaApp.getInstance();
        inizializzaCalciatori(fantaApp);
        inizializzaGiocatori(fantaApp);
        while(true){
            menu(fantaApp);
        }
    }
}