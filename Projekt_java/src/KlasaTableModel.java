import Szkolna.Klasa;
import Szkolna.Przedmiot;
import Szkolna.Uczen;
import Szkolna.Ocena;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class KlasaTableModel extends AbstractTableModel {

    private ArrayList<Przedmiot> przedmioty;
    private ArrayList<Uczen> uczniowie;

    public KlasaTableModel(Klasa a){
        this.przedmioty = a.getPrzedmiots();
        this.uczniowie = a.getUczens();
    }

    public String getColumnName(int col) {
        if(col == 0){
            return "Nazwisko Ucznia";
        }
        return przedmioty.get(col-1).getName();
    }

    @Override
    public int getRowCount() {
        return uczniowie.size();
    }

    @Override
    public int getColumnCount() {
        return przedmioty.size()+1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object value = null;
        if(columnIndex == 0){
            value = uczniowie.get(rowIndex).getNazwisko();
        }
        else {
            if(!uczniowie.get(rowIndex).getPrzedmiot(columnIndex - 1).getOcenas().isEmpty())
                value = uczniowie.get(rowIndex).getPrzedmiot(columnIndex - 1).ret_avg_ocenas();
            else
                value = "";
        }
        return value;
    }
}
