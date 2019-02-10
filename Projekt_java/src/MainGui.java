import Szkolna.Klasa;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;
import java.util.ArrayList;


public class MainGui extends JFrame {
    private JList list1;
    private JButton dodajKlase;
    private JPanel rootPanel;
    private JTextField nazwaKlasy;
    private JTable table1;
    private JButton pokazOcenyButton;
    private JButton wsteczButton;
    private JButton dodaj_ocene_button;
    private JTextField wagaField;
    private JTextField ocenaField;
    private JButton zapiszButton;
    private KlasaTableModel tableModel;
    private UczenPrzedmiotTableModel uczenTableMdl;

    private ListaKlasModel listaModel;
    private Klasa to_disp_klasa;
    private int selectedKlasa = 0;

    int column;
    int row;

    public MainGui(ArrayList<Klasa> paramklasa){

        this.to_disp_klasa = paramklasa.get(0);

        setTitle("Lista Klas");
        setSize(1000,800);
        add(rootPanel);
        tableModel = new KlasaTableModel(to_disp_klasa);
        listaModel = new ListaKlasModel(paramklasa);
        list1.setModel(listaModel);
        dodajKlase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DodajKlaseClass windw = new DodajKlaseClass(paramklasa);
                windw.setVisible(true);
                windw.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
        list1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                selectedKlasa = list1.getSelectedIndex();
                to_disp_klasa = paramklasa.get(selectedKlasa);
                tableModel = new KlasaTableModel(to_disp_klasa);
            }
        });
        pokazOcenyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table1.setModel(tableModel);
            }
        });
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                column = table1.getSelectedColumn();
                row = table1.getSelectedRow();
                if(column!=0) {
                    uczenTableMdl = new UczenPrzedmiotTableModel(paramklasa.get(selectedKlasa).getUczens().get(row), column - 1);
                    table1.setModel(uczenTableMdl);
                }

                super.mouseClicked(e);
            }
        });
        wsteczButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table1.setModel(tableModel);
            }
        });
        dodaj_ocene_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = Integer.parseInt(wagaField.getText());
                int y = Integer.parseInt(ocenaField.getText());
                int z = list1.getSelectedIndex();
                //System.out.println(z);
                if(x>0 && x < 5 && y >0 && y < 7)
                paramklasa.get(z).getUczens().get(row).getPrzedmiot(column-1)
                       .dodaj_ocene(x,y);
            }
        });
        zapiszButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CSVKlasy csv = new CSVKlasy();
                csv.tworz_plik(paramklasa);
            }
        });
    }





}