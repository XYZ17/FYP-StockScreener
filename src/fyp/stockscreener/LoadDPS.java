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
public class LoadDPS {
    DatabaseFunction df = new DatabaseFunction();
    POIFunction poi = new POIFunction();
    private ArrayList<String> StkCodeList = new ArrayList<String>() ;
    private String[] StkSymbol = new String[StkCodeList.size()];
    private String StkCode = "" ;
    private String checkGrowth = "";
    private double StkDPS = 0.0;
    private double StkDPS_GR = 0.0;
    private int DPSYear = 0;
    private int year = Calendar.getInstance().get(Calendar.YEAR);
    
    public void LoadDPS(){
        setStkCodeList();
        POIgetDPS();
    }
    
    public void setStkCodeList()
    {
        StkCodeList = df.getStockCodeList();
    }
    
    public ArrayList<String> getStkCodeList()
    {return StkCodeList;};
    
    public void POIgetDPS(){
        StkSymbol = getStkCodeList().toArray(StkSymbol);
        for(int i=0; i<StkCodeList.size(); i++)  //i<StkCodeList.size()
        {   
            String StkSbl = StkSymbol[i].replaceAll(" ","");
            String FileAddress = ("C:/Users/xyi17/Desktop/B.C.S/FYP/FYP-StockScreener/files/FA/FA_"+ StkSbl + ".xlsx");
            try {
                for(char alphabet = 'C'; alphabet <= 'Z'; alphabet++){
                    String CheckYear = poi.poiToGetString(FileAddress, alphabet + "4",1);
                        if("Last 12M".equals(CheckYear))
                        {
                            DPSYear = 2016;
                            StkDPS = poi.poiToGetDbl(FileAddress, alphabet + "32",1);
                            checkGrowth = poi.poiToGetString(FileAddress, "A33",1);
                            if( !"    Growth (YoY)".equals(checkGrowth)){
                                StkDPS_GR = 0.0;
                            }
                            else{
                                StkDPS_GR = poi.poiToGetDbl(FileAddress, alphabet + "33",1);
                            }
                            df.insertStockDPS(StkDPS, DPSYear,StkDPS_GR, StkSbl);
                            System.out.println("DPS for " + StkSbl + " in " + DPSYear + " Inserted");
                            break;
                        }
                        else if("FY 2016 Est".equals(CheckYear)||"FY 2017 Est".equals(CheckYear)){
                            break;
                        }
                        else{
                           DPSYear = Integer.parseInt(CheckYear.replace("FY ", ""));
                            if(DPSYear < 2011){
                            continue; }
                           StkDPS = poi.poiToGetDbl(FileAddress, alphabet + "32", 1);
                           checkGrowth = poi.poiToGetString(FileAddress, "A33", 1);
                            if( !"    Growth (YoY)".equals(checkGrowth)){
                                StkDPS_GR = 0.0;
                            }
                            else{
                                StkDPS_GR = poi.poiToGetDbl(FileAddress, alphabet + "33", 1);
                            }
                        }

                    df.insertStockDPS(StkDPS, DPSYear,StkDPS_GR, StkSbl);
                    System.out.println("DPS for " + StkSbl + " in " + DPSYear + " Inserted");
                }
            } catch (FileNotFoundException e) {
                System.out.println("Error detected: " + e);
            }
        }
    }
}
