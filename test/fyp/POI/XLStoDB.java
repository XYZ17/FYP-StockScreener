/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fyp.POI;

/**
 *
 * @author Lim
 */

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLStoDB {
     static XSSFRow row;
    static XSSFCell cell;
    
   public int readStockSymbol()
   {
      FileInputStream fis = new FileInputStream(
      new File("../../../files/Stocklist.xlsx"));
      XSSFWorkbook wb = new XSSFWorkbook(fis);
      XSSFSheet sheet = wb.getSheetAt(0);
      FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
      
      CellReference cr = new CellReference("C4"); 
        Row row = sheet.getRow(cr.getRow());
        Cell cell = row.getCell(cr.getCol()); 
        CellValue cellValue = evaluator.evaluate(cell);

        switch (cellValue.getCellType()) {
            case Cell.CELL_TYPE_BOOLEAN:
                boolean truefalse = cellValue.getBooleanValue();
                System.out.println("Boolean" + truefalse);
                break;
            case Cell.CELL_TYPE_NUMERIC:
                double NumericCheck = cellValue.getNumberValue();
                if(NumericCheck % 1 == 0){
                        int Integer = (int) NumericCheck;
                        System.out.println("Integer" + Integer);
                    }
                    else{
                        double Dbl = NumericCheck;
                        System.out.println("Double" + Dbl);
                    }
                break;
                
            case Cell.CELL_TYPE_STRING:
                String str = cellValue.getStringValue();
                System.out.println("String" + str.substring(3));
                break;
                
            case Cell.CELL_TYPE_BLANK:
                System.out.println("Blank");
                break;
                
            case Cell.CELL_TYPE_ERROR:
                break;
        }
      fis.close();
   }
}
