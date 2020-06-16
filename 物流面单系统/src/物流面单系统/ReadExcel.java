package �����浥ϵͳ;

import java.io.File;
import java.text.SimpleDateFormat;
import jxl.Sheet;
import jxl.Workbook;
import java.util.*;

public class ReadExcel { //��xls��ȡ������Ϣ��������һ��Logistic����
	
	public Logistics readFromExcel(File file) throws Exception {
		Logistics l=new Logistics();
		//1:����workbook
        Workbook workbook=Workbook.getWorkbook(file); 
        //2:��ȡ��һ��������sheet
        Sheet sheet=workbook.getSheet(0);
        l.setLogistNum(sheet.getCell(0,1).getContents());
        l.setNetWeight(sheet.getCell(1,1).getContents());
        l.setRoughWeight(sheet.getCell(2,1).getContents());
        l.setNumber(sheet.getCell(3,1).getContents());
        l.setGoods(sheet.getCell(4,1).getContents());
        
        l.setReceName(sheet.getCell(5,1).getContents());
        l.setRecePost(sheet.getCell(6,1).getContents());
        l.setReceAddress(sheet.getCell(7,1).getContents());
        l.setReceTel(sheet.getCell(8,1).getContents());
        
        l.setSendName(sheet.getCell(9,1).getContents());
        l.setSendPost(sheet.getCell(10,1).getContents());
        l.setSendAddress(sheet.getCell(11,1).getContents());
        l.setSendTel(sheet.getCell(11,1).getContents());
        
        //���ɶ�����
		int random=(int)(Math.random()*999);
		String randomStr = String.format("%03d",random);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS"); 
		Date today = new Date(); 
		String str=df.format(today) + randomStr;
		
		l.setOrderNum(str);
		
		
        workbook.close();
        return l;
	}
}
