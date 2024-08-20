import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReservationForm extends JFrame {
    private JTextField nameField;
    private JTextField reservationDetailsField;
    private JButton reserveButton;
    private JButton cancelButton;
    private JTextArea reservationDisplay;

    public ReservationForm() {
        setTitle("Reservation System");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 20, 80, 25);
        add(nameLabel);

        nameField = new JTextField(20);
        nameField.setBounds(100, 20, 165, 25);
        add(nameField);

        JLabel detailsLabel = new JLabel("Details:");
        detailsLabel.setBounds(10, 50, 80, 25);
        add(detailsLabel);

        reservationDetailsField = new JTextField(20);
        reservationDetailsField.setBounds(100, 50, 165, 25);
        add(reservationDetailsField);

        reserveButton = new JButton("Reserve");
        reserveButton.setBounds(10, 80, 255, 25);
        add(reserveButton);

        cancelButton = new JButton("Cancel Reservation");
        cancelButton.setBounds(10, 110, 255, 25);
        add(cancelButton);

        reservationDisplay = new JTextArea();
        reservationDisplay.setBounds(10, 140, 355, 120);
        add(reservationDisplay);

        reserveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String details = reservationDetailsField.getText();
                if (!name.isEmpty() && !details.isEmpty()) {
                    // Simulate saving reservation
                    reservationDisplay.append("Reservation for " + name + ": " + details + "\n");
                    nameField.setText("");
                    reservationDetailsField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter all details.");
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                if (!name.isEmpty()) {
                    // Simulate cancellation
                    reservationDisplay.append("Reservation for " + name + " has been cancelled.\n");
                    nameField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter the name to cancel.");
                }
            }
        });
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ReservationForm().setVisible(true));
    }
}
