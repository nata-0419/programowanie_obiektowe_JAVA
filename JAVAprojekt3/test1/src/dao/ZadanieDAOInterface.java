package dao;

import model.Zadanie;
import model.NiepoprawnyPiorytetException;

import java.sql.SQLException;
import java.util.List;

public interface ZadanieDAOInterface {
    void utworzZadanie(Zadanie zadanie) throws SQLException, NiepoprawnyPiorytetException;
    Zadanie pobierzZadaniePoId(int id) throws SQLException;
    List<Zadanie> pobierzZadaniaUzytkownika(int idUzytkownika) throws SQLException;
    void aktualizujZadanie(Zadanie zadanie) throws SQLException, NiepoprawnyPiorytetException;
    void usunZadanie(int id) throws SQLException;
}
