import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Konwerter walut");
        frame.setSize(500, 200);
        frame.setLayout(new FlowLayout());

        JLabel kwotaLabel = new JLabel("Kwota");
        JTextField kwotaField = new JTextField(10);

        String[] waluty = {"PLN", "USD", "EUR"};
        JComboBox<String> walutaWpr = new JComboBox<>(waluty);
        JComboBox<String> walutaPrz = new JComboBox<>(waluty);

        JButton przeliczButton = new JButton("Przelicz");
        JLabel wynikLabel = new JLabel("Wynik: ");

        frame.add(kwotaLabel);
        frame.add(kwotaField);
        frame.add(new JLabel("Wybierz walute: "));
        frame.add(walutaWpr);
        frame.add(new JLabel("na walute: "));
        frame.add(walutaPrz);
        frame.add(przeliczButton);
        frame.add(wynikLabel);

        double kursPLNnaEUR = 0.22;
        double kursPLNnaUSD = 0.24;
        double kursEURnaPLN = 4.50;
        double kursEURnaUSD = 1.10;
        double kursUSDnaPLN = 4.10;
        double kursUSDnaEUR = 0.91;


        przeliczButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String kwotaText = kwotaField.getText();
                    if (kwotaText.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Proszę podać kwotę.", "Błąd", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    double kwota = Double.parseDouble(kwotaText);

                    String waluta = (String) walutaWpr.getSelectedItem();
                    String walutaDocelowa = (String) walutaPrz.getSelectedItem();
                    double wynik = 0;

                    if (waluta.equals("PLN")) {
                        if (walutaDocelowa.equals("EUR")) {
                            wynik = kwota * kursPLNnaEUR;
                        } else if (walutaDocelowa.equals("USD")) {
                            wynik = kwota * kursPLNnaUSD;
                        } else {
                            wynik = kwota; // PLN na PLN
                        }
                    } else if (waluta.equals("EUR")) {
                        if (walutaDocelowa.equals("PLN")) {
                            wynik = kwota * kursEURnaPLN;
                        } else if (walutaDocelowa.equals("USD")) {
                            wynik = kwota * kursEURnaUSD;
                        } else {
                            wynik = kwota; // EUR na EUR
                        }
                    } else if (waluta.equals("USD")) {
                        if (walutaDocelowa.equals("PLN")) {
                            wynik = kwota * kursUSDnaPLN;
                        } else if (walutaDocelowa.equals("EUR")) {
                            wynik = kwota * kursUSDnaEUR;
                        } else {
                            wynik = kwota; // USD na USD
                        }
                    }
                    wynikLabel.setText("Wynik: " + String.format("%.2f", wynik) + " " + walutaDocelowa);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Wpisano niepoprawną wartość kwoty!", "Błąd", JOptionPane.ERROR_MESSAGE);
                }
            }
        });



        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}