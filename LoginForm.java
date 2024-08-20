import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    
    public LoginForm() {
        setTitle("Login Form");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(10, 20, 80, 25);
        add(usernameLabel);

        usernameField = new JTextField(20);
        usernameField.setBounds(100, 20, 165, 25);
        add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        add(passwordLabel);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(100, 50, 165, 25);
        add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 255, 25);
        add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Simple authentication logic (for demonstration purposes)
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (username.equals("user") && password.equals("pass")) {
                    JOptionPane.showMessageDialog(null, "Login Successful");
                    // Proceed to reservation system
                    new ReservationForm().setVisible(true);
                    dispose(); // Close login form
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid credentials, please try again.");
                }
            }
        });
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginForm().setVisible(true));
    }
}
