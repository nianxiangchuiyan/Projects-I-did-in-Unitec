import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ChangePassword extends MainWindow{

    /**
     * @wbp.parser.entryPoint
     */
    private JFrame frame;
    private JComboBox<String> usernameComboBox;
    private JPasswordField passwordField;
    private JPasswordField oldPasswordField;
    private JPasswordField newPasswordField;
    private JPasswordField confirmNewPasswordField;


    private static void sure() {
    	String dialogue = "Are you Sure to exit?";
    	int select = JOptionPane.showConfirmDialog(null, dialogue,"Exit?",JOptionPane.YES_NO_OPTION);
    	if (select == 0) 
    		System.exit(0);
    }
    /**
     * @wbp.parser.entryPoint
     */
    public ChangePassword() {
        frame = new JFrame("Change Password");
        frame.getContentPane().setLayout(null);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
        	@Override
        	public void windowClosing(WindowEvent e) {
        		sure();
        	}
        });

        JLabel usernameLabel = new JLabel("Select Admin ID:");
        usernameLabel.setBounds(20, 20, 120, 25);
        frame.getContentPane().add(usernameLabel);

        usernameComboBox = new JComboBox<>();
        populateUsernameComboBox();
        usernameComboBox.setBounds(150, 20, 120, 25);
        frame.getContentPane().add(usernameComboBox);

        JLabel oldPasswordLabel = new JLabel("Old Password:");
        oldPasswordLabel.setBounds(20, 60, 100, 25);
        frame.getContentPane().add(oldPasswordLabel);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(0, 0, 7, 19);
        frame.getContentPane().add(passwordField);

        JLabel newPasswordLabel = new JLabel("New Password:");
        newPasswordLabel.setBounds(20, 100, 100, 25);
        frame.getContentPane().add(newPasswordLabel);

        JLabel confirmNewPasswordLabel = new JLabel("Confirm New Password:");
        confirmNewPasswordLabel.setBounds(20, 140, 140, 25);
        frame.getContentPane().add(confirmNewPasswordLabel);

            
        JButton changeButton = new JButton("Change");
        changeButton.setBounds(180, 200, 80, 25);
        changeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedUsername = (String) usernameComboBox.getSelectedItem();
                String oldPassword = oldPasswordField.getText();
                String newPassword = newPasswordField.getText();
                String confirmNewPassword = confirmNewPasswordField.getText();

                if (checkOldPassword(selectedUsername, oldPassword)) {
                    if (newPassword.equals(confirmNewPassword) && newPassword.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$")) {
                        try {
                            File file = new File("C:\\JAVA\\UNITEC\\Assignment\\src\\password.txt");
                            BufferedReader reader = new BufferedReader(new FileReader(file));
                            String line;
                            StringBuilder content = new StringBuilder();
                            while ((line = reader.readLine()) != null) {
                                if (line.startsWith(selectedUsername)) {
                                    content.append(selectedUsername).append(",").append(newPassword).append("\n");
                                } else {
                                    content.append(line).append("\n");
                                }
                            }
                            reader.close();

                            FileWriter writer = new FileWriter(file);
                            writer.write(content.toString());
                            writer.close();
                            JOptionPane.showMessageDialog(null, "Password changed successfully.");
                            frame.dispose();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error occurred while changing password.");
                        }
                    } else if (!newPassword.equals(confirmNewPassword)) {
                        JOptionPane.showMessageDialog(null, "Passwords do not match.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Your password needs to have uppercase, lowercase, and numbers.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Old password is incorrect.");
                }
            }
        });
        frame.getContentPane().add(changeButton);
        
        oldPasswordField = new JPasswordField();
        oldPasswordField.setBounds(150, 57, 120, 25);
        frame.getContentPane().add(oldPasswordField);
        
        newPasswordField = new JPasswordField();
        newPasswordField.setBounds(150, 100, 120, 22);
        frame.getContentPane().add(newPasswordField);
        
        confirmNewPasswordField = new JPasswordField();
        confirmNewPasswordField.setBounds(150, 140, 120, 22);
        frame.getContentPane().add(confirmNewPasswordField);
        
        JButton btnNewButton = new JButton("Cancle");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.dispose();
        	}
        });
        btnNewButton.setBounds(35, 202, 85, 21);
        frame.getContentPane().add(btnNewButton);

        frame.setVisible(true);
    }

    private void populateUsernameComboBox() {
        try {
            File file = new File("C:\\JAVA\\UNITEC\\Assignment\\src\\password.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 1) {
                    usernameComboBox.addItem(parts[0]);
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean checkOldPassword(String selectedUsername, String oldPassword) {
        try {
            File file = new File("C:\\JAVA\\UNITEC\\Assignment\\src\\password.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(selectedUsername)) {
                    String[] parts = line.split(",");
                    if (parts.length == 2) {
                        String storedPassword = parts[1];
                        if (oldPassword.equals(storedPassword)) {
                            reader.close();
                            return true;
                        }
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ChangePassword::new);
    }
}
