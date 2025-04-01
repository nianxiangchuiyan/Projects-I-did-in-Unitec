package pptgen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.TransferHandler;
import javax.swing.TransferHandler.TransferSupport;

import java.awt.Font;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
public class fenbieshangchuan {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	ArrayList<String> uploadedImagePaths;
	private Map<JLabel, String> labelToImagePathMap;
	private JTextField textField;
	private JTextField textField_1;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fenbieshangchuan window = new fenbieshangchuan();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public fenbieshangchuan() {
		
		initialize();
		
	}
    private void updateUploadedImagePaths() {
        uploadedImagePaths.clear();
        for (JLabel label : labelToImagePathMap.keySet()) {
            String imagePath = labelToImagePathMap.get(label);
            uploadedImagePaths.add(imagePath);
        }
    }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		uploadedImagePaths = new ArrayList<>();
		labelToImagePathMap = new LinkedHashMap<>();
		frame = new JFrame();
		frame.setBounds(150, 0, 1151, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("正面微笑");
		lblNewLabel.setBounds(10, 33, 161, 42);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 24));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("正面自然");
		lblNewLabel_1.setBounds(220, 33, 161, 42);
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 24));
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("侧位90°");
		lblNewLabel_2.setBounds(454, 33, 161, 42);
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 24));
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("扫描右侧位");
		lblNewLabel_3.setBounds(672, 33, 161, 42);
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 24));
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("扫描正位");
		lblNewLabel_4.setBounds(910, 33, 161, 42);
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 24));
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("扫描左侧位");
		lblNewLabel_5.setBounds(10, 233, 161, 42);
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 24));
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("扫描上颌");
		lblNewLabel_6.setBounds(220, 233, 161, 42);
		lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 24));
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("扫描下颌");
		lblNewLabel_7.setBounds(454, 233, 161, 42);
		lblNewLabel_7.setFont(new Font("宋体", Font.PLAIN, 24));
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("扫描全口");
		lblNewLabel_8.setBounds(672, 233, 161, 42);
		lblNewLabel_8.setFont(new Font("宋体", Font.PLAIN, 24));
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_8_1 = new JLabel("曲面断层片");
		lblNewLabel_8_1.setBounds(910, 233, 161, 42);
		lblNewLabel_8_1.setFont(new Font("宋体", Font.PLAIN, 24));
		frame.getContentPane().add(lblNewLabel_8_1);
		
		JLabel lblNewLabel_8_2 = new JLabel("头颅侧位片");
		lblNewLabel_8_2.setBounds(10, 433, 161, 42);
		lblNewLabel_8_2.setFont(new Font("宋体", Font.PLAIN, 24));
		frame.getContentPane().add(lblNewLabel_8_2);
		
		JLabel lblNewLabel_8_3 = new JLabel("头颅测量分析");
		lblNewLabel_8_3.setBounds(230, 433, 161, 42);
		lblNewLabel_8_3.setFont(new Font("宋体", Font.PLAIN, 24));
		frame.getContentPane().add(lblNewLabel_8_3);
		
		JLabel lblNewLabel_8_4 = new JLabel("测量数据分析");
		lblNewLabel_8_4.setBounds(454, 433, 161, 42);
		lblNewLabel_8_4.setFont(new Font("宋体", Font.PLAIN, 24));
		frame.getContentPane().add(lblNewLabel_8_4);
        
        JLabel PatientName = new JLabel("患者姓名：");
        PatientName.setFont(new Font("宋体", Font.PLAIN, 24));
        PatientName.setBounds(146, 684, 150, 42);
        frame.getContentPane().add(PatientName);
        
        textField = new JTextField();
        textField.setFont(new Font("宋体", Font.PLAIN, 40));
        textField.setColumns(10);
        textField.setBounds(259, 684, 161, 42);
        frame.getContentPane().add(textField);

        JLabel doctorname = new JLabel("医师姓名：");
        doctorname.setFont(new Font("宋体", Font.PLAIN, 24));
        doctorname.setBounds(527, 684, 150, 42);
        frame.getContentPane().add(doctorname);
        
        textField_1 = new JTextField();
        textField_1.setEnabled(false);
        textField_1.setEditable(false);
        textField_1.setText("闫恩霞：13269377626");
        textField_1.setFont(new Font("宋体", Font.PLAIN, 27));
        textField_1.setColumns(10);
        textField_1.setBounds(640, 684, 271, 42);
        frame.getContentPane().add(textField_1);
        
		JButton btnNewButton = new JButton("保存");
		btnNewButton.setBounds(310, 750, 93, 40);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveImages();
				frame.dispose();
			}
		});
		
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.setBackground(new Color(255, 128, 0));
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();	
			}
		});
		btnNewButton_1.setBounds(619, 750, 93, 40);
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_1.setBackground(new Color(128, 128, 255));
		frame.getContentPane().add(btnNewButton_1);
		

		JLabel lblNewLabel_9 = new JLabel("拖放文件到这里上传");
		lblNewLabel_9.setBounds(10, 85, 124, 138);
		lblNewLabel_9.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.getContentPane().add(lblNewLabel_9);

		
		JLabel lblNewLabel_9_1 = new JLabel("拖放文件到这里上传");
		lblNewLabel_9_1.setBounds(230, 85, 126, 138);
		lblNewLabel_9_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.getContentPane().add(lblNewLabel_9_1);
		
		JLabel lblNewLabel_9_2 = new JLabel("拖放文件到这里上传");
		lblNewLabel_9_2.setBounds(454, 85, 126, 138);
		lblNewLabel_9_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.getContentPane().add(lblNewLabel_9_2);
		
		JLabel lblNewLabel_9_3 = new JLabel("拖放文件到这里上传");
		lblNewLabel_9_3.setBounds(678, 85, 126, 138);
		lblNewLabel_9_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.getContentPane().add(lblNewLabel_9_3);
		
		JLabel lblNewLabel_9_4 = new JLabel("拖放文件到这里上传");
		lblNewLabel_9_4.setBounds(454, 285, 126, 138);
		lblNewLabel_9_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.getContentPane().add(lblNewLabel_9_4);
		
		JLabel lblNewLabel_9_5 = new JLabel("拖放文件到这里上传");
		lblNewLabel_9_5.setBounds(230, 285, 126, 138);
		lblNewLabel_9_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.getContentPane().add(lblNewLabel_9_5);
		
		JLabel lblNewLabel_9_6 = new JLabel("拖放文件到这里上传");
		lblNewLabel_9_6.setBounds(10, 285, 126, 138);
		lblNewLabel_9_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.getContentPane().add(lblNewLabel_9_6);
		
		JLabel lblNewLabel_9_7 = new JLabel("拖放文件到这里上传");
		lblNewLabel_9_7.setBounds(910, 85, 124, 138);
		lblNewLabel_9_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.getContentPane().add(lblNewLabel_9_7);
		
		JLabel lblNewLabel_9_8 = new JLabel("拖放文件到这里上传");
		lblNewLabel_9_8.setBounds(680, 285, 124, 138);
		lblNewLabel_9_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.getContentPane().add(lblNewLabel_9_8);
		
		JLabel lblNewLabel_9_9 = new JLabel("拖放文件到这里上传");
		lblNewLabel_9_9.setBounds(908, 285, 126, 138);
		lblNewLabel_9_9.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.getContentPane().add(lblNewLabel_9_9);
		
		JLabel lblNewLabel_9_10 = new JLabel("拖放文件到这里上传");
		lblNewLabel_9_10.setBounds(10, 473, 126, 138);
		lblNewLabel_9_10.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.getContentPane().add(lblNewLabel_9_10);
		
		JLabel lblNewLabel_9_11 = new JLabel("拖放文件到这里上传");
		lblNewLabel_9_11.setBounds(230, 473, 126, 138);
		lblNewLabel_9_11.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.getContentPane().add(lblNewLabel_9_11);
		
		JLabel lblNewLabel_9_12 = new JLabel("拖放文件到这里上传");
		lblNewLabel_9_12.setBounds(454, 473, 126, 138);
		lblNewLabel_9_12.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.getContentPane().add(lblNewLabel_9_12);
		
		JLabel lblNewLabel_9_13 = new JLabel("拖放文件到这里上传");
        lblNewLabel_9_13.setOpaque(true);
        lblNewLabel_9_13.setBorder(new LineBorder(new Color(0, 0, 0)));
        lblNewLabel_9_13.setBackground(Color.WHITE);
        lblNewLabel_9_13.setBounds(680, 473, 124, 138);
        frame.getContentPane().add(lblNewLabel_9_13);
        
        JLabel lblNewLabel_9_14 = new JLabel("拖放文件到这里上传");
        lblNewLabel_9_14.setOpaque(true);
        lblNewLabel_9_14.setBorder(new LineBorder(new Color(0, 0, 0)));
        lblNewLabel_9_14.setBackground(Color.WHITE);
        lblNewLabel_9_14.setBounds(910, 473, 124, 138);
        frame.getContentPane().add(lblNewLabel_9_14);
        
        JLabel lblNewLabel_8_4_1 = new JLabel("牙弓CBCT分析上颌");
        lblNewLabel_8_4_1.setFont(new Font("宋体", Font.PLAIN, 24));
        lblNewLabel_8_4_1.setBounds(640, 433, 193, 42);
        frame.getContentPane().add(lblNewLabel_8_4_1);
        
        JLabel lblNewLabel_8_4_2 = new JLabel("牙弓CBCT分析下颌");
        lblNewLabel_8_4_2.setFont(new Font("宋体", Font.PLAIN, 24));
        lblNewLabel_8_4_2.setBounds(878, 433, 193, 42);
        frame.getContentPane().add(lblNewLabel_8_4_2);

        
        addUploadFunctionality(lblNewLabel_9);
        addUploadFunctionality(lblNewLabel_9_1);
        addUploadFunctionality(lblNewLabel_9_2);
        addUploadFunctionality(lblNewLabel_9_3);
        addUploadFunctionality(lblNewLabel_9_4);
        addUploadFunctionality(lblNewLabel_9_5);
        addUploadFunctionality(lblNewLabel_9_6);
        addUploadFunctionality(lblNewLabel_9_7);
        addUploadFunctionality(lblNewLabel_9_8);
        addUploadFunctionality(lblNewLabel_9_9);
        addUploadFunctionality(lblNewLabel_9_10);
        addUploadFunctionality(lblNewLabel_9_11);
        addUploadFunctionality(lblNewLabel_9_12);
        addUploadFunctionality(lblNewLabel_9_13);
        addUploadFunctionality(lblNewLabel_9_14);
        

        
        
        
	}
    private void saveImages() {
    	File imagesaveDirectory = new File("C:/患者信息/" + textField.getText()+ "/图片");
    	imagesaveDirectory.mkdirs();
        String desktopPath = "C:/患者信息/" + textField.getText()+ "/图片/"; // Get desktop path

        for (int i = 0; i < uploadedImagePaths.size(); i++) {
            String imagePath = uploadedImagePaths.get(i);
            File source = new File(imagePath);
            String fileName = ".jpg";
            switch(i) {
            case 0 :	fileName = "正面微笑.jpg";break;
            case 1 :	fileName = "正面自然.jpg";break;
            case 2 :	fileName = "侧位90°.jpg";break;
            case 3 :	fileName = "扫描右侧位.jpg";break;
            case 4 :	fileName = "扫描正位.jpg";break;
            case 5 :	fileName = "扫描左侧位.jpg";break;
            case 6 :	fileName = "扫描上颌.jpg";break;
            case 7 :	fileName = "扫描下颌.jpg";break;
            case 8 :	fileName = "扫描全口.jpg";break;
            case 9 :	fileName = "曲面断层片.jpg";break;
            case 10 :	fileName = "头颅侧位片.jpg";break;
            case 11:	fileName = "头颅测量分析.jpg";break;
            case 12:	fileName = "测量数据分析.jpg";break;
            case 13:	fileName = "牙弓CBCT分析上颌.jpg";break;
            case 14:	fileName = "牙弓CBCT分析下颌.jpg";break;
            }
           // String fileName = "image_" + (i + 1) + ".jpg"; // Example: image_1.jpg, image_2.jpg, ...
            File destination = new File(desktopPath + fileName);
            try {
                Files.copy(source.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(i>=3&&i<9){
            try {
                BufferedImage image = ImageIO.read(source);
                BufferedImage croppedImage = cropWhiteBorders(image);
                ImageIO.write(croppedImage, "jpg", destination);
            } catch (IOException e) {
                e.printStackTrace();
            }}
        }

        
        pptgen.gen(textField.getText());
        JOptionPane.showMessageDialog(frame, "已保存图片C:/患者信息/" + textField.getText() + "/图片中");
        JOptionPane.showMessageDialog(frame, "PPT已生成在C:/患者信息/");
        
    }

    // Method to add upload file functionality to a JLabel
    private void addUploadFunctionality(JLabel label) {
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Open file chooser dialog
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    // Handle the file selection in a background thread
                    new SwingWorker<Void, Void>() {
                        @Override
                        protected Void doInBackground() throws Exception {
                            // Simulate a long-running task (e.g., file processing)
                            Thread.sleep(1000);
                            return null;
                        }

                        @Override
                        protected void done() {
                            label.setText(selectedFile.getAbsolutePath());
                            labelToImagePathMap.put(label, selectedFile.getAbsolutePath());
                            updateUploadedImagePaths();
                        }
                    }.execute();
                }
            }
        });

        // Set label properties for drag and drop
        label.setTransferHandler(new TransferHandler() {
            @Override
            public boolean canImport(TransferHandler.TransferSupport support) {
                return support.isDataFlavorSupported(DataFlavor.javaFileListFlavor);
            }

            @Override
            public boolean importData(TransferHandler.TransferSupport support) {
                if (!canImport(support)) {
                    return false;
                }

                Transferable transferable = support.getTransferable();
                try {
                    @SuppressWarnings("unchecked")
                    List<File> files = (List<File>) transferable.getTransferData(DataFlavor.javaFileListFlavor);
                    if (files.size() > 0) {
                        File file = files.get(files.size()-1); // Assuming only one file is dragged and dropped
                        new SwingWorker<Void, Void>() {
                            @Override
                            protected Void doInBackground() throws Exception {
                                // Simulate a long-running task (e.g., file processing)
                                Thread.sleep(100);
                                return null;
                            }

                            @Override
                            protected void done() {
                                label.setText("已拖入");
                                Color green = new Color(128, 255, 0);
                                label.setBackground(green);
                                uploadedImagePaths.add(file.getAbsolutePath());
                                labelToImagePathMap.put(label, file.getAbsolutePath());
                                updateUploadedImagePaths();
                            }
                        }.execute();
                        return true;
                    }
                } catch (UnsupportedFlavorException | IOException e) {
                    e.printStackTrace();
                }
                return false;
            }
        });
        
        label.setOpaque(true);
        label.setBackground(Color.WHITE);
        label.setBorder(new LineBorder(Color.BLACK));
        

    }
    private BufferedImage cropWhiteBorders(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        int top = 0;
        int left = 0;
        int right = width - 1;
        int bottom = height - 1;

        topLoop:
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (image.getRGB(x, y) != Color.WHITE.getRGB()) {
                    top = y;
                    break topLoop;
                }
            }
        }

        bottomLoop:
        for (int y = height - 1; y >= 0; y--) {
            for (int x = 0; x < width; x++) {
                if (image.getRGB(x, y) != Color.WHITE.getRGB()) {
                    bottom = y;
                    break bottomLoop;
                }
            }
        }

        leftLoop:
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (image.getRGB(x, y) != Color.WHITE.getRGB()) {
                    left = x;
                    break leftLoop;
                }
            }
        }

        rightLoop:
        for (int x = width - 1; x >= 0; x--) {
            for (int y = 0; y < height; y++) {
                if (image.getRGB(x, y) != Color.WHITE.getRGB()) {
                    right = x;
                    break rightLoop;
                }
            }
        }

        int newWidth = right - left + 1;
        int newHeight = bottom - top + 1;

        BufferedImage croppedImage = new BufferedImage(newWidth, newHeight, image.getType());
        for (int y = 0; y < newHeight; y++) {
            for (int x = 0; x < newWidth; x++) {
                croppedImage.setRGB(x, y, image.getRGB(x + left, y + top));
            }
        }

        return croppedImage;
    }
}