import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

public class ViewMemberDetails extends MainWindow{
	
	private JFrame frame;
    private JLabel idLabel, firstNameLabel, lastNameLabel, phoneNumberLabel, emailLabel, memberLevelLabel,
            dobLabel, loyaltyPointsLabel, ageLabel, rentHistoryLabel, freeMovieLabel;
    private JTextField idField, firstNameField, lastNameField, phoneNumberField, emailField, memberLevelField,
            dobField, loyaltyPointsField, ageField, rentHistoryField, freeMovieField;
    private JTextField emailField_1;
    private JTextField ageField_1;
    private JTextField freeMovieField_1;
    private JTextField loyaltyPointsField_1;
    private JTextField rentHistoryField_1;
    private JTextField memberLevelField_1;
    private JTextField phoneNumberField_1;
    private JTextField dobField_1;
    private JTextField lastNameField_1;
    private JTextField firstNameField_1;
    private JTextField idField_1;
    /**
     * @wbp.parser.entryPoint
     */
    public ViewMemberDetails(String id, String firstName, String lastName, String phoneNumber, String email, String memberLevel, String dob, String loyaltyPoints, String age, String rentHistory, String freeMovie) {
        this.idField = new JTextField(id);
        this.firstNameField = new JTextField(firstName);
        this.lastNameField = new JTextField(lastName);
        this.phoneNumberField = new JTextField(phoneNumber);
        this.emailField = new JTextField(email);
        this.memberLevelField = new JTextField(memberLevel);
        this.dobField = new JTextField(dob);
        this.loyaltyPointsField = new JTextField(loyaltyPoints);
        this.ageField = new JTextField(age);
        this.rentHistoryField = new JTextField(rentHistory);
        this.freeMovieField = new JTextField(freeMovie);
        frame = new JFrame("Member Details");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);
        frame.getContentPane().setLayout(null);

        idLabel = new JLabel("ID:");
        idLabel.setBounds(50, 30, 80, 25);
        frame.getContentPane().add(idLabel);

        idField_1 = new JTextField(id);
        idField_1.setEditable(false);
        idField_1.setBounds(150, 30, 200, 25);
        frame.getContentPane().add(idField_1);

        firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setBounds(50, 60, 80, 25);
        frame.getContentPane().add(firstNameLabel);

        firstNameField_1 = new JTextField(firstName);
        firstNameField_1.setEditable(false);
        firstNameField_1.setBounds(150, 60, 200, 25);
        frame.getContentPane().add(firstNameField_1);

        lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setBounds(50, 90, 80, 25);
        frame.getContentPane().add(lastNameLabel);

        lastNameField_1 = new JTextField(lastName);
        lastNameField_1.setEditable(false);
        lastNameField_1.setBounds(150, 90, 200, 25);
        frame.getContentPane().add(lastNameField_1);

        phoneNumberLabel = new JLabel("Phone Number:");
        phoneNumberLabel.setBounds(50, 160, 80, 25);
        frame.getContentPane().add(phoneNumberLabel);

        phoneNumberField_1 = new JTextField(phoneNumber);
        phoneNumberField_1.setEditable(false);
        phoneNumberField_1.setBounds(150, 160, 200, 25);
        frame.getContentPane().add(phoneNumberField_1);

        emailLabel = new JLabel("E-Mail Address:");
        emailLabel.setBounds(461, 160, 80, 25);
        frame.getContentPane().add(emailLabel);

        emailField_1 = new JTextField(email);
        emailField_1.setEditable(false);
        emailField_1.setBounds(551, 160, 200, 25);
        frame.getContentPane().add(emailField_1);

        memberLevelLabel = new JLabel("Member Level:");
        memberLevelLabel.setBounds(461, 30, 80, 25);
        frame.getContentPane().add(memberLevelLabel);

        memberLevelField_1 = new JTextField(memberLevel);
        memberLevelField_1.setEditable(false);
        memberLevelField_1.setBounds(551, 30, 200, 25);
        frame.getContentPane().add(memberLevelField_1);

        dobLabel = new JLabel("Date of Birth:");
        dobLabel.setBounds(50, 125, 80, 25);
        frame.getContentPane().add(dobLabel);

        dobField_1 = new JTextField(dob);
        dobField_1.setEditable(false);
        dobField_1.setBounds(150, 125, 200, 25);
        frame.getContentPane().add(dobField_1);

        loyaltyPointsLabel = new JLabel("Loyalty Points:");
        loyaltyPointsLabel.setBounds(461, 60, 80, 25);
        frame.getContentPane().add(loyaltyPointsLabel);

        loyaltyPointsField_1 = new JTextField(loyaltyPoints);
        loyaltyPointsField_1.setEditable(false);
        loyaltyPointsField_1.setBounds(551, 60, 200, 25);
        frame.getContentPane().add(loyaltyPointsField_1);

        ageLabel = new JLabel("Age:");
        ageLabel.setBounds(461, 125, 80, 25);
        frame.getContentPane().add(ageLabel);

        ageField_1 = new JTextField(age);
        ageField_1.setEditable(false);
        ageField_1.setBounds(551, 125, 200, 25);
        frame.getContentPane().add(ageField_1);

        rentHistoryLabel = new JLabel("Rent History:");
        rentHistoryLabel.setHorizontalAlignment(SwingConstants.CENTER);
        rentHistoryLabel.setBounds(10, 215, 776, 25);
        frame.getContentPane().add(rentHistoryLabel);

        rentHistoryField_1 = new JTextField(rentHistory);
        rentHistoryField_1.setEditable(false);
        rentHistoryField_1.setBounds(178, 250, 424, 256);
        frame.getContentPane().add(rentHistoryField_1);

        freeMovieLabel = new JLabel("Free Movie:");
        freeMovieLabel.setBounds(461, 90, 80, 25);
        frame.getContentPane().add(freeMovieLabel);

        freeMovieField_1 = new JTextField(freeMovie);
        freeMovieField_1.setEditable(false);
        freeMovieField_1.setBounds(551, 90, 200, 25);
        frame.getContentPane().add(freeMovieField_1);

        frame.setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new ViewMemberDetails(null, null, null, null, null, null, null, null, null, null, null));
    }

}
