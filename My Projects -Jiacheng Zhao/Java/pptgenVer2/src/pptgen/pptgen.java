package pptgen;

import org.apache.poi.sl.usermodel.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.apache.poi.sl.usermodel.TextParagraph.TextAlign;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xddf.usermodel.chart.Shape;
import org.apache.poi.xslf.usermodel.*;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.*;


public class pptgen extends fenbieshangchuan {
public static void gen(String name){
	IOUtils.setByteArrayMaxOverride(300000000);
	String pname = name;
	String doctor= "闫恩霞：13269377626";
    // 创建一个新的PPT文档

    XMLSlideShow ppt = new XMLSlideShow();
    ppt.setPageSize(new Dimension(1600,900));
    // 获取幻灯片尺寸
    Dimension pageSize = ppt.getPageSize();
    //addWatermark(ppt, "C:/患者信息/别动我/logo.tif");
    // 添加前两页幻灯片和内容...
    String[] titles = {
            pname+"矫正报告",
            "临床诊断分析及个性化矫正方案",
        };
    for (int i = 0; i < titles.length; i++) {
        // 添加第一个新的幻灯片
        XSLFSlide slide = ppt.createSlide();
        
     // 添加文本框并设置标题
        XSLFTextBox textBox = slide.createTextBox();
        XSLFTextParagraph paragraph = textBox.addNewTextParagraph();
        XSLFTextRun textRun = paragraph.addNewTextRun();
        textRun.setText(titles[i]);
        textRun.setFontFamily("SimSun");
        if (i==0) {
        int textBoxWidth = 750; // 文本框宽度
        int textBoxHeight = 150; // 文本框高度
        int x = (pageSize.width - textBoxWidth) / 2; // 居中位置
        int y = (pageSize.height - textBoxHeight) / 2; // 居中位置
        textBox.setAnchor(new Rectangle(x, y, textBoxWidth, textBoxHeight));

        // 设置文本框中的文本居中对齐
        textBox.setTextAutofit(TextShape.TextAutofit.NORMAL); // 设置文本自适应模式
        //textBox.setTextVerticalAlignment(VerticalAlignment.MIDDLE); // 设置文本垂直对齐方式
        //textBox.setTextHorizontalAlignment(HorizontalAlignment.CENTER); // 设置文本水平对齐方式


        // 设置字体大小
        textRun.setFontSize(100.0);
        textRun.setFontFamily("SimSun");
        }
        if (i == 0) {
        	XSLFTextBox textBoxdoc = slide.createTextBox();
            XSLFTextParagraph paragraphdoc = textBoxdoc.addNewTextParagraph();
            XSLFTextRun textRundoc = paragraphdoc.addNewTextRun();
            textRundoc.setText(doctor);

            int textBoxWidthdoc = 500; // 文本框宽度
            int textBoxHeightdoc = 70; // 文本框高度
            int xdoc = (900); // 居中位置
            int ydoc = (600); // 居中位置
            textBoxdoc.setAnchor(new Rectangle(xdoc, ydoc, textBoxWidthdoc, textBoxHeightdoc));
            // 设置字体大小
            textRundoc.setFontSize(48.0);
        }
        if (i == 1) {
        	int textBoxWidth = 1150; // 文本框宽度
            int textBoxHeight = 150; // 文本框高度
            int x = (pageSize.width - textBoxWidth) / 2; // 居中位置
            int y = (pageSize.height - textBoxHeight) / 2; // 居中位置
            textBox.setAnchor(new Rectangle(x, y, textBoxWidth, textBoxHeight));

            // 设置文本框中的文本居中对齐
            textBox.setTextAutofit(TextShape.TextAutofit.NORMAL); // 设置文本自适应模式
            //textBox.setTextVerticalAlignment(VerticalAlignment.MIDDLE); // 设置文本垂直对齐方式
            //textBox.setTextHorizontalAlignment(HorizontalAlignment.CENTER); // 设置文本水平对齐方式


            // 设置字体大小
            textRun.setFontSize(80.0);
        }
        // 添加图像框
        addpicc(slide, "C:/患者信息/别动我/logo.tif", 51.76, 0, 4.69, 4.69);
    }
    
    // 添加第三页起的幻灯片和内容...
    String[] titless = {
            "   一、患者信息",
            "   二、临床检查",
            "正面微笑像",
            "侧面像",
            "   三、口内检查",
            "口内像",
            "数字化模型",
            "   四、X线检查",
            "颞颌关节",
            "头颅测量分析",
            "头颅测量结果",
            "生长发育分析",
            "气道分析",
            "牙弓CBCT分析",
            "恒牙CBCT分析",
            "   五、诊断结果",
            "   六、问题列表",
            "   七、矫正目标",
            "矫正方案一（弹性功能矫正)",
            "弹性功能矫正器",
            "  矫正方案二（功能矫正）",
            "功能性矫正器",
            "  矫正方案三（固定矫正）",
            " 固定矫正器",
            "矫正方案四（隐形矫正）",
            " 隐形矫正器",
            "   各种方案的主要区别",
            "				汇报完毕，\n若有疑问联系我们。谢谢！\n",
            "","","","","","","","","","","","",

        };
    for (int i = 0; i < titless.length; i++) {
        // 添加一个新的幻灯片
        XSLFSlide slide = ppt.createSlide();

     // 添加文本框并设置标题
        XSLFTextBox textBox = slide.createTextBox();
        XSLFTextParagraph paragraph = textBox.addNewTextParagraph();
        XSLFTextRun textRun = paragraph.addNewTextRun();
        textRun.setText(titless[i]);
        textRun.setFontFamily("SimSun");
        int textBoxWidth=0;
        // 设置文本框位置和大小
        if (i ==0||i ==1||i ==4||i ==7||i ==15||i ==16||i ==17|| i == 27||(i>=17 && i<27)) {
        	if(i==21||i==23||i==25)
        	{textBoxWidth = 500;}
        	else if (i==19)
        		textBoxWidth = 600;
        	else if (i >18&&i <27) { textBoxWidth = 900;}
        	 else if(i==18) {
        		 textBoxWidth = 1000;}
            
            else
        textBoxWidth = 700; // 文本框宽度
        
        int textBoxHeight = 150; // 文本框高度
        int x = (pageSize.width - textBoxWidth) / 2; // 居中位置
        int y = 50;
        if(i==27)
        {textBoxWidth = 1100;
        x = (pageSize.width - textBoxWidth) / 2; // 居中位置
        y = 550;
        textBox.setAnchor(new Rectangle(x, y, textBoxWidth, textBoxHeight));
        textBox.setHorizontalCentered(true);
        textRun.setFontSize(80.0);
        textRun.setFontFamily("SimSun");}
          // 确保使用支持中文的字体
        
        else {
        textBox.setAnchor(new Rectangle(x, y, textBoxWidth, textBoxHeight));

        // 设置文本框中的文本居中对齐
        textBox.setTextAutofit(TextShape.TextAutofit.NORMAL); // 设置文本自适应模式
        //textBox.setTextVerticalAlignment(VerticalAlignment.MIDDLE); // 设置文本垂直对齐方式
        //textBox.setTextHorizontalAlignment(HorizontalAlignment.CENTER); // 设置文本水平对齐方式
        // 设置字体大小
       

        textRun.setFontSize(80.0);
        }
        }
        else{
        	textBoxWidth = 500; // 文本框宽度
	            int textBoxHeight = 150; // 文本框高度

	            int x = 150;
	            int y = 100;
	            textBox.setAnchor(new Rectangle(x, y, textBoxWidth, textBoxHeight));

	            // 设置文本框中的文本居中对齐
	            textBox.setTextAutofit(TextShape.TextAutofit.NORMAL); // 设置文本自适应模式
	            //textBox.setTextVerticalAlignment(VerticalAlignment.MIDDLE); // 设置文本垂直对齐方式
	            //textBox.setTextHorizontalAlignment(HorizontalAlignment.CENTER); // 设置文本水平对齐方式
	        // 设置字体大小
            textRun.setFontSize(60.0); }
        if (i== 0){//第一页人像+文本
        	addpicc(slide,"C:/患者信息/"+name+"/图片/正面微笑.jpg",35.30,10.6,15,19.42);
        	XSLFPictureData pic0 = null;
        	try {
    			pic0 = ppt.addPicture(new File("C:/患者信息/"+name+"/图片/正面微笑.jpg"), PictureData.PictureType.PNG);
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
            XSLFTextBox textBox1 = slide.createTextBox();
            XSLFTextParagraph paragraph1 = textBox1.addNewTextParagraph();
            XSLFTextRun textRun1 = paragraph1.addNewTextRun();
            textRun1.setText("姓名："+name+"       "
            		+ "性别： 男/女\n"
            		+ "年龄："
            		+ "\n"
            		+ "初诊日期："+getDate()+"\n"
            		+ "牙列：乳牙列，替牙列，恒牙列\n"
            		+ "主诉：\n"
            		+ "现病史：\n"
            		+ "既往史：\n"
            		+ "家族史：");
           textBox1.setAnchor(new Rectangle(100,280,730,610));
           textRun1.setFontSize(32.0);
           textRun1.setFontFamily("SimSun");
           paragraph1.setSpaceAfter((double) 18);
           paragraph1.setSpaceBefore((double) 18);
           setLineSpacing(textBox1, 160);
           addtextn(slide, 343, 360,361,60, "病历号：");
        }
        if(i == 1) {
        	XSLFPictureData pic01 = null;
        	try {
    			pic01 = ppt.addPicture(new File("C:/患者信息/"+name+"/图片/正面自然.jpg"), PictureData.PictureType.PNG);
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
            XSLFPictureShape picture = slide.createPicture(pic01);
            picture.setAnchor(new Rectangle(1000, 300, 425, 550));
            
         // 创建一个自动形状作为线条
            XSLFAutoShape lineShape = slide.createAutoShape();
            lineShape.setShapeType(org.apache.poi.sl.usermodel.ShapeType.LINE);

            // 设置线条的起点和终点坐标
            lineShape.setAnchor(new java.awt.Rectangle(1000, 400, 430, 0));

            // 设置线条的样式（颜色、粗细等）
            lineShape.setLineWidth(4);// 设置线条粗细
            lineShape.setLineColor(Color.CYAN); // 设置线条颜色

            // 将线条添加到幻灯片中
            
            //slide.addShape(lineShape);(未知原因，无需添加)
            // 创建一个自动形状作为线条
            XSLFAutoShape lineShape1 = slide.createAutoShape();
            lineShape1.setShapeType(org.apache.poi.sl.usermodel.ShapeType.LINE);

            // 设置线条的起点和终点坐标
            lineShape1.setAnchor(new java.awt.Rectangle(1000, 500, 430, 0));

            // 设置线条的样式（颜色、粗细等）
            lineShape1.setLineWidth(4);// 设置线条粗细
            lineShape1.setLineColor(Color.CYAN); // 设置线条颜色

            // 将线条添加到幻灯片中
            
            //slide.addShape(lineShape);(未知原因，无需添加)
            // 创建一个自动形状作为线条
            XSLFAutoShape lineShape2 = slide.createAutoShape();
            lineShape2.setShapeType(org.apache.poi.sl.usermodel.ShapeType.LINE);

            // 设置线条的起点和终点坐标
            lineShape2.setAnchor(new java.awt.Rectangle(1000, 600, 430, 0));

            // 设置线条的样式（颜色、粗细等）
            lineShape2.setLineWidth(4);// 设置线条粗细
            lineShape2.setLineColor(Color.CYAN); // 设置线条颜色

            // 将线条添加到幻灯片中
            
            //slide.addShape(lineShape);(未知原因，无需添加)
            // 创建一个自动形状作为线条
            XSLFAutoShape lineShape3 = slide.createAutoShape();
            lineShape3.setShapeType(org.apache.poi.sl.usermodel.ShapeType.LINE);

            // 设置线条的起点和终点坐标
            lineShape3.setAnchor(new java.awt.Rectangle(1000, 700, 430, 0));

            // 设置线条的样式（颜色、粗细等）
            lineShape3.setLineWidth(4);// 设置线条粗细
            lineShape3.setLineColor(Color.CYAN); // 设置线条颜色

            // 将线条添加到幻灯片中
            
            //slide.addShape(lineShape);(未知原因，无需添加)
            // 创建一个自动形状作为线条
            XSLFAutoShape lineShape4 = slide.createAutoShape();
            lineShape4.setShapeType(org.apache.poi.sl.usermodel.ShapeType.LINE);

            // 设置线条的起点和终点坐标
            lineShape4.setAnchor(new java.awt.Rectangle(1050, 300, 0, 550));

            // 设置线条的样式（颜色、粗细等）
            lineShape4.setLineWidth(4);// 设置线条粗细
            lineShape4.setLineColor(Color.YELLOW); // 设置线条颜色
            // 创建一个自动形状作为线条
            XSLFAutoShape lineShape5 = slide.createAutoShape();
            lineShape5.setShapeType(org.apache.poi.sl.usermodel.ShapeType.LINE);

            // 设置线条的起点和终点坐标
            lineShape5.setAnchor(new java.awt.Rectangle(1100, 300, 0, 550));

            // 设置线条的样式（颜色、粗细等）
            lineShape5.setLineWidth(4);// 设置线条粗细
            lineShape5.setLineColor(Color.YELLOW); // 设置线条颜色
            // 创建一个自动形状作为线条
            XSLFAutoShape lineShape6 = slide.createAutoShape();
            lineShape6.setShapeType(org.apache.poi.sl.usermodel.ShapeType.LINE);

            // 设置线条的起点和终点坐标
            lineShape6.setAnchor(new java.awt.Rectangle(1150, 300, 0, 550));

            // 设置线条的样式（颜色、粗细等）
            lineShape6.setLineWidth(4);// 设置线条粗细
            lineShape6.setLineColor(Color.YELLOW); // 设置线条颜色
            // 创建一个自动形状作为线条
            XSLFAutoShape lineShape7 = slide.createAutoShape();
            lineShape7.setShapeType(org.apache.poi.sl.usermodel.ShapeType.LINE);

            // 设置线条的起点和终点坐标
            lineShape7.setAnchor(new java.awt.Rectangle(1200, 300, 0, 550));

            // 设置线条的样式（颜色、粗细等）
            lineShape7.setLineWidth(4);// 设置线条粗细
            lineShape7.setLineColor(Color.red); // 设置线条颜色
            // 创建一个自动形状作为线条
            XSLFAutoShape lineShape8 = slide.createAutoShape();
            lineShape8.setShapeType(org.apache.poi.sl.usermodel.ShapeType.LINE);

            // 设置线条的起点和终点坐标
            lineShape8.setAnchor(new java.awt.Rectangle(1250, 300, 0, 550));

            // 设置线条的样式（颜色、粗细等）
            lineShape8.setLineWidth(4);// 设置线条粗细
            lineShape8.setLineColor(Color.YELLOW); // 设置线条颜色
            // 创建一个自动形状作为线条
            XSLFAutoShape lineShape9 = slide.createAutoShape();
            lineShape9.setShapeType(org.apache.poi.sl.usermodel.ShapeType.LINE);

            // 设置线条的起点和终点坐标
            lineShape9.setAnchor(new java.awt.Rectangle(1300, 300, 0, 550));

            // 设置线条的样式（颜色、粗细等）
            lineShape9.setLineWidth(4);// 设置线条粗细
            lineShape9.setLineColor(Color.YELLOW); // 设置线条颜色
            // 创建一个自动形状作为线条
            XSLFAutoShape lineShape10 = slide.createAutoShape();
            lineShape10.setShapeType(org.apache.poi.sl.usermodel.ShapeType.LINE);

            // 设置线条的起点和终点坐标
            lineShape10.setAnchor(new java.awt.Rectangle(1350, 300, 0, 550));

            // 设置线条的样式（颜色、粗细等）
            lineShape10.setLineWidth(4);// 设置线条粗细
            lineShape10.setLineColor(Color.YELLOW); // 设置线条颜色
            // 添加图像框
            XSLFPictureData renxiang = null;
    		try {
    			renxiang = ppt.addPicture(new File("C:/患者信息/别动我/人像.tif"), PictureData.PictureType.PNG);
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		
            XSLFPictureShape picture1 = slide.createPicture(renxiang);
            picture1.setAnchor(new Rectangle(400, 600, 250, 250)); // 设置图像框位置和大小
        
        
        XSLFTextBox textBox2 = slide.createTextBox();
        XSLFTextParagraph paragraph2 = textBox2.addNewTextParagraph();
        XSLFTextRun textRun2 = paragraph2.addNewTextRun();
        textRun2.setText("正面自然像\n"
        		);
       
       textBox2.setAnchor(new Rectangle(100,250,250,150));
       textRun2.setFontSize(40.0);
       paragraph2.setSpaceAfter((double) 18);
       paragraph2.setSpaceBefore((double) 18);
       XSLFTextBox textBox3 = slide.createTextBox();
       XSLFTextParagraph paragraph3 = textBox3.addNewTextParagraph();
       XSLFTextRun textRun4 = paragraph3.addNewTextRun();
       textRun4.setText("1.面部基本协调\n"
       		+ "2.左右面部对称\n");
       setLineSpacing(textBox3, 160);
      textBox3.setAnchor(new Rectangle(100,348,300,350));
      textRun4.setFontSize(32.0);
      textRun4.setFontFamily("SimSun");
      paragraph3.setSpaceAfter((double) 18);
      paragraph3.setSpaceBefore((double) 18);
        }
        if(i == 2) {
        	XSLFPictureData pic0 = null;
        	try {
    			pic0 = ppt.addPicture(new File("C:/患者信息/"+name+"/图片/正面微笑.jpg"), PictureData.PictureType.PNG);
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
            XSLFPictureShape picture = slide.createPicture(pic0);
            picture.setAnchor(new Rectangle(1000, 300, 425, 550));
            // 创建一个自动形状作为线条
            XSLFAutoShape lineShape0 = slide.createAutoShape();
            lineShape0.setShapeType(org.apache.poi.sl.usermodel.ShapeType.LINE);

            // 设置线条的起点和终点坐标
            lineShape0.setAnchor(new java.awt.Rectangle(1200, 300, 0, 550));

            // 设置线条的样式（颜色、粗细等）
            lineShape0.setLineWidth(4);// 设置线条粗细
            lineShape0.setLineColor(Color.CYAN); // 设置线条颜色
           XSLFTextBox textBox23 = slide.createTextBox();
           XSLFTextParagraph paragraph23 = textBox23.addNewTextParagraph();
           XSLFTextRun textRun24 = paragraph23.addNewTextRun();
           textRun24.setText("1.牙龈无明显暴露\n"
           		+ "2.笑线可\n"
           		+ "3.上前牙中线与上唇中线无明显偏差\n");
          
          textBox23.setAnchor(new Rectangle(150,200,600,500));
          textRun24.setFontSize(32.0);
          textRun24.setFontFamily("SimSun");
          paragraph23.setSpaceAfter((double) 18);
          paragraph23.setSpaceBefore((double) 18);
          setLineSpacing(textBox23, 160);
        }
        if(i == 3) {
        	XSLFPictureData pic0 = null;
        	XSLFPictureData pic1 = null;
        	XSLFPictureData pic3 = null;
        	try {
    			pic0 = ppt.addPicture(new File("C:/患者信息/"+name+"/图片/侧位90°.jpg"), PictureData.PictureType.PNG);
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
            XSLFPictureShape picture = slide.createPicture(pic0);
            picture.setAnchor(new Rectangle(700, 200, 450, 650));
            try {
    			pic1 = ppt.addPicture(new File("C:/患者信息/"+name+"/图片/头颅侧位片.jpg"), PictureData.PictureType.PNG);
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
            XSLFPictureShape picture1 = slide.createPicture(pic1);
            picture1.setAnchor(new Rectangle(150, 500, 300, 350));
            try {
    			pic3 = ppt.addPicture(new File("C:/患者信息/别动我/侧位.png"), PictureData.PictureType.PNG);
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
            XSLFPictureShape picture3 = slide.createPicture(pic3);
            picture3.setAnchor(new Rectangle(1300, 525, 280, 330));
           XSLFTextBox textBox33 = slide.createTextBox();
           XSLFTextParagraph paragraph33 = textBox33.addNewTextParagraph();
           XSLFTextRun textRun34 = paragraph33.addNewTextRun();
           textRun34.setText("1. 上下唇在E线内\n"
           		+ "2. 接近直面型\n"
           		+ "3. 一级驼背姿势\n"
           		);
          
          textBox33.setAnchor(new Rectangle(150,200,300,350));
          textRun34.setFontSize(32.0);
          textRun34.setFontFamily("SimSun");
          paragraph33.setSpaceAfter((double) 18);
          paragraph33.setSpaceBefore((double) 18);
          setLineSpacing(textBox33, 160);
          XSLFAutoShape lineShape9 = slide.createAutoShape();
          lineShape9.setShapeType(org.apache.poi.sl.usermodel.ShapeType.LINE);

          // 设置线条的起点和终点坐标
          lineShape9.setAnchor(new java.awt.Rectangle(1050, 300, 0, 200));

          // 设置线条的样式（颜色、粗细等）
          lineShape9.setLineWidth(2);// 设置线条粗细
          lineShape9.setLineColor(Color.YELLOW); // 设置线条颜色
          XSLFAutoShape lineShape91 = slide.createAutoShape();
          lineShape91.setShapeType(org.apache.poi.sl.usermodel.ShapeType.LINE);

          // 设置线条的起点和终点坐标
          lineShape91.setAnchor(new java.awt.Rectangle(1050, 600, 0, 200));

          // 设置线条的样式（颜色、粗细等）
          lineShape91.setLineWidth(2);// 设置线条粗细
          lineShape91.setLineColor(Color.YELLOW); // 设置线条颜色
          XSLFAutoShape lineShape92 = slide.createAutoShape();
          lineShape92.setShapeType(org.apache.poi.sl.usermodel.ShapeType.LINE);

          // 设置线条的起点和终点坐标
          lineShape92.setAnchor(new java.awt.Rectangle(1100, 300, 0, 300));

          // 设置线条的样式（颜色、粗细等）
          lineShape92.setLineWidth(2);// 设置线条粗细
          lineShape92.setLineColor(Color.CYAN); // 设置线条颜色
          XSLFAutoShape lineShape3 = slide.createAutoShape();
          lineShape3.setShapeType(org.apache.poi.sl.usermodel.ShapeType.LINE);

          // 设置线条的起点和终点坐标
          lineShape3.setAnchor(new java.awt.Rectangle(900, 500, 0, 350));

          // 设置线条的样式（颜色、粗细等）
          lineShape3.setLineWidth(4);// 设置线条粗细
          lineShape3.setLineColor(Color.red); // 设置线条颜色
        }
        
        // 添加logo图像框
        XSLFPictureData pd = null;
        if(i<27) {
        	addpicc(slide, "C:/患者信息/别动我/logo.tif", 51.76, 0, 4.69, 4.69);
    }
        if (i == 27) {
        		addpicc(slide, "C:/患者信息/别动我/logo.tif", 22.93, 5.29, 10.58, 10.58);
}
    String path = "C:/患者信息/"+name+"/图片/";
    if(i == 4)
    {
    addpicc(slide,path+"扫描右侧位.jpg",1.98,12.87,16.61,8.33);
    addpicc(slide, path+"扫描正位.jpg", 20.18, 12.87, 16.61,8.33);
    addpicc(slide, path+"扫描左侧位.jpg", 38.38, 12.87, 16.61,8.33);
    XSLFAutoShape lineShape4 = slide.createAutoShape();
    lineShape4.setShapeType(org.apache.poi.sl.usermodel.ShapeType.LINE);

    // 设置线条的起点和终点坐标
    lineShape4.setAnchor(new java.awt.Rectangle(250, 400, 0, 200));

    // 设置线条的样式（颜色、粗细等）
    lineShape4.setLineWidth(4);// 设置线条粗细
    lineShape4.setLineColor(Color.black); // 设置线条颜色
    XSLFAutoShape lineShape41 = slide.createAutoShape();
    lineShape41.setShapeType(org.apache.poi.sl.usermodel.ShapeType.LINE);

    // 设置线条的起点和终点坐标
    lineShape41.setAnchor(new java.awt.Rectangle(800, 500, 0, 100));

    // 设置线条的样式（颜色、粗细等）
    lineShape41.setLineWidth(4);// 设置线条粗细
    lineShape41.setLineColor(Color.YELLOW); // 设置线条颜色
    XSLFAutoShape lineShape411 = slide.createAutoShape();
    lineShape411.setShapeType(org.apache.poi.sl.usermodel.ShapeType.LINE);

    // 设置线条的起点和终点坐标
    lineShape411.setAnchor(new java.awt.Rectangle(1350, 400, 0, 200));

    // 设置线条的样式（颜色、粗细等）
    lineShape411.setLineWidth(4);// 设置线条粗细
    lineShape411.setLineColor(Color.black); // 设置线条颜色
    XSLFAutoShape lineShape4111 = slide.createAutoShape();
    // 设置线条的起点和终点坐标
    lineShape4111.setAnchor(new java.awt.Rectangle(800, 400, 0, 100));

    // 设置线条的样式（颜色、粗细等）
    lineShape4111.setLineWidth(4);// 设置线条粗细
    lineShape4111.setLineColor(Color.black); // 设置线条颜色
    addArrowShapeWithText(slide, "右侧后牙开始远中关系", 1.3, 22.44, 14.91, 4.9);
    addArrowShapeWithText(slide, "前牙反合\n"
    							+ "中线有偏差", 20.78, 22.44, 14.91, 4.9);
    addArrowShapeWithText(slide, "左侧后牙开始远中关系", 40.18, 22.44, 14.91, 4.9);
    }
    if(i == 5)
    {
    addpicc(slide, path+"扫描上颌.jpg", 28.11, 8.82,16, 10.8);
    addpicc(slide, path+"扫描下颌.jpg", 28.11, 19.69,16, 10.8);
    addText(slide, "牙弓情况：上下颌牙弓呈卵圆形，不对称\n"
    		+ "牙列情况:  上下颌恒牙列\n"
    		+ "拥挤度：   上颌牙列拥挤\n"
    		+ "		 下颌后牙舌侧倾斜\n"
    		+ "龋齿：        无"); 
            XSLFAutoShape ellipse = slide.createAutoShape();
            ellipse.setShapeType(ShapeType.ELLIPSE);
            ellipse.setAnchor(new java.awt.Rectangle(850, 258, 352, 586)); // 设置位置和大小

            // 设置椭圆形的属性
            ellipse.setLineColor(new java.awt.Color(0, 0, 255)); // 深蓝色线条
            ellipse.setLineWidth(4); // 线条宽度设置为2
        }
    if(i == 6)
    addpicc(slide, path+"扫描全口.jpg", 10.37, 8.25, 39.44, 23.01);
    if(i == 7) {
    addpicc(slide, path+"曲面断层片.jpg", 6.63, 7.2, 42.96, 20);
    XSLFTextBox textBoxdoc = slide.createTextBox();
    XSLFTextParagraph paragraphdoc = textBoxdoc.addNewTextParagraph();
    XSLFTextRun textRundoc = paragraphdoc.addNewTextRun();
    textRundoc.setText("曲面断层片：");
    textRundoc.setFontFamily("SimSun");
    int textBoxWidthdoc = 600; // 文本框宽度
    int textBoxHeightdoc = 80; // 文本框高度
    int xdoc = 400; // 居中位置
    int ydoc = 780; // 居中位置
    textBoxdoc.setAnchor(new Rectangle(xdoc, ydoc, textBoxWidthdoc, textBoxHeightdoc));
    textRundoc.setFontSize(50.0);
    paragraphdoc.setSpaceAfter((double) 18);
    paragraphdoc.setSpaceBefore((double) 18);
    }
    if(i == 8) {
        addText(slide, "无明显压痛\n"
        		+ "无明显弹响\n"
        		+ "双侧关节动度基本一致\n"
        		+ "开口度：三横指\n"
        		+ "开口型：正常\n"
        		+ "两侧髁突形状一致");
    XSLFAutoShape ellipse = slide.createAutoShape();
    ellipse.setShapeType(ShapeType.ELLIPSE);
    ellipse.setAnchor(new java.awt.Rectangle(870, 312, 134, 134)); // 设置位置和大小

    // 设置椭圆形的属性
    ellipse.setLineColor(new java.awt.Color(255, 0, 0)); // 深蓝色线条
    ellipse.setLineWidth(4); // 线条宽度设置为2
    //
    XSLFAutoShape ellipse2 = slide.createAutoShape();
    ellipse2.setShapeType(ShapeType.ELLIPSE);
    ellipse2.setAnchor(new java.awt.Rectangle(1082, 312, 134, 134)); // 设置位置和大小

    // 设置椭圆形的属性
    ellipse2.setLineColor(new java.awt.Color(255, 0, 0)); // 深蓝色线条
    ellipse2.setLineWidth(4); // 线条宽度设置为2
    }
    if(i == 9)
    addpicc(slide, path+"头颅测量分析.jpg", 6.48, 8.68,44.19,21.52);
    
    if(i == 10) {
    addpicc(slide, path+"测量数据分析.jpg", 1.55, 1.27, 20.23, 29.42);
    XSLFTextBox textBoxdoc = slide.createTextBox();
    XSLFTextParagraph paragraphdoc = textBoxdoc.addNewTextParagraph();
    XSLFTextRun textRundoc = paragraphdoc.addNewTextRun();
    textRundoc.setText(""
    		+ "上颌骨发育不足\n"
    		+ "骨性III类倾向\n"
    		+ "上前牙唇倾\n"
    		+ "下前牙舌倾\n"
    		+ "上唇前突\n"
    		+ "下唇前突\n");
    int textBoxWidthdoc = 600; // 文本框宽度
    int textBoxHeightdoc = 300; // 文本框高度
    int xdoc = 800; // 居中位置
    int ydoc = 250; // 居中位置
    textBoxdoc.setAnchor(new Rectangle(xdoc, ydoc, textBoxWidthdoc, textBoxHeightdoc));
    textRundoc.setFontSize(32.0);
    textRundoc.setFontFamily("SimSun");  // 确保使用支持中文的字体
    setLineSpacing(textBoxdoc, 160);
    paragraphdoc.setSpaceAfter((double) 18);
    paragraphdoc.setSpaceBefore((double) 18);
    XSLFTextBox textBoxdoc1 = slide.createTextBox();
    XSLFTextParagraph paragraphdoc1 = textBoxdoc1.addNewTextParagraph();
    XSLFTextRun textRundoc1 = paragraphdoc1.addNewTextRun();
    textRundoc1.setText(""
    		+ "头颅测量结果\n");
    int textBoxWidthdoc1 = 600; // 文本框宽度
    int textBoxHeightdoc1 = 60; // 文本框高度
    int xdoc1 = 800; // 居中位置
    int ydoc1 = 100; // 居中位置
    textBoxdoc1.setAnchor(new Rectangle(xdoc1, ydoc1, textBoxWidthdoc1, textBoxHeightdoc1));
    textRundoc1.setFontSize(60.0);
    paragraphdoc1.setSpaceAfter((double) 18);
    paragraphdoc1.setSpaceBefore((double) 18);
    
    }
    
    if(i == 11) {
    addpic(slide, path+"头颅侧位片.jpg", 900, 250, 450, 600);
    addText(slide, "已经进入生长发育高峰期\n"
    		+ "尚未进入生长发育高峰期\n"
    		+ "生长发育尚未完全结束\n"
    		+ "生长发育结束\n");
    addpic(slide, "C:/患者信息/别动我/发育 .tif", 100, 550, 500, 300);
    XSLFAutoShape ellipses = slide.createAutoShape();
    ellipses.setShapeType(ShapeType.ROUND_RECT);
    ellipses.setAnchor(new java.awt.Rectangle(950, 580, 100, 200)); // 设置位置和大小

    // 设置椭圆形的属性
    ellipses.setLineColor(new java.awt.Color(255, 0, 0)); // 深蓝色线条
    ellipses.setLineWidth(4); // 线条宽度设置为2
    }
    if(i == 12) {
    addpic(slide, path+"头颅侧位片.jpg", 900, 250, 450, 600);
    addtext(slide, 425, 75, 800, 101,"鼻甲肥大，腺样体肥大，扁桃体肥大，气道狭窄");
    addpic(slide, "C:/患者信息/别动我/气道.png", 100, 600, 500, 200);
    XSLFAutoShape ellipsess = slide.createAutoShape();
    ellipsess.setShapeType(ShapeType.ROUND_RECT);
    ellipsess.setAnchor(new java.awt.Rectangle(1050, 520, 100, 200)); // 设置位置和大小

    // 设置椭圆形的属性
    ellipsess.setLineColor(new java.awt.Color(255, 0, 0)); // 深蓝色线条
    ellipsess.setLineWidth(4); // 线条宽度设置为2
    }
    if(i == 13) {

    	addpic(slide, path+"牙弓CBCT分析下颌.jpg",  900, 600, 400, 240);
    	addpic(slide, path+"牙弓CBCT分析上颌.jpg",  900, 200, 400, 240);
    
    }
    if(i == 14) {

    	addText(slide, "牙根位置情况：\r\n");
    	addtext(slide, 150, 300, 1400, 100, "17    16    15    14    13    12    11    21    22    23    24    25    26    27");
    	addtext(slide, 150, 700, 1400, 100, "47    46    45    44    43    42    41    31    32    33    34    35    36    37");
    }
    if(i == 15) {
    	addtextff(slide, 450, 235, 1034, 574,40.0, "牙性：安氏 II类\n"
    			+ "毛氏： II类二分类+III类二分类\n"
    			+ "骨性：上颌骨发育不足，上下后牙弓狭窄\n"
    			+ "面型：凸面型\n"
    			+ "口腔功能：张口呼吸，开唇露齿\n"
    			+ "龋齿：\n");}
    if(i == 16) {
    	int Row = 6;
    	int Col = 4;
        String[] cols = {
        		"",
                "矢状向",
                "垂直向",
                "水平向",
            };
        String[] rows = {
        		"",
                "颌骨",
                "牙齿",
                "肌肉软组织",
                "不良习惯           及功能异常",
                "其他",
            };
    	XSLFTable table = slide.createTable(Row, Col);
    	

    	 for (int row = 0; row < Row; row++) {
    		 XSLFTableCell cell = table.getCell(row, 0);
    		 cell.setText(rows[row]).setFontFamily("SimSun");
    		 cell.setVerticalAlignment(VerticalAlignment.MIDDLE);
    		    for (XSLFTextParagraph paragraph1 : cell.getTextParagraphs()) {
    		        paragraph1.setTextAlign(TextParagraph.TextAlign.CENTER); // 设置水平居中
    		        
    		    }
    		    
             table.setRowHeight(row, 85);
    	 }
    	 for (int col = 0; col < Col; col++) {
    		 XSLFTableCell cell = table.getCell(0, col);
    		 cell.setText(cols[col]).setFontFamily("SimSun");
    		 cell.setVerticalAlignment(VerticalAlignment.MIDDLE);
    		    for (XSLFTextParagraph paragraph1 : cell.getTextParagraphs()) {
    		        paragraph1.setTextAlign(TextParagraph.TextAlign.CENTER); // 设置水平居中
    		    }
    		 table.setColumnWidth(col, 335);
    	 }	
         for (XSLFTableRow row : table.getRows()) {
             for (XSLFTableCell cell : row.getCells()) {
                 // 设置单元格边框线颜色
                 cell.setBorderColor(XSLFTableCell.BorderEdge.bottom, Color.BLACK);
                 cell.setBorderColor(XSLFTableCell.BorderEdge.top, Color.BLACK);
                 cell.setBorderColor(XSLFTableCell.BorderEdge.left, Color.BLACK);
                 cell.setBorderColor(XSLFTableCell.BorderEdge.right, Color.BLACK);
                 // 设置单元格边框线宽度
                 cell.setBorderWidth(XSLFTableCell.BorderEdge.bottom, 1.0);
                 cell.setBorderWidth(XSLFTableCell.BorderEdge.top, 1.0);
                 cell.setBorderWidth(XSLFTableCell.BorderEdge.left, 1.0);
                 cell.setBorderWidth(XSLFTableCell.BorderEdge.right, 1.0);
                 
                 // 设置单元格内文本字体大小为 14
                 for (XSLFTextParagraph paragraph1 : cell.getTextParagraphs()) {
                     for (XSLFTextRun textRun1 : paragraph1.getTextRuns()) {
                         textRun1.setFontSize(44.0);
                         textRun1.setBold(false); 
                     }
                 }
             }
         }

     	table.setAnchor(new java.awt.Rectangle(116, 235, 1384, 614));
     	
    }
    if (i == 17)
    {
        XSLFTextBox textBoxdoc = slide.createTextBox();
        XSLFTextParagraph paragraphdoc = textBoxdoc.addNewTextParagraph();
        XSLFTextRun textRundoc = paragraphdoc.addNewTextRun();
        textRundoc.setText("1.检查呼吸道。\n"
        		+ "2.唇肌功能训练。\n"
        		+ "3.调整后牙弓宽度。\n"
        		+ "4.内收上前牙。\n"
        		+ "5.解除上前牙拥挤。\n"
        		+ "6.调整覆合覆盖。\n"
        		+ "7.遗传因素不可控。\n");
        int textBoxWidthdoc = 396; // 文本框宽度
        int textBoxHeightdoc = 684; // 文本框高度
        int xdoc = 632; // 居中位置
        int ydoc = 166; // 居中位置
        textBoxdoc.setAnchor(new Rectangle(xdoc, ydoc, textBoxWidthdoc, textBoxHeightdoc));
        textRundoc.setFontSize(40.0);
        textRundoc.setFontFamily("SimSun");  // 确保使用支持中文的字体
        setLineSpacing(textBoxdoc, 160);
        paragraphdoc.setSpaceAfter((double) 20);
        paragraphdoc.setSpaceBefore((double) 20);
    }
if (i == 18) {
	addpicc(slide, path+"扫描全口.jpg", 33.73, 10.13, 21.73, 14.43);
	addpicc(slide, path+"曲面断层片.jpg", 33.73, 24.57, 12.35, 5.94);
	addpicc(slide, path+"头颅侧位片.jpg", 48.54, 24.57, 5.30, 5.94);
	addtextf(slide, 80, 220, 750, 602, 30.0, "1,呼吸道阻塞（鼻炎，腺扁肥大）是引起口呼吸的最主要原因，需要耳鼻喉科检查是否需要配合治疗。\n"
			+ "2,唇肌功能训练，改善口呼吸。\n"
			+ "3,上下弹性矫正器，适当调整牙弓，适当排齐牙列，适当改善前牙的覆合覆盖关系。\n"
			+ "4,维持现有的上下颌中线。\n"
			+ "5,硬性食物，促进颌骨的发育。\n"
			+ "6,患者已经进入生长发育高峰期，爸爸牙列不齐，有遗传因素，随着生长发育，骨性III类错合有可能加重，不排除成年后手术的可能，恒牙胚拥挤，恒牙期需要评估牙量骨量是否协调，不排除拔牙的可能性。\n"
			+ "7,两侧髁突形态不一致，避免偏侧咀嚼，需要观察。\n"
			+ "8,疗程：1-1.5年，费用6400元.");
	
}
if (i==20) {
	addpicc(slide, path+"扫描全口.jpg", 33.73, 10.13, 21.73, 14.43);
	addpicc(slide, path+"曲面断层片.jpg", 33.73, 24.57, 12.35, 5.94);
	addpicc(slide, path+"头颅侧位片.jpg", 48.54, 24.57, 5.30, 5.94);
	addtextf(slide, 80, 220, 750, 602, 30.0, "1，呼吸道阻塞（鼻甲肥大，腺样体肥大）是引起口呼吸/下颌前伸的最主要原因之一，需要耳鼻喉科检查是否需要配合治疗。\n"
			+ "2，纠正下颌前伸的习惯。\n"
			+ "3，第一期：上颌活动矫正器，唇侧移动上前牙，解除反合，改善前牙的覆合覆盖关系。\n"
			+ "4，第二期：前方牵引器，引导上颌骨的前方生长。\n"
			+ "5，反合解除后观察上下颌中线能否改善。\n"
			+ "6，多吃硬性食物，促进颌骨的发育。\n"
			+ "7，患者尚未进入生长发育高峰期，妈妈反合，有遗传因素，随着生长发育，骨性III类错合有可能加重，不排除成年后手术的可能，恒牙胚拥挤，恒牙期需要评估牙量骨量是否协调，不排除拔牙的可能性。\n"
			+ "8，右下后牙低密度影需要外科会诊。\n"
			+ "9，疗程：6-10个月，费用12000元.");
	
}
if (i==22) {
	addpicc(slide, path+"扫描全口.jpg", 33.73, 10.13, 21.73, 14.43);
	addpicc(slide, path+"曲面断层片.jpg", 33.73, 24.57, 12.35, 5.94);
	addpicc(slide, path+"头颅侧位片.jpg", 48.54, 24.57, 5.30, 5.94);
	addtextf(slide, 80, 220, 750, 602, 30.0, "1，上颌窦异常，需要耳鼻喉科检查。\n"
			+ "2，拔除15/25/35/45。\n"
			+ "3，上下固定矫正器，上下强支抗，排齐牙列，调整牙轴，建立正常覆合覆盖关系，多余间隙后牙近中移动。\n"
			+ "4，维持现有的上下颌中线和面型。\n"
			+ "5，多吃硬性食物，促进颌骨的发育。\n"
			+ "6，患者生长发育尚未结束，妈妈牙齿不齐，有遗传因素，有三颗智齿存在，随着智齿的萌出，牙列拥挤有可能加重，智齿酌情拔除。\n"
			+ "7，两侧髁突形态不一致，避免偏侧咀嚼，需要观察。\n"
			+ "疗程：2年左右，费用28000元.\n"
			+ "");
	
}
if (i==24) {
	addpicc(slide, path+"扫描全口.jpg", 33.73, 10.13, 21.73, 14.43);
	addpicc(slide, path+"曲面断层片.jpg", 33.73, 24.57, 12.35, 5.94);
	addpicc(slide, path+"头颅侧位片.jpg", 48.54, 24.57, 5.30, 5.94);
	addtextf(slide, 80, 220, 750, 602, 30.0, 
			  "1，呼吸道阻塞（鼻甲肥大，腺扁肥大）是引起口呼吸的最主要原因之一，需要耳鼻喉科检查是否需要配合治疗。\n"
			+ "2，唇/舌肌功能训练，改善口呼吸和舌低位。\n"
			+ "3，上下隐形矫正器，调整后牙弓宽度，排齐牙列，调整前牙牙轴，压低上下前牙，矫正深覆合，引导下颌前方生长，改善前牙的覆合覆盖关系。\n"
			+ "4，维持现有的上下颌中线。\n"
			+ "5，多吃硬性食物，促进颌骨的发育。\n"
			+ "6，患者尚未进入生长发育高峰期，不确定是否有遗传因素，随着生长发育，骨性II类错合有可能加重，不排除成年后手术的可能，恒牙胚拥挤，恒牙期需要评估牙量骨量是否协调，不排除拔牙的可能性。\n"
			+ "7，两侧髁突形态不一致，避免偏侧咀嚼，需要观察。\n"
			+ "8，疗程：1-1.5年，费用26480元.\n"
			+ "");
	
}

if(i==19)
	addpic(slide, "C:/患者信息/别动我/弹性.png", 210, 300, 1150, 560);
if(i==21)
	addpicc(slide, "C:/患者信息/别动我/功能.png", 16.91, 6.96, 22.63, 23.08);
if(i==23)
	addpicc(slide, "C:/患者信息/别动我/固定.png", 8.22, 7.62, 40,22.19);
if(i==25)
	addpicc(slide, "C:/患者信息/别动我/隐形.png", 13.88, 7.06, 28.68, 22.49);
if(i == 26) {
	int Row = 6;
	int Col = 5;
    String[] cols = {
    		"",
            "方案一",
            "方案二",
            "方案三",
            "方案四",
        };
    String[] rows = {
    		"",
            "矫正时间",
            "矫正效果",
            "矫正费用",
            "矫正舒适度",
            "需要配合度"
        };
	XSLFTable table = slide.createTable(6, 5);


	 for (int row = 0; row < Row; row++) {
		 XSLFTableCell cell = table.getCell(row, 0);
		 cell.setText(rows[row]).setFontFamily("SimSun");
		 cell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		    for (XSLFTextParagraph paragraph1 : cell.getTextParagraphs()) {
		        paragraph1.setTextAlign(TextParagraph.TextAlign.CENTER); // 设置水平居中
		    }
         table.setRowHeight(row, 90);
         
	 }
	 for (int col = 0; col < Col; col++) {
		 XSLFTableCell cell = table.getCell(0, col);
		 cell.setText(cols[col]).setFontFamily("SimSun");
		 cell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		    for (XSLFTextParagraph paragraph1 : cell.getTextParagraphs()) {
		        paragraph1.setTextAlign(TextParagraph.TextAlign.CENTER); // 设置水平居中
		    }
		 table.setColumnWidth(col, 290);
		 
	 }	
     for (XSLFTableRow row : table.getRows()) {
         for (XSLFTableCell cell : row.getCells()) {
             // 设置单元格边框线颜色
             cell.setBorderColor(XSLFTableCell.BorderEdge.bottom, Color.BLACK);
             cell.setBorderColor(XSLFTableCell.BorderEdge.top, Color.BLACK);
             cell.setBorderColor(XSLFTableCell.BorderEdge.left, Color.BLACK);
             cell.setBorderColor(XSLFTableCell.BorderEdge.right, Color.BLACK);
             // 设置单元格边框线宽度
             cell.setBorderWidth(XSLFTableCell.BorderEdge.bottom, 1.0);
             cell.setBorderWidth(XSLFTableCell.BorderEdge.top, 1.0);
             cell.setBorderWidth(XSLFTableCell.BorderEdge.left, 1.0);
             cell.setBorderWidth(XSLFTableCell.BorderEdge.right, 1.0);
             for (XSLFTextParagraph paragraph1 : cell.getTextParagraphs()) {
                 for (XSLFTextRun textRun1 : paragraph1.getTextRuns()) {
                     textRun1.setFontSize(40.0);
                 }
             }
         }
     }

 	table.setAnchor(new java.awt.Rectangle(80, 240, 300, 100));

}
if (i>27) {
	int j;
	j=i-27;
	switch (j) {
	case 7: 
	case 8:
	case 9:addpic(slide, "C:/患者信息/别动我/"+j+".png", 400, 130, 840, 700);
	
	break;
	case 1:
	case 2:
	case 3:
	case 4:addpic(slide, "C:/患者信息/别动我/"+j+".png", 100, 130, 1400, 650);
		break;
	case 5:
	case 6:addpic(slide, "C:/患者信息/别动我/"+j+".png", 250, 130, 1100, 650);
	break;
	case 10:
	case 11:
	case 12:
	case 13:addpic(slide, "C:/患者信息/别动我/"+j+".png", 240, 150, 1100, 650);
		break;
	}
}
    }
    
    
    // 指定保存路径
    String desktopPath = "C:/患者信息/";
    String fileName = pname+"设计方案.pptx";
    String filePath = desktopPath + fileName;
   
    // 保存PPT文件到桌面
    try {
        FileOutputStream out = new FileOutputStream(filePath);
        ppt.write(out);
        out.close();
        System.out.println("PPT已保存为"
        		+pname+ "设计方案.\n"
        				+ "(保存路径："+filePath+"。)");
    } catch (IOException e) {
        System.out.println("Error saving PPT: " + e.getMessage());
}
    }
private static void addpic(XSLFSlide slide, String imagePath, int x, int y, int width, int height) {
    XSLFPictureData pd = null;
    try {
        pd = slide.getSlideShow().addPicture(new File(imagePath), PictureData.PictureType.PNG);
        
    }catch(FileNotFoundException e){
    	return;
    }catch (IOException e) {
        e.printStackTrace();
    }

    XSLFPictureShape picture = slide.createPicture(pd);
    picture.setAnchor(new Rectangle(x, y, width, height));
}
private static void addpicc(XSLFSlide slide, String imagePath, double x, double y, double width, double height) {
    XSLFPictureData pd = null;
    try {
        pd = slide.getSlideShow().addPicture(new File(imagePath), PictureData.PictureType.PNG);
        
    }catch(FileNotFoundException e){
    	return;
    }catch (IOException e) {
        e.printStackTrace();	
    }
     int xx = (int) (x * 28.3432781); // Convert cm to EMUs
     int yy = (int) (y * 28.3432781); // Convert cm to EMUs
    int wwidth = (int) (width *28.3432781); // Convert cm to EMUs
    int hheight = (int) (height *28.3432781); // Convert cm to EMUs

    XSLFPictureShape picture = slide.createPicture(pd);
    picture.setAnchor(new Rectangle(xx, yy, wwidth, hheight));
}


private static void addtext(XSLFSlide slide, int x, int y, int width, int hight,String Text) {
	XSLFTextBox textBoxdoc = slide.createTextBox();
    XSLFTextParagraph paragraphdoc = textBoxdoc.addNewTextParagraph();
    XSLFTextRun textRundoc = paragraphdoc.addNewTextRun();
    textRundoc.setText(Text);
    int textBoxWidthdoc = width; // 文本框宽度
    int textBoxHeightdoc = hight; // 文本框高度
    int xdoc = x; // 居中位置
    int ydoc = y; // 居中位置
    textBoxdoc.setAnchor(new Rectangle(xdoc, ydoc, textBoxWidthdoc, textBoxHeightdoc));
    textRundoc.setFontSize(32.0);
    textRundoc.setFontFamily("SimSun");  // 确保使用支持中文的字体
    paragraphdoc.setSpaceAfter((double) 18);
    paragraphdoc.setSpaceBefore((double) 18);
    setLineSpacing(textBoxdoc, 160);
}
private static void addtextn(XSLFSlide slide, int x, int y, int width, int height, String Text) {
    XSLFTextBox textBoxdoc = slide.createTextBox();
    textBoxdoc.setAnchor(new Rectangle(x, y, width, height));
    textBoxdoc.clearText();
    textBoxdoc.setVerticalAlignment(VerticalAlignment.TOP); // 设置文本框顶部对齐
    XSLFTextParagraph paragraphdoc = textBoxdoc.addNewTextParagraph();
    paragraphdoc.setTextAlign(TextParagraph.TextAlign.LEFT); // 设置文本左对齐
    paragraphdoc.setSpaceAfter(0.0); // 设置段后间距
    paragraphdoc.setSpaceBefore(0.0); // 设置段前间距
    paragraphdoc.setLineSpacing(1.0); // 设置行间距

    XSLFTextRun textRundoc = paragraphdoc.addNewTextRun();
    textRundoc.setText(Text);
    textRundoc.setFontSize(32.0);
    textRundoc.setFontFamily("SimSun");  // 确保使用支持中文的字体
    
    setLineSpacing(textBoxdoc, 160); // 设置行间距
}
private static void addtextf(XSLFSlide slide, int x, int y, int width, int hight,double font,String Text) {
	XSLFTextBox textBoxdoc = slide.createTextBox();
    XSLFTextParagraph paragraphdoc = textBoxdoc.addNewTextParagraph();
    XSLFTextRun textRundoc = paragraphdoc.addNewTextRun();
    textRundoc.setText(Text);
    int textBoxWidthdoc = width; // 文本框宽度
    int textBoxHeightdoc = hight; // 文本框高度
    int xdoc = x; // 居中位置
    int ydoc = y; // 居中位置
    textBoxdoc.setAnchor(new Rectangle(xdoc, ydoc, textBoxWidthdoc, textBoxHeightdoc));
    textRundoc.setFontSize(font);
    textRundoc.setFontFamily("SimSun");  // 确保使用支持中文的字体
    paragraphdoc.setSpaceAfter((double) 18);
    paragraphdoc.setSpaceBefore((double) 18);
}
private static void addtextff(XSLFSlide slide, int x, int y, int width, int hight,double font,String Text) {
	XSLFTextBox textBoxdoc = slide.createTextBox();
    XSLFTextParagraph paragraphdoc = textBoxdoc.addNewTextParagraph();
    XSLFTextRun textRundoc = paragraphdoc.addNewTextRun();
    textRundoc.setText(Text);
    int textBoxWidthdoc = width; // 文本框宽度
    int textBoxHeightdoc = hight; // 文本框高度
    int xdoc = x; // 居中位置
    int ydoc = y; // 居中位置
    textBoxdoc.setAnchor(new Rectangle(xdoc, ydoc, textBoxWidthdoc, textBoxHeightdoc));
    textRundoc.setFontSize(font);
    textRundoc.setFontFamily("SimSun");  // 确保使用支持中文的字体
    paragraphdoc.setSpaceAfter((double) 18);
    paragraphdoc.setSpaceBefore((double) 18);
    setLineSpacing(textBoxdoc, 160);
}
private static void addText(XSLFSlide slide, String Text) {
	addDoctorInfo(slide, Text, 32);
}
private static void addDoctorInfo(XSLFSlide slide, String Text,double fontsize) {
	
    XSLFTextBox textBoxdoc = slide.createTextBox();
    XSLFTextParagraph paragraphdoc = textBoxdoc.addNewTextParagraph();
    XSLFTextRun textRundoc = paragraphdoc.addNewTextRun();
    textRundoc.setText(Text);
    int textBoxWidthdoc = 800; // 文本框宽度
    int textBoxHeightdoc = 400; // 文本框高度
    int xdoc = 150; // 居中位置
    int ydoc = 200; // 居中位置
    textBoxdoc.setAnchor(new Rectangle(xdoc, ydoc, textBoxWidthdoc, textBoxHeightdoc));
    textRundoc.setFontSize( fontsize);
    paragraphdoc.setSpaceAfter((double) 18);
    paragraphdoc.setSpaceBefore((double) 18);
    setLineSpacing(textBoxdoc, 160);
    textRundoc.setFontFamily("SimSun");  // 确保使用支持中文的字体
}
private static void setLineSpacing(XSLFTextBox textBox, double lineSpacing) {
    for (XSLFTextParagraph paragraph : textBox.getTextParagraphs()) {
        paragraph.setLineSpacing(lineSpacing);
    }
}
public static String getDate() {
    // 获取当前本地日期
    LocalDate localDate = LocalDate.now();

    // 定义日期格式化模式
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    // 格式化日期
    return localDate.format(formatter);
}
public static void addArrowShapeWithText(XSLFSlide slide, String text, double d, double e, double f, double g) {
    XSLFAutoShape arrowShape = slide.createAutoShape();
    int xx = (int) (d * 28.3432781); // Convert cm to EMUs
    int yy = (int) (e * 28.3432781); // Convert cm to EMUs
   int wwidth = (int) (f *28.3432781); // Convert cm to EMUs
   int hheight = (int) (g *28.3432781); // Convert cm to EMUs
    arrowShape.setAnchor(new Rectangle(xx, yy, wwidth, hheight));
    arrowShape.setFillColor(new Color(255, 228, 196)); // 设置填充颜色 (类似米色)
    arrowShape.setShapeType(ShapeType.UP_ARROW_CALLOUT);
    arrowShape.setText(text).setFontFamily("SimSun");; // 设置文本

    
    // 设置文本居中
    arrowShape.setVerticalAlignment(VerticalAlignment.MIDDLE);
    arrowShape.setTextAutofit(XSLFAutoShape.TextAutofit.SHAPE);
    arrowShape.getTextParagraphs().forEach(paragraph -> {
        paragraph.setTextAlign(TextAlign.CENTER);
        paragraph.getTextRuns().forEach(run -> {
            run.setFontSize(40.0);
            run.setBold(false);
            run.setFontFamily("SimSun");; // 设置文本
        });
    });
    arrowShape.setLineColor(Color.BLUE); // 设置边框颜色
    arrowShape.setLineWidth(1.0); // 设置边框宽度
}

private static void addWatermark(XMLSlideShow ppt, String imagePath) {
    XSLFSlideMaster slideMaster = ppt.getSlideMasters().get(0); // 获取第一个幻灯片母版

    XSLFPictureData pd = null;
    try {
        pd = ppt.addPicture(new File(imagePath), PictureData.PictureType.TIFF);
    } catch (IOException e) {
        e.printStackTrace();
    }

    if (pd != null) {
        for (XSLFSlideLayout layout : slideMaster.getSlideLayouts()) {
            // 在每个布局上添加水印
            XSLFPictureShape picture = layout.createPicture(pd);
            picture.setAnchor(new Rectangle(0, 0, ppt.getPageSize().width, ppt.getPageSize().height));
        }
    }
}


	    public static void main(String[] args) {
	    	gen("朱慧慧");
    }}