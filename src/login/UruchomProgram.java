package login;

/*Java Program to switch between frames using buttons*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static java.util.Map.entry;
class login implements ActionListener
{
    private static HashMap<String, String> users = new HashMap<>(Map.ofEntries(
            entry("admin", "admin"),
            entry("user", "12345"),
            entry("12345", "12345")));
    static JFrame frame1;
    static JFrame frame2;
    static JFrame frame3;
    static JButton register;
    static JButton close;
    static JButton back;
    static JButton loginButton;
    static JButton addUser;
    static JTextField login;
    static JPasswordField passwordField;
    static JTextField newLogin;
    static JPasswordField newPasswordField;
    static JLabel info;
    static JLabel info2;
    static JLabel txtLogin;
    static JLabel txtPassword;
    public static void main(String[] args)
    {
        frame1 = new JFrame("Logowanie");
        frame1.setSize(400,300);
        frame1.setLayout(null);
        frame1.setResizable(false);
        login = new JTextField();
        register = new JButton("Rejestracja");
        close = new JButton("Zamknij");
        passwordField = new JPasswordField();
        info = new JLabel();
        txtLogin = new JLabel();
        txtPassword = new JLabel();
        txtLogin.setBounds(10, 25, 180, 20);
        txtLogin.setText("Nazwa użytkownika:");
        txtPassword.setBounds(10, 55, 180, 20);
        txtPassword.setText("Hasło:");
        loginButton = new JButton();
        loginButton.setBounds(25, 150, 100, 30);
        loginButton.setText("Login");
        loginButton.addActionListener(e -> {
            String password = users.get(login.getText());
            if (password != null && password.equals(new String(passwordField.getPassword()))) {
                info.setText("Prawidłowy login i hasło");
                info.setForeground(Color.GREEN);
                create_frame3();

            }
            else {
                info.setText("Błędne dane logowania");
                info.setForeground(Color.RED);
            }});
        login.setBounds(150, 25, 160, 20);
        register.setBounds(150,150,100,30);
        close.setBounds(275,150,100,30);
        passwordField.setBounds(150, 55, 160, 20);
        info.setBounds(10, 85, 250, 30);
        info.setText("");
        info.setFont(new Font("Calibri", Font.BOLD, 20));
        info.setForeground(Color.GREEN);
        frame1.add(register);
        frame1.add(close);
        frame1.add(login);
        frame1.add(passwordField);
        frame1.add(info);
        frame1.add(loginButton);
        frame1.add(txtLogin);
        frame1.add(txtPassword);

        login obj=new login();
        register.addActionListener(obj);
        close.addActionListener(obj);
        frame1.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        String button=e.getActionCommand();
        if(button.equals("Rejestracja"))
        {
            create_frame2();
        }
        if(button.equals("Zamknij"))
        {
            frame1.dispose();
        }
        if(button.equals("Powrót"))
        {
            frame2.dispose();
        }
        if(button.equals("Wyloguj się"))
        {
            frame3.dispose();
        }
    }
    public static void create_frame2()
    {
        frame2 = new JFrame("Rejestracja");
        frame2.setSize(400,300);
        frame2.setLayout(null);
        frame2.setBackground(Color.white);
        info2 = new JLabel();
        info2.setBounds(10, 100, 350, 30);
        info2.setFont(new Font("Calibri", Font.BOLD, 20));
        addUser = new JButton();
        addUser.setText("Dodaj użytkownika");
        addUser.setBounds(25,150,225,30);
        addUser.addActionListener(e -> {
            String user = newLogin.getText();
            String password = new String(passwordField.getPassword());
            if (users.containsKey(user)){
                info2.setText("Użytkownik znajduje się już w bazie");
                info2.setForeground(Color.RED);
            }
            else {
                users.putIfAbsent(user, password);
                info2.setText("Użytkownik pomyślnie dodany");
                info2.setForeground(Color.GREEN);
            }
        });
        newLogin = new JPasswordField();
        newLogin.setBounds(150, 25, 160, 20);
        newPasswordField = new JPasswordField();
        newPasswordField.setBounds(150, 55, 160, 20);
        back = new JButton("Powrót");
        back.setBounds(275,150,100,30);
        frame2.add(back);
        frame2.add(txtLogin);
        frame2.add(txtPassword);
        frame2.add(addUser);
        frame2.add(newLogin);
        frame2.add(newPasswordField);
        frame2.add(info2);
        login obj=new login();
        back.addActionListener(obj);
        frame2.setVisible(true);
    }
    public static void create_frame3()
    {
        frame3 = new JFrame("Użytkownicy");
        frame3.setSize(400,300);
        frame3.setLayout(null);
        frame3.setBackground(Color.white);
        back = new JButton("Wyloguj się");
        back.setBounds(250,10,100,30);
        JTable tableOfUsers = new JTable(users.size(),2);
        tableOfUsers.setBounds(25, 75, 300, users.size()*16);
        int row=0;
        for(Map.Entry<String, String> entry: users.entrySet()){
            tableOfUsers.setValueAt(entry.getKey(),row,0);
            tableOfUsers.setValueAt(entry.getValue(),row,1);
            row++;
        }
        frame3.add(back);
        frame3.add(tableOfUsers);
        login obj=new login();
        back.addActionListener(obj);
        frame3.setVisible(true);
    }
}