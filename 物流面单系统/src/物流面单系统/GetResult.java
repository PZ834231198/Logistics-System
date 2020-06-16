package �����浥ϵͳ;

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


public class GetResult {  //������ �����ܷ�����jpg�ļ���pdf�ļ�
	int width=600;//ͼƬ���
	int height=600;//ͼƬ�߶�
	
	public static void main(String[] args) throws Exception {
		File file=new File("./data/������Ϣ.xls");
		String pngPath = "./data/������.png";
		String jpgPath = "./data/������Ϣ.jpg";
		String pdfPath = "./data/������Ϣ.pdf";
		Logistics l=new ReadExcel().readFromExcel(file);  
		
        getPng(pngPath);
		getJpg(l,pngPath);
		System.out.println("�ɹ�����jpg��");
		getPdf(jpgPath, pdfPath);
		System.out.println("�ɹ�����pdf��");
		System.out.println("ˢ�¹����ļ���data�ļ��м��ɲ鿴");
	}

	
	
	public static void getPng(String pngPath) throws Exception { //�����������png�ļ�
        int codeWidth = 3 + (7 * 6) + 5 + (7 * 6) + 3;
        
        codeWidth = Math.max(codeWidth,105);
       // BufferedImage image = new BufferedImage(400, 300,BufferedImage.TYPE_INT_RGB);
		BitMatrix bitMatrix = new MultiFormatWriter().encode("8747966618941", BarcodeFormat.EAN_13, codeWidth, 50, null);
		Matrix.writeToFile(bitMatrix, "png",new File(pngPath));   
    } 
	
	
 
    public static void getJpg(Logistics l,String pngPath) throws Exception {  //����jpg�ļ�
    	BufferedImage image1 = ImageIO.read(new FileInputStream(pngPath));
    	int imageWidth = 1000;  
        int imageHeight = 1000;  
        BufferedImage image = new BufferedImage(imageWidth, imageHeight,  BufferedImage.TYPE_INT_RGB);
        
        Graphics g = image.getGraphics();  
        g.setColor(Color.white);  
        g.fillRect(0, 0, imageWidth, imageHeight); //������䱳����ɫ 
        g.setColor(Color.black);
        //������Ϊ800����Ϊ400�ľ��ο�
        g.drawRect(100,100,800,400); 
        g.drawLine(100,200,900,200);
        g.drawLine(100,300,900,300);
        g.drawLine(100,400,900,400);
        g.drawLine(500,300,500,400);
        
        g.setFont(new Font("����", Font.BOLD, 60));   
        g.drawString("EMS��׼", 180, 95);  //EMS��������
        g.setFont(new Font("����", Font.BOLD, 25));  
        g.drawString("�������ţ�" + l.getLogistNum(), 580, 95);
        g.drawString("�ռ��ˣ�" + l.getReceName(), 220, 130);
        g.drawString("�绰/�ֻ���" + l.getReceTel(), 520, 130);
        g.drawString("��ַ��" + l.getReceAddress(), 180, 160);
        g.drawString("�ʱࣺ" + l.getRecePost(), 200, 190);
        g.drawString("�ļ��ˣ�" + l.getSendName(),220, 230);
        g.drawString("�绰/�ֻ���" + l.getSendTel(),520, 230);
        g.drawString("��ַ��" + l.getSendAddress(), 180, 260);
        g.drawString("�ʱࣺ" + l.getSendPost(), 200, 290);
        g.setFont(new Font("����", Font.BOLD, 18)); 
        g.drawString("�ռ��ˣ�", 520, 330);
        g.drawString("������" + l.getNumber(), 220, 330);
        g.drawString("���أ�" + l.getNetWeight(), 220, 380);
        g.drawString("ë�أ�" + l.getRoughWeight(), 220, 355);
        g.drawString("�����ţ�" + l.getOrderNum(), 400, 488);
        g.drawImage(image1, 400, 420, 250,50, null);
        saveJpg("./data/������Ϣ.jpg",image); //�����ɵ�ͼƬ��ŵ�ָ��·��
    }
    
    
    public static void saveJpg(String jpgPath,BufferedImage image) throws Exception { //�����ɵ�ͼƬ��ŵ�ָ��·��
		FileOutputStream fos = new FileOutputStream(jpgPath);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(bos);
		encoder.encode(image);
		bos.close();
		fos.close();
    }
    
    
	public static void getPdf(String jpgPath,String pdfPath) throws Exception { //����jpg��Ӧ��pdf�ļ�
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
