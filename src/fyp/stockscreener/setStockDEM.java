/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fyp.stockscreener;

import fyp.database.DatabaseFunction;
import java.util.ArrayList;

/**
 *
 * @author Lim
 */
public class setStockDEM {
    
    DatabaseFunction df = new DatabaseFunction();
    
    private ArrayList<String> StkSymbolList = new ArrayList<String>() ;
    private String[] StkSymbol = new String[StkSymbolList.size()];
    
    public void setStockDEM()
    {
        DEM();
    }
    
    public void setStkSymbolList()
    {
        StkSymbolList = df.getStockSymbolList();
    }
    
    public ArrayList<String> getStkSymbolList()
    {return StkSymbolList;};

    public void DEM()
        {
            double Earnings = 0.0;
            double EPS_GrowthRate = 0.12;
            double RiskFreeRate = 0.04;
            double DiscountRate, DiscountedEarnings;
            double DEM = 0.0 ;
            double[] CumulativeEarnings = new double[11];
            
            StkSymbol = getStkSymbolList().toArray(StkSymbol);
                
            for(int i=0; i<StkSymbolList.size(); i++)
                {   
                    String StkSbl = StkSymbol[i].replaceAll(" ","");
                    
                    for(int j=1;j<11;j++){
                    Earnings *= (1+EPS_GrowthRate);
                    DiscountRate = 1/(Math.pow((1+RiskFreeRate),j));
                    DiscountedEarnings = Earnings*DiscountRate;
                    if(j==1){
                            CumulativeEarnings[j] = DiscountedEarnings;
                    }
                    else{
                            CumulativeEarnings[j] = DiscountedEarnings + CumulativeEarnings[j-1];
                    }
                    }
                    DEM = CumulativeEarnings[10];

                    df.updateStockDEM(StkSbl, DEM);
                    System.out.println(StkSbl + "Updated");
                }

            
        }
}