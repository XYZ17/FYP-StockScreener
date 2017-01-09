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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

public class POIFunction {
     static XSSFRow row;
     static XSSFCell cell;
     DataFormatter dF = new DataFormatter();
     
   private void checkNullString(Cell c)
   {
       if(c.getCellType() == Cell.CELL_TYPE_BLANK){
                c.setCellValue(" ");
       }
       else if(c.getCellType() == Cell.CELL_TYPE_ERROR){
                c.setCellValue(" ");
       }
   }
   
   private void checkNullNumeric(Cell c)
   {
       if(c.getCellType() == Cell.CELL_TYPE_BLANK){
                c.setCellValue(0.0);
                
       }
       else if(c.getCellType() == Cell.CELL_TYPE_ERROR){
           System.out.println("ERROR");
                c.setCellValue(0.0);
       }
   }
   
   public double poiToGetDbl(String FileAddress, String CellDetails, int SheetNum) throws NullPointerException
   {
       double result = 0.0;
         try {
             FileInputStream fis = new FileInputStream(
                     new File(FileAddress));
             XSSFWorkbook wb = null;
             try {
                 wb = new XSSFWorkbook(fis);
             } catch (IOException e) {
                 System.out.print("Error detected: " + e);
             }
             XSSFSheet sheet = wb.getSheetAt(SheetNum);
             FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
            try{
                CellReference cr = new CellReference(CellDetails);
                Row row = sheet.getRow(cr.getRow());
                Cell cell = row.getCell(cr.getCol());
                //System.out.println("CELL "+ cell);
                checkNullNumeric(cell);
                CellValue cellValue = evaluator.evaluate(cell);

                switch (cellValue.getCellType()) {
                   case Cell.CELL_TYPE_BLANK:
                       result = 0.0;
                       break;

                   case Cell.CELL_TYPE_ERROR:
                       result = 0.0;
                       break;

                   case Cell.CELL_TYPE_NUMERIC:
                       result = cellValue.getNumberValue();
                       break;

               }
            } catch (NullPointerException n){
                result = 0.0;
            }
             fis.close();
         } catch (IOException e) {
             System.out.print("Error detected: " + e);
         }
         return result;
   }
   
   public double poiToGetInt(String FileAddress, String CellDetails, int SheetNum) throws FileNotFoundException
   {
       double result = 0.0;
       
         try {
             FileInputStream fis = new FileInputStream(
                     new File(FileAddress));
             XSSFWorkbook wb = null;
             try {
                 wb = new XSSFWorkbook(fis);
             } catch (IOException e) {
                 System.out.print("Error detected: " + e);
             }
             XSSFSheet sheet = wb.getSheetAt(SheetNum);
             FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
             
             try{
                 CellReference cr = new CellReference(CellDetails);
             Row row = sheet.getRow(cr.getRow());
             Cell cell = row.getCell(cr.getCol());
             checkNullNumeric(cell);
             CellValue cellValue = evaluator.evaluate(cell);
             switch (cellValue.getCellType()) {
                case Cell.CELL_TYPE_NUMERIC:
                    result = cellValue.getNumberValue();
                    break;

                case Cell.CELL_TYPE_BLANK:
                    result = 0;
                    break;

                case Cell.CELL_TYPE_ERROR:
                    result = 0;
                    break;
                }
             }catch (NullPointerException n){
                result = 0;
            }
             
             fis.close();
         } catch (IOException e) {
             System.out.print("Error detected: " + e);
         }
         return (int) result;
   }
   
   public String poiToGetString(String FileAddress, String CellDetails, int SheetNum) throws FileNotFoundException
   {
       String result = "NOTFOUND";
         try {
             FileInputStream fis = new FileInputStream(
                     new File(FileAddress));
             XSSFWorkbook wb = null;
             try {
                 wb = new XSSFWorkbook(fis);
             } catch (IOException e) {
                 System.out.print("Error detected: " + e);
             }
             XSSFSheet sheet = wb.getSheetAt(SheetNum);
             FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
             try{
                 CellReference cr = new CellReference(CellDetails);
             Row row = sheet.getRow(cr.getRow());
             Cell cell = row.getCell(cr.getCol());
             checkNullString(cell);
             CellValue cellValue = evaluator.evaluate(cell);
             
             switch (cellValue.getCellType()) {
                case Cell.CELL_TYPE_STRING:
                    result = cellValue.getStringValue();
                    break;

                case Cell.CELL_TYPE_BLANK:
                    result = " ";
                    break;

                case Cell.CELL_TYPE_ERROR:
                    result = " ";
                    break;
            }
            }catch (NullPointerException n){
                result = " ";
            }
             fis.close();
         } catch (IOException e) {
             System.out.print("Error detected: " + e);
         }
         return result;
   }
   
   
   
}

/*
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

*/