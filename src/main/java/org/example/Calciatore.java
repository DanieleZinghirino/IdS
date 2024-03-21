package org.example;

public class Calciatore {
    ////////////////////////    ATTRIBUTI   ////////////////////////
    private int id;
    private String nome;
    private String cognome;
    private int eta;
    private String squadra;
    private Voto ultimoVoto;
    private boolean svincolato;

    ////////////////////////    COSTRUTTORE     ////////////////////////
    public Calciatore(int id, String nome, String cognome, int eta, String squadra){
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.squadra = squadra;
        this.ultimoVoto = null;
        this.svincolato = true;
    }

    ////////////////////////    METODI      ////////////////////////
    int getId(){
        return this.id;
    }
    public String getNome() {
        return nome;
    }
    public String getCognome() {
        return cognome;
    }
    public Voto getUltimoVoto() {
        return ultimoVoto;
    }
    boolean getSvincolato(){
        return this.svincolato;
    }
    void setSvincolato(boolean svincolato){
        this.svincolato = svincolato;
    }
    public void setUltimoVoto(Voto ultimoVoto) {
        this.ultimoVoto = ultimoVoto;
    }
    String votoToString(){
        String risultato = "0";
        if(this.ultimoVoto != null)
            risultato = this.ultimoVoto.toString();
        return  risultato;
    }
    @Override
    public String toString() {
        return "Calciatore: " +
                "id = " + id +
                ", " + nome + '\'' +
                " " + cognome + '\'' +
                ", " + eta +
                " anni, squadra = '" + squadra + '\'' +
                ", ultimo voto = " + votoToString() +
                ", svincolato = " + svincolato +
                '}';
    }
    void stampa(){
        System.out.println(this);
    }
}
