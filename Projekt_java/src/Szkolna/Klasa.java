package Szkolna;

import java.util.ArrayList;


public class Klasa {
    private int class_id;
    private String class_name;
    private ArrayList<Uczen> uczens;
    private ArrayList<Przedmiot> przedmiots;

    public ArrayList<Przedmiot> getPrzedmiots() {
        return przedmiots;
    }

    public String getClass_name() {
        return class_name;
    }

    public ArrayList<Uczen> getUczens() {
        return uczens;
    }
    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }
    public Klasa(int class_id, String class_name) {
        this.class_id = class_id;
        this.class_name = class_name;
        this.uczens = new ArrayList<Uczen>();
        this.przedmiots = new ArrayList<Przedmiot>();
    }

    public void  dodaj_ucznia(String imie, String nazwisko, int numer){
        Uczen a = new Uczen(imie,nazwisko,numer, przedmiots);
        uczens.add(a);
    }

    public void usun_ucznia(){
        uczens.remove(uczens.size()-1);
    }
    public void pobierz_ucznia(int indx){
        System.out.println( uczens.get(indx));
    }

    public void dodaj_ocene(int nr_dz,int przed, int waga, int ocena){
        uczens.get(nr_dz).dodaj_ocene(przed, waga, ocena );
    }


    public void dodaj_przedmiot(String nazwa, int id){
        Przedmiot nw = new Przedmiot(nazwa, id);
        przedmiots.add(nw);
    }
    public void dodaj_przedmiot2(Przedmiot prz){
        Przedmiot nw = new Przedmiot(prz);
        przedmiots.add(nw);
    }



    int ret_przedmiot_count(){
        return przedmiots.size();
    }




    public void getUczensOcena(int ucn, int przdmt){
        uczens.get(ucn).getPrzedmiot(przdmt).poka_poka_oceny();
    }
}
