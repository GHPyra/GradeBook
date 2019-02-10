package Szkolna;

public class Ocena {
    private int waga;
    private int ocn;

    public Ocena(int waga, int ocn) {
        try {
            if(ocn > 0 && ocn <= 5) {
                this.waga = waga;
                this.ocn = ocn;
            }
        }catch (Exception e) {

        }
    }

    @Override
    public String toString() {
        return "{" +
                "waga=" + waga +
                ", ocn=" + ocn +
                '}';
    }

    public int getWaga() {
        return waga;
    }

    public int getOcn() {
        return ocn;
    }

    public void setOcn(char ocn) {
        this.ocn = ocn;
    }

    public void setWaga(char waga) {
        this.waga = waga;
    }
}
