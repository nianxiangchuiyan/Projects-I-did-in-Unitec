import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AddAdmin extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    
    private boolean isUsernameUnique(String username) {
        File file = new File("C:\\JAVA\\UNITEC\\Assignment\\src\\admin_credentials.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] credentials = line.split(",");
                String existingUsername = credentials[0];
                if (existingUsername.equals(username)) {
                    return false; // Username already exists
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception as per your requirement
        }
        return true; // Username is unique
    }

    public AddAdmin() {
        setTitle("Add New Admin");
        setSize(300, 200);
        getContentPane().setLayout(null);

        JLabel usernameLabel = new JLabel("Admmin ID:");
        usernameLabel.setBounds(20, 20, 80, 25);
        getContentPane().add(usernameLabel);

        usernameField = new JTextField(20);
        usernameField.setBounds(130, 20, 140, 25);
        getContentPane().add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(20, 50, 80, 25);
        getContentPane().add(passwordLabel);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(130, 50, 140, 25);
        getContentPane().add(passwordField);

        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setHorizontalAlignment(SwingConstants.LEFT);
        confirmPasswordLabel.setBounds(10, 80, 120, 25);
        getContentPane().add(confirmPasswordLabel);

        confirmPasswordField = new JPasswordField(20);
        confirmPasswordField.setBounds(130, 80, 140, 25);
        getContentPane().add(confirmPasswordField);

        JButton addButton = new JButton("Add");
        addButton.setBounds(190, 120, 80, 25);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());
                if (!isUsernameUnique(username))
                	JOptionPane.showMessageDialog(null, "Admin ID exist, try again");
                else {
                if (password.equals(confirmPassword) && password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$")) {
                    try (FileWriter writer = new FileWriter("C:\\JAVA\\UNITEC\\Assignment\\src\\password.txt", true)) {
                        writer.write("\n" + username + "," + password);
                        JOptionPane.showMessageDialog(null, "Admin added successfully.");
                        dispose();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error occurred while adding admin.");
                    }
                } else if(!password.equals(confirmPassword)) 
                	JOptionPane.showMessageDialog(null, "Passwords do not match");
                else {
                    JOptionPane.showMessageDialog(null, "Your password need to have uppercase letters, lowercase letter and number ");
                }}
            }
        });
        getContentPane().add(addButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(20, 120, 80, 25);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        getContentPane().add(cancelButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AddAdmin::new);
    }
}
