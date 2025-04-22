import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Logowanie {
        public static void main(String[] args) {
            JFrame frame = new JFrame("Logowanie do systemu");
            frame.setSize(300, 300);
            frame.setLayout(new GridLayout(3,2,5,5));
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JLabel userLabel = new JLabel("Użytkownik: ");
    JTextField userField = new JTextField();

    JLabel passwordLabel = new JLabel("Haslo: ");
    JTextField passwordField = new JPasswordField();

    JButton loginButton = new JButton("Zaloguj");

    frame.add(userLabel);
    frame.add(userField);
    frame.add(passwordLabel);
    frame.add(passwordField);
    frame.add(loginButton);

    loginButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            String user = userField.getText();
            String password = new String(passwordField.getText());

            if (!user.isEmpty() && !password.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Logowanie powiodlo się!");
            } else {
                JOptionPane.showMessageDialog(frame, "Uzupelnij dane!");
            }
        }});

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        }
    }
