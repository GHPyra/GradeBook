package Szkolna;

import java.util.ArrayList;

public class Przedmiot {
    String name;
    int id;
    ArrayList<Ocena> ocenas;

    public ArrayList<Ocena> getOcenas() {
        return ocenas;
    }

    public Przedmiot(String name, int id) {
        this.name = name;
        this.id = id;
        ocenas = new ArrayList<Ocena>();
    }

    public Przedmiot(Przedmiot cpy){
        this.id = cpy.getId();
        this.name = cpy.getName();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void dodaj_ocene(int waga, int ocena){
        Ocena nw = new Ocena(waga,ocena);
        ocenas.add(nw);
    }


    public void poka_poka_oceny(){
        for(int i = 0 ; i < ocenas.size(); i ++){
            System.out.print(ocenas.get(i)+" ");
        }
    }

    public float ret_avg_ocenas(){
        float temp = 0;
        for(int i = 0 ; i < ocenas.size() ; i++){
            temp += (ocenas.get(i).getOcn());
        }
        return temp = temp / ocenas.size();
    }



}
