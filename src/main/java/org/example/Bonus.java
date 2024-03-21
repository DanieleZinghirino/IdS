package org.example;

public class Bonus {
    ////////////////////////    ATTRIBUTI   ////////////////////////
    private int gol;
    private int assist;
    private int autogol;
    private boolean ammonizione;
    private boolean espulsione;

    ////////////////////////    COSTRUTTORE   ////////////////////////

    public Bonus(int gol, int assist, int autogol, boolean ammonizione, boolean espulsione){
        this.gol = gol;
        this.assist = assist;
        this.autogol = autogol;
        this.ammonizione = ammonizione;
        this.espulsione = espulsione;
    }

    ////////////////////////    METODI   ////////////////////////

    public int getGol() {
        return gol;
    }

    public int getAssist() {
        return assist;
    }

    public int getAutogol() {
        return autogol;
    }

    public boolean getAmmonizione() {
        return ammonizione;
    }

    public boolean getEspulsione() {
        return espulsione;
    }
}
