/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fyp.stockscreener;

import fyp.database.DatabaseFunction;
import fyp.POI.POIFunction;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Lim
 */
public class LoadEPS {
    DatabaseFunction df = new DatabaseFunction();
    POIFunction poi = new POIFunction();
    private ArrayList<String> StkCodeList = new ArrayList<String>() ;
    private String[] StkSymbol = new String[StkCodeList.size()];
    private String StkCode = "" ;
    private double StkEPS = 0.0;
    private int EPSYear = 0;
    private int year = Calendar.getInstance().get(Calendar.YEAR);
    
    public void LoadEPS(){
        setStkCodeList();
        POIgetEPS();
    }
    
    private void setStkCodeList()
    {
        StkCodeList = df.getStockCodeList();
    }
    
    private ArrayList<String> getStkCodeList()
    {return StkCodeList;};
    
    public void POIgetEPS(){
        StkSymbol = getStkCodeList().toArray(StkSymbol);
        for(int i=0; i<StkCodeList.size(); i++)  //i<StkCodeList.size()
        {   
            String StkSbl = StkSymbol[i].replaceAll(" ","");
            String FileAddress = ("C:/Users/xyi17/Desktop/B.C.S/FYP/FYP-StockScreener/files/FA/FA_"+ StkSbl + ".xlsx");
            try {
                    for(char alphabet = 'C'; alphabet <= 'Z'; alphabet++){
                    String CheckYear = poi.poiToGetString(FileAddress, alphabet + "4", 0);
                        if("Current/LTM".equals(CheckYear)||"Current".equals(CheckYear))
                        {
                            EPSYear = 2016;
                            StkEPS = poi.poiToGetDbl(FileAddress, alphabet + "20", 0);
                            df.insertStockEPS(StkEPS, EPSYear, StkSbl);
                            System.out.println("EPS for " + StkSbl + " in " + EPSYear + " Inserted");
                            break;
                        }
                        else if("FY 2016 Est".equals(CheckYear)||"FY 2017 Est".equals(CheckYear)){
                            break;
                        }
                        else{
                           EPSYear = Integer.parseInt(CheckYear.replace("FY ", "")); 
                            if(EPSYear < 2011){
                            continue; }
                           StkEPS = poi.poiToGetDbl(FileAddress, alphabet + "20", 0);
                        }
                    df.insertStockEPS(StkEPS, EPSYear, StkSbl);
                    System.out.println("EPS for " + StkSbl + " in " + EPSYear + " Inserted");
                    }
            } catch (FileNotFoundException e) {
                System.out.println("Error detected: " + e);
            }
        }
    }
}
