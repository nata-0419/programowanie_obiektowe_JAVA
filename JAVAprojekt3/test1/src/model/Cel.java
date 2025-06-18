package model;

public class Cel {
    private int id;
    private int idUzytkownika;
    private String nazwa;
    private String kategoria;
    private String opis;
    private String zdjecie;

    public Cel(int id, int idUzytkownika, String nazwa, String kategoria, String opis, String zdjecie) {
        this.id = id;
        this.idUzytkownika = idUzytkownika;
        this.nazwa = nazwa;
        this.kategoria = kategoria;
        this.opis = opis;
        this.zdjecie = zdjecie;
    }

    public int getId() { return id; }
    public int getIdUzytkownika() { return idUzytkownika; }
    public String getNazwa() { return nazwa; }
    public String getKategoria() { return kategoria; }
    public String getOpis() { return opis; }
    public String getZdjecie() { return zdjecie; }

    public void setId(int id) { this.id = id; }
    public void setNazwa(String nazwa) { this.nazwa = nazwa; }
    public void setKategoria(String kategoria) { this.kategoria = kategoria; }
    public void setOpis(String opis) { this.opis = opis; }
    public void setZdjecie(String zdjecie) { this.zdjecie = zdjecie; }
}
