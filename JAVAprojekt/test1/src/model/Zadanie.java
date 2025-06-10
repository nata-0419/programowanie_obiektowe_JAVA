package model;

public class Zadanie {
    private int id;
    private int idUzytkownika;
    private String nazwa;
    private int priorytet;
    private String kategoria;

    public Zadanie(int id, int idUzytkownika, String nazwa, int priorytet, String kategoria) {
        this.id = id;
        this.idUzytkownika = idUzytkownika;
        this.nazwa = nazwa;
        this.priorytet = priorytet;
        this.kategoria = kategoria;
    }

    public int getId() { return id; }
    public int getIdUzytkownika() { return idUzytkownika; }
    public String getNazwa() { return nazwa; }
    public int getPriorytet() { return priorytet; }
    public String getKategoria() { return kategoria; }

    public void setId(int id) { this.id = id; }
    public void setNazwa(String nazwa) { this.nazwa = nazwa; }
    public void setPriorytet(int priorytet) { this.priorytet = priorytet; }
    public void setKategoria(String kategoria) { this.kategoria = kategoria; }
}
