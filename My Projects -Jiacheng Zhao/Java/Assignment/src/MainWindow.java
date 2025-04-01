import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
public class MainWindow {
    private JTable memberTable;
    private DefaultTableModel tableModel; 
    private JFrame frame;
    private int selectedRow = -1; 
   

    public JFrame getFrame() {
        return frame;
    }

    private void resetSearch() {
        TableRowSorter<DefaultTableModel> sorter = (TableRowSorter<DefaultTableModel>) memberTable.getRowSorter();
        sorter.setRowFilter(null);
    }
    private void searchMember(String searchTerm) {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
        memberTable.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter(searchTerm));
    }
    public static boolean isNumeric(String str){
    	if (str.equals("N/A"))
    		return true;
  	  for (int i = str.length();--i>=0;){    
  	   if (!Character.isDigit(str.charAt(i))){  
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
    public static int calculateAge(String dateOfBirth) {
        try {
            LocalDate dob = LocalDate.parse(dateOfBirth);
            LocalDate currentDate = LocalDate.now();
            if ((dob != null) && (dob.isBefore(currentDate))) {
                return Period.between(dob, currentDate).getYears();
            } else {
                System.out.println("Invalid date of birth.");
                return -1; // or throw an exception based on your requirements
            }
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please use the format: yyyy-MM-dd");
            return -1;} // or throw an exception based on your requirements
        }
    public static boolean isValidNumber(String input) {
        return input.matches("\\d+(\\.\\d)?");
    }
    private static void sure() {
    	String dialogue = "Are you Sure to exit?";
    	int select = JOptionPane.showConfirmDialog(null, dialogue,"Exit?",JOptionPane.YES_NO_OPTION);
    	if (select == 0) 
    		System.exit(0);
    }

    /**
     * @wbp.parser.entryPoint
     */
    
    public MainWindow() {
    	
        JFrame frame = new JFrame("Main Window");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
        	@Override
        	public void windowClosing(WindowEvent e) {
        		sure();
        	}
        });
        frame.setSize(950, 400);
        frame.getContentPane().setLayout(null);
        
        // 设置绝对布局

        // 创建表格
        String[] columnNames = {"ID", "First Name","Last Name", "Phone Number", "E-Mail Address","Member Level","Date of Birth","Loyalty Points","Age","Rent History","Free Movie"};
        tableModel = new DefaultTableModel(columnNames, 0);
        memberTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(memberTable);
        scrollPane.setBackground(Color.WHITE);
        scrollPane.setBounds(50, 50, 852, 200); 
        frame.getContentPane().add(scrollPane);
     // 设置所有列的宽度F
        javax.swing.table.TableColumnModel columnModel = memberTable.getColumnModel();
        int columnCount = memberTable.getColumnCount();
  
        int width = 1000;
        for (int i = 0; i < columnCount; i++) {
            columnModel.getColumn(i).setPreferredWidth(width);
        }

        // 创建按钮
        
        JTextField searchField = new JTextField();
        searchField.setBounds(400, 323, 200, 30);
        frame.getContentPane().add(searchField);

        JButton searchButton = new JButton("Search Member");
        searchButton.setBounds(620, 323, 130, 30);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchTerm = searchField.getText();
                if (!searchTerm.isEmpty()) {
                    searchMember(searchTerm);
                }
            }
        });
        frame.getContentPane().add(searchButton);
       
        
        JButton changePasswordButton = new JButton("Change Password");
        changePasswordButton.setBounds(590, 10, 150, 30);
        changePasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new ChangePassword();
            }
        });
        frame.getContentPane().add(changePasswordButton);
        JButton addAdminButton = new JButton("Add Admin");
        addAdminButton.setBounds(734, 10, 168, 30);
        addAdminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddAdmin();
            }
        });
        frame.getContentPane().add(addAdminButton);

        JButton addMemberButton = new JButton("Add Member");
        addMemberButton.setBounds(50, 323, 120, 30);
        addMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = null ;
                boolean validId = false;
                boolean validPhone = false;
                boolean vaildEmail = false;
                boolean vaildlevel = false;
                boolean vailddob = false;
                boolean vaildselect = false;
                boolean vaildfree = false;
                String dob = null;
                String LP= null;
                String Phone = null;
                String EMail = null;
                String MemberLevel = null;
                String free = null;
                String history = "null";
                while (!validId) {
                    id = JOptionPane.showInputDialog("Enter ID:");
                    if (!isNumeric(id)) {
                        JOptionPane.showMessageDialog(null, "ID should contain only digits. Please try again.");
                    } else {
                        validId = true;
                        for (int i = 0; i < tableModel.getRowCount(); i++) {
                            if (tableModel.getValueAt(i, 0).equals(id)) {
                                JOptionPane.showMessageDialog(null, "ID already exists. Please enter a different ID.");
                                validId = false;
                                break;
                            }
                        }
                    }
                }

                String firstName = JOptionPane.showInputDialog("Enter First Name:");
                String LastName = JOptionPane.showInputDialog("Enter Last Name:");
                while (!validPhone) {
                Phone = JOptionPane.showInputDialog("Enter Phone Number:");
                if (!isNumeric(Phone)) {
                	JOptionPane.showMessageDialog(null, "Phone number should contain only digits. Please try again.");
                }
                else
                	validPhone = true;
                }
                while (!vaildEmail) {
                EMail = JOptionPane.showInputDialog("Enter E-Mail Address:");
                if (EMail.contains("@")&&EMail.contains("."))
                	vaildEmail = true;
                else
                	JOptionPane.showMessageDialog(null, "Email should contain\" @\" and \".\". Please try again.");
                }
                while(!vaildlevel) {
                MemberLevel = JOptionPane.showInputDialog("MemberLevel(hit enter for Regular):");
                if (MemberLevel.isEmpty()) {
                	MemberLevel = "Regular";
                	vaildlevel = true;
                }
                if (MemberLevel.toLowerCase().equals("regular") ||MemberLevel.toLowerCase().equals("sliver")||MemberLevel.toLowerCase().equals("gold")){
                if (MemberLevel.toLowerCase().equals("regular")) {
                	MemberLevel = "Regular";
                	vaildlevel = true;
                }
                if (MemberLevel.toLowerCase().equals("sliver")) {
                	MemberLevel = "Sliver";
                	vaildlevel = true;
                }
                if (MemberLevel.toLowerCase().equals("gold")) {
                	MemberLevel = "Gold";
                	vaildlevel = true;
                }}
                else
                	JOptionPane.showMessageDialog(null, "Not a vaild member level. Regular, Silver or Gold Only!");
                               }
                while (!vailddob) {
                	String temp = JOptionPane.showInputDialog("Enter Date Of Birth(yyyy-mm-dd):");
                	if (isDateValid(temp)) {
                		vailddob = true;
                		dob = temp;}
                	else
                		JOptionPane.showMessageDialog(null, "Not a vaild date of birth (yyyy-mm-dd)");
                }
                if (!MemberLevel.equals("Regular")) {
                int select = JOptionPane.showConfirmDialog(null, "Do You want to give loyalty points or free movie to this customer\n(loyalty points and free movie will give automatically when customer rent a movie.)?","Warning!!!",JOptionPane.YES_NO_OPTION);
                if (select == 0) {
                	while (!vaildselect) {
                	LP = JOptionPane.showInputDialog("Enter loyalty points:");
                	if (isNumeric(LP)) 
                		vaildselect = true;
                	else
                		JOptionPane.showInputDialog("Digit only！");
                	}
                	while (!vaildfree&&MemberLevel.equals("Gold")) {
                    	free = JOptionPane.showInputDialog("Enter the progress of free movie(e.g. 1.6, 2):");
                    	if (isValidNumber(free)) 
                    		vaildfree = true;
                    	else
                    		JOptionPane.showMessageDialog(null, "Number only！");
                    	}
                	}
                else {
                	LP = "0";
                	free = "0";
                }
                	}
                // 以此类推，获取其他成员信息
                int age1 = calculateAge(dob);
                String age = age1+"";
                // 添加到表格中
                String LPS;
                if (MemberLevel.equals("Regular"))
                	LPS = "N/A";
                else
                	LPS = LP+"";
                String[] newMember = {id, firstName,LastName,Phone,EMail,MemberLevel,dob,LPS,age,history,free};
                tableModel.addRow(newMember);
                // 保存数据到文件
                saveDataToFile();
            }
        });
        frame.getContentPane().add(addMemberButton);

        JButton deleteMemberButton = new JButton("Delete Member");
        deleteMemberButton.setBounds(776, 260, 150, 30);
        frame.getContentPane().add(deleteMemberButton);
        deleteMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = memberTable.getSelectedRow();
                if (selectedRow != -1) {
                    int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this member?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        tableModel.removeRow(selectedRow);
                        // 保存数据到文件
                        saveDataToFile();
                    }
                }
            }
        });
        JButton resetButton = new JButton("Reset Search");
        resetButton.setBounds(760, 323, 130, 30);
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetSearch();
                searchField.setText("");
            }
        });
        frame.getContentPane().add(resetButton);
        
        

        MainWindow mainWinRef = this; // 保存 MainWindow 的引用
        int selectedRow = memberTable.getSelectedRow(); // 保存选定的行号
        
        JButton editMemberButton = new JButton("Update Member");
        editMemberButton.setBounds(213, 270, 150, 43);
        editMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	int selectedRow = memberTable.getSelectedRow();
                if (selectedRow != -1) {
                	
                    String id = tableModel.getValueAt(selectedRow, 0).toString();
                    String firstName = tableModel.getValueAt(selectedRow, 1).toString();
                    String lastName = tableModel.getValueAt(selectedRow, 2).toString();
                    String phoneNumber = tableModel.getValueAt(selectedRow, 3).toString();
                    String email = tableModel.getValueAt(selectedRow, 4).toString();
                    String memberLevel = tableModel.getValueAt(selectedRow, 5).toString();
                    String dob = tableModel.getValueAt(selectedRow, 6).toString();
                    String loyaltyPoints = tableModel.getValueAt(selectedRow, 7).toString();
                    String age = tableModel.getValueAt(selectedRow, 8).toString();
                    String rentHistory = tableModel.getValueAt(selectedRow, 9).toString();
                    String freeMovie = tableModel.getValueAt(selectedRow, 10).toString();
                        new EditMemberDetails(mainWinRef, selectedRow, id, firstName, lastName, phoneNumber, email, memberLevel, dob,
                                loyaltyPoints, age, rentHistory, freeMovie);
                }
              

            }
        });
        frame.getContentPane().add(editMemberButton);

        JButton showMemberButton = new JButton("Show Member Detials");
        showMemberButton.addActionListener(new ActionListener() {

        	public void actionPerformed(ActionEvent e) {
        		 int selectedRow = memberTable.getSelectedRow();
        	        if (selectedRow != -1) {
        	            String id = memberTable.getValueAt(selectedRow, 0).toString();
        	            String firstName = memberTable.getValueAt(selectedRow, 1).toString();
        	            String lastName = memberTable.getValueAt(selectedRow, 2).toString();
        	            String phoneNumber = memberTable.getValueAt(selectedRow, 3).toString();
        	            String email = memberTable.getValueAt(selectedRow, 4).toString();
        	            String memberLevel = memberTable.getValueAt(selectedRow, 5).toString();
        	            String dob = memberTable.getValueAt(selectedRow, 6).toString();
        	            String loyaltyPoints = memberTable.getValueAt(selectedRow, 7).toString();
        	            String age = memberTable.getValueAt(selectedRow, 8).toString();
        	            String rentHistory = memberTable.getValueAt(selectedRow, 9).toString();
        	            String freeMovie = memberTable.getValueAt(selectedRow, 10).toString();
        	                    new ViewMemberDetails(id, firstName, lastName, phoneNumber, email, memberLevel, dob,
        	                            loyaltyPoints, age, rentHistory, freeMovie);
        	            
        	        }
        	    
            }
        });
        showMemberButton.setFont(UIManager.getFont("Button.font"));
        showMemberButton.setBounds(35, 270, 168, 43);
        frame.getContentPane().add(showMemberButton);
        
        JButton RentMovieButton = new JButton("Rent Movie");
        RentMovieButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		        int selectedRow = memberTable.getSelectedRow();
        		        if (selectedRow != -1) {
        		            String memberLevel = tableModel.getValueAt(selectedRow, 5).toString();
        		            String movieName = JOptionPane.showInputDialog("Enter the movie name:");
        		            String priceString = JOptionPane.showInputDialog("Enter the movie price:");
        		            double price = Double.parseDouble(priceString);

        		            if (memberLevel.equalsIgnoreCase("Silver")) {
        		                price *= 0.9; // 10% discount for Silver
        		                int currentLoyaltyPoints = Integer.parseInt(tableModel.getValueAt(selectedRow, 7).toString());
        		                tableModel.setValueAt(Integer.toString(currentLoyaltyPoints + 1), selectedRow, 7);
        		            } else if (memberLevel.equalsIgnoreCase("Gold")) {
        		            	boolean use = false;
        		                double freeMovie = Double.parseDouble(tableModel.getValueAt(selectedRow, 10).toString());
        		                if (freeMovie >= 1) {
        		                    int useFreeMovie = JOptionPane.showConfirmDialog(null, "You have free movie available. Do you want to use it?", "Use Free Movie", JOptionPane.YES_NO_OPTION);
        		                    if (useFreeMovie == JOptionPane.YES_OPTION) {
        		                        freeMovie -= 1;
        		                        tableModel.setValueAt(Double.toString(freeMovie), selectedRow, 10);
        		                        use = true;
        		                    }
        		                }
        		                if (!use){
        		                price *= 0.85; // 15% discount for Gold
        		                int currentLoyaltyPoints = Integer.parseInt(tableModel.getValueAt(selectedRow, 7).toString());
        		                tableModel.setValueAt(Integer.toString(currentLoyaltyPoints + 2), selectedRow, 7);
        		                freeMovie += 0.2;
        		                tableModel.setValueAt(Double.toString(freeMovie), selectedRow, 10);}
        		            }

        		            int confirmed = JOptionPane.showConfirmDialog(null, "The total price is: " + price + "NZD. Pay now?", "Confirmation", JOptionPane.YES_NO_OPTION);
        		            if (confirmed == JOptionPane.YES_OPTION) {
        		                String rentHistory = tableModel.getValueAt(selectedRow, 9).toString();
        		                if (rentHistory.equals("null")) {
        		                    rentHistory = "<<"+movieName+">>";
        		                } else {
        		                    rentHistory += "<< " + movieName+">>";
        		                }
        		                tableModel.setValueAt(rentHistory, selectedRow, 9);
        
        		                saveDataToFile();
        		            }
        		        } else {
        		            JOptionPane.showMessageDialog(null, "Please select a member to rent a movie.");
        		        }
        		    }
        		});

        RentMovieButton.setBounds(197, 323, 120, 30);
        frame.getContentPane().add(RentMovieButton);
        
        JLabel lblNewLabel = new JLabel("Membership Mangement System");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(50, 10, 674, 30);
        frame.getContentPane().add(lblNewLabel);
        
        JButton editMemberButton_1 = new JButton("Refresh");
        editMemberButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		MainWindow.this.refreshTable();
        	}
        });
        editMemberButton_1.setBounds(373, 270, 150, 43);
        frame.getContentPane().add(editMemberButton_1);

        // 读取文本文件并显示在表格中
        loadMemberData();

        frame.setVisible(true);
    }

    void loadMemberData() {
        File file = new File("C:\\JAVA\\UNITEC\\Assignment\\src\\members.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                tableModel.addRow(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void saveDataToFile() {
        File file = new File("C:\\JAVA\\UNITEC\\Assignment\\src\\members.txt");

        try (FileWriter writer = new FileWriter(file)) {
            for (int row = 0; row < tableModel.getRowCount(); row++) {
                for (int col = 0; col < tableModel.getColumnCount(); col++) {
                    writer.write(tableModel.getValueAt(row, col) + ",");
                }
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void refreshTable() {
        tableModel.setRowCount(0); // 清空原有数据
        loadMemberData(); // 重新加载数据
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainWindow());
        
    }
}
