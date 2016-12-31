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
    
        public ArrayList<String> getStockSymbolList()
        {
                String sqlSelectStockSymbol = "SELECT Stock_Symbol FROM `Stock`";    
                ArrayList<String> StockSymbolList = dc.sqlToGetArrayString(sqlSelectStockSymbol, "Stock_Symbol");
                return StockSymbolList;
        }
        
        public ArrayList<String> getStockCodeList()
        {
                String sqlSelectStockCode = "SELECT Stock_Code FROM `Stock`";    
                ArrayList<String> StockSymbolList = dc.sqlToGetArrayString(sqlSelectStockCode, "Stock_Code");
                return StockSymbolList;
        }
        
        public double getEPS(String Symbol)
        {
                double result = dc.sqlToGetDbl("SELECT EPS_Value FROM earningpershare WHERE Stock_Symbol='" + Symbol+"' AND Year='2016';", "EPS_Value");
                return result;
        }
        
        
    public boolean insertStockDetails(String Symbol, String Code)
	{   
                String sqlPOIInsertDetails = "INSERT INTO `Stock` (`Stock_Symbol`, `Stock_Code`) VALUES (' " + Symbol + "', '" + Code + "');";
		return dc.sqlToInsertUpdateDelete(sqlPOIInsertDetails);
	}
    
    public boolean updateStockDetails(String Symbol, String Name, double Low, double High, double Prev, double Last)
        {
                String sqlPOIUpdateDetails = "UPDATE `Stock` " + "SET Stock_Name ='" + Name + "', Stock_Low ='" + Low + "', "+ "Stock_High ='" + High + "', Stock_Prev = '" + Prev + "', Stock_Last ='" + Last + "' WHERE Stock_Symbol = ' " + Symbol + "';";
                return dc.sqlToInsertUpdateDelete(sqlPOIUpdateDetails); 
        }
    
    public boolean updateStockDEM(String Symbol, double DEM)
        {
                String sqlPOIUpdateDEM = "UPDATE `Stock` " + "SET Stock_DEM ='" + DEM + "' WHERE Stock_Symbol = ' " + Symbol + "';";
                return dc.sqlToInsertUpdateDelete(sqlPOIUpdateDEM); 
        }
    
    public boolean insertStockEPS(double EPS, int Year, String Symbol )
	{   
                String sqlPOIInsertEPS = "INSERT INTO `earningpershare` (`EPS_Value`, `Year`, `Stock_Symbol`) VALUES (' " + EPS + "', '" + Year + "', '" + Symbol + "');";
		return dc.sqlToInsertUpdateDelete(sqlPOIInsertEPS);
	}
    
    public boolean insertStockFCF(double FCF, int Year, String Symbol)
	{   
                String sqlPOIInsertFCF = "INSERT INTO `freecashflow` (`FCF_Value`, `Year`, `Stock_Symbol`) VALUES (' " + FCF + "', '" + Year + "', '" + Symbol + "');";
		return dc.sqlToInsertUpdateDelete(sqlPOIInsertFCF);
	}
    
    public boolean insertStockDPS(double DPS, int Year, double DPS_GR, String Symbol)
	{   
                String sqlPOIInsertDPS = "INSERT INTO `dividendpershare` (`DPS_Value`, `Year`, `DPS_GrowthRate`, `Stock_Symbol`) VALUES (' " + DPS + "', '" + Year + "', '" + DPS_GR + "', '" + Symbol + "');";
		return dc.sqlToInsertUpdateDelete(sqlPOIInsertDPS);
	}
}
