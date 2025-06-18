package model;

import java.util.Objects;

public class Uzytkownik {
    private int id;
    private String imie;
    private String nazwisko;
    private String nick;
    private String hasloHaszowane;

    public Uzytkownik(int id, String imie, String nazwisko, String nick, String hasloHaszowane) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nick = nick;
        this.hasloHaszowane = hasloHaszowane;
    }

    public int getId() { return id; }
    public String getImie() { return imie; }
    public String getNazwisko() { return nazwisko; }
    public String getNick() { return nick; }
    public String getHasloHaszowane() { return hasloHaszowane; }

    public void setId(int id) { this.id = id; }
    public void setImie(String imie) { this.imie = imie; }
    public void setNazwisko(String nazwisko) { this.nazwisko = nazwisko; }
    public void setNick(String nick) { this.nick = nick; }
    public void setHasloHaszowane(String hasloHaszowane) { this.hasloHaszowane = hasloHaszowane; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Uzytkownik)) return false;
        Uzytkownik that = (Uzytkownik) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
