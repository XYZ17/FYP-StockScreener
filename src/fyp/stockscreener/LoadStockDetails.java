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
public class LoadStockDetails{
    DatabaseFunction df = new DatabaseFunction();
    POIFunction poi = new POIFunction();
    private ArrayList<String> StkCodeList = new ArrayList<String>() ;
    private String[] StkSymbol = new String[StkCodeList.size()];
    private String StkCode = "" ;
    private double StkGProfit = 0.0;
    private int GProfitYear = 0;
    private double StkRevenue = 0.0;
    private int RevenueYear = 0;
    private double StkNetIncome = 0.0;
    private int NetIncomeYear = 0;
    
    public void LoadStockDetails(){
        setStkCodeList();
        POIgetGProfit();
        POIgetRevenue();
        POIgetNetIncome();
    }
    
    public void setStkCodeList()
    {
        StkCodeList = df.getStockCodeList();
    }
    
    public ArrayList<String> getStkCodeList()
    {return StkCodeList;};
    
    public void POIgetGProfit(){
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
                            GProfitYear = 2016;
                            StkGProfit = poi.poiToGetDbl(FileAddress, alphabet + "14", 0);
                            df.insertStockGrossProfit(StkGProfit, GProfitYear, StkSbl);
                            System.out.println("GProfit for " + StkSbl + " in " + GProfitYear + " Inserted");
                            break;
                        }
                        else if("FY 2016 Est".equals(CheckYear)||"FY 2017 Est".equals(CheckYear)){
                            break;
                        }
                        else{
                           GProfitYear = Integer.parseInt(CheckYear.replace("FY ", "")); 
                            if(GProfitYear < 2011){
                            continue; }
                           StkGProfit = poi.poiToGetDbl(FileAddress, alphabet + "14", 0);
                        }
                    df.insertStockGrossProfit(StkGProfit, GProfitYear, StkSbl);
                    System.out.println("GProfit for " + StkSbl + " in " + GProfitYear + " Inserted");
                    }
            } catch (FileNotFoundException e) {
                System.out.println("Error detected: " + e);
            }
        }
    }
    
    public void POIgetRevenue(){
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
                            RevenueYear = 2016;
                            StkRevenue = poi.poiToGetDbl(FileAddress, alphabet + "12", 0);
                            df.insertStockRevenue(StkRevenue, RevenueYear, StkSbl);
                            System.out.println("Revenue for " + StkSbl + " in " + RevenueYear + " Inserted");
                            break;
                        }
                        else if("FY 2016 Est".equals(CheckYear)||"FY 2017 Est".equals(CheckYear)){
                            break;
                        }
                        else{
                           RevenueYear = Integer.parseInt(CheckYear.replace("FY ", "")); 
                            if(RevenueYear < 2011){
                            continue; }
                           StkRevenue = poi.poiToGetDbl(FileAddress, alphabet + "12", 0);
                        }
                    df.insertStockRevenue(StkRevenue, RevenueYear, StkSbl);
                    System.out.println("Revenue for " + StkSbl + " in " + RevenueYear + " Inserted");
                    }
            } catch (FileNotFoundException e) {
                System.out.println("Error detected: " + e);
            }
        }
    }
    
    public void POIgetNetIncome(){
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
                            NetIncomeYear = 2016;
                            StkNetIncome = poi.poiToGetDbl(FileAddress, alphabet + "18", 0);
                            df.insertStockNetIncome(StkNetIncome, NetIncomeYear, StkSbl);
                            System.out.println("NetIncome for " + StkSbl + " in " + NetIncomeYear + " Inserted");
                            break;
                        }
                        else if("FY 2016 Est".equals(CheckYear)||"FY 2017 Est".equals(CheckYear)){
                            break;
                        }
                        else{
                           NetIncomeYear = Integer.parseInt(CheckYear.replace("FY ", "")); 
                            if(NetIncomeYear < 2011){
                            continue; }
                           StkNetIncome = poi.poiToGetDbl(FileAddress, alphabet + "18", 0);
                        }
                    df.insertStockNetIncome(StkNetIncome, NetIncomeYear, StkSbl);
                    System.out.println("NetIncome for " + StkSbl + " in " + NetIncomeYear + " Inserted");
                    }
            } catch (FileNotFoundException e) {
                System.out.println("Error detected: " + e);
            }
        }
    }
}
