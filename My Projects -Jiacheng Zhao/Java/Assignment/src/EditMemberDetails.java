import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
    /**
     * @wbp.parser.entryPoint
     */
    public class EditMemberDetails extends MainWindow {
        private JFrame frame;
        private JTextField idField, firstNameField, lastNameField, phoneNumberField, emailField, memberLevelField,
                dobField, loyaltyPointsField, ageField, rentHistoryField, freeMovieField;
        private MainWindow mainWindow;

        /**
         * @wbp.parser.entryPoint
         */
        public EditMemberDetails(MainWindow mainWindow, int row, String id, String firstName, String lastName, String phoneNumber, String email, String memberLevel,
                                String dob, String loyaltyPoints, String age, String rentHistory, String freeMovie) {
            this.mainWindow = mainWindow;
            
            frame = new JFrame("Edit Member Details");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(800, 600);
            frame.getContentPane().setLayout(new GridLayout(0, 2, 10, 10));

            idField = new JTextField(id);
            idField.setEditable(false);
            firstNameField = new JTextField(firstName);
            lastNameField = new JTextField(lastName);
            phoneNumberField = new JTextField(phoneNumber);
            emailField = new JTextField(email);
            memberLevelField = new JTextField(memberLevel);
            dobField = new JTextField(dob);
            loyaltyPointsField = new JTextField(loyaltyPoints);
            ageField = new JTextField(age);
            rentHistoryField = new JTextField(rentHistory);
            freeMovieField = new JTextField(freeMovie);

            frame.getContentPane().add(new JLabel("ID:"));
            frame.getContentPane().add(idField);

            frame.getContentPane().add(new JLabel("First Name:"));
            frame.getContentPane().add(firstNameField);

            frame.getContentPane().add(new JLabel("Last Name:"));
            frame.getContentPane().add(lastNameField);

            frame.getContentPane().add(new JLabel("Phone Number:"));
            frame.getContentPane().add(phoneNumberField);

            frame.getContentPane().add(new JLabel("E-Mail Address:"));
            frame.getContentPane().add(emailField);

            frame.getContentPane().add(new JLabel("Member Level:"));
            frame.getContentPane().add(memberLevelField);

            frame.getContentPane().add(new JLabel("Date of Birth:"));
            frame.getContentPane().add(dobField);

            frame.getContentPane().add(new JLabel("Loyalty Points:"));
            frame.getContentPane().add(loyaltyPointsField);

            frame.getContentPane().add(new JLabel("Age:"));
            frame.getContentPane().add(ageField);

            frame.getContentPane().add(new JLabel("Rent History:"));
            frame.getContentPane().add(rentHistoryField);

            frame.getContentPane().add(new JLabel("Free Movie:"));
            frame.getContentPane().add(freeMovieField);

            JButton saveButton = new JButton("Save");
            saveButton.addActionListener(e -> {
                String idValue = idField.getText();
                String firstNameValue = firstNameField.getText();
                String lastNameValue = lastNameField.getText();
                String phoneNumberValue = phoneNumberField.getText();
                String emailValue = emailField.getText();
                String memberLevelValue = memberLevelField.getText();
                String dobValue = dobField.getText();
                String loyaltyPointsValue = loyaltyPointsField.getText();
                String ageValue = ageField.getText();
                String rentHistoryValue = rentHistoryField.getText();
                String freeMovieValue = freeMovieField.getText();

                if (!isNumeric(phoneNumberValue)) {
                    JOptionPane.showMessageDialog(frame, "Phone number should contain only digits. Please try again.");
                    return;
                }

                if (!(emailValue.contains("@") && emailValue.contains("."))) {
                    JOptionPane.showMessageDialog(frame, "Email should contain '@' and '.'. Please try again.");
                    return;
                }

                if (!memberLevelValue.isEmpty() && !(memberLevelValue.equalsIgnoreCase("Regular") || memberLevelValue.equalsIgnoreCase("Silver") || memberLevelValue.equalsIgnoreCase("Gold"))) {
                    JOptionPane.showMessageDialog(frame, "Not a valid member level. Regular, Silver, or Gold only!");
                    return;
                }

                if (!isDateValid(dobValue)) {
                    JOptionPane.showMessageDialog(frame, "Not a valid date of birth. Please use the format: yyyy-MM-dd");
                    return;
                }

                // 更新文件内容
                updateFileContent(idValue, idValue, firstNameValue, lastNameValue, phoneNumberValue, emailValue, memberLevelValue,
                        dobValue, loyaltyPointsValue, ageValue, rentHistoryValue, freeMovieValue);

                JOptionPane.showMessageDialog(frame, "Member details saved successfully.");

                frame.dispose();
            });
            frame.getContentPane().add(saveButton);

            frame.setVisible(true);
        }

        public static boolean isNumeric(String str) {
            if (str.equals("N/A"))
                return true;
            for (int i = str.length(); --i >= 0; ) {
                if (!Character.isDigit(str.charAt(i))) {
                    return false;
                }
            }
            return true;
        }

        public static boolean isDateValid(String date) {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            try {
                dateFormatter.parse(date);
                return true;
            } catch (DateTimeParseException e) {
                return false;
            }
        }

        public static boolean isValidNumber(String input) {
            return input.matches("\\d+(\\.\\d)?");
        }

        private void updateFileContent(String idValue, String... newData) {
            File file = new File("C:\\JAVA\\UNITEC\\Assignment\\src\\members.txt");
            try {
                ArrayList<String> lines = new ArrayList<>();
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.startsWith(idValue)) {
                        lines.add(String.join(",", newData));
                    } else {
                        lines.add(line);
                    }
                }
                br.close();

                FileWriter writer = new FileWriter(file);
                for (String updatedLine : lines) {
                    writer.write(updatedLine + "\n");
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Error occurred while saving member details.");
            }
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() ->
                    new EditMemberDetails(new MainWindow(), 0, "test", "test", "test", "test", "test@example.com", "Gold",
                            "2000-01-01", "10", "3", "test", "2"));
        }
    }