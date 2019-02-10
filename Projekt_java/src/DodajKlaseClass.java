import Szkolna.Klasa;
import Szkolna.Przedmiot;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DodajKlaseClass extends JFrame {
    private JButton zatwierdzButton;
    private JTextField nazwaKlasyTextField;
    private JList listaprzedmiotow;
    private JList listauczniow;
    private JTextField uczentextField1;
    private JButton dodajUczniaButton;
    private JPanel panel1;
    private JButton usunUczniaButton;

    private ArrayList<Przedmiot> listapval;

    String nazw_klsy;
    String nazw_uczn;
    DodajKlaseClass(ArrayList<Klasa> param){
        setSize(300,700);
        add(panel1);
        listapval = getListaprzedmiotow();
        Klasa nw = new Klasa(param.size() ,nazw_klsy);
        for(int i = 0 ; i < listapval.size(); i++){
            nw.dodaj_przedmiot2(listapval.get(i));
        }
        DefaultListModel dlm = new DefaultListModel();
        listauczniow.setModel(dlm);
        zatwierdzButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nazw_klsy = nazwaKlasyTextField.getText().trim();
                nw.setClass_name(nazw_klsy);
                param.add(param.size(),nw);
                CSVKlasy csv = new CSVKlasy();
                csv.tworz_plik(param);
            }
        });
        dodajUczniaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nazw_uczn = uczentextField1.getText();
                String [] str;
                str = nazw_uczn.split(" ");
                nw.dodaj_ucznia(str[0],str[1],nw.getUczens().size());
                dlm.addElement(str[0]+" "+str[1]);

            }
        });
        usunUczniaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(nw.getUczens().size()>0){
                    dlm.remove(nw.getUczens().size()-1);
                    nw.usun_ucznia();
                }
            }
        });
    }

    public ArrayList<Przedmiot> getListaprzedmiotow() {
        ArrayList<Przedmiot> temp;
        temp = new ArrayList<Przedmiot>();

        ListModel model = listaprzedmiotow.getModel();
        for(int i=0; i < model.getSize(); i++){
            Object o =  model.getElementAt(i);
            Przedmiot nw = new Przedmiot(o.toString(),i);
            temp.add(i,nw);
        }
        return temp;
    }
}
