package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.AdminController;
import Model.AdminModel;
import View.MenuAdmin;

public class LoginGUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    AdminController adminController ;
    MenuAdmin menuAdmin ;
    public LoginGUI() {
        adminController = new AdminController();
//        menuAdmin = new MenuAdmin();
        setTitle("Login Form");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminModel.dataAdmin();
                boolean status = false;
                String nama = usernameField.getText();
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);
                status = adminController.loginAdmin(nama, password);

                if (adminController.loginAdmin(nama, password)) {
                    JOptionPane.showMessageDialog(LoginGUI.this, "Login Successful!");
                    //MenuAdmin.menuAdmin();
                } else {
                    JOptionPane.showMessageDialog(LoginGUI.this, "Invalid Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel()); // placeholder for layout
        panel.add(loginButton);

        add(panel);
    }

//    private boolean isValidLogin(String username, String password) {
//        // You can implement your own validation logic here
//        // For simplicity, let's consider a valid login if both username and password are non-empty
//        return !username.isEmpty() && !password.isEmpty();
//    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginGUI().setVisible(true);
            }
        });
    }
}
