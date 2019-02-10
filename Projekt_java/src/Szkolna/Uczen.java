package Szkolna;

import Szkolna.Przedmiot;

import java.util.ArrayList;


public class Uczen {

    private String imie;
    private String nazwisko;
    private int nr_dziennika;
    private ArrayList<Przedmiot> przedmiots;

    public Uczen(String imie, String nazwisko, int nr_dziennika, ArrayList<Przedmiot> przdmt) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nr_dziennika = nr_dziennika;
        this.przedmiots = new ArrayList<Przedmiot>();
        for(int i  = 0 ; i < przdmt.size(); i++){
            String s = przdmt.get(i).getName();
            int id = przdmt.get(i).getId();
            Przedmiot nw = new Przedmiot(s, id);
            przedmiots.add(nw);
        }
    }

    public Uczen(String imie, String nazwisko, int nr_dziennika) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nr_dziennika = nr_dziennika;
        this.przedmiots = new ArrayList<Przedmiot>();
    }

    public void dodaj_ocene(int przed, int waga, int ocena){
        przedmiots.get(przed).dodaj_ocene(waga,ocena);
    }

    public Przedmiot getPrzedmiot(int p_idx){
        return przedmiots.get(p_idx);
    }

    @Override
    public String toString() {
        return "Szkolna.Uczen{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", nr_dziennika=" + nr_dziennika +
                '}';
    }

    public ArrayList<Przedmiot> getPrzedmiots() {
        return przedmiots;
    }

    public String getNazwisko() {
        return nr_dziennika+1+". "+nazwisko;
    }

    public String getNazw(){
        return  nazwisko;
    }
    public String getImie(){
        return imie;
    }
}

//ZROB TO SAMO TYLKO BEZ PRZEDMIOTOW ABSTRAKCYJNYCH