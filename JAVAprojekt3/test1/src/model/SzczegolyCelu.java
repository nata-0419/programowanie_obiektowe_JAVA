package model;
import java.time.LocalDate;

public class SzczegolyCelu {
    private int idCelu;
    private double koszty;
    private double uzbieranaKwota;
    private LocalDate dataRozpoczecia;
    private LocalDate dataZakonczenia;
    private String status;

    public SzczegolyCelu(int idCelu, double koszty, double uzbieranaKwota, LocalDate dataRozpoczecia, LocalDate dataZakonczenia, String status) {
        this.idCelu = idCelu;
        this.koszty = koszty;
        this.uzbieranaKwota = uzbieranaKwota;
        this.dataRozpoczecia = dataRozpoczecia;
        this.dataZakonczenia = dataZakonczenia;
        this.status = status;
    }

    public int getIdCelu() { return idCelu; }
    public double getKoszty() { return koszty; }
    public double getUzbieranaKwota() { return uzbieranaKwota; }
    public LocalDate getDataRozpoczecia() { return dataRozpoczecia; }
    public LocalDate getDataZakonczenia() { return dataZakonczenia; }
    public String getStatus() { return status; }

    public void setKoszty(double koszty) { this.koszty = koszty; }
    public void setUzbieranaKwota(double uzbieranaKwota) { this.uzbieranaKwota = uzbieranaKwota; }
    public void setDataRozpoczecia(LocalDate dataRozpoczecia) { this.dataRozpoczecia = dataRozpoczecia; }
    public void setDataZakonczenia(LocalDate dataZakonczenia) { this.dataZakonczenia = dataZakonczenia; }
    public void setStatus(String status) { this.status = status; }
}
