package 物流面单系统;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.imageio.ImageIO;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;


public class GetResult {  //测试类 测试能否生成jpg文件和pdf文件
	int width=600;//图片宽度
	int height=600;//图片高度
	
	public static void main(String[] args) throws Exception {
		File file=new File("./data/物流信息.xls");
		String pngPath = "./data/条形码.png";
		String jpgPath = "./data/物流信息.jpg";
		String pdfPath = "./data/物流信息.pdf";
		Logistics l=new ReadExcel().readFromExcel(file);  
		
        getPng(pngPath);
		getJpg(l,pngPath);
		System.out.println("成功生成jpg！");
		getPdf(jpgPath, pdfPath);
		System.out.println("成功生成pdf！");
		System.out.println("刷新工程文件的data文件夹即可查看");
	}

	
	
	public static void getPng(String pngPath) throws Exception { //生成条形码的png文件
        int codeWidth = 3 + (7 * 6) + 5 + (7 * 6) + 3;
        
        codeWidth = Math.max(codeWidth,105);
       // BufferedImage image = new BufferedImage(400, 300,BufferedImage.TYPE_INT_RGB);
		BitMatrix bitMatrix = new MultiFormatWriter().encode("8747966618941", BarcodeFormat.EAN_13, codeWidth, 50, null);
		Matrix.writeToFile(bitMatrix, "png",new File(pngPath));   
    } 
	
	
 
    public static void getJpg(Logistics l,String pngPath) throws Exception {  //生成jpg文件
    	BufferedImage image1 = ImageIO.read(new FileInputStream(pngPath));
    	int imageWidth = 1000;  
        int imageHeight = 1000;  
        BufferedImage image = new BufferedImage(imageWidth, imageHeight,  BufferedImage.TYPE_INT_RGB);
        
        Graphics g = image.getGraphics();  
        g.setColor(Color.white);  
        g.fillRect(0, 0, imageWidth, imageHeight); //设置填充背景颜色 
        g.setColor(Color.black);
        //画出长为800，宽为400的矩形框
        g.drawRect(100,100,800,400); 
        g.drawLine(100,200,900,200);
        g.drawLine(100,300,900,300);
        g.drawLine(100,400,900,400);
        g.drawLine(500,300,500,400);
        
        g.setFont(new Font("宋体", Font.BOLD, 60));   
        g.drawString("EMS标准", 180, 95);  //EMS物流字体
        g.setFont(new Font("宋体", Font.BOLD, 25));  
        g.drawString("物流单号：" + l.getLogistNum(), 580, 95);
        g.drawString("收件人：" + l.getReceName(), 220, 130);
        g.drawString("电话/手机：" + l.getReceTel(), 520, 130);
        g.drawString("地址：" + l.getReceAddress(), 180, 160);
        g.drawString("邮编：" + l.getRecePost(), 200, 190);
        g.drawString("寄件人：" + l.getSendName(),220, 230);
        g.drawString("电话/手机：" + l.getSendTel(),520, 230);
        g.drawString("地址：" + l.getSendAddress(), 180, 260);
        g.drawString("邮编：" + l.getSendPost(), 200, 290);
        g.setFont(new Font("宋体", Font.BOLD, 18)); 
        g.drawString("收件人：", 520, 330);
        g.drawString("件数：" + l.getNumber(), 220, 330);
        g.drawString("净重：" + l.getNetWeight(), 220, 380);
        g.drawString("毛重：" + l.getRoughWeight(), 220, 355);
        g.drawString("订单号：" + l.getOrderNum(), 400, 488);
        g.drawImage(image1, 400, 420, 250,50, null);
        saveJpg("./data/物流信息.jpg",image); //把生成的图片存放到指定路径
    }
    
    
    public static void saveJpg(String jpgPath,BufferedImage image) throws Exception { //把生成的图片存放到指定路径
		FileOutputStream fos = new FileOutputStream(jpgPath);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(bos);
		encoder.encode(image);
		bos.close();
		fos.close();
    }
    
    
	public static void getPdf(String jpgPath,String pdfPath) throws Exception { //生成jpg对应的pdf文件
		BufferedImage img = ImageIO.read(new File(jpgPath));			
		FileOutputStream fos = new FileOutputStream(pdfPath);			
		Document doc = new Document(null, 0, 0, 0, 0);			
		doc.setPageSize(new Rectangle(img.getWidth(), img.getHeight()));			
		Image image = Image.getInstance(jpgPath);			
		PdfWriter.getInstance(doc, fos);			
		doc.open();			
		doc.add(image);			
		doc.close();
	}
}
