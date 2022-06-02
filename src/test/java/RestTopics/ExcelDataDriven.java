package RestTopics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataDriven {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		
	   //Creating objct of Workbook class to get hold of excel first
		FileInputStream fis = new FileInputStream("C:\\Program Files\\testdata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		    //get number of sheets
		     int sheets =  workbook.getNumberOfSheets();
		   for(int i=0;i<sheets;i++) {
			      if(workbook.getSheetName(i).equals("testdata")){
			    	 XSSFSheet sheet =           workbook.getSheetAt(i);
			   
			    	 //Identify the test case column by scanning entire 1st row
			    	 //kaise dhundoge column ,sheet is collection of rows so row iterate krke milega
			  Iterator<Row> rows  =   sheet.rowIterator();
			         Row firstrow     =   rows.next();
			     
			         //rows iterate krne ke baad celliterate hota h
			      Iterator<Cell>ce =        firstrow.cellIterator();
			      
			      int k=0;
			      int column =0;
			      while(ce.hasNext()) {
			    Cell value =	  ce.next();
			      
			      if(value.getStringCellValue().equals("Testcases")) {
			    	  column=k;
			      }
			      k++;
			      }
			      System.out.println(column);
			      
			      
			      //Once the column is identified then scan the entire test case column to get the prchase test case row 
			      
			      while(rows.hasNext()) {
			   Row r = rows.next();
			     if(r.getCell(column).getStringCellValue().equals("Purchase")){
			    	 
			    	 
			    	 //after you grab purchase test case row, pull all the data of that row and and feed it into test
			  Iterator<Cell>cv   =  r.cellIterator();
			     while(cv.hasNext()) {
			    	System.out.println(cv.next().getStringCellValue()); 
			     }
			     }
			      
			      }
			      
			      }
		  
		       
		   }
		
	             
	              
	}

}
