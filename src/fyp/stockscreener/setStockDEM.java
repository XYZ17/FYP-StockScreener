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
    
    private ArrayList<String> StkCodeList = new ArrayList<String>() ;
    private String[] StkSymbol = new String[StkCodeList.size()];
    
    public void setStockDEM()
    {
        setStkCodeList();
        DEM();
    }
    
    public void setStkCodeList()
    {
        StkCodeList = df.getStockCodeList();
    }
    
    public ArrayList<String> getStkCodeList()
    {return StkCodeList;};

    public void DEM()
        {
            double Earnings = 0.0;
            double EPS_GrowthRate = 0.12;
            double RiskFreeRate = 0.04;
            double DiscountRate, DiscountedEarnings;
            double DEM = 0.0 ;
            double[] CumulativeEarnings = new double[11];
            
            StkSymbol = getStkCodeList().toArray(StkSymbol);
                
            for(int i=0; i<StkCodeList.size(); i++)
                {   
                    String StkCd = StkSymbol[i].replaceAll(" ","");
                    Earnings = df.getEarning(StkCd);
                    
                    for(int j=1;j<11;j++){
                    if(j==1){
			Earnings = Earnings;
                    }
                    else{
                            Earnings *= (1+EPS_GrowthRate);
                    }
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

                    df.updateStockDEM(StkCd, DEM);
                    System.out.println(StkCd + " Updated");
                }

            
        }
}