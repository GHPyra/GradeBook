import Szkolna.Klasa;

import javax.swing.*;
import java.util.ArrayList;

public class Main {



    public static void main(String[] args) {
        ArrayList<Klasa> klasas;
        klasas = new ArrayList<Klasa>();
        CSVKlasy csv = new CSVKlasy();
        klasas = csv.czytaj_plik();
        MainGui mainGui = new MainGui(klasas);
        mainGui.setVisible(true);
        mainGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);







    }
}
