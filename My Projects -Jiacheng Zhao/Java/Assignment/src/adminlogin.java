import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class adminlogin {
    private static int loginAttempts = 0;
    private static final int MAX_LOGIN_ATTEMPTS = 3;
   
    private static  boolean checkPassword(String UserName,String PassWord) throws Throwable {
    	boolean checker = true;
    	try (BufferedReader reader = new BufferedReader(new FileReader("C:\\JAVA\\UNITEC\\Assignment\\src\\password.txt"))) {
            String line = reader.readLine().trim();
            while (line != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, ",");
                if (tokenizer.countTokens() == 2) {  
                    String name = tokenizer.nextToken().trim();
                    String password = tokenizer.nextToken().trim();
                    if (name.equals(UserName) && password.equals(PassWord)) {
                        checker = false;
                    }
                
                line = reader.readLine();  
            }
    	
            }} catch (IOException e) {
            e.printStackTrace();
            File file = new File("C:\\JAVA\\UNITEC\\Assignment\\src\\password.txt");
            File file1 = new File("C:\\JAVA\\UNITEC\\Assignment\\src\\members.txt");
            try (FileWriter writer = new FileWriter(file)) {
				writer.write("admin,admin");
				writer.close();
				FileWriter writer1 = new FileWriter(file1);
				writer1.append("");
				writer1.close();}
            	checker = checkPassword(UserName,PassWord);
            }
        
    	
    	return checker;
    }
    private static void dialogue() {
    	String dialogue = "Max login attempts reached.\n"
    			+ "please check readme file for defualt username and password\n"
    			+ " Exiting.";
    	JOptionPane.showMessageDialog(null, dialogue);
    }
    private static void sure() {
    	String dialogue = "Are you Sure to exit?";
    	int select = JOptionPane.showConfirmDialog(null, dialogue,"Exit?",JOptionPane.YES_NO_OPTION);
    	if (select == 0) 
    		System.exit(0);
    }

    public static void main(String[] args) {
    	
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
        	@Override
        	public void windowClosing(WindowEvent e) {
        		sure();
        	
        }});
        
        frame.setSize(400, 200);
        frame.getContentPane().setLayout(null);

        JLabel usernameLabel = new JLabel("Admin ID:");
        usernameLabel.setBounds(50, 30, 80, 25);
        frame.getContentPane().add(usernameLabel);

        JTextField usernameField = new JTextField(20);
        usernameField.setBounds(150, 30, 150, 25);
        frame.getContentPane().add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 60, 80, 25);
        frame.getContentPane().add(passwordLabel);

        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setBounds(150, 60, 150, 25);
        frame.getContentPane().add(passwordField);

        JLabel errorMessageLabel = new JLabel("");
        errorMessageLabel.setBounds(72, 10, 250, 25);
        frame.getContentPane().add(errorMessageLabel);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(242, 128, 80, 25);
        frame.getContentPane().add(loginButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(50, 128, 80, 25);
        frame.getContentPane().add(exitButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enterdusername = usernameField.getText();
                String enterdpassword = new String(passwordField.getPassword());
                boolean check = false;
                try {
					check = checkPassword(enterdusername, enterdpassword);
				} catch (Throwable e1) {
					
					e1.printStackTrace();
				}
                
                if (check == true) {
                    errorMessageLabel.setText("Login successful!");
                    new MainWindow();
                    frame.dispose();
                    //TODO call the main Customer window
                } else {
                    loginAttempts++;
                    int remainingAttempts = MAX_LOGIN_ATTEMPTS - loginAttempts;
                    if (remainingAttempts > 0) {
                        errorMessageLabel.setText("Login failed. " + remainingAttempts + " attempts remaining.");
                    } else {
                    	//TODO call a new window show the text
                        dialogue();
                        System.exit(0);
                    }
                }
            
            }});

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	sure();
            }
        });
        
        

        frame.setVisible(true);
    
}}



