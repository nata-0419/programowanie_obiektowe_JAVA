public class Dzban {
    private int Id;
    private String nazwa;
    private String opis;
    private int pojemnosc;
    private int wysokosc;

    public Dzban(String nazwa, String opis, int pojemnosc, int wysokosc) {
        this.nazwa = nazwa;
        this.opis = opis;
        this.pojemnosc = pojemnosc;
        this.wysokosc = wysokosc;
    }

    public Dzban(int Id, String nazwa, String opis, int pojemnosc, int wysokosc) {
        this.Id = Id;
        this.nazwa = nazwa;
        this.opis = opis;
        this.pojemnosc = pojemnosc;
        this.wysokosc = wysokosc;
    }

    public int getId() {
        return Id;
    }
    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNazwa() {
        return nazwa;
    }
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOpis() {
        return opis;
    }
    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getPojemnosc() {
        return pojemnosc;
    }
    public void setPojemnosc(int pojemnosc) {
        this.pojemnosc = pojemnosc;
    }

    public int getWysokosc() {
        return wysokosc;
    }
    public void setWysokosc(int wysokosc) {
        this.wysokosc = wysokosc;
    }


    public String toString() {
        return "Dzban: " + "Id=" + Id + ": " + nazwa + ", " + opis + ", " + pojemnosc + ", " + wysokosc;
    }
}
