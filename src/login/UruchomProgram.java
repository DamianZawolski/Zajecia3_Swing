
package login;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import static java.util.Map.entry;

class MainWindow extends JFrame {
    private HashMap<String, String> users = new HashMap<>(Map.ofEntries(
            entry("admin", "admin"),
            entry("user", "12345"),
            entry("12345", "12345")));

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                MainWindow frame = new MainWindow();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace(System.err);
            }
        });
    }

    final Color defaultColor = new Color(220, 220, 220);

    public MainWindow() throws HeadlessException {
        super("Logowanie");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(400, 300);
        JPanel contentPane = new JPanel();

        contentPane.setBorder(new EmptyBorder(35, 35, 35, 35));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(defaultColor);

        JTextField idTextField = new JTextField();
        idTextField.setBounds(150, 25, 160, 20);
        contentPane.add(idTextField);

        JButton loginButton = new JButton();

        JLabel txta3 = new JLabel();
        txta3.setText("");
        txta3.setBounds(10, 85, 250, 30);
        txta3.setFont(new Font("Serif", Font.BOLD, 20));
        txta3.setForeground(Color.GREEN);
        contentPane.add(txta3);



        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(150, 55, 160, 20);
        passwordField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    loginButton.doClick();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        contentPane.add(passwordField);

        loginButton.setBounds(15, 200, 100, 30);
        loginButton.setText("Login");
        loginButton.addActionListener(e -> {
            String password = users.get(idTextField.getText());
            if (password != null && password.equals(new String(passwordField.getPassword()))) {
                txta3.setText("Prawidłowy login i hasło");
                txta3.setForeground(Color.GREEN);
                contentPane.add(txta3);

                return;
            }
            txta3.setText("Błąd logowania");
            txta3.setForeground(Color.RED);
            contentPane.add(txta3);
        });
        contentPane.add(loginButton);

        JButton resetButton = new JButton();
        resetButton.setBounds(130, 200, 100, 30);
        resetButton.setText("Reset");
        resetButton.addActionListener(e -> {
            idTextField.setText("");
            passwordField.setText("");
            contentPane.setBackground(defaultColor);
            txta3.setText("");
        });
        contentPane.add(resetButton);

        JButton registerButton = new JButton();
        registerButton.setBounds(245, 200, 100, 30);
        registerButton.setText("Rejestracja");
        registerButton.addActionListener(e -> contentPane.setBackground(defaultColor));
        contentPane.add(registerButton);

        JLabel txta1 = new JLabel();
        txta1.setBounds(10, 25, 180, 20);
        txta1.setText("Nazwa użytkownika:");
        contentPane.add(txta1);

        JLabel txta2 = new JLabel();
        txta2.setBounds(10, 55, 180, 20);
        txta2.setText("Hasło:");
        contentPane.add(txta2);


    }
}