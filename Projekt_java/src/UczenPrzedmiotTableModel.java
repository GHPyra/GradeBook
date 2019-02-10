import Szkolna.Ocena;
import Szkolna.Uczen;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class UczenPrzedmiotTableModel extends AbstractTableModel {
    private ArrayList<Ocena> ocenas;

    UczenPrzedmiotTableModel(Uczen ths, int przedm){
        this.ocenas = ths.getPrzedmiot(przedm).getOcenas();
    }

    @Override
    public int getRowCount() {
        return 1;
    }

    @Override
    public int getColumnCount() {
        return ocenas.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return ocenas.get(columnIndex);
    }
}
