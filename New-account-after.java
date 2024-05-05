import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPage extends JFrame implements ActionListener {
    JTextField emailField;
    JPasswordField passwordField;
    JButton loginButton;
    JButton createAccountButton;
    JTextField nameField;
    JTextField universityEmailField;

    public LoginPage() {
        setTitle("Login Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        panel.setLayout(new GridLayout(6, 2));

        JLabel emailLabel = new JLabel("Email:");
        JLabel passwordLabel = new JLabel("Password:");
        emailField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");
        createAccountButton = new JButton("Create Account");
        JLabel nameLabel = new JLabel("Name:");
        JLabel universityEmailLabel = new JLabel("University Email:");
        nameField = new JTextField();
        universityEmailField = new JTextField();

        loginButton.addActionListener(this);
        createAccountButton.addActionListener(this);

        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel()); // Placeholder for spacing
        panel.add(loginButton);
        panel.add(new JLabel()); // Placeholder for spacing
        panel.add(createAccountButton);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(universityEmailLabel);
        panel.add(universityEmailField);

        add(panel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            if (email.equals("admin@example.com") && password.equals("admin")) {
                JOptionPane.showMessageDialog(this, "Login Successful!");
                // Add code to navigate to next page or perform further actions
            } else {
                JOptionPane.showMessageDialog(this, "Invalid email or password. Please try again.");
            }
        } else if (e.getSource() == createAccountButton) {
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            String name = nameField.getText();
            String universityEmail = universityEmailField.getText();


            UserAccount user = new UserAccount(email, password, name, universityEmail);
            JOptionPane.showMessageDialog(this, "Account created successfully!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginPage();
            }
        });
    }
}

class UserAccount {
    private String email;
    private String password;
    private String name;
    private String universityEmail;

    public UserAccount(String email, String password, String name, String universityEmail) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.universityEmail = universityEmail;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniversityEmail() {
        return universityEmail;
    }

    public void setUniversityEmail(String universityEmail) {
        this.universityEmail = universityEmail;
    }


    public String toString() {
        return "Email Address: " + email + "\n" +
               "Name: " + name + "\n" +
               "University Email: " + universityEmail + "\n";
    }
}
