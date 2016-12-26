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

import fyp.database.DatabaseConnection;
import fyp.POI.XLStoDB;
import java.util.*;
import java.util.Date;
import java.sql.*;
import java.text.*;

public class DatabaseFunction {
    DatabaseConnection dc = new DatabaseConnection();
    XLStoDB ap = new XLStoDB();
    
    public boolean insertDPS(String sql){
        float dpsvalue = ap.getDPSValue();
        int dpsyear = ap.getDPSYear();
        float dpsgrowth = ap.getDPSGrowthRate();
        String stocksymbol = ap.getStockSymbol();
        
        String sqlInsertDPS = "INSERT INTO 'dividendpershare' ('DPS_Value','Year','DPS_GrowthRate','Stock_Symbol') VALUES ('" + dpsvalue + "','" + dpsyear + "','" + dpsgrowth + "','" + stocksymbol + "');";
        return dc.sqlToInsertUpdateDelete(sqlInsertDPS);
    }
    
    public boolean insertEPS(String sql){
        float epsvalue = ap.getEPSValue();
        int epsyear = ap.getEPSYear();
        String stocksymbol = ap.getStockSymbol();
        
        String sqlInsertEPS = "INSERT INTO 'earningpershare' ('EPS_Value','Year','Stock_Symbol') VALUES ('" + epsvalue + "','" + epsyear + "','" + stocksymbol + "');";
        return dc.sqlToInsertUpdateDelete(sqlInsertEPS);
    }
    
    public boolean insertFCF(String sql){
        float fcfvalue = ap.getFCFValue();
        int fcfyear = ap.getFCFYear();
        String stocksymbol = ap.getStockSymbol();
        
        String sqlInsertFCF = "INSERT INTO 'freecashflow' ('FCF_Value','Year','Stock_Symbol') VALUES ('" + fcfvalue + "','" + fcfyear + "','" + stocksymbol + "');";
        return dc.sqlToInsertUpdateDelete(sqlInsertFCF);
    }
}
