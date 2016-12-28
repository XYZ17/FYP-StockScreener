/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fyp.database;

/**
 *
 * @author Lim
 */

import fyp.stockscreener.StockScreener;
import java.util.*;
import java.util.Date;
import java.sql.*;
import java.text.*;

public class DatabaseFunction {
    DatabaseConnection dc = new DatabaseConnection();
    
        public ArrayList<String> getStockSymbolList(String Symbol)
        {
                String sqlSelectStockSymbol = "SELECT Stock_Symbol FROM `Stock`";    
                ArrayList<String> StockSymbolList = dc.sqlToGetArrayString(sqlSelectStockSymbol, "Stock_Symbol");
                return StockSymbolList;
        }
        
    public boolean insertStockDetails(String Symbol, String Code)
	{   
                String sqlPOIInsertDetails = "INSERT INTO `Stock` (`Stock_Symbol`, `Stock_Code`) VALUES (' " + Symbol + "', '" + Code + "');";
		return dc.sqlToInsertUpdateDelete(sqlPOIInsertDetails);
	}
    
    public boolean updateStockDetails(String Symbol, String Name, double Low, double High, double Prev, double Last)
        {
                String sqlPOIUpdateDetails = "UPDATE `Stock` " + "SET Stock_Name ='" + Name + "', Stock_Low ='" + Low + "', "+ "Stock_High ='" + High + "', Stock_Prev = '" + Prev + "', Stock_Last ='" + Last + "' WHERE Stock_Symbol = ' " + Symbol + "';";
                System.out.println(sqlPOIUpdateDetails);
                return dc.sqlToInsertUpdateDelete(sqlPOIUpdateDetails); 
        }
}
