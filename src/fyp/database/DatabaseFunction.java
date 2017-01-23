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

import fyp.stockscreener.Dashboard;
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
                ArrayList<String> StockCodeList = dc.sqlToGetArrayString(sqlSelectStockCode, "Stock_Code");
                return StockCodeList;
        }
        
        public ArrayList<Double> getEPSDetails(String Code)
        {
                String sqlSelectStockCode = "SELECT EPS_Value, EPS_Year FROM `EarningPerShare` WHERE Stock_Code='" + Code + "';";  
                ArrayList<Double> EPSDetailsList = dc.sqlToGetArrayDbl(sqlSelectStockCode, "EPS_Value");
                return EPSDetailsList;
        }
        
        public ArrayList<Double> getDPSDetails(String Code)
        {
                String sqlSelectStockCode = "SELECT DPS_Value, DPS_Year FROM `DividendPerShare` WHERE Stock_Code='" + Code + "';";      
                ArrayList<Double> DPSDetailsList = dc.sqlToGetArrayDbl(sqlSelectStockCode, "EPS_Value");
                return DPSDetailsList;
        }
        
        public double getEarning(String Code)
        {
                double result = dc.sqlToGetDbl("SELECT EPS_Value FROM earningpershare WHERE Stock_Code='" + Code + "' AND EPS_Year='2016';", "EPS_Value");
                return result;
        }
        
        public double getDividend(String Code)
        {
                double result = dc.sqlToGetDbl("SELECT DPS_Value FROM dividendpershare WHERE Stock_Code='" + Code + "' AND DPS_Year='2016';", "DPS_Value");
                return result;
        }
        
        public double getGrowth(String Code)
        {
                double result = dc.sqlToGetDbl("SELECT Stock_Growth FROM Stock WHERE Stock_Code='" + Code + "';", "Stock_Growth");
                return result;
        }
        
        public double getDividendGrowth(String Code)
        {
                double result = dc.sqlToGetDbl("SELECT DPS_GrowthRate FROM dividendpershare WHERE Stock_Code='" + Code + "' AND DPS_Year='2016';", "DPS_GrowthRate");
                return result;
        }
        
        public String getIVStockName(String Code)
        {
                String result = dc.sqlToGetString("SELECT Stock_Name FROM stock WHERE Stock_Code='" + Code + "';", "Stock_Name");
                return result;
        }
        
        public String getIVStockSymbol(String Code)
        {
                String result = dc.sqlToGetString("SELECT Stock_Name FROM stock WHERE Stock_Code='" + Code + "';", "Stock_Name");
                return result;
        }
        
    public boolean insertStockDetails(String Symbol, String Code)
	{   
                String sqlPOIInsertDetails = "INSERT INTO `Stock` (`Stock_Symbol`, `Stock_Code`) VALUES (' " + Symbol + "', '" + Code + "');";
		return dc.sqlToInsertUpdateDelete(sqlPOIInsertDetails);
	}

    public boolean insertStockEPS(double EPS, int Year, String Code )
	{   
                String sqlPOIInsertEPS = "INSERT INTO `earningpershare` (`EPS_Value`, `EPS_Year`, `Stock_Code`) VALUES (' " + EPS + "', '" + Year + "', '" + Code + "');";
		return dc.sqlToInsertUpdateDelete(sqlPOIInsertEPS);
	}
    
    public boolean insertStockDPS(double DPS, int Year, double DPS_GR, String Code)
	{   
                String sqlPOIInsertDPS = "INSERT INTO `dividendpershare` (`DPS_Value`, `DPS_Year`, `DPS_GrowthRate`, `Stock_Code`) VALUES (' " + DPS + "', '" + Year + "', '" + DPS_GR + "', '" + Code + "');";
		return dc.sqlToInsertUpdateDelete(sqlPOIInsertDPS);
	}
    
    public boolean updateStockDetails(String Symbol, String Name, double Low, double High, double Prev, double Last)
        {
                String sqlPOIUpdateDetails = "UPDATE `Stock` SET Stock_Name ='" + Name + "', Stock_Low ='" + Low + "', "+ "Stock_High ='" + High + "', Stock_Prev = '" + Prev + "', Stock_Last ='" + Last + "' WHERE Stock_Symbol = ' " + Symbol + "';";
                return dc.sqlToInsertUpdateDelete(sqlPOIUpdateDetails); 
        }
    
    public boolean updateStock5YrsGrowth(String Code, double Growth)
        {
                String sqlPOIUpdateGrowth = "UPDATE `Stock` SET Stock_Growth =" + Growth + " WHERE Stock_Code = '" + Code + "';";
                return dc.sqlToInsertUpdateDelete(sqlPOIUpdateGrowth); 
        }
    
    public boolean updateStockGrowth(String Code, double Growth)
        {
                String sqlPOIUpdateGrowth = "UPDATE `Stock` SET Stock_Growth =" + Growth + " WHERE Stock_Code = '" + Code + "';";
                return dc.sqlToInsertUpdateDelete(sqlPOIUpdateGrowth); 
        }
    
    public boolean updateStockDEM(String Code, double DEM)
        {
                String sqlPOIUpdateDEM = "UPDATE `Stock` SET Stock_DEM =" + DEM + " WHERE Stock_Code = '" + Code + "';";
                return dc.sqlToInsertUpdateDelete(sqlPOIUpdateDEM); 
        }
    
    public boolean updateStockGGM(String Code, double GGM)
        {
                String sqlPOIUpdateGGM = "UPDATE `Stock` SET Stock_GGM =" + GGM + " WHERE Stock_Code = '" + Code + "';";
                return dc.sqlToInsertUpdateDelete(sqlPOIUpdateGGM); 
        }
    
    public boolean updateStockBGF(String Code, double BGF)
        {
                String sqlPOIUpdateBGF = "UPDATE `Stock` SET Stock_BGF =" + BGF + " WHERE Stock_Code = '" + Code + "';";
                return dc.sqlToInsertUpdateDelete(sqlPOIUpdateBGF); 
        }
}
