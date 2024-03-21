package org.example;

public class Voto {
    ////////////////////////    ATTRIBUTI   ////////////////////////
    private float votoBase;
    private Bonus bonus;
    private float totale;

    ////////////////////////    COSTRUTTORE   ////////////////////////
    public Voto(float votoBase, Bonus bonus){
        this.votoBase = votoBase;
        this.bonus = bonus;
        float ammonizione = 0;
        int espulsione = 0;
        if(bonus.getAmmonizione()) ammonizione = 0.5F;
        if(bonus.getEspulsione()) espulsione = 1;
        float bonusGol = (float)(bonus.getGol()*3);
        float bonusAssist = (float)(bonus.getAssist());
        float malusAutogol = (float)(bonus.getAutogol()*3);
        this.totale = votoBase + bonusGol + bonusAssist - malusAutogol - ammonizione - espulsione;
        System.out.println("Voto totale ---> " + this.totale);
    }

    ////////////////////////    METODI   ////////////////////////
    @Override
    public String toString(){
        return String.valueOf(this.totale);
    }

    public float getTotale() {
        return this.totale;
    }
}
