import Szkolna.Klasa;

import javax.swing.*;
import java.util.ArrayList;

public class ListaKlasModel extends AbstractListModel {
    private ArrayList<Klasa> klasy;

    public ListaKlasModel(ArrayList<Klasa> klasas){
        this.klasy = klasas;
    }


    @Override
    public int getSize() {
        return klasy.size();
    }

    @Override
    public Object getElementAt(int index) {
        Object value = null;
        value = klasy.get(index).getClass_name();
        return value;
    }

}
