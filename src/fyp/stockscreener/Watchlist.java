/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fyp.stockscreener;

import fyp.database.DatabaseFunction;
import fyp.POI.POIFunction;
import fyp.yahooapi.StockDetailsAPI;
import fyp.yahooapi.StockFetcherAPI;
import fyp.yahooapi.StockLoadAPI;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lim
 */
public class Watchlist {
    DatabaseFunction df = new DatabaseFunction();
    POIFunction poi = new POIFunction();
    StockLoadAPI api = new StockLoadAPI();
    
    private ArrayList<String> StkSymbolList = new ArrayList<String>() ;
    private String[] StkSymbol = new String[StkSymbolList.size()];
    private String StkCode = null ;
    private String StkName = null ;
    private double StkLow = 0 ;
    private double StkHigh = 0 ;
    private double StkPrev = 0 ;
    private double StkLast = 0 ;
    private double StkGrowth = 0 ;
    
    public void Watchlist(){
        
        setStkSymbolList();
        setStkDetails();
        /*
        String FileAddress = ("C:/Users/xyi17/Desktop/B.C.S/FYP/FYP-StockScreener/files/Stocklist.xlsx");
        for(int i=1; i<=200; i++){
            try {
                StockSymbol =poi.poiToGetString(FileAddress, "A"+i, 0);
                StockCode = poi.poiToGetString(FileAddress, "B"+i, 0);
                df.insertStockDetails(StockSymbol, StockCode);
                System.out.println(StockSymbol + "&" + StockCode + "Inserted");
            } catch (FileNotFoundException e) {
                System.out.println("Error detected: " + e);
            }
        }
        */
    }
    
    public void setStkSymbolList()
    {
        StkSymbolList = df.getStockSymbolList();
    }
    
    public ArrayList<String> getStkSymbolList()
    {return StkSymbolList;};
   
    public void setStkDetails()
    {
        StkSymbol = getStkSymbolList().toArray(StkSymbol);
        for(int i=0; i<StkSymbolList.size(); i++)
        {   
            String StkSbl = StkSymbol[i].replaceAll(" ","");
            StkName = api.getStockName(StkSbl);
            StkLow = api.getStockLow(StkSbl);
            StkHigh = api.getStockHigh(StkSbl);
            StkPrev = api.getStockPrev(StkSbl);
            StkLast = api.getStockLast(StkSbl);

            df.updateStockDetails(StkSbl, StkName, StkLow, StkHigh, StkPrev, StkLast);
            System.out.println(StkSbl + " Updated");
        }      
    }
    
    
}
