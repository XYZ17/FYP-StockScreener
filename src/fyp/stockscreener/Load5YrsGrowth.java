/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fyp.stockscreener;

import fyp.POI.POIFunction;
import fyp.database.DatabaseFunction;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Lim
 */
public class Load5YrsGrowth {
    DatabaseFunction df = new DatabaseFunction();
    POIFunction poi = new POIFunction();
    private ArrayList<String> StkCodeList = new ArrayList<String>() ;
    private String[] StkSymbol = new String[StkCodeList.size()];
    private String StkCode = "" ;
    private String CheckRow = "";
    private String GrowthRow = "";
    private double StkGrowth = 0.0;
    private int year = Calendar.getInstance().get(Calendar.YEAR);
    
    public void Load5YrsGrowth(){
        setStkCodeList();
        POIgetGrowth();
    }
    
    public void setStkCodeList()
    {
        StkCodeList = df.getStockCodeList();
    }
    
    public ArrayList<String> getStkCodeList()
    {return StkCodeList;};
    
    public void POIgetGrowth(){
        StkSymbol = getStkCodeList().toArray(StkSymbol);
        for(int i=0; i<StkCodeList.size(); i++)  //i<StkCodeList.size()
        {   
            String StkSbl = StkSymbol[i].replaceAll(" ","");
            String FileAddress = ("C:/Users/xyi17/Desktop/B.C.S/FYP/FYP-StockScreener/files/FA/FA_"+ StkSbl + ".xlsx");
            try {
                System.out.println(StkSbl);
                int j = 25;
                do{
                    j++;
                        String tempRow = Integer.toString(j);
                        CheckRow = poi.poiToGetString(FileAddress, "A"+tempRow, 2); 
                            if("Net Income to Common".equals(CheckRow))
                            {
                                GrowthRow = tempRow;
                                for(char alphabet = 'C'; alphabet <= 'Z'; alphabet++)
                                {
                                    String CheckYear = poi.poiToGetString(FileAddress, alphabet + "4", 2);
                                        if("FY 2015".equals(CheckYear))
                                        {
                                            StkGrowth = poi.poiToGetDbl(FileAddress, alphabet + GrowthRow, 2);
                                            df.updateStockGrowth(StkSbl,StkGrowth);
                                            System.out.println("5Yrs Growth for " + StkSbl + " Inserted");
                                        }
                                        else if("FY 2016".equals(CheckYear))
                                        {
                                            StkGrowth = poi.poiToGetDbl(FileAddress, alphabet + GrowthRow, 2);
                                            df.updateStockGrowth(StkSbl,StkGrowth);
                                            System.out.println("5Yrs Growth for " + StkSbl + " Re-inserted");
                                            break;
                                        }
                                        else
                                        {
                                            continue;
                                        }
                                }
                            }
                            else if("Sequential Growth".equals(CheckRow))
                            {
                                break;
                            }
                            else
                            {}
                    }while(CheckRow != "Net Income to Common"); 
                }catch (FileNotFoundException e) {
                System.out.println("Error detected: " + e);
                }   
        }
    }
}
