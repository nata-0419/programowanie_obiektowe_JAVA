package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class SzczegolyZadania {
    private int idZadania;
    private LocalDate data;
    private LocalTime godzina;
    private String stanRealizacji;
    private String szczegoly;

    public SzczegolyZadania(int idZadania, LocalDate data, LocalTime godzina, String stanRealizacji, String szczegoly) {
        this.idZadania = idZadania;
        this.data = data;
        this.godzina = godzina;
        this.stanRealizacji = stanRealizacji;
        this.szczegoly = szczegoly;
    }

    public int getIdZadania() { return idZadania; }
    public LocalDate getData() { return data; }
    public LocalTime getGodzina() { return godzina; }
    public String getStanRealizacji() { return stanRealizacji; }
    public String getSzczegoly() { return szczegoly; }

    public void setData(LocalDate data) { this.data = data; }
    public void setGodzina(LocalTime godzina) { this.godzina = godzina; }
    public void setStanRealizacji(String stanRealizacji) { this.stanRealizacji = stanRealizacji; }
    public void setSzczegoly(String szczegoly) { this.szczegoly = szczegoly; }
}
