import javax.swing.*;
import gui.OknoLogowania;
import gui.OknoRejestracji;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Object[] options = {"Logowanie", "Rejestracja"};
            int wybor = JOptionPane.showOptionDialog(null,
                    "Wybierz opcję:",
                    "Start",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);

            if (wybor == JOptionPane.YES_OPTION) {
                OknoLogowania oknoLogowania = new OknoLogowania();
                oknoLogowania.setVisible(true);
            } else if (wybor == JOptionPane.NO_OPTION) {
                OknoRejestracji oknoRejestracji = new OknoRejestracji();
                oknoRejestracji.setVisible(true);
            } else {
                System.exit(0);
            }
        });
    }
}
